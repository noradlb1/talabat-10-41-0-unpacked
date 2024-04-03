package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkh;
import com.google.android.gms.internal.ads.zzgkl;
import java.io.IOException;

public class zzgkh<MessageType extends zzgkl<MessageType, BuilderType>, BuilderType extends zzgkh<MessageType, BuilderType>> extends zzgim<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    public zzgkh(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzgkl) messagetype.zzb(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzgmd.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    public final /* synthetic */ zzgim zzac(zzgin zzgin) {
        zzaf((zzgkl) zzgin);
        return this;
    }

    /* renamed from: zzae */
    public final BuilderType zzab() {
        BuilderType buildertype = (zzgkh) this.zzc.zzb(5, (Object) null, (Object) null);
        buildertype.zzaf(zzaj());
        return buildertype;
    }

    public final BuilderType zzaf(MessageType messagetype) {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzag(byte[] bArr, int i11, int i12, zzgjx zzgjx) throws zzgkx {
        if (this.zzb) {
            zzal();
            this.zzb = false;
        }
        try {
            zzgmd.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i12, new zzgiq(zzgjx));
            return this;
        } catch (zzgkx e11) {
            throw e11;
        } catch (IndexOutOfBoundsException unused) {
            throw zzgkx.zzj();
        } catch (IOException e12) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
        }
    }

    public final MessageType zzah() {
        MessageType zzai = zzaj();
        if (zzai.zzaM()) {
            return zzai;
        }
        throw new zzgne(zzai);
    }

    /* renamed from: zzai */
    public MessageType zzaj() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzgmd.zza().zzb(messagetype.getClass()).zzf(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public void zzal() {
        MessageType messagetype = (zzgkl) this.zza.zzb(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    public final /* synthetic */ zzglv zzbp() {
        return this.zzc;
    }
}
