package com.eliteai.et8080.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis的自动化配置和自动化创建, 没有支持到多模块中，需要我们手动进行配置和创建
 *
 * @author MR.ZHANG
 * @create 2018-08-20 17:16
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScan("com.eliteai.et8080.mapper")
public class MybatisMapperScannerConfig {
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.eliteai.et8080.mapper");
        return mapperScannerConfigurer;
    }
}
