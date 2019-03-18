package learning.spring.boot.demo.controller;

import learning.spring.boot.demo.model.ProductModel;
import learning.spring.boot.demo.service.ProductService;
import learning.spring.boot.demo.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ProductController extends AbstractController {
    @Autowired
    ProductService productService;
    @Autowired
    SendEmailService sendEmailService;
    private static Map<String, ProductModel> productRepo = new HashMap<>();

    @GetMapping(value = "/products") // GET API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> getProducts() throws IOException, MessagingException {
        logger.info("this is a info message getProducts");
        logger.warn("this is a warn message getProducts");
        logger.error("this is a error message getProducts");
       /* boolean sendFlg = false;
        sendFlg =  sendEmailService.sendMail();*/
        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

    @PostMapping(value = "/products") // POST API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel productModel) {
        if (!productService.createProduct(productModel)) {
            return new ResponseEntity<>("Create productModel Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Create productModel success", HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}") // PUT API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody ProductModel productModel) {
        if (!productService.updateProduct(productModel, id)) {
            return new ResponseEntity<>("Update productModel Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update productModel success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}") // DELETE API
    @CrossOrigin(origins = "http://localhost:8888")
    public ResponseEntity<Object> removeProduct(@PathVariable("id") Long id, @RequestBody ProductModel productModel) {
        if (!productService.deleteProduct(id)) {
            return new ResponseEntity<>("Delete productModel Fail", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete productModel success", HttpStatus.OK);
    }

}
