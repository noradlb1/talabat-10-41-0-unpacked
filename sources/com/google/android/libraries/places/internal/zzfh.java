package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

public class zzfh {
    /* access modifiers changed from: private */
    public final String zza;

    public /* synthetic */ zzfh(zzfh zzfh, zzfg zzfg) {
        this.zza = zzfh.zza;
    }

    private zzfh(String str) {
        this.zza = str;
    }

    public static zzfh zzb(String str) {
        return new zzfh(str);
    }

    public static final CharSequence zzf(@CheckForNull Object obj) {
        obj.getClass();
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public <A extends Appendable> A zza(A a11, Iterator it) throws IOException {
        if (it.hasNext()) {
            a11.append(zzf(it.next()));
            while (it.hasNext()) {
                a11.append(this.zza);
                a11.append(zzf(it.next()));
            }
        }
        return a11;
    }

    public final zzfh zzc() {
        return new zzfe(this, this);
    }

    public final String zze(Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it = iterable.iterator();
        StringBuilder sb2 = new StringBuilder();
        try {
            zza(sb2, it);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
