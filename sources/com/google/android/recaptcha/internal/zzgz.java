package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzgz;
import com.google.android.recaptcha.internal.zzhf;

public class zzgz<MessageType extends zzhf<MessageType, BuilderType>, BuilderType extends zzgz<MessageType, BuilderType>> extends zzeq<MessageType, BuilderType> {
    protected zzhf zza;
    private final zzhf zzb;

    public zzgz(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzF()) {
            this.zza = messagetype.zzs();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zzd(Object obj, Object obj2) {
        zziy.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final /* synthetic */ zzip zzX() {
        return this.zzb;
    }

    public final /* synthetic */ zzeq zzb(zzer zzer) {
        zzg((zzhf) zzer);
        return this;
    }

    /* renamed from: zzf */
    public final zzgz zza() {
        zzgz zzgz = (zzgz) this.zzb.zzh(5, (Object) null, (Object) null);
        zzgz.zza = zzk();
        return zzgz;
    }

    public final zzgz zzg(zzhf zzhf) {
        if (!this.zzb.equals(zzhf)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zzd(this.zza, zzhf);
        }
        return this;
    }

    /* renamed from: zzh */
    public final MessageType zzj() {
        MessageType zzi = zzk();
        if (zzi.zzo()) {
            return zzi;
        }
        throw new zzjv(zzi);
    }

    /* renamed from: zzi */
    public MessageType zzk() {
        if (!this.zza.zzF()) {
            return this.zza;
        }
        this.zza.zzA();
        return this.zza;
    }

    public final void zzm() {
        if (!this.zza.zzF()) {
            zzn();
        }
    }

    public void zzn() {
        zzhf zzs = this.zzb.zzs();
        zzd(zzs, this.zza);
        this.zza = zzs;
    }

    public final boolean zzo() {
        return zzhf.zzE(this.zza, false);
    }
}
