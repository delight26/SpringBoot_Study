package info.thecodinglive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import info.thecodinglive.ExcuteTimeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public ExcuteTimeInterceptor excuteTimeInterceptor() {
		return new ExcuteTimeInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(excuteTimeInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/templates/**")
				.addResourceLocations("classpath:/templates/","/templates/");
		registry.addResourceHandler("/assets/**")
			.addResourceLocations("classpath:/assets/","/assets/")
			.setCachePeriod(3600)
			.resourceChain(true)
			.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
}
