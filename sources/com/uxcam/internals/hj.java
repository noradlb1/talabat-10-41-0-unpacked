package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class hj {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f13560a = new byte[16];

    /* renamed from: b  reason: collision with root package name */
    public SecretKeySpec f13561b = a();

    /* renamed from: c  reason: collision with root package name */
    public IvParameterSpec f13562c;

    @SuppressLint({"TrulyRandom"})
    public hj() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.f13562c = new IvParameterSpec(bArr);
    }

    public final SecretKeySpec a() {
        new SecureRandom().nextBytes(this.f13560a);
        return new SecretKeySpec(this.f13560a, "AES");
    }

    public String b() {
        String str;
        byte[] bArr = new byte[0];
        try {
            bArr = hp.a(this.f13562c.getIV());
            str = "";
        } catch (BadPaddingException e11) {
            e11.printStackTrace();
            str = e11.getMessage();
        } catch (IllegalBlockSizeException e12) {
            e12.printStackTrace();
            str = e12.getMessage();
        } catch (InvalidKeyException e13) {
            e13.printStackTrace();
            str = e13.getMessage();
        } catch (NoSuchPaddingException e14) {
            e14.printStackTrace();
            str = e14.getMessage();
        } catch (NoSuchAlgorithmException e15) {
            e15.printStackTrace();
            str = e15.getMessage();
        }
        if (!TextUtils.isEmpty(str)) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "UXCamAES::rsaEncryptedIv()");
            fxVar.a("reason", str);
            fxVar.a(2);
        }
        return Base64.encodeToString(bArr, 0).replaceAll("\\s", "");
    }

    public String c() {
        String str;
        byte[] bArr = new byte[0];
        try {
            bArr = hp.a(this.f13560a);
            str = "";
        } catch (BadPaddingException e11) {
            e11.printStackTrace();
            str = e11.getMessage();
        } catch (IllegalBlockSizeException e12) {
            e12.printStackTrace();
            str = e12.getMessage();
        } catch (InvalidKeyException e13) {
            e13.printStackTrace();
            str = e13.getMessage();
        } catch (NoSuchPaddingException e14) {
            e14.printStackTrace();
            str = e14.getMessage();
        } catch (NoSuchAlgorithmException e15) {
            e15.printStackTrace();
            str = e15.getMessage();
        }
        if (!TextUtils.isEmpty(str)) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "UXCamAES::rsaEncryptedKey()");
            fxVar.a("reason", str);
            fxVar.a(2);
        }
        return Base64.encodeToString(bArr, 0).replaceAll("\\s", "");
    }

    public CipherOutputStream a(OutputStream outputStream) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, this.f13561b, this.f13562c);
            return new CipherOutputStream(outputStream, instance);
        } catch (Exception e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "UXCamAES::createCypherOutputStream()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
            return null;
        }
    }
}
