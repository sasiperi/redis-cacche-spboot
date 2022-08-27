package com.example.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author sasi.peri
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.example.cache.repository" })
@EnableJpaAuditing
public class JpaConfiguration
{

}
