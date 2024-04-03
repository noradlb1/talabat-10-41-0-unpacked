package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zzep extends BaseGmsClient {
    public zzep(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 93, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof zzej) {
            return (zzej) queryLocalInterface;
        }
        return new zzeh(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
