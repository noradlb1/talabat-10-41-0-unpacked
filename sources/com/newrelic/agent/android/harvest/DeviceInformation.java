package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.HashMap;
import java.util.Map;

public class DeviceInformation extends HarvestableArray {
    private String agentName;
    private String agentVersion;
    private ApplicationFramework applicationFramework;
    private String applicationFrameworkVersion;
    private String architecture;
    private String countryCode;
    private String deviceId;
    private String manufacturer;
    private Map<String, String> misc = new HashMap();
    private String model;
    private String osBuild;
    private String osName;
    private String osVersion;
    private String regionCode;
    private String runTime;
    private String size;

    public void addMisc(String str, String str2) {
        this.misc.put(str, str2);
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notEmpty(this.osName);
        jsonArray.add((JsonElement) new JsonPrimitive(this.osName));
        notEmpty(this.osVersion);
        jsonArray.add((JsonElement) new JsonPrimitive(this.osVersion));
        notEmpty(this.model);
        jsonArray.add((JsonElement) new JsonPrimitive(this.model));
        notEmpty(this.agentName);
        jsonArray.add((JsonElement) new JsonPrimitive(this.agentName));
        notEmpty(this.agentVersion);
        jsonArray.add((JsonElement) new JsonPrimitive(this.agentVersion));
        notEmpty(this.deviceId);
        jsonArray.add((JsonElement) new JsonPrimitive(this.deviceId));
        jsonArray.add((JsonElement) new JsonPrimitive(optional(this.countryCode)));
        jsonArray.add((JsonElement) new JsonPrimitive(optional(this.regionCode)));
        notEmpty(this.manufacturer);
        jsonArray.add((JsonElement) new JsonPrimitive(this.manufacturer));
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.misc;
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(this.misc);
        }
        ApplicationFramework applicationFramework2 = this.applicationFramework;
        if (applicationFramework2 != null) {
            hashMap.put("platform", applicationFramework2.toString());
            String str = this.applicationFrameworkVersion;
            if (str != null) {
                hashMap.put("platformVersion", str);
            }
        }
        jsonArray.add(new Gson().toJsonTree(hashMap, BaseHarvestable.GSON_STRING_MAP_TYPE));
        return jsonArray;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DeviceInformation deviceInformation = (DeviceInformation) obj;
        String str = this.agentName;
        if (str == null ? deviceInformation.agentName != null : !str.equals(deviceInformation.agentName)) {
            return false;
        }
        String str2 = this.agentVersion;
        if (str2 == null ? deviceInformation.agentVersion != null : !str2.equals(deviceInformation.agentVersion)) {
            return false;
        }
        String str3 = this.architecture;
        if (str3 == null ? deviceInformation.architecture != null : !str3.equals(deviceInformation.architecture)) {
            return false;
        }
        String str4 = this.deviceId;
        if (str4 == null ? deviceInformation.deviceId != null : !str4.equals(deviceInformation.deviceId)) {
            return false;
        }
        String str5 = this.manufacturer;
        if (str5 == null ? deviceInformation.manufacturer != null : !str5.equals(deviceInformation.manufacturer)) {
            return false;
        }
        String str6 = this.model;
        if (str6 == null ? deviceInformation.model != null : !str6.equals(deviceInformation.model)) {
            return false;
        }
        String str7 = this.osBuild;
        if (str7 == null ? deviceInformation.osBuild != null : !str7.equals(deviceInformation.osBuild)) {
            return false;
        }
        String str8 = this.osName;
        if (str8 == null ? deviceInformation.osName != null : !str8.equals(deviceInformation.osName)) {
            return false;
        }
        String str9 = this.osVersion;
        if (str9 == null ? deviceInformation.osVersion != null : !str9.equals(deviceInformation.osVersion)) {
            return false;
        }
        String str10 = this.runTime;
        if (str10 == null ? deviceInformation.runTime != null : !str10.equals(deviceInformation.runTime)) {
            return false;
        }
        String str11 = this.size;
        String str12 = deviceInformation.size;
        if (str11 == null ? str12 == null : str11.equals(str12)) {
            return true;
        }
        return false;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public String getAgentVersion() {
        return this.agentVersion;
    }

    public ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public String getApplicationFrameworkVersion() {
        return this.applicationFrameworkVersion;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getRunTime() {
        return this.runTime;
    }

    public String getSize() {
        return this.size;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        String str = this.osName;
        int i22 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i23 = i11 * 31;
        String str2 = this.osVersion;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i24 = (i23 + i12) * 31;
        String str3 = this.osBuild;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i25 = (i24 + i13) * 31;
        String str4 = this.model;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i26 = (i25 + i14) * 31;
        String str5 = this.agentName;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i27 = (i26 + i15) * 31;
        String str6 = this.agentVersion;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str7 = this.deviceId;
        if (str7 != null) {
            i17 = str7.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str8 = this.manufacturer;
        if (str8 != null) {
            i18 = str8.hashCode();
        } else {
            i18 = 0;
        }
        int i31 = (i29 + i18) * 31;
        String str9 = this.architecture;
        if (str9 != null) {
            i19 = str9.hashCode();
        } else {
            i19 = 0;
        }
        int i32 = (i31 + i19) * 31;
        String str10 = this.runTime;
        if (str10 != null) {
            i21 = str10.hashCode();
        } else {
            i21 = 0;
        }
        int i33 = (i32 + i21) * 31;
        String str11 = this.size;
        if (str11 != null) {
            i22 = str11.hashCode();
        }
        return i33 + i22;
    }

    public void setAgentName(String str) {
        this.agentName = str;
    }

    public void setAgentVersion(String str) {
        this.agentVersion = str;
    }

    public void setApplicationFramework(ApplicationFramework applicationFramework2) {
        this.applicationFramework = applicationFramework2;
    }

    public void setApplicationFrameworkVersion(String str) {
        this.applicationFrameworkVersion = str;
    }

    public void setArchitecture(String str) {
        this.architecture = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMisc(Map<String, String> map) {
        this.misc = new HashMap(map);
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOsBuild(String str) {
        this.osBuild = str;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setRunTime(String str) {
        this.runTime = str;
    }

    public void setSize(String str) {
        this.size = str;
        addMisc(BindingAdaptersKt.QUERY_SIZE, str);
    }

    public String toJsonString() {
        String str = this.manufacturer;
        String str2 = this.osName;
        String str3 = this.osVersion;
        String str4 = this.model;
        String str5 = this.agentName;
        String str6 = this.agentVersion;
        String str7 = this.deviceId;
        String str8 = this.countryCode;
        String str9 = this.regionCode;
        return "DeviceInformation{manufacturer='" + str + "', osName='" + str2 + "', osVersion='" + str3 + "', model='" + str4 + "', agentName='" + str5 + "', agentVersion='" + str6 + "', deviceId='" + str7 + "', countryCode='" + str8 + "', regionCode='" + str9 + "'}";
    }
}
