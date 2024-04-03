package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
public final class zzaa extends zzi<zzaa> {
    private String zzva;
    private int zzvb;
    private int zzvc;
    private String zzvd;
    private String zzve;
    private boolean zzvf;
    private boolean zzvg;

    public zzaa() {
        this(false);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.zzva);
        hashMap.put("interstitial", Boolean.valueOf(this.zzvf));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.zzvg));
        hashMap.put("screenId", Integer.valueOf(this.zzvb));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzvc));
        hashMap.put("referrerScreenName", this.zzvd);
        hashMap.put("referrerUri", this.zzve);
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaa zzaa = (zzaa) zzi;
        if (!TextUtils.isEmpty(this.zzva)) {
            zzaa.zzva = this.zzva;
        }
        int i11 = this.zzvb;
        if (i11 != 0) {
            zzaa.zzvb = i11;
        }
        int i12 = this.zzvc;
        if (i12 != 0) {
            zzaa.zzvc = i12;
        }
        if (!TextUtils.isEmpty(this.zzvd)) {
            zzaa.zzvd = this.zzvd;
        }
        if (!TextUtils.isEmpty(this.zzve)) {
            String str = this.zzve;
            if (TextUtils.isEmpty(str)) {
                zzaa.zzve = null;
            } else {
                zzaa.zzve = str;
            }
        }
        boolean z11 = this.zzvf;
        if (z11) {
            zzaa.zzvf = z11;
        }
        boolean z12 = this.zzvg;
        if (z12) {
            zzaa.zzvg = z12;
        }
    }

    public final String zzca() {
        return this.zzva;
    }

    public final int zzcb() {
        return this.zzvb;
    }

    public final String zzcc() {
        return this.zzve;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzaa(boolean r5) {
        /*
            r4 = this;
            java.util.UUID r5 = java.util.UUID.randomUUID()
            long r0 = r5.getLeastSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r0 = (int) r0
            if (r0 == 0) goto L_0x0010
            goto L_0x0023
        L_0x0010:
            long r0 = r5.getMostSignificantBits()
            long r0 = r0 & r2
            int r0 = (int) r0
            if (r0 == 0) goto L_0x0019
            goto L_0x0023
        L_0x0019:
            java.lang.String r5 = "GAv4"
            java.lang.String r0 = "UUID.randomUUID() returned 0."
            android.util.Log.e(r5, r0)
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x0023:
            r5 = 0
            r4.<init>(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzaa.<init>(boolean):void");
    }

    @ShowFirstParty
    @VisibleForTesting
    private zzaa(boolean z11, int i11) {
        Preconditions.checkNotZero(i11);
        this.zzvb = i11;
        this.zzvg = false;
    }
}
