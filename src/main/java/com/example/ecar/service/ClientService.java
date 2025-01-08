package com.example.ecar.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.exception.AuthFailureException;
import com.example.ecar.exception.BadRequestException;
import com.example.ecar.exception.NotFoundException;
import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.model.Reservation;
import com.example.ecar.repository.CarRepository;
import com.example.ecar.repository.ClientRepository;
import com.example.ecar.repository.ReservationRepository;

@Service
public class ClientService {
	private static final int MAX_TIME_SLOTS_PER_DAY = 16;
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private ReservationRepository reservationRepo;

	public List<Car> getCars() {
		return carRepo.findAll();
	}

	public Client getClientByToken(String token) {
		List<Client> clientList = clientRepo.findByToken(token);
		if (clientList.size() != 1) {
			throw new AuthFailureException();
		}
		return clientList.get(0);
	}

	public List<Car> searchCars(String brand, String model, String fuel, Integer seats, Double fromPrice,
			Double toPrice, Integer fromEngine, Integer toEngine) {
		return carRepo.search(brand, model, fuel, seats, fromPrice, toPrice, fromEngine, toEngine);
	}

	public void buyCar(String token, int id) {
		getClientByToken(token);
		if (carRepo.buyCar(id) != 1) {
			throw new BadRequestException("Could not complete transaction");
		}
	}

	public Set<Integer> getAvailableTimeSlotsForDay(String token, int carId, String day) {
		getClientByToken(token);
		Car car = carRepo.findById(carId).orElseThrow(NotFoundException::new);
		List<Integer> bookedSlots = reservationRepo.findSlotsByDate(car, parseDate(day));
		HashSet<Integer> availableSlots = new HashSet<Integer>();
		for (int i = 0; i < MAX_TIME_SLOTS_PER_DAY; i++) {
			availableSlots.add(i);
		}
		availableSlots.removeAll(bookedSlots);
		return availableSlots;
	}

	public synchronized void reserveCar(String token, int carId, String day, int timeslot) {
		Client tester = getClientByToken(token);
		Car car = carRepo.findById(carId).orElseThrow(NotFoundException::new);
		Date date = parseDate(day);
		if (timeslot >= MAX_TIME_SLOTS_PER_DAY || timeslot < 0) {
			throw new BadRequestException("Timeslot can only take values from 0 to " + (MAX_TIME_SLOTS_PER_DAY - 1));
		}
		if (!reservationRepo.findByCarAndTime(car, date, timeslot).isEmpty()) {
			throw new BadRequestException("Selected time slot is not available for this car");
		}
		reservationRepo.save(new Reservation(tester, date, timeslot, car));
	}
	
	private Date parseDate(String source) {
		try {
			return DATE_FORMATTER.parse(source);
		} catch (ParseException e) {
			throw new BadRequestException("Invalid date: " + source);
		}
	}

}
