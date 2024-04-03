package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.huawei.hms.flutter.map.constants.Param;

public final class zzeqh implements zzevn<zzeqi> {
    private final zzevn<zzevs> zza;
    private final zzfef zzb;
    private final Context zzc;
    private final zzcik zzd;

    public zzeqh(zzerw<zzevs> zzerw, zzfef zzfef, Context context, zzcik zzcik) {
        this.zza = zzerw;
        this.zzb = zzfef;
        this.zzc = context;
        this.zzd = zzcik;
    }

    public final /* synthetic */ zzeqi zza(zzevs zzevs) {
        boolean z11;
        String str;
        int i11;
        int i12;
        float f11;
        String str2;
        int i13;
        DisplayMetrics displayMetrics;
        zzbfi zzbfi = this.zzb.zze;
        zzbfi[] zzbfiArr = zzbfi.zzg;
        if (zzbfiArr != null) {
            str = null;
            boolean z12 = false;
            boolean z13 = false;
            z11 = false;
            for (zzbfi zzbfi2 : zzbfiArr) {
                boolean z14 = zzbfi2.zzi;
                if (!z14 && !z12) {
                    str = zzbfi2.zza;
                    z12 = true;
                }
                if (z14) {
                    if (!z13) {
                        z13 = true;
                        z11 = true;
                    } else {
                        z13 = true;
                    }
                }
                if (z12 && z13) {
                    break;
                }
            }
        } else {
            str = zzbfi.zza;
            z11 = zzbfi.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f11 = 0.0f;
            i12 = 0;
            i11 = 0;
        } else {
            float f12 = displayMetrics.density;
            int i14 = displayMetrics.widthPixels;
            i11 = displayMetrics.heightPixels;
            str2 = this.zzd.zzh().zzl();
            i12 = i14;
            f11 = f12;
        }
        StringBuilder sb2 = new StringBuilder();
        zzbfi[] zzbfiArr2 = zzbfi.zzg;
        if (zzbfiArr2 != null) {
            boolean z15 = false;
            for (zzbfi zzbfi3 : zzbfiArr2) {
                if (zzbfi3.zzi) {
                    z15 = true;
                } else {
                    if (sb2.length() != 0) {
                        sb2.append("|");
                    }
                    int i15 = zzbfi3.zze;
                    if (i15 == -1) {
                        if (f11 != 0.0f) {
                            i15 = (int) (((float) zzbfi3.zzf) / f11);
                        } else {
                            i15 = -1;
                        }
                    }
                    sb2.append(i15);
                    sb2.append(Param.X);
                    int i16 = zzbfi3.zzb;
                    if (i16 == -2) {
                        if (f11 != 0.0f) {
                            i16 = (int) (((float) zzbfi3.zzc) / f11);
                        } else {
                            i16 = -2;
                        }
                    }
                    sb2.append(i16);
                }
            }
            if (z15) {
                if (sb2.length() != 0) {
                    i13 = 0;
                    sb2.insert(0, "|");
                } else {
                    i13 = 0;
                }
                sb2.insert(i13, "320x50");
            }
        }
        return new zzeqi(zzbfi, str, z11, sb2.toString(), f11, i12, i11, str2, this.zzb.zzp);
    }

    public final zzfxa<zzeqi> zzb() {
        return zzfwq.zzm(this.zza.zzb(), new zzeqg(this), zzcjm.zzf);
    }
}
