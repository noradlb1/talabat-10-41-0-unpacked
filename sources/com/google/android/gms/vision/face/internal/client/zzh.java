package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzp;

public interface zzh extends IInterface {
    FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzp zzp) throws RemoteException;

    boolean zzd(int i11) throws RemoteException;

    void zzm() throws RemoteException;
}
