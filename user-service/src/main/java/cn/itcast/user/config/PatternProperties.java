package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 陈超
 * @version 1.0
 */
@Data
@Component
//2、这种就是第二种方式，通过configurationProperties类来使用整个前缀配置文件内容这样整个前缀的配置文件内容都会热更新，企业大多数使用这种方式
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {

    //会根据配置文件的内容自动更新
    private String dateformat;
    
    private String enSharedValue;

}
