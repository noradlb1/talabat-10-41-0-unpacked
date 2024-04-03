package com.huawei.hms.dtm.core.util;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class i {
    public static void a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "create file failed#content is empty";
        } else if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            str4 = "create file failed#file name is empty ";
        } else {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str3);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str3);
                try {
                    fileOutputStream2.write(str.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream2.flush();
                    a(str2);
                    if (file.renameTo(new File(str2))) {
                        Logger.debug("DTM-Execute", "rename new success.");
                    } else {
                        boolean delete = file.delete();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("rename new failed#");
                        sb2.append(delete);
                        Logger.warn("DTM-Execute", sb2.toString());
                    }
                    k.a(fileOutputStream2);
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        Logger.error("DTM-Execute", "save file failed.");
                        k.a(fileOutputStream);
                        a(str3);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        k.a(fileOutputStream);
                        a(str3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    k.a(fileOutputStream);
                    a(str3);
                    throw th;
                }
            } catch (IOException unused2) {
                Logger.error("DTM-Execute", "save file failed.");
                k.a(fileOutputStream);
                a(str3);
                return;
            }
            a(str3);
            return;
        }
        Logger.error("DTM-Execute", str4);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        return file.delete();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.warn("DTM-Execute", "mkdir#direcory is null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static String c(String str) {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        IOException e11;
        FileInputStream fileInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e12) {
                e11 = e12;
                byteArrayOutputStream = null;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("read file error:");
                    sb2.append(e11.toString());
                    Logger.warn("DTM-AutoTrace", sb2.toString());
                    k.a(byteArrayOutputStream);
                    k.a(fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileInputStream2 = fileInputStream;
                    th2 = th4;
                    k.a(byteArrayOutputStream);
                    k.a(fileInputStream2);
                    throw th2;
                }
            } catch (Throwable th5) {
                fileInputStream2 = fileInputStream;
                th2 = th5;
                byteArrayOutputStream = null;
                k.a(byteArrayOutputStream);
                k.a(fileInputStream2);
                throw th2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String str2 = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                        k.a(byteArrayOutputStream);
                        k.a(fileInputStream);
                        return str2;
                    }
                }
            } catch (IOException e13) {
                e11 = e13;
                StringBuilder sb22 = new StringBuilder();
                sb22.append("read file error:");
                sb22.append(e11.toString());
                Logger.warn("DTM-AutoTrace", sb22.toString());
                k.a(byteArrayOutputStream);
                k.a(fileInputStream);
                return null;
            }
        } catch (IOException e14) {
            e11 = e14;
            fileInputStream = null;
            byteArrayOutputStream = null;
            StringBuilder sb222 = new StringBuilder();
            sb222.append("read file error:");
            sb222.append(e11.toString());
            Logger.warn("DTM-AutoTrace", sb222.toString());
            k.a(byteArrayOutputStream);
            k.a(fileInputStream);
            return null;
        } catch (Throwable th6) {
            th2 = th6;
            byteArrayOutputStream = null;
            k.a(byteArrayOutputStream);
            k.a(fileInputStream2);
            throw th2;
        }
    }
}
