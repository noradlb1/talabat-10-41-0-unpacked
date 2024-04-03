package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.android.gms.internal.p002firebaseauthapi.zzaha;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagw  reason: invalid package */
public class zzagw<MessageType extends zzaha<MessageType, BuilderType>, BuilderType extends zzagw<MessageType, BuilderType>> extends zzafe<MessageType, BuilderType> {
    protected zzaha zza;
    private final zzaha zzb;

    public zzagw(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzw();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzain.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final /* synthetic */ zzaif zzM() {
        throw null;
    }

    /* renamed from: zzg */
    public final zzagw zzf() {
        zzagw zzagw = (zzagw) this.zzb.zzj(5, (Object) null, (Object) null);
        zzagw.zza = zzk();
        return zzagw;
    }

    public final zzagw zzh(zzaha zzaha) {
        if (!this.zzb.equals(zzaha)) {
            if (!this.zza.zzL()) {
                zzn();
            }
            zza(this.zza, zzaha);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType zzj = zzk();
        if (zzj.zzK()) {
            return zzj;
        }
        throw new zzajk(zzj);
    }

    /* renamed from: zzj */
    public MessageType zzk() {
        if (!this.zza.zzL()) {
            return this.zza;
        }
        this.zza.zzF();
        return this.zza;
    }

    public final void zzm() {
        if (!this.zza.zzL()) {
            zzn();
        }
    }

    public void zzn() {
        zzaha zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
