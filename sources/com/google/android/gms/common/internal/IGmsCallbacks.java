package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i11, @NonNull IBinder iBinder, @NonNull Bundle bundle) throws RemoteException;

    void zzb(int i11, @NonNull Bundle bundle) throws RemoteException;

    void zzc(int i11, IBinder iBinder, zzk zzk) throws RemoteException;
}
