package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import android.os.Build;
import com.adjust.sdk.Constants;
import com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static KeyStore f44869a;

    /* renamed from: b  reason: collision with root package name */
    public static b0 f44870b = new b0();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f44871c = new Object();

    public static b0 a() throws UcsKeyStoreException {
        if (f44869a == null) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                f44869a = instance;
                instance.load((KeyStore.LoadStoreParameter) null);
                LogUcs.i("KeyStoreManager", "initKeyStore ok", new Object[0]);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e11) {
                LogUcs.e("KeyStoreManager", "initKeyStore failed, " + e11.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "initKeyStore failed , exception " + e11.getMessage());
            }
        }
        return f44870b;
    }

    public static boolean a(Context context) {
        return SpUtil.getInt("ucs_keystore_sp_key_t", -1, context) == 1;
    }

    public static void b(Context context) {
        boolean z11;
        if (SpUtil.getInt("ucs_keystore_sp_key_t", -1, context) == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            LogUcs.i("KeyStoreManager", "keyStoreRootKey status already init", new Object[0]);
        } else if (Build.VERSION.SDK_INT >= 24) {
            SpUtil.putInt("ucs_keystore_sp_key_t", 1, context);
        } else {
            c(context);
        }
    }

    public static void c(Context context) {
        SpUtil.putInt("ucs_keystore_sp_key_t", 0, context);
    }

    public final PrivateKey a(String str) throws UcsKeyStoreException {
        try {
            return (PrivateKey) f44869a.getKey(str, (char[]) null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e11) {
            LogUcs.e("KeyStoreManager", "getPrivateKey failed, " + e11.getMessage(), new Object[0]);
            throw new UcsKeyStoreException(1022, "getPrivateKey failed , exception " + e11.getMessage());
        }
    }

    public byte[] a(String str, byte[] bArr) throws UcsKeyStoreException {
        byte[] doFinal;
        synchronized (f44871c) {
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                instance.init(2, a(str), new OAEPParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
                instance.update(bArr);
                doFinal = instance.doFinal();
            } catch (NoSuchAlgorithmException e11) {
                e = e11;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (InvalidKeyException e12) {
                e = e12;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (NoSuchPaddingException e13) {
                e = e13;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (BadPaddingException e14) {
                e = e14;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (IllegalBlockSizeException e15) {
                e = e15;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (InvalidAlgorithmParameterException e16) {
                e = e16;
                LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                throw new UcsKeyStoreException(1022, "doDecrypt failed , exception " + e.getMessage());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return doFinal;
    }
}
