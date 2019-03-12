package learning.spring.boot.demo.service.Impl;

import learning.spring.boot.demo.model.Product;
import learning.spring.boot.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Override
    public boolean createProduct(Product product) {
        productRepo.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean updateProduct(Product product, String id) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return true;
    }

    @Override
    public boolean deleteProduct(String id) {
        productRepo.remove(id);
        return true;
    }

    @Override
    public Collection<Product> getProductList() {
        return productRepo.values();
    }

}
