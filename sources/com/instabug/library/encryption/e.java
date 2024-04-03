package com.instabug.library.encryption;

import android.app.Application;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.contentprovider.a;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f34348a = new e();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static KeyStore f34349b;

    static {
        if (f34349b == null) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                f34349b = instance;
                if (instance != null) {
                    instance.load((KeyStore.LoadStoreParameter) null);
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while instantiating keystore");
                IBGDiagnostics.reportNonFatal(e11, "Error while instantiating keystore");
                f34349b = null;
            }
        }
    }

    private e() {
    }

    private final String a(byte[] bArr) {
        KeyStore keyStore = f34349b;
        if (keyStore == null) {
            return "";
        }
        try {
            Intrinsics.checkNotNull(keyStore);
            KeyStore.Entry entry = keyStore.getEntry("rsa_keys", (KeyStore.ProtectionParameter) null);
            if (entry != null) {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(RSA_MODE, \"AndroidOpenSSL\")");
                instance.init(1, ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
                cipherOutputStream.write(bArr);
                cipherOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
                return Base64.encodeToString(byteArray, 0);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while encrypting key using RSA");
            IBGDiagnostics.reportNonFatal(e11, "Error while encrypting key using RSA");
            return "";
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "OOM while encrypting key using RSA");
            IBGDiagnostics.reportNonFatal(e12, "OOM while encrypting key using RSA");
            return "";
        }
    }

    @RequiresApi(18)
    private final void b() {
        Application a11;
        a b11 = a.b();
        if (b11 != null && (a11 = b11.a()) != null) {
            try {
                Calendar instance = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
                Calendar instance2 = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "getInstance()");
                instance2.add(1, 30);
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(a11).setAlias("rsa_keys").setSubject(new X500Principal("CN=rsa_keys")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(it)\n            …                 .build()");
                KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                Intrinsics.checkNotNullExpressionValue(instance3, "getInstance(\"RSA\", androidKeyStore)");
                instance3.initialize(build);
                instance3.generateKeyPair();
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while generating RSA keys");
                IBGDiagnostics.reportNonFatal(e11, "Error while generating RSA keys");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @RequiresApi(18)
    @JvmStatic
    @Nullable
    public static final Key c() {
        boolean z11;
        a aVar = a.f34342a;
        boolean z12 = false;
        if (aVar.b().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f34348a.a();
        }
        byte[] a11 = f34348a.a(aVar.b());
        if (a11 != null) {
            if (a11.length == 0) {
                z12 = true;
            }
            if (!z12) {
                return new SecretKeySpec(a11, "AES");
            }
        }
        return null;
    }

    private final byte[] a(String str) {
        if (f34349b == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(encrypted, DEFAULT)");
            KeyStore keyStore = f34349b;
            KeyStore.Entry entry = keyStore == null ? null : keyStore.getEntry("rsa_keys", (KeyStore.ProtectionParameter) null);
            if (entry != null) {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(RSA_MODE, \"AndroidOpenSSL\")");
                instance.init(2, ((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
                CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(decode), instance);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int read = cipherInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    arrayList.add(Byte.valueOf((byte) read));
                }
                int size = arrayList.size();
                byte[] bArr = new byte[size];
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj = arrayList.get(i11);
                    Intrinsics.checkNotNullExpressionValue(obj, "values[i]");
                    bArr[i11] = ((Number) obj).byteValue();
                }
                return bArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.KeyStore.PrivateKeyEntry");
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while decrypting encryption key using RSA");
            IBGDiagnostics.reportNonFatal(e11, "Error while decrypting encryption key using RSA");
            return null;
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "OOM while decrypting key using RSA");
            IBGDiagnostics.reportNonFatal(e12, "OOM while decrypting encryption key using RSA");
            return null;
        }
    }

    @RequiresApi(18)
    public final void a() {
        KeyStore keyStore = f34349b;
        if (keyStore != null) {
            boolean z11 = true;
            if (!keyStore.containsAlias("rsa_keys")) {
                z11 = false;
            }
            if (!z11) {
                b();
            }
        }
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        String a11 = a(bArr);
        a aVar = a.f34342a;
        if (a11 == null) {
            a11 = "";
        }
        aVar.b(a11);
    }
}
