package com.henu.main.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfiguration {

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}

	@Bean
	public ServletRegistrationBean druidStatViewServlet() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		registrationBean.addInitParameter("loginUsername", "admin");
		registrationBean.addInitParameter("loginPassword", "admin123456");
		registrationBean.addInitParameter("resetEnable", "false");
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean druidWebStatViewFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
		registrationBean.addInitParameter("urlPatterns", "/*");
		registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		return registrationBean;
	}
}
