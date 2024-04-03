package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

final class zzgas extends zzfyh<zzfxy, zzgej> {
    public zzgas(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzgej zzgej = (zzgej) obj;
        zzgeg zzc = zzgej.zzf().zzc();
        zzgep zzf = zzc.zzf();
        int zzc2 = zzgbd.zzc(zzf.zzg());
        byte[] zzE = zzgej.zzg().zzE();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, zzE), zzghn.zze(zzc2));
        return new zzghi((ECPrivateKey) zzghp.zzg.zza("EC").generatePrivate(eCPrivateKeySpec), zzf.zze().zzE(), zzgbd.zzb(zzf.zzh()), zzgbd.zzd(zzc.zzi()), new zzgbe(zzc.zza().zze()));
    }
}
