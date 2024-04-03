package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzad;

public class Marker {
    protected final zzad zza;

    public Marker(zzad zzad) {
        this.zza = (zzad) Preconditions.checkNotNull(zzad);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.zza.zzE(((Marker) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getAlpha() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public LatLng getPosition() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getRotation() {
        try {
            return this.zza.zze();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public String getSnippet() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzi());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public String getTitle() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void hideInfoWindow() {
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isDraggable() {
        try {
            return this.zza.zzF();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isFlat() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            return this.zza.zzH();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzI();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void remove() {
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setAlpha(float f11) {
        try {
            this.zza.zzp(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setAnchor(float f11, float f12) {
        try {
            this.zza.zzq(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setDraggable(boolean z11) {
        try {
            this.zza.zzr(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setFlat(boolean z11) {
        try {
            this.zza.zzs(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setIcon(@Nullable BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            try {
                this.zza.zzt((IObjectWrapper) null);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.zza.zzt(bitmapDescriptor.zza());
        }
    }

    public void setInfoWindowAnchor(float f11, float f12) {
        try {
            this.zza.zzv(f11, f12);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng) {
        if (latLng != null) {
            try {
                this.zza.zzw(latLng);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
    }

    public void setRotation(float f11) {
        try {
            this.zza.zzx(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setSnippet(@Nullable String str) {
        try {
            this.zza.zzy(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTag(@Nullable Object obj) {
        try {
            this.zza.zzz(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTitle(@Nullable String str) {
        try {
            this.zza.zzA(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.zza.zzB(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.zza.zzC(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void showInfoWindow() {
        try {
            this.zza.zzD();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
