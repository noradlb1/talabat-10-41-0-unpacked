package com.huawei.agconnect.credential.obs;

import android.text.TextUtils;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.common.api.RandomWrapper;
import com.huawei.agconnect.datastore.annotation.SharedPreference;
import com.huawei.secure.android.common.util.HexUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f47575a = new h();

    /* renamed from: b  reason: collision with root package name */
    private String f47576b = null;

    /* renamed from: c  reason: collision with root package name */
    private SecretKey f47577c;
    @SharedPreference(fileName = "com.huawei.appgallery.datastore", key = "fish")
    String fish;
    @SharedPreference(fileName = "com.huawei.agconnect.internal", key = "jerry")
    String jerry;
    @SharedPreference(fileName = "com.huawei.appgallery.datastore", key = "key")
    String randmonKey;

    private h() {
    }

    private String a(int i11) {
        return HexUtil.byteArray2HexStr(RandomWrapper.generateSecureRandom(i11 / 2));
    }

    private static String a(String str, int i11) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        if (hexStr2ByteArray == null || hexStr2ByteArray.length == 0) {
            return null;
        }
        for (int i12 = 0; i12 < hexStr2ByteArray.length; i12++) {
            if (i11 < 0) {
                hexStr2ByteArray[i12] = (byte) (hexStr2ByteArray[i12] << (-i11));
            } else {
                hexStr2ByteArray[i12] = (byte) (hexStr2ByteArray[i12] >> i11);
            }
        }
        return HexUtil.byteArray2HexStr(hexStr2ByteArray);
    }

    private static String a(String str, String str2) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray == null || hexStr2ByteArray2 == null || hexStr2ByteArray.length != hexStr2ByteArray2.length) {
            return null;
        }
        int length = hexStr2ByteArray.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) (hexStr2ByteArray[i11] ^ hexStr2ByteArray2[i11]);
        }
        return HexUtil.byteArray2HexStr(bArr);
    }

    private static String a(String str, String str2, String str3) {
        return a(a(a(a(str, -4), str2), 6), str3);
    }

    private static SecretKey a(String str, String str2, String str3, String str4) {
        if (str.length() == 32 && str2.length() == 32 && str3.length() == 32) {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a(str, str2, str3).toCharArray(), HexUtil.hexStr2ByteArray(str4), 5000, 128)).getEncoded(), "AES");
        }
        throw new IllegalArgumentException("invalid data for generating the key.");
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) || str.length() != 32;
    }

    private String c() {
        i.a().d(this);
        if (TextUtils.isEmpty(this.randmonKey) || this.randmonKey.length() != 16) {
            this.randmonKey = a(16);
            i.a().a(this);
        }
        return this.randmonKey;
    }

    private void d() {
        i.a().f(this);
        i.a().e(this);
        if (a(this.jerry) || a(this.fish)) {
            this.jerry = a(32);
            this.fish = a(32);
            i.a().b(this);
            i.a().c(this);
        }
        try {
            this.f47577c = a(w.d(), this.jerry, "767d9b01105c2acd25fb7955a5394f78", this.fish);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Logger.e("KeyManager", "Exception when reading the 'T&J&C&F' for 'KeyManager'.");
            this.f47577c = null;
        }
    }

    public synchronized String a() {
        if (TextUtils.isEmpty(this.f47576b)) {
            String a11 = a(a(w.c(), 6), g.a());
            String a12 = a(a("AE6D8285", -4), "4D5480E9");
            this.f47576b = a11 + a12 + c();
        }
        return this.f47576b;
    }

    public synchronized SecretKey b() {
        if (this.f47577c == null) {
            d();
        }
        return this.f47577c;
    }
}
