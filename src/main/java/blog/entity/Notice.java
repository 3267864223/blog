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
public class Notice {
	
	//自增ID
	private Integer noticeId;  
	
	//公告标题
    private String noticeTitle; 
	
    //公告内容
	private String noticeContent;
	
	//创建时间
    private Date noticeCreateTime; 
    
    //更新时间
    private Date noticeUpdateTime;
    
    //状态 
    private Integer noticeStatus; 
    
    //排序
    private Integer noticeOrder; 
}
