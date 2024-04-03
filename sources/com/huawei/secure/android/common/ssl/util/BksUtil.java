package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BksUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33937a = "BksUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33938b = "com.huawei.hwid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33939c = "com.huawei.hwid";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33940d = "com.huawei.hms";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33941e = "com.huawei.hwid.tv";

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f33942f = Uri.parse("content://com.huawei.hwid");

    /* renamed from: g  reason: collision with root package name */
    private static final String f33943g = "files/hmsrootcas.bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f33944h = "4.0.2.300";

    /* renamed from: i  reason: collision with root package name */
    private static final String f33945i = "aegis";

    /* renamed from: j  reason: collision with root package name */
    private static final String f33946j = "hmsrootcas.bks";

    /* renamed from: k  reason: collision with root package name */
    private static final long f33947k = 604800000;

    /* renamed from: l  reason: collision with root package name */
    private static final String f33948l = "last_update_time";

    /* renamed from: m  reason: collision with root package name */
    private static final String f33949m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* renamed from: n  reason: collision with root package name */
    private static final String f33950n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* renamed from: o  reason: collision with root package name */
    private static final String f33951o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* renamed from: p  reason: collision with root package name */
    private static final String[] f33952p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    /* renamed from: q  reason: collision with root package name */
    private static final String f33953q = "";

    /* renamed from: r  reason: collision with root package name */
    private static final String f33954r = "bks_hash";

    private BksUtil() {
    }

    private static void a(InputStream inputStream, Context context) {
        if (inputStream != null && context != null) {
            String a11 = a(context);
            if (!new File(a11).exists()) {
                a(a11);
            }
            File file = new File(a11, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                e.c(f33937a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            d.a((OutputStream) fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.b(f33937a, " IOException");
                        d.a((OutputStream) fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        d.a((OutputStream) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    d.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                e.b(f33937a, " IOException");
                d.a((OutputStream) fileOutputStream);
            }
        }
    }

    private static boolean a(int i11) {
        return i11 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream getBksFromTss(Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        synchronized (BksUtil.class) {
            e.c(f33937a, "get bks from tss begin");
            if (context != null) {
                ContextUtil.setContext(context);
            }
            Context instance = ContextUtil.getInstance();
            InputStream inputStream4 = null;
            if (instance == null) {
                e.b(f33937a, "context is null");
                return null;
            } else if (!b(f.a("com.huawei.hwid")) && !b(f.a("com.huawei.hms"))) {
                e.b(f33937a, "hms version code is too low : " + f.a("com.huawei.hwid"));
                return null;
            } else if (c(instance, "com.huawei.hwid") || b(instance, "com.huawei.hms")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream2 = instance.getContentResolver().openInputStream(Uri.withAppendedPath(f33942f, f33943g));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception e11) {
                        e = e11;
                        try {
                            e.b(f33937a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                            d.a(inputStream2);
                            d.a((OutputStream) byteArrayOutputStream);
                            d.a(inputStream4);
                            InputStream filesBksIS = getFilesBksIS(instance);
                            return filesBksIS;
                        } catch (Throwable th2) {
                            th = th2;
                            InputStream inputStream5 = inputStream2;
                            inputStream3 = inputStream4;
                            inputStream4 = inputStream5;
                            inputStream = inputStream3;
                            inputStream2 = inputStream4;
                            d.a(inputStream2);
                            d.a((OutputStream) byteArrayOutputStream);
                            d.a(inputStream);
                            throw th;
                        }
                    }
                    try {
                        String a11 = g.a(f33954r, "", instance);
                        String b11 = b(byteArrayOutputStream.toByteArray());
                        if (c(instance)) {
                            if (a11.equals(b11)) {
                                e.c(f33937a, "bks not update");
                                d.a(inputStream2);
                                d.a((OutputStream) byteArrayOutputStream);
                                d.a(inputStream);
                                InputStream filesBksIS2 = getFilesBksIS(instance);
                                return filesBksIS2;
                            }
                        }
                        e.c(f33937a, "update bks and sp");
                        a(inputStream, instance);
                        g.b(f33954r, b11, instance);
                        d.a(inputStream2);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a(inputStream);
                    } catch (Exception e12) {
                        InputStream inputStream6 = inputStream;
                        e = e12;
                        inputStream4 = inputStream6;
                        e.b(f33937a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                        d.a(inputStream2);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a(inputStream4);
                        InputStream filesBksIS22 = getFilesBksIS(instance);
                        return filesBksIS22;
                    } catch (Throwable th3) {
                        th = th3;
                        d.a(inputStream2);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a(inputStream);
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                    inputStream2 = null;
                    e.b(f33937a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                    d.a(inputStream2);
                    d.a((OutputStream) byteArrayOutputStream);
                    d.a(inputStream4);
                    InputStream filesBksIS222 = getFilesBksIS(instance);
                    return filesBksIS222;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream3 = null;
                    inputStream = inputStream3;
                    inputStream2 = inputStream4;
                    d.a(inputStream2);
                    d.a((OutputStream) byteArrayOutputStream);
                    d.a(inputStream);
                    throw th;
                }
                InputStream filesBksIS2222 = getFilesBksIS(instance);
                return filesBksIS2222;
            } else {
                e.b(f33937a, "hms sign error");
                return null;
            }
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e.c(f33937a, "getFilesBksIS ");
        try {
            return new FileInputStream(b(context));
        } catch (FileNotFoundException unused) {
            e.b(f33937a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static boolean b(String str) {
        int i11;
        int i12;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.c(f33937a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f33944h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i13 = 0; i13 < max; i13++) {
            if (i13 < length) {
                try {
                    i11 = Integer.parseInt(split[i13]);
                } catch (Exception e11) {
                    e.b(f33937a, " exception : " + e11.getMessage());
                    if (i13 >= length2) {
                        return true;
                    }
                    return false;
                }
            } else {
                i11 = 0;
            }
            if (i13 < length2) {
                i12 = Integer.parseInt(split2[i13]);
            } else {
                i12 = 0;
            }
            if (i11 < i12) {
                return false;
            }
            if (i11 > i12) {
                return true;
            }
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] a11 = a(context, str);
        for (String equalsIgnoreCase : f33952p) {
            if (equalsIgnoreCase.equalsIgnoreCase(c(a11))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance(Constants.SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException e11) {
            Log.e(f33937a, "NoSuchAlgorithmException" + e11.getMessage());
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(Constants.SHA256);
            instance.update(bArr);
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33937a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            e.e(f33937a, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            e.a(f33937a, "create directory  success");
            return 0;
        } else {
            e.b(f33937a, "create directory  failed");
            return -1;
        }
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f33945i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f33945i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(f33937a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e(f33937a, "PackageManager.NameNotFoundException : " + e11.getMessage());
        } catch (Exception e12) {
            Log.e(f33937a, "get pm exception : " + e12.getMessage());
        }
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
