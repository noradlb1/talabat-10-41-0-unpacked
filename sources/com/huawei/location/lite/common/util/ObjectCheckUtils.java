package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.Collection;

public class ObjectCheckUtils {
    public static void checkEmptyString(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            LogConsole.e(str, "checkString, string is empty");
            throw new LocationServiceException(10100, LocationStatusCode.getStatusCodeString(10100) + ":for String");
        }
    }

    public static void checkEmptyString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            LogConsole.e(str, "checkString, string is empty" + str3);
            throw new LocationServiceException(10100, LocationStatusCode.getStatusCodeString(10100) + ":for errorMessage is " + str3);
        }
    }

    public static void checkNullCollection(String str, Collection<?> collection, String str2) {
        if (CollectionsUtils.isEmpty(collection)) {
            LogConsole.e(str, "checkNullCollection, collection is null:for errorMessage is " + str2);
            throw new LocationServiceException(10100, LocationStatusCode.getStatusCodeString(10100) + ":for errorMessage  is " + str2);
        }
    }

    public static void checkNullObject(String str, Object obj, int i11, Class cls) {
        if (obj == null) {
            LogConsole.e(str, "checkNullObject, string is empty:for object name is " + cls);
            throw new LocationServiceException(i11, LocationStatusCode.getStatusCodeString(i11) + ":for object name is " + cls);
        }
    }

    public static void checkNullObject(String str, Object obj, int i11, String str2) {
        if (obj == null) {
            LogConsole.e(str, "checkNullObject, " + str2);
            throw new LocationServiceException(i11, str2);
        }
    }

    public static void checkNullObject(String str, Object obj, Class cls) {
        if (obj == null) {
            LogConsole.e(str, "checkNullObject, Object is null:for object name is " + cls);
            throw new LocationServiceException(10100, LocationStatusCode.getStatusCodeString(10100) + ":for object name is " + cls);
        }
    }

    public static void checkNullObject(String str, Object obj, String str2) {
        if (obj == null) {
            LogConsole.e(str, "checkNullObject, Object is null:for errorMessage is " + str2);
            throw new LocationServiceException(10100, LocationStatusCode.getStatusCodeString(10100) + ":for errorMessage  is " + str2);
        }
    }

    public static void throwIfMatch(String str, int i11, boolean z11, String str2) {
        if (z11) {
            LogConsole.e(str, "throwIfMatch:code is " + i11 + "for errorMessage is " + str2);
            throw new LocationServiceException(i11, LocationStatusCode.getStatusCodeString(i11) + ":for errorMessage  is " + str2);
        }
    }
}
