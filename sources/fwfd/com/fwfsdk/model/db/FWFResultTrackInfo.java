package fwfd.com.fwfsdk.model.db;

import java.util.List;

public class FWFResultTrackInfo {
    private Boolean flagEnabled;
    private String flagType;
    private List<String> trackerServices;
    private Object variationName;

    public FWFResultTrackInfo(Object obj, String str, Boolean bool, List<String> list) {
        this.variationName = obj;
        this.flagType = str;
        this.flagEnabled = bool;
        this.trackerServices = list;
    }

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
}
