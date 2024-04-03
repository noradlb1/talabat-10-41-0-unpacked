package fwfd.com.fwfsdk.model.db;

import android.util.Patterns;
import com.google.gson.JsonObject;
import fwfd.com.fwfsdk.util.FWFHelper;
import fwfd.com.fwfsdk.util.FWFLogger;

public class FWFUserAttributes {
    private JsonObject custom = new JsonObject();
    private String email;
    private String googleClientId;
    private String userId;

    public FWFUserAttributes() {
        setFwFCustomAttributes();
    }

    private void setFwFCustomAttributes() {
        this.custom.addProperty(FWFHelper.FWF_OS_VERSION_KEY, FWFHelper.fwfOSVersion);
        this.custom.addProperty(FWFHelper.FWF_DEVICE_OS_KEY, "android");
    }

    public boolean existAttributeWithValue(String str) {
        for (String equals : this.custom.keySet()) {
            if (str.equals(equals)) {
                if (this.custom.get(str) != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public JsonObject getCustom() {
        return this.custom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGoogleClientId() {
        return this.googleClientId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void removeAttribute(String str) {
        if (!str.equals(FWFHelper.FWF_OS_VERSION_KEY) && !str.equals(FWFHelper.FWF_DEVICE_OS_KEY)) {
            this.custom.remove(str);
        }
    }

    public void setAppVersion(String str, String str2) {
        if (this.custom != null) {
            if (!Patterns.IP_ADDRESS.matcher(str2).matches()) {
                FWFLogger.logError("Format Error AppVersion");
            }
            this.custom.addProperty(str, str2);
        }
    }

    public void setAttribute(String str, String str2) {
        if (this.custom != null) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -836030906:
                    if (str.equals("userId")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1360113567:
                    if (str.equals("googleClientId")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    setUserId(str2);
                    return;
                case 1:
                    setEmail(str2);
                    return;
                case 2:
                    setGoogleClientId(str2);
                    return;
                default:
                    this.custom.addProperty(str, str2);
                    return;
            }
        }
    }

    public void setCustom(JsonObject jsonObject) {
        this.custom = jsonObject;
        setFwFCustomAttributes();
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setGoogleClientId(String str) {
        this.googleClientId = str;
    }

    public void setIpAddress(String str, String str2) {
        if (this.custom != null) {
            if (!Patterns.IP_ADDRESS.matcher(str2).matches()) {
                FWFLogger.logError("Format error IP");
            }
            this.custom.addProperty(str, str2);
        }
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setAttribute(String str, boolean z11) {
        JsonObject jsonObject = this.custom;
        if (jsonObject != null) {
            jsonObject.addProperty(str, Boolean.valueOf(z11));
        }
    }

    public void setAttribute(String str, float f11) {
        JsonObject jsonObject = this.custom;
        if (jsonObject != null) {
            jsonObject.addProperty(str, (Number) Float.valueOf(f11));
        }
    }

    public void setAttribute(String str, int i11) {
        JsonObject jsonObject = this.custom;
        if (jsonObject != null) {
            jsonObject.addProperty(str, (Number) Integer.valueOf(i11));
        }
    }
}
