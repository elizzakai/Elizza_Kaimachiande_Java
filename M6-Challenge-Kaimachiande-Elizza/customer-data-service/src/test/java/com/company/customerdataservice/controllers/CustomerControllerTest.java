package com.company.customerdataservice.controllers;
import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa


    private ObjectMapper mapper = new ObjectMapper();
    // A list of customers for testing purposes

    @BeforeEach
    public void setUp() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("lza");
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        Customer customerout = new Customer();
        customerout.setFirstName("Elza");
        customerout.setLastName("Kai");
        customerout.setAddress1("123 Juniper Rd");
        customerout.setAddress2("Jonestown-B2");
        customerout.setEmail("elza@gmail.com");
        customerout.setCompany("Zara");
        customerout.setPhone("404-781-8888");
        customerout.setPostalCode("3354");
        customerout.setCity("Jonestowns");
        customerout.setState("GA");
        customerout.setCountry("USA");

        String outputJson = mapper.writeValueAsString(customerout);

    }


    private List<Customer> customerList;
    @Test
    public void shouldReturnAllCustomersInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(customerList);

        // ACT
        mockMvc.perform(get("/customers"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }


    @Test
    public void shouldReturnCustomerbyId() throws Exception {
        String outputJson = mapper.writeValueAsString(customerList);
        mockMvc
                .perform(get("/customers/1"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("lza");
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        Customer customerout = new Customer();
        customerout.setFirstName("Elza");
        customerout.setLastName("Kai");
        customerout.setAddress1("123 Juniper Rd");
        customerout.setAddress2("Jonestown-B2");
        customerout.setEmail("elza@gmail.com");
        customerout.setCompany("Zara");
        customerout.setPhone("404-781-8888");
        customerout.setPostalCode("3354");
        customerout.setCity("Jonestowns");
        customerout.setState("GA");
        customerout.setCountry("USA");

        String outputJson = mapper.writeValueAsString(customerout);
        mockMvc.perform(
                        post("/customers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateExistingCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("lza");
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        Customer customerout = new Customer();
        customerout.setFirstName("Elza");
        customerout.setLastName("Kai");
        customerout.setAddress1("123 Juniper Rd");
        customerout.setAddress2("Jonestown-B2");
        customerout.setEmail("elza@gmail.com");
        customerout.setCompany("Zara");
        customerout.setPhone("404-781-8888");
        customerout.setPostalCode("3354");
        customerout.setCity("Jonestowns");
        customerout.setState("GA");
        customerout.setCountry("USA");

        String outputJson = mapper.writeValueAsString(customerout);
        mockMvc.perform(
                        put("/customers/1")                            // Perform the PUT request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        String outputJson = mapper.writeValueAsString(customerList);
        mockMvc.perform(delete("/customers/1")).andDo(print()).andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetByState() throws Exception {
        String outputJson = mapper.writeValueAsString(customerList);
        mockMvc.perform(get("/customers/state/GA")).andDo(print()).andExpect(status().isOk());
    }





    }

