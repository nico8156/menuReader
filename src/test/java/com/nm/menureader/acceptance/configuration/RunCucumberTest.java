package com.nm.menureader.acceptance.configuration;

import com.nm.menureader.MenureaderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = MenureaderApplication.class)
public class RunCucumberTest {
}
