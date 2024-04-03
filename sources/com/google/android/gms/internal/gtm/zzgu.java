package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzgu {
    private Tracker zzrl;
    private Context zzrm;
    private GoogleAnalytics zzro;

    public zzgu(Context context) {
        this.zzrm = context;
    }

    private final synchronized void zzbn(String str) {
        if (this.zzro == null) {
            GoogleAnalytics instance = GoogleAnalytics.getInstance(this.zzrm);
            this.zzro = instance;
            instance.setLogger(new zzgv());
            this.zzrl = this.zzro.newTracker(str);
        }
    }

    public final Tracker zzbm(String str) {
        zzbn(str);
        return this.zzrl;
    }
}
