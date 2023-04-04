package com.example.loginadmin;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.loginadmin.models.AuthenticationRequest;
import com.example.loginadmin.models.Employee;
import com.example.loginadmin.models.Manager;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

@SpringBootTest
class LoginAdminApplicationTests {
	@Test
	@Order(1)
	void LoginTest() {
		AuthenticationRequest authCheck = new AuthenticationRequest();
		authCheck.setUsername("Admin");
		authCheck.setPassword("Admin");

		given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(authCheck)
		.when()
		.post("http://localhost:8080/authenticate")
		.then()
		.assertThat().statusCode(200);

	}
	@Test
	@Order(2)
	void  saveEmployee() {
		Employee e= new Employee();
		e.setFirstName("abnm");
		e.setLastName("rdtyfh");
		e.setAddress("H.no-23");
		e.setCity("Bns");
		e.setCountry("India");
		
		e.setEmailId("ab@gmail.com");
		e.setEmployeeId("909");
		e.setGender("female");
		e.setMemailId("aravind@gmail.com");
		e.setMobileNumber("898912334");
		e.setPassword("Emp@2023");
		e.setPinCode(50423L);
		e.setRole("Developer");
		e.setState("TS");


		given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(e)
		.when()
		.post("http://localhost:8080/admin/employee/addemployee")
		.then()
		.assertThat().statusCode(201);

	}

	@Test
	@Order(3)
	void getALLEmployee() {


		given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)

		.when()
		.get("http://localhost:8080/admin/employee/getemployees")
		.then()
		.assertThat().statusCode(200);

	}
	@Test
	@Order(4)
	void getAllManagers() {
		given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)

		.when()
		.get("http://localhost:8080/admin/manager/getmanagers")
		.then()
		.assertThat().statusCode(200);
	}
	@Test
	@Order(5)
	void getManagerByEmailId() {

		given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)

		.when()
		.get("http://localhost:8080/admin/manager/madhavi@gmail.com")
		.then()
		.assertThat().statusCode(200);

	}
	
		
		@Test
		@Order(6)
		void saveManager() {
			Manager e1=new Manager();
			e1.setAddress("H.no:22/22");
			e1.setCity("Hyd");
			e1.setCountry("India");
			e1.setEmailId("anm@gmail.com");
			e1.setFirstName("ammuis");
			e1.setLastName("hello");
			e1.setManagerId("23");
			e1.setPassword("Manger@2023");
			e1.setRole("Devloper");
	
			given().header("Content_Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(e1)
			.when()
			.post("http://localhost:8080/admin/manager/addmanager")
			.then()
			.assertThat().statusCode(201);
	
	
	
		}





}
