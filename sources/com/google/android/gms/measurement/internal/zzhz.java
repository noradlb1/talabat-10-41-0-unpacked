package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzhz implements zzlo {
    final /* synthetic */ zzik zza;

    public zzhz(zzik zzik) {
        this.zza = zzik;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzF("auto", "_err", bundle, str);
        } else {
            this.zza.zzD("auto", "_err", bundle);
        }
    }
}
