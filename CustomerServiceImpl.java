package com.bank.app.service;

import com.bank.app.dto.CustomerUpdateDTO;
import com.bank.app.model.Customer;
import com.bank.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomersByIdService(int customerId) {
        Customer byId = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"customer with customerId not found"));
        return byId;
    }

    @Override
    public Customer updateCustomerSer(CustomerUpdateDTO dto, int customerId) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"customer with " + customerId + "not found"));

        if (dto.getFirstName() != null) existingCustomer.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) existingCustomer.setLastName(dto.getLastName());
        if (dto.getEmail() != null) existingCustomer.setEmail(dto.getEmail());
        if (dto.getPhoneNo() != null) existingCustomer.setPhoneNo(dto.getPhoneNo());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public Customer deleteCustomerSer(int customerId) {
        Customer findCustomer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"customer with "+customerId+"Not available for deletion"));

        customerRepository.delete(findCustomer);
        return findCustomer;
    }
}
