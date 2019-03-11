package learning.spring.boot.demo.controller;

import learning.spring.boot.demo.exception.product.ProductNotfoundException;
import learning.spring.boot.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
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
    @RequestMapping(value="/products") // GET API
    public ResponseEntity<Object> getProducts() {
        logger.info("this is a info message getProducts");
        logger.warn("this is a warn message getProducts");
        logger.error("this is a error message getProducts");
        return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
    }

    @RequestMapping(value="/products", method = RequestMethod.POST) // POST API
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Create product success",HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}" , method = RequestMethod.PUT) // PUT API
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id , @RequestBody Product product) {
        if(!productRepo.containsKey(id)) throw new ProductNotfoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Update product success",HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}" , method = RequestMethod.DELETE) // DELETE API
    public ResponseEntity<Object> removeProduct(@PathVariable("id") String id , @RequestBody Product product) {
        productRepo.remove(id);
        return new ResponseEntity<>("Delete product success",HttpStatus.OK);
    }

}
