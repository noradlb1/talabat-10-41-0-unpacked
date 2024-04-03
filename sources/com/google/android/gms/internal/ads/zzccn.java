package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzccn {
    @Nonnull
    private final View zza;
    @Nullable
    private final Map<String, WeakReference<View>> zzb;
    @Nullable
    private final zzcht zzc;

    public zzccn(zzccm zzccm) {
        View zza2 = zzccm.zza;
        this.zza = zza2;
        Map<String, WeakReference<View>> zzd = zzccm.zzb;
        this.zzb = zzd;
        zzcht zza3 = zzccj.zza(zzccm.zza.getContext());
        this.zzc = zza3;
        if (zza3 != null && !zzd.isEmpty()) {
            try {
                zza3.zzf(new zzcco(ObjectWrapper.wrap(zza2).asBinder(), ObjectWrapper.wrap(zzd).asBinder()));
            } catch (RemoteException unused) {
                zzciz.zzg("Failed to call remote method.");
            }
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzcht zzcht = this.zzc;
        if (zzcht != null) {
            try {
                zzcht.zzh(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException unused) {
                zzciz.zzg("Failed to call remote method.");
            }
        } else {
            zzciz.zze("Failed to get internal reporting info generator.");
        }
    }

    public final void zzb(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzi(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zza), new zzccl(this, updateClickUrlCallback));
        } catch (RemoteException e11) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e11.toString()));
        }
    }

    public final void zzc(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzj(list, ObjectWrapper.wrap(this.zza), new zzcck(this, updateImpressionUrlsCallback));
        } catch (RemoteException e11) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e11.toString()));
        }
    }
}
