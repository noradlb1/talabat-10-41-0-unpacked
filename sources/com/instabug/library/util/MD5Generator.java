package com.instabug.library.util;

import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {
    @Nullable
    public static String generateMD5(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if (b12 < 16) {
                    sb2.append("0");
                    sb2.append(Integer.toHexString(b12));
                } else {
                    sb2.append(Integer.toHexString(b12));
                }
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
