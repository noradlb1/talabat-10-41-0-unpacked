package com.google.android.gms.internal.icing;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzae extends GmsClient<zzaa> {
    public zzae(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (queryLocalInterface instanceof zzaa) {
            return (zzaa) queryLocalInterface;
        }
        return new zzaa(iBinder);
    }

    public final int getMinApkVersion() {
        return 12600000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
