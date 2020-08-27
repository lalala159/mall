package com.mall.mdo.jdk.sys.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * jkgl_user
 * @author 
 */
@Data
public class JkglUser implements Serializable {
    private Integer id;

    private String userName;

    private static final long serialVersionUID = 1L;
}