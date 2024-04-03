package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzwh;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public final class zzbt {
    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final Logger zzd = new Logger("StorageHelpers", new String[0]);

    public zzbt(Context context, String str) {
        Preconditions.checkNotNull(context);
        String checkNotEmpty = Preconditions.checkNotEmpty(str);
        this.zzb = checkNotEmpty;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{checkNotEmpty}), 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r15v6, types: [com.google.firebase.auth.TotpMultiFactorInfo] */
    /* JADX WARNING: type inference failed for: r15v7, types: [com.google.firebase.auth.PhoneMultiFactorInfo] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        throw new com.google.android.gms.internal.p002firebaseauthapi.zzwh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0174, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x017a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017b, code lost:
        r26.zzd.wtf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6 A[SYNTHETIC, Splitter:B:33:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0174 A[ExcHandler: zzwh | ArrayIndexOutOfBoundsException | IllegalArgumentException (e java.lang.Throwable), Splitter:B:1:0x0009] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.auth.internal.zzx zzf(org.json.JSONObject r27) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "userMultiFactorInfo"
            java.lang.String r2 = "userMetadata"
            r3 = 0
            java.lang.String r4 = "cachedTokenState"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r5 = "applicationName"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r6 = "anonymous"
            boolean r6 = r0.getBoolean(r6)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r7 = "2"
            java.lang.String r8 = "version"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r8 == 0) goto L_0x0024
            r7 = r8
        L_0x0024:
            java.lang.String r8 = "userInfos"
            org.json.JSONArray r8 = r0.getJSONArray(r8)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            int r9 = r8.length()     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r10.<init>(r9)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r12 = 0
        L_0x0034:
            java.lang.String r13 = "phoneNumber"
            java.lang.String r14 = "displayName"
            if (r12 >= r9) goto L_0x0085
            java.lang.String r15 = r8.getString(r12)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzt> r16 = com.google.firebase.auth.internal.zzt.CREATOR     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r11.<init>((java.lang.String) r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r15 = "userId"
            java.lang.String r18 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r15 = "providerId"
            java.lang.String r19 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r15 = "email"
            java.lang.String r20 = r11.optString(r15)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r21 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r22 = r11.optString(r14)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r13 = "photoUrl"
            java.lang.String r23 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r13 = "isEmailVerified"
            boolean r24 = r11.optBoolean(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r13 = "rawUserInfo"
            java.lang.String r25 = r11.optString(r13)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            com.google.firebase.auth.internal.zzt r11 = new com.google.firebase.auth.internal.zzt     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r17 = r11
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ JSONException -> 0x007e, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r10.add(r11)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            int r12 = r12 + 1
            goto L_0x0034
        L_0x007e:
            r0 = move-exception
            com.google.android.gms.internal.firebase-auth-api.zzwh r1 = new com.google.android.gms.internal.firebase-auth-api.zzwh     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            throw r1     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0085:
            com.google.firebase.FirebaseApp r5 = com.google.firebase.FirebaseApp.getInstance(r5)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            com.google.firebase.auth.internal.zzx r8 = new com.google.firebase.auth.internal.zzx     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r8.<init>(r5, r10)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r5 != 0) goto L_0x009b
            com.google.android.gms.internal.firebase-auth-api.zzadr r4 = com.google.android.gms.internal.p002firebaseauthapi.zzadr.zzd(r4)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r8.zzh(r4)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x009b:
            if (r6 != 0) goto L_0x00a0
            r8.zzm()     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x00a0:
            r8.zzl(r7)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r4 == 0) goto L_0x00c9
            org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzz> r4 = com.google.firebase.auth.internal.zzz.CREATOR     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 != 0) goto L_0x00b3
        L_0x00b1:
            r2 = r3
            goto L_0x00c4
        L_0x00b3:
            java.lang.String r4 = "lastSignInTimestamp"
            long r4 = r2.getLong(r4)     // Catch:{ JSONException -> 0x00b1, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r6 = "creationTimestamp"
            long r6 = r2.getLong(r6)     // Catch:{ JSONException -> 0x00b1, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            com.google.firebase.auth.internal.zzz r2 = new com.google.firebase.auth.internal.zzz     // Catch:{ JSONException -> 0x00b1, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r2.<init>(r4, r6)     // Catch:{ JSONException -> 0x00b1, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x00c4:
            if (r2 == 0) goto L_0x00c9
            r8.zzr(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x00c9:
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 == 0) goto L_0x0173
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r0 == 0) goto L_0x0173
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r1.<init>()     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r11 = 0
        L_0x00db:
            int r2 = r0.length()     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r11 >= r2) goto L_0x0170
            java.lang.String r2 = r0.getString(r11)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r4.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r2 = "factorIdKey"
            java.lang.String r2 = r4.optString(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r5 = "phone"
            boolean r5 = r5.equals(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r6 = "uid"
            java.lang.String r7 = "enrollmentTimestamp"
            if (r5 == 0) goto L_0x0123
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneMultiFactorInfo> r2 = com.google.firebase.auth.PhoneMultiFactorInfo.CREATOR     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 == 0) goto L_0x011b
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r20 = r4.optString(r13)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            com.google.firebase.auth.PhoneMultiFactorInfo r2 = new com.google.firebase.auth.PhoneMultiFactorInfo     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            goto L_0x0159
        L_0x011b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            throw r0     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0123:
            java.lang.String r5 = "totp"
            if (r2 == r5) goto L_0x0132
            if (r2 == 0) goto L_0x0130
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 == 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r2 = r3
            goto L_0x0159
        L_0x0132:
            android.os.Parcelable$Creator<com.google.firebase.auth.TotpMultiFactorInfo> r2 = com.google.firebase.auth.TotpMultiFactorInfo.CREATOR     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 == 0) goto L_0x0168
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r2 = "totpInfo"
            java.lang.Object r2 = r4.opt(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            if (r2 == 0) goto L_0x0160
            com.google.android.gms.internal.firebase-auth-api.zzaeq r20 = new com.google.android.gms.internal.firebase-auth-api.zzaeq     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r20.<init>()     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            com.google.firebase.auth.TotpMultiFactorInfo r2 = new com.google.firebase.auth.TotpMultiFactorInfo     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0159:
            r1.add(r2)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            int r11 = r11 + 1
            goto L_0x00db
        L_0x0160:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r1 = "A totpInfo is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            throw r0     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0168:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
            throw r0     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0170:
            r8.zzi(r1)     // Catch:{ JSONException -> 0x017a, ArrayIndexOutOfBoundsException -> 0x0178, IllegalArgumentException -> 0x0176, zzwh -> 0x0174 }
        L_0x0173:
            return r8
        L_0x0174:
            r0 = move-exception
            goto L_0x017b
        L_0x0176:
            r0 = move-exception
            goto L_0x017b
        L_0x0178:
            r0 = move-exception
            goto L_0x017b
        L_0x017a:
            r0 = move-exception
        L_0x017b:
            r1 = r26
            com.google.android.gms.common.logging.Logger r2 = r1.zzd
            r2.wtf(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbt.zzf(org.json.JSONObject):com.google.firebase.auth.internal.zzx");
    }

    @Nullable
    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zzf(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Nullable
    public final zzadr zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), (String) null);
        if (string != null) {
            return zzadr.zzd(string);
        }
        return null;
    }

    public final void zzc(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        String str;
        Preconditions.checkNotNull(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzx = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", (Object) zzx.zzf());
                jSONObject.put("applicationName", (Object) zzx.zza().getName());
                jSONObject.put("type", (Object) "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzx.zzo() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List zzo = zzx.zzo();
                    int size = zzo.size();
                    if (zzo.size() > 30) {
                        this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzo.size()));
                        size = 30;
                    }
                    for (int i11 = 0; i11 < size; i11++) {
                        jSONArray.put((Object) ((zzt) zzo.get(i11)).zzb());
                    }
                    jSONObject.put("userInfos", (Object) jSONArray);
                }
                jSONObject.put("anonymous", zzx.isAnonymous());
                jSONObject.put("version", (Object) ExifInterface.GPS_MEASUREMENT_2D);
                if (zzx.getMetadata() != null) {
                    jSONObject.put("userMetadata", (Object) ((zzz) zzx.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzx).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i12 = 0; i12 < enrolledFactors.size(); i12++) {
                        jSONArray2.put((Object) enrolledFactors.get(i12).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", (Object) jSONArray2);
                }
                str = JSONObjectInstrumentation.toString(jSONObject);
            } catch (Exception e11) {
                this.zzd.wtf("Failed to turn object into JSON", e11, new Object[0]);
                throw new zzwh(e11);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
        }
    }

    public final void zze(FirebaseUser firebaseUser, zzadr zzadr) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzadr);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzadr.zzh()).apply();
    }
}
