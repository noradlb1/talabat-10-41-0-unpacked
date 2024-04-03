package fwfd.com.fwfsdk.model.api.requestbody;

import com.google.gson.JsonObject;
import fwfd.com.fwfsdk.model.db.FWFUserAttributes;

public class FWFGetFlagRequest {
    private JsonObject custom;
    private String email;
    private String googleClientId;
    private String userId;

    public FWFGetFlagRequest(FWFUserAttributes fWFUserAttributes) {
        this.googleClientId = fWFUserAttributes.getGoogleClientId();
        this.userId = fWFUserAttributes.getUserId();
        this.email = fWFUserAttributes.getEmail();
        this.custom = fWFUserAttributes.getCustom();
    }
}
