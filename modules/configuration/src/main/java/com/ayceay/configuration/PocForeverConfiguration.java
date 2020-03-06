package com.ayceay.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"com.ayceay"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = PocForeverConfigurationClass.class),
        }
)
// TODO : Her modülün kendi Configuration class'ı olusturulması ve EnableFeignClient tanımlamalarının orada olusturulması gerekiyor.
public class PocForeverConfiguration {
}

