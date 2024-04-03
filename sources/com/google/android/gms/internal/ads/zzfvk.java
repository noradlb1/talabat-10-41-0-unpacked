package com.google.android.gms.internal.ads;

final class zzfvk<I, O> extends zzfvm<I, O, zzfvx<? super I, ? extends O>, zzfxa<? extends O>> {
    public zzfvk(zzfxa<? extends I> zzfxa, zzfvx<? super I, ? extends O> zzfvx) {
        super(zzfxa, zzfvx);
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj, Object obj2) throws Exception {
        zzfvx zzfvx = (zzfvx) obj;
        zzfxa zza = zzfvx.zza(obj2);
        zzfqg.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfvx);
        return zza;
    }

    public final /* synthetic */ void zzb(Object obj) {
        zzu((zzfxa) obj);
    }
}
