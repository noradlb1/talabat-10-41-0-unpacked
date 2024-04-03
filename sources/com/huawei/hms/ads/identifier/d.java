package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.ads.R;
import com.newrelic.agent.android.payload.PayloadController;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f47838a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f47839b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static SoftReference<byte[]> f47840c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Long f47843a = Long.valueOf(PayloadController.PAYLOAD_REQUEUE_PERIOD_MS);

        /* renamed from: h  reason: collision with root package name */
        private static final byte[] f47844h = new byte[0];

        /* renamed from: i  reason: collision with root package name */
        private static volatile a f47845i;

        /* renamed from: b  reason: collision with root package name */
        private SharedPreferences f47846b = null;

        /* renamed from: c  reason: collision with root package name */
        private SharedPreferences f47847c = null;

        /* renamed from: d  reason: collision with root package name */
        private SharedPreferences f47848d = null;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f47849e = new byte[0];

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f47850f = new byte[0];

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f47851g = new byte[0];

        /* renamed from: j  reason: collision with root package name */
        private Context f47852j;

        private a(Context context) {
            try {
                this.f47852j = context.getApplicationContext();
                Context a11 = e.a(context);
                this.f47846b = a11.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.f47847c = a11.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.f47848d = a11.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th2) {
                Log.w("Aes128", "get SharedPreference error: " + th2.getClass().getSimpleName());
            }
        }

        public static a a(Context context) {
            a aVar;
            if (f47845i != null) {
                return f47845i;
            }
            synchronized (f47844h) {
                if (f47845i == null) {
                    f47845i = new a(context);
                }
                aVar = f47845i;
            }
            return aVar;
        }

        public String a() {
            synchronized (this.f47850f) {
                SharedPreferences sharedPreferences = this.f47848d;
                if (sharedPreferences == null) {
                    return "";
                }
                String string = sharedPreferences.getString("read_first_chapter", "");
                if (TextUtils.isEmpty(string)) {
                    return string;
                }
                String a11 = d.a(string, d.a(this.f47852j));
                return a11;
            }
        }

        public void a(String str) {
            synchronized (this.f47850f) {
                if (this.f47848d != null) {
                    this.f47848d.edit().putString("read_first_chapter", d.b(str, d.a(this.f47852j))).apply();
                }
            }
        }

        public void b() {
            synchronized (this.f47851g) {
                SharedPreferences sharedPreferences = this.f47846b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                }
            }
        }

        public void b(String str) {
            synchronized (this.f47849e) {
                SharedPreferences sharedPreferences = this.f47847c;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                }
            }
        }

        public void c(String str) {
            synchronized (this.f47851g) {
                SharedPreferences sharedPreferences = this.f47846b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c() {
            /*
                r7 = this;
                byte[] r0 = r7.f47851g
                monitor-enter(r0)
                android.content.SharedPreferences r1 = r7.f47846b     // Catch:{ all -> 0x002c }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return r2
            L_0x000a:
                java.lang.String r3 = "read_first_chapter_time"
                r4 = -1
                long r3 = r1.getLong(r3, r4)     // Catch:{ all -> 0x002c }
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x001a
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return r2
            L_0x001a:
                java.lang.Long r1 = f47843a     // Catch:{ all -> 0x002c }
                long r5 = r1.longValue()     // Catch:{ all -> 0x002c }
                long r3 = r3 + r5
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002c }
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 <= 0) goto L_0x002a
                r2 = 1
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return r2
            L_0x002c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.identifier.d.a.c():boolean");
        }

        public void d() {
            synchronized (this.f47851g) {
                SharedPreferences sharedPreferences = this.f47846b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("has_read_first_chapter", true).apply();
                }
            }
        }

        public void d(String str) {
            synchronized (this.f47851g) {
                this.f47846b.edit().putString("read_second_chapter", str).apply();
            }
        }

        public boolean e() {
            synchronized (this.f47851g) {
                SharedPreferences sharedPreferences = this.f47846b;
                if (sharedPreferences == null) {
                    return false;
                }
                boolean z11 = sharedPreferences.getBoolean("has_read_first_chapter", false);
                return z11;
            }
        }

        public String f() {
            synchronized (this.f47849e) {
                SharedPreferences sharedPreferences = this.f47847c;
                if (sharedPreferences == null) {
                    return null;
                }
                String string = sharedPreferences.getString("get_a_book", (String) null);
                return string;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String g() {
            /*
                r4 = this;
                byte[] r0 = r4.f47851g
                monitor-enter(r0)
                android.content.SharedPreferences r1 = r4.f47846b     // Catch:{ all -> 0x001f }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                return r2
            L_0x000a:
                java.lang.String r3 = "catch_a_cat"
                java.lang.String r1 = r1.getString(r3, r2)     // Catch:{ all -> 0x001f }
                if (r1 != 0) goto L_0x001d
                byte[] r1 = com.huawei.hms.ads.identifier.d.a()     // Catch:{ all -> 0x001f }
                java.lang.String r1 = com.huawei.hms.ads.identifier.d.a((byte[]) r1)     // Catch:{ all -> 0x001f }
                r4.c(r1)     // Catch:{ all -> 0x001f }
            L_0x001d:
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                return r1
            L_0x001f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.identifier.d.a.g():java.lang.String");
        }

        public String h() {
            String string;
            synchronized (this.f47851g) {
                string = this.f47846b.getString("read_second_chapter", "");
            }
            return string;
        }
    }

    private static String a(Context context, a aVar) {
        String a11 = a(b());
        aVar.b(b(a11, d(context)));
        return a11;
    }

    public static String a(String str, String str2) {
        String a11;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f47838a) {
            try {
                a11 = a(str, b(str2));
            } catch (Throwable th2) {
                Log.w("Aes128", "decrypt oaid ex: " + th2.getClass().getSimpleName());
                return null;
            }
        }
        return a11;
    }

    public static String a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (d()) {
                    return d(str, bArr);
                }
            } catch (Throwable th2) {
                Log.w("Aes128", "fail to decrypt: " + th2.getClass().getSimpleName());
            }
        }
        return "";
    }

    public static String a(byte[] bArr) {
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

    public static byte[] a() {
        return a(16);
    }

    public static byte[] a(int i11) {
        byte[] bArr = new byte[i11];
        c().nextBytes(bArr);
        return bArr;
    }

    public static byte[] a(Context context) {
        byte[] bArr;
        byte[] c11;
        synchronized (f47839b) {
            SoftReference<byte[]> softReference = f47840c;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    c11 = b(b(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    c11 = c(context);
                    bArr = c11;
                    f47840c = new SoftReference<>(bArr);
                    return bArr;
                } catch (Throwable th2) {
                    Log.w("Aes128", "getWorkKeyBytes " + th2.getClass().getSimpleName());
                    c11 = c(context);
                    bArr = c11;
                    f47840c = new SoftReference<>(bArr);
                    return bArr;
                }
                bArr = c11;
                f47840c = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }

    private static byte[] a(Context context, String str) {
        return a(str, context.getString(R.string.identifier_hiad_str_2), context.getString(R.string.identifier_hiad_str_3));
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            return b(str);
        } catch (Throwable th2) {
            Log.e("Aes128", "hex string 2 byte: " + th2.getClass().getSimpleName());
            return bArr;
        }
    }

    private static byte[] a(String str, String str2, String str3) {
        byte[] a11 = a(str);
        byte[] a12 = a(str2);
        return a(a(a11, a12), a(str3));
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || !c(bArr) || !b(bArr2) || !d()) {
            Log.i("Aes128", "gcm encrypt param is not right");
        } else {
            try {
                return a(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e11) {
                Log.e("Aes128", "GCM encrypt data error" + e11.getMessage());
            }
        }
        return new byte[0];
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= bArr2.length) {
            byte[] bArr3 = bArr2;
            bArr2 = bArr;
            bArr = bArr3;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr4 = new byte[length];
        int i11 = 0;
        while (i11 < length2) {
            bArr4[i11] = (byte) (bArr2[i11] ^ bArr[i11]);
            i11++;
        }
        while (i11 < bArr.length) {
            bArr4[i11] = bArr[i11];
            i11++;
        }
        return bArr4;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "encrypt, contentBytes invalid.";
        } else if (bArr2 == null || bArr2.length < 16) {
            str = "encrypt, keyBytes invalid.";
        } else if (!d()) {
            str = "encrypt, osVersion too low.";
        } else if (bArr3 == null || bArr3.length < 12) {
            str = "encrypt, random invalid.";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
                instance.init(1, secretKeySpec, d(bArr3));
                return instance.doFinal(bArr);
            } catch (GeneralSecurityException e11) {
                Log.e("Aes128", "GCM encrypt data error" + e11.getMessage());
            }
        }
        Log.i("Aes128", str);
        return new byte[0];
    }

    public static byte[] a(char[] cArr, byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return SecretKeyFactory.getInstance(Build.VERSION.SDK_INT > 26 ? "PBKDF2WithHmacSHA256" : "PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }

    private static String b(int i11) {
        try {
            SecureRandom c11 = c();
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append(Integer.toHexString(c11.nextInt(16)));
            }
            return sb2.toString();
        } catch (Throwable th2) {
            Log.w("Aes128", "generate aes key1 err:" + th2.getClass().getSimpleName());
            return "";
        }
    }

    private static String b(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        synchronized (f47839b) {
            a a11 = a.a(context);
            String f11 = a11.f();
            if (f11 != null) {
                String a12 = a(f11, d(context));
                if (!TextUtils.isEmpty(a12)) {
                    str = a12;
                }
            }
            str = a(context, a11);
        }
        return str;
    }

    public static String b(String str, byte[] bArr) {
        StringBuilder sb2;
        if (!(TextUtils.isEmpty(str) || bArr == null || bArr.length == 0)) {
            try {
                if (d()) {
                    return c(str, bArr);
                }
            } catch (Exception e11) {
                th = e11;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(th.getClass().getSimpleName());
                Log.w("Aes128", sb2.toString());
                return "";
            } catch (Throwable th2) {
                th = th2;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(th.getClass().getSimpleName());
                Log.w("Aes128", sb2.toString());
                return "";
            }
        }
        return "";
    }

    private static boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    public static byte[] b() {
        return a(16);
    }

    public static byte[] b(String str) throws UnsupportedEncodingException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes("UTF-8");
        for (int i11 = 0; i11 < length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0x");
            int i12 = i11 * 2;
            sb2.append(new String(new byte[]{bytes[i12]}, "UTF-8"));
            bArr[i11] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i12 + 1]}, "UTF-8")).byteValue());
        }
        return bArr;
    }

    private static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        Log.i("Aes128", "IV is invalid.");
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r0 = a(12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(java.lang.String r3, byte[] r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x003c
            if (r4 == 0) goto L_0x003c
            int r0 = r4.length
            r2 = 16
            if (r0 < r2) goto L_0x003c
            boolean r0 = d()
            if (r0 == 0) goto L_0x003c
            r0 = 12
            byte[] r0 = a((int) r0)
            byte[] r3 = a((java.lang.String) r3, (byte[]) r4, (byte[]) r0)
            if (r3 == 0) goto L_0x003c
            int r4 = r3.length
            if (r4 == 0) goto L_0x003c
            java.lang.String r4 = a((byte[]) r0)
            java.lang.String r3 = a((byte[]) r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.identifier.d.c(java.lang.String, byte[]):java.lang.String");
    }

    private static SecureRandom c() {
        SecureRandom secureRandom;
        try {
            secureRandom = Build.VERSION.SDK_INT >= 26 ? SecureRandom.getInstanceStrong() : SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e11) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e11.getClass().getSimpleName());
            secureRandom = null;
        }
        return secureRandom == null ? new SecureRandom() : secureRandom;
    }

    private static boolean c(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    private static byte[] c(Context context) {
        Log.i("Aes128", "regenerateWorkKey");
        a.a(context).b("");
        return a(b(context));
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static String d(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && d()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
                String c11 = c(str);
                String d11 = d(str);
                if (TextUtils.isEmpty(c11) || TextUtils.isEmpty(d11)) {
                    Log.i("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                instance.init(2, secretKeySpec, d(a(c11)));
                return new String(instance.doFinal(a(d11)), "UTF-8");
            } catch (UnsupportedEncodingException | GeneralSecurityException e11) {
                Log.e("Aes128", "GCM decrypt data exception: " + e11.getMessage());
            }
        }
        return "";
    }

    private static AlgorithmParameterSpec d(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private static boolean d() {
        return true;
    }

    private static byte[] d(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        a a11 = a.a(context);
        try {
            return a(a(e(context)).toCharArray(), a(a11.g()));
        } catch (NoSuchAlgorithmException unused) {
            str = "get userRootKey NoSuchAlgorithmException";
            Log.w("Aes128", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "get userRootKey InvalidKeySpecException";
            Log.w("Aes128", str);
            return null;
        }
    }

    private static byte[] e(Context context) {
        return a(context, f(context));
    }

    private static String f(Context context) {
        final a a11 = a.a(context);
        String h11 = a11.h();
        if (!TextUtils.isEmpty(h11)) {
            return h11;
        }
        final String b11 = b(64);
        e.f47853a.execute(new Runnable() {
            public void run() {
                a11.d(b11);
            }
        });
        return b11;
    }
}
