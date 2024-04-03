package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.uxcam.internals.gu;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

@Instrumented
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public Context f12975a;

    /* renamed from: b  reason: collision with root package name */
    public File f12976b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f12977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12978d = false;

    public class aa implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12980b;

        public aa(String str, String str2, String str3) {
            this.f12979a = str;
            this.f12980b = str3;
        }

        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            try {
                gu.a("S3Uploader").getClass();
                ae aeVar = ae.this;
                aeVar.a(aeVar.f12976b, iOException.getMessage(), -1);
            } catch (Exception unused) {
                gu.a("S3Uploader").getClass();
                fz a11 = new fz().a();
                a11.a("site_of_error", "AmazonUploader::anonymousCallback -> onFailure()");
                StringBuilder a12 = hl.a("exception while trying to log failure : { ");
                a12.append(iOException.getMessage());
                a12.append(" }");
                a11.a("reason", a12.toString()).a(2);
            }
        }

        public void onResponse(@NonNull Call call, @NonNull Response response) {
            String str;
            if (!response.isSuccessful()) {
                ae aeVar = ae.this;
                aeVar.a(aeVar.f12976b, response.message(), response.code());
            } else if (Integer.parseInt(this.f12979a) == response.code()) {
                gu.ab a11 = gu.a("S3Uploader");
                ae.this.f12976b.length();
                a11.getClass();
                HttpPostService.a(ae.this.f12976b);
                String header = response.header(HttpHeaders.ETAG);
                if (!(header == null || (str = this.f12980b) == null || !header.contains(str))) {
                    if (bh.b(ae.this.f12975a)) {
                        eq eqVar = new eq(ae.this.f12975a);
                        long length = ae.this.f12976b.length();
                        SharedPreferences sharedPreferences = eqVar.f13291a;
                        long j11 = 0;
                        if (sharedPreferences != null) {
                            j11 = sharedPreferences.getLong("mobile_data_used_size", 0);
                        }
                        long j12 = j11 + length;
                        SharedPreferences sharedPreferences2 = eqVar.f13291a;
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putLong("mobile_data_used_size", j12).apply();
                        }
                    }
                    ae.this.f12976b.delete();
                    ae.this.a();
                }
                hm.i();
                fz a12 = new fz().a("S3 File Upload").c().a("file_name", ae.this.f12976b.getName().replace("$", "/"));
                StringBuilder a13 = hl.a("");
                a13.append(ae.this.f12976b.length());
                fz a14 = a12.a("file_size", a13.toString());
                StringBuilder a15 = hl.a("");
                a15.append(ae.this.f12978d);
                a14.a("is_offline", a15.toString()).a(2);
            } else {
                ae aeVar2 = ae.this;
                aeVar2.a(aeVar2.f12976b, response.message(), response.code());
            }
            response.body().close();
        }
    }

    public final void a(File file, String str, int i11) {
        gu.ab a11 = gu.a("S3Uploader");
        file.getAbsolutePath();
        file.length();
        a11.getClass();
        HttpPostService.a(file);
        hm.i();
        String replace = file.getName().replace("$", "/");
        fz a12 = new fz().a("S3 File Upload").a().a("http_response", str);
        a12.a("response_code", "" + i11);
        a12.a("is_offline", String.valueOf(this.f12978d)).a("file_name", replace).a(2);
    }

    public void b(Context context, File file) {
        Iterator it = HttpPostService.f13679b.iterator();
        while (true) {
            if (!it.hasNext()) {
                HttpPostService.f13679b.add(file.getAbsolutePath());
                break;
            }
            if (file.getAbsolutePath().equals((String) it.next())) {
                break;
            }
        }
        a(context, file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r19, java.io.File r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r0.f12975a = r1
            boolean r2 = r20.exists()
            java.lang.String r3 = "site_of_error"
            r4 = 1
            if (r2 == 0) goto L_0x0167
            r2 = r20
            r0.f12976b = r2
            org.json.JSONObject r5 = r0.f12977c
            if (r5 != 0) goto L_0x001b
            org.json.JSONObject r5 = com.uxcam.internals.gm.f13461j
            r0.f12977c = r5
        L_0x001b:
            boolean r5 = com.uxcam.internals.bh.b(r19)
            com.uxcam.internals.eq r6 = new com.uxcam.internals.eq
            r6.<init>(r1)
            java.io.File r1 = r20.getParentFile()
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "override_mobile_data_data_only_setting_"
            r2.append(r7)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            boolean r1 = r6.a((java.lang.String) r1)
            java.lang.String r2 = "upload(false)"
            java.lang.String r6 = "invokes_next"
            r7 = 0
            if (r5 == 0) goto L_0x0063
            if (r1 == 0) goto L_0x0063
            com.uxcam.internals.fz r1 = new com.uxcam.internals.fz
            r1.<init>()
            com.uxcam.internals.fz r1 = r1.b()
            java.lang.String r5 = "AmazonUploader::upload() -> if0"
            r1.a(r3, r5)
            r1.a(r6, r2)
            r1.a((int) r4)
            r0.a(r7)
            goto L_0x019a
        L_0x0063:
            if (r5 == 0) goto L_0x0084
            boolean r1 = com.uxcam.internals.gm.f13460i
            if (r1 == 0) goto L_0x0084
            com.uxcam.internals.fz r1 = new com.uxcam.internals.fz
            r1.<init>()
            com.uxcam.internals.fz r1 = r1.b()
            java.lang.String r2 = "AmazonUploader::upload() -> if1"
            r1.a(r3, r2)
            java.lang.String r2 = "upload(true)"
            r1.a(r6, r2)
            r1.a((int) r4)
            r0.a(r4)
            goto L_0x019a
        L_0x0084:
            android.content.Context r1 = r0.f12975a
            boolean r1 = com.uxcam.internals.bh.c(r1)
            android.content.Context r5 = r0.f12975a
            boolean r5 = com.uxcam.internals.bh.b(r5)
            com.uxcam.internals.eq r8 = new com.uxcam.internals.eq
            android.content.Context r9 = r0.f12975a
            r8.<init>(r9)
            android.content.SharedPreferences r8 = r8.f13291a
            java.lang.String r9 = "current_month"
            if (r8 != 0) goto L_0x009f
            r8 = r7
            goto L_0x00a3
        L_0x009f:
            int r8 = r8.getInt(r9, r7)
        L_0x00a3:
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            r11 = 2
            int r10 = r10.get(r11)
            int r10 = r10 + r4
            java.lang.String r12 = "mobile_data_used_size"
            r13 = 0
            java.lang.String r15 = "S3Uploader"
            if (r8 == r10) goto L_0x00e8
            com.uxcam.internals.eq r8 = new com.uxcam.internals.eq
            android.content.Context r7 = r0.f12975a
            r8.<init>(r7)
            android.content.SharedPreferences r7 = r8.f13291a
            if (r7 == 0) goto L_0x00cb
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.putInt(r9, r10)
            r7.apply()
        L_0x00cb:
            com.uxcam.internals.eq r7 = new com.uxcam.internals.eq
            android.content.Context r8 = r0.f12975a
            r7.<init>(r8)
            android.content.SharedPreferences r7 = r7.f13291a
            if (r7 == 0) goto L_0x00e1
            android.content.SharedPreferences$Editor r7 = r7.edit()
            android.content.SharedPreferences$Editor r7 = r7.putLong(r12, r13)
            r7.apply()
        L_0x00e1:
            com.uxcam.internals.gu$ab r7 = com.uxcam.internals.gu.a(r15)
            r7.getClass()
        L_0x00e8:
            if (r5 == 0) goto L_0x0140
            int r5 = com.uxcam.internals.gm.f13459h
            if (r5 <= 0) goto L_0x0140
            java.io.File r1 = r0.f12976b
            java.io.File r1 = r1.getParentFile()
            long r7 = com.uxcam.internals.ia.d((java.io.File) r1)
            int r1 = com.uxcam.internals.gm.f13459h
            long r9 = (long) r1
            r16 = 1024(0x400, double:5.06E-321)
            long r9 = r9 * r16
            long r9 = r9 * r16
            com.uxcam.internals.eq r1 = new com.uxcam.internals.eq
            android.content.Context r5 = r0.f12975a
            r1.<init>(r5)
            android.content.SharedPreferences r1 = r1.f13291a
            if (r1 != 0) goto L_0x010d
            goto L_0x0111
        L_0x010d:
            long r13 = r1.getLong(r12, r13)
        L_0x0111:
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r15)
            r1.getClass()
            long r12 = r9 - r13
            int r1 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r1 <= 0) goto L_0x0142
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r15)
            r1.getClass()
            com.uxcam.internals.fx r1 = new com.uxcam.internals.fx
            r1.<init>()
            java.lang.String r5 = "Monthly Data Limit Reached"
            com.uxcam.internals.fx r1 = r1.a((java.lang.String) r5)
            java.lang.String r5 = "AmazonUploader::isBelowDataSizeLimit"
            r1.a((java.lang.String) r3, (java.lang.String) r5)
            float r5 = (float) r9
            java.lang.String r7 = "data_limit_kb"
            com.uxcam.internals.fx r1 = r1.a((java.lang.String) r7, (float) r5)
            r1.a((int) r11)
            goto L_0x014b
        L_0x0140:
            if (r1 == 0) goto L_0x0144
        L_0x0142:
            r1 = r4
            goto L_0x014c
        L_0x0144:
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r15)
            r1.getClass()
        L_0x014b:
            r1 = 0
        L_0x014c:
            if (r1 == 0) goto L_0x019a
            com.uxcam.internals.fz r1 = new com.uxcam.internals.fz
            r1.<init>()
            com.uxcam.internals.fz r1 = r1.b()
            java.lang.String r5 = "AmazonUploader::upload() -> if2"
            r1.a(r3, r5)
            r1.a(r6, r2)
            r1.a((int) r4)
            r1 = 0
            r0.a(r1)
            goto L_0x019a
        L_0x0167:
            r2 = r20
            com.uxcam.internals.fz r1 = new com.uxcam.internals.fz
            r1.<init>()
            com.uxcam.internals.fz r1 = r1.b()
            java.lang.String r5 = "AmazonUploader::upload() -> else"
            r1.a(r3, r5)
            java.lang.String r2 = r20.getAbsolutePath()
            java.lang.String r3 = "name_of_file"
            com.uxcam.internals.fz r1 = r1.a(r3, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "condition_met -> is_below_data_size_limit"
            r1.a(r3, r2)
            r1.a((int) r4)
        L_0x019a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ae.a(android.content.Context, java.io.File):void");
    }

    public void a(boolean z11) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        try {
            File[] listFiles = this.f12976b.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                String name2 = this.f12976b.getName();
                boolean startsWith = name2.startsWith("data");
                if (!z11 || startsWith) {
                    String str9 = "reason";
                    str = "body";
                    String str10 = "file_size";
                    if (name2.startsWith("video")) {
                        str4 = MimeTypes.VIDEO_MP4;
                        try {
                            jSONObject = this.f12977c.getJSONObject("video").getJSONObject(str);
                            str3 = this.f12977c.getJSONObject("video").getString("url");
                            str5 = this.f12977c.getJSONObject("video").getJSONObject(str).getString("success_action_status");
                        } catch (Exception e11) {
                            e = e11;
                            str2 = str9;
                            str = str10;
                            fz c11 = new fz().a("S3 File Upload").c();
                            StringBuilder a11 = hl.a("an exception was thrown ");
                            a11.append(e.getMessage());
                            fz a12 = c11.a(str2, a11.toString()).a("file_name", this.f12976b.getName());
                            StringBuilder a13 = hl.a("");
                            a13.append(this.f12976b.length());
                            fz a14 = a12.a(str, a13.toString());
                            StringBuilder a15 = hl.a("");
                            a15.append(this.f12978d);
                            a14.a("is_offline", a15.toString()).a(2);
                        }
                    } else if (name2.startsWith("data")) {
                        str4 = "text/plain";
                        JSONObject jSONObject2 = this.f12977c.getJSONObject("data").getJSONObject(str);
                        str3 = this.f12977c.getJSONObject("data").getString("url");
                        str5 = this.f12977c.getJSONObject("data").getJSONObject(str).getString("success_action_status");
                        jSONObject = jSONObject2;
                    } else if (name2.startsWith("icon")) {
                        try {
                            if (!this.f12977c.has("icon")) {
                                gu.a("S3Uploader").getClass();
                                this.f12976b.delete();
                                return;
                            }
                            jSONObject = this.f12977c.getJSONObject("icon").getJSONObject(str);
                            str3 = this.f12977c.getJSONObject("icon").getString("url");
                            str5 = this.f12977c.getJSONObject("icon").getJSONObject(str).getString("success_action_status");
                            str4 = "image/png";
                        } catch (Exception e12) {
                            e = e12;
                            str = str10;
                            str2 = str9;
                            fz c112 = new fz().a("S3 File Upload").c();
                            StringBuilder a112 = hl.a("an exception was thrown ");
                            a112.append(e.getMessage());
                            fz a122 = c112.a(str2, a112.toString()).a("file_name", this.f12976b.getName());
                            StringBuilder a132 = hl.a("");
                            a132.append(this.f12976b.length());
                            fz a142 = a122.a(str, a132.toString());
                            StringBuilder a152 = hl.a("");
                            a152.append(this.f12978d);
                            a142.a("is_offline", a152.toString()).a(2);
                        }
                    } else {
                        str = str10;
                        fz fzVar = new fz();
                        fzVar.a("site_of_error", "AmazonUploader::upload -> else { }");
                        str2 = str9;
                        try {
                            fzVar.a(str2, "file name comparison has failed, there exist no valid file named : " + this.f12976b.getName()).a(2);
                            return;
                        } catch (Exception e13) {
                            e = e13;
                            fz c1122 = new fz().a("S3 File Upload").c();
                            StringBuilder a1122 = hl.a("an exception was thrown ");
                            a1122.append(e.getMessage());
                            fz a1222 = c1122.a(str2, a1122.toString()).a("file_name", this.f12976b.getName());
                            StringBuilder a1322 = hl.a("");
                            a1322.append(this.f12976b.length());
                            fz a1422 = a1222.a(str, a1322.toString());
                            StringBuilder a1522 = hl.a("");
                            a1522.append(this.f12978d);
                            a1422.a("is_offline", a1522.toString()).a(2);
                        }
                    }
                    jSONObject.remove("file");
                    String optString = jSONObject.optString("key");
                    String name3 = this.f12976b.getName();
                    if (name3 == null) {
                        str7 = str5;
                        str6 = name2;
                        str8 = null;
                    } else {
                        str7 = str5;
                        int lastIndexOf = name3.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        str6 = name2;
                        if (name3.lastIndexOf("/") > lastIndexOf) {
                            lastIndexOf = 1;
                        }
                        if (lastIndexOf == 1) {
                            str8 = "";
                        } else {
                            str8 = name3.substring(lastIndexOf + 1);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    if (optString == null) {
                        optString = null;
                    } else {
                        int lastIndexOf2 = optString.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        if (optString.lastIndexOf("/") > lastIndexOf2) {
                            lastIndexOf2 = 1;
                        }
                        if (lastIndexOf2 != 1) {
                            optString = optString.substring(0, lastIndexOf2);
                        }
                    }
                    sb2.append(optString);
                    sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                    sb2.append(str8);
                    String sb3 = sb2.toString();
                    jSONObject.put("key", (Object) sb3);
                    gu.ab a16 = gu.a("S3Uploader");
                    this.f12976b.getAbsolutePath();
                    a16.getClass();
                    str = str10;
                    try {
                        new fz().a("S3 File Upload").b().a("file_name", sb3).a(str, "" + this.f12976b.length()).a("is_offline_session", "" + this.f12978d).a(2);
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        OkHttpClient build = builder.connectTimeout(30000, timeUnit).writeTimeout(30000, timeUnit).readTimeout(30000, timeUnit).build();
                        MediaType parse = MediaType.parse(str4);
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            type.addFormDataPart(next, jSONObject.getString(next));
                        }
                        type.addFormDataPart("file", "X", RequestBody.create(parse, this.f12976b));
                        Request.Builder post = new Request.Builder().url(str3).post(type.build());
                        Request build2 = !(post instanceof Request.Builder) ? post.build() : OkHttp3Instrumentation.build(post);
                        FirebasePerfOkHttpClient.enqueue(!(build instanceof OkHttpClient) ? build.newCall(build2) : OkHttp3Instrumentation.newCall(build, build2), new aa(str7, str6, dr.a(this.f12976b)));
                    } catch (Exception e14) {
                        e = e14;
                        str2 = str9;
                        fz c11222 = new fz().a("S3 File Upload").c();
                        StringBuilder a11222 = hl.a("an exception was thrown ");
                        a11222.append(e.getMessage());
                        fz a12222 = c11222.a(str2, a11222.toString()).a("file_name", this.f12976b.getName());
                        StringBuilder a13222 = hl.a("");
                        a13222.append(this.f12976b.length());
                        fz a14222 = a12222.a(str, a13222.toString());
                        StringBuilder a15222 = hl.a("");
                        a15222.append(this.f12978d);
                        a14222.a("is_offline", a15222.toString()).a(2);
                    }
                } else {
                    HttpPostService.a(this.f12976b);
                }
            } else {
                for (File a17 : listFiles) {
                    ae aeVar = new ae();
                    aeVar.f12978d = this.f12978d;
                    aeVar.f12977c = this.f12977c;
                    aeVar.a(this.f12975a, a17);
                }
            }
        } catch (Exception e15) {
            e = e15;
            str = "file_size";
            str2 = "reason";
            fz c112222 = new fz().a("S3 File Upload").c();
            StringBuilder a112222 = hl.a("an exception was thrown ");
            a112222.append(e.getMessage());
            fz a122222 = c112222.a(str2, a112222.toString()).a("file_name", this.f12976b.getName());
            StringBuilder a132222 = hl.a("");
            a132222.append(this.f12976b.length());
            fz a142222 = a122222.a(str, a132222.toString());
            StringBuilder a152222 = hl.a("");
            a152222.append(this.f12978d);
            a142222.a("is_offline", a152222.toString()).a(2);
        }
    }

    public final void a() {
        File[] listFiles;
        File parentFile = this.f12976b.getParentFile();
        if (parentFile != null && (listFiles = parentFile.listFiles()) != null && listFiles.length == 1) {
            String name2 = listFiles[0].getName();
            if (name2.endsWith(".usid")) {
                String str = name2.split(".usid")[0];
                eq eqVar = new eq(this.f12975a);
                SharedPreferences sharedPreferences = eqVar.f13291a;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().remove(str).apply();
                }
                String name3 = parentFile.getName();
                eqVar.c("override_mobile_data_data_only_setting_" + name3);
                gu.a("S3Uploader").getClass();
            }
            listFiles[0].delete();
            parentFile.delete();
            gu.ab a11 = gu.a("S3Uploader");
            parentFile.getName();
            a11.getClass();
        }
    }
}
