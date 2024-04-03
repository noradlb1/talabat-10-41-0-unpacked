package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbns extends RelativeLayout {
    private static final float[] zza = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzb;

    public zzbns(Context context, zzbnr zzbnr, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzbnr);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zza, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zzbnr.zzd());
        setLayoutParams(layoutParams);
        zzt.zzq();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzbnr.zzg())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzbnr.zzg());
            textView.setTextColor(zzbnr.zze());
            textView.setTextSize((float) zzbnr.zzf());
            zzbgo.zzb();
            int zzs = zzcis.zzs(context, 4);
            zzbgo.zzb();
            textView.setPadding(zzs, 0, zzcis.zzs(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzbnu> zzi = zzbnr.zzi();
        if (zzi != null && zzi.size() > 1) {
            this.zzb = new AnimationDrawable();
            for (zzbnu zzf : zzi) {
                try {
                    this.zzb.addFrame((Drawable) ObjectWrapper.unwrap(zzf.zzf()), zzbnr.zzb());
                } catch (Exception e11) {
                    zzciz.zzh("Error while getting drawable.", e11);
                }
            }
            zzt.zzq();
            imageView.setBackground(this.zzb);
        } else if (zzi.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzi.get(0).zzf()));
            } catch (Exception e12) {
                zzciz.zzh("Error while getting drawable.", e12);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
