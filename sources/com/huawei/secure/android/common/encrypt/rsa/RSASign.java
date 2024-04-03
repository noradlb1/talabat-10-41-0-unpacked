package com.huawei.secure.android.common.encrypt.rsa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

public abstract class RSASign {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33792a = "SHA256WithRSA";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33793b = "SHA256WithRSA/PSS";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33794c = "RSASign";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33795d = "UTF-8";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33796e = "";

    private static String a(String str, String str2, boolean z11) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f33794c, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        if (z11) {
            return newSign(str, privateKey);
        }
        return sign(str, privateKey);
    }

    public static boolean isBuildVersionHigherThan23() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static String newSign(String str, String str2) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, true);
        }
        b.b(f33794c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, str3, true);
        }
        b.b(f33794c, "sdk version is too low");
        return false;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return a(str, str2, str3, false);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return a(str, privateKey, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return a(str, str2, publicKey, false);
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z11) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(f33794c, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        if (z11) {
            try {
                signature = Signature.getInstance(f33793b);
                signature.setParameter(new PSSParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e11) {
                String str = f33794c;
                b.b(str, "sign NoSuchAlgorithmException: " + e11.getMessage());
                return bArr2;
            } catch (InvalidKeyException e12) {
                String str2 = f33794c;
                b.b(str2, "sign InvalidKeyException: " + e12.getMessage());
                return bArr2;
            } catch (SignatureException e13) {
                String str3 = f33794c;
                b.b(str3, "sign SignatureException: " + e13.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e14) {
                String str4 = f33794c;
                b.b(str4, "sign InvalidAlgorithmParameterException: " + e14.getMessage());
                return bArr2;
            } catch (Exception e15) {
                String str5 = f33794c;
                b.b(str5, "sign Exception: " + e15.getMessage());
                return bArr2;
            }
        } else {
            signature = Signature.getInstance(f33792a);
        }
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z11) {
        Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(f33794c, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z11) {
            try {
                signature = Signature.getInstance(f33793b);
                signature.setParameter(new PSSParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e11) {
                String str = f33794c;
                b.b(str, "check sign exception: " + e11.getMessage());
                return false;
            } catch (Exception e12) {
                String str2 = f33794c;
                b.b(str2, "exception : " + e12.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance(f33792a);
        }
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (isBuildVersionHigherThan23()) {
            return a(str, privateKey, true);
        }
        b.b(f33794c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, publicKey, true);
        }
        b.b(f33794c, "sdk version is too low");
        return false;
    }

    private static String a(String str, PrivateKey privateKey, boolean z11) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z11), 0);
        } catch (UnsupportedEncodingException e11) {
            String str2 = f33794c;
            b.b(str2, "sign UnsupportedEncodingException: " + e11.getMessage());
            return "";
        }
    }

    private static boolean a(String str, String str2, String str3, boolean z11) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            b.b(f33794c, "content or public key or sign value is null");
            return false;
        }
        RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
        if (z11) {
            return newVerifySign(str, str2, (PublicKey) publicKey);
        }
        return verifySign(str, str2, (PublicKey) publicKey);
    }

    private static boolean a(String str, String str2, PublicKey publicKey, boolean z11) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z11);
        } catch (UnsupportedEncodingException e11) {
            String str3 = f33794c;
            b.b(str3, "verifySign UnsupportedEncodingException: " + e11.getMessage());
            return false;
        } catch (Exception e12) {
            String str4 = f33794c;
            b.b(str4, "base64 decode Exception : " + e12.getMessage());
            return false;
        }
    }

    public static boolean verifySign(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z11) {
        Signature signature;
        if (byteBuffer == null || publicKey == null || bArr == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(f33794c, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z11) {
            try {
                signature = Signature.getInstance(f33793b);
                signature.setParameter(new PSSParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e11) {
                String str = f33794c;
                b.b(str, "check sign exception: " + e11.getMessage());
                return false;
            } catch (Exception e12) {
                String str2 = f33794c;
                b.b(str2, "exception : " + e12.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance(f33792a);
        }
        signature.initVerify(publicKey);
        signature.update(byteBuffer);
        return signature.verify(bArr);
    }

    public static byte[] sign(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z11) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(f33794c, "content or privateKey is null , or length is too short");
            return bArr;
        }
        if (z11) {
            try {
                signature = Signature.getInstance(f33793b);
                signature.setParameter(new PSSParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e11) {
                String str = f33794c;
                b.b(str, "sign NoSuchAlgorithmException: " + e11.getMessage());
                return bArr;
            } catch (InvalidKeyException e12) {
                String str2 = f33794c;
                b.b(str2, "sign InvalidKeyException: " + e12.getMessage());
                return bArr;
            } catch (SignatureException e13) {
                String str3 = f33794c;
                b.b(str3, "sign SignatureException: " + e13.getMessage());
                return bArr;
            } catch (InvalidAlgorithmParameterException e14) {
                String str4 = f33794c;
                b.b(str4, "sign InvalidAlgorithmParameterException: " + e14.getMessage());
                return bArr;
            } catch (Exception e15) {
                String str5 = f33794c;
                b.b(str5, "sign Exception: " + e15.getMessage());
                return bArr;
            }
        } else {
            signature = Signature.getInstance(f33792a);
        }
        signature.initSign(privateKey);
        signature.update(byteBuffer);
        byte[] sign = signature.sign();
        String str6 = f33794c;
        b.c(str6, "result is : " + Arrays.toString(sign));
        return sign;
    }
}
