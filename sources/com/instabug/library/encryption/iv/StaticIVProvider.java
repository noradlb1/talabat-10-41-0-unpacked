package com.instabug.library.encryption.iv;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

public final class StaticIVProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final StaticIVProvider f34353a = new StaticIVProvider();

    static {
        try {
            System.loadLibrary("ibg-native");
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("StaticIVProvider", "Error loading native library", e11);
        }
    }

    private StaticIVProvider() {
    }

    @JvmStatic
    @NotNull
    public static final byte[] a() {
        int i11;
        Exception e11;
        try {
            String iVString = getIVString();
            i11 = iVString.length();
            try {
                byte[] bArr = new byte[i11];
                byte[] bytes = iVString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                System.arraycopy(bytes, 0, bArr, 0, i11);
                return bArr;
            } catch (Exception e12) {
                e11 = e12;
                InstabugSDKLogger.e("StaticIVProvider", "Error loading native initialization vector", e11);
                return new byte[i11];
            }
        } catch (Exception e13) {
            i11 = 0;
            e11 = e13;
            InstabugSDKLogger.e("StaticIVProvider", "Error loading native initialization vector", e11);
            return new byte[i11];
        }
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final native String getIVString();
}
