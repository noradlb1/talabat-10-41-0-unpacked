package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadx  reason: invalid package */
public final class zzadx {
    private final List zza;

    public zzadx() {
        this.zza = new ArrayList();
    }

    public static zzadx zza(JSONArray jSONArray) throws JSONException {
        zzadw zzadw;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzadx(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            if (jSONObject == null) {
                zzadw = new zzadw();
            } else {
                zzadw = new zzadw(Strings.emptyToNull(jSONObject.optString("federatedId", (String) null)), Strings.emptyToNull(jSONObject.optString(Profile.DISPLAY_NAME, (String) null)), Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null)), Strings.emptyToNull(jSONObject.optString("providerId", (String) null)), (String) null, Strings.emptyToNull(jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (String) null)), Strings.emptyToNull(jSONObject.optString("email", (String) null)));
            }
            arrayList.add(zzadw);
        }
        return new zzadx(arrayList);
    }

    public static zzadx zzb(zzadx zzadx) {
        List list = zzadx.zza;
        zzadx zzadx2 = new zzadx();
        if (list != null) {
            zzadx2.zza.addAll(list);
        }
        return zzadx2;
    }

    public final List zzc() {
        return this.zza;
    }

    public zzadx(List list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
