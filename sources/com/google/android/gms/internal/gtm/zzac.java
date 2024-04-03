package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
public final class zzac extends zzi<zzac> {
    public String mCategory;
    public String zzvk;
    public long zzvl;
    public String zzvm;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzvk);
        hashMap.put("timeInMillis", Long.valueOf(this.zzvl));
        hashMap.put("category", this.mCategory);
        hashMap.put("label", this.zzvm);
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzac zzac = (zzac) zzi;
        if (!TextUtils.isEmpty(this.zzvk)) {
            zzac.zzvk = this.zzvk;
        }
        long j11 = this.zzvl;
        if (j11 != 0) {
            zzac.zzvl = j11;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzac.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzvm)) {
            zzac.zzvm = this.zzvm;
        }
    }
}
