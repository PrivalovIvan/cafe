package cafe.customer_service.di;

import cafe.customer_service.model.Customer;
import cafe.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "Ivan Ivanov", "ivan@example.com", "123456789"));
            customerRepository.save(new Customer(null, "Mashka Smirnova", "mashka@example.com", "987654321"));
            customerRepository.save(new Customer(null, "Pavel Valerich", "pavel@example.com", "777777777"));
        };
    }
}
