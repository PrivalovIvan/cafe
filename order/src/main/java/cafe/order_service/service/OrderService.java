package cafe.order_service.service;

import cafe.order_service.client.CustomerClient;
import cafe.order_service.model.Order;
import cafe.order_service.model.OrderItem;
import cafe.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public Order createOrder(Order order) {
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
