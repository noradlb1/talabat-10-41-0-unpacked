package fwfd.com.fwfsdk.model.api;

import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.model.db.FWFResult;
import java.util.HashMap;
import java.util.Map;

public class FWFSubscribeResult {
    private FWFSubscribeCallbackExplanation explanation;
    private Map<String, FWFResult> flags;

    public enum FWFSubscribeCallbackExplanation {
        SINGLE_FLAG_UPDATE(FWFConstants.EXPLANATION_SINGLE_FLAG_UPDATE),
        MULTI_FLAG_UPDATE(FWFConstants.EXPLANATION_MULTI_FLAG_UPDATE),
        BACKGROUND_UPDATE(FWFConstants.EXPLANATION_BACKGROUND_UPDATE);
        
        private String value;

        private FWFSubscribeCallbackExplanation(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public FWFSubscribeResult(Map<String, FWFResult> map, FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation) {
        this.flags = map;
        this.explanation = fWFSubscribeCallbackExplanation;
    }

    public FWFSubscribeCallbackExplanation getExplanation() {
        return this.explanation;
    }

    public Map<String, FWFResult> getFlags() {
        return this.flags;
    }

    public FWFSubscribeResult(String str, FWFResult fWFResult, FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation) {
        this.explanation = fWFSubscribeCallbackExplanation;
        HashMap hashMap = new HashMap();
        this.flags = hashMap;
        hashMap.put(str, fWFResult);
    }
}
