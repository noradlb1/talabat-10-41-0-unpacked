package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/core/util/LongSparseArrayKt$keyIterator$1", "Lkotlin/collections/LongIterator;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "nextLong", "", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongSparseArray<T> f11443b;
    private int index;

    public LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.f11443b = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean hasNext() {
        return this.index < this.f11443b.size();
    }

    @SuppressLint({"ClassVerificationFailure"})
    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.f11443b;
        int i11 = this.index;
        this.index = i11 + 1;
        return longSparseArray.keyAt(i11);
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }
}
