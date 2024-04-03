package com.adyen.checkout.core.card.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class PublicKeyResponse extends JsonObject {
    @NonNull
    public static final JsonObject.Creator<PublicKeyResponse> CREATOR = new JsonObject.DefaultCreator(PublicKeyResponse.class);
    private final String mId;
    private final String mPublicKey;
    private final String mStatus;

    private PublicKeyResponse(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mStatus = jSONObject.getString("status");
        this.mId = jSONObject.optString("id");
        this.mPublicKey = jSONObject.optString("publicKey");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PublicKeyResponse.class != obj.getClass()) {
            return false;
        }
        PublicKeyResponse publicKeyResponse = (PublicKeyResponse) obj;
        String str = this.mStatus;
        if (str == null ? publicKeyResponse.mStatus != null : !str.equals(publicKeyResponse.mStatus)) {
            return false;
        }
        String str2 = this.mId;
        if (str2 == null ? publicKeyResponse.mId != null : !str2.equals(publicKeyResponse.mId)) {
            return false;
        }
        String str3 = this.mPublicKey;
        String str4 = publicKeyResponse.mPublicKey;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getId() {
        return this.mId;
    }

    @Nullable
    public String getPublicKey() {
        return this.mPublicKey;
    }

    @NonNull
    public String getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        int i11;
        int i12;
        String str = this.mStatus;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        String str2 = this.mId;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.mPublicKey;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return i15 + i13;
    }
}
