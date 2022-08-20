package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Options;
import blog.mapper.OptionsMapper;
import blog.service.OptionsService;

@Service
public class OptionsServieImpl implements OptionsService{

	@Resource
	private OptionsMapper optionsMapper;
	
	public List<Options> getAllOptions() {
		return optionsMapper.getAllOptions();
	}

	public Options getOptionsById(Integer optionsId) {
		return optionsMapper.getOptionsById(optionsId);
	}

	public void updateOptions(Options options) {
		if(options.getOptionAboutsitePhoto()!=null && options.getOptionAboutsiteWechatphoto()!=null) {
			optionsMapper.updateOptionsP2(options);
		}else if(options.getOptionAboutsitePhoto()==null && options.getOptionAboutsiteWechatphoto()!=null) {
			optionsMapper.updateOptionsPv(options);
		}else if(options.getOptionAboutsitePhoto()!=null && options.getOptionAboutsiteWechatphoto()==null) {
			optionsMapper.updateOptionsPa(options);
		}else {
			optionsMapper.updateOptions(options);
		}
	}

}
