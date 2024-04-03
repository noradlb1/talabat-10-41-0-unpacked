package com.google.android.gms.internal.icing;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.search.SearchAuth;

final class zzay extends BaseImplementation.ApiMethodImpl<Status, zzav> {
    private final String zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public final boolean zzc = Log.isLoggable("SearchAuth", 3);

    public zzay(GoogleApiClient googleApiClient, String str) {
        super((Api<?>) SearchAuth.API, googleApiClient);
        this.zzb = str;
        this.zza = googleApiClient.getContext().getPackageName();
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        if (this.zzc) {
            String valueOf = String.valueOf(status.getStatusMessage());
            if (valueOf.length() != 0) {
                "ClearTokenImpl received failure: ".concat(valueOf);
            }
        }
        return status;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzau) ((zzav) anyClient).getService()).zze(new zzax(this), this.zza, this.zzb);
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
