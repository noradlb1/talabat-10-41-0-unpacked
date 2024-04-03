package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.KlarnaConfiguration;

public class KlarnaConfigurationImpl extends JsonObject implements KlarnaConfiguration {
    @NonNull
    public static final Parcelable.Creator<KlarnaConfigurationImpl> CREATOR = new JsonObject.DefaultCreator(KlarnaConfigurationImpl.class);
    private static final String KEY_SSN_LOOKUP_UR = "shopperInfoSSNLookupUrl";
    private String mShopperInfoSsnLookupUrl;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KlarnaConfigurationImpl klarnaConfigurationImpl = (KlarnaConfigurationImpl) obj;
        String str = this.mShopperInfoSsnLookupUrl;
        if (str != null) {
            return str.equals(klarnaConfigurationImpl.mShopperInfoSsnLookupUrl);
        }
        if (klarnaConfigurationImpl.mShopperInfoSsnLookupUrl == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getShopperInfoSsnLookupUrl() {
        return this.mShopperInfoSsnLookupUrl;
    }

    public int hashCode() {
        String str = this.mShopperInfoSsnLookupUrl;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
