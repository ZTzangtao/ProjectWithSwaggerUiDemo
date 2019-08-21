package com.bbd.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbd.common.base.ErrorCode;
import com.bbd.common.base.Response;
import com.bbd.common.util.JsonTools;
import com.bbd.common.util.StringUtils;
import com.bbd.core.dto.ArticleEditVo;
import com.bbd.core.dto.ArticleVo;
import com.bbd.core.entity.LaArticle;
import com.bbd.core.entity.LaArticleType;
import com.bbd.core.mapper.LaArticleMapper;
import com.bbd.core.mapper.LaArticleTypeMapper;
import com.bbd.core.resp.ArticleResp;
import com.bbd.core.service.ILaArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zangtao
 * @since 2019-04-19
 */
@Service
public class LaArticleServiceImpl extends ServiceImpl<LaArticleMapper, LaArticle> implements ILaArticleService {

    Logger logger = LoggerFactory.getLogger(LaArticleServiceImpl.class);

    @Autowired
    private LaArticleMapper laArticleMapper;

    @Autowired
    private LaArticleTypeMapper laArticleTypeMapper;

    @Override
    public Response articleQueryList(Integer type, String title, Integer pageNo,Integer pageSize) {
        Page<ArticleResp> page = new Page<>(pageNo, pageSize);
        return Response.success(laArticleMapper.articleQueryList(page, type, title));
    }

    @Override
    public Response articleQueryDetail(String showId) {
        return Response.success( laArticleMapper.articleQueryDetail(showId) );
    }

    @Override
    public Response createArticle(ArticleVo articleVo) {
        //对type进行校验
        LaArticleType laArticleType = laArticleTypeMapper.selectById(articleVo.getTypeId());
        if (laArticleType == null) {
            return Response.error(ErrorCode.NO_TYPE_INFO.getCode(),ErrorCode.NO_TYPE_INFO.getErrorName());
        }
        //转换对象 JsonTools
        LaArticle laArticle = JsonTools.convertValue(articleVo,LaArticle.class);
        //设置对外展示id
        laArticle.setShowId(StringUtils.getUUID());
        laArticle.setAppId("123");
        laArticle.setCreateDate(new Date());
        laArticleMapper.insert(laArticle);
        return Response.successMessage("新增资讯成功！");
    }

    @Override
    public Response editArticle(ArticleEditVo articleEditVo) {
        String showId = articleEditVo.getShowId();
        //根据showId判断
        LaArticle laArticle = laArticleMapper.selectOne(Wrappers.<LaArticle>query().eq("show_id", showId));
        if (laArticle == null) {
            return Response.error(ErrorCode.NO_INFO.getCode(), ErrorCode.NO_INFO.getErrorName());
        }

        //判断typeId
        if (articleEditVo.getTypeId() != null) {
            //对type进行校验
            LaArticleType laArticleType = laArticleTypeMapper.selectById(articleEditVo.getTypeId());
            if (laArticleType == null) {
                return Response.error(ErrorCode.NO_TYPE_INFO.getCode(), ErrorCode.NO_TYPE_INFO.getErrorName());
            }
        }
        //转换对象 JsonTools
        LaArticle laArticle1 = JsonTools.convertValue(articleEditVo, LaArticle.class);
        laArticle1.setArticleId(laArticle.getArticleId());
        laArticle1.setUpdateDate(new Date());
        laArticleMapper.updateById(laArticle1);
        return Response.successMessage("编辑成功！");
    }

    @Override
    public Response deleteArticle(String showId) {
        //根据showId判断
        LaArticle laArticle = laArticleMapper.selectOne(Wrappers.<LaArticle>query().eq("show_id", showId));
//        LaArticle laArticle  = laArticleMapper.selectList(Wrappers.<LaArticle>query().eq("show_id",showId)).get(0);
        if (laArticle == null){
            return Response.error(ErrorCode.NO_INFO.getCode(),ErrorCode.NO_INFO.getErrorName());
        }
        laArticleMapper.deleteById(laArticle.getArticleId());
        return Response.successMessage("删除成功！");
    }

    @Override
    public Response onlineArticle(String showId, Short type) {
        short line;
        if (type == 0) {
            line = 1;
        } else {
            line = 0;
        }
        //判断showId
        LaArticle laArticle = laArticleMapper.judgeOffShowId(showId, line);
        if (laArticle == null) {
            return Response.error(ErrorCode.NO_INFO.getCode(),ErrorCode.NO_INFO.getErrorName());
        }
        //更新操作
        laArticleMapper.updateById(new LaArticle().setArticleId(laArticle.getArticleId()).setOnline(type).setUpdateDate(new Date()));
        return Response.successMessage("操作成功！");
    }


}
