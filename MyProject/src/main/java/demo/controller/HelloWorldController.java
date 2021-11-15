package demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class HelloWorldController {
 
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String authorInfo(Model model) {        
        return "redirect:/hello";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {         
        model.addAttribute("greeting", "Hello Spring MVC");         
        return"helloworld";         
    }
 
    @RequestMapping(value = "/saveRS")
    @ResponseBody
    public String authorInfo2(Model model) {
    	model.addAttribute("info","ResponseBody Info");
        return "ResponseBody";
    } 

}
