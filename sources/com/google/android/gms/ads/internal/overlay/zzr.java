package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciz;

public final class zzr extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final ImageButton zza;
    private final zzaa zzb;

    public zzr(Context context, zzq zzq, @Nullable zzaa zzaa) {
        super(context);
        zzp zzp;
        this.zzb = zzaa;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzbgo.zzb();
        int zzs = zzcis.zzs(context, zzq.zza);
        zzbgo.zzb();
        int zzs2 = zzcis.zzs(context, 0);
        zzbgo.zzb();
        int zzs3 = zzcis.zzs(context, zzq.zzb);
        zzbgo.zzb();
        imageButton.setPadding(zzs, zzs2, zzs3, zzcis.zzs(context, zzq.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzbgo.zzb();
        int zzs4 = zzcis.zzs(context, zzq.zzd + zzq.zza + zzq.zzb);
        zzbgo.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(zzs4, zzcis.zzs(context, zzq.zzd + zzq.zzc), 17));
        long longValue = ((Long) zzbgq.zzc().zzb(zzblj.zzaQ)).longValue();
        if (longValue > 0) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaR)).booleanValue()) {
                zzp = new zzp(this);
            } else {
                zzp = null;
            }
            imageButton.setAlpha(0.0f);
            imageButton.animate().alpha(1.0f).setDuration(longValue).setListener(zzp);
        }
    }

    private final void zzc() {
        String str = (String) zzbgq.zzc().zzb(zzblj.zzaP);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(17301527);
            return;
        }
        Resources zzd = zzt.zzo().zzd();
        if (zzd != null) {
            Drawable drawable = null;
            try {
                if ("white".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                } else if ("black".equals(str)) {
                    drawable = zzd.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                }
            } catch (Resources.NotFoundException unused) {
                zzciz.zze("Close button resource not found, falling back to default.");
            }
            if (drawable == null) {
                this.zza.setImageResource(17301527);
                return;
            }
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        this.zza.setImageResource(17301527);
    }

    public final void onClick(View view) {
        zzaa zzaa = this.zzb;
        if (zzaa != null) {
            zzaa.zzbR();
        }
    }

    public final void zzb(boolean z11) {
        if (z11) {
            this.zza.setVisibility(8);
            if (((Long) zzbgq.zzc().zzb(zzblj.zzaQ)).longValue() > 0) {
                this.zza.animate().cancel();
                this.zza.clearAnimation();
                return;
            }
            return;
        }
        this.zza.setVisibility(0);
    }
}
