package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.DoNotCall;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzaj implements Iterator, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
