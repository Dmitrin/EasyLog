package logging.easyMdc;

import logging.easyMdc.annotations.EasyMdc;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

@Aspect
public class EasyMDCAspect {

    Logger log = LoggerFactory.getLogger(EasyMDCAspect.class);

    private EasyMDCProperties properties;

    @Autowired
    public EasyMDCAspect(EasyMDCProperties properties) {
        this.properties = properties;
    }

    @Around("@annotation(easyMdc)")
    public Object around(ProceedingJoinPoint pjp, EasyMdc easyMdc) throws Throwable {

        Optional<String> oldStage = Optional.ofNullable(MDC.get(properties.getStageKey()));
        Optional<Integer> oldDepth = Optional.ofNullable(
                MDC.get(properties.getDepthKey())
        ).map(Integer::valueOf);

        String currentStageName = Objects.equals(easyMdc.value(), "") ?
                pjp.getSignature().getName() : easyMdc.value();

        MDC.put(
                properties.getStageKey(),
                oldStage
                        .map(s -> s+".")
                        .orElse("") + currentStageName
        );

        MDC.put(
                properties.getDepthKey(),
                String.valueOf(oldDepth.orElse(0)+1)
        );

        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());

        StringBuilder prefix = buildInPrefix(oldDepth.orElse(0) + 1);
        logger.debug(prefix+"Start stage: " + currentStageName);

        long start = System.nanoTime();

        Object result = pjp.proceed();

        long finish = System.nanoTime();

        MDC.put(properties.getTimerKeyNs(), String.valueOf(finish-start));
        MDC.put(properties.getTimerKeyMs(), String.valueOf((finish-start)/1000000));

        prefix = buildOutPrefix(oldDepth.orElse(0) + 1);
        logger.debug(prefix+"Finish stage: " + currentStageName);

        MDC.remove(properties.getTimerKeyNs());
        MDC.put(properties.getStageKey(), oldStage.orElse(null));
        MDC.put(
                properties.getDepthKey(),
                String.valueOf(oldDepth.orElse(0))
        );

        return result;
    }

    private StringBuilder buildOutPrefix(int depth) {
        StringBuilder prefix = new StringBuilder();

        for (int i = 1; i < depth-1; i++) {
            prefix.append("== ");
        }
        prefix.append("<| ");
        return prefix;
    }

    private StringBuilder buildInPrefix(Integer depth) {
        StringBuilder prefix = new StringBuilder();

        for (int i = 1; i < depth; i++) {
            prefix.append("== ");
        }
        prefix.append("|> ");
        return prefix;
    }

}
