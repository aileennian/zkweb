package com.yasenagat.zkweb;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 *  WebMvcConfigurationSupport
 * @author admin
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {// org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter{

	
	
	
	/**
	 * this is a method of the WebMvcConfigurerAdapter.class we can override the
	 * default value/achievements of spring boot and customize our own
	 * HttpMessageConverters.
	 * 
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		/*
		 * using the StringHttpMessageConverter to handle with simple String
		 * message.
		 */

		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(stringConverter);
		/*
		 * using the FastJsonHttpMessageConverter to handle these below. 1.
		 * text/html;charset=UTF-8 a page(htm/html/jsp etc.) 2.
		 * application/json;charset=utf-8 json data type response 3.
		 * text/plain;charset=UTF-8 a text or string etc. 4.
		 * application/x-www-form-urlencoded;charset=utf-8 standard encoding
		 * type. convert form data to a key-value. ...
		 */
		//FastJsonHttpMessageConverter4 fastJsonConverter = new FastJsonHttpMessageConverter4();
		FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
		
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName("UTF-8"));
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);

		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		MediaType text_plain = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		MediaType text_html = new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8"));
		MediaType x_www_form_urlencoded_utf8 = new MediaType(MediaType.APPLICATION_FORM_URLENCODED,Charset.forName("UTF-8"));
		
		supportedMediaTypes.add(text_html);
		supportedMediaTypes.add(text_plain);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(x_www_form_urlencoded_utf8);

		fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(fastJsonConverter);
		super.configureMessageConverters(converters);

	}
	
	
	

}
