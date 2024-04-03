package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzbr;
import com.google.android.gms.internal.icing.zzbs;

public abstract class zzbr<MessageType extends zzbs<MessageType, BuilderType>, BuilderType extends zzbr<MessageType, BuilderType>> implements zzed {
    /* renamed from: zzd */
    public abstract BuilderType clone();

    public abstract BuilderType zze(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzed zzf(zzee zzee) {
        if (zzm().getClass().isInstance(zzee)) {
            return zze((zzbs) zzee);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
