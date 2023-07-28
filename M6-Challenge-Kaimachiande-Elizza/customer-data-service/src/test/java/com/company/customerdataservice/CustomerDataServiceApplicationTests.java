package com.company.customerdataservice;

import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CustomerDataServiceApplicationTests {
	@Autowired
	CustomerRepository customerRepository;

	@BeforeEach
	public void setUp() throws Exception {
		customerRepository.deleteAll();
	}

	@Test
	public void shouldAddCustomer() {
		//organize
		Customer customer = new Customer();
		customer.setFirstName("Elza");
		customer.setLastName("Kai");
		customer.setAddress1("123 Juniper Rd");
		customer.setAddress2("Jonestown-B2");
		customer.setEmail("elza@gmail.com");
		customer.setCompany("Zara");
		customer.setPhone("404-781-8888");
		customer.setPostalCode("3354");
		customer.setCity("Jonestowns");
		customer.setState("GA");
		customer.setCountry("USA");



		//act
		customer = customerRepository.save(customer);
		Optional<Customer> customer1 = customerRepository.findById(customer.getId());

		//assert
		assertEquals(customer1.get(), customer);
	}


	@Test
	public void shouldUpdateCustomer() {
		//arrange
		Customer customer = new Customer();
		customer.setFirstName("Elza");
		customer.setLastName("Kai");
		customer.setAddress1("123 Juniper Rd");
		customer.setAddress2("Jonestown-B2");
		customer.setEmail("elza@gmail.com");
		customer.setCompany("Zara");
		customer.setPhone("404-781-8888");
		customer.setPostalCode("3354");
		customer.setCity("Jonestowns");
		customer.setState("GA");
		customer.setCountry("USA");

		customer = customerRepository.save(customer);

		customer.setFirstName("Elmo");
		customer.setLastName("Iye");
		customer.setAddress1("123 Nu-niper Rd");
		customer.setAddress2("Donestown-B2");
		customer.setEmail("a@gmail.com");
		customer.setCompany("Daras");
		customer.setPhone("678-781-8888");
		customer.setPostalCode("3324");
		customer.setCity("Storyville");
		customer.setState("MA");
		customer.setCountry("USA");

		customer = customerRepository.save(customer);

		//act
		Optional<Customer> customer1 = customerRepository.findById(customer.getId());

		//assert
		assertEquals(customer1.get(), customer);
	}

	@Test
	public void shouldGetCustomerById() {
		//arrange
		Customer customer = new Customer();
		customer.setFirstName("Elza");
		customer.setLastName("Kai");
		customer.setAddress1("123 Juniper Rd");
		customer.setAddress2("Jonestown-B2");
		customer.setEmail("elza@gmail.com");
		customer.setCompany("Zara");
		customer.setPhone("404-781-8888");
		customer.setPostalCode("3354");
		customer.setCity("Jonestowns");
		customer.setState("GA");
		customer.setCountry("USA");
		customer = customerRepository.save(customer);

		Customer customer2 = new Customer();
		customer2.setFirstName("Elmo");
		customer2.setLastName("Iye");
		customer2.setAddress1("123 Nu-niper Rd");
		customer2.setAddress2("Donestown-B2");
		customer2.setEmail("a@gmail.com");
		customer2.setCompany("Daras");
		customer2.setPhone("678-781-8888");
		customer2.setPostalCode("3324");
		customer2.setCity("Storyville");
		customer2.setState("MA");
		customer2.setCountry("USA");
		customer2 = customerRepository.save(customer2);

		Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());
		assertEquals(foundCustomer.get(), customer);
	}

	@Test
	public void shouldGetCustomerbyState() {
		Customer customer = new Customer();
		customer.setFirstName("Elza");
		customer.setLastName("Kai");
		customer.setAddress1("123 Juniper Rd");
		customer.setAddress2("Jonestown-B2");
		customer.setEmail("elza@gmail.com");
		customer.setCompany("Zara");
		customer.setPhone("404-781-8888");
		customer.setPostalCode("3354");
		customer.setCity("Jonestowns");
		customer.setState("GA");
		customer.setCountry("USA");
		customer = customerRepository.save(customer);

		customer = new Customer();
		customer.setFirstName("Elmo");
		customer.setLastName("Iye");
		customer.setAddress1("123 Nu-niper Rd");
		customer.setAddress2("Donestown-B2");
		customer.setEmail("a@gmail.com");
		customer.setCompany("Daras");
		customer.setPhone("678-781-8888");
		customer.setPostalCode("3324");
		customer.setCity("Storyville");
		customer.setState("MA");
		customer.setCountry("USA");
		customer = customerRepository.save(customer);

		List<Customer> aList = customerRepository.findByState("GA");
		assertEquals(aList.size(),1);

	}

	@Test
	public void shouldDeleteCustomerById() {
		//arrange
		Customer customer = new Customer();
		customer.setFirstName("Elza");
		customer.setLastName("Kai");
		customer.setAddress1("123 Juniper Rd");
		customer.setAddress2("Jonestown-B2");
		customer.setEmail("elza@gmail.com");
		customer.setCompany("Zara");
		customer.setPhone("404-781-8888");
		customer.setPostalCode("3354");
		customer.setCity("Jonestowns");
		customer.setState("GA");
		customer.setCountry("USA");

		customer = customerRepository.save(customer);
		Optional<Customer> customer1 = customerRepository.findById(customer.getId());
		assertEquals(customer1.get(), customer);

		customerRepository.deleteById(customer.getId());
		customer1 = customerRepository.findById(customer.getId());
		assertFalse(customer1.isPresent());

	}


	@Test
	void contextLoads() {
	}

}
