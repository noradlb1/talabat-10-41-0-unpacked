package com.huawei.hms.maps.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.maps.MapClientIdentify;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.utils.AgcCoreUtil;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapClientUtil;
import com.huawei.hms.maps.utils.MapsAdvUtil;

public final class maa {
    public static void a(Context context) {
        if (TextUtils.isEmpty(MapClientUtil.getAppId(context))) {
            LogM.e("ConfigCheckUtil", "AppId is null. Please check whether the agconnect-services.json file is added to your app project.");
            throw new RuntimeRemoteException("AppId is null. Please check whether the agconnect-services.json file is added to your app project.");
        } else if (TextUtils.isEmpty(MapsAdvUtil.getAccessToken()) && TextUtils.isEmpty(b(context))) {
            LogM.e("ConfigCheckUtil", "ApiKey and token is null. Please check whether set accessToken or the agconnect-services.json file is added to your app project.");
            throw new RuntimeRemoteException("ApiKey and token is null. Please check whether set accessToken or the agconnect-services.json file is added to your app project.");
        }
    }

    public static void a(Context context, String str) {
        if (MapClientUtil.validCountryCode(str)) {
            MapClientIdentify.setCountryCode(str);
            return;
        }
        String string = AgcCoreUtil.getString(context, "processing_location_policy/map");
        if (!TextUtils.isEmpty(string) && string.equals("1")) {
            String string2 = AgcCoreUtil.getString(context, "region");
            if (MapClientUtil.validCountryCode(string2)) {
                MapClientIdentify.setCountryCode(string2);
            }
        }
    }

    private static String b(Context context) {
        MapClientIdentify.initApiKey(context);
        return MapClientIdentify.getApiKey();
    }
}
