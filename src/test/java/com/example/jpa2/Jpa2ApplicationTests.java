package com.example.jpa2;

import com.example.jpa2.entity.CreditCard;
import com.example.jpa2.repositories.EmployeeRepository;
import com.example.jpa2.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class Jpa2ApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	PaymentRepository paymentRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testEmployeHavingSalaryGreaterThanAvgSal(){
		List<Object[]> empData = repository.finadAllEmployee();
		for(Object[] obj: empData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	@Test
	//@Rollback(value = true)
	public void testUpdateSalaryOfEmployeeLessThanAvg(){
		double salary = 6800;
		repository.updateSalaryOfEmployeeLessThanAvg(salary);
	}

	@Test
	@Transactional
	public void testDeleteEmployeeSalary(){
		repository.deleteEmployeeSalary();
	}
	@Test
	public void testgetAllEmployeeWhoesNameEndsWith(){
		List<Object[]> empData = repository.getAllEmployeeWhoesNameEndsWith();
		for(Object[] obj: empData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testdeleteEmployeeHaingAgeGreaterThan(){
		repository.deleteEmployeeHaingAgeGreaterThan(45);
	}

	//payment tests for single_table
	@Test
	public void createPayment(){
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(5000);
		cc.setCreditCard("555147963");
		paymentRepository.save(cc);
	}

}
