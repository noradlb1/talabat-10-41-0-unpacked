package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzil  reason: invalid package */
final class zzil extends zzll {
    public zzil(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzaif zzaif) throws GeneralSecurityException {
        zzrl zzrl = (zzrl) zzaif;
        zzrf zzb = zzrl.zzb();
        zzro zze = zzb.zze();
        int zzc = zzit.zzc(zze.zzf());
        byte[] zzq = zzrl.zzg().zzq();
        byte[] zzq2 = zzrl.zzh().zzq();
        ECParameterSpec zzi = zzvb.zzi(zzc);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzq), new BigInteger(1, zzq2));
        zzjy.zzb(eCPoint, zzi.getCurve());
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zzi);
        return new zzuy((ECPublicKey) ((KeyFactory) zzvk.zzg.zza("EC")).generatePublic(eCPublicKeySpec), zze.zzd().zzq(), zzit.zzb(zze.zzg()), zzit.zzd(zzb.zzh()), new zziu(zzb.zza().zzd()));
    }
}
