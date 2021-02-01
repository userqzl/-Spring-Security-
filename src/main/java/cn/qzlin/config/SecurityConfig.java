package cn.qzlin.config;

import cn.qzlin.handler.MyFailureHandler;
import cn.qzlin.handler.MySuccessHandler;
import cn.qzlin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @description: 安全配置类
 * @author: qzl
 * @created: 2021/02/01 11:04
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    MySuccessHandler mySuccessHandler;

    @Autowired
    MyFailureHandler myFailureHandler;

    @Autowired
    AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //指定自定义认证服务类
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //认证
        http.formLogin()
                //登录参数
                .usernameParameter("username")
                .passwordParameter("password")
                //登录url
                .loginProcessingUrl("/login")
                //登录成功处理器
                .successHandler(mySuccessHandler)
                //登录失败处理器
                .failureHandler(myFailureHandler);

        //授权
        http.authorizeRequests()
                //登录放行
                .antMatchers("/login").permitAll()
                //查询所有图书需要查询权限
                .antMatchers("/allBooks").hasAuthority("find_all_book")
                //添加图书需要管理员权限
                .antMatchers("/addBook").hasAuthority("add_book")
                //所有请求都要认证
                .anyRequest().authenticated();
        //403
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);

        //关闭csrf
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }
}
