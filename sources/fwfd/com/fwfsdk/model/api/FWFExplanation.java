package fwfd.com.fwfsdk.model.api;

import androidx.room.TypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import fwfd.com.fwfsdk.util.FWFStringListConverter;
import java.util.List;

public class FWFExplanation {
    private String error;
    @SerializedName("evalAttrs")
    @Expose
    @TypeConverters({FWFStringListConverter.class})
    private List<String> evaluatedAttributes;
    @SerializedName("evalFlags")
    @Expose
    @TypeConverters({FWFStringListConverter.class})
    private List<String> evaluatedFlags;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("ruleIdx")
    @Expose
    private String ruleIndex;

    public String getError() {
        return this.error;
    }

    public List<String> getEvaluatedAttributes() {
        return this.evaluatedAttributes;
    }

    public List<String> getEvaluatedFlags() {
        return this.evaluatedFlags;
    }

    public String getFrom() {
        return this.from;
    }

    public String getKind() {
        return this.kind;
    }

    public String getRuleIndex() {
        return this.ruleIndex;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setEvaluatedAttributes(List<String> list) {
        this.evaluatedAttributes = list;
    }

    public void setEvaluatedFlags(List<String> list) {
        this.evaluatedFlags = list;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setRuleIndex(String str) {
        this.ruleIndex = str;
    }
}
