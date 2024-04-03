package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzghi implements zzfxy {
    private final ECPrivateKey zza;
    private final zzghk zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzghh zze;

    public zzghi(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i11, zzghh zzghh) throws GeneralSecurityException {
        this.zza = eCPrivateKey;
        this.zzb = new zzghk(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzghh;
    }
}
