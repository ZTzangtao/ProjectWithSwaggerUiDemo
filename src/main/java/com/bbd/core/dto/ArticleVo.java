package com.bbd.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 资讯模块传参
 *
 * @author zangtao
 * @create 2019 - 04 -18 16:26
 */
@Data
public class ArticleVo {

    @NotNull
    @ApiModelProperty(value="类别",name="type",required = true)
    private Integer typeId;

    @Size(max = 100)
    @ApiModelProperty(value="标题",name="title")
    private String title;

    @ApiModelProperty(value="图片id",name="imageId")
    private String imageId;

    @NotNull
    @ApiModelProperty(value = "是否上线 1是 2否", name = "online", required = true)
    private Short online;

    @NotNull
    @ApiModelProperty(value="触达人群",name="toUser",required = true)
    private Short toUser;

    @NotNull
    @Size(max = 1000)
    @ApiModelProperty(value="内容",name="content",required = true)
    private String content;

}
