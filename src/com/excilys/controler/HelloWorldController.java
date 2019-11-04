package com.excilys.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/ceciestuntest")
public class HelloWorldController {

     @RequestMapping(method = RequestMethod.GET)
     public String sayHello(ModelMap model) {
          model
               .addAttribute("greeting", "Hello World from Spring 4 MVC");
          return "dashboard";
     }


}
