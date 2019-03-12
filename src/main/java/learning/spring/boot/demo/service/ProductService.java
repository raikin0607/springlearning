package learning.spring.boot.demo.service;

import learning.spring.boot.demo.model.Product;

import java.util.Collection;


public interface ProductService {

    boolean createProduct(Product product);

    boolean updateProduct(Product product, String id);

    boolean deleteProduct(String id);

    Collection<Product> getProductList();
}
