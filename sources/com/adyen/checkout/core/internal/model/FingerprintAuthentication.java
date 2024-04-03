package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Authentication;

@ProvidedBy(FingerprintAuthentication.class)
public final class FingerprintAuthentication extends JsonObject implements Authentication {
    public static final Parcelable.Creator<FingerprintAuthentication> CREATOR = new JsonObject.DefaultCreator(FingerprintAuthentication.class);
    private static final String KEY_THREE_DS_FINGERPRINT_TOKEN = "threeds2.fingerprintToken";
    private final String mFingerprintToken;

    @NonNull
    public String getFingerprintToken() {
        return this.mFingerprintToken;
    }
}
