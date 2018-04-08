package logging.easyMdc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyMDCConfiguration {

    @Bean
    EasyMDCAspect easyMDCAspect(EasyMDCProperties properties){
        return new EasyMDCAspect(properties);
    }

    @Bean
    EasyMDCProperties properties(){
        return new EasyMDCProperties();
    }
}
