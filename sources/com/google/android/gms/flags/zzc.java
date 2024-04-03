package com.google.android.gms.flags;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzc extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z11, int i11) throws RemoteException;

    int getIntFlagValue(String str, int i11, int i12) throws RemoteException;

    long getLongFlagValue(String str, long j11, int i11) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i11) throws RemoteException;

    void init(IObjectWrapper iObjectWrapper) throws RemoteException;
}
