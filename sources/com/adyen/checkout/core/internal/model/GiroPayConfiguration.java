package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

@ProvidedBy(GiroPayConfiguration.class)
public final class GiroPayConfiguration extends JsonObject implements Configuration {
    @NonNull
    public static final Parcelable.Creator<GiroPayConfiguration> CREATOR = new JsonObject.DefaultCreator(GiroPayConfiguration.class);
    private final String mIssuersUrl;

    private GiroPayConfiguration(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mIssuersUrl = jSONObject.getString("giroPayIssuersUrl");
    }

    @NonNull
    public String getIssuersUrl() {
        return this.mIssuersUrl;
    }
}
