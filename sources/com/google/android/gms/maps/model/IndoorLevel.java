package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzx;

public final class IndoorLevel {
    private final zzx zza;

    public IndoorLevel(zzx zzx) {
        this.zza = (zzx) Preconditions.checkNotNull(zzx);
    }

    public void activate() {
        try {
            this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorLevel) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getName() {
        try {
            return this.zza.zze();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getShortName() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
