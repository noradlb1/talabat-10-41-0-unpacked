package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
final class zzaf extends DeferredLifecycleHelper {
    protected OnDelegateCreatedListener zza;
    private final Fragment zzb;
    private Activity zzc;
    private final List zzd = new ArrayList();

    @VisibleForTesting
    public zzaf(Fragment fragment) {
        this.zzb = fragment;
    }

    public static /* synthetic */ void zza(zzaf zzaf, Activity activity) {
        zzaf.zzc = activity;
        zzaf.zzc();
    }

    public final void createDelegate(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zzc();
    }

    public final void zzb(OnMapReadyCallback onMapReadyCallback) {
        if (getDelegate() != null) {
            ((zzae) getDelegate()).getMapAsync(onMapReadyCallback);
        } else {
            this.zzd.add(onMapReadyCallback);
        }
    }

    public final void zzc() {
        if (this.zzc != null && this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                IMapFragmentDelegate zzf = zzcc.zza(this.zzc, (MapsInitializer.Renderer) null).zzf(ObjectWrapper.wrap(this.zzc));
                if (zzf != null) {
                    this.zza.onDelegateCreated(new zzae(this.zzb, zzf));
                    for (OnMapReadyCallback mapAsync : this.zzd) {
                        ((zzae) getDelegate()).getMapAsync(mapAsync);
                    }
                    this.zzd.clear();
                }
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }
}
