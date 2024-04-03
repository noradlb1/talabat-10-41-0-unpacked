package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class zzfzu extends zzfyi<zzgdg> {
    public zzfzu() {
        super(zzgdg.class, new zzfzs(zzfxu.class));
    }

    public static void zzk(boolean z11) throws GeneralSecurityException {
        if (zzm()) {
            zzfza.zzm(new zzfzu(), true);
        }
    }

    public static /* bridge */ /* synthetic */ zzfyf zzl(int i11, int i12) {
        zzgdi zzc = zzgdj.zzc();
        zzc.zza(i11);
        return new zzfyf((zzgdj) zzc.zzah(), i12);
    }

    private static boolean zzm() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzfyg<zzgdj, zzgdg> zza() {
        return new zzfzt(this, zzgdj.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgdg.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgdg zzgdg = (zzgdg) zzglv;
        zzgii.zzb(zzgdg.zza(), 0);
        zzgii.zza(zzgdg.zzf().zzd());
    }

    public final int zzj() {
        return 3;
    }
}
