package com.uxcam.internals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dr {
    public static String a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e11) {
                        throw new RuntimeException("Unable to process file for MD5", e11);
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            gu.f13504c.getClass();
                        }
                        throw th2;
                    }
                }
                String replace = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    gu.f13504c.getClass();
                }
                return replace;
            } catch (FileNotFoundException unused3) {
                gu.f13504c.getClass();
                return null;
            }
        } catch (NoSuchAlgorithmException unused4) {
            gu.f13504c.getClass();
            return null;
        }
    }
}
