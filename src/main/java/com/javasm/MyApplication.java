package com.javasm;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//SpringBootApplication注解相当于
// @Configuration、@EnableAutoConfiguration和@ComponentScan三个注解的合集
@SpringBootApplication
@MapperScan("com.javasm.mapper") // 扫描 mapper接口 扫描到的接口会自动交给 Spring 管理
@EnableTransactionManagement // 开启事务管理
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());

        // 添加乐观锁插件的拦截器
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
