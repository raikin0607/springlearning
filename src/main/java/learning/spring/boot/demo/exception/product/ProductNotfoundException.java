package learning.spring.boot.demo.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception (ProductNotfoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

}
