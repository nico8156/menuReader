package com.nm.menureader.acceptance.configuration;

import com.nm.menureader.adapters.InMemoryPlatRepository;
import com.nm.menureader.domain.repositories.PlatRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoriesConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public PlatRepository platRepository(){
        return new InMemoryPlatRepository();
    }
}
