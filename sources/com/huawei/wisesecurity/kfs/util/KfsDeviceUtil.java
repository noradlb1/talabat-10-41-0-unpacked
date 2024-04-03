package com.huawei.wisesecurity.kfs.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import com.huawei.wisesecurity.kfs.crypto.digest.DigestAlg;
import com.huawei.wisesecurity.kfs.crypto.digest.KfsDigest;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;

public class KfsDeviceUtil {
    public static final int MAGIC_SDK_INT = getSystemPropertiesInt("ro.build.magic_api_level", 0);
    public static final int MIN_MAGIC_API_LEVEL = 33;
    public static final String PREFERENCES_NAME = "com.huawei.wisesecurity.kfs.DeviceId";
    public static final String TAG = "KfsDeviceUtil";
    public static final String UUID_KEY = "UUID";
    public static String uuid = "";
    public static String uuidHash = "";

    public static String getAndroidId(Context context) throws KfsException {
        if (Build.VERSION.SDK_INT >= 26) {
            String upperCase = Settings.Secure.getString(context.getContentResolver(), "android_id").toUpperCase(Locale.US);
            if (!TextUtils.isEmpty(upperCase)) {
                return upperCase;
            }
            throw new KfsException("getAndroidId failed, androidId is null or empty");
        }
        throw new KfsException("Android version not support, min version is Android8(O)");
    }

    public static Class<?> getBuildExClass() throws KfsException {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getUDID MAGIC_SDK_INT:");
            int i11 = MAGIC_SDK_INT;
            sb2.append(i11);
            Log.i(TAG, sb2.toString());
            if (i11 >= 33) {
                Log.i(TAG, "clazz name is com.hihonor.android.os.Build");
                str = "com.hihonor.android.os.Build";
            } else {
                Log.i(TAG, "clazz name is com.huawei.android.os.BuildEx");
                str = "com.huawei.android.os.BuildEx";
            }
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new KfsException("getBuildExClass get exception" + e11.getMessage());
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getIMEI(Context context) throws KfsException {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        throw new KfsException("getIMEI failed, imei is null or empty");
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getSN(Context context) throws KfsException {
        return KfsDigest.getDigestHandler(DigestAlg.SHA256).from(getSerial(context)).digestHex();
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getSerial(Context context) throws KfsException {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    str = Build.getSerial();
                } else {
                    throw new KfsException("getSN failed, read phone state permission not permit");
                }
            } catch (SecurityException e11) {
                throw new KfsException("getSN get exception, " + e11.getMessage());
            }
        } else {
            str = Build.SERIAL;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new KfsException("getSN failed, SN is null or empty");
    }

    public static int getSystemPropertiesInt(String str, int i11) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{str, Integer.valueOf(i11)});
            if (invoke == null) {
                return 0;
            }
            return ((Integer) invoke).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            Log.e(TAG, "An exception occurred while reading SystemProperties: " + str);
            return i11;
        }
    }

    public static String getUDID() throws KfsException {
        try {
            Method declaredMethod = getBuildExClass().getDeclaredMethod("getUDID", new Class[0]);
            declaredMethod.setAccessible(true);
            String str = (String) declaredMethod.invoke((Object) null, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new KfsException("getUDID failed, udid is null or empty");
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            throw new KfsException("getUDID get exception, " + e11.getMessage());
        }
    }

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(uuid)) {
            return uuid;
        }
        SharedPreferences sharedPreferences = (Build.VERSION.SDK_INT >= 24 ? context.createDeviceProtectedStorageContext() : context.getApplicationContext()).getSharedPreferences(PREFERENCES_NAME, 0);
        String string = sharedPreferences.getString("UUID", "");
        uuid = string;
        if (TextUtils.isEmpty(string)) {
            uuid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("UUID", uuid).apply();
        }
        return uuid;
    }

    public static String getUUIDHash(Context context) throws CryptoException {
        if (TextUtils.isEmpty(uuidHash)) {
            uuidHash = KfsDigest.getDigestHandler(DigestAlg.SHA256).from(getUUID(context)).digestHex();
        }
        return uuidHash;
    }
}
