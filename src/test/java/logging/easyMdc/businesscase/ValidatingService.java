package logging.easyMdc.businesscase;

import logging.easyMdc.annotations.EasyMdc;
import org.springframework.stereotype.Component;

@Component
public class ValidatingService {

    @EasyMdc("validate-data")
    public void someDataValidate() {

    }
}
