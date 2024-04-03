package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class zzar implements DialogInterface.OnClickListener {
    public final /* synthetic */ AtomicInteger zza;

    public /* synthetic */ zzar(AtomicInteger atomicInteger) {
        this.zza = atomicInteger;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.set(i11);
    }
}
