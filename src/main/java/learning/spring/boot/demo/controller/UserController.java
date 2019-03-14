package learning.spring.boot.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @GetMapping()
   /* @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })*/
    public ResponseEntity<Object> getUserInfo () throws InterruptedException {
        Thread.sleep(3000);
        return new ResponseEntity<>("VU MANH HOANG", HttpStatus.OK);
    }

    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
