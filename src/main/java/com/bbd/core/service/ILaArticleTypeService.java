package com.bbd.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bbd.common.base.Response;
import com.bbd.core.dto.ArticleTypeEditVo;
import com.bbd.core.dto.ArticleTypeVo;
import com.bbd.core.entity.LaArticleType;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zangtao
 * @since 2019-04-23
 */
public interface ILaArticleTypeService extends IService<LaArticleType> {

    /**
     * 新增资讯类型
     *
     * @param articleTypeVo
     * @return
     */
    Response createArticleType(ArticleTypeVo articleTypeVo);

    /**
     * 删除资讯类型
     *
     * @param id
     * @return
     */
    Response deleteArticleType(Integer id);

    /**
     * 编辑资讯类型
     *
     * @param articleTypeEditVo
     * @return
     */
    Response editArticleType(ArticleTypeEditVo articleTypeEditVo);

    /**
     * 查询类型详情
     *
     * @param id
     * @return
     */
    Response articleTypeDetail(Integer id);

    /**
     * 搜索资讯类型
     *
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    Response articleTypeList(String name, Integer pageNo, Integer pageSize);
}
