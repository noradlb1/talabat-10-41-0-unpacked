package fwfd.com.fwfsdk.tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FWFFlagData {
    private Map<String, String> customAttributes = new HashMap();
    private String explanation;
    private String featureKey;
    private Object featureVariation;
    private Boolean isABTest;
    private List<String> trackers;

    public FWFFlagData(String str, Object obj, Boolean bool, List<String> list, String str2, Map<String, String> map) {
        this.featureKey = str;
        this.featureVariation = obj;
        this.isABTest = bool;
        this.trackers = list;
        this.explanation = str2;
        if (map != null) {
            this.customAttributes = map;
        }
    }

    public Boolean getABTest() {
        return this.isABTest;
    }

    public Map<String, String> getCustomAttributes() {
        return this.customAttributes;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public String getFeatureKey() {
        return this.featureKey;
    }

    public Object getFeatureVariation() {
        return this.featureVariation;
    }

    public List<String> getTrackers() {
        return this.trackers;
    }
}
