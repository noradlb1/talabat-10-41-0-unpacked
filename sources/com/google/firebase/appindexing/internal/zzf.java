package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzf extends GmsClient<zzv> {
    static final Api<Api.ApiOptions.NoOptions> zze;
    private static final Api.ClientKey<zzf> zzf;
    private static final Api.AbstractClientBuilder<zzf, Api.ApiOptions.NoOptions> zzg;

    static {
        Api.ClientKey<zzf> clientKey = new Api.ClientKey<>();
        zzf = clientKey;
        zze zze2 = new zze();
        zzg = zze2;
        zze = new Api<>("AppIndexing.API", zze2, clientKey);
    }

    public zzf(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 113, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        if (queryLocalInterface instanceof zzv) {
            return (zzv) queryLocalInterface;
        }
        return new zzv(iBinder);
    }

    public final int getMinApkVersion() {
        return 12600000;
    }

    public final String getServiceDescriptor() {
        return "com.google.firebase.appindexing.internal.IAppIndexingService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.icing.APP_INDEXING_SERVICE";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
