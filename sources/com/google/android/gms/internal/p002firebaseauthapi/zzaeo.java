package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeo  reason: invalid package */
public final class zzaeo extends zzaei {
    private static final String zza = "zzaeo";
    @Nullable
    private String zzb;
    @Nullable
    private String zzc;
    private int zzd;
    @Nullable
    private String zze;
    private int zzf;
    private long zzg;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        zzg(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzaei zzb(String str) throws zzyq {
        zzg(str);
        return this;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzd;
    }

    public final long zzf() {
        return this.zzg;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzaeo zzg(java.lang.String r5) throws com.google.android.gms.internal.p002firebaseauthapi.zzyq {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r0.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "totpSessionInfo"
            org.json.JSONObject r0 = r0.optJSONObject(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            if (r0 == 0) goto L_0x006b
            java.lang.String r1 = "sharedSecretKey"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r4.zzc = r1     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "verificationCodeLength"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r4.zzd = r1     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "hashingAlgorithm"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r4.zze = r1     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "periodSec"
            int r1 = r0.optInt(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r4.zzf = r1     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "sessionInfo"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = com.google.android.gms.internal.p002firebaseauthapi.zzac.zza(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r4.zzb = r1     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r1 = "finalizeEnrollmentTime"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            com.google.android.gms.internal.firebase-auth-api.zzajj r1 = com.google.android.gms.internal.p002firebaseauthapi.zzake.zzb(r0)     // Catch:{ ParseException -> 0x0055 }
            com.google.android.gms.internal.p002firebaseauthapi.zzake.zza(r1)     // Catch:{ ParseException -> 0x0055 }
            long r1 = r1.zzb()     // Catch:{ ParseException -> 0x0055 }
            r4.zzg = r1     // Catch:{ ParseException -> 0x0055 }
            goto L_0x006b
        L_0x0055:
            java.lang.String r1 = zza     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r2.<init>()     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r3 = "Failed to parse timestamp: "
            r2.append(r3)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            r2.append(r0)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
            android.util.Log.e(r1, r0)     // Catch:{ JSONException -> 0x006e, NullPointerException -> 0x006c }
        L_0x006b:
            return r4
        L_0x006c:
            r0 = move-exception
            goto L_0x006f
        L_0x006e:
            r0 = move-exception
        L_0x006f:
            java.lang.String r1 = zza
            com.google.android.gms.internal.firebase-auth-api.zzyq r5 = com.google.android.gms.internal.p002firebaseauthapi.zzafd.zza(r0, r1, r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaeo.zzg(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzaeo");
    }

    @Nullable
    public final String zzh() {
        return this.zze;
    }

    @Nullable
    public final String zzi() {
        return this.zzc;
    }
}
