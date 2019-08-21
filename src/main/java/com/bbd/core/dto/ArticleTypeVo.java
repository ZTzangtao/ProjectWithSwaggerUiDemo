package com.bbd.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 新增资讯类型
 *
 * @author zangtao
 * @create 2019 - 04 -19 17:29
 */
@Data
public class ArticleTypeVo {

    @NotEmpty
    @Size(max = 35)
    @ApiModelProperty(value="名字",name="name")
    private String name;

    @Size(max = 150)
    @ApiModelProperty(value = "描述", name = "description")
    private String description;




}
