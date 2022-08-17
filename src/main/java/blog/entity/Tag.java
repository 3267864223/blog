package blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
	
    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

	private Integer tagId;
    private String tagName;
    private String tagDescription;

    //文章数量(不是数据库字段)
    private Integer articleCount;

  
}
