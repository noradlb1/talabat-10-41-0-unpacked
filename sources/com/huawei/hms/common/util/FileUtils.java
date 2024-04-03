package com.huawei.hms.common.util;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48219a = "FileUtils";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(f48219a, "An exception occurred while closing the closeable.");
            }
        }
    }

    public static boolean a(File file) {
        String str;
        if (file == null) {
            str = "targetFile is null.";
        } else {
            try {
                return file.setReadOnly();
            } catch (SecurityException e11) {
                str = "SecurityException occur, message: " + e11.getMessage();
            }
        }
        Logger.e(f48219a, str);
        return false;
    }

    public static boolean a(String str) {
        boolean z11;
        if (TextUtils.isEmpty(str)) {
            Logger.w(f48219a, "No need to delete anything.");
            return true;
        }
        File file = new File(str);
        if (!file.isDirectory() || file.list() == null) {
            z11 = true;
        } else {
            z11 = true;
            for (String str2 : file.list()) {
                if (z11) {
                    if (a(str + File.separator + str2)) {
                        z11 = true;
                    }
                }
                z11 = false;
            }
        }
        return z11 && file.delete();
    }

    public static boolean b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "The Path is null.";
        } else {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                return file.mkdirs();
            } catch (SecurityException e11) {
                str2 = "MakeDirectory exception: " + e11.getClass().getSimpleName();
            }
        }
        Logger.e(f48219a, str2);
        return false;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f48219a, "the pathname is empty.");
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }
}
