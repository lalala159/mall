package com.mall.sys.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * cms_topic_comment
 * @author 
 */
@Data
public class CmsTopicComment implements Serializable {
    private Long id;

    private String memberNickName;

    private Long topicId;

    private String memberIcon;

    private String content;

    private Date createTime;

    private Integer showStatus;

    private static final long serialVersionUID = 1L;
}