package info.thecodinglive.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}
	
	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("JPub Spring Boot")
				.description("Spring Boot Rest API")
				.version("1.0")
				.build();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/basic/.*"))
				.build()
				.apiInfo(metadata());
	}
	
	@Bean
	public HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clienthttpRequestFactory =  new HttpComponentsClientHttpRequestFactory();
		
		clienthttpRequestFactory.setConnectionRequestTimeout(5000);
		clienthttpRequestFactory.setReadTimeout(5000);
		
		return clienthttpRequestFactory;
	}
	
	@Bean
	public ClientHttpRequestFactory getRequestConfigHttpRequestFactory() {
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(5000)
				.setConnectionRequestTimeout(5000)
				.setSocketTimeout(5000)
				.build();
		CloseableHttpClient httpClient = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
		
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}
}