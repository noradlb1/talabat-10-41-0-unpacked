package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzeq;
import com.google.android.recaptcha.internal.zzer;

public abstract class zzeq<MessageType extends zzer<MessageType, BuilderType>, BuilderType extends zzeq<MessageType, BuilderType>> implements zzio {
    /* renamed from: zza */
    public abstract zzeq clone();

    public abstract zzeq zzb(zzer zzer);

    public final /* bridge */ /* synthetic */ zzio zzc(zzip zzip) {
        if (zzX().getClass().isInstance(zzip)) {
            return zzb((zzer) zzip);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
