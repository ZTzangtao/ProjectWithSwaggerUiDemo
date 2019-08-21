package com.bbd.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bbd.common.base.Response;
import com.bbd.core.dto.ArticleEditVo;
import com.bbd.core.dto.ArticleVo;
import com.bbd.core.entity.LaArticle;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zangtao
 * @since 2019-04-19
 */
public interface ILaArticleService extends IService<LaArticle> {

    /**
     * 查询资讯列表
     *
     * @param type 类别
     * @param title 标题
     * @param pageNo 当前页
     * @param pageSize 页大小
     * @return
     */
    Response articleQueryList(Integer type, String title, Integer pageNo,Integer pageSize );

    /**
     * 查看资讯详情
     *
     * @param showId 对外主键Id
     * @return
     */
    Response articleQueryDetail(String showId);

    /**
     * 创建资讯
     *
     * @param articleVo
     * @return
     */
    Response createArticle(ArticleVo articleVo);

    /**
     * 编辑资讯模块
     *
     * @param articleEditVo
     * @return
     */
    Response editArticle(ArticleEditVo articleEditVo);

    /**
     * 根据对外id删除资讯
     *
     * @param showId
     * @return
     */
    Response deleteArticle(String showId);

    /**
     * 上下线该资讯
     *
     * @param showId
     * @param type
     * @return
     */
    Response onlineArticle(String showId, Short type);


}
