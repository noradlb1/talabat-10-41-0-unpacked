package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ApplicationInformation extends HarvestableArray {
    private String appBuild;
    private String appName;
    private String appVersion;
    private String packageId;
    private int versionCode;

    public ApplicationInformation() {
        this.versionCode = -1;
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notEmpty(this.appName);
        jsonArray.add((JsonElement) new JsonPrimitive(this.appName));
        notEmpty(this.appVersion);
        jsonArray.add((JsonElement) new JsonPrimitive(this.appVersion));
        notEmpty(this.packageId);
        jsonArray.add((JsonElement) new JsonPrimitive(this.packageId));
        return jsonArray;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApplicationInformation applicationInformation = (ApplicationInformation) obj;
        String str = this.appName;
        if (str == null ? applicationInformation.appName != null : !str.equals(applicationInformation.appName)) {
            return false;
        }
        String str2 = this.appVersion;
        if (str2 == null ? applicationInformation.appVersion != null : !str2.equals(applicationInformation.appVersion)) {
            return false;
        }
        String str3 = this.appBuild;
        if (str3 == null ? applicationInformation.appBuild != null : !str3.equals(applicationInformation.appBuild)) {
            return false;
        }
        String str4 = this.packageId;
        if (str4 == null ? applicationInformation.packageId != null : !str4.equals(applicationInformation.packageId)) {
            return false;
        }
        if (this.versionCode != applicationInformation.versionCode) {
            return false;
        }
        return true;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        String str = this.appName;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = i11 * 31;
        String str2 = this.appVersion;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        String str3 = this.appBuild;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i17 = (i16 + i13) * 31;
        String str4 = this.packageId;
        if (str4 != null) {
            i14 = str4.hashCode();
        }
        return i17 + i14;
    }

    public boolean isAppUpgrade(ApplicationInformation applicationInformation) {
        int i11 = applicationInformation.versionCode;
        if (i11 == -1) {
            if (this.versionCode >= 0 && applicationInformation.appVersion != null) {
                return true;
            }
        } else if (this.versionCode > i11) {
            return true;
        }
        return false;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setVersionCode(int i11) {
        this.versionCode = i11;
    }

    public ApplicationInformation(String str, String str2, String str3, String str4) {
        this();
        this.appName = str;
        this.appVersion = str2;
        this.packageId = str3;
        this.appBuild = str4;
    }
}
