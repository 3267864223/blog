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
		List<Tag> tagList=tagMapper.getAllTag();
		for(Tag t:tagList) {
			t.setArticleCount(tagMapper.getArticleTagCount(t.getTagId()));
		}
		return tagList;
	}

	public Tag getTagById(Integer tagId) {
		return tagMapper.getTagById(tagId);
	}

	public void updateTag(Tag tag) {
		tagMapper.updateTag(tag);
		
	}

	public void addTag(Tag tag) {
		tagMapper.addTag(tag);
	}

	public void deleteTag(Integer tagId) {
		tagMapper.deleteTag(tagId);
	}

}
