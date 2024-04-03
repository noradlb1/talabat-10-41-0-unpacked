package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Iterator;

public class DeviceInfo extends HarvestableObject {
    private String OSBuild;
    private String OSVersion;
    private String architecture;
    private String deviceName;
    private String deviceUuid;
    private long[] diskAvailable;
    private long memoryUsage;
    private String modelNumber;
    private String networkStatus;
    private int orientation;
    private String runTime;
    private String screenResolution;

    public DeviceInfo() {
    }

    private JsonArray getDiskAvailableAsJson() {
        JsonArray jsonArray = new JsonArray();
        for (long valueOf : this.diskAvailable) {
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(valueOf)));
        }
        return jsonArray;
    }

    private static long[] longArrayFromJsonArray(JsonArray jsonArray) {
        long[] jArr = new long[jsonArray.size()];
        Iterator<JsonElement> it = jsonArray.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            jArr[i11] = it.next().getAsLong();
            i11++;
        }
        return jArr;
    }

    public static DeviceInfo newFromJson(JsonObject jsonObject) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.memoryUsage = jsonObject.get("memoryUsage").getAsLong();
        deviceInfo.orientation = jsonObject.get("orientation").getAsInt();
        deviceInfo.networkStatus = jsonObject.get("networkStatus").getAsString();
        deviceInfo.diskAvailable = longArrayFromJsonArray(jsonObject.get("diskAvailable").getAsJsonArray());
        deviceInfo.OSVersion = jsonObject.get(AnalyticsAttribute.OS_VERSION_ATTRIBUTE).getAsString();
        deviceInfo.deviceName = jsonObject.get("deviceName").getAsString();
        deviceInfo.OSBuild = jsonObject.get(AnalyticsAttribute.OS_BUILD_ATTRIBUTE).getAsString();
        deviceInfo.architecture = jsonObject.get(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE).getAsString();
        deviceInfo.runTime = jsonObject.get(AnalyticsAttribute.RUNTIME_ATTRIBUTE).getAsString();
        deviceInfo.modelNumber = jsonObject.get("modelNumber").getAsString();
        deviceInfo.screenResolution = jsonObject.get("screenResolution").getAsString();
        deviceInfo.deviceUuid = jsonObject.get("deviceUuid").getAsString();
        return deviceInfo;
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("memoryUsage", SafeJsonPrimitive.factory((Number) Long.valueOf(this.memoryUsage)));
        jsonObject.add("orientation", SafeJsonPrimitive.factory((Number) Integer.valueOf(this.orientation)));
        jsonObject.add("networkStatus", SafeJsonPrimitive.factory(this.networkStatus));
        jsonObject.add("diskAvailable", getDiskAvailableAsJson());
        jsonObject.add(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, SafeJsonPrimitive.factory(this.OSVersion));
        jsonObject.add("deviceName", SafeJsonPrimitive.factory(this.deviceName));
        jsonObject.add(AnalyticsAttribute.OS_BUILD_ATTRIBUTE, SafeJsonPrimitive.factory(this.OSBuild));
        jsonObject.add(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE, SafeJsonPrimitive.factory(this.architecture));
        jsonObject.add(AnalyticsAttribute.RUNTIME_ATTRIBUTE, SafeJsonPrimitive.factory(this.runTime));
        jsonObject.add("modelNumber", SafeJsonPrimitive.factory(this.modelNumber));
        jsonObject.add("screenResolution", SafeJsonPrimitive.factory(this.screenResolution));
        jsonObject.add("deviceUuid", SafeJsonPrimitive.factory(this.deviceUuid));
        return jsonObject;
    }

    public DeviceInfo(DeviceInformation deviceInformation, EnvironmentInformation environmentInformation) {
        this.memoryUsage = environmentInformation.getMemoryUsage();
        this.orientation = environmentInformation.getOrientation();
        this.networkStatus = environmentInformation.getNetworkStatus();
        this.diskAvailable = environmentInformation.getDiskAvailable();
        this.OSVersion = deviceInformation.getOsVersion();
        this.deviceName = deviceInformation.getManufacturer();
        this.OSBuild = deviceInformation.getOsBuild();
        this.architecture = deviceInformation.getArchitecture();
        this.modelNumber = deviceInformation.getModel();
        this.screenResolution = deviceInformation.getSize();
        this.deviceUuid = deviceInformation.getDeviceId();
        this.runTime = deviceInformation.getRunTime();
    }
}
