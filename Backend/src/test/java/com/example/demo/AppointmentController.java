package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.appoinment;
import com.example.demo.repository.appoinmentRepo;
@SpringBootTest
public class AppointmentController {

	@Autowired
	appoinmentRepo appoinmentRepo;
	
	@Test
	public void testAppointmentSave() {
		appoinment appoinment = new appoinment();
		appoinment.setId(2L);
		appoinment.setC_name("Test Consultant");
		appoinment.setU_name("Test User");
		appoinment.setBook_date("20/08/2023");
		appoinment.setTime("7.00");
		appoinment.setContact("0775412455");
		appoinmentRepo.save(appoinment);
		assertNotNull(appoinmentRepo.findById(2L).get());
	}
	
	@Test
	public void testReadAllAppointment() {
		List<appoinment> list1 = appoinmentRepo.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}
	
	@Test
	public void testDeleteAppointment() {
		appoinmentRepo.deleteById(1L);
		assertThat(appoinmentRepo.existsById(1L)).isFalse();
	}
	
	
}
