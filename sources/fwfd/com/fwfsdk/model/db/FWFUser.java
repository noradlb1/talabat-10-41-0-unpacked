package fwfd.com.fwfsdk.model.db;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.manager.FWFDataManager;
import fwfd.com.fwfsdk.util.FWFLogger;
import java.util.ArrayList;
import java.util.List;

public class FWFUser {
    private FWFUserAttributes attributes = new FWFUserAttributes();

    private void attributeChange(String str) {
        if (FunWithFlags.getInstance().getContext() != null) {
            FWFDataManager.getInstance().updateFlagsWithRelevantContext(str);
        } else {
            FWFLogger.logError("FunWithFlags: Context is null. User relevant flags not updated.");
        }
    }

    private void attributesChange(List<String> list) {
        if (FunWithFlags.getInstance().getContext() != null) {
            FWFDataManager.getInstance().updateFlagsWithRelevantContext(list);
        } else {
            FWFLogger.logError("FunWithFlags: Context is null. User relevant flags not updated.");
        }
    }

    public void clearCustomAttributes() {
        this.attributes.setCustom(new JsonObject());
    }

    public FWFUserAttributes getAttributes() {
        return this.attributes;
    }

    public JsonObject getCustom() {
        return this.attributes.getCustom();
    }

    public String getEmail() {
        return this.attributes.getEmail();
    }

    public String getGoogleClientId() {
        return this.attributes.getGoogleClientId();
    }

    public JsonObject getTrackingContext() {
        JsonObject jsonObject = new JsonObject();
        for (String next : getCustom().keySet()) {
            jsonObject.addProperty(next, getCustom().get(next).toString());
        }
        jsonObject.addProperty("userId", getUserId());
        jsonObject.addProperty("googleClientId", getGoogleClientId());
        return jsonObject;
    }

    public String getUserId() {
        return this.attributes.getUserId();
    }

    public void removeAttribute(String str) {
        this.attributes.removeAttribute(str);
    }

    public void setAppVersion(String str, String str2) {
        this.attributes.setAppVersion(str, str2);
        attributeChange(str);
    }

    public void setAttribute(String str, String str2) {
        this.attributes.setAttribute(str, str2);
        attributeChange(str);
    }

    public void setAttributes(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList();
        for (String next : jsonObject.keySet()) {
            JsonElement jsonElement = jsonObject.get(next);
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isBoolean()) {
                    this.attributes.setAttribute(next, asJsonPrimitive.getAsBoolean());
                    arrayList.add(next);
                } else if (asJsonPrimitive.isNumber()) {
                    this.attributes.setAttribute(next, asJsonPrimitive.getAsFloat());
                    arrayList.add(next);
                } else if (asJsonPrimitive.isString()) {
                    this.attributes.setAttribute(next, asJsonPrimitive.getAsString());
                    arrayList.add(next);
                }
            } else if (jsonElement.isJsonNull() && this.attributes.existAttributeWithValue(next)) {
                this.attributes.removeAttribute(next);
                arrayList.add(next);
            }
        }
        attributesChange(arrayList);
    }

    public void setCustom(JsonObject jsonObject) {
        this.attributes.setCustom(jsonObject);
    }

    public void setEmail(String str) {
        this.attributes.setEmail(str);
        attributeChange("email");
    }

    public void setGoogleClientId(String str) {
        this.attributes.setGoogleClientId(str);
        attributeChange("googleClientId");
    }

    public void setIpAddress(String str, String str2) {
        this.attributes.setIpAddress(str, str2);
        attributeChange(str);
    }

    public void setUserId(String str) {
        this.attributes.setUserId(str);
        attributeChange("userId");
    }

    public void setAppVersion(String str) {
        this.attributes.setAttribute("appVersion", str);
        attributeChange("appVersion");
    }

    public void setAttribute(String str, boolean z11) {
        this.attributes.setAttribute(str, z11);
        attributeChange(str);
    }

    public void setIpAddress(String str) {
        this.attributes.setAttribute(FWFConstants.USER_ATTRIBUTE_IP_ADDRESS, str);
        attributeChange(FWFConstants.USER_ATTRIBUTE_IP_ADDRESS);
    }

    public void setAttribute(String str, float f11) {
        this.attributes.setAttribute(str, f11);
        attributeChange(str);
    }

    public void setAttribute(String str, int i11) {
        this.attributes.setAttribute(str, i11);
        attributeChange(str);
    }
}
