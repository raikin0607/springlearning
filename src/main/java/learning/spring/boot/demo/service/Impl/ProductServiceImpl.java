package learning.spring.boot.demo.service.Impl;

import learning.spring.boot.demo.entity.Product;
import learning.spring.boot.demo.model.ProductModel;
import learning.spring.boot.demo.repository.ProductRepository;
import learning.spring.boot.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static Map<Long, ProductModel> productRepo = new HashMap<>();
    static {
        ProductModel honey = new ProductModel();
        honey.setId(1L);
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        ProductModel almond = new ProductModel();
        almond.setId(2L);
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Override
    public boolean createProduct(ProductModel productModel) {
        productRepo.put(productModel.getId(), productModel);
        return true;
    }

    @Override
    public boolean updateProduct(ProductModel productModel, Long id) {
        productRepo.remove(id);
        productModel.setId(id);
        productRepo.put(id, productModel);
        return true;
    }

    @Override
    public boolean deleteProduct(Long id) {
        productRepo.remove(id);
        return true;
    }

    @Override
    public List<ProductModel> getProductList() {

        List<Product> productList = productRepository.findAll();
        List<ProductModel> productModelList = new ArrayList<>();

        for (Product pro : productList) {
            ProductModel model = new ProductModel();
            model.setId(pro.getId());
            model.setName(pro.getProducName());
            productModelList.add(model);
        }

        return productModelList;
    }

}
