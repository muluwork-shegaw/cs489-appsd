package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void deleteCustomer(Long id);
}
