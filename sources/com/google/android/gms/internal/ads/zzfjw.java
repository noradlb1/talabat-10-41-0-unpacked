package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzfjw extends IInterface {
    @Nullable
    IObjectWrapper zze(String str, IObjectWrapper iObjectWrapper, String str2, String str3, @Nullable String str4, String str5, String str6, String str7, @Nullable String str8) throws RemoteException;

    @Nullable
    IObjectWrapper zzf(String str, IObjectWrapper iObjectWrapper, String str2, String str3, @Nullable String str4, String str5, String str6, String str7, @Nullable String str8) throws RemoteException;

    @Nullable
    String zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzl(IObjectWrapper iObjectWrapper) throws RemoteException;
}
