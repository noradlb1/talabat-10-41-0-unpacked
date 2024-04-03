package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzd  reason: invalid package */
abstract class zzd implements Iterator, j$.util.Iterator {
    @CheckForNull
    private Object zza;
    private int zzb = 2;

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        int i11 = this.zzb;
        if (i11 != 4) {
            int i12 = i11 - 1;
            if (i11 == 0) {
                throw null;
            } else if (i12 == 0) {
                return true;
            } else {
                if (i12 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public abstract Object zza();

    @CheckForNull
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
