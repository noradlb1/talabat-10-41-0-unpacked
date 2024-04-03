package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;

public class ApplicationInfo extends HarvestableObject {
    private String applicationBuild = "";
    private String applicationName = "";
    private String applicationVersion = "";
    private String bundleId = "";
    private int processId = 0;

    public ApplicationInfo() {
    }

    public static ApplicationInfo newFromJson(JsonObject jsonObject) {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.applicationName = jsonObject.get(AnalyticsAttribute.APP_NAME_ATTRIBUTE).getAsString();
        applicationInfo.applicationVersion = jsonObject.get("appVersion").getAsString();
        applicationInfo.applicationBuild = jsonObject.get("appBuild").getAsString();
        applicationInfo.bundleId = jsonObject.get(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID).getAsString();
        applicationInfo.processId = jsonObject.get("processId").getAsInt();
        return applicationInfo;
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(AnalyticsAttribute.APP_NAME_ATTRIBUTE, SafeJsonPrimitive.factory(this.applicationName));
        jsonObject.add("appVersion", SafeJsonPrimitive.factory(this.applicationVersion));
        jsonObject.add("appBuild", SafeJsonPrimitive.factory(this.applicationBuild));
        jsonObject.add(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID, SafeJsonPrimitive.factory(this.bundleId));
        jsonObject.add("processId", SafeJsonPrimitive.factory((Number) Integer.valueOf(this.processId)));
        return jsonObject;
    }

    public String getApplicationBuild() {
        return this.applicationBuild;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getApplicationVersion() {
        return this.applicationVersion;
    }

    public ApplicationInfo(ApplicationInformation applicationInformation) {
        this.applicationName = applicationInformation.getAppName();
        this.applicationVersion = applicationInformation.getAppVersion();
        this.applicationBuild = applicationInformation.getAppBuild();
        this.bundleId = applicationInformation.getPackageId();
    }
}
