package fwfd.com.fwfsdk.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class FWFPut {
    @SerializedName("abTest")
    @Expose
    private boolean abtest;
    @SerializedName("explanation")
    @Expose
    private FWFExplanation explanation;
    @SerializedName("holdoutsEvaluations")
    @Expose
    private Map<String, Boolean> holdoutsEvaluations;
    @SerializedName("relevantContext")
    @Expose
    private String relevantContext;
    @SerializedName("trackInfo")
    @Expose
    private FWFTrackInfo trackInfo;
    @SerializedName("variation")
    @Expose
    private Object variation;

    public boolean getAbtest() {
        return this.abtest;
    }

    public FWFExplanation getExplanation() {
        return this.explanation;
    }

    public Map<String, Boolean> getHoldoutsEvaluations() {
        return this.holdoutsEvaluations;
    }

    public String getRelevantContext() {
        return this.relevantContext;
    }

    public FWFTrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    public Object getVariation() {
        return this.variation;
    }
}
