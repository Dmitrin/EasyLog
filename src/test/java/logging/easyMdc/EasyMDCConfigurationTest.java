package logging.easyMdc;

import logging.easyMdc.annotations.EnableEasyMDC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EasyMDCConfigurationTest.TestConfig.class})
public class EasyMDCConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Configuration
    @EnableEasyMDC
    static class TestConfig{
        @Bean
        public LogSomething doSomething(){
            return new LogSomething();
        }
    }

    @Autowired
    EasyMDCProperties properties;

    @Test
    public void testEasyMdcMethodMDCKey() {

        applicationContext.getBean(LogSomething.class).doSomething(mdcAdapter -> {
            assertEquals(
                    "doSomething",
                    mdcAdapter.get(properties.getStageKey())
            );
        });

        assertEquals(MDC.get(properties.getStageKey()), null);
    }

}