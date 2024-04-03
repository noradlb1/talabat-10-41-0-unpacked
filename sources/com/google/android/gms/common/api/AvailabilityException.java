package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final ArrayMap zaa;

    public AvailabilityException(@NonNull ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        Object obj = this.zaa.get(apiKey);
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(obj != null, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }

    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z11 = true;
        for (ApiKey apiKey : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
            z11 &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        Object obj = this.zaa.get(apiKey);
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(obj != null, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }
}
