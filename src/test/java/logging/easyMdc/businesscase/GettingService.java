package logging.easyMdc.businesscase;

import logging.easyMdc.annotations.EasyMdc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GettingService {

    @Autowired
    private DAO dao;

    @EasyMdc("getting-data")
    public void getSomeData() {

        dao.retrieveSomeData();
    }
}
