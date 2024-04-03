package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.MediaContent;

public class MediaView extends FrameLayout {
    private MediaContent zza;
    private boolean zzb;
    private ImageView.ScaleType zzc;
    private boolean zzd;
    private zzb zze;
    private zzc zzf;

    public MediaView(@RecentlyNonNull Context context) {
        super(context);
    }

    public void setImageScaleType(@RecentlyNonNull ImageView.ScaleType scaleType) {
        this.zzd = true;
        this.zzc = scaleType;
        zzc zzc2 = this.zzf;
        if (zzc2 != null) {
            zzc2.zza.zzc(scaleType);
        }
    }

    public void setMediaContent(@RecentlyNonNull MediaContent mediaContent) {
        this.zzb = true;
        this.zza = mediaContent;
        zzb zzb2 = this.zze;
        if (zzb2 != null) {
            zzb2.zza.zzb(mediaContent);
        }
    }

    public final synchronized void zza(zzb zzb2) {
        this.zze = zzb2;
        if (this.zzb) {
            zzb2.zza.zzb(this.zza);
        }
    }

    public final synchronized void zzb(zzc zzc2) {
        this.zzf = zzc2;
        if (this.zzd) {
            zzc2.zza.zzc(this.zzc);
        }
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @TargetApi(21)
    public MediaView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
