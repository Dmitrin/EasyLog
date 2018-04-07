package logging.easyMdc.config;

import logging.easyMdc.services.EasyMdcAnnotationHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyMDCConfiguration {

    @Bean
    public EasyMdcAnnotationHandlerBeanPostProcessor easyMdcAnnotationHandlerBeanPostProcessor() {
        return new EasyMdcAnnotationHandlerBeanPostProcessor();
    }

}
