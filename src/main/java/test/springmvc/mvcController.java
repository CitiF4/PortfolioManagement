package test.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mandy on 2018/8/10.
 */


    @Controller
    public class mvcController {

        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public String hello(){
            System.out.println("==========================================");
            return "hello";
        }
    }

