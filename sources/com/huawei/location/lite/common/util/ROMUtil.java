package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.visa.checkout.Profile;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ROMUtil {
    private static final String BUILD_VERSION_CLASS_HONOR = "com.hihonor.android.os.Build$VERSION";
    public static final String MANUFACTURER_HONOR = "HONOR";
    public static final String MANUFACTURER_HUAWEI = "HUAWEI";
    public static final int ROM_TYPE_EMUI = 1;
    public static final int ROM_TYPE_HARMONY = 3;
    public static final int ROM_TYPE_HARMONY_OEM = 5;
    public static final int ROM_TYPE_MAGIC_UI = 2;
    public static final int ROM_TYPE_NOT_HUAWEI = -1;
    public static final int ROM_TYPE_USE_BRAND_CUST = 4;
    private static final String TAG = "ROMUtil";
    private static AtomicInteger emuiVersionCode;
    private static AtomicBoolean isHuaweiDevice;
    private static AtomicBoolean romHmsGms;
    private static AtomicBoolean romRegionIsCn;
    private static AtomicInteger romType;

    public static String getEmuiVerName() {
        String eMUIVersion = SystemPropertiesUtil.getEMUIVersion();
        LogConsole.d(TAG, "Emui version name: " + eMUIVersion);
        return eMUIVersion;
    }

    public static int getEmuiVersionCode() {
        AtomicInteger atomicInteger = emuiVersionCode;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        int versionCodeFromBuild = getVersionCodeFromBuild(0);
        if (versionCodeFromBuild <= 0) {
            try {
                versionCodeFromBuild = Integer.parseInt(SystemPropertiesUtil.get("ro.build.hw_emui_api_level", "0"));
            } catch (NumberFormatException unused) {
                LogConsole.e(TAG, "NumberFormatException: get hw_emui_api_level failed");
            }
        }
        LogConsole.i(TAG, "EMUI_VERSION_CODE: " + versionCodeFromBuild);
        AtomicInteger atomicInteger2 = new AtomicInteger(versionCodeFromBuild);
        emuiVersionCode = atomicInteger2;
        return atomicInteger2.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1 > 0) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getHuaweiPlatformROMType() {
        /*
            java.util.concurrent.atomic.AtomicInteger r0 = romType
            if (r0 == 0) goto L_0x0009
            int r0 = r0.get()
            return r0
        L_0x0009:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r1 = getEmuiVersionCode()
            r0.hashCode()
            java.lang.String r2 = "HONOR"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0038
            java.lang.String r2 = "HUAWEI"
            boolean r0 = r0.equals(r2)
            r2 = 27
            if (r0 != 0) goto L_0x0031
            if (r1 >= r2) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            boolean r0 = isUseBrandCust()
            if (r0 == 0) goto L_0x002f
            r0 = 4
            goto L_0x004c
        L_0x002f:
            r0 = 5
            goto L_0x004c
        L_0x0031:
            if (r1 < r2) goto L_0x0035
            r0 = 3
            goto L_0x004c
        L_0x0035:
            if (r1 <= 0) goto L_0x0049
            goto L_0x003e
        L_0x0038:
            if (r1 <= 0) goto L_0x0040
            r0 = 25
            if (r1 > r0) goto L_0x0040
        L_0x003e:
            r0 = 1
            goto L_0x004c
        L_0x0040:
            r0 = 26
            if (r1 == r0) goto L_0x004b
            r0 = 29
            if (r1 < r0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r0 = -1
            goto L_0x004c
        L_0x004b:
            r0 = 2
        L_0x004c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Rom type is "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ROMUtil"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r1.<init>(r0)
            romType = r1
            int r0 = r1.get()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.ROMUtil.getHuaweiPlatformROMType():int");
    }

    private static int getVersionCodeFromBuild(int i11) {
        String str;
        try {
            Class<?> cls = Class.forName(EmuiUtil.BUILDEX_VERSION);
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i11 : ((Integer) obj).intValue();
        } catch (ClassNotFoundException unused) {
            i11 = getVersionCodeFromHonorBuild(i11);
            str = "getVersionCodeFromBuild ClassNotFoundException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (NoSuchFieldException unused2) {
            str = "getVersionCodeFromBuild NoSuchFieldException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromBuild IllegalAccessException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (ClassCastException unused4) {
            str = "getVersionCodeFromBuild ClassCastException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (Exception unused5) {
            str = "getVersionCodeFromBuild unknown exception";
            LogConsole.e(TAG, str);
            return i11;
        }
    }

    private static int getVersionCodeFromHonorBuild(int i11) {
        String str;
        try {
            Class<?> cls = Class.forName(BUILD_VERSION_CLASS_HONOR);
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i11 : ((Integer) obj).intValue();
        } catch (ClassNotFoundException unused) {
            str = "getVersionCodeFromHonorBuild ClassNotFoundException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (NoSuchFieldException unused2) {
            str = "getVersionCodeFromHonorBuild NoSuchFieldException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromHonorBuild IllegalAccessException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (ClassCastException unused4) {
            str = "getVersionCodeFromHonorBuild ClassCastException";
            LogConsole.e(TAG, str);
            return i11;
        } catch (Exception unused5) {
            str = "getVersionCodeFromHonorBuild unknown exception";
            LogConsole.e(TAG, str);
            return i11;
        }
    }

    public static boolean isAbroadHWPlatformRom() {
        return isHuaweiPlatformDevice() && !isChineseRom();
    }

    public static boolean isChineseRom() {
        AtomicBoolean atomicBoolean = romRegionIsCn;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean equalsIgnoreCase = Profile.Country.CN.equalsIgnoreCase(SystemPropertiesUtil.getProRegion());
        LogConsole.d(TAG, "isChineseRom is " + equalsIgnoreCase);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(equalsIgnoreCase);
        romRegionIsCn = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean isGmsRom() {
        AtomicBoolean atomicBoolean = romHmsGms;
        if (atomicBoolean != null) {
            atomicBoolean.get();
        }
        String str = SystemPropertiesUtil.get("ro.com.google.gmsversion", "");
        LogConsole.d(TAG, "isGmsVersion is " + str);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(TextUtils.isEmpty(str) ^ true);
        romHmsGms = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static boolean isHuaweiPlatformDevice() {
        if (isHuaweiDevice != null) {
            LogConsole.i(TAG, "is huawei device:" + isHuaweiDevice.get());
            return isHuaweiDevice.get();
        }
        boolean z11 = getHuaweiPlatformROMType() != -1;
        LogConsole.i(TAG, "is huawei device:" + z11);
        AtomicBoolean atomicBoolean = new AtomicBoolean(z11);
        isHuaweiDevice = atomicBoolean;
        return atomicBoolean.get();
    }

    public static boolean isMagic6OrAbove() {
        return getHuaweiPlatformROMType() == 2 && getEmuiVersionCode() >= 32;
    }

    private static boolean isUseBrandCust() {
        return TextUtils.equals(SystemPropertiesUtil.get("hw_sc.product.useBrandCust", ""), "true");
    }
}
