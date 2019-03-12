package learning.spring.boot.demo.Interceptor.Product;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class ProductInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


       /* System.out.println("Pre Handle method is Calling");
        System.out.println("The request : " + request);
        System.out.println("The response : " + response);*/
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        /*System.out.println("Post Handle method is Calling");
        System.out.println("The request : " + request);
        System.out.println("The response : " + response);*/
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        /*System.out.println("Request and Response is completed");
        System.out.println("The request : " + request);
        System.out.println("The response : " + response);*/
    }
}
