package com.nm.menureader.acceptance.configuration;

import com.nm.menureader.adapters.FakeOpenAiService;
import com.nm.menureader.domain.repositories.PlatRepository;
import com.nm.menureader.domain.services.AnalyseMenuService;
import com.nm.menureader.domain.services.OpenAiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServicesConfiguration {


    @Bean
    @Scope("cucumber-glue")
    public OpenAiService openAiService(){
        return new FakeOpenAiService();
    }
}
