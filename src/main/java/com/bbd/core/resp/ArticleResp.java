package com.bbd.core.resp;

import lombok.Data;

/**
 * 资讯列表返回
 *
 * @author zangtao
 * @create 2019 - 04 -18 18:18
 */
@Data
public class ArticleResp {

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
}
