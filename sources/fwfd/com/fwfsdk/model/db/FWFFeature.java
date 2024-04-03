package fwfd.com.fwfsdk.model.db;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.model.api.FWFExplanation;
import fwfd.com.fwfsdk.model.api.FWFPut;
import fwfd.com.fwfsdk.model.api.FWFTrackInfo;
import fwfd.com.fwfsdk.util.FWFAnyConverter;
import fwfd.com.fwfsdk.util.FWFMapConverter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Entity(primaryKeys = {"key", "accessToken"}, tableName = "FWFFeature")
public class FWFFeature {
    private boolean abTest;
    @NonNull
    private String accessToken;
    private long date;
    @Embedded
    private FWFExplanation explanation;
    @TypeConverters({FWFMapConverter.class})
    private Map<String, Boolean> holdoutsEvaluations;
    @NonNull
    private String key;
    private String relevantContext;
    private int subscribe;
    @Embedded
    private FWFTrackInfo trackInfo;
    @TypeConverters({FWFAnyConverter.class})
    private Object variation;

    public FWFFeature() {
    }

    public boolean equals(Object obj) {
        return getKey().equals(((FWFFeature) obj).getKey());
    }

    public boolean getAbTest() {
        return this.abTest;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getDate() {
        return this.date;
    }

    public FWFExplanation getExplanation() {
        return this.explanation;
    }

    public Map<String, Boolean> getHoldoutsEvaluations() {
        return this.holdoutsEvaluations;
    }

    public String getKey() {
        return this.key;
    }

    public String getRelevantContext() {
        return this.relevantContext;
    }

    public int getSubscribe() {
        return this.subscribe;
    }

    public FWFTrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    public Object getVariation() {
        return this.variation;
    }

    public boolean requiresUpdate() {
        if (TimeUnit.MILLISECONDS.toMinutes(Math.abs(System.currentTimeMillis() - this.date)) > TimeUnit.SECONDS.toMinutes(FunWithFlags.getInstance().getFeatureExpirationTime().longValue())) {
            return true;
        }
        return false;
    }

    public void setAbTest(boolean z11) {
        this.abTest = z11;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setExplanation(FWFExplanation fWFExplanation) {
        this.explanation = fWFExplanation;
    }

    public void setHoldoutsEvaluations(Map<String, Boolean> map) {
        this.holdoutsEvaluations = map;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRelevantContext(String str) {
        this.relevantContext = str;
    }

    public void setSubscribe(int i11) {
        this.subscribe = i11;
    }

    public void setTrackInfo(FWFTrackInfo fWFTrackInfo) {
        this.trackInfo = fWFTrackInfo;
    }

    public void setVariation(Object obj) {
        this.variation = obj;
    }

    public FWFResult toFWFResult() {
        return new FWFResult(this.variation, this.abTest, this.explanation, this.trackInfo, this.holdoutsEvaluations);
    }

    public FWFFeature(String str, FWFPut fWFPut, int i11, String str2) {
        this.key = str;
        this.variation = fWFPut.getVariation();
        this.abTest = fWFPut.getAbtest();
        this.accessToken = str2;
        this.trackInfo = fWFPut.getTrackInfo();
        this.relevantContext = fWFPut.getRelevantContext();
        this.explanation = fWFPut.getExplanation();
        this.date = System.currentTimeMillis();
        this.holdoutsEvaluations = fWFPut.getHoldoutsEvaluations();
        this.subscribe = i11;
    }

    public FWFFeature(String str, FWFPut fWFPut, String str2) {
        this.key = str;
        this.variation = fWFPut.getVariation();
        this.abTest = fWFPut.getAbtest();
        this.accessToken = str2;
        this.trackInfo = fWFPut.getTrackInfo();
        this.relevantContext = fWFPut.getRelevantContext();
        this.explanation = fWFPut.getExplanation();
        this.date = System.currentTimeMillis();
        this.holdoutsEvaluations = fWFPut.getHoldoutsEvaluations();
    }
}
