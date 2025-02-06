package cafe.inventory_service.controller;

import cafe.inventory_service.model.Inventory;
import cafe.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/check")
    boolean isProductAvailable(@RequestParam("productId") Long productId,
                               @RequestParam("quantity") int quantity) {
        return inventoryService.isProductAvailable(productId, quantity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> findById(@PathVariable Long id) {
        return inventoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> findAll() {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inventoryService.save(inventory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable Long id, @RequestBody Inventory inventory) {
        return inventoryService.update(id, inventory)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return inventoryService.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
