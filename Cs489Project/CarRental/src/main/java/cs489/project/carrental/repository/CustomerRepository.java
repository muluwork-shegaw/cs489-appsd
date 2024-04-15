package cs489.project.carrental.repository;

import cs489.project.carrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional queries related to the customer can be defined here.
}
