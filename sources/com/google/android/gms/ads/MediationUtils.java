package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import java.util.List;

public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    @RecentlyNullable
    public static AdSize findClosestSize(@RecentlyNonNull Context context, @RecentlyNonNull AdSize adSize, @RecentlyNonNull List<AdSize> list) {
        AdSize adSize2 = null;
        if (!(list == null || adSize == null)) {
            if (!adSize.zzh() && !adSize.zzi()) {
                float f11 = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f11), Math.round(((float) adSize.getHeightInPixels(context)) / f11));
            }
            for (AdSize next : list) {
                if (next != null) {
                    int width = adSize.getWidth();
                    int width2 = next.getWidth();
                    int height = adSize.getHeight();
                    int height2 = next.getHeight();
                    if (((double) width) * MIN_WIDTH_RATIO <= ((double) width2) && width >= width2) {
                        if (adSize.zzi()) {
                            int zza = adSize.zza();
                            if (((Integer) zzbgq.zzc().zzb(zzblj.zzfK)).intValue() <= width2) {
                                if (((Integer) zzbgq.zzc().zzb(zzblj.zzfL)).intValue() <= height2) {
                                    if (zza < height2) {
                                    }
                                }
                            }
                        } else if (adSize.zzh()) {
                            if (adSize.zzb() < height2) {
                            }
                        } else if (((double) height) * MIN_HEIGHT_RATIO <= ((double) height2)) {
                            if (height < height2) {
                            }
                        }
                        if (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= next.getWidth() * next.getHeight()) {
                            adSize2 = next;
                        }
                    }
                }
            }
        }
        return adSize2;
    }
}
