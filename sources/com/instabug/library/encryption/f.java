package com.instabug.library.encryption;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.google.android.gms.stats.CodePackage;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f34350a = new f();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f34351b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static KeyStore f34352c;

    static {
        char[] charArray = "aes_key_password".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        f34351b = charArray;
        if (f34352c == null) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                f34352c = instance;
                if (instance != null) {
                    instance.load((KeyStore.LoadStoreParameter) null);
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while instantiating keystore");
                IBGDiagnostics.reportNonFatal(e11, "Error while instantiating keystore");
                f34352c = null;
            }
        }
    }

    private f() {
    }

    @RequiresApi(23)
    private final void a() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(KeyPropertie…THM_AES, androidKeyStore)");
            instance.init(new KeyGenParameterSpec.Builder("aes_key", 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).setRandomizedEncryptionRequired(false).build());
            instance.generateKey();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Failed to generate encryption key using keystore");
            IBGDiagnostics.reportNonFatal(e11, "Failed to generate encryption key using keystore");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (r0.containsAlias("aes_key") == true) goto L_0x0010;
     */
    @androidx.annotation.RequiresApi(23)
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.security.Key b() {
        /*
            java.security.KeyStore r0 = f34352c
            java.lang.String r1 = "aes_key"
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            boolean r0 = r0.containsAlias(r1)
            r2 = 1
            if (r0 != r2) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            if (r2 != 0) goto L_0x0017
            com.instabug.library.encryption.f r0 = f34350a
            r0.a()
        L_0x0017:
            java.security.KeyStore r0 = f34352c
            if (r0 != 0) goto L_0x001d
            r0 = 0
            goto L_0x0023
        L_0x001d:
            char[] r2 = f34351b
            java.security.Key r0 = r0.getKey(r1, r2)
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.encryption.f.b():java.security.Key");
    }
}
