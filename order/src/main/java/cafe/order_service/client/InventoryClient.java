package cafe.order_service.client;

import cafe.order_service.dto.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory")
public interface InventoryClient {
    @GetMapping("/inventory/{id}")
    InventoryDTO findById(@PathVariable Long id);

    @PutMapping("/inventory/{id}")
    InventoryDTO update(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO);

    @GetMapping("/inventory/check")
    boolean isProductAvailable(@RequestParam("productId") Long productId,
                               @RequestParam("quantity") int quantity);
}
