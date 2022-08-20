package blog.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import blog.entity.Options;
import blog.service.OptionsService;

@Controller @RequestMapping("/options")
public class OptionsController {

	@Resource
	private OptionsService optionsService;
	
	@RequestMapping("")
	public String getAllOptions(ModelMap m){
		Options options=optionsService.getOptionsById(1);
		m.put("options", options);
		return "Options/options-list";
	}
	
	//图片预览
	@RequestMapping("/photo1")
	public void getPhoto1(Integer optionId, HttpServletResponse response ) throws IOException {
		Options options=optionsService.getOptionsById(optionId);
		
		response.setContentType("image/jpg");
		ServletOutputStream outStream =response.getOutputStream();
		
		if(options.getOptionAboutsitePhoto()!=null) {
			outStream.write(options.getOptionAboutsitePhoto());
			outStream.flush();
		}
	}
	@RequestMapping("/photo2")
	public void getPhoto2(Integer optionId, HttpServletResponse response ) throws IOException {
		Options options=optionsService.getOptionsById(optionId);
		
		response.setContentType("image/jpg");
		ServletOutputStream outStream =response.getOutputStream();
		
		if(options.getOptionAboutsiteWechatphoto()!=null) {
			outStream.write(options.getOptionAboutsiteWechatphoto());
			outStream.flush();
		}
	}
	
	@RequestMapping("/update")
	public String updateUser(Options options,@RequestParam MultipartFile[] photo) throws IOException {
		if(photo[0].getSize()!=0 && photo[1].getSize()!=0) {
			options.setOptionAboutsitePhoto(photo[0].getBytes());
			options.setOptionAboutsiteWechatphoto(photo[1].getBytes());
		}else if(photo[0].getSize()==0 && photo[1].getSize()!=0) {
			options.setOptionAboutsiteWechatphoto(photo[1].getBytes());
		}else if(photo[0].getSize()!=0 && photo[1].getSize()==0) {
			options.setOptionAboutsitePhoto(photo[0].getBytes());
		}
		optionsService.updateOptions(options);
		return "forward:/options";
	}
}
