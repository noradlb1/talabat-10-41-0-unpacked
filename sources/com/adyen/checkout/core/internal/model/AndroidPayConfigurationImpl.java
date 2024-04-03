package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.AndroidPayConfiguration;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class AndroidPayConfigurationImpl extends JsonObject implements AndroidPayConfiguration {
    @NonNull
    public static final Parcelable.Creator<AndroidPayConfigurationImpl> CREATOR = new JsonObject.DefaultCreator(AndroidPayConfigurationImpl.class);
    private final int mEnvironment;
    private final String mMerchantName;
    private final String mPublicKey;

    private AndroidPayConfigurationImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mEnvironment = jSONObject.getInt(Profile.ENVIRONMENT);
        this.mMerchantName = jSONObject.getString(TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_MERCHANT_NAME);
        this.mPublicKey = jSONObject.getString("publicKey");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AndroidPayConfigurationImpl.class != obj.getClass()) {
            return false;
        }
        AndroidPayConfigurationImpl androidPayConfigurationImpl = (AndroidPayConfigurationImpl) obj;
        if (this.mEnvironment != androidPayConfigurationImpl.mEnvironment) {
            return false;
        }
        String str = this.mMerchantName;
        if (str == null ? androidPayConfigurationImpl.mMerchantName != null : !str.equals(androidPayConfigurationImpl.mMerchantName)) {
            return false;
        }
        String str2 = this.mPublicKey;
        String str3 = androidPayConfigurationImpl.mPublicKey;
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
    public String getMerchantName() {
        return this.mMerchantName;
    }

    @NonNull
    public String getPublicKey() {
        return this.mPublicKey;
    }

    public int hashCode() {
        int i11;
        int i12 = this.mEnvironment * 31;
        String str = this.mMerchantName;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i12 + i11) * 31;
        String str2 = this.mPublicKey;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        return i14 + i13;
    }
}
