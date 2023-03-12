package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author 陈超
 * @version 1.0
 */
//这里是通过类来配置fegin的日志级别
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level loglevel()
    {
        return Logger.Level.BASIC;
    }
}
