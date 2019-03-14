package learning.spring.boot.demo.controller;

import learning.spring.boot.demo.exception.product.ProductNotfoundException;
import learning.spring.boot.demo.model.Product;
import learning.spring.boot.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ProductController extends AbstractController {
    @Autowired
    ProductService productService;
    private static Map<String, Product> productRepo = new HashMap<>();

    @GetMapping(value = "/products") // GET API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> getProducts() {
        logger.info("this is a info message getProducts");
        logger.warn("this is a warn message getProducts");
        logger.error("this is a error message getProducts");
        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

    @PostMapping(value = "/products") // POST API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        if (!productService.createProduct(product)) {
            return new ResponseEntity<>("Create product Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Create product success", HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}") // PUT API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if (!productService.updateProduct(product, id)) {
            return new ResponseEntity<>("Update product Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update product success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}") // DELETE API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> removeProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if (!productService.deleteProduct(id)) {
            return new ResponseEntity<>("Delete product Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete product success", HttpStatus.OK);
    }

}
