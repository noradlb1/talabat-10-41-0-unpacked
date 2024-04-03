package com.adyen.checkout.core.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentMethodDeletionResponse extends JsonObject {
    @NonNull
    public static final JsonObject.Creator<PaymentMethodDeletionResponse> CREATOR = new JsonObject.DefaultCreator(PaymentMethodDeletionResponse.class);
    private static final String KEY_RESULT_CODE = "resultCode";
    private final ResultCode mResultCode = ((ResultCode) d("resultCode", ResultCode.class));

    public enum ResultCode {
        SUCCESS,
        ERROR
    }

    public PaymentMethodDeletionResponse(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentMethodDeletionResponse.class != obj.getClass()) {
            return false;
        }
        if (this.mResultCode == ((PaymentMethodDeletionResponse) obj).mResultCode) {
            return true;
        }
        return false;
    }

    @NonNull
    public ResultCode getResultCode() {
        return this.mResultCode;
    }

    public int hashCode() {
        ResultCode resultCode = this.mResultCode;
        if (resultCode != null) {
            return resultCode.hashCode();
        }
        return 0;
    }
}
