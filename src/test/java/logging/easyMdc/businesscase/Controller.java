package logging.easyMdc.businesscase;


import logging.easyMdc.annotations.EasyMdc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Controller {

    @Autowired
    private GettingService gettingService;

    @Autowired
    private ComputingService computeService;

    @Autowired
    private ValidatingService validateService;

    @EasyMdc("test-case")
    public void businessCaseMethod(){

        gettingService.getSomeData();

        computeService.someDataCompute();

//        log.debug("We get some data here...");

        validateService.someDataValidate();

//        log.debug("Business successful executed...");

    }
}
