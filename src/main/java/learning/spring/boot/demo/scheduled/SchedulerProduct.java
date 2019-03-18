package learning.spring.boot.demo.scheduled;

import learning.spring.boot.demo.model.ProductModel;
import learning.spring.boot.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Component
public class SchedulerProduct {
    @Autowired
    ProductService productService;
    /*
    * cron --> using by :
    * # ┌───────────── minute (0 - 59)
        │ ┌───────────── hour (0 - 23)
        │ │ ┌───────────── day of the month (1 - 31)
        │ │ │ ┌───────────── month (1 - 12)
        │ │ │ │ ┌───────────── day of the week (0 - 6) (Sunday to Saturday;
        │ │ │ │ │                                   7 is also Sunday on some systems)
        │ │ │ │ │
        │ │ │ │ │
        * * * * * command to execute
        https://en.wikipedia.org/wiki/Cron#Special_Characters
    * */
    @Scheduled(cron = "0 * 9 * * ? ")
    public void cronJobProductCron() {
        System.out.println("Start cronJobProductCron");
        execute ();
    }

    @Scheduled(fixedRate = 10000000) // each 1s will be do job
    public void cronJobProductFixRate() {
        System.out.println("Start cronJobProductFixRate");
        execute ();
    }

    @Scheduled(fixedDelay = 1000000 , initialDelay = 300000) // the first 1s will be do job and the next time do is 3s
     public void cronJobProductFixDelay() {
        System.out.println("Start fixedDelay");
        execute ();
    }

    private void execute () {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now = new Date();
            String strDate = sdf.format(now);
            System.out.println("Java cron job expression Start:: " + strDate);
            Collection<ProductModel> listProductModel = new ArrayList<>();
            listProductModel = productService.getProductList();
            for(ProductModel pro : listProductModel) {
                System.out.println("Java cron job expression:: " + pro.getId());
                System.out.println("Java cron job expression:: " + pro.getName());
            }
            strDate = sdf.format(now);
            System.out.println("Java cron job expression End :: " + strDate);
        }
}
