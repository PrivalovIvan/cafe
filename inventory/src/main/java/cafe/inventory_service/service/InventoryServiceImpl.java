package cafe.inventory_service.service;

import cafe.inventory_service.model.Inventory;
import cafe.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!inventoryRepository.existsById(id)) return false;
        inventoryRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Inventory> update(Long id, Inventory inventory) {
        inventory.setId(id);
        return Optional.of(inventoryRepository.save(inventory));
    }

    @Override
    public boolean isProductAvailable(Long productId, int quantity) {
        return inventoryRepository.findById(productId)
                .map(prod -> prod.getQuantity() >= quantity)
                .orElse(false);
    }
}
