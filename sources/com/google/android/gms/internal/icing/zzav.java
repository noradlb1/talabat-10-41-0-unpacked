package com.google.android.gms.internal.icing;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzav extends GmsClient<zzau> {
    public zzav(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, context.getMainLooper(), 73, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
        if (queryLocalInterface instanceof zzau) {
            return (zzau) queryLocalInterface;
        }
        return new zzau(iBinder);
    }

    public final int getMinApkVersion() {
        return 12600000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }
}
