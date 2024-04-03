package com.google.android.gms.internal.location;

import androidx.annotation.GuardedBy;
import com.instabug.library.logging.InstabugLog;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

public final class zzdj {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    @GuardedBy("sharedStringBuilder")
    private static final StringBuilder zzc = new StringBuilder(33);

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat(InstabugLog.LOG_MESSAGE_DATE_FORMAT, locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
    }

    public static String zza(long j11) {
        String sb2;
        StringBuilder sb3 = zzc;
        synchronized (sb3) {
            sb3.setLength(0);
            zzb(j11, sb3);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static void zzb(long j11, StringBuilder sb2) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            sb2.append("0s");
            return;
        }
        sb2.ensureCapacity(sb2.length() + 27);
        boolean z11 = false;
        if (i11 < 0) {
            sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            if (j11 != Long.MIN_VALUE) {
                j11 = -j11;
            } else {
                j11 = Long.MAX_VALUE;
                z11 = true;
            }
        }
        if (j11 >= 86400000) {
            sb2.append(j11 / 86400000);
            sb2.append("d");
            j11 %= 86400000;
        }
        if (true == z11) {
            j11 = 25975808;
        }
        if (j11 >= DateUtils.MILLIS_PER_HOUR) {
            sb2.append(j11 / DateUtils.MILLIS_PER_HOUR);
            sb2.append("h");
            j11 %= DateUtils.MILLIS_PER_HOUR;
        }
        if (j11 >= 60000) {
            sb2.append(j11 / 60000);
            sb2.append("m");
            j11 %= 60000;
        }
        if (j11 >= 1000) {
            sb2.append(j11 / 1000);
            sb2.append("s");
            j11 %= 1000;
        }
        if (j11 > 0) {
            sb2.append(j11);
            sb2.append("ms");
        }
    }
}
