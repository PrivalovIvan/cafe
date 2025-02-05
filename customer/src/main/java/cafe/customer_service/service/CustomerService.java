package cafe.customer_service.service;

import cafe.customer_service.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    boolean deleteById(Long id);

    Optional<Customer> update(Long id, Customer customer);
}
