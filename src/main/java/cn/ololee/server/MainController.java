package cn.ololee.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private Logger logger= LoggerFactory.getLogger(MainController.class);
    @ResponseBody
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/user/signin")
    public String login()
    {
        return "hello";
    }
}
