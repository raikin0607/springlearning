package learning.spring.boot.demo.exception;

import learning.spring.boot.demo.exception.product.ProductNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception (ProductNotfoundException exception) {
        return new ResponseEntity<>("ProductModel not found", HttpStatus.NOT_FOUND);
    }
}
