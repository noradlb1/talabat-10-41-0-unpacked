package com.google.android.gms.search;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public interface SearchAuthApi {

    public interface GoogleNowAuthResult extends Result {
        @NonNull
        GoogleNowAuthState getGoogleNowAuthState();
    }

    @NonNull
    PendingResult<Status> clearToken(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    PendingResult<GoogleNowAuthResult> getGoogleNowAuth(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
