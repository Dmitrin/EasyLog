package logging.easyMdc.businesscase;

import logging.easyMdc.annotations.EasyMdc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DAO {

    @EasyMdc("retrieving-data")
    public void retrieveSomeData() {

        log.debug("Getting request to DB...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
