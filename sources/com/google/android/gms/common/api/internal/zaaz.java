package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zaaz implements GoogleApiClient.ConnectionCallbacks {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ StatusPendingResult zab;
    final /* synthetic */ zabe zac;

    public zaaz(zabe zabe, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zac = zabe;
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zac.zam((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.zaa.get()), this.zab, true);
    }

    public final void onConnectionSuspended(int i11) {
    }
}
