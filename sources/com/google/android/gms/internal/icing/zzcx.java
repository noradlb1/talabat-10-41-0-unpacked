package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzcx;
import com.google.android.gms.internal.icing.zzda;

public class zzcx<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcx<MessageType, BuilderType>> extends zzbr<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    public zzcx(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzda) messagetype.zzf(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzem.zza().zzb(messagetype.getClass()).zzc(messagetype, messagetype2);
    }

    public final /* bridge */ /* synthetic */ zzbr zze(zzbs zzbs) {
        zzk((zzda) zzbs);
        return this;
    }

    public void zzg() {
        MessageType messagetype = (zzda) this.zza.zzf(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    /* renamed from: zzh */
    public final BuilderType zzd() {
        BuilderType buildertype = (zzcx) this.zzc.zzf(5, (Object) null, (Object) null);
        buildertype.zzk(zzl());
        return buildertype;
    }

    /* renamed from: zzi */
    public MessageType zzl() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzem.zza().zzb(messagetype.getClass()).zze(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzj() {
        MessageType messagetype;
        MessageType zzi = zzl();
        boolean z11 = true;
        byte byteValue = ((Byte) zzi.zzf(1, (Object) null, (Object) null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z11 = false;
            } else {
                boolean zzf = zzem.zza().zzb(zzi.getClass()).zzf(zzi);
                if (true != zzf) {
                    messagetype = null;
                } else {
                    messagetype = zzi;
                }
                zzi.zzf(2, messagetype, (Object) null);
                z11 = zzf;
            }
        }
        if (z11) {
            return zzi;
        }
        throw new zzfc(zzi);
    }

    public final BuilderType zzk(MessageType messagetype) {
        if (this.zzb) {
            zzg();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzee zzm() {
        return this.zzc;
    }
}
