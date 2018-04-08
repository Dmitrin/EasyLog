package logging.easyMdc.annotations;

import logging.easyMdc.EasyMDCConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(EasyMDCConfiguration.class)
@EnableAspectJAutoProxy
public @interface EnableEasyMDC {
}
