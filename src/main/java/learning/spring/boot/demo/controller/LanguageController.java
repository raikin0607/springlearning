package learning.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController extends AbstractController {

    @RequestMapping("locale")
    public String locale () {
        return"locale";
    }
}
