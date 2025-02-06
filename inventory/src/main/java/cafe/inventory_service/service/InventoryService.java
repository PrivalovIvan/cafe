package cafe.inventory_service.service;

import cafe.inventory_service.model.Inventory;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    Optional<Inventory> findById(Long id);

    List<Inventory> findAll();

    Inventory save(Inventory inventory);

    boolean deleteById(Long id);

    Optional<Inventory> update(Long id, Inventory inventory);

    boolean isProductAvailable(Long productId, int quantity);
}
