package cafe.product_service.di;

import cafe.product_service.model.Product;
import cafe.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public CommandLineRunner init(ProductRepository repository) {
        return args -> {
            repository.save(new Product(null, "Капучино", 2.6));
            repository.save(new Product(null, "Американо", 3.2));
            repository.save(new Product(null, "Эспрессо", 2.8));
            repository.save(new Product(null, "Ванильный капучино", 4.3));
        };
    }
}
