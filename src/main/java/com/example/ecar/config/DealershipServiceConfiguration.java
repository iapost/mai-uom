package com.example.ecar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.ecar.model.Car;
import com.example.ecar.model.Dealership;
import com.example.ecar.repository.CarRepository;
import com.example.ecar.repository.DealershipRepository;

@Configuration
public class DealershipServiceConfiguration implements CommandLineRunner {

	@Autowired
	DealershipRepository dRepo;

	@Autowired
	CarRepository cRepo;

	@Override
	public void run(String... args) throws Exception {

		Dealership d1 = new Dealership(123456781, "123", "Toyta-Κατικαρίδης", "Κώστας Κατικαρίδης");
		Dealership d2 = new Dealership(987654123, "123", "Citroen-Ασπρόπουλος", "Ιορδάνης Ασπρόπουλος");
		Dealership d3 = new Dealership(456789123, "123", "Volksvagen-Πετρακάκης", "Γιάννης Πετρακάκης");
		Dealership d4 = new Dealership(789123456, "123", "Audi-Παπαδόπουλος", "Πέτρος Παπαδόπουλος");
		dRepo.save(d1);
		dRepo.save(d2);
		dRepo.save(d3);
		dRepo.save(d4);

		Car car1 = new Car("Volkswagen", "Golf", "Πετρέλαιο", 1400, 5, 18000, "Έκδοση GTI", 3);
		car1.setDealership(d3);
		Car car2 = new Car("Volkswagen", "Polo", "Πετρέλαιο", 1400, 5, 16000, "Έκδοση TDI", 2);
		car2.setDealership(d3);
		Car car3 = new Car("Volkswagen", "Passat", "Βενζίνη", 1600, 5, 25000, "Full Extra", 5);
		car3.setDealership(d3);
		Car car4 = new Car("Toyota", "Auris", "Υβδριδικό Βενζίνη", 1200, 5, 20000, "5 χρόνια εγγύηση", 2);
		car4.setDealership(d1);
		Car car5 = new Car("Toyota", "Hilux", "Βενζίνη", 2400, 5, 55000, "7 χρόνια εγγύηση", 2);
		car5.setDealership(d1);
		Car car6 = new Car("Toyota", "Yaris", "Βενζίνη", 1000, 5, 16500, "3 χρόνια εγγύηση", 6);
		car6.setDealership(d1);
		Car car7 = new Car("Audi", "A4", "Βενζίνη", 1600, 5, 27000, "FullExtra", 4);
		car7.setDealership(d4);
		Car car8 = new Car("Audi", "A5", "Βενζίνη", 1800, 5, 32000, "Δώρο ζάντες επιλογής σας", 3);
		car8.setDealership(d4);
		Car car9 = new Car("Audi", "A6", "Βενζίνη", 2000, 5, 35000, "Εγγύηση 6 χρόνια", 4);
		car9.setDealership(d4);
		Car car10 = new Car("Citroen", "C1", "Υβριδικό Βενζίνη", 800, 3, 14000, "Δώρο 10 service αντιπροσωπείας", 6);
		car10.setDealership(d2);
		Car car11 = new Car("Citroen", "C2", "Πετρέλαιο", 1200, 3, 15000, "FullExtra", 5);
		car11.setDealership(d2);
		Car car12 = new Car("Citroen", "C3", "Βενζίνη", 1400, 5, 18000, "FullExtra", 1);
		car12.setDealership(d2);

		cRepo.save(car1);
		cRepo.save(car2);
		cRepo.save(car3);
		cRepo.save(car4);
		cRepo.save(car5);
		cRepo.save(car6);
		cRepo.save(car7);
		cRepo.save(car8);
		cRepo.save(car9);
		cRepo.save(car10);
		cRepo.save(car11);
		cRepo.save(car12);

	}

}
