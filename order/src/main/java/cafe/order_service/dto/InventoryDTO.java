package cafe.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryDTO {
    private Long id;
    private Long productId;
    private int quantity;
}
