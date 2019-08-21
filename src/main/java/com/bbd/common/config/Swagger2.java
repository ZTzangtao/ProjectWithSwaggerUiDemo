package com.bbd.common.config;


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.bbd.common.annotation.ArticleOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 臧涛
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	/**
	 * 以下是使用swagger2 生成api文档
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.bbd.core.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 构建 api文档的详细信息函数
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("临安文化馆")
				//描述
				.description("临安文化馆")
				.termsOfServiceUrl("http://localhost:8085/swagger-ui.html")
				//版本
				.version("1.0")
				.build();
	}

	@Bean
	public Docket rticleRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("资讯")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ArticleOperation.class))
				.paths(PathSelectors.any())
				.build();
	}

//	@Bean
//	public Docket userApi() {
//		List<ResponseMessage> responseMessageList = new ArrayList<>();
//		responseMessageList.add(new ResponseMessageBuilder().code(1008).message("请求参数缺失").responseModel(new ModelRef("Response")).build());
//		responseMessageList.add(new ResponseMessageBuilder().code(409).message("业务逻辑异常").responseModel(new ModelRef("Response")).build());
//		responseMessageList.add(new ResponseMessageBuilder().code(422).message("参数校验异常").responseModel(new ModelRef("Response")).build());
//		responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("Response")).build());
//		responseMessageList.add(new ResponseMessageBuilder().code(503).message("Hystrix异常").responseModel(new ModelRef("Response")).build());
//
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.globalResponseMessage(RequestMethod.GET, responseMessageList)
//				.globalResponseMessage(RequestMethod.POST, responseMessageList)
//				.globalResponseMessage(RequestMethod.PUT, responseMessageList)
//				.globalResponseMessage(RequestMethod.DELETE, responseMessageList)
//				.build();
//	}

}
