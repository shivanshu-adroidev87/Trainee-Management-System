package com.nucleus.project.configuration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.nucleus.project")
public class BatchTraineeConfigure implements WebMvcConfigurer {
}
