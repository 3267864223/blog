package blog.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page {
	
	// 页面id
    private Integer pageId; 
    
    //localhost:8080/aaa
    private String pageKey;   

    //标题
    private String pageTitle; 

    //内容
    private String pageContent; 

    // 创建时间
    private Date pageCreateTime;
 
    //更新时间
    private Date pageUpdateTime; 

    //点击次数
    private Integer pageViewCount; 

    //评论数量
    private Integer pageCommentCount; 

    //状态
    private Integer pageStatus; 
}
