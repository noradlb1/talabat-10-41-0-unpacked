package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zah implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ ConnectionCallbacks zaa;

    public zah(ConnectionCallbacks connectionCallbacks) {
        this.zaa = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaa.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i11) {
        this.zaa.onConnectionSuspended(i11);
    }
}
