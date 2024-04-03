package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public abstract class RSAEncryptKS {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33774a = "RSAEncryptKS";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33775b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33776c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33777d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f33778e = 2048;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33779f = 3072;

    private static boolean a() {
        return true;
    }

    private static byte[] a(String str, byte[] bArr, boolean z11) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33774a, "alias or content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33774a, "sdk version is too low");
            return bArr2;
        } else {
            PublicKey b11 = b(str, z11);
            if (b11 == null) {
                b.b(f33774a, "Public key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(f33776c);
                instance.init(1, b11, new OAEPParameterSpec(Constants.SHA256, "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33774a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                String str3 = f33774a;
                b.b(str3, "NoSuchPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                String str4 = f33774a;
                b.b(str4, "InvalidKeyException: " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                String str5 = f33774a;
                b.b(str5, "InvalidAlgorithmParameterException: " + e14.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e15) {
                String str6 = f33774a;
                b.b(str6, "IllegalBlockSizeException: " + e15.getMessage());
                return bArr2;
            } catch (BadPaddingException e16) {
                String str7 = f33774a;
                b.b(str7, "BadPaddingException: " + e16.getMessage());
                return bArr2;
            } catch (Exception e17) {
                String str8 = f33774a;
                b.b(str8, "Exception: " + e17.getMessage());
                return bArr2;
            }
        }
    }

    private static PublicKey b(String str, boolean z11) {
        if (!b(str)) {
            a(str, z11);
        }
        Certificate c11 = c(str);
        if (c11 != null) {
            return c11.getPublicKey();
        }
        return null;
    }

    private static Certificate c(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance.getCertificate(str);
        } catch (KeyStoreException e11) {
            String str2 = f33774a;
            b.b(str2, "KeyStoreException: " + e11.getMessage());
            return null;
        } catch (CertificateException e12) {
            String str3 = f33774a;
            b.b(str3, "CertificateException: " + e12.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e13) {
            String str4 = f33774a;
            b.b(str4, "NoSuchAlgorithmException: " + e13.getMessage());
            return null;
        } catch (IOException e14) {
            String str5 = f33774a;
            b.b(str5, "IOException: " + e14.getMessage());
            return null;
        } catch (Exception e15) {
            String str6 = f33774a;
            b.b(str6, "Exception: " + e15.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33774a;
            b.b(str3, "UnsupportedEncodingException: " + e11.getMessage());
            return "";
        } catch (Exception e12) {
            String str4 = f33774a;
            b.b(str4, "Exception: " + e12.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33774a;
            b.b(str3, "UnsupportedEncodingException: " + e11.getMessage());
            return "";
        } catch (Exception e12) {
            String str4 = f33774a;
            b.b(str4, "Exception: " + e12.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33774a;
            b.b(str3, "UnsupportedEncodingException: " + e11.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33774a;
            b.b(str3, "UnsupportedEncodingException: " + e11.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(f33774a, "alias or encrypted content is null");
            return bArr2;
        } else if (!a()) {
            b.b(f33774a, "sdk version is too low");
            return bArr2;
        } else {
            PrivateKey a11 = a(str);
            if (a11 == null) {
                b.b(f33774a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(f33776c);
                instance.init(2, a11, new OAEPParameterSpec(Constants.SHA256, "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33774a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e12) {
                String str3 = f33774a;
                b.b(str3, "NoSuchPaddingException: " + e12.getMessage());
                return bArr2;
            } catch (InvalidKeyException e13) {
                String str4 = f33774a;
                b.b(str4, "InvalidKeyException: " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                String str5 = f33774a;
                b.b(str5, "InvalidAlgorithmParameterException: " + e14.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e15) {
                String str6 = f33774a;
                b.b(str6, "IllegalBlockSizeException: " + e15.getMessage());
                return bArr2;
            } catch (BadPaddingException e16) {
                String str7 = f33774a;
                b.b(str7, "BadPaddingException: " + e16.getMessage());
                return bArr2;
            } catch (Exception e17) {
                String str8 = f33774a;
                b.b(str8, "Exception: " + e17.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    private static boolean b(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            if (instance.getKey(str, (char[]) null) != null) {
                return true;
            }
            return false;
        } catch (KeyStoreException e11) {
            String str2 = f33774a;
            b.b(str2, "KeyStoreException: " + e11.getMessage());
            return false;
        } catch (CertificateException e12) {
            String str3 = f33774a;
            b.b(str3, "CertificateException: " + e12.getMessage());
            return false;
        } catch (UnrecoverableKeyException e13) {
            String str4 = f33774a;
            b.b(str4, "UnrecoverableKeyException: " + e13.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e14) {
            String str5 = f33774a;
            b.b(str5, "NoSuchAlgorithmException: " + e14.getMessage());
            return false;
        } catch (IOException e15) {
            String str6 = f33774a;
            b.b(str6, "IOException: " + e15.getMessage());
            return false;
        } catch (Exception e16) {
            String str7 = f33774a;
            b.b(str7, "Exception: " + e16.getMessage());
            return false;
        }
    }

    private static synchronized KeyPair a(String str, boolean z11) {
        KeyPair keyPair;
        synchronized (RSAEncryptKS.class) {
            keyPair = null;
            if (b(str)) {
                b.b(f33774a, "Key pair exits");
                return null;
            }
            b.c(f33774a, "generate key pair.");
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                if (!z11) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(new String[]{Constants.SHA256, "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(new String[]{Constants.SHA256, "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(3072).build());
                }
                keyPair = instance.generateKeyPair();
            } catch (NoSuchAlgorithmException e11) {
                String str2 = f33774a;
                b.b(str2, "NoSuchAlgorithmException: " + e11.getMessage());
            } catch (NoSuchProviderException e12) {
                String str3 = f33774a;
                b.b(str3, "NoSuchProviderException: " + e12.getMessage());
            } catch (InvalidAlgorithmParameterException e13) {
                String str4 = f33774a;
                b.b(str4, "InvalidAlgorithmParameterException: " + e13.getMessage());
            } catch (Exception e14) {
                String str5 = f33774a;
                b.b(str5, "Exception: " + e14.getMessage());
            }
        }
        return keyPair;
    }

    private static PrivateKey a(String str) {
        if (!b(str)) {
            return null;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return (PrivateKey) instance.getKey(str, (char[]) null);
        } catch (KeyStoreException e11) {
            String str2 = f33774a;
            b.b(str2, "KeyStoreException: " + e11.getMessage());
            return null;
        } catch (CertificateException e12) {
            String str3 = f33774a;
            b.b(str3, "CertificateException: " + e12.getMessage());
            return null;
        } catch (UnrecoverableKeyException e13) {
            String str4 = f33774a;
            b.b(str4, "UnrecoverableKeyException: " + e13.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e14) {
            String str5 = f33774a;
            b.b(str5, "NoSuchAlgorithmException: " + e14.getMessage());
            return null;
        } catch (IOException e15) {
            String str6 = f33774a;
            b.b(str6, "IOException: " + e15.getMessage());
            return null;
        } catch (Exception e16) {
            String str7 = f33774a;
            b.b(str7, "Exception: " + e16.getMessage());
            return null;
        }
    }
}
