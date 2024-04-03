package com.huawei.wearengine.utils.json;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceJson extends JSONObject {
    private static final String TAG = "DeviceJson";

    public static class Builder {
        private String mBasicInfo = "";
        private String mCapability = "";
        private String mIdentify = "";
        private String mReservedness = "";
        private String mWearEngineDeviceId;

        public DeviceJson build() {
            DeviceJson deviceJson = new DeviceJson();
            try {
                deviceJson.put("device_reservedness", (Object) this.mReservedness);
                deviceJson.put("device_capability", (Object) this.mCapability);
                deviceJson.put("device_basic_info", (Object) this.mBasicInfo);
                deviceJson.put("device_identify", (Object) this.mIdentify);
                deviceJson.put("device_wear_engine_device_id", (Object) this.mWearEngineDeviceId);
            } catch (JSONException unused) {
                com.huawei.wearengine.common.a.c(DeviceJson.TAG, "build catch JSONException");
            }
            return deviceJson;
        }

        public Builder setBasicInfo(String str) {
            this.mBasicInfo = str;
            return this;
        }

        public Builder setCapability(String str) {
            this.mCapability = str;
            return this;
        }

        public Builder setIdentify(String str) {
            this.mIdentify = str;
            return this;
        }

        public Builder setReservedness(String str) {
            this.mReservedness = str;
            return this;
        }

        public Builder setWearEngineDeviceId(String str) {
            this.mWearEngineDeviceId = str;
            return this;
        }
    }

    private DeviceJson() {
    }
}
