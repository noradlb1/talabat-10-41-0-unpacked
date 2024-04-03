package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzag;
import java.util.List;

public final class Polygon {
    private final zzag zza;

    public Polygon(zzag zzag) {
        this.zza = (zzag) Preconditions.checkNotNull(zzag);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.zza.zzB(((Polygon) obj).zza);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int getFillColor() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public List<List<LatLng>> getHoles() {
        try {
            return this.zza.zzl();
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
    public List<LatLng> getPoints() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int getStrokeColor() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public int getStrokeJointType() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zza.zzn());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public float getStrokeWidth() {
        try {
            return this.zza.zzd();
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
            return this.zza.zze();
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
            return this.zza.zzC();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isGeodesic() {
        try {
            return this.zza.zzD();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzE();
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

    public void setGeodesic(boolean z11) {
        try {
            this.zza.zzr(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setHoles(@NonNull List<? extends List<LatLng>> list) {
        try {
            this.zza.zzs(list);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPoints(@NonNull List<LatLng> list) {
        try {
            Preconditions.checkNotNull(list, "points must not be null.");
            this.zza.zzt(list);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokeColor(int i11) {
        try {
            this.zza.zzu(i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokeJointType(int i11) {
        try {
            this.zza.zzv(i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokePattern(@Nullable List<PatternItem> list) {
        try {
            this.zza.zzw(list);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStrokeWidth(float f11) {
        try {
            this.zza.zzx(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setTag(@Nullable Object obj) {
        try {
            this.zza.zzy(ObjectWrapper.wrap(obj));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setVisible(boolean z11) {
        try {
            this.zza.zzz(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZIndex(float f11) {
        try {
            this.zza.zzA(f11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
