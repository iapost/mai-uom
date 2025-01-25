package com.example.ecar.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddCarRequestDto {
	@NotBlank(message="Η μάρκα είναι υποχρεωτική")
	public String brand;
	@NotBlank(message="Το μοντέλο είναι υποχρεωτικό")
	public String model;
	@NotBlank(message="Το είδος καυσίμου είναι υποχρεωτικό")
	public String fuel;
	@Min(value=500, message="Τα cc μηχανής είναι υποχρεωτικά")
	@Max(value=10000, message="Τα cc μηχανής είναι υποχρεωτικά")
	public int engine;
	@Min(value=1, message="Ο αριθμός θέσεων είναι υποχρεωτικός")
	@Max(value=50, message="Ο αριθμός θέσεων είναι υποχρεωτικός")
	public int seats;
	@Min(value=1, message="Η τιμή είναι υποχρεωτική")
	@Max(value=10000000, message="Η τιμή είναι υποχρεωτική")
	public double price;
	public String info;
	@Min(value=1, message="Ο αριθμός διαθεσιμότητας είναι υποχρεωτικός")
	@Max(value=20000, message="Ο αριθμός διαθεσιμότητας είναι υποχρεωτικός")
	public int amount;
}
