package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.uxcam.OnVerificationListener;
import com.uxcam.internals.gu;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import mz.l0;
import mz.m0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ij {

    /* renamed from: c  reason: collision with root package name */
    public static final String f13637c = "ij";

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f13638d = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13639a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f13640b;

    @Instrumented
    public class aa implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ae f13641a;

        public aa(ae aeVar) {
            this.f13641a = aeVar;
        }

        public void onFailure(@NotNull Call call, IOException iOException) {
            gu.ab a11 = gu.a("OkHttp");
            iOException.getMessage();
            a11.getClass();
            fz a12 = new fz().a("verifyAndUpload").a();
            StringBuilder a13 = hl.a("");
            a13.append(iOException.getMessage());
            a12.a("reason", a13.toString()).a(2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x006c A[EDGE_INSN: B:40:0x006c->B:18:0x006c ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(@androidx.annotation.NonNull okhttp3.Call r17, okhttp3.Response r18) {
            /*
                r16 = this;
                r1 = r16
                java.lang.String r2 = "sessionId"
                java.lang.String r3 = "try { }"
                java.lang.String r4 = "data"
                java.lang.String r5 = "reason"
                java.lang.String r6 = "site_of_error"
                java.lang.String r7 = "verifyAndUpload"
                r8 = 2
                okhttp3.ResponseBody r0 = r18.body()     // Catch:{ JSONException -> 0x0025, IOException -> 0x0023 }
                if (r0 == 0) goto L_0x0042
                okhttp3.ResponseBody r0 = r18.body()     // Catch:{ JSONException -> 0x0025, IOException -> 0x0023 }
                java.lang.String r0 = r0.string()     // Catch:{ JSONException -> 0x0025, IOException -> 0x0023 }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0025, IOException -> 0x0023 }
                r9.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0025, IOException -> 0x0023 }
                goto L_0x0043
            L_0x0023:
                r0 = move-exception
                goto L_0x0026
            L_0x0025:
                r0 = move-exception
            L_0x0026:
                com.uxcam.internals.fz r9 = new com.uxcam.internals.fz
                r9.<init>()
                com.uxcam.internals.fz r9 = r9.a((java.lang.String) r7)
                com.uxcam.internals.fz r9 = r9.a()
                com.uxcam.internals.fz r9 = r9.a(r6, r3)
                java.lang.String r0 = r0.getMessage()
                com.uxcam.internals.fz r0 = r9.a(r5, r0)
                r0.a((int) r8)
            L_0x0042:
                r9 = 0
            L_0x0043:
                com.uxcam.internals.ae r0 = r1.f13641a
                java.io.File r0 = r0.f12976b
                java.io.File r0 = r0.getParentFile()
                r10 = 1
                r11 = 0
                if (r0 == 0) goto L_0x006c
                java.io.File[] r0 = r0.listFiles()
                if (r0 == 0) goto L_0x006c
                int r12 = r0.length
                r13 = r11
            L_0x0057:
                if (r13 >= r12) goto L_0x006c
                r14 = r0[r13]
                java.lang.String r14 = r14.getName()
                java.lang.String r15 = ".usid"
                boolean r14 = r14.endsWith(r15)
                if (r14 == 0) goto L_0x0069
                r0 = r10
                goto L_0x006d
            L_0x0069:
                int r13 = r13 + 1
                goto L_0x0057
            L_0x006c:
                r0 = r11
            L_0x006d:
                boolean r0 = com.uxcam.internals.ik.a(r9, r0)
                if (r0 == 0) goto L_0x00a8
                com.uxcam.internals.hm r0 = com.uxcam.internals.hm.f()
                r0.f13581f = r11
                com.uxcam.internals.fz r0 = new com.uxcam.internals.fz
                r0.<init>()
                com.uxcam.internals.fz r0 = r0.a((java.lang.String) r7)
                com.uxcam.internals.fz r0 = r0.a()
                java.lang.String r2 = "shouldCancelSessionWithoutSendingCancellation"
                com.uxcam.internals.fz r0 = r0.a(r6, r2)
                boolean r2 = r9 instanceof org.json.JSONObject
                if (r2 != 0) goto L_0x0095
                java.lang.String r2 = r9.toString()
                goto L_0x0099
            L_0x0095:
                java.lang.String r2 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r9)
            L_0x0099:
                com.uxcam.internals.fz r0 = r0.a(r5, r2)
                r0.a((int) r8)
                com.uxcam.internals.ae r0 = r1.f13641a
                java.io.File r0 = r0.f12976b
                com.uxcam.internals.ia.c((java.io.File) r0)
                return
            L_0x00a8:
                if (r9 == 0) goto L_0x0117
                int r0 = r18.code()
                r12 = 200(0xc8, float:2.8E-43)
                if (r0 == r12) goto L_0x00b3
                goto L_0x0117
            L_0x00b3:
                java.lang.String r0 = "status"
                boolean r0 = r9.optBoolean(r0, r10)     // Catch:{ JSONException -> 0x00f5 }
                if (r0 == 0) goto L_0x0116
                org.json.JSONObject r0 = r9.getJSONObject(r4)     // Catch:{ JSONException -> 0x00f5 }
                java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.ij r10 = com.uxcam.internals.ij.this     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.ae r12 = r1.f13641a     // Catch:{ JSONException -> 0x00f5 }
                java.io.File r12 = r12.f12976b     // Catch:{ JSONException -> 0x00f5 }
                r10.b(r12, r0)     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.ij r10 = com.uxcam.internals.ij.this     // Catch:{ JSONException -> 0x00f5 }
                r10.c(r0)     // Catch:{ JSONException -> 0x00f5 }
                java.lang.String r0 = com.uxcam.internals.ij.f13637c     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.gu$ab r0 = com.uxcam.internals.gu.a(r0)     // Catch:{ JSONException -> 0x00f5 }
                org.json.JSONObject r10 = r9.getJSONObject(r4)     // Catch:{ JSONException -> 0x00f5 }
                r10.getString(r2)     // Catch:{ JSONException -> 0x00f5 }
                r0.getClass()     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.ae r0 = r1.f13641a     // Catch:{ JSONException -> 0x00f5 }
                org.json.JSONObject r2 = r9.getJSONObject(r4)     // Catch:{ JSONException -> 0x00f5 }
                java.lang.String r4 = "s3"
                org.json.JSONObject r2 = r2.getJSONObject(r4)     // Catch:{ JSONException -> 0x00f5 }
                r0.f12977c = r2     // Catch:{ JSONException -> 0x00f5 }
                com.uxcam.internals.ae r0 = r1.f13641a     // Catch:{ JSONException -> 0x00f5 }
                r0.a(r11)     // Catch:{ JSONException -> 0x00f5 }
                goto L_0x0116
            L_0x00f5:
                r0 = move-exception
                com.uxcam.internals.fz r2 = new com.uxcam.internals.fz
                r2.<init>()
                com.uxcam.internals.fz r2 = r2.a((java.lang.String) r7)
                com.uxcam.internals.fz r2 = r2.a()
                com.uxcam.internals.fz r2 = r2.a(r6, r3)
                java.lang.String r0 = r0.getMessage()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                com.uxcam.internals.fz r0 = r2.a(r5, r0)
                r0.a((int) r8)
            L_0x0116:
                return
            L_0x0117:
                com.uxcam.internals.hm r0 = com.uxcam.internals.hm.f()
                r0.f13581f = r11
                com.uxcam.internals.fz r0 = new com.uxcam.internals.fz
                r0.<init>()
                com.uxcam.internals.fz r0 = r0.a((java.lang.String) r7)
                com.uxcam.internals.fz r0 = r0.a()
                java.lang.String r2 = "200 != response.code()"
                com.uxcam.internals.fz r0 = r0.a(r6, r2)
                java.lang.String r2 = "Expected status code { 200 } but received was { "
                java.lang.StringBuilder r2 = com.uxcam.internals.hl.a(r2)
                int r3 = r18.code()
                r2.append(r3)
                java.lang.String r3 = " }"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.uxcam.internals.fz r0 = r0.a(r5, r2)
                r0.a((int) r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ij.aa.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    public class ab implements FilenameFilter {
        public ab(ij ijVar) {
        }

        public boolean accept(File file, String str) {
            return str.toLowerCase(Locale.ENGLISH).endsWith(".usid");
        }
    }

    public ij(Context context) {
        this.f13639a = context;
        String a11 = bm.a(context);
        String b11 = ia.b(context);
        String d11 = bm.d(context);
        String str = (String) ia.c(context).first;
        String valueOf = String.valueOf(561);
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.MODEL;
        int a12 = new eq(context).a();
        int b12 = new eq(context).b();
        try {
            JSONObject jSONObject = new JSONObject();
            this.f13640b = jSONObject;
            jSONObject.putOpt("buildIdentifier", b11);
            this.f13640b.putOpt("deviceId", a11);
            this.f13640b.putOpt(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, str2);
            this.f13640b.putOpt("platform", ht.f13603b);
            this.f13640b.putOpt("deviceType", d11);
            this.f13640b.putOpt("deviceModelName", str3);
            this.f13640b.putOpt("appVersion", str);
            this.f13640b.putOpt(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "3.4.4");
            this.f13640b.putOpt("sdkVersionNumber", valueOf);
            this.f13640b.putOpt("sessionsRecordedOnDevice", Integer.valueOf(a12));
            this.f13640b.putOpt("videosRecordedOnDevice", Integer.valueOf(b12));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void a(ae aeVar, String str) {
        String str2;
        aa aaVar = new aa(aeVar);
        File[] listFiles = aeVar.f12976b.listFiles(new m0());
        if (listFiles == null || listFiles.length <= 0) {
            str2 = null;
        } else {
            str2 = listFiles[0].getName().split("\\.")[0];
            StringBuilder sb2 = new StringBuilder();
            for (File append : listFiles) {
                sb2.append(" | ");
                sb2.append(append);
            }
            HashMap hashMap = new HashMap();
            StringBuilder a11 = hl.a("");
            a11.append(listFiles.length);
            hashMap.put("data_size", a11.toString());
            hashMap.put("files", "" + sb2);
            hu.b("verifyAndUpload", hashMap);
        }
        a(str, aaVar, str2, false);
    }

    public final void b(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + ".usid");
        gu.ab a11 = gu.a("file72");
        file2.getAbsolutePath();
        a11.getClass();
        File[] listFiles = file.listFiles(new ab(this));
        if (listFiles != null && listFiles.length == 0) {
            try {
                file2.createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        String str2;
        eq eqVar = new eq(this.f13639a);
        JSONObject jSONObject = this.f13640b;
        if (!(jSONObject instanceof JSONObject)) {
            str2 = jSONObject.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject);
        }
        SharedPreferences sharedPreferences = eqVar.f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public final JSONObject b(String str) {
        try {
            SharedPreferences sharedPreferences = new eq(this.f13639a).f13291a;
            return new JSONObject(sharedPreferences == null ? "" : sharedPreferences.getString(str, (String) null));
        } catch (JSONException e11) {
            e11.toString();
            gu.f13504c.getClass();
            return null;
        }
    }

    public void a(String str) {
        int i11;
        String str2 = f13637c;
        gu.a(str2).getClass();
        eq eqVar = new eq(this.f13639a);
        StringBuilder a11 = hl.a("settings_");
        a11.append(str.hashCode());
        String b11 = eqVar.b(a11.toString());
        if (b11 == null) {
            gu.a(str2).getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "cacheResponse is null.");
            hashMap.put("site_of_error", "autoVerify()");
            hu.c("[FAIL] Auto Verify", hashMap);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(b11);
            File[] listFiles = new File(by.a()).listFiles(new l0(str));
            if (listFiles == null) {
                i11 = 0;
            } else {
                i11 = listFiles.length;
            }
            gu.a(str2).getClass();
            if (i11 >= jSONObject.getJSONObject("data").getJSONObject("settings").optInt("maxOfflineVideos", 0)) {
                gm.A = true;
                jSONObject.getJSONObject("data").put("videoRecording", false);
            }
            a(jSONObject, true, str);
        } catch (Exception e11) {
            gu.a(f13637c).getClass();
            HashMap hashMap2 = new HashMap();
            StringBuilder a12 = hl.a("exception was thrown : ");
            a12.append(e11.getMessage());
            hashMap2.put("reason", a12.toString());
            hashMap2.put("at", "autoVerify()");
            hu.c("[FAIL] Auto Verify", hashMap2);
        }
    }

    public static boolean a(String str, File file, String str2) {
        boolean z11;
        boolean z12;
        try {
            if (str2.endsWith(String.valueOf(str.hashCode()))) {
                File file2 = new File(file, str2);
                String str3 = ia.f13615a;
                z11 = true;
                if (file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= listFiles.length) {
                                break;
                            } else if (by.a(listFiles[i11].getName())) {
                                z12 = true;
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    z12 = false;
                } else {
                    z12 = by.a(file2.getName());
                }
                if (z12 && !ia.e(new File(file, str2))) {
                    gu.a("val72").getClass();
                    return z11;
                }
            }
            z11 = false;
            gu.a("val72").getClass();
            return z11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final void a(JSONObject jSONObject, boolean z11, String str) {
        hm.f().f13581f = false;
        if (hm.f().f13579d != 2) {
            String str2 = f13637c;
            gu.a(str2).getClass();
            gu.ab a11 = gu.a(str2);
            if (!(jSONObject instanceof JSONObject)) {
                jSONObject.toString();
            } else {
                JSONObjectInstrumentation.toString(jSONObject);
            }
            a11.getClass();
            try {
                boolean optBoolean = jSONObject.optBoolean("status", true);
                if (optBoolean && !z11) {
                    hu.a(this.f13639a);
                }
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject.has("verifyLimits")) {
                    jSONObject2 = jSONObject.getJSONObject("verifyLimits");
                }
                if (a(this.f13639a, jSONObject2)) {
                    optBoolean = false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("verificationStatus", Boolean.valueOf(optBoolean));
                hashMap.put("offline", Boolean.valueOf(z11));
                hu.c("verificationSuccess", hashMap);
                if (jSONObject.has("cancelInternalLogs")) {
                    a(jSONObject.optBoolean("cancelInternalLogs"));
                }
                if (jSONObject.has("logLevel")) {
                    gm.K = jSONObject.optInt("logLevel");
                    this.f13639a.getSharedPreferences("UXCamLog", 0).edit().putInt("logLevel", 0).apply();
                }
                if (optBoolean) {
                    gm.f13453b = UUID.randomUUID().toString().concat(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE).concat(String.valueOf(str.hashCode()));
                    if (!z11) {
                        String string = jSONObject.optJSONObject("data").getString("sessionId");
                        b(new File(by.c()), string);
                        c(string);
                    }
                    Context context = this.f13639a;
                    ih.f13634a = optBoolean;
                    gm.f13477z = z11;
                    new gn(jSONObject, context).a();
                    af.a(str);
                    return;
                }
                bi.f13067b = false;
                String str3 = "";
                try {
                    str3 = jSONObject.optString("message");
                    if (str3.isEmpty()) {
                        str3 = jSONObject.optJSONObject("error").optString("message");
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                gu.f13504c.b("UXCam 3.4.4[561] : Application Key verification failed. Error : " + str3, new Object[0]);
                hm.f().f13579d = 1;
                for (OnVerificationListener onVerificationFailed : hm.f().f13576a) {
                    onVerificationFailed.onVerificationFailed(str3);
                }
            } catch (Exception e12) {
                String str4 = f13637c;
                gu.a(str4).getClass();
                gu.ab a12 = gu.a(str4);
                e12.toString();
                a12.getClass();
            }
        }
    }

    public boolean a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.has("stopUntil") && ((double) System.currentTimeMillis()) < jSONObject.optDouble("stopUntil") * 1000.0d) {
                return true;
            }
            if (jSONObject.has("sdkVersionNewerThan") && 561.0d <= jSONObject.optDouble("sdkVersionNewerThan")) {
                return true;
            }
            if (jSONObject.has("appVersionNotInList")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("appVersionNotInList");
                if (!f13638d) {
                    if (optJSONArray == null) {
                        throw new AssertionError();
                    }
                }
                String str = (String) ia.c(context).first;
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    if (optJSONArray.getString(i11).equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0118 A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, okhttp3.Callback r9, java.lang.String r10, boolean r11) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x0011
            java.lang.String r2 = ""
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x000e }
            if (r2 != 0) goto L_0x0011
            r2 = r0
            goto L_0x0012
        L_0x000e:
            r8 = move-exception
            goto L_0x0122
        L_0x0011:
            r2 = r1
        L_0x0012:
            android.content.Context r3 = r7.f13639a     // Catch:{ Exception -> 0x000e }
            boolean r3 = com.uxcam.internals.bh.a(r3)     // Catch:{ Exception -> 0x000e }
            if (r3 == 0) goto L_0x0118
            org.json.JSONObject r3 = r7.f13640b     // Catch:{ Exception -> 0x000e }
            java.lang.String r4 = "appKey"
            r3.put((java.lang.String) r4, (java.lang.Object) r8)     // Catch:{ Exception -> 0x000e }
            okhttp3.OkHttpClient$Builder r8 = new okhttp3.OkHttpClient$Builder     // Catch:{ Exception -> 0x000e }
            r8.<init>()     // Catch:{ Exception -> 0x000e }
            r3 = 0
            okhttp3.OkHttpClient$Builder r8 = r8.cache(r3)     // Catch:{ Exception -> 0x000e }
            okhttp3.OkHttpClient r8 = r8.build()     // Catch:{ Exception -> 0x000e }
            okhttp3.FormBody$Builder r3 = new okhttp3.FormBody$Builder     // Catch:{ Exception -> 0x000e }
            r3.<init>()     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0064
            java.lang.String r4 = "sessionId"
            r3.add(r4, r10)     // Catch:{ Exception -> 0x000e }
            org.json.JSONObject r10 = r7.b(r10)     // Catch:{ Exception -> 0x000e }
            r7.f13640b = r10     // Catch:{ Exception -> 0x000e }
            if (r10 == 0) goto L_0x0046
            r7.a((okhttp3.FormBody.Builder) r3)     // Catch:{ Exception -> 0x000e }
        L_0x0046:
            java.lang.String r10 = f13637c     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r10)     // Catch:{ Exception -> 0x000e }
            org.json.JSONObject r5 = r7.f13640b     // Catch:{ Exception -> 0x000e }
            boolean r6 = r5 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x000e }
            if (r6 != 0) goto L_0x0056
            r5.toString()     // Catch:{ Exception -> 0x000e }
            goto L_0x0059
        L_0x0056:
            com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)     // Catch:{ Exception -> 0x000e }
        L_0x0059:
            r4.getClass()     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r10 = com.uxcam.internals.gu.a(r10)     // Catch:{ Exception -> 0x000e }
            r10.getClass()     // Catch:{ Exception -> 0x000e }
            goto L_0x0084
        L_0x0064:
            r7.a((okhttp3.FormBody.Builder) r3)     // Catch:{ Exception -> 0x000e }
            java.lang.String r10 = f13637c     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r10)     // Catch:{ Exception -> 0x000e }
            org.json.JSONObject r5 = r7.f13640b     // Catch:{ Exception -> 0x000e }
            boolean r6 = r5 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x000e }
            if (r6 != 0) goto L_0x0077
            r5.toString()     // Catch:{ Exception -> 0x000e }
            goto L_0x007a
        L_0x0077:
            com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)     // Catch:{ Exception -> 0x000e }
        L_0x007a:
            r4.getClass()     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r10 = com.uxcam.internals.gu.a(r10)     // Catch:{ Exception -> 0x000e }
            r10.getClass()     // Catch:{ Exception -> 0x000e }
        L_0x0084:
            if (r11 == 0) goto L_0x00a7
            android.content.Context r10 = r7.f13639a     // Catch:{ Exception -> 0x000e }
            java.lang.String r11 = "UXCamLog"
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r11, r1)     // Catch:{ Exception -> 0x000e }
            java.lang.String r11 = "events"
            java.lang.String r1 = "[]"
            java.lang.String r10 = r10.getString(r11, r1)     // Catch:{ Exception -> 0x000e }
            java.lang.String r11 = "internalDebugEvents"
            r3.add(r11, r10)     // Catch:{ Exception -> 0x000e }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x000e }
            r11.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x000e }
            int r10 = r11.length()     // Catch:{ Exception -> 0x000e }
            int r10 = r10 - r0
            com.uxcam.internals.hu.f13606c = r10     // Catch:{ Exception -> 0x000e }
        L_0x00a7:
            java.lang.String r10 = com.uxcam.internals.ht.a()     // Catch:{ Exception -> 0x000e }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ Exception -> 0x000e }
            r11.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = "isOldSession"
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x000e }
            r11.put(r0, r1)     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = "verificationStarted"
            com.uxcam.internals.hu.c(r0, r11)     // Catch:{ Exception -> 0x000e }
            java.lang.String r11 = "pendingSessionCount"
            java.lang.String r0 = "count"
            int r1 = com.uxcam.UXCam.pendingUploads()     // Catch:{ Exception -> 0x000e }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x000e }
            java.util.Map r0 = java.util.Collections.singletonMap(r0, r1)     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.hu.c(r11, r0)     // Catch:{ Exception -> 0x000e }
            okhttp3.FormBody r11 = r3.build()     // Catch:{ Exception -> 0x000e }
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x000e }
            r0.<init>()     // Catch:{ Exception -> 0x000e }
            okhttp3.Request$Builder r10 = r0.url((java.lang.String) r10)     // Catch:{ Exception -> 0x000e }
            okhttp3.Request$Builder r10 = r10.post(r11)     // Catch:{ Exception -> 0x000e }
            boolean r11 = r10 instanceof okhttp3.Request.Builder     // Catch:{ Exception -> 0x000e }
            if (r11 != 0) goto L_0x00eb
            okhttp3.Request r10 = r10.build()     // Catch:{ Exception -> 0x000e }
            goto L_0x00ef
        L_0x00eb:
            okhttp3.Request r10 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r10)     // Catch:{ Exception -> 0x000e }
        L_0x00ef:
            okio.Buffer r11 = new okio.Buffer     // Catch:{ Exception -> 0x000e }
            r11.<init>()     // Catch:{ Exception -> 0x000e }
            okhttp3.RequestBody r0 = r10.body()     // Catch:{ Exception -> 0x000e }
            r0.writeTo(r11)     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = f13637c     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r0 = com.uxcam.internals.gu.a(r0)     // Catch:{ Exception -> 0x000e }
            r11.readUtf8()     // Catch:{ Exception -> 0x000e }
            r0.getClass()     // Catch:{ Exception -> 0x000e }
            boolean r11 = r8 instanceof okhttp3.OkHttpClient     // Catch:{ Exception -> 0x000e }
            if (r11 != 0) goto L_0x0110
            okhttp3.Call r8 = r8.newCall(r10)     // Catch:{ Exception -> 0x000e }
            goto L_0x0114
        L_0x0110:
            okhttp3.Call r8 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r8, r10)     // Catch:{ Exception -> 0x000e }
        L_0x0114:
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r8, r9)     // Catch:{ Exception -> 0x000e }
            goto L_0x013e
        L_0x0118:
            java.lang.String r8 = f13637c     // Catch:{ Exception -> 0x000e }
            com.uxcam.internals.gu$ab r8 = com.uxcam.internals.gu.a(r8)     // Catch:{ Exception -> 0x000e }
            r8.getClass()     // Catch:{ Exception -> 0x000e }
            goto L_0x013e
        L_0x0122:
            java.lang.String r9 = f13637c
            com.uxcam.internals.gu$ab r9 = com.uxcam.internals.gu.a(r9)
            r9.getClass()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r8 = r8.getMessage()
            java.lang.String r10 = "reason"
            r9.put(r10, r8)
            java.lang.String r8 = "verificationFailed"
            com.uxcam.internals.hu.c(r8, r9)
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ij.a(java.lang.String, okhttp3.Callback, java.lang.String, boolean):void");
    }

    public final void a(FormBody.Builder builder) {
        Iterator<String> keys = this.f13640b.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            builder.add(next, this.f13640b.getString(next));
        }
    }

    public final void a(boolean z11) {
        if (z11) {
            Context context = this.f13639a;
            hu.f13604a = new JSONArray();
            SharedPreferences.Editor edit = context.getSharedPreferences("UXCamLog", 0).edit();
            JSONArray jSONArray = hu.f13604a;
            edit.putString("events", !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).apply();
            HashMap hashMap = new HashMap();
            hashMap.put("cancelInternalLogs", String.valueOf(true));
            hu.a("enableOrDisableInternalLogs", hashMap);
            this.f13639a.getSharedPreferences("UXCamLog", 0).edit().putBoolean("debug", false).apply();
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cancelInternalLogs", String.valueOf(false));
        hu.a("enableOrDisableInternalLogs", hashMap2);
        this.f13639a.getSharedPreferences("UXCamLog", 0).edit().putBoolean("debug", true).apply();
    }
}
