package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.payroll.enums.Status;
import com.example.payroll.model.Employee;
import com.example.payroll.model.Order;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.OrderRepository;


@Configuration
public class LoadDatabase {
	
	public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
		return args -> {
			employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
			employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));
			employeeRepository.save(new Employee("Steve", "Jobs", "CEO"));
			
			employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
			
			orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
			orderRepository.save(new Order("iPad", Status.IN_PROGRESS));
			
			orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
		};
	}

}
