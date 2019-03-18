package learning.spring.boot.demo.service;

import learning.spring.boot.demo.model.ProductModel;

import java.util.Collection;


public interface ProductService {

    boolean createProduct(ProductModel productModel);

    boolean updateProduct(ProductModel productModel, Long id);

    boolean deleteProduct(Long id);

    Collection<ProductModel> getProductList();
}
