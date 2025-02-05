package cafe.order_service.client;

import cafe.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/products/{id}")
    ProductDTO findById(@PathVariable Long id);

    @GetMapping("/products")
    List<ProductDTO> findAll();
}
