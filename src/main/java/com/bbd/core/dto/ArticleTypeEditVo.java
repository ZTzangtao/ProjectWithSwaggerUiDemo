package com.bbd.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 编辑资讯类型
 *
 * @author zangtao
 * @create 2019 - 04 -19 18:20
 */
@Data
public class ArticleTypeEditVo {

    @NotNull
    @ApiModelProperty(value = "主键id", name = "id", required = true)
    private Integer id;

    @Size(max = 35)
    @ApiModelProperty(value="名字",name="name")
    private String name;

    @Size(max = 150)
    @ApiModelProperty(value = "描述", name = "description")
    private String description;


}
