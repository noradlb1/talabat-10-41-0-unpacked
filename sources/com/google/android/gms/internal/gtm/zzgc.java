package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import com.google.android.gms.tagmanager.zzch;

final class zzgc extends zzch {
    final /* synthetic */ zzfy zzaqb;

    public zzgc(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        String str3 = str;
        if (!str.endsWith("+gtm")) {
            StringBuilder sb2 = new StringBuilder(str.length() + 4);
            sb2.append(str);
            sb2.append("+gtm");
            this.zzaqb.zzamv.execute(new zzgd(this, str2, bundle, sb2.toString(), j11, str));
            return;
        }
    }
}
