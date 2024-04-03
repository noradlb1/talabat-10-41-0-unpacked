package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
public final class zzv extends zzi<zzv> {
    private String zzuj;
    public int zzuk;
    public int zzul;
    public int zzum;
    public int zzun;
    public int zzuo;

    public final String getLanguage() {
        return this.zzuj;
    }

    public final void setLanguage(String str) {
        this.zzuj = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(ConstantsKt.ADJUST_LANGUAGE, this.zzuj);
        hashMap.put("screenColors", Integer.valueOf(this.zzuk));
        hashMap.put("screenWidth", Integer.valueOf(this.zzul));
        hashMap.put("screenHeight", Integer.valueOf(this.zzum));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzun));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzuo));
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzv zzv = (zzv) zzi;
        int i11 = this.zzuk;
        if (i11 != 0) {
            zzv.zzuk = i11;
        }
        int i12 = this.zzul;
        if (i12 != 0) {
            zzv.zzul = i12;
        }
        int i13 = this.zzum;
        if (i13 != 0) {
            zzv.zzum = i13;
        }
        int i14 = this.zzun;
        if (i14 != 0) {
            zzv.zzun = i14;
        }
        int i15 = this.zzuo;
        if (i15 != 0) {
            zzv.zzuo = i15;
        }
        if (!TextUtils.isEmpty(this.zzuj)) {
            zzv.zzuj = this.zzuj;
        }
    }
}
