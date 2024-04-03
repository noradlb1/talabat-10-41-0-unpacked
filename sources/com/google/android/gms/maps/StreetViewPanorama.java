package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbl;
import com.google.android.gms.maps.internal.zzbn;
import com.google.android.gms.maps.internal.zzbp;
import com.google.android.gms.maps.internal.zzbr;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import net.bytebuddy.implementation.MethodDelegation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zza;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(@NonNull StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public StreetViewPanorama(@NonNull IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.zza = (IStreetViewPanoramaDelegate) Preconditions.checkNotNull(iStreetViewPanoramaDelegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }

    public void animateTo(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera, long j11) {
        Preconditions.checkNotNull(streetViewPanoramaCamera);
        try {
            this.zza.animateTo(streetViewPanoramaCamera, j11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zza.getStreetViewPanoramaLocation();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zza.getPanoramaCamera();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zza.isPanningGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zza.isStreetNamesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zza.isUserNavigationEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zza.isZoomGesturesEnabled();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @Nullable
    public Point orientationToPoint(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            IObjectWrapper orientationToPoint = this.zza.orientationToPoint(streetViewPanoramaOrientation);
            if (orientationToPoint == null) {
                return null;
            }
            return (Point) ObjectWrapper.unwrap(orientationToPoint);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    @NonNull
    public StreetViewPanoramaOrientation pointToOrientation(@NonNull Point point) {
        try {
            return this.zza.pointToOrientation(ObjectWrapper.wrap(point));
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(@Nullable OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        if (onStreetViewPanoramaCameraChangeListener == null) {
            try {
                this.zza.setOnStreetViewPanoramaCameraChangeListener((zzbl) null);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.zza.setOnStreetViewPanoramaCameraChangeListener(new zzak(this, onStreetViewPanoramaCameraChangeListener));
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(@Nullable OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        if (onStreetViewPanoramaChangeListener == null) {
            try {
                this.zza.setOnStreetViewPanoramaChangeListener((zzbn) null);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.zza.setOnStreetViewPanoramaChangeListener(new zzaj(this, onStreetViewPanoramaChangeListener));
        }
    }

    public final void setOnStreetViewPanoramaClickListener(@Nullable OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        if (onStreetViewPanoramaClickListener == null) {
            try {
                this.zza.setOnStreetViewPanoramaClickListener((zzbp) null);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.zza.setOnStreetViewPanoramaClickListener(new zzal(this, onStreetViewPanoramaClickListener));
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(@Nullable OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        if (onStreetViewPanoramaLongClickListener == null) {
            try {
                this.zza.setOnStreetViewPanoramaLongClickListener((zzbr) null);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        } else {
            this.zza.setOnStreetViewPanoramaLongClickListener(new zzam(this, onStreetViewPanoramaLongClickListener));
        }
    }

    public void setPanningGesturesEnabled(boolean z11) {
        try {
            this.zza.enablePanning(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng) {
        try {
            this.zza.setPosition(latLng);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setStreetNamesEnabled(boolean z11) {
        try {
            this.zza.enableStreetNames(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setUserNavigationEnabled(boolean z11) {
        try {
            this.zza.enableUserNavigation(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setZoomGesturesEnabled(boolean z11) {
        try {
            this.zza.enableZoom(z11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng, int i11) {
        try {
            this.zza.setPositionWithRadius(latLng, i11);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng, int i11, @Nullable StreetViewSource streetViewSource) {
        try {
            this.zza.setPositionWithRadiusAndSource(latLng, i11, streetViewSource);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull LatLng latLng, @Nullable StreetViewSource streetViewSource) {
        try {
            this.zza.setPositionWithSource(latLng, streetViewSource);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }

    public void setPosition(@NonNull String str) {
        try {
            this.zza.setPositionWithID(str);
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
