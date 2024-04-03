package com.adyen.checkout.core.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentSessionResponse extends JsonObject {
    @NonNull
    private static final JsonObject.Creator<PaymentSessionResponse> CREATOR = new JsonObject.DefaultCreator(PaymentSessionResponse.class);
    private final String mPaymentSession;

    private PaymentSessionResponse(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mPaymentSession = jSONObject.getString("paymentSession");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentSessionResponse.class != obj.getClass()) {
            return false;
        }
        String str = this.mPaymentSession;
        String str2 = ((PaymentSessionResponse) obj).mPaymentSession;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getPaymentSession() {
        return this.mPaymentSession;
    }

    public int hashCode() {
        String str = this.mPaymentSession;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
