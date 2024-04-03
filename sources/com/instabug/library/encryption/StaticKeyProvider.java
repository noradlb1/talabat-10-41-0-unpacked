package com.instabug.library.encryption;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StaticKeyProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final StaticKeyProvider f34341a = new StaticKeyProvider();

    static {
        try {
            System.loadLibrary("ibg-native");
        } catch (UnsatisfiedLinkError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native library while getting static encryption key");
            IBGDiagnostics.reportNonFatal(e11, "Error loading native library");
        }
    }

    private StaticKeyProvider() {
    }

    @JvmStatic
    @Nullable
    public static final Key a() {
        try {
            byte[] bytes = getKeyString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new SecretKeySpec(bytes, "AES");
        } catch (UnsatisfiedLinkError unused) {
            InstabugSDKLogger.e("IBG-Core", "Error loading native library while getting static encryption key");
            return null;
        }
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final native String getKeyString();
}
