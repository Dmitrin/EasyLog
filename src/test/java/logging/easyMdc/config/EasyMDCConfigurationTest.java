package logging.easyMdc.config;

import logging.easyMdc.annotations.EnableEasyMDC;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EasyMDCConfigurationTest.TestConfig.class})
public class EasyMDCConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Configuration
    @EnableEasyMDC
    static class TestConfig{
        @Bean
        public DoSomething doSomething(){
            return new LogSomething();
        }
    }

    @Test
    public void easyMdcAnnotationHandlerBeanPostProcessor() {

        applicationContext.getBean(DoSomething.class).doSomething();

        // Проверка корректности удаления
        System.out.println("Diagnostic MDC content CLEAR: " + MDC.get("it works"));

        Assert.assertEquals(MDC.get("it works"), null);
    }

    @Test
    public void AddAndRemoveMdcTenTimes() {

        for (int i = 0; i<10; i++) {
            System.out.println("Try number: " + i);
            applicationContext.getBean(DoSomething.class).doSomething();
        }

        // Проверка корректности удаления
        System.out.println("Diagnostic MDC content CLEAR: " + MDC.get("it works"));

        Assert.assertEquals(MDC.get("it works"), null);
    }
}