package com.google.ads;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import net.bytebuddy.jar.asm.Opcodes;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    @RecentlyNonNull
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    @RecentlyNonNull
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    @RecentlyNonNull
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    @RecentlyNonNull
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(Opcodes.IF_ICMPNE, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    @RecentlyNonNull
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final com.google.android.gms.ads.AdSize zza;

    public AdSize(int i11, int i12) {
        this(new com.google.android.gms.ads.AdSize(i11, i12));
    }

    public AdSize(@RecentlyNonNull com.google.android.gms.ads.AdSize adSize) {
        this.zza = adSize;
    }

    public boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.zza.equals(((AdSize) obj).zza);
    }

    @RecentlyNonNull
    public AdSize findBestSize(@RecentlyNonNull AdSize... adSizeArr) {
        AdSize adSize = null;
        if (adSizeArr == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        float f11 = 0.0f;
        for (AdSize adSize2 : adSizeArr) {
            int width2 = adSize2.getWidth();
            int height2 = adSize2.getHeight();
            if (isSizeAppropriate(width2, height2)) {
                float f12 = ((float) (width2 * height2)) / ((float) (width * height));
                if (f12 > 1.0f) {
                    f12 = 1.0f / f12;
                }
                if (f12 > f11) {
                    adSize = adSize2;
                    f11 = f12;
                }
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.zza.getHeight();
    }

    public int getHeightInPixels(@RecentlyNonNull Context context) {
        return this.zza.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zza.getWidth();
    }

    public int getWidthInPixels(@RecentlyNonNull Context context) {
        return this.zza.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zza.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zza.isFullWidth();
    }

    public boolean isSizeAppropriate(int i11, int i12) {
        int width = getWidth();
        int height = getHeight();
        float f11 = (float) i11;
        float f12 = (float) width;
        if (f11 > f12 * 1.25f || f11 < f12 * 0.8f) {
            return false;
        }
        float f13 = (float) i12;
        float f14 = (float) height;
        if (f13 > 1.25f * f14 || f13 < f14 * 0.8f) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public String toString() {
        return this.zza.toString();
    }

    private AdSize(int i11, int i12, String str) {
        this(new com.google.android.gms.ads.AdSize(i11, i12));
    }
}
