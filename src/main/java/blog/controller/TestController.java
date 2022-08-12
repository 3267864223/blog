package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String test(ModelMap m) {
		System.out.println("test方法调用了,springmvc流程成功");
		m.put("msg","springmvc配置成功");
		return "index";
	}
}
