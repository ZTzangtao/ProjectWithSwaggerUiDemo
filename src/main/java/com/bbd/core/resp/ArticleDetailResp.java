package com.bbd.core.resp;

import lombok.Data;

import java.util.Date;

/**
 * 资讯详情
 *
 * @author zangtao
 * @create 2019 - 04 -19 11:44
 */
@Data
public class ArticleDetailResp {
    /**
     * 对外展示ID
     */
    private String showId;
    /**
     * 分类 1234
     */
    private String type;

    /**
     * 文章标题
     */
    private String title;

    private String imageId;
    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建日期
     */
    private String createDate;
}
