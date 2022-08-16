package blog.entity;

import lombok.Data;

@Data
public class Tag {
	
	public Tag() {}

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.articleCount = articleCount;
    }

	private Integer tagId;
    private String tagName;
    private String tagDescription;

    //文章数量(不是数据库字段)
    private Integer articleCount;

  
}
