package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private Object zac;

    public SingleRefDataBufferIterator(@NonNull DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @NonNull
    public final Object next() {
        if (hasNext()) {
            int i11 = this.zab + 1;
            this.zab = i11;
            if (i11 == 0) {
                Object checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
                this.zac = checkNotNull;
                if (!(checkNotNull instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(checkNotNull.getClass());
                    throw new IllegalStateException("DataBuffer reference of type " + valueOf + " is not movable");
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
            }
            return this.zac;
        }
        int i12 = this.zab;
        throw new NoSuchElementException("Cannot advance the iterator beyond " + i12);
    }
}
