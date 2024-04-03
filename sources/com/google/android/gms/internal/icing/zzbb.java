package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuthApi;

final class zzbb implements SearchAuthApi.GoogleNowAuthResult {
    private final Status zza;
    private final GoogleNowAuthState zzb;

    public zzbb(Status status, GoogleNowAuthState googleNowAuthState) {
        this.zza = status;
        this.zzb = googleNowAuthState;
    }

    public final GoogleNowAuthState getGoogleNowAuthState() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
