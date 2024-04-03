package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate zza;

    private CameraUpdateFactory() {
    }

    @NonNull
    public static CameraUpdate newCameraPosition(@NonNull CameraPosition cameraPosition) {
        Preconditions.checkNotNull(cameraPosition, "cameraPosition must not be null");
        try {
            return new CameraUpdate(zzb().newCameraPosition(cameraPosition));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate newLatLng(@NonNull LatLng latLng) {
        Preconditions.checkNotNull(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(zzb().newLatLng(latLng));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate newLatLngBounds(@NonNull LatLngBounds latLngBounds, int i11) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngBounds(latLngBounds, i11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate newLatLngZoom(@NonNull LatLng latLng, float f11) {
        Preconditions.checkNotNull(latLng, "latLng must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngZoom(latLng, f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate scrollBy(float f11, float f12) {
        try {
            return new CameraUpdate(zzb().scrollBy(f11, f12));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate zoomBy(float f11) {
        try {
            return new CameraUpdate(zzb().zoomBy(f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(zzb().zoomIn());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(zzb().zoomOut());
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate zoomTo(float f11) {
        try {
            return new CameraUpdate(zzb().zoomTo(f11));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public static void zza(@NonNull ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        zza = (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate zzb() {
        return (ICameraUpdateFactoryDelegate) Preconditions.checkNotNull(zza, "CameraUpdateFactory is not initialized");
    }

    @NonNull
    public static CameraUpdate zoomBy(float f11, @NonNull Point point) {
        Preconditions.checkNotNull(point, "focus must not be null");
        try {
            return new CameraUpdate(zzb().zoomByWithFocus(f11, point.x, point.y));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public static CameraUpdate newLatLngBounds(@NonNull LatLngBounds latLngBounds, int i11, int i12, int i13) {
        Preconditions.checkNotNull(latLngBounds, "bounds must not be null");
        try {
            return new CameraUpdate(zzb().newLatLngBoundsWithSize(latLngBounds, i11, i12, i13));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
