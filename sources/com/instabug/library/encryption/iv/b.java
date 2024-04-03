package com.instabug.library.encryption.iv;

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
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.security.auth.x500.X500Principal;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f34356a = new b();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static KeyStore f34357b;

    static {
        if (f34357b == null) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                f34357b = instance;
                if (instance != null) {
                    instance.load((KeyStore.LoadStoreParameter) null);
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while instantiating keystore", e11);
                f34357b = null;
            }
        }
    }

    private b() {
    }

    private final String a(byte[] bArr) {
        KeyStore keyStore = f34357b;
        if (keyStore == null) {
            return "";
        }
        try {
            KeyStore.Entry entry = keyStore.getEntry("iv_rsa_keys", (KeyStore.ProtectionParameter) null);
            if (entry != null) {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(RSA_MODE)");
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
            InstabugSDKLogger.e("IBG-Core", "Error while encrypting IV using RSA", e11);
            IBGDiagnostics.reportNonFatal(e11, "Error while encrypting IV using RSA");
            return "";
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "OOM while encrypting IV using RSA", e12);
            IBGDiagnostics.reportNonFatal(e12, "OOM while encrypting IV using RSA");
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
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(a11).setAlias("iv_rsa_keys").setSubject(new X500Principal("CN=iv_rsa_keys")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(it)\n            …                 .build()");
                KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                Intrinsics.checkNotNullExpressionValue(instance3, "getInstance(\"RSA\", androidKeyStore)");
                instance3.initialize(build);
                instance3.generateKeyPair();
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error while generating RSA keys", e11);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @RequiresApi(18)
    @JvmStatic
    @Nullable
    public static final byte[] c() {
        boolean z11;
        com.instabug.library.encryption.a aVar = com.instabug.library.encryption.a.f34342a;
        boolean z12 = false;
        if (aVar.a().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f34356a.a();
        }
        byte[] a11 = f34356a.a(aVar.a());
        if (a11 != null) {
            if (a11.length == 0) {
                z12 = true;
            }
            if (!z12) {
                return a11;
            }
        }
        return null;
    }

    private final byte[] a(String str) {
        KeyStore keyStore = f34357b;
        if (keyStore == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(encrypted, DEFAULT)");
            KeyStore.Entry entry = keyStore.getEntry("iv_rsa_keys", (KeyStore.ProtectionParameter) null);
            if (entry != null) {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(RSA_MODE)");
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
            InstabugSDKLogger.e("IBG-Core", "Error while decrypting encryption IV using RSA", e11);
            IBGDiagnostics.reportNonFatal(e11, "Error while decrypting encryption IV using RSA");
            return null;
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "OOM while decrypting IV using RSA", e12);
            IBGDiagnostics.reportNonFatal(e12, "OOM while decrypting encryption IV using RSA");
            return null;
        }
    }

    @RequiresApi(18)
    private final synchronized void a() {
        KeyStore keyStore = f34357b;
        if (keyStore != null) {
            boolean z11 = true;
            if (!keyStore.containsAlias("iv_rsa_keys")) {
                z11 = false;
            }
            if (!z11) {
                b();
            }
        }
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        String a11 = a(bArr);
        com.instabug.library.encryption.a aVar = com.instabug.library.encryption.a.f34342a;
        if (a11 == null) {
            a11 = "";
        }
        aVar.a(a11);
    }
}
