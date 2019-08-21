package com.bbd.core.controller;


import com.bbd.common.annotation.ArticleOperation;
import com.bbd.common.base.Response;
import com.bbd.core.dto.ArticleTypeEditVo;
import com.bbd.core.dto.ArticleTypeVo;
import com.bbd.core.service.ILaArticleTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zangtao
 * @since 2019-04-23
 */
@Api( tags = "资讯类型模块" )
@RestController
@RequestMapping("/v1/informationType")
public class LaArticleTypeController {

    @Autowired
    private ILaArticleTypeService iLaArticleTypeService;

    @ApiOperation(value = "资讯管理端-资讯类型新增", notes = "资讯管理端-资讯类型新增")
    @ArticleOperation
    @PostMapping(value = "articleType")
    public Response createArticleType(@RequestBody @Valid ArticleTypeVo articleTypeVo) {
        return iLaArticleTypeService.createArticleType(articleTypeVo);
    }

    @ApiOperation(value = "资讯管理端-资讯类型删除", notes = "资讯管理端-资讯类型删除")
    @ArticleOperation
    @ApiImplicitParam(value = "资讯类型Id", name = "id", dataType = "String", paramType = "path", required = true)
    @DeleteMapping(value = "articleType/{id}")
    public Response deleteArticleType(@PathVariable String id) {
        return iLaArticleTypeService.deleteArticleType(Integer.valueOf(id));
    }

    @ApiOperation(value = "资讯管理端-资讯类型编辑", notes = "资讯管理端-资讯类型编辑")
    @ArticleOperation
    @PutMapping(value = "articleType")
    public Response editArticleType(@RequestBody @Valid ArticleTypeEditVo articleTypeEditVo) {
        return iLaArticleTypeService.editArticleType(articleTypeEditVo);
    }

    @ApiOperation(value = "资讯管理端-资讯类型详情", notes = "资讯管理端-资讯类型详情")
    @ArticleOperation
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "String", paramType = "path", required = true)
    @GetMapping(value = "articleTypeDetail/{id}")
    public Response articleTypeDetail(@PathVariable String id) {
        return iLaArticleTypeService.articleTypeDetail(Integer.valueOf(id));
    }

    @ApiOperation(value = "资讯管理端-资讯类型搜索", notes = "资讯管理端-资讯类型搜索")
    @ArticleOperation
    @GetMapping(value = "articleTypeList")
    public Response articleTypeList(@ApiParam(name = "name", value = "名称") @RequestParam(required = false) String name,
                                    @ApiParam(name = "pageNo", value = "当前页", defaultValue = "1") @RequestParam Integer pageNo,
                                    @ApiParam(name = "pageSize", value = "页大小", defaultValue = "10") @RequestParam Integer pageSize) {
        return iLaArticleTypeService.articleTypeList(name, pageNo, pageSize);
    }
}
