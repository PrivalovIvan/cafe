package cafe.order_service.model;

import cafe.order_service.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long customerId;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference //@JsonManagedReference показывает, что Order управляет отношением.
    private List<OrderItem> items;

    @Transient //не сохраняем в бд
    private CustomerDTO customer;

    private BigDecimal totalPrice;
}
