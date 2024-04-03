package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzfqp {
    /* access modifiers changed from: private */
    public final zzfps zza;
    private final zzfqo zzb;

    private zzfqp(zzfqo zzfqo) {
        zzfpr zzfpr = zzfpr.zza;
        this.zzb = zzfqo;
        this.zza = zzfpr;
    }

    public static zzfqp zzb(int i11) {
        return new zzfqp(new zzfql(4000));
    }

    public static zzfqp zzc(zzfps zzfps) {
        return new zzfqp(new zzfqj(zzfps));
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable<String> zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfqm(this, charSequence);
    }

    public final List<String> zzf(CharSequence charSequence) {
        Iterator<String> zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add(zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
