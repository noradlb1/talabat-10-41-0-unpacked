package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;
    @Nullable
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, (Feature[]) null, false, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z11, int i11) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z11;
        this.zad = i11;
    }

    @KeepForSdk
    public void clearListener() {
        this.zaa.clear();
    }

    @KeepForSdk
    @Nullable
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    @KeepForSdk
    @Nullable
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    @KeepForSdk
    public abstract void registerListener(@NonNull A a11, @NonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @NonNull Feature[] featureArr, boolean z11) {
        this(listenerHolder, featureArr, z11, 0);
    }
}
