package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

public final class zzdrb {
    private final zzg zza;
    private final zzfef zzb;
    private final zzdqh zzc;
    private final zzdqc zzd;
    @Nullable
    private final zzdrm zze;
    @Nullable
    private final zzdru zzf;
    private final Executor zzg;
    private final Executor zzh;
    private final zzbnw zzi;
    private final zzdpz zzj;

    public zzdrb(zzg zzg2, zzfef zzfef, zzdqh zzdqh, zzdqc zzdqc, @Nullable zzdrm zzdrm, @Nullable zzdru zzdru, Executor executor, Executor executor2, zzdpz zzdpz) {
        this.zza = zzg2;
        this.zzb = zzfef;
        this.zzi = zzfef.zzi;
        this.zzc = zzdqh;
        this.zzd = zzdqc;
        this.zze = zzdrm;
        this.zzf = zzdru;
        this.zzg = executor;
        this.zzh = executor2;
        this.zzj = zzdpz;
    }

    private static void zzg(RelativeLayout.LayoutParams layoutParams, int i11) {
        if (i11 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i11 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i11 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzh(@NonNull ViewGroup viewGroup, boolean z11) {
        View view;
        FrameLayout.LayoutParams layoutParams;
        if (z11) {
            view = this.zzd.zzf();
        } else {
            view = this.zzd.zzg();
        }
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcv)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(view, layoutParams);
        return true;
    }

    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z11;
        if (viewGroup != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.zzd.zzf() == null) {
            return;
        }
        if (this.zzd.zzc() == 2 || this.zzd.zzc() == 1) {
            this.zza.zzE(this.zzb.zzf, String.valueOf(this.zzd.zzc()), z11);
        } else if (this.zzd.zzc() == 6) {
            this.zza.zzE(this.zzb.zzf, ExifInterface.GPS_MEASUREMENT_2D, z11);
            this.zza.zzE(this.zzb.zzf, "1", z11);
        }
    }

    public final /* synthetic */ void zzb(zzdrw zzdrw) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbof zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzc.zze() || this.zzc.zzd()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i11 = 0;
            while (true) {
                if (i11 >= 2) {
                    break;
                }
                View zzg2 = zzdrw.zzg(strArr[i11]);
                if (zzg2 != null && (zzg2 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg2;
                    break;
                }
                i11++;
            }
        }
        viewGroup = null;
        Context context2 = zzdrw.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzd.zze() != null) {
            view = this.zzd.zze();
            zzbnw zzbnw = this.zzi;
            if (zzbnw != null && viewGroup == null) {
                zzg(layoutParams, zzbnw.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.zzd.zzl() instanceof zzbnr)) {
            view = null;
        } else {
            zzbnr zzbnr = (zzbnr) this.zzd.zzl();
            if (viewGroup == null) {
                zzg(layoutParams, zzbnr.zzc());
            }
            zzbns zzbns = new zzbns(context2, zzbnr, layoutParams);
            zzbns.setContentDescription((CharSequence) zzbgq.zzc().zzb(zzblj.zzct));
            view = zzbns;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdrw.zzf().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzh2 = zzdrw.zzh();
                if (zzh2 != null) {
                    zzh2.addView(zza3);
                }
            }
            zzdrw.zzq(zzdrw.zzk(), view, true);
        }
        zzfss<String> zzfss = zzdqx.zza;
        int size = zzfss.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg3 = zzdrw.zzg(zzfss.get(i12));
            i12++;
            if (zzg3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg3;
                break;
            }
        }
        this.zzh.execute(new zzdqy(this, viewGroup2));
        if (viewGroup2 != null) {
            if (!zzh(viewGroup2, true)) {
                if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgZ)).booleanValue() || !zzh(viewGroup2, false)) {
                    viewGroup2.removeAllViews();
                    View zzf2 = zzdrw.zzf();
                    if (zzf2 != null) {
                        context = zzf2.getContext();
                    }
                    if (context != null && (zza2 = this.zzj.zza()) != null) {
                        try {
                            IObjectWrapper zzi2 = zza2.zzi();
                            if (zzi2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi2)) != null) {
                                ImageView imageView = new ImageView(context);
                                imageView.setImageDrawable(drawable);
                                IObjectWrapper zzj2 = zzdrw.zzj();
                                if (zzj2 != null) {
                                    if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeD)).booleanValue()) {
                                        imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj2));
                                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        viewGroup2.addView(imageView);
                                    }
                                }
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                viewGroup2.addView(imageView);
                            }
                        } catch (RemoteException unused) {
                            zzciz.zzj("Could not get main image drawable");
                        }
                    }
                } else if (this.zzd.zzp() != null) {
                    this.zzd.zzp().zzaq(new zzdra(zzdrw, viewGroup2));
                }
            } else if (this.zzd.zzr() != null) {
                this.zzd.zzr().zzaq(new zzdra(zzdrw, viewGroup2));
            }
        }
    }

    public final void zzc(@Nullable zzdrw zzdrw) {
        if (zzdrw != null && this.zze != null && zzdrw.zzh() != null && this.zzc.zzf()) {
            try {
                zzdrw.zzh().addView(this.zze.zza());
            } catch (zzcpa e11) {
                zze.zzb("web view can not be obtained", e11);
            }
        }
    }

    public final void zzd(@Nullable zzdrw zzdrw) {
        if (zzdrw != null) {
            Context context = zzdrw.zzf().getContext();
            if (zzcb.zzh(context, this.zzc.zza)) {
                if (!(context instanceof Activity)) {
                    zzciz.zze("Activity context is needed for policy validator.");
                } else if (this.zzf != null && zzdrw.zzh() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzf.zza(zzdrw.zzh(), windowManager), zzcb.zzb());
                    } catch (zzcpa e11) {
                        zze.zzb("web view can not be obtained", e11);
                    }
                }
            }
        }
    }

    public final void zze(zzdrw zzdrw) {
        this.zzg.execute(new zzdqz(this, zzdrw));
    }

    public final boolean zzf(@NonNull ViewGroup viewGroup) {
        return zzh(viewGroup, true);
    }
}
