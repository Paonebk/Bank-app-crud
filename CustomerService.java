package com.bank.app.service;

import com.bank.app.dto.CustomerUpdateDTO;
import com.bank.app.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void createNewCustomer(Customer customer);

    Customer getCustomersByIdService(int customerId);

    Customer updateCustomerSer(CustomerUpdateDTO dto, int customerId);

    Customer deleteCustomerSer(int customerId);
}
