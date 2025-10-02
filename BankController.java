package com.bank.app.controller;

import com.bank.app.dto.CustomerUpdateDTO;
import com.bank.app.model.Customer;
import com.bank.app.repositories.CustomerRepository;
import com.bank.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class BankController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomer = customerService.getCustomers();
        return new ResponseEntity<>(allCustomer,HttpStatus.OK);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerService.createNewCustomer(customer);
        return new ResponseEntity<>("Customer added successfully ",HttpStatus.CREATED);
    }

    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable int customerId){
        try{
            Customer customerById = customerService.getCustomersByIdService(customerId);
            return new ResponseEntity<>(customerById,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerUpdateDTO dto, @PathVariable int customerId){
        try{
            Customer updateCustomer = customerService.updateCustomerSer(dto,customerId);
            return new ResponseEntity<>(updateCustomer,HttpStatus.OK);
        }catch (ResponseStatusException r){
            return new ResponseEntity<>(r.getReason(),r.getStatusCode());
        }
    }

    @DeleteMapping("/api/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
        try{
            Customer deleteCustomer = customerService.deleteCustomerSer(customerId);
            return new ResponseEntity<>("Customer deleted successfully ",HttpStatus.OK);
        }catch (ResponseStatusException r){
            return new ResponseEntity<>(r.getReason(),r.getStatusCode());
        }
    }
}
