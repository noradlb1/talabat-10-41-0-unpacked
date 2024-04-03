package com.instabug.library.networkv2.service.synclogs;

import com.instabug.library.util.InstabugSDKLogger;

public class SyncLogKeyProvider implements a {
    static {
        try {
            System.loadLibrary("ibg-native");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static native String getNativeMatchingEmailPrefix();

    public static native String getNativeMatchingEmailSuffix();

    public static native String getNativeMatchingUuidPrefix();

    public static native String getNativeMatchingUuidSuffix();

    public static native String getNativeSyncingEmailPrefix();

    public static native String getNativeSyncingEmailSuffix();

    public static native String getNativeSyncingUuidPrefix();

    public static native String getNativeSyncingUuidSuffix();

    public String a() {
        try {
            return getNativeSyncingEmailSuffix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String b() {
        try {
            return getNativeSyncingEmailPrefix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String c() {
        try {
            return getNativeMatchingEmailSuffix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String d() {
        try {
            return getNativeSyncingUuidPrefix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String e() {
        try {
            return getNativeMatchingUuidSuffix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String f() {
        try {
            return getNativeMatchingUuidPrefix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String g() {
        try {
            return getNativeMatchingEmailPrefix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }

    public String h() {
        try {
            return getNativeSyncingUuidSuffix();
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native method", e11);
            return "";
        }
    }
}
