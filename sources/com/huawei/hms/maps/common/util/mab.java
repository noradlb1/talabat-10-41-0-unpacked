package com.huawei.hms.maps.common.util;

import android.app.Application;
import android.content.Context;
import android.os.RemoteException;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.MapClientIdentify;
import com.huawei.hms.maps.internal.HmsUtil;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IDistanceCalculatorDelegate;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapClientUtil;
import com.huawei.hms.maps.utils.MapsAdvUtil;
import java.lang.reflect.InvocationTargetException;

public class mab {

    /* renamed from: a  reason: collision with root package name */
    private static IDistanceCalculatorDelegate f49377a;

    public static double a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        try {
            if (MapsAdvUtil.containsMapsBasic()) {
                LogM.d("MapUtil", "computeDistanceBetween from basic.");
                if (f49377a == null) {
                    f49377a = new com.huawei.hms.maps.provider.inhuawei.IDistanceCalculatorDelegate();
                }
                return f49377a.computeDistanceBetween(latLng, latLng2);
            }
            if (f49377a == null) {
                a();
            }
            IDistanceCalculatorDelegate iDistanceCalculatorDelegate = f49377a;
            if (iDistanceCalculatorDelegate != null) {
                return iDistanceCalculatorDelegate.computeDistanceBetween(latLng, latLng2);
            }
            return 0.0d;
        } catch (RemoteException e11) {
            LogM.d("MapUtil", "RemoteException: " + e11.toString());
            return 0.0d;
        }
    }

    public static int a(Context context) {
        StringBuilder sb2;
        int i11;
        if (b() && !c()) {
            sb2 = new StringBuilder();
            sb2.append("isHmsMapAvailable is ");
            i11 = 2;
        } else if (new AvailableAdapter(HmsUtil.getMinHmsVersion(context)).isHuaweiMobileServicesAvailable(context) != 0) {
            sb2 = new StringBuilder();
            sb2.append("isHmsMapAvailable is ");
            i11 = 1;
        } else {
            sb2 = new StringBuilder();
            sb2.append("isHmsMapAvailable is ");
            i11 = 0;
        }
        sb2.append(i11);
        LogM.d("MapUtil", sb2.toString());
        return i11;
    }

    private static void a() {
        String str;
        StringBuilder sb2;
        try {
            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
            MapClientIdentify mapClientIdentify = new MapClientIdentify();
            int isHmsAvailable = HmsUtil.isHmsAvailable(application);
            if (isHmsAvailable != 0) {
                LogM.e("MapUtil", "hmsState check failed: " + isHmsAvailable);
            }
            ICreator b11 = com.huawei.hms.maps.internal.mab.b((Context) application);
            mapClientIdentify.regestIdentity(application, b11);
            if (b11 == null) {
                LogM.d("MapUtil", "creator is null");
            } else {
                f49377a = b11.newDistanceCalculatorDelegate(ObjectWrapper.wrap(com.huawei.hms.maps.internal.mab.d(application)));
            }
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        } catch (ClassNotFoundException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "ClassNotFoundException: ";
            sb2.append(str);
            sb2.append(e.toString());
            LogM.e("MapUtil", sb2.toString());
        } catch (NoSuchMethodException e13) {
            e = e13;
            sb2 = new StringBuilder();
            str = "NoSuchMethodException: ";
            sb2.append(str);
            sb2.append(e.toString());
            LogM.e("MapUtil", sb2.toString());
        } catch (IllegalAccessException e14) {
            e = e14;
            sb2 = new StringBuilder();
            str = "IllegalAccessException: ";
            sb2.append(str);
            sb2.append(e.toString());
            LogM.e("MapUtil", sb2.toString());
        } catch (InvocationTargetException e15) {
            e = e15;
            sb2 = new StringBuilder();
            str = "InvocationTargetException: ";
            sb2.append(str);
            sb2.append(e.toString());
            LogM.e("MapUtil", sb2.toString());
        }
    }

    private static boolean b() {
        return "cn".equalsIgnoreCase(MapClientUtil.getSystemProperties("ro.product.locale.region", "")) || "cn".equalsIgnoreCase(MapClientUtil.getSystemProperties("ro.hw.country", "")) || "cn".equalsIgnoreCase(MapClientUtil.getSystemProperties("msc.sys.country", ""));
    }

    private static boolean c() {
        StringBuilder sb2;
        int i11;
        if (!MapClientUtil.getSystemProperties("ro.build.version.magic", "").equals("") || !MapClientUtil.getSystemProperties("ro.build.version.emui", "").contains("EmotionUI_10")) {
            return true;
        }
        String systemProperties = MapClientUtil.getSystemProperties("ro.huawei.build.display.id", "");
        LogM.d("MapUtil", "huaweiSubVersion is " + systemProperties);
        if ("".equals(systemProperties)) {
            systemProperties = MapClientUtil.getSystemProperties("ro.build.display.id", "");
            LogM.d("MapUtil", "emuiSubVersion is " + systemProperties);
        }
        String[] split = systemProperties.split(" ");
        boolean z11 = false;
        if (1 < split.length) {
            String[] split2 = split[1].split("\\.");
            if (3 < split2.length) {
                String str = split2[3];
                int indexOf = str.indexOf("(");
                if (-1 != indexOf) {
                    str = str.substring(0, indexOf);
                }
                try {
                    int parseInt = Integer.parseInt(split2[0]);
                    int parseInt2 = Integer.parseInt(split2[1]);
                    int parseInt3 = Integer.parseInt(split2[2]);
                    int parseInt4 = Integer.parseInt(str);
                    if (parseInt < 10 || (parseInt == 10 && parseInt2 == 0 && parseInt3 < 1 && parseInt4 < 122)) {
                        z11 = true;
                    }
                    return true ^ z11;
                } catch (NumberFormatException e11) {
                    LogM.e("MapUtil", "NumberFormatException" + e11.toString());
                    return true;
                }
            } else {
                sb2 = new StringBuilder();
                sb2.append("versionStrs.length <= 3: ");
                i11 = split2.length;
            }
        } else {
            sb2 = new StringBuilder();
            sb2.append("versions.length <= 1: ");
            i11 = split.length;
        }
        sb2.append(i11);
        LogM.e("MapUtil", sb2.toString());
        return false;
    }
}
