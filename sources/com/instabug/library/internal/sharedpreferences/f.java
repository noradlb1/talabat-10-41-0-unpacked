package com.instabug.library.internal.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.encryption.EncryptionManager;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Map;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f51018a = {"APM_SHARED_PREFERENCES", "SHARED_PREFERENCES_NDK_CRASHES", "com.instabug.chat"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f51019b = {"instabug_apm", "instabug_ndk_crashes", "instabug_chat"};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f51020c = {SettingsManager.INSTABUG_SHARED_PREF_NAME, "instabug_apm", "instabug_chat", "instabug_announcements", "instabug_bug_reporting", "instabug_crash", "instabug_survey", "instabug_ndk_crashes"};

    public static void b(boolean z11, @Nullable Context context) {
        if (context != null) {
            CoreServiceLocator.getSharedPreferencesExecutor().execute(new d(z11, context));
        }
    }

    private static String c(String str) {
        String encrypt = EncryptionManager.encrypt(str);
        return encrypt == null ? str : encrypt;
    }

    public static void a(boolean z11, @Nullable Context context) {
        if (context != null) {
            CoreServiceLocator.getSharedPreferencesExecutor().execute(new e(context, z11));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ApplySharedPref"})
    public static void b(Context context) {
        int i11 = 0;
        while (true) {
            String[] strArr = f51018a;
            if (i11 < strArr.length) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(strArr[i11], 0);
                SharedPreferences.Editor edit = context.getSharedPreferences(f51019b[i11], 0).edit();
                for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                    if (next.getValue().getClass().equals(Boolean.class)) {
                        edit.putBoolean((String) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                    } else if (next.getValue().getClass().equals(Float.class)) {
                        edit.putFloat((String) next.getKey(), ((Float) next.getValue()).floatValue());
                    } else if (next.getValue().getClass().equals(Integer.class)) {
                        edit.putInt((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    } else if (next.getValue().getClass().equals(Long.class)) {
                        edit.putLong((String) next.getKey(), ((Long) next.getValue()).longValue());
                    } else if (next.getValue().getClass().equals(String.class)) {
                        edit.putString((String) next.getKey(), (String) next.getValue());
                    }
                }
                edit.commit();
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.clear();
                edit2.commit();
                i11++;
            } else {
                return;
            }
        }
    }

    private static boolean a(String str) {
        String decrypt = EncryptionManager.decrypt(str);
        return decrypt != null && !str.equals(decrypt);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    @SuppressLint({"ApplySharedPref"})
    public static void b(String str, boolean z11, Context context) {
        InstabugSDKLogger.v("IBG-Core", "Migrating shared preferences file " + str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
            if (next.getValue() instanceof String) {
                String str2 = (String) next.getValue();
                if (!z11) {
                    str2 = b(str2);
                } else if (!a(str2)) {
                    str2 = c(str2);
                }
                edit.putString((String) next.getKey(), str2);
            }
        }
        edit.commit();
    }

    private static String b(String str) {
        String decrypt = EncryptionManager.decrypt(str);
        return decrypt == null ? str : decrypt;
    }
}
