package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzbyk implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbnw zzg;
    private final List<String> zzh = new ArrayList();
    private final boolean zzi;
    private final Map<String, Boolean> zzj = new HashMap();
    private final String zzk;

    public zzbyk(@Nullable Date date, int i11, @Nullable Set<String> set, @Nullable Location location, boolean z11, int i12, zzbnw zzbnw, List<String> list, boolean z12, int i13, String str) {
        this.zza = date;
        this.zzb = i11;
        this.zzc = set;
        this.zze = location;
        this.zzd = z11;
        this.zzf = i12;
        this.zzg = zzbnw;
        this.zzi = z12;
        this.zzk = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(CertificateUtil.DELIMITER, 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.TRUE);
                        } else if ("false".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzbjq.zzf().zza();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzbnw zzbnw = this.zzg;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbnw == null) {
            return builder.build();
        }
        int i11 = zzbnw.zza;
        if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbnw.zzg);
                    builder.setMediaAspectRatio(zzbnw.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzbnw.zzb);
                builder.setImageOrientation(zzbnw.zzc);
                builder.setRequestMultipleImages(zzbnw.zzd);
                return builder.build();
            }
            zzbkq zzbkq = zzbnw.zzf;
            if (zzbkq != null) {
                builder.setVideoOptions(new VideoOptions(zzbkq));
            }
        }
        builder.setAdChoicesPlacement(zzbnw.zze);
        builder.setReturnUrlsForImageAssets(zzbnw.zzb);
        builder.setImageOrientation(zzbnw.zzc);
        builder.setRequestMultipleImages(zzbnw.zzd);
        return builder.build();
    }

    @NonNull
    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzbnw.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return zzbjq.zzf().zzu();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final Map<String, Boolean> zza() {
        return this.zzj;
    }

    public final boolean zzb() {
        return this.zzh.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }
}
