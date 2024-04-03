package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;

public abstract class zzc<T extends IInterface> extends BaseGmsClient<T> {
    public zzc(Context context, Looper looper, int i11, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        super(context, looper, i11, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }
}
