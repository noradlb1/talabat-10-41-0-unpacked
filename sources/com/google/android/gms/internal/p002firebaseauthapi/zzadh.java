package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadh  reason: invalid package */
public final class zzadh implements zzaba {
    private static final String zza = "zzadh";
    private zzadj zzb;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        zzadj zzadj;
        int i11;
        zzadi zzadi;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                this.zzb = new zzadj();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z11 = false;
                        int i12 = 0;
                        while (i12 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i12);
                            if (jSONObject2 == null) {
                                zzadi = new zzadi();
                                i11 = i12;
                            } else {
                                i11 = i12;
                                zzadi = new zzadi(Strings.emptyToNull(jSONObject2.optString("localId", (String) null)), Strings.emptyToNull(jSONObject2.optString("email", (String) null)), jSONObject2.optBoolean("emailVerified", z11), Strings.emptyToNull(jSONObject2.optString(Profile.DISPLAY_NAME, (String) null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null)), zzadx.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null)), Strings.emptyToNull(jSONObject2.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (String) null)), jSONObject2.optLong("createdAt", 0), jSONObject2.optLong("lastLoginAt", 0), false, (zze) null, zzadv.zzg(jSONObject2.optJSONArray("mfaInfo")));
                            }
                            arrayList.add(zzadi);
                            i12 = i11 + 1;
                            z11 = false;
                        }
                        zzadj = new zzadj(arrayList);
                        this.zzb = zzadj;
                    }
                }
                zzadj = new zzadj(new ArrayList());
                this.zzb = zzadj;
            }
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str2);
        }
    }

    public final List zzb() {
        return this.zzb.zza();
    }
}
