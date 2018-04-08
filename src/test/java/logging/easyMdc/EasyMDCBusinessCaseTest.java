package logging.easyMdc;

import logging.easyMdc.annotations.EnableEasyMDC;
import logging.easyMdc.businesscase.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EasyMDCBusinessCaseTest.TestConfig.class})
public class EasyMDCBusinessCaseTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Configuration
    @EnableEasyMDC
    @ComponentScan("logging.easyMdc.businesscase")
    static class TestConfig{
    }

    @Autowired
    EasyMDCProperties properties;

    @Test
    public void testEasyMdcMethodMDCKey() {

        applicationContext.getBean(Controller.class).businessCaseMethod();

    }

}