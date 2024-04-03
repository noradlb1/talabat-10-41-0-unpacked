package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Map;

final class zzqr extends zzqq<Object> {
    public final <UT, UB> UB zza(zzsy zzsy, Object obj, zzqp zzqp, zzqt<Object> zzqt, UB ub2, zztr<UT, UB> zztr) throws IOException {
        throw new NoSuchMethodError();
    }

    public final int zzb(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    public final boolean zze(zzsk zzsk) {
        return zzsk instanceof zzrc.zzc;
    }

    public final zzqt<Object> zzr(Object obj) {
        return ((zzrc.zzc) obj).zzbaq;
    }

    public final zzqt<Object> zzs(Object obj) {
        zzrc.zzc zzc = (zzrc.zzc) obj;
        if (zzc.zzbaq.isImmutable()) {
            zzc.zzbaq = (zzqt) zzc.zzbaq.clone();
        }
        return zzc.zzbaq;
    }

    public final void zzt(Object obj) {
        zzr(obj).zzmi();
    }

    public final void zza(zzum zzum, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    public final Object zza(zzqp zzqp, zzsk zzsk, int i11) {
        return zzqp.zza(zzsk, i11);
    }

    public final void zza(zzsy zzsy, Object obj, zzqp zzqp, zzqt<Object> zzqt) throws IOException {
        throw new NoSuchMethodError();
    }

    public final void zza(zzps zzps, Object obj, zzqp zzqp, zzqt<Object> zzqt) throws IOException {
        throw new NoSuchMethodError();
    }
}
