package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(@NonNull T t11, @NonNull U u11) throws RemoteException;
}
