package cafe.product_service.service;

import cafe.product_service.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> update(Long id, Product product);

    boolean delete(Long id);
}
