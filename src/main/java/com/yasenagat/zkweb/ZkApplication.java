package com.yasenagat.zkweb;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/*@ImportResource(locations = { "classpath:spring/appServlet/servlet-context.xml" })*/
public class ZkApplication {

/*	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
				AnnotationJerseyConfig.class.getName());
		return registration;
	}
*/
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ZkApplication.class);
		// app.setAddCommandLineProperties(false);
		// app.addListeners(new MyAppListener());
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
		// SpringApplication.run(SampleTomcatSslApplication.class, args);

	}

}