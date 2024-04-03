package com.huawei.wearengine.utils.json;

import android.text.TextUtils;
import com.huawei.wearengine.common.a;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceJsonUtil {
    private static final String TAG = "DeviceJsonUtil";

    private DeviceJsonUtil() {
    }

    public static String getBasicInfo(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "getBasicInfo jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("device_basic_info")) {
                    return jSONObject.getString("device_basic_info");
                }
                a.c(TAG, "getBasicInfo input json not has key");
                return "";
            } catch (JSONException unused) {
                str2 = "getBasicInfo catch JSONException";
            }
        }
        a.c(TAG, str2);
        return "";
    }

    public static String getCapability(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "getCapability jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("device_capability")) {
                    return jSONObject.getString("device_capability");
                }
                a.c(TAG, "getCapability input json not has key");
                return "";
            } catch (JSONException unused) {
                str2 = "getCapability catch JSONException";
            }
        }
        a.c(TAG, str2);
        return "";
    }

    public static String getIdentify(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "getIdentify jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("device_identify")) {
                    return jSONObject.getString("device_identify");
                }
                a.c(TAG, "getIdentify input json not has key");
                return "";
            } catch (JSONException unused) {
                str2 = "getIdentify catch JSONException";
            }
        }
        a.c(TAG, str2);
        return "";
    }

    public static String getReservedness(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "getReservedness jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("device_reservedness")) {
                    return jSONObject.getString("device_reservedness");
                }
                a.c(TAG, "getReservedness input json not has key");
                return "";
            } catch (JSONException unused) {
                str2 = "getReservedness catch JSONException";
            }
        }
        a.c(TAG, str2);
        return "";
    }

    public static String getWearEngineDeviceId(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "getWearEngineDeviceId jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("device_wear_engine_device_id")) {
                    return jSONObject.getString("device_wear_engine_device_id");
                }
                a.c(TAG, "getWearEngineDeviceId input json not has key");
                return "";
            } catch (JSONException unused) {
                str2 = "getWearEngineDeviceId catch JSONException";
            }
        }
        a.c(TAG, str2);
        return "";
    }
}
