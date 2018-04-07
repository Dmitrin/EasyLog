package logging.easyMdc.config;

import logging.easyMdc.annotations.EasyMdc;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class LogSomething implements DoSomething {

    @EasyMdc
    public void doSomething() {
        log.debug("1");

        System.out.println("Diagnostic MDC content : " + MDC.get("it works"));

        System.out.println("Did something!");

        log.debug("2");
    }
}
