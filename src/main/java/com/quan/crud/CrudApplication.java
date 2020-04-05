package com.quan.crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableRabbit   //开启基于注解的rabbitmq  @EnableRabbit+@RabbitListener  监听消息队列里的内容
@MapperScan("com.quan.crud.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

//    @Bean
//    public HttpMessageConverters fastjsonHttpMessageConverters(){
//        //1.定义一个消息转换对象convert
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        //2.添加fastjson配置信息，是否需要格式化
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //3.在convert添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters(fastConverter);
//    }

}
