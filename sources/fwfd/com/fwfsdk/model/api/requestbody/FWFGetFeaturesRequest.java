package fwfd.com.fwfsdk.model.api.requestbody;

import fwfd.com.fwfsdk.model.db.FWFUserAttributes;

public class FWFGetFeaturesRequest extends FWFGetFlagRequest {
    private String[] featureList;

    public FWFGetFeaturesRequest(FWFUserAttributes fWFUserAttributes, String[] strArr) {
        super(fWFUserAttributes);
        this.featureList = strArr;
    }

    public String[] getFeatureList() {
        return this.featureList;
    }
}
