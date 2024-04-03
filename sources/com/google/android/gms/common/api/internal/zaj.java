package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zaj implements GoogleApiClient.OnConnectionFailedListener {
    public final int zaa;
    public final GoogleApiClient zab;
    @Nullable
    public final GoogleApiClient.OnConnectionFailedListener zac;
    final /* synthetic */ zak zad;

    public zaj(zak zak, int i11, @Nullable GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zad = zak;
        this.zaa = i11;
        this.zab = googleApiClient;
        this.zac = onConnectionFailedListener;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        "beginFailureResolution for ".concat(String.valueOf(connectionResult));
        this.zad.zah(connectionResult, this.zaa);
    }
}
