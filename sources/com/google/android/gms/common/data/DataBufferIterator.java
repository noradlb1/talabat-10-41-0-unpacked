package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T>, j$.util.Iterator {
    @NonNull
    protected final DataBuffer zaa;
    protected int zab = -1;

    public DataBufferIterator(@NonNull DataBuffer dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zab < this.zaa.getCount() + -1;
    }

    @NonNull
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zaa;
            int i11 = this.zab + 1;
            this.zab = i11;
            return dataBuffer.get(i11);
        }
        int i12 = this.zab;
        throw new NoSuchElementException("Cannot advance the iterator beyond " + i12);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
