package com.huawei.hms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

public class mac {
    private mac() {
    }

    public static Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            return bundle2;
        }
        Parcelable a11 = a(bundle, "HuaweiMapOptions");
        if (a11 != null) {
            a(bundle2, "HuaweiMapOptions", a11);
        }
        Parcelable a12 = a(bundle, "StreetViewOptions");
        if (a12 != null) {
            a(bundle2, "StreetViewOptions", a12);
        }
        Parcelable a13 = a(bundle, "CameraState");
        if (a13 != null) {
            a(bundle2, "CameraState", a13);
        }
        if (bundle.containsKey("position")) {
            bundle2.putString("position", bundle.getString("position"));
        }
        return bundle2;
    }

    private static <T extends Parcelable> T a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        Class<mac> cls = mac.class;
        bundle.setClassLoader(cls.getClassLoader());
        Bundle bundle2 = (Bundle) bundle.get("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(cls.getClassLoader());
        return bundle2.getParcelable(str);
    }

    public static void a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(mac.class.getClassLoader());
        bundle.putBundle("map_state", b(bundle, str, parcelable));
    }

    public static Bundle b(Bundle bundle, String str, Parcelable parcelable) {
        Bundle bundle2 = null;
        if (bundle != null) {
            try {
                bundle2 = bundle.getBundle("map_state");
            } catch (Exception e11) {
                Log.e("MapStateUtils", "getOrgMapState exception " + e11.getMessage());
            }
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(mac.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        return bundle2;
    }
}
