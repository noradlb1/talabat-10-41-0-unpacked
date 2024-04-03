package com.adyen.checkout.core.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class GiroPayIssuersResponse extends JsonObject {
    @NonNull
    public static final JsonObject.Creator<GiroPayIssuersResponse> CREATOR = new JsonObject.DefaultCreator(GiroPayIssuersResponse.class);
    private final List<GiroPayIssuerImpl> mGiroPayIssuers = e("giroPayIssuers", GiroPayIssuerImpl.class);

    private GiroPayIssuersResponse(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GiroPayIssuersResponse.class != obj.getClass()) {
            return false;
        }
        List<GiroPayIssuerImpl> list = this.mGiroPayIssuers;
        List<GiroPayIssuerImpl> list2 = ((GiroPayIssuersResponse) obj).mGiroPayIssuers;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<GiroPayIssuerImpl> getGiroPayIssuers() {
        return new ArrayList(this.mGiroPayIssuers);
    }

    public int hashCode() {
        List<GiroPayIssuerImpl> list = this.mGiroPayIssuers;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}
