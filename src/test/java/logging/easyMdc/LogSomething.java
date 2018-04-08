package logging.easyMdc;

import logging.easyMdc.annotations.EasyMdc;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

import java.util.function.Consumer;

@Slf4j
public class LogSomething {

    @EasyMdc
    public void doSomething(Consumer<MDCAdapter> testSome) {

        log.info("Log message");
        testSome.accept(MDC.getMDCAdapter());
    }
}
