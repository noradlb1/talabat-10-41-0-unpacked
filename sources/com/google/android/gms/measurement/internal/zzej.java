package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

public interface zzej extends IInterface {
    @Nullable
    String zzd(zzq zzq) throws RemoteException;

    @Nullable
    List zze(zzq zzq, boolean z11) throws RemoteException;

    List zzf(@Nullable String str, @Nullable String str2, zzq zzq) throws RemoteException;

    List zzg(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    List zzh(@Nullable String str, @Nullable String str2, boolean z11, zzq zzq) throws RemoteException;

    List zzi(String str, @Nullable String str2, @Nullable String str3, boolean z11) throws RemoteException;

    void zzj(zzq zzq) throws RemoteException;

    void zzk(zzau zzau, zzq zzq) throws RemoteException;

    void zzl(zzau zzau, String str, @Nullable String str2) throws RemoteException;

    void zzm(zzq zzq) throws RemoteException;

    void zzn(zzac zzac, zzq zzq) throws RemoteException;

    void zzo(zzac zzac) throws RemoteException;

    void zzp(zzq zzq) throws RemoteException;

    void zzq(long j11, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    void zzr(Bundle bundle, zzq zzq) throws RemoteException;

    void zzs(zzq zzq) throws RemoteException;

    void zzt(zzlk zzlk, zzq zzq) throws RemoteException;

    @Nullable
    byte[] zzu(zzau zzau, String str) throws RemoteException;
}
