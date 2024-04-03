package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

public class e implements IDecrypt {

    /* renamed from: a  reason: collision with root package name */
    private final ConfigReader f47501a;

    /* renamed from: b  reason: collision with root package name */
    private SecretKey f47502b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f47503c = false;

    public e(ConfigReader configReader) {
        this.f47501a = configReader;
    }

    private void a() {
        try {
            this.f47502b = j.a(new d(this.f47501a.getString("/code/code1", (String) null), this.f47501a.getString("/code/code2", (String) null), this.f47501a.getString("/code/code3", (String) null), this.f47501a.getString("/code/code4", (String) null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_Mark", "Exception when reading the 'K&I' for 'Config'.");
            this.f47502b = null;
        }
        this.f47503c = true;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    private String b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            Log.e("AGC_Mark", "getRawString exception");
            return "";
        }
    }

    public String decrypt(String str, String str2) {
        String str3;
        if (!this.f47503c) {
            a();
        }
        if (this.f47502b == null) {
            str3 = "mKey is null, return default value";
        } else if (!a(str)) {
            return str2;
        } else {
            try {
                return new String(j.a(this.f47502b, Hex.decodeHexString(b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("AGC_Mark", str3);
        return str2;
    }
}
