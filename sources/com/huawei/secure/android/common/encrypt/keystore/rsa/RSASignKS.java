package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public abstract class RSASignKS {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33780a = "RSASignKS";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33781b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33782c = "SHA256withRSA/PSS";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33783d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33784e = 2048;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33785f = 3072;

    private static byte[] a(String str, byte[] bArr, boolean z11) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33780a, "alias or content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.b(f33780a, "sdk version is too low");
            return bArr2;
        } else {
            KeyStore.Entry b11 = b(str, z11);
            if (!(b11 instanceof KeyStore.PrivateKeyEntry)) {
                b.b(f33780a, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature instance = Signature.getInstance(f33782c);
                instance.initSign(((KeyStore.PrivateKeyEntry) b11).getPrivateKey());
                instance.update(bArr);
                return instance.sign();
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33780a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (SignatureException e12) {
                String str3 = f33780a;
                b.b(str3, "SignatureException: " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                String str4 = f33780a;
                b.b(str4, "InvalidKeyException: " + e13.getMessage());
                return bArr2;
            } catch (Exception e14) {
                String str5 = f33780a;
                b.b(str5, "Exception: " + e14.getMessage());
                return bArr2;
            }
        }
    }

    private static KeyStore.Entry b(String str, boolean z11) {
        if (!a(str)) {
            a(str, z11);
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance.getEntry(str, (KeyStore.ProtectionParameter) null);
        } catch (KeyStoreException e11) {
            String str2 = f33780a;
            b.b(str2, "KeyStoreException: " + e11.getMessage());
            return null;
        } catch (CertificateException e12) {
            String str3 = f33780a;
            b.b(str3, "CertificateException: " + e12.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e13) {
            String str4 = f33780a;
            b.b(str4, "NoSuchAlgorithmException: " + e13.getMessage());
            return null;
        } catch (IOException e14) {
            String str5 = f33780a;
            b.b(str5, "IOException: " + e14.getMessage());
            return null;
        } catch (UnrecoverableEntryException e15) {
            String str6 = f33780a;
            b.b(str6, "UnrecoverableEntryException: " + e15.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return true;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33780a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33780a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e11.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e11) {
            String str4 = f33780a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e11.getMessage());
            return false;
        } catch (Exception e12) {
            String str5 = f33780a;
            b.b(str5, "base64 decode Exception" + e12.getMessage());
            return false;
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e11) {
            String str4 = f33780a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e11.getMessage());
            return false;
        } catch (Exception e12) {
            String str5 = f33780a;
            b.b(str5, "base64 decode Exception" + e12.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z11) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr2 == null) {
            b.b(f33780a, "alias or content or sign value is null");
            return false;
        } else if (!isBuildVersionHigherThan22()) {
            b.b(f33780a, "sdk version is too low");
            return false;
        } else {
            KeyStore.Entry b11 = b(str, z11);
            if (!(b11 instanceof KeyStore.PrivateKeyEntry)) {
                b.b(f33780a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature instance = Signature.getInstance(f33782c);
                instance.initVerify(((KeyStore.PrivateKeyEntry) b11).getCertificate());
                instance.update(bArr);
                return instance.verify(bArr2);
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33780a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
                return false;
            } catch (SignatureException e12) {
                String str3 = f33780a;
                b.b(str3, "SignatureException: " + e12.getMessage());
                return false;
            } catch (InvalidKeyException e13) {
                String str4 = f33780a;
                b.b(str4, "InvalidKeyException: " + e13.getMessage());
                return false;
            } catch (Exception e14) {
                String str5 = f33780a;
                b.b(str5, "Exception: " + e14.getMessage());
                return false;
            }
        }
    }

    private static synchronized KeyPair a(String str, boolean z11) {
        KeyPair keyPair;
        synchronized (RSASignKS.class) {
            keyPair = null;
            if (a(str)) {
                b.b(f33780a, "Key pair exits");
                return null;
            }
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                if (!z11) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(new String[]{Constants.SHA256, "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(new String[]{Constants.SHA256, "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(3072).build());
                }
                keyPair = instance.generateKeyPair();
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33780a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
            } catch (NoSuchProviderException e12) {
                String str3 = f33780a;
                b.b(str3, "NoSuchProviderException: " + e12.getMessage());
            } catch (InvalidAlgorithmParameterException e13) {
                String str4 = f33780a;
                b.b(str4, "InvalidAlgorithmParameterException: " + e13.getMessage());
            }
        }
        return keyPair;
    }

    private static boolean a(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            if (instance.getKey(str, (char[]) null) != null) {
                return true;
            }
            return false;
        } catch (KeyStoreException e11) {
            String str2 = f33780a;
            b.b(str2, "KeyStoreException: " + e11.getMessage());
            return false;
        } catch (CertificateException e12) {
            String str3 = f33780a;
            b.b(str3, "CertificateException: " + e12.getMessage());
            return false;
        } catch (UnrecoverableKeyException e13) {
            String str4 = f33780a;
            b.b(str4, "UnrecoverableKeyException: " + e13.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e14) {
            String str5 = f33780a;
            b.b(str5, "NoSuchAlgorithmException: " + e14.getMessage());
            return false;
        } catch (IOException e15) {
            String str6 = f33780a;
            b.b(str6, "IOException: " + e15.getMessage());
            return false;
        }
    }
}
