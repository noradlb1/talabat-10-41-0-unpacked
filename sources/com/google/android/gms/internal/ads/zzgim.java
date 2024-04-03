package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgim;
import com.google.android.gms.internal.ads.zzgin;

public abstract class zzgim<MessageType extends zzgin<MessageType, BuilderType>, BuilderType extends zzgim<MessageType, BuilderType>> implements zzglu {
    /* renamed from: zzab */
    public abstract BuilderType clone();

    public abstract BuilderType zzac(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzglu zzad(zzglv zzglv) {
        if (zzbp().getClass().isInstance(zzglv)) {
            return zzac((zzgin) zzglv);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
