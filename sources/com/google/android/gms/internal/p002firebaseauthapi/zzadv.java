package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.visa.checkout.Profile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadv  reason: invalid package */
public final class zzadv {
    @Nullable
    private final String zza;
    @NonNull
    private final String zzb;
    private final String zzc;
    private final long zzd;
    @Nullable
    private final zzaeq zze;
    @Nullable
    private String zzf;

    public zzadv(String str, String str2, String str3, long j11, zzaeq zzaeq) {
        if (TextUtils.isEmpty(str) || zzaeq == null) {
            this.zza = str;
            this.zzb = Preconditions.checkNotEmpty(str2);
            this.zzc = str3;
            this.zzd = j11;
            this.zze = zzaeq;
            return;
        }
        Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
        throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
    }

    public static zzadv zzb(@NonNull JSONObject jSONObject) {
        zzaeq zzaeq;
        String optString = jSONObject.optString("phoneInfo", (String) null);
        String optString2 = jSONObject.optString("mfaEnrollmentId", (String) null);
        String optString3 = jSONObject.optString(Profile.DISPLAY_NAME, (String) null);
        long zzh = zzh(jSONObject.optString("enrolledAt", ""));
        if (jSONObject.opt("totpInfo") != null) {
            zzaeq = new zzaeq();
        } else {
            zzaeq = null;
        }
        zzadv zzadv = new zzadv(optString, optString2, optString3, zzh, zzaeq);
        zzadv.zzf = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzadv;
    }

    public static List zzg(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(zzb(jSONArray.getJSONObject(i11)));
        }
        return arrayList;
    }

    private static long zzh(String str) {
        try {
            zzajj zzb2 = zzake.zzb(str);
            zzake.zza(zzb2);
            return zzb2.zzb();
        } catch (ParseException e11) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e11);
            return 0;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    @Nullable
    public final zzaeq zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzb;
    }

    @Nullable
    public final String zzf() {
        return this.zza;
    }
}
