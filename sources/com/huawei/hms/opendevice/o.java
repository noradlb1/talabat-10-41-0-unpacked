package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f49681a = "o";

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f49682b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f49683c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true);
        }
        return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (f49683c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f49681a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(d.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.i(f49681a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a11 = c.a(generateSecureRandom);
            String a12 = c.a(generateSecureRandom2);
            String a13 = c.a(generateSecureRandom3);
            String a14 = c.a(generateSecureRandom4);
            a(a11, a12, a13, a14, WorkKeyCryptUtil.encryptWorkKey(c.a(EncryptUtil.generateSecureRandom(32)), a(a11, a12, a13, a14)), context);
            HMSLog.i(f49681a, "generate D.");
        }
    }

    private static void d(Context context) {
        if (i()) {
            HMSLog.i(f49681a, "secretKeyCache not empty.");
            return;
        }
        f49682b.clear();
        String c11 = d.c(context);
        if (!TextUtils.isEmpty(c11)) {
            String a11 = p.a(c11 + "/files/math/m");
            String a12 = p.a(c11 + "/files/panda/p");
            String a13 = p.a(c11 + "/files/panda/d");
            String a14 = p.a(c11 + "/files/math/t");
            String a15 = p.a(c11 + "/files/s");
            if (q.a(a11, a12, a13, a14, a15)) {
                f49682b.put("m", a11);
                f49682b.put("p", a12);
                f49682b.put("d", a13);
                f49682b.put("t", a14);
                f49682b.put("s", a15);
            }
        }
    }

    private static synchronized String e(Context context) {
        synchronized (o.class) {
            String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
            if (q.a(decryptWorkKey)) {
                HMSLog.i(f49681a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(f(), h());
            if (q.a(decryptWorkKey2)) {
                HMSLog.i(f49681a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, b()), context);
                return decryptWorkKey2;
            }
            String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(f(), BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));
            if (q.a(decryptWorkKey3)) {
                HMSLog.i(f49681a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, b()), context);
                return decryptWorkKey3;
            }
            HMSLog.e(f49681a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    private static String f() {
        return a("s");
    }

    private static String g() {
        return a("t");
    }

    private static RootKeyUtil h() {
        return RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f49681a, "work key is empty, execute init.");
            c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
        if (q.a(decryptWorkKey)) {
            return decryptWorkKey;
        }
        return e(context);
    }

    public static byte[] a(Context context) {
        byte[] a11 = c.a(context.getString(R.string.push_cat_head));
        byte[] a12 = c.a(context.getString(R.string.push_cat_body));
        return a(a(a(a11, a12), c.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr[i11] >> 2);
        }
        return bArr;
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c11 = d.c(context.getApplicationContext());
        if (!TextUtils.isEmpty(c11)) {
            try {
                a("m", str, c11 + "/files/math/m");
                a("p", str2, c11 + "/files/panda/p");
                a("d", str3, c11 + "/files/panda/d");
                a("t", str4, c11 + "/files/math/t");
                a("s", str5, c11 + "/files/s");
            } catch (IOException unused) {
                HMSLog.e(f49681a, "save key IOException.");
            }
        }
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a("p");
    }

    private static String c() {
        return a("d");
    }

    private static void a(String str, Context context) {
        String c11 = d.c(context.getApplicationContext());
        if (!TextUtils.isEmpty(c11)) {
            try {
                a("s", str, c11 + "/files/s");
            } catch (IOException unused) {
                HMSLog.e(f49681a, "save keyS IOException.");
            }
        }
    }

    private static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        HMSLog.i(f49681a, "save local secret key.");
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str3);
            p.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    f49682b.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly((Writer) outputStreamWriter);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter = null;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    private static String a(String str) {
        String str2 = f49682b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
