package com.huawei.wearengine.common;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class WearEngineErrorCode {
    public static final int ERROR_CODE_COMM_FAIL = 206;
    public static final int ERROR_CODE_COMM_SUCCESS = 207;
    public static final int ERROR_CODE_DEVICE_IS_NOT_CONNECTED = 16;
    public static final int ERROR_CODE_DEVICE_NOT_SENSOR = 304;
    public static final int ERROR_CODE_DEVICE_UUID_IS_INVALID = 17;
    public static final int ERROR_CODE_DEVICE_VERSION_NOT_SUPPORT = 13;
    public static final int ERROR_CODE_GENERIC = 1;
    public static final int ERROR_CODE_HEALTH_LOGOUT = 3;
    public static final int ERROR_CODE_HEALTH_NOT_AUTO_START = 15;
    public static final int ERROR_CODE_HEALTH_VERSION_IS_LOW = 14;
    public static final int ERROR_CODE_INTERFACE_IS_NOT_SUPPORTED = 18;
    public static final int ERROR_CODE_INTERNAL_ERROR = 12;
    public static final int ERROR_CODE_INVALID_ARGUMENT = 5;
    public static final int ERROR_CODE_INVALID_FILE = 10;
    public static final int ERROR_CODE_OVERMUCH_RECEIVER = 11;
    public static final int ERROR_CODE_P2P_OTHER_ERROR = 203;
    public static final int ERROR_CODE_P2P_PHONE_APP_EXIT = 205;
    public static final int ERROR_CODE_P2P_PHONE_APP_NOT_EXIT = 204;
    public static final int ERROR_CODE_P2P_WATCH_APP_NOT_EXIT = 200;
    public static final int ERROR_CODE_P2P_WATCH_APP_NOT_RUNNING = 201;
    public static final int ERROR_CODE_P2P_WATCH_APP_RUNNING = 202;
    public static final int ERROR_CODE_SCOPE_UNAUTHORIZED = 8;
    public static final int ERROR_CODE_SENSOR_WATCH_LEAD_OFF = 301;
    public static final int ERROR_CODE_SENSOR_WATCH_SENSOR_USED = 303;
    public static final int ERROR_CODE_SENSOR_WATCH_USER_STOP = 302;
    public static final int ERROR_CODE_SENSOR_WATCH_WEAR_OFF = 300;
    public static final int ERROR_CODE_SERVER_REMOTE_BINDER = 6;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_UNBOUND_DEVICE = 4;
    public static final int ERROR_CODE_UNINSTALL_HEALTH = 2;
    public static final int ERROR_CODE_USER_UNAUTHORIZED_IN_HEALTH = 7;
    public static final int ERROR_CODE_USER_UNAUTHORIZED_IN_WEAR_ENGINE = 9;
    public static final String ERROR_MSG_COMM_FAIL = "Fail";
    public static final String ERROR_MSG_COMM_SUCCESS = "Success";
    public static final String ERROR_MSG_DEVICE_IS_NOT_CONNECTED = "Device is not connected";
    public static final String ERROR_MSG_DEVICE_UUID_IS_INVALID = "Device uuid is invalid";
    public static final String ERROR_MSG_DEVICE_VERSION_NOT_SUPPORT = "Device version is not supported";
    public static final String ERROR_MSG_EVICE_NOT_SENSOR = "Sensor Not Abilites";
    public static final String ERROR_MSG_GENERIC = "Generic error";
    public static final String ERROR_MSG_HEALTH_LOGOUT = "Health app not login";
    public static final String ERROR_MSG_HEALTH_NOT_AUTO_START = "Health does not has permission to start";
    public static final String ERROR_MSG_HEALTH_VERSION_IS_LOW = "Health version is low";
    public static final String ERROR_MSG_INTERFACE_IS_NOT_SUPPORTED = "Interface is not supported";
    public static final String ERROR_MSG_INTERNAL_ERROR = "Internal error";
    public static final String ERROR_MSG_INVALID_ARGUMENT = "Invalid argument";
    public static final String ERROR_MSG_INVALID_FILE = "Invalid file";
    public static final String ERROR_MSG_OVERMUCH_RECEIVER = "Too much receivers";
    public static final String ERROR_MSG_P2P_OTHER_ERROR = "Other error";
    public static final String ERROR_MSG_P2P_PHONE_APP_EXIT = "Phone app exist";
    public static final String ERROR_MSG_P2P_PHONE_APP_NOT_EXIT = "Phone app not exist";
    public static final String ERROR_MSG_P2P_WATCH_APP_NOT_EXIT = "Watch app not exist";
    public static final String ERROR_MSG_P2P_WATCH_APP_NOT_RUNNING = "Watch app not running";
    public static final String ERROR_MSG_P2P_WATCH_APP_RUNNING = "Watch app running";
    public static final String ERROR_MSG_SCOPE_UNAUTHORIZED = "Scope unauthorized";
    public static final String ERROR_MSG_SENSOR_WATCH_LEAD_OFF = "Sensor Watch Lead Off";
    public static final String ERROR_MSG_SENSOR_WATCH_SENSOR_USED = "Sensor Watch Sensor Used";
    public static final String ERROR_MSG_SENSOR_WATCH_USER_STOP = "Sensor Watch User Stop";
    public static final String ERROR_MSG_SENSOR_WATCH_WEAR_OFF = "Sensor Watch Wear Off";
    public static final String ERROR_MSG_SERVER_REMOTE_BINDER = "Server remote binder is null";
    public static final String ERROR_MSG_SUCCESS = "Success";
    public static final String ERROR_MSG_UNBOUND_DEVICE = "Health app unbound device";
    public static final String ERROR_MSG_UNINSTALL_HEALTH = "Health app not exist";
    public static final String ERROR_MSG_USER_UNAUTHORIZED_IN_HEALTH = "User unauthorized in health";
    public static final String ERROR_MSG_USER_UNAUTHORIZED_WEAR_ENGINE = "User unauthorized in wear engine";

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, String> f35137a;

    static {
        HashMap hashMap = new HashMap();
        f35137a = hashMap;
        hashMap.put(0, "Success");
        f35137a.put(1, ERROR_MSG_GENERIC);
        f35137a.put(2, ERROR_MSG_UNINSTALL_HEALTH);
        f35137a.put(3, ERROR_MSG_HEALTH_LOGOUT);
        f35137a.put(4, ERROR_MSG_UNBOUND_DEVICE);
        f35137a.put(5, ERROR_MSG_INVALID_ARGUMENT);
        f35137a.put(6, ERROR_MSG_SERVER_REMOTE_BINDER);
        f35137a.put(7, ERROR_MSG_USER_UNAUTHORIZED_IN_HEALTH);
        f35137a.put(8, ERROR_MSG_SCOPE_UNAUTHORIZED);
        f35137a.put(9, ERROR_MSG_USER_UNAUTHORIZED_WEAR_ENGINE);
        f35137a.put(10, ERROR_MSG_INVALID_FILE);
        f35137a.put(11, ERROR_MSG_OVERMUCH_RECEIVER);
        f35137a.put(12, ERROR_MSG_INTERNAL_ERROR);
        f35137a.put(13, ERROR_MSG_DEVICE_VERSION_NOT_SUPPORT);
        f35137a.put(14, ERROR_MSG_HEALTH_VERSION_IS_LOW);
        f35137a.put(15, ERROR_MSG_HEALTH_NOT_AUTO_START);
        f35137a.put(16, ERROR_MSG_DEVICE_IS_NOT_CONNECTED);
        f35137a.put(17, ERROR_MSG_DEVICE_UUID_IS_INVALID);
        f35137a.put(18, ERROR_MSG_INTERFACE_IS_NOT_SUPPORTED);
        f35137a.put(200, ERROR_MSG_P2P_WATCH_APP_NOT_EXIT);
        f35137a.put(201, ERROR_MSG_P2P_WATCH_APP_NOT_RUNNING);
        f35137a.put(202, ERROR_MSG_P2P_WATCH_APP_RUNNING);
        f35137a.put(203, ERROR_MSG_P2P_OTHER_ERROR);
        f35137a.put(204, ERROR_MSG_P2P_PHONE_APP_NOT_EXIT);
        f35137a.put(205, ERROR_MSG_P2P_PHONE_APP_EXIT);
        f35137a.put(206, ERROR_MSG_COMM_FAIL);
        f35137a.put(207, "Success");
        f35137a.put(300, ERROR_MSG_SENSOR_WATCH_WEAR_OFF);
        f35137a.put(301, ERROR_MSG_SENSOR_WATCH_LEAD_OFF);
        f35137a.put(302, ERROR_MSG_SENSOR_WATCH_USER_STOP);
        f35137a.put(303, ERROR_MSG_SENSOR_WATCH_SENSOR_USED);
        f35137a.put(304, ERROR_MSG_EVICE_NOT_SENSOR);
    }

    private WearEngineErrorCode() {
    }

    public static int convertStringToErrorCode(String str) {
        int i11;
        try {
            i11 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            a.a("WearEngineErrorCode", "NumberFormatException");
            i11 = 1;
        }
        if (f35137a.containsKey(Integer.valueOf(i11))) {
            return i11;
        }
        return 1;
    }

    public static int getErrorCodeFromErrorMsg(String str) {
        int i11 = 1;
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry next : f35137a.entrySet()) {
                if (str.equals(next.getValue())) {
                    i11 = ((Integer) next.getKey()).intValue();
                }
            }
        }
        return i11;
    }

    public static String getErrorMsgFromCode(int i11) {
        return f35137a.containsKey(Integer.valueOf(i11)) ? f35137a.get(Integer.valueOf(i11)) : ERROR_MSG_GENERIC;
    }
}
