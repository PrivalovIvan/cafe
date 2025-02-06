package cafe.inventory_service.di;

import cafe.inventory_service.model.Inventory;
import cafe.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {
    @Bean
    public CommandLineRunner init(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(new Inventory(null, 1l, 4));
            inventoryRepository.save(new Inventory(null, 2l, 3));
            inventoryRepository.save(new Inventory(null, 3l, 2));
            inventoryRepository.save(new Inventory(null, 4l, 1));
        };
    }
}
