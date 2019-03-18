package learning.spring.boot.demo.repository;

import learning.spring.boot.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryCustom {
    boolean updateProduct (Product product , int id);
    boolean createProduct (Product product);

}
