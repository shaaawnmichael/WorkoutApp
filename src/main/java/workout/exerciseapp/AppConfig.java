package workout.exerciseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import workout.exerciseapp.services.JwtFilter;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private JwtFilter myfilter;

    @Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/api/**");
	}     

	@Bean
	public FilterRegistrationBean<JwtFilter> registerJwtFilter(JwtFilter filter) {

		FilterRegistrationBean<JwtFilter> regFilterBean = new FilterRegistrationBean<>();
		regFilterBean.setFilter(filter);
		regFilterBean.addUrlPatterns("/secure/*");
		regFilterBean.setEnabled(true);

		return regFilterBean;
	}
    
}
