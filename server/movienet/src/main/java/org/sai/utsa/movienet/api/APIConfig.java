package org.sai.utsa.movienet.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"org.sai.utsa.movienet.api","org.sai.utsa.movienet.api.repository","org.sai.utsa.movienet.api.entity","org.sai.utsa.movienet.api.service","org.sai.utsa.movienet.api.controller"})
@EnableWebMvc
public class APIConfig {
	
}
