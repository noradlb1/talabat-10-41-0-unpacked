package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzaai;
import com.google.android.libraries.places.internal.zzaaj;

public abstract class zzaai<MessageType extends zzaaj<MessageType, BuilderType>, BuilderType extends zzaai<MessageType, BuilderType>> implements zzacy {
    /* renamed from: zzo */
    public abstract BuilderType clone();

    public abstract BuilderType zzp(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzacy zzq(zzacz zzacz) {
        if (zzw().getClass().isInstance(zzacz)) {
            return zzp((zzaaj) zzacz);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
