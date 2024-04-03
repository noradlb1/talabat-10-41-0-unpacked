package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzl;
import java.util.List;

public final class Circle {
    private final zzl zza;

    public Circle(zzl zzl) {
        this.zza = (zzl) Preconditions.checkNotNull(zzl);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.zza.zzy(((Circle) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public LatLng getCenter() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int getFillColor() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public double getRadius() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zza.zzm());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zza.zze();
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

    public float getZIndex() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final int hashCode() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzz();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzA();
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

    public void setCenter(@NonNull LatLng latLng) {
        try {
            Preconditions.checkNotNull(latLng, "center must not be null.");
            this.zza.zzo(latLng);
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

    public void setFillColor(int i11) {
        try {
            this.zza.zzq(i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setRadius(double d11) {
        try {
            this.zza.zzr(d11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokeColor(int i11) {
        try {
            this.zza.zzs(i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokePattern(@Nullable List<PatternItem> list) {
        try {
            this.zza.zzt(list);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokeWidth(float f11) {
        try {
            this.zza.zzu(f11);
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

    public void setVisible(boolean z11) {
        try {
            this.zza.zzw(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.zza.zzx(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
