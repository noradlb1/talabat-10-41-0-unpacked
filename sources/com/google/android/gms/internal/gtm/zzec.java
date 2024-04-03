package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.FirebasePerformance;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzec implements zzei {
    private static final Object zzadq = new Object();
    private static zzec zzanj;
    private static final Set<String> zzanm = new HashSet(Arrays.asList(new String[]{"GET", FirebasePerformance.HttpMethod.HEAD, "POST", "PUT"}));
    private zzfe zzank;
    private zzej zzanl;

    private zzec(Context context) {
        this(zzek.zzq(context), new zzfm());
    }

    public static zzei zzp(Context context) {
        zzec zzec;
        synchronized (zzadq) {
            if (zzanj == null) {
                zzanj = new zzec(context);
            }
            zzec = zzanj;
        }
        return zzec;
    }

    public final void dispatch() {
        zzfo.zzkv().dispatch();
    }

    public final boolean zza(String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        if (str2 != null && !zzanm.contains(str2)) {
            zzev.zzac(String.format("Unsupport http method %s. Drop the hit.", new Object[]{str2}));
            return false;
        } else if (zzfd.zzkr().isPreview() || this.zzank.zzfm()) {
            this.zzanl.zzb(str, str2, str3, map, str4);
            return true;
        } else {
            zzev.zzac("Too many hits sent too quickly (rate throttled).");
            return false;
        }
    }

    public final boolean zzay(String str) {
        return zza(str, (String) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final boolean zzf(String str, String str2) {
        return zza(str, (String) null, str2, (Map<String, String>) null, (String) null);
    }

    @VisibleForTesting
    private zzec(zzej zzej, zzfe zzfe) {
        this.zzanl = zzej;
        this.zzank = zzfe;
    }
}
