package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbtl implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcjr zza;

    public zzbtl(zzbtm zzbtm, zzcjr zzcjr) {
        this.zza = zzcjr;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zza.zze(new RuntimeException("Connection failed."));
    }
}
