package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciz;
import net.bytebuddy.jar.asm.Opcodes;

@VisibleForTesting
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    @RecentlyNonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    @RecentlyNonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    @RecentlyNonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    @RecentlyNonNull
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    @RecentlyNonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    @RecentlyNonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    @RecentlyNonNull
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    @RecentlyNonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    @RecentlyNonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(Opcodes.IF_ICMPNE, 600, "160x600_as");
    @RecentlyNonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        L_0x000a:
            r1 = -2
            if (r7 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r7)
        L_0x0014:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + 4
            int r2 = r2 + r3
            r4.<init>(r2)
            r4.append(r0)
            java.lang.String r0 = "x"
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = "_as"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r5.<init>(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        AdSize zzc2 = zzcis.zzc(context, i11, 50, 0);
        zzc2.zze = true;
        return zzc2;
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        int zza2 = zzcis.zza(context, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getCurrentOrientationInterscrollerAdSize(@RecentlyNonNull Context context, int i11) {
        return zzj(i11, zzcis.zza(context, 0));
    }

    @RecentlyNonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i11, int i12) {
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzg = i12;
        adSize.zzf = true;
        if (i12 < 32) {
            StringBuilder sb2 = new StringBuilder(129);
            sb2.append("The maximum height set for the inline adaptive ad size was ");
            sb2.append(i12);
            sb2.append(" dp, which is below the minimum recommended value of 32 dp.");
            zzciz.zzj(sb2.toString());
        }
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        AdSize zzc2 = zzcis.zzc(context, i11, 50, 2);
        zzc2.zze = true;
        return zzc2;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        int zza2 = zzcis.zza(context, 2);
        AdSize adSize = new AdSize(i11, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getLandscapeInterscrollerAdSize(@RecentlyNonNull Context context, int i11) {
        return zzj(i11, zzcis.zza(context, 2));
    }

    @RecentlyNonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        AdSize zzc2 = zzcis.zzc(context, i11, 50, 1);
        zzc2.zze = true;
        return zzc2;
    }

    @RecentlyNonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@RecentlyNonNull Context context, int i11) {
        int zza2 = zzcis.zza(context, 1);
        AdSize adSize = new AdSize(i11, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.zzg = zza2;
        adSize.zzf = true;
        return adSize;
    }

    @RecentlyNonNull
    public static AdSize getPortraitInterscrollerAdSize(@RecentlyNonNull Context context, int i11) {
        return zzj(i11, zzcis.zza(context, 1));
    }

    private static AdSize zzj(int i11, int i12) {
        if (i12 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzi = i12;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd)) {
            return true;
        }
        return false;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(@RecentlyNonNull Context context) {
        int i11 = this.zzc;
        if (i11 == -4 || i11 == -3) {
            return -1;
        }
        if (i11 == -2) {
            return zzbfi.zza(context.getResources().getDisplayMetrics());
        }
        zzbgo.zzb();
        return zzcis.zzs(context, this.zzc);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(@RecentlyNonNull Context context) {
        int i11 = this.zzb;
        if (i11 == -3) {
            return -1;
        }
        if (i11 != -1) {
            zzbgo.zzb();
            return zzcis.zzs(context, this.zzb);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzbfi> creator = zzbfi.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    @RecentlyNonNull
    public String toString() {
        return this.zzd;
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final void zzc(int i11) {
        this.zzg = i11;
    }

    public final void zzd(int i11) {
        this.zzi = i11;
    }

    public final void zze(boolean z11) {
        this.zzf = true;
    }

    public final void zzf(boolean z11) {
        this.zzh = true;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zzh;
    }

    public AdSize(int i11, int i12, String str) {
        if (i11 < 0 && i11 != -1 && i11 != -3) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Invalid width for AdSize: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i12 >= 0 || i12 == -2 || i12 == -4) {
            this.zzb = i11;
            this.zzc = i12;
            this.zzd = str;
        } else {
            StringBuilder sb3 = new StringBuilder(38);
            sb3.append("Invalid height for AdSize: ");
            sb3.append(i12);
            throw new IllegalArgumentException(sb3.toString());
        }
    }
}
