package com.bbd.core.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbd.core.entity.LaArticle;
import com.bbd.core.resp.ArticleDetailResp;
import com.bbd.core.resp.ArticleResp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zangtao
 * @since 2019-04-19
 */
@Component
public interface LaArticleMapper extends BaseMapper<LaArticle> {

    /**
     * 查询资讯列表
     *
     * @param page 分页
     * @param type 类型
     * @param title 标题
     * @return
     */
    IPage<ArticleResp> articleQueryList(Page page, @Param("type") Integer type, @Param("title") String title);

    /**
     * 资讯详情
     *
     * @param showId
     * @return
     */
    ArticleDetailResp articleQueryDetail(@Param("showId") String showId);

    /**
     * 根据对外主键查询
     *
     * @param showId
     * @return
     */
    LaArticle judgeOffShowId(@Param("showId") String showId, @Param("online") Short online);
}
