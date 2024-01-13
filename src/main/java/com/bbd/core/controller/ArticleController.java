package com.bbd.core.controller;


import com.bbd.common.annotation.ArticleOperation;
import com.bbd.common.base.Response;
import com.bbd.common.util.HttpUtils;
import com.bbd.core.dto.ArticleEditVo;
import com.bbd.core.dto.ArticleVo;
import com.bbd.core.service.ILaArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zangtao
 * @since 2019-04-18
 */
@Api( tags = "资讯模块" )
@RestController
@RequestMapping("/v1/information")
public class ArticleController {

    @Autowired
    private ILaArticleService iLaArticleService;

    @ApiOperation(value = "查询资讯列表", notes = "资讯列表web端和管理后台的",httpMethod = "GET")
    @ArticleOperation
    @GetMapping(value = "queryList")
    public Response articleQueryList(@ApiParam(value = "类型",name = "typeId" ) @RequestParam(required = false) Integer typeId,
                                     @ApiParam(value = "标题",name = "title" ) @RequestParam(required = false) String title,
                                     @ApiParam(value = "当前页",name = "pageNo",defaultValue = "1") @RequestParam(defaultValue = "1") Integer pageNo,
                                     @ApiParam(value = "页大小",name = "pageSize",defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize) {
        return iLaArticleService.articleQueryList(typeId,title,pageNo,pageSize);
    }

    @ApiOperation(value = "查询资讯详情", notes = "查询资讯详情")
    @ArticleOperation
    @ApiImplicitParam(name = "showId" , value = "对外主键Id" , dataType = "String" ,required = true, paramType = "query")
    @GetMapping(value = "articleDetail")
    public Response articleQueryDetail(@RequestParam String showId) {
        return iLaArticleService.articleQueryDetail(showId);
    }

    @ApiOperation(value = "资讯管理端-创建", notes = "资讯管理端-创建")
    @ArticleOperation
    @PostMapping(value = "article")
    public Response createArticle(@RequestBody @Valid ArticleVo articleVo) {
        return iLaArticleService.createArticle(articleVo);
    }

    @ApiOperation(value = "资讯管理端-编辑", notes = "资讯管理端-编辑")
    @ArticleOperation
    @PutMapping(value = "article" )
    public Response editArticle(@RequestBody @Valid ArticleEditVo articleEditVo) {
        return iLaArticleService.editArticle(articleEditVo);
    }

    @ApiOperation(value = "资讯管理端-删除", notes = "资讯管理端-删除")
    @ArticleOperation
    @ApiImplicitParam(value = "主键id",name = "showId" ,required = true,paramType = "path",dataType = "String")
    @DeleteMapping(value = "article/{showId}")
    public Response deleteArticle(@PathVariable String showId) {
        return iLaArticleService.deleteArticle(showId);
    }

    @ApiOperation(value = "资讯管理端-上下线该资讯", notes = "只有状态为下线的资讯才能上线")
    @ArticleOperation
    @PostMapping(value = "articleLine")
    public Response onlineArticle(
            @ApiParam(name = "showId", value = "主键id", required = true) @RequestParam String showId,
            @ApiParam(name = "type", value = "0是上线,1是下线", required = true) @RequestParam Short type
    ) {
        return iLaArticleService.onlineArticle(showId, type);
    }



        public static void main(String[] args) {
            String host = "https://jmfaceip.market.alicloudapi.com";
            String path = "/vehicle/vin-query";
            String method = "POST";
            String appcode = "d8d19719f3fc4454b30982f05da9236a";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            //根据API的要求，定义相对应的Content-Type
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            Map<String, String> querys = new HashMap<String, String>();
            Map<String, String> bodys = new HashMap<String, String>();
            bodys.put("vin", "LBV31FH0XRM724749");


            try {
                /**
                 * 重要提示如下:
                 * HttpUtils请从
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
                 * 下载
                 *
                 * 相应的依赖请参照
                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
                 */
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                //获取response的body
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
