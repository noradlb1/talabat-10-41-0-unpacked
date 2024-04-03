package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.GooglePayConfiguration;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

public final class GooglePayConfigurationImpl extends JsonObject implements GooglePayConfiguration {
    @NonNull
    public static final Parcelable.Creator<GooglePayConfigurationImpl> CREATOR = new JsonObject.DefaultCreator(GooglePayConfigurationImpl.class);
    private final int mEnvironment;
    private final String mGateway;
    private final String mGatewayMerchantId;

    private GooglePayConfigurationImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mEnvironment = jSONObject.getInt(Profile.ENVIRONMENT);
        this.mGateway = jSONObject.getString("gateway");
        this.mGatewayMerchantId = jSONObject.getString("gatewayMerchantId");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GooglePayConfigurationImpl.class != obj.getClass()) {
            return false;
        }
        GooglePayConfigurationImpl googlePayConfigurationImpl = (GooglePayConfigurationImpl) obj;
        if (this.mEnvironment != googlePayConfigurationImpl.mEnvironment) {
            return false;
        }
        String str = this.mGateway;
        if (str == null ? googlePayConfigurationImpl.mGateway != null : !str.equals(googlePayConfigurationImpl.mGateway)) {
            return false;
        }
        String str2 = this.mGatewayMerchantId;
        String str3 = googlePayConfigurationImpl.mGatewayMerchantId;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int getEnvironment() {
        return this.mEnvironment;
    }

    @NonNull
    public String getGateway() {
        return this.mGateway;
    }

    @NonNull
    public String getGatewayMerchantId() {
        return this.mGatewayMerchantId;
    }

    public int hashCode() {
        int i11;
        int i12 = this.mEnvironment * 31;
        String str = this.mGateway;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i12 + i11) * 31;
        String str2 = this.mGatewayMerchantId;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        return i14 + i13;
    }
}
