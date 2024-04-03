package com.iab.omid.library.deliveryhero3.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.deliveryhero3.adsession.DeviceCategory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static UiModeManager f44997a;

    public static DeviceCategory a() {
        UiModeManager uiModeManager = f44997a;
        if (uiModeManager == null) {
            return DeviceCategory.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV : DeviceCategory.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f44997a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
