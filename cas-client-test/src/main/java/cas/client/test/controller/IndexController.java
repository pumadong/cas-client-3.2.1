package cas.client.test.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


 
/**
 *主界面及登录验证相关的控制器 
 */

@Controller
@RequestMapping("/controller")
public class IndexController {
	

	@RequestMapping("/main")
    public String main(String moduleFlag,HttpServletRequest request,ModelMap map) {       
        return "main.ftl";
    }	
}