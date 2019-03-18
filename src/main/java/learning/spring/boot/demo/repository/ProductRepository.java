package learning.spring.boot.demo.repository;

import learning.spring.boot.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
/*https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring*/
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById (Long id);

    /*List<Product> findProductList ();*/

    @Query("SELECT SUM(id) FROM Product")
    Integer countProduct ();
}
