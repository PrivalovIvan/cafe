package cafe.product_service.di;

import cafe.product_service.model.Product;
import cafe.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductConfig {
    @Bean
    public CommandLineRunner init(ProductRepository repository) {
        return args -> {
            repository.save(new Product(null, "Капучино", BigDecimal.valueOf(2.6)));
            repository.save(new Product(null, "Американо", BigDecimal.valueOf(3.2)));
            repository.save(new Product(null, "Эспрессо", BigDecimal.valueOf(2.8)));
            repository.save(new Product(null, "Ванильный капучино", BigDecimal.valueOf(4.3)));
        };
    }
}
