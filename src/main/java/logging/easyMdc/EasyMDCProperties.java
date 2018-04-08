package logging.easyMdc;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "easy-mdc")
public class EasyMDCProperties {

    private String stageKey = "stage-key";
    private String timerKey = "execution-time-ns";
    private String timerKeyMs = "execution-time-ms";
    private String depthKey = "stage-depth";

    public String getStageKey() {
        return stageKey;
    }

    public void setStageKey(String stageKey) {
        this.stageKey = stageKey;
    }

    public String getTimerKeyNs() {
        return timerKey;
    }

    public void setTimerKey(String timerKey) {
        this.timerKey = timerKey;
    }

    public String getTimerKeyMs() {
        return timerKeyMs;
    }

    public void setTimerKeyMs(String timerKeyMs) {
        this.timerKeyMs = timerKeyMs;
    }

    public String getDepthKey() {
        return depthKey;
    }

    public void setDepthKey(String depthKey) {
        this.depthKey = depthKey;
    }
}
