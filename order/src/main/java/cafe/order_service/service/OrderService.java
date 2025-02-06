package cafe.order_service.service;

import cafe.order_service.client.CustomerClient;
import cafe.order_service.client.InventoryClient;
import cafe.order_service.client.ProductClient;
import cafe.order_service.dto.InventoryDTO;
import cafe.order_service.dto.ProductDTO;
import cafe.order_service.model.Order;
import cafe.order_service.model.OrderItem;
import cafe.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final InventoryClient inventoryClient;


    private BigDecimal getTotalPrice(Order order) {
        return order.getItems().stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public Order createOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            ProductDTO productDTO = productClient.findById(item.getProductId());
            boolean isAvailable = inventoryClient.isProductAvailable(item.getProductId(), item.getQuantity());
            if (!isAvailable) {
                throw new IllegalArgumentException("Product with ID " + item.getProductId() +
                        " is not available in the requested quantity.");
            } else {
                inventoryClient.update(item.getProductId(), new InventoryDTO(null, item.getProductId(), inventoryClient.findById(item.getProductId()).getQuantity() - item.getQuantity()));
            }
            item.setPrice(productDTO.getPrice());
        }
        order.setTotalPrice(getTotalPrice(order));

        return orderRepository.save(order);
    }

    public Optional<Order> findOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(this::attachCustomerData);
        return order;
    }

    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(this::attachCustomerData);
        return orders;
    }

    public void attachCustomerData(Order order) {
        order.setCustomer(customerClient.findById(order.getCustomerId()));
    }


    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
