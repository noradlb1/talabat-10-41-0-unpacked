package com.adyen.checkout.core.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentMethodBase extends JsonObject {
    @NonNull
    public static final JsonObject.Creator<PaymentMethodBase> CREATOR = new JsonObject.DefaultCreator(PaymentMethodBase.class);
    private final String mType;

    public PaymentMethodBase(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mType = jSONObject.getString("type");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.mType;
        String str2 = ((PaymentMethodBase) obj).mType;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getType() {
        return this.mType;
    }

    public int hashCode() {
        String str = this.mType;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
