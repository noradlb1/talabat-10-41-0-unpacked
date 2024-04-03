package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogConsole;

public class Transform {
    private static final String TAG = "Transform";

    static {
        String str;
        try {
            System.loadLibrary(TAG);
            LogConsole.i(TAG, "load Transform Library.");
            return;
        } catch (SecurityException unused) {
            str = "load Transform Library failed because of SecurityException.";
        } catch (UnsatisfiedLinkError unused2) {
            str = "load Transform Library failed because of UnsatisfiedLinkError.";
        } catch (Exception unused3) {
            str = "load Transform Library failed.";
        }
        LogConsole.e(TAG, str);
    }

    public static native double[] gcj02to84Native(double d11, double d12);

    public static native double[] wgs84to02Native(double d11, double d12);
}
