package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzr;

public final class GroundOverlay {
    private final zzr zza;

    public GroundOverlay(zzr zzr) {
        this.zza = (zzr) Preconditions.checkNotNull(zzr);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.zza.zzz(((GroundOverlay) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getBearing() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public LatLngBounds getBounds() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getHeight() {
        try {
            return this.zza.zze();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public LatLng getPosition() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzj());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getTransparency() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getWidth() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzA();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzB();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void remove() {
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setBearing(float f11) {
        try {
            this.zza.zzo(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setClickable(boolean z11) {
        try {
            this.zza.zzp(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setDimensions(float f11) {
        try {
            this.zza.zzq(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setImage(@NonNull BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.zza.zzs(bitmapDescriptor.zza());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng) {
        try {
            this.zza.zzt(latLng);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPositionFromBounds(@NonNull LatLngBounds latLngBounds) {
        try {
            this.zza.zzu(latLngBounds);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTag(@Nullable Object obj) {
        try {
            this.zza.zzv(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTransparency(float f11) {
        try {
            this.zza.zzw(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.zza.zzx(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.zza.zzy(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setDimensions(float f11, float f12) {
        try {
            this.zza.zzr(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
