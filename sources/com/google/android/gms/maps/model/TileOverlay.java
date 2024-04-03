package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzam;

public final class TileOverlay {
    private final zzam zza;

    public TileOverlay(zzam zzam) {
        this.zza = (zzam) Preconditions.checkNotNull(zzam);
    }

    public void clearTileCache() {
        try {
            this.zza.zzh();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.zza.zzn(((TileOverlay) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getTransparency() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void remove() {
        try {
            this.zza.zzi();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setFadeIn(boolean z11) {
        try {
            this.zza.zzj(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTransparency(float f11) {
        try {
            this.zza.zzk(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.zza.zzl(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.zza.zzm(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
