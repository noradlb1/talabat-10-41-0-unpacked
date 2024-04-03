package fwfd.com.fwfsdk.model.api;

import androidx.room.TypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import fwfd.com.fwfsdk.util.FWFAnyConverter;
import fwfd.com.fwfsdk.util.FWFStringListConverter;
import java.util.List;

public class FWFTrackInfo {
    @SerializedName("flagEnabled")
    @Expose
    private Boolean flagEnabled;
    @SerializedName("flagType")
    @Expose
    private String flagType;
    @TypeConverters({FWFStringListConverter.class})
    private List<String> trackerServices;
    @SerializedName("variationName")
    @Expose
    @TypeConverters({FWFAnyConverter.class})
    private Object variationName;

    public Boolean getFlagEnabled() {
        return this.flagEnabled;
    }

    public String getFlagType() {
        return this.flagType;
    }

    public List<String> getTrackerServices() {
        return this.trackerServices;
    }

    public Object getVariationName() {
        return this.variationName;
    }

    public void setFlagEnabled(Boolean bool) {
        this.flagEnabled = bool;
    }

    public void setFlagType(String str) {
        this.flagType = str;
    }

    public void setTrackerServices(List<String> list) {
        this.trackerServices = list;
    }

    public void setVariationName(Object obj) {
        this.variationName = obj;
    }
}
