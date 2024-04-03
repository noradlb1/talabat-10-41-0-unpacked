package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzciz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class NativeAdViewHolder {
    @RecentlyNonNull
    public static WeakHashMap<View, NativeAdViewHolder> zza = new WeakHashMap<>();
    @NotOnlyInitialized
    private zzbos zzb;
    private WeakReference<View> zzc;

    public NativeAdViewHolder(@RecentlyNonNull View view, @RecentlyNonNull Map<String, View> map, @RecentlyNonNull Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzciz.zzg("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zza.get(view) != null) {
            zzciz.zzg("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zza.put(view, this);
            this.zzc = new WeakReference<>(view);
            this.zzb = zzbgo.zza().zzh(view, zza(map), zza(map2));
        }
    }

    private static final HashMap<String, View> zza(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setClickConfirmingView(@RecentlyNonNull View view) {
        try {
            this.zzb.zzb(ObjectWrapper.wrap(view));
        } catch (RemoteException e11) {
            zzciz.zzh("Unable to call setClickConfirmingView on delegate", e11);
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@RecentlyNonNull NativeAd nativeAd) {
        View view;
        ? zza2 = nativeAd.zza();
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            zzciz.zzj("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zza.containsKey(view)) {
            zza.put(view, this);
        }
        zzbos zzbos = this.zzb;
        if (zzbos != null) {
            try {
                zzbos.zzc(zza2);
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call setNativeAd on delegate", e11);
            }
        }
    }

    public void unregisterNativeAd() {
        View view;
        zzbos zzbos = this.zzb;
        if (zzbos != null) {
            try {
                zzbos.zzd();
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call unregisterNativeAd on delegate", e11);
            }
        }
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            zza.remove(view);
        }
    }
}
