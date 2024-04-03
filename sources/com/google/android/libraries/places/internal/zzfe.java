package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

final class zzfe extends zzfh {
    final /* synthetic */ zzfh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfe(zzfh zzfh, zzfh zzfh2) {
        super(zzfh2, (zzfg) null);
        this.zza = zzfh;
    }

    public final <A extends Appendable> A zza(A a11, Iterator it) throws IOException {
        zzfm.zzc(it, "parts");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                a11.append(zzfh.zzf(next));
                break;
            }
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                a11.append(this.zza.zza);
                a11.append(zzfh.zzf(next2));
            }
        }
        return a11;
    }
}
