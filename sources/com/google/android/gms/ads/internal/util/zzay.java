package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;

final class zzay implements DialogInterface.OnClickListener {
    final /* synthetic */ zzaz zza;

    public zzay(zzaz zzaz) {
        this.zza = zzaz;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        zzt.zzp();
        zzt.zzY(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
