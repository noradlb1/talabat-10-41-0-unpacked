package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.RedirectData;
import org.json.JSONException;
import org.json.JSONObject;

@ProvidedBy(ThreeDSecureRedirectData.class)
public final class ThreeDSecureRedirectData extends JsonObject implements RedirectData {
    @NonNull
    public static final Parcelable.Creator<ThreeDSecureRedirectData> CREATOR = new JsonObject.DefaultCreator(ThreeDSecureRedirectData.class);
    private final String mMd;

    private ThreeDSecureRedirectData(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mMd = jSONObject.getString("MD");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ThreeDSecureRedirectData.class != obj.getClass()) {
            return false;
        }
        String str = this.mMd;
        String str2 = ((ThreeDSecureRedirectData) obj).mMd;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getMd() {
        return this.mMd;
    }

    public int hashCode() {
        String str = this.mMd;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
