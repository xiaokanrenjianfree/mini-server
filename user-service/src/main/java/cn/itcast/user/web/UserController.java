package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import com.netflix.ribbon.proxy.annotation.Http;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import sun.dc.path.PathError;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
//@RefreshScope 1.这里是热刷新的第一种方法，配置了这个注解，该类中用到的的配置文件内容如果发生修改就会更新
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //2.这种就是第二种方式的具体实现
    @Autowired
    private PatternProperties properties;

    @GetMapping("prop")
    public PatternProperties properties()
    {
        return properties;
    }

    @GetMapping("test")//测试filter网关加请求头
    public String test(@RequestHeader(value = "Truth", required = false) String truth)
    {
        System.out.println(truth);
        return " ";
    }

    @GetMapping("now")
    public String now()
    {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
