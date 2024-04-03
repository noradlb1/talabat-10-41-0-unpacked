package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

public interface zzg extends IInterface {
    Barcode[] zza(IObjectWrapper iObjectWrapper, zzp zzp) throws RemoteException;

    Barcode[] zzb(IObjectWrapper iObjectWrapper, zzp zzp) throws RemoteException;

    void zzm() throws RemoteException;
}
