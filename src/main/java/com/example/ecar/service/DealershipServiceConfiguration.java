package com.example.ecar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.ecar.model.Car;
import com.example.ecar.model.Credentials;
import com.example.ecar.model.Dealership;

@Configuration
public class DealershipServiceConfiguration implements CommandLineRunner {

	@Autowired
	DealershipService dService;

	@Override
	public void run(String... args) throws Exception {

		Dealership d1 = new Dealership(123456781, "Toyta-Κατικαρίδης", "Κώστας Κατικαρίδης");
		Dealership d2 = new Dealership(987654123, "Citroen-Ασπρόπουλος", "Ιορδάνης Ασπρόπουλος");
		Dealership d3 = new Dealership(456789123, "Volksvagen-Πετρακάκης", "Γιάννης Πετρακάκης");
		Dealership d4 = new Dealership(789123456, "Audi-Παπαδόπουλος", "Πέτρος Παπαδόπουλος");

		Credentials creds3 = new Credentials("toyota", "123", 2);
		Credentials creds4 = new Credentials("citro", "123", 2);
		Credentials creds5 = new Credentials("vw", "123", 2);
		Credentials creds6 = new Credentials("audi", "123", 2);

		d1.setCredentials(creds3);
		d2.setCredentials(creds4);
		d3.setCredentials(creds5);
		d4.setCredentials(creds6);

		dService.addDealership(d1);
		dService.addDealership(d2);
		dService.addDealership(d3);
		dService.addDealership(d4);

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
		Car car10 = new Car(" Citroen", "C1", "Υβριδικό Βενζίνη", 800, 3, 14000, "Δώρο 10 service αντιπροσωπείας", 6);
		car10.setDealership(d2);
		Car car11 = new Car("Citroen", "C2", "Πετρέλαιο", 1200, 3, 15000, "FullExtra", 5);
		car11.setDealership(d2);
		Car car12 = new Car("Citroen", "C3", "Βενζίνη", 1400, 5, 18000, "FullExtra", 1);
		car12.setDealership(d2);

		d1.addCar(car4);
		d1.addCar(car5);
		d1.addCar(car6);
		d3.addCar(car1);
		d3.addCar(car2);
		d3.addCar(car3);
		d4.addCar(car7);
		d4.addCar(car8);
		d4.addCar(car9);
		d3.addCar(car10);
		d3.addCar(car11);
		d3.addCar(car12);

		dService.addCar(car1);
		dService.addCar(car2);
		dService.addCar(car3);
		dService.addCar(car4);
		dService.addCar(car5);
		dService.addCar(car6);
		dService.addCar(car7);
		dService.addCar(car8);
		dService.addCar(car9);
		dService.addCar(car10);
		dService.addCar(car11);
		dService.addCar(car12);

	}

}
