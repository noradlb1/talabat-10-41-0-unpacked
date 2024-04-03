package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import java.util.List;
import javax.annotation.Nullable;

public interface zzaj extends IInterface {
    void zzA(boolean z11) throws RemoteException;

    void zzB(float f11) throws RemoteException;

    void zzC(float f11) throws RemoteException;

    boolean zzD(@Nullable zzaj zzaj) throws RemoteException;

    boolean zzE() throws RemoteException;

    boolean zzF() throws RemoteException;

    boolean zzG() throws RemoteException;

    float zzd() throws RemoteException;

    float zze() throws RemoteException;

    int zzf() throws RemoteException;

    int zzg() throws RemoteException;

    int zzh() throws RemoteException;

    IObjectWrapper zzi() throws RemoteException;

    Cap zzj() throws RemoteException;

    Cap zzk() throws RemoteException;

    String zzl() throws RemoteException;

    List zzm() throws RemoteException;

    List zzn() throws RemoteException;

    List zzo() throws RemoteException;

    void zzp() throws RemoteException;

    void zzq(boolean z11) throws RemoteException;

    void zzr(int i11) throws RemoteException;

    void zzs(Cap cap) throws RemoteException;

    void zzt(boolean z11) throws RemoteException;

    void zzu(int i11) throws RemoteException;

    void zzv(@Nullable List list) throws RemoteException;

    void zzw(List list) throws RemoteException;

    void zzx(List list) throws RemoteException;

    void zzy(Cap cap) throws RemoteException;

    void zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}
