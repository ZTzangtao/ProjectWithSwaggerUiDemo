package com.bbd.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbd.common.base.ErrorCode;
import com.bbd.common.base.Response;
import com.bbd.common.util.JsonTools;
import com.bbd.core.dto.ArticleTypeEditVo;
import com.bbd.core.dto.ArticleTypeVo;
import com.bbd.core.entity.LaArticleType;
import com.bbd.core.mapper.LaArticleTypeMapper;
import com.bbd.core.service.ILaArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zangtao
 * @since 2019-04-23
 */
@Service
public class LaArticleTypeServiceImpl extends ServiceImpl<LaArticleTypeMapper, LaArticleType> implements ILaArticleTypeService {

    @Autowired
    private LaArticleTypeMapper laArticleTypeMapper;

    @Override
    public Response createArticleType(ArticleTypeVo articleTypeVo) {
        LaArticleType laArticleType = JsonTools.convertValue(articleTypeVo, LaArticleType.class);
        laArticleType.setCreateDate(new Date());
        laArticleTypeMapper.insert(laArticleType);
        return Response.successMessage("新增成功！");
    }

    @Override
    public Response deleteArticleType(Integer id) {
        LaArticleType laArticleType = laArticleTypeMapper.selectById(id);
        if (laArticleType == null) {
            return Response.error(ErrorCode.NO_INFO.getCode(), ErrorCode.NO_INFO.getErrorName());
        }
        laArticleTypeMapper.deleteById(id);
        return Response.successMessage("删除成功！");
    }

    @Override
    public Response editArticleType(ArticleTypeEditVo articleTypeEditVo) {
        LaArticleType laArticleType = laArticleTypeMapper.selectById(articleTypeEditVo.getId());
        if (laArticleType == null) {
            return Response.error(ErrorCode.NO_INFO.getCode(), ErrorCode.NO_INFO.getErrorName());
        }
        LaArticleType ArticleType = JsonTools.convertValue(articleTypeEditVo, LaArticleType.class);
        ArticleType.setUpdateDate(new Date());
        laArticleTypeMapper.updateById(ArticleType);
        return Response.successMessage("编辑成功！");
    }

    @Override
    public Response articleTypeDetail(Integer id) {
        QueryWrapper<LaArticleType> wrapper = new QueryWrapper<>();
        wrapper.select("id,name,create_date");
        wrapper.eq("id", id);
        LaArticleType laArticleType = laArticleTypeMapper.selectOne(wrapper);
        if (laArticleType == null) {
            return Response.error(ErrorCode.NO_INFO.getCode(), ErrorCode.NO_INFO.getErrorName());
        }
        return Response.success(laArticleType);
    }

    @Override
    public Response articleTypeList(String name, Integer pageNo, Integer pageSize) {
        Page<LaArticleType> page = new Page<>(pageNo, pageSize);
        QueryWrapper<LaArticleType> queryWrapper = new QueryWrapper<>();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        IPage<LaArticleType> laArticleTypeIPage = laArticleTypeMapper.selectPage(page, queryWrapper);
        return Response.success(laArticleTypeIPage);
    }


}
