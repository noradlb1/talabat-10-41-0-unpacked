package com.instabug.library.networkv2.authorization;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class a {
    @Nullable
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            InstabugSDKLogger.e("IBG-Core", e11.getMessage() == null ? "Couldn't encode URL in UTF-8" : e11.getMessage(), e11);
            return null;
        }
    }

    public static byte[] b(String str) throws IOException, OutOfMemoryError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    @Nullable
    public static String c(@Nullable String str) throws UnsupportedEncodingException, OutOfMemoryError {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("UTF-8"), 0, str.length());
            byte[] digest = instance.digest();
            StringBuilder sb2 = new StringBuilder();
            int length = digest.length;
            for (int i11 = 0; i11 < length; i11++) {
                sb2.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i11] & 255)}));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't hash data", e11);
            }
            return null;
        }
    }

    public static String a(String str, @NonNull String str2) throws Exception {
        Charset forName = Charset.forName("US-ASCII");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(forName.encode(str).array(), "HmacSHA256"));
        return Base64.encodeToString(instance.doFinal(forName.encode(str2).array()), 2);
    }
}
