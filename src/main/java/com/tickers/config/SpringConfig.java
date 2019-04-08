package com.tickers.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@Configuration
@EnableCaching
public class SpringConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public CacheManager cacheManager() {
        return new GuavaCacheManager("tickers", "stockData");
    }

//    @Bean
//    public CacheManager cacheManager() {
//        return new EhCacheCacheManager(cacheMangerFactory().getObject());
//    }

//    @Bean
//    public EhCacheManagerFactoryBean cacheMangerFactory() {
//        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
//        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        bean.setShared(true);
//        return bean;
//    }
}
