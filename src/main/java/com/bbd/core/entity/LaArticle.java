package com.bbd.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zangtao
 * @since 2019-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LaArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 对外展示ID
     */
    private String showId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 分类 1234
     */
    private Integer typeId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 图片
     */
    private String imageId;

    /**
     * 那类用户可看
     */
    private short toUser;

    /**
     * 上下线，0上线，1下线
     */
    private short online;

    /**
     * 标签
     */
    private String tag;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 审核人
     */
    private String auditBy;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 应用状态（0：待审核；1：已审核；2：下架）
     */
    private Integer status;

    /**
     * 删除标识（0：未删除；1：已删除）
     */
    @TableLogic
    private Integer delFlag;


}
