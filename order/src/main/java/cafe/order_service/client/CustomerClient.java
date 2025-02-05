package cafe.order_service.client;

import cafe.order_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer")
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    CustomerDTO findById(@PathVariable long id);
}
