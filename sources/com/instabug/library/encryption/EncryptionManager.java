package com.instabug.library.encryption;

import android.util.Base64;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.encryption.iv.a;
import com.instabug.library.util.InstabugSDKLogger;
import java.nio.charset.Charset;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EncryptionManager {
    @NotNull
    private static final String AES_MODE = "AES/GCM/NoPadding";
    @NotNull
    private static final String ENCRYPTION_NEW_LINE_REPLACEMENT = "^instaLINE^";
    @NotNull
    private static final String ENCRYPTION_PREFIX = "^instaEncrypted^";
    @NotNull
    public static final EncryptionManager INSTANCE = new EncryptionManager();
    private static final int IV_LENGTH = 128;
    public static final int IV_V1 = 1;
    public static final int IV_V2 = 2;
    @NotNull
    public static final String LINE_FEED = "\n\r";
    @NotNull

    /* renamed from: iv  reason: collision with root package name */
    private static final byte[] f34340iv;

    static {
        byte[] bytes = "RandomAESIv1".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        f34340iv = bytes;
    }

    private EncryptionManager() {
    }

    @JvmStatic
    @Nullable
    public static final String decrypt(@Nullable String str) {
        return decrypt(str, 1);
    }

    @JvmStatic
    @Nullable
    public static final String decryptWithStaticKey(@Nullable String str) {
        boolean z11;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        EncryptionManager encryptionManager = INSTANCE;
        String replace$default = StringsKt__StringsJVMKt.replace$default(str, ENCRYPTION_NEW_LINE_REPLACEMENT, StringUtils.LF, false, 4, (Object) null);
        try {
            byte[] decode = Base64.decode(replace$default, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "{\n                Base64…          )\n            }");
            try {
                Cipher instance = Cipher.getInstance(AES_MODE);
                instance.init(2, StaticKeyProvider.a(), encryptionManager.getIvSpec());
                byte[] doFinal = instance.doFinal(decode);
                Intrinsics.checkNotNullExpressionValue(doFinal, "decryptedBytes");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                return new String(doFinal, forName);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while decrypting string, returning original string");
                IBGDiagnostics.reportNonFatal(e11, "Error: " + e11.getMessage() + "while decrypting string, returning original string");
                return str;
            } catch (OutOfMemoryError e12) {
                InstabugSDKLogger.e("IBG-Core", "OOM while decrypting string, returning original string");
                IBGDiagnostics.reportNonFatal(e12, "OOM while decrypting string, returning original string");
                return str;
            }
        } catch (IllegalArgumentException unused) {
            return replace$default;
        }
    }

    @JvmStatic
    @Nullable
    public static final String encrypt(@Nullable String str) {
        return encrypt(str, 1);
    }

    @JvmStatic
    @Nullable
    public static final String encryptWithStaticKey(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            EncryptionManager encryptionManager = INSTANCE;
            if (StringsKt__StringsJVMKt.startsWith$default(str, ENCRYPTION_PREFIX, false, 2, (Object) null)) {
                return str;
            }
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(1, StaticKeyProvider.a(), encryptionManager.getIvSpec());
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] doFinal = instance.doFinal(bytes);
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(data.toByteArray())");
            String encodeToString = Base64.encodeToString(doFinal, 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(cipherText, Base64.DEFAULT)");
            return StringsKt__StringsJVMKt.replace$default(encodeToString, StringUtils.LF, ENCRYPTION_NEW_LINE_REPLACEMENT, false, 4, (Object) null);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatalAndLog(e11, "Error while encrypting string, returning original string", "IBG-Core");
            return str;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatalAndLog(e12, "OOM while encrypting string, returning original string", "IBG-Core");
            return str;
        }
    }

    private final AlgorithmParameterSpec getIvSpec() {
        return new GCMParameterSpec(96, f34340iv);
    }

    private final synchronized AlgorithmParameterSpec getIvSpecV2() {
        return new GCMParameterSpec(128, a.a());
    }

    @NotNull
    public final byte[] getIv() {
        return f34340iv;
    }

    @JvmStatic
    @Nullable
    public static final String decrypt(@Nullable String str, int i11) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        EncryptionManager encryptionManager = INSTANCE;
        if (!StringsKt__StringsJVMKt.startsWith$default(str, ENCRYPTION_PREFIX, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(16, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            byte[] decode = Base64.decode(StringsKt__StringsJVMKt.replace$default(substring, ENCRYPTION_NEW_LINE_REPLACEMENT, StringUtils.LF, false, 4, (Object) null), 0);
            Intrinsics.checkNotNullExpressionValue(decode, "{\n                Base64…          )\n            }");
            try {
                Cipher instance = Cipher.getInstance(AES_MODE);
                instance.init(2, c.a(), i11 == 1 ? encryptionManager.getIvSpec() : encryptionManager.getIvSpecV2());
                byte[] doFinal = instance.doFinal(decode);
                Intrinsics.checkNotNullExpressionValue(doFinal, "decryptedBytes");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                return new String(doFinal, forName);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while decrypting string, returning original string");
                IBGDiagnostics.reportNonFatal(e11, "Error: " + e11.getMessage() + "while decrypting string, returning original string");
                return str;
            } catch (OutOfMemoryError e12) {
                InstabugSDKLogger.e("IBG-Core", "OOM while decrypting string, returning original string");
                IBGDiagnostics.reportNonFatal(e12, "OOM while decrypting string, returning original string");
                return str;
            }
        } catch (IllegalArgumentException unused) {
            return substring;
        }
    }

    @JvmStatic
    @Nullable
    public static final String encrypt(@Nullable String str, int i11) {
        if (str == null) {
            return null;
        }
        try {
            EncryptionManager encryptionManager = INSTANCE;
            if (StringsKt__StringsJVMKt.startsWith$default(str, ENCRYPTION_PREFIX, false, 2, (Object) null)) {
                return str;
            }
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(1, c.a(), i11 == 1 ? encryptionManager.getIvSpec() : encryptionManager.getIvSpecV2());
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] doFinal = instance.doFinal(bytes);
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(data.toByteArray())");
            String encodeToString = Base64.encodeToString(doFinal, 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(cipherText, Base64.DEFAULT)");
            return Intrinsics.stringPlus(ENCRYPTION_PREFIX, StringsKt__StringsJVMKt.replace$default(encodeToString, StringUtils.LF, ENCRYPTION_NEW_LINE_REPLACEMENT, false, 4, (Object) null));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while encrypting string, returning original string");
            IBGDiagnostics.reportNonFatal(e11, "Error: " + e11.getMessage() + "while encrypting string, returning original string");
            return str;
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "OOM while encrypting string, returning original string");
            IBGDiagnostics.reportNonFatal(e12, "OOM while encrypting string, returning original string");
            return str;
        }
    }

    @JvmStatic
    @NotNull
    public static final byte[] encrypt(@NotNull byte[] bArr) throws Exception, OutOfMemoryError {
        Intrinsics.checkNotNullParameter(bArr, "data");
        try {
            EncryptionManager encryptionManager = INSTANCE;
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(1, c.a(), encryptionManager.getIvSpec());
            byte[] doFinal = instance.doFinal(bArr);
            Intrinsics.checkNotNullExpressionValue(doFinal, "{\n            val cipher…r.doFinal(data)\n        }");
            return doFinal;
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Error while encrypting bytes");
            return bArr;
        }
    }

    @JvmStatic
    @NotNull
    public static final byte[] decrypt(@NotNull byte[] bArr) throws Exception, OutOfMemoryError {
        Intrinsics.checkNotNullParameter(bArr, "data");
        try {
            EncryptionManager encryptionManager = INSTANCE;
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(2, c.a(), encryptionManager.getIvSpec());
            byte[] doFinal = instance.doFinal(bArr);
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(data)");
            return doFinal;
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Error while decrypting bytes");
            return bArr;
        }
    }
}
