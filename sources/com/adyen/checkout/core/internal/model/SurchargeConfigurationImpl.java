package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.SurchargeConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

public final class SurchargeConfigurationImpl extends JsonObject implements SurchargeConfiguration {
    @NonNull
    public static final Parcelable.Creator<SurchargeConfigurationImpl> CREATOR = new JsonObject.DefaultCreator(SurchargeConfigurationImpl.class);
    private final String mSurchargeCurrencyCode;
    private final long mSurchargeFinalAmount;
    private final long mSurchargeFixedCost;
    private final long mSurchargeTotalCost;
    private final int mSurchargeVariableCost;

    public SurchargeConfigurationImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        int i11;
        long j11;
        this.mSurchargeCurrencyCode = jSONObject.getString("surchargeCurrencyCode");
        String optString = jSONObject.optString("surchargeVariableCost");
        if (optString == null || "null".equals(optString)) {
            i11 = 0;
        } else {
            i11 = Integer.parseInt(optString);
        }
        this.mSurchargeVariableCost = i11;
        String optString2 = jSONObject.optString("surchargeFixedCost");
        if (optString2 == null || "null".equals(optString2)) {
            j11 = 0;
        } else {
            j11 = Long.parseLong(optString2);
        }
        this.mSurchargeFixedCost = j11;
        this.mSurchargeFinalAmount = jSONObject.getLong("surchargeFinalAmount");
        this.mSurchargeTotalCost = jSONObject.getLong("surchargeTotalCost");
    }

    @NonNull
    public String getSurchargeCurrencyCode() {
        return this.mSurchargeCurrencyCode;
    }

    public long getSurchargeFinalAmount() {
        return this.mSurchargeFinalAmount;
    }

    public long getSurchargeFixedCost() {
        return this.mSurchargeFixedCost;
    }

    public long getSurchargeTotalCost() {
        return this.mSurchargeTotalCost;
    }

    public int getSurchargeVariableCost() {
        return this.mSurchargeVariableCost;
    }
}
