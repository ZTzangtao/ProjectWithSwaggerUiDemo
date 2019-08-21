package com.bbd.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 后端编辑
 *
 * @author zangtao
 * @create 2019 - 04 -19 16:24
 */
@Data
public class ArticleEditVo {

    @NotEmpty
    @ApiModelProperty(value = "主键" , name = "showId")
    private String showId;

    @ApiModelProperty(value="类别",name="type")
    private Integer typeId;

    @Size(max = 100)
    @ApiModelProperty(value="标题",name="title")
    private String title;

    @ApiModelProperty(value="图片id",name="imageId")
    private String imageId;

    @ApiModelProperty(value = "是否上线 1是 2否", name = "online")
    private Short online;

    @ApiModelProperty(value="触达人群",name="toUser")
    private Short toUser;

    @Size(max = 1000)
    @ApiModelProperty(value="内容",name="content")
    private String content;

}
