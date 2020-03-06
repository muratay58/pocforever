package com.ayceay.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.ayceay.repo"})
@EntityScan(basePackages = {"com.ayceay.entities"})
public class LogisticConfiguration extends PocForeverConfigurationClass{
}
