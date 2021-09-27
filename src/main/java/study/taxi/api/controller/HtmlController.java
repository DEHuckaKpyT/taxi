package study.taxi.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HtmlController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

//    @GetMapping("reg")
//    public String reg(HttpServletRequest request){
//        request.login("");
//    }

}
