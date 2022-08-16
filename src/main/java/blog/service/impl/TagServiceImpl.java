package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Tag;
import blog.mapper.TagMapper;
import blog.service.TagService;

@Service
public class TagServiceImpl implements TagService{
	
	@Resource
	private TagMapper tagMapper;

	public List<Tag> getAllTag() {
		return tagMapper.getAllTag();
	}

}
