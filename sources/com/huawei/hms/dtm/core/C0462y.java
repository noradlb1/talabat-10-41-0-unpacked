package com.huawei.hms.dtm.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.debug.a;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.b;
import com.huawei.hms.dtm.core.util.f;
import com.huawei.hms.dtm.core.util.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.dtm.core.y  reason: case insensitive filesystem */
class C0462y {

    /* renamed from: a  reason: collision with root package name */
    private String f48633a;

    /* renamed from: b  reason: collision with root package name */
    private String f48634b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f48635c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f48636d = 0;

    private String a() {
        String a11 = b.a();
        String c11 = b.c();
        if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(c11)) {
            return null;
        }
        return "DTM-" + c11 + a11 + ".json";
    }

    private String a(Hc hc2, long j11, int i11) {
        b(hc2, j11, i11);
        int c11 = hc2.c();
        if (c11 == 200) {
            Logger.info("DTM-Decode", "load json from network#success delay=" + j11);
            return hc2.a();
        } else if (c11 == 204) {
            Logger.warn("DTM-Decode", "load json from network#no content#204");
            return "HTTP_NO_CONTENT";
        } else if (c11 == 404 && !TextUtils.isEmpty(hc2.a())) {
            return e(hc2.a());
        } else {
            Logger.error("DTM-Decode", "load json from network#" + c11);
            return "";
        }
    }

    private void a(Context context, String str) {
        String e11 = e(context);
        if (!TextUtils.isEmpty(e11)) {
            File file = new File(e11);
            if (!file.exists() && !file.mkdirs()) {
                Logger.debug("DTM-Decode", "mkdirs failed");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e11);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(this.f48633a);
            String sb3 = sb2.toString();
            File file2 = new File(sb3);
            long currentTimeMillis = System.currentTimeMillis();
            FileOutputStream fileOutputStream = null;
            try {
                File file3 = new File(e11 + str2 + currentTimeMillis + ".bak");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                try {
                    fileOutputStream2.write(str.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream2.flush();
                    if (file2.exists() && !file2.delete()) {
                        Logger.warn("DTM-Decode", "delete old failed");
                    }
                    if (file3.renameTo(new File(sb3))) {
                        Logger.debug("DTM-Decode", "rename new success.");
                    } else {
                        boolean delete = file3.delete();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("rename new failed#");
                        sb4.append(delete);
                        Logger.warn("DTM-Decode", sb4.toString());
                    }
                    k.a(fileOutputStream2);
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        Logger.error("DTM-Decode", "Save json IOException.");
                        k.a(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        k.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    k.a(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                Logger.error("DTM-Decode", "Save json IOException.");
                k.a(fileOutputStream);
            } catch (Throwable th4) {
                th = th4;
                k.a(fileOutputStream);
                throw th;
            }
        }
    }

    private boolean a(C0457x xVar) {
        long c11 = xVar.c() * 60 * 60 * 1000;
        Logger.debug("DTM-Decode", "update interval is " + c11);
        long currentTimeMillis = System.currentTimeMillis() - xVar.b();
        Logger.debug("DTM-Decode", "load json offset#" + currentTimeMillis);
        return currentTimeMillis >= c11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r4.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            int r0 = r4.length()
            r2 = 5
            if (r0 <= r2) goto L_0x0016
            int r0 = r0 - r2
            r1 = 0
            java.lang.String r1 = com.huawei.hms.dtm.core.safe.SafeString.substring(r4, r1, r0)
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.C0462y.b(java.lang.String):java.lang.String");
    }

    private void b(Hc hc2, long j11, int i11) {
        Context a11 = J.a();
        if (a11 != null && hc2 != null) {
            boolean a12 = f.a(a11);
            Logger.debug("DTM-Decode", "network connected#" + a12);
            if (a12) {
                C0376gd.a().a(a(a11)).b(String.valueOf(hc2.c())).c(String.valueOf(j11)).a(i11).b();
            }
        }
    }

    private String c(String str) {
        Logger.info("DTM-Decode", "load json from network begin...");
        if (TextUtils.isEmpty(str)) {
            Logger.error("DTM-Decode", "load json from network#empty url");
            return "";
        }
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (i11 > 3) {
                return "";
            }
            long nanoTime = System.nanoTime();
            Hc a11 = Fc.a(str);
            int c11 = a11.c();
            long round = c11 == 0 ? -1 : Math.round(((double) (System.nanoTime() - nanoTime)) / 1000000.0d);
            if (c11 == 399) {
                return d(a11.a());
            }
            this.f48636d = 0;
            if (c11 != 0) {
                return a(a11, round, i12);
            }
            if (i12 == 3) {
                return a(a11, round, i12);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e11) {
                Logger.warn("DTM-Decode", "InterruptedException#" + e11.getMessage());
            }
            i11 = i12;
        }
    }

    private String d(Context context) {
        if (!TextUtils.isEmpty(this.f48633a)) {
            return this.f48633a;
        }
        AssetManager assets = context.getAssets();
        Pattern compile = Pattern.compile("(dtm-[a-z0-9]{32})\\.json", 2);
        try {
            String[] list = assets.list("containers");
            if (list != null) {
                int length = list.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    String str = list[i11];
                    if (compile.matcher(str).matches()) {
                        this.f48633a = str;
                        break;
                    }
                    i11++;
                }
            }
            if (TextUtils.isEmpty(this.f48633a)) {
                this.f48633a = a();
            }
        } catch (IOException unused) {
            Logger.error("DTM-Decode", "Get ID IOException");
        }
        return this.f48633a;
    }

    private String d(String str) {
        if (this.f48636d >= 5) {
            Logger.error("DTM-Decode", "have redirect 5 times and all stations are expired.");
            this.f48635c = null;
            this.f48636d = 0;
            return "";
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            this.f48636d++;
            this.f48635c = str;
            String a11 = C0421pd.a(str);
            if (TextUtils.isEmpty(a11)) {
                return "";
            }
            String str2 = a11 + "/download/android?id=" + a(J.a()) + "&digest=" + b(J.a()) + "&sdkversion=" + 60600302;
            Logger.info("DTM-Decode", "redirect times#" + this.f48636d);
            return c(str2);
        }
    }

    private String e(Context context) {
        String str;
        try {
            str = context.getFilesDir().getCanonicalPath();
        } catch (IOException unused) {
            Logger.error("DTM-Decode", "Get Json path IOException.");
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + File.separator + "dtm_container";
    }

    private String e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("errorCode")) {
                return "";
            }
            if (!"1001".equals(jSONObject.optString("errorCode"))) {
                return "";
            }
            Logger.warn("DTM-Decode", "load json from network#not found or deleted#404");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{\"download_url\": \"");
            sb2.append(this.f48634b);
            sb2.append("\",\"ser_country\":\"");
            sb2.append(this.f48635c);
            sb2.append("\"}");
            return sb2.toString();
        } catch (JSONException unused) {
            Logger.error("DTM-Decode", "load json from network#404 and body is not a json");
            return "";
        }
    }

    private String f(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (TextUtils.isEmpty(this.f48633a)) {
            Logger.error("DTM-Decode", "please load configuration first");
            return "";
        }
        Logger.info("DTM-Decode", "load json from asserts begin...");
        InputStream inputStream = null;
        try {
            AssetManager assets = context.getAssets();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("containers");
            sb2.append(File.separator);
            sb2.append(this.f48633a);
            InputStream open = assets.open(sb2.toString());
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = open.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            Logger.info("DTM-Decode", "load json from asserts#success");
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                            k.a(byteArrayOutputStream);
                            k.a(open);
                            return byteArrayOutputStream2;
                        }
                    } catch (IOException unused) {
                        inputStream = open;
                        try {
                            Logger.warn("DTM-Decode", "load json from assets#IOException");
                            k.a(byteArrayOutputStream);
                            k.a(inputStream);
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            k.a(byteArrayOutputStream);
                            k.a(inputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        inputStream = open;
                        th = th4;
                        k.a(byteArrayOutputStream);
                        k.a(inputStream);
                        throw th;
                    }
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = null;
                inputStream = open;
                Logger.warn("DTM-Decode", "load json from assets#IOException");
                k.a(byteArrayOutputStream);
                k.a(inputStream);
                return "";
            } catch (Throwable th5) {
                byteArrayOutputStream = null;
                inputStream = open;
                th = th5;
                k.a(byteArrayOutputStream);
                k.a(inputStream);
                throw th;
            }
        } catch (IOException unused3) {
            byteArrayOutputStream = null;
            Logger.warn("DTM-Decode", "load json from assets#IOException");
            k.a(byteArrayOutputStream);
            k.a(inputStream);
            return "";
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            k.a(byteArrayOutputStream);
            k.a(inputStream);
            throw th;
        }
    }

    private boolean f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return jSONObject.has("download_url") && !TextUtils.isEmpty(jSONObject.getString("download_url"));
            }
        } catch (JSONException unused) {
            Logger.error("DTM-Decode", " hasDownloadUrl JSONException");
        }
        return false;
    }

    private String g(Context context) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(this.f48633a)) {
            Logger.error("DTM-Decode", "please load configuration first");
            return "";
        }
        Logger.info("DTM-Decode", "load json from file begin...");
        String e11 = e(context);
        if (TextUtils.isEmpty(e11)) {
            Logger.error("DTM-Decode", "load json from file#empty path");
            return "";
        }
        File file = new File(e11 + File.separator + this.f48633a);
        if (!file.exists()) {
            Logger.error("DTM-Decode", "load json from file#no file");
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException unused) {
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    Logger.error("DTM-Decode", "load json from file#IOException");
                    k.a(fileInputStream);
                    k.a(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    k.a(fileInputStream);
                    k.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                k.a(fileInputStream);
                k.a(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream2.flush();
                        Logger.info("DTM-Decode", "load json from file#success");
                        String byteArrayOutputStream3 = byteArrayOutputStream2.toString("UTF-8");
                        k.a(fileInputStream);
                        k.a(byteArrayOutputStream2);
                        return byteArrayOutputStream3;
                    }
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = byteArrayOutputStream2;
                Logger.error("DTM-Decode", "load json from file#IOException");
                k.a(fileInputStream);
                k.a(byteArrayOutputStream);
                return "";
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                k.a(fileInputStream);
                k.a(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileInputStream = null;
            Logger.error("DTM-Decode", "load json from file#IOException");
            k.a(fileInputStream);
            k.a(byteArrayOutputStream);
            return "";
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            k.a(fileInputStream);
            k.a(byteArrayOutputStream);
            throw th;
        }
    }

    private void h(Context context) {
        try {
            String g11 = g(context);
            if (TextUtils.isEmpty(g11) || !f(g11)) {
                g11 = f(context);
            }
            if (!TextUtils.isEmpty(g11)) {
                JSONObject jSONObject = new JSONObject(g11);
                String str = null;
                this.f48634b = jSONObject.has("download_url") ? jSONObject.getString("download_url") : null;
                if (jSONObject.has("ser_country")) {
                    str = jSONObject.getString("ser_country");
                }
                this.f48635c = str;
            }
        } catch (JSONException unused) {
            Logger.warn("DTM-Decode", " getSerInfoFromFile JSONException");
        }
    }

    private void i(Context context) {
        try {
            h(context);
            if (TextUtils.isEmpty(this.f48635c)) {
                this.f48635c = b.d();
            }
        } catch (Exception e11) {
            Logger.warn("DTM-Decode", "initServerUrlAndSerCountry#" + e11.getMessage());
        }
    }

    public String a(Context context) {
        return b(d(context));
    }

    public String a(Context context, String str, boolean z11) {
        String str2;
        C0457x xVar = new C0457x(context);
        if (a(xVar)) {
            str2 = c(str);
            if (z11 && "HTTP_NO_CONTENT".equals(str2)) {
                xVar.a(System.currentTimeMillis());
                return "";
            } else if ("HTTP_NO_CONTENT".equals(str2)) {
                xVar.a(System.currentTimeMillis());
                str2 = "";
            } else if (!TextUtils.isEmpty(str2)) {
                a(context, str2);
                xVar.a(System.currentTimeMillis());
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = g(context);
            if (TextUtils.isEmpty(str2)) {
                str2 = f(context);
                if (TextUtils.isEmpty(str2)) {
                    return str2;
                }
                a(context, str2);
            }
        }
        a.a(false);
        return str2;
    }

    public String a(String str) {
        a.a(true);
        Logger.info("DTM-Decode", "load json for preview");
        String c11 = c(str);
        return "HTTP_NO_CONTENT".equals(c11) ? "" : c11;
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(this.f48633a)) {
            Logger.error("DTM-Decode", "please load configuration first");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(e(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append(this.f48633a);
        File file = new File(sb2.toString());
        if (file.exists()) {
            return C0452w.a(file);
        }
        InputStream inputStream = null;
        try {
            AssetManager assets = context.getAssets();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("containers");
            sb3.append(str);
            sb3.append(this.f48633a);
            inputStream = assets.open(sb3.toString());
            return C0452w.a(inputStream);
        } catch (IOException unused) {
            Logger.debug("DTM-Decode", "Get digest IOException");
            return "";
        } finally {
            k.a(inputStream);
        }
    }

    public String c(Context context) {
        if (!TextUtils.isEmpty(this.f48634b)) {
            return this.f48634b;
        }
        i(context);
        return this.f48634b;
    }
}
