package com.zwr.springboot.springboot_01_cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {

    /**
     * 自定义缓存的生成key
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return (target, method, params) -> method.getName()+"["+ Arrays.asList(params).toString()+"]";
    }
}
