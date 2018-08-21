package com.eliteai.et8080.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * mybatis的自动化配置和自动化创建, 没有支持到多模块中，需要我们手动进行配置和创建
 *
 * @author MR.ZHANG
 * @create 2018-08-20 17:04
 */
@Configuration
public class MybatisConfig {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${mybatis.config-location}")
    private String mapperLocationPattern;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){return new com.alibaba.druid.pool.DruidDataSource();
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        logger.error("wesker mapperLocationPattern : " + mapperLocationPattern);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            //设置驼峰命名规则
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}
