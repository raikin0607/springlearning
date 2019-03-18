package learning.spring.boot.demo.repository.Impl;

import learning.spring.boot.demo.entity.Product;
import learning.spring.boot.demo.repository.ProductRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public boolean updateProduct(Product product, int id) {
        Product pro= entityManager.find(Product.class,id);
        if (pro == null ) {
            return false;
        }
        pro.setId(product.getId());
        pro.setProducName(product.getProducName());
        entityManager.flush();
        return true;
    }

    @Override
    public boolean createProduct(Product product) {
        return true;
    }
}
