package logging.easyMdc.businesscase;

import logging.easyMdc.annotations.EasyMdc;
import org.springframework.stereotype.Component;

@Component
public class ComputingService {

    @EasyMdc("compute-data")
    public void someDataCompute() {

    }
}
