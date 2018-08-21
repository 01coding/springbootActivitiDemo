//package com.zjrodger.config;
//
//import com.zjrodger.modules.app.interceptor.MyInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class SpringMvcConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private MyInterceptor myInterceptor;
//
////    @Bean
////    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
////        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
////        List<MediaType> mediaTypes = new ArrayList<>();
////        mediaTypes.add(MediaType.TEXT_HTML);
////        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
////        jsonConverter.setSupportedMediaTypes(mediaTypes);
////        return jsonConverter;
////    }
////
////    @Bean
////    public StringHttpMessageConverter customerStringHttpMessageConverter() {
////        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
////                Charset.forName("UTF-8"));
////        List<MediaType> mediaTypes = new ArrayList<>();
////        mediaTypes.add(MediaType.TEXT_HTML);
////        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
////        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
////        return stringHttpMessageConverter;
////    }
////
////    @Bean
////    public ResourceHttpMessageConverter customerResourceHttpMessageConverter() {
////        return new ResourceHttpMessageConverter();
////    }
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/templates/**")
////                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
////        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
////        super.addResourceHandlers(registry);
////    }
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor).addPathPatterns("/testController/**");
//    }
//
//}
