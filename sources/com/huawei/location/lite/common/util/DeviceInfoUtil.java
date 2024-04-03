package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceInfoUtil {
    public static final int DEVICE_TYPE_CAR = 8;
    public static final int DEVICE_TYPE_EARPHONE = 7;
    public static final int DEVICE_TYPE_GLASS = 6;
    public static final int DEVICE_TYPE_HANDSET = 0;
    public static final int DEVICE_TYPE_KID_WATCH = 3;
    public static final int DEVICE_TYPE_MOBILE_TV = 5;
    public static final int DEVICE_TYPE_PAD = 1;
    public static final int DEVICE_TYPE_TV = 4;
    public static final int DEVICE_TYPE_UNKNOWN = -1;
    public static final int DEVICE_TYPE_WATCH = 2;
    private static final DeviceType[] D_TYPE_LIST = {new DeviceType(0, "handset", false, "default", (String) null), new DeviceType(1, "pad", false, "tablet", (String) null), new DeviceType(2, "watch", true, "watch", "watch"), new DeviceType(3, "kidwatch", false, "kidwatch", (String) null), new DeviceType(4, "tv", true, "tv", "television"), new DeviceType(4, "tv", true, "tv", "leanback"), new DeviceType(5, "mobiletv", false, "mobiletv", (String) null), new DeviceType(6, "glass", false, (String) null, (String) null), new DeviceType(7, "earphone", false, (String) null, (String) null), new DeviceType(8, "car", false, "car", "automotive")};
    private static final String[] FEATURE_ANDROID = {"android.hardware.type.", "android.software."};
    private static final String FEATURE_HONOR = "com.hihonor.software.features.";
    private static final String FEATURE_HUAWEI = "com.huawei.software.features.";
    private static final String HUAWEI_FEATURE_DIALOG = "com.huawei.software.features.car.ux.activity.dialog";
    private static final String IS_EMULATOR = "1";
    private static final List<String> KID_CHARACTERS = Arrays.asList(new String[]{"kidpad", "kidwatch"});
    private static final String TAG = "DeviceInfoUtil";
    private static final String USERTYPE_KID = "kid";
    private static final String USERTYPE_NORMAL = "normal";
    private static volatile String brand = "";
    private static volatile int deviceType = -1;
    private static volatile String model = "";
    private static volatile String pubMfc = "";
    private static volatile String userType = "";

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceProperty {
        public static final String EMULATOR = "emulator";
        public static final String USERTYPE = "userType";
        public static final String VENDOR = "vendor";
    }

    public static final class DeviceType {
        /* access modifiers changed from: private */
        public final String androidFeature;
        /* access modifiers changed from: private */
        public final String androidPropChar;
        /* access modifiers changed from: private */
        public final String huaweiFeature;
        /* access modifiers changed from: private */
        public final boolean hwHasSubFeatures;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final int f50155id;

        private DeviceType(int i11, String str, boolean z11, String str2, String str3) {
            this.f50155id = i11;
            this.huaweiFeature = str;
            this.hwHasSubFeatures = z11;
            this.androidPropChar = str2;
            this.androidFeature = str3;
        }
    }

    private DeviceInfoUtil() {
    }

    private static String checkNormalOrKid(FeatureInfo[] featureInfoArr) {
        int i11;
        if (!(featureInfoArr == null || featureInfoArr.length == 0)) {
            for (FeatureInfo featureInfo : featureInfoArr) {
                String str = featureInfo.name;
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith(FEATURE_HUAWEI)) {
                        i11 = 29;
                    } else if (str.startsWith(FEATURE_HONOR)) {
                        i11 = 30;
                    } else {
                        continue;
                    }
                    String substring = str.substring(i11);
                    if (KID_CHARACTERS.contains(substring)) {
                        LogConsole.d(TAG, "get a kid feature name: " + substring);
                        return USERTYPE_KID;
                    }
                }
            }
        }
        return "normal";
    }

    private static int detectAndroidFeature(FeatureInfo[] featureInfoArr) {
        LogConsole.d(TAG, "Checking Android Features...");
        HashSet hashSet = new HashSet();
        for (FeatureInfo featureInfo : featureInfoArr) {
            if (featureInfo != null) {
                String parseNickNameByAndroidFeature = parseNickNameByAndroidFeature(featureInfo.name);
                if (!TextUtils.isEmpty(parseNickNameByAndroidFeature)) {
                    hashSet.add(parseNickNameByAndroidFeature);
                }
            }
        }
        return getTypeFromDTypeList(hashSet);
    }

    private static int detectDeviceType(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            LogConsole.e(TAG, "packageManager is null.");
            return -1;
        }
        FeatureInfo[] featureInfoArr = new FeatureInfo[0];
        try {
            featureInfoArr = packageManager.getSystemAvailableFeatures();
        } catch (RuntimeException unused) {
            LogConsole.e(TAG, "Package  manager  has  died Exception");
        }
        int detectHuaweiFeature = detectHuaweiFeature(featureInfoArr);
        LogConsole.i(TAG, "1. detectHuaweiFeature: " + detectHuaweiFeature);
        if (detectHuaweiFeature == -1) {
            detectHuaweiFeature = -1;
        } else if (detectHuaweiFeature != 0) {
            return detectHuaweiFeature;
        }
        int detectAndroidFeature = detectAndroidFeature(featureInfoArr);
        LogConsole.i(TAG, "2. detectAndroidFeature: " + detectAndroidFeature);
        if (detectAndroidFeature != -1) {
            return detectAndroidFeature;
        }
        int detectSystemProperty = detectSystemProperty();
        LogConsole.i(TAG, "3. detectSystemProperty: " + detectSystemProperty);
        return detectSystemProperty == -1 ? detectHuaweiFeature : detectSystemProperty;
    }

    private static int detectHuaweiFeature(FeatureInfo[] featureInfoArr) {
        int i11;
        LogConsole.d(TAG, "Checking Huawei Features...");
        int length = featureInfoArr.length;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            if (i13 >= length) {
                break;
            }
            FeatureInfo featureInfo = featureInfoArr[i13];
            if (featureInfo != null) {
                String str = featureInfo.name;
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith(FEATURE_HUAWEI)) {
                        i11 = 29;
                    } else if (str.startsWith(FEATURE_HONOR)) {
                        i11 = 30;
                    } else {
                        continue;
                    }
                    String substring = str.substring(i11);
                    for (DeviceType deviceType2 : D_TYPE_LIST) {
                        if (substring.equals(deviceType2.huaweiFeature)) {
                            i12 = deviceType2.f50155id;
                            if (!deviceType2.hwHasSubFeatures) {
                                break;
                            }
                        }
                    }
                    if (i12 != -1) {
                        LogConsole.i(TAG, "Huawei Feature is found: " + featureInfo.name);
                        break;
                    }
                } else {
                    continue;
                }
            }
            i13++;
        }
        return i12;
    }

    private static int detectSystemProperty() {
        LogConsole.d(TAG, "Checking system properties...");
        String character = SystemPropertiesUtil.getCharacter();
        if (TextUtils.isEmpty(character)) {
            return -1;
        }
        List asList = Arrays.asList(character.split(",", 10));
        int i11 = -1;
        for (DeviceType deviceType2 : D_TYPE_LIST) {
            if (asList.contains(deviceType2.androidPropChar)) {
                i11 = deviceType2.f50155id;
                if (!deviceType2.hwHasSubFeatures) {
                    break;
                }
            }
        }
        if (i11 == -1) {
            LogConsole.i(TAG, "System property not found.");
        }
        return i11;
    }

    public static synchronized String getBrand() {
        synchronized (DeviceInfoUtil.class) {
            if (!TextUtils.isEmpty(brand)) {
                String str = brand;
                return str;
            }
            brand = Build.BRAND;
            String str2 = brand;
            return str2;
        }
    }

    public static int getDeviceFeature(Context context) {
        if (deviceType != -1) {
            LogConsole.i(TAG, "get deviceType from cache: " + deviceType);
            return deviceType;
        } else if (context == null) {
            LogConsole.e(TAG, "context is null.");
            return deviceType;
        } else {
            int detectDeviceType = detectDeviceType(context);
            if (detectDeviceType != -1) {
                deviceType = detectDeviceType;
            }
            LogConsole.i(TAG, "Final DeviceType: " + deviceType);
            return detectDeviceType;
        }
    }

    public static synchronized String getDeviceModel() {
        synchronized (DeviceInfoUtil.class) {
            if (!TextUtils.isEmpty(model)) {
                String str = model;
                return str;
            }
            model = Build.MODEL;
            String str2 = model;
            return str2;
        }
    }

    public static String getDeviceProperty(Context context, String str) {
        if (context == null) {
            LogConsole.e(TAG, "context is null.");
            return "";
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -820075192:
                if (str.equals("vendor")) {
                    c11 = 0;
                    break;
                }
                break;
            case -266464859:
                if (str.equals(DeviceProperty.USERTYPE)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1336193813:
                if (str.equals(DeviceProperty.EMULATOR)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return getVendor();
            case 1:
                return getUserType(context);
            case 2:
                return getEmulator();
            default:
                return "";
        }
    }

    private static String getEmulator() {
        String emulator = SystemPropertiesUtil.getEmulator();
        LogConsole.d(TAG, "getEmulator: " + emulator);
        return ("1".equalsIgnoreCase(emulator) ? Boolean.TRUE : Boolean.FALSE).toString();
    }

    private static String getHwSystemProperties() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.PackageManagerEx");
            Object invoke = cls.getDeclaredMethod("getHwSystemAvailableFeatures", new Class[0]).invoke(cls, new Object[0]);
            return invoke instanceof FeatureInfo[] ? checkNormalOrKid((FeatureInfo[]) invoke) : "normal";
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e11) {
            LogConsole.e(TAG, "Didn't find class: " + e11.getMessage());
            return "normal";
        } catch (Throwable th2) {
            LogConsole.w(TAG, "Failed to resolve class: " + th2.getMessage());
            return "normal";
        }
    }

    public static synchronized String getManufacturer() {
        synchronized (DeviceInfoUtil.class) {
            if (!TextUtils.isEmpty(pubMfc)) {
                String str = pubMfc;
                return str;
            }
            pubMfc = Build.MANUFACTURER;
            String str2 = pubMfc;
            return str2;
        }
    }

    private static int getTypeFromDTypeList(Set<String> set) {
        LogConsole.d(TAG, "androidFeaturesNickNames :" + set);
        int i11 = -1;
        for (String next : set) {
            for (DeviceType deviceType2 : D_TYPE_LIST) {
                if (next.equals(deviceType2.androidFeature)) {
                    i11 = deviceType2.f50155id;
                    if (!deviceType2.hwHasSubFeatures) {
                        continue;
                        break;
                    }
                }
            }
            if (i11 != -1) {
                break;
            }
        }
        return i11;
    }

    private static String getUserType(Context context) throws InvalidParameterException {
        StringBuilder sb2;
        String str;
        if (!userType.isEmpty()) {
            sb2 = new StringBuilder();
            str = "get userType from cache: ";
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    userType = checkNormalOrKid(packageManager.getSystemAvailableFeatures());
                } catch (RuntimeException unused) {
                    LogConsole.e(TAG, "Package  manager  has  died Exception");
                }
                if (!userType.equalsIgnoreCase(USERTYPE_KID)) {
                    userType = getHwSystemProperties();
                }
                sb2 = new StringBuilder();
                str = "getUserType: ";
            } else {
                throw new InvalidParameterException("context.getPackageManger is null.");
            }
        }
        sb2.append(str);
        sb2.append(userType);
        LogConsole.i(TAG, sb2.toString());
        return userType;
    }

    private static String getVendor() {
        String vendor = SystemPropertiesUtil.getVendor();
        LogConsole.i(TAG, "getVendor: " + vendor);
        return vendor;
    }

    public static boolean isBloomDevice() {
        return getDeviceFeature(ContextUtil.getContext()) == 1 && TextUtils.equals(getDeviceProperty(ContextUtil.getContext(), DeviceProperty.USERTYPE), USERTYPE_KID);
    }

    public static boolean isCar(Context context) {
        return getDeviceFeature(context) == 8;
    }

    public static boolean isHuaweiWatch() {
        return isWatch() && ROMUtil.isHuaweiPlatformDevice();
    }

    public static boolean isHwDialogThemeForCar(Context context) {
        return isSupportFeatureForCar(context, HUAWEI_FEATURE_DIALOG);
    }

    public static boolean isSupportFeature(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                for (FeatureInfo featureInfo : context.getPackageManager().getSystemAvailableFeatures()) {
                    String str2 = featureInfo.name;
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, str)) {
                        return true;
                    }
                }
                return false;
            } catch (RuntimeException unused) {
                LogConsole.e(TAG, "feature get failure");
            }
        }
        return false;
    }

    private static boolean isSupportFeatureForCar(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !isCar(context)) {
            return false;
        }
        return isSupportFeature(context, str);
    }

    public static boolean isWatch() {
        return getDeviceFeature(ContextUtil.getContext()) == 2;
    }

    private static String parseNickNameByAndroidFeature(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = FEATURE_ANDROID;
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            String str3 = strArr[i11];
            if (str.startsWith(str3)) {
                str2 = str.substring(str3.length());
                break;
            }
            i11++;
        }
        LogConsole.d(TAG, "featureInfoName relative nick name :" + str2);
        return str2;
    }
}
