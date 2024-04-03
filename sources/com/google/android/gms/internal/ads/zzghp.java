package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghx;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzghp<T_WRAPPER extends zzghx<T_ENGINE>, T_ENGINE> {
    public static final zzghp<zzghq, Cipher> zza = new zzghp<>(new zzghq());
    public static final zzghp<zzghu, Mac> zzb = new zzghp<>(new zzghu());
    public static final zzghp<zzghw, Signature> zzc = new zzghp<>(new zzghw());
    public static final zzghp<zzghv, MessageDigest> zzd = new zzghp<>(new zzghv());
    public static final zzghp<zzghr, KeyAgreement> zze = new zzghp<>(new zzghr());
    public static final zzghp<zzght, KeyPairGenerator> zzf = new zzghp<>(new zzght());
    public static final zzghp<zzghs, KeyFactory> zzg = new zzghp<>(new zzghs());
    private static final Logger zzh = Logger.getLogger(zzghp.class.getName());
    private static final List<Provider> zzi;
    private static final boolean zzj;
    private final T_WRAPPER zzk;

    static {
        if (zzgal.zzb()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt");
            zzj = false;
        } else if (zzgih.zzb()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
            zzj = true;
        } else {
            zzi = new ArrayList();
            zzj = true;
        }
    }

    public zzghp(T_WRAPPER t_wrapper) {
        this.zzk = t_wrapper;
    }

    public static List<Provider> zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public final T_ENGINE zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzi) {
            try {
                return this.zzk.zza(str, zza2);
            } catch (Exception e11) {
                if (exc == null) {
                    exc = e11;
                }
            }
        }
        if (zzj) {
            return this.zzk.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
