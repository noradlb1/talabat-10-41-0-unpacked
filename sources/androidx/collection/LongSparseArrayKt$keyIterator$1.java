package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/LongSparseArrayKt$keyIterator$1", "Lkotlin/collections/LongIterator;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "nextLong", "", "collection-ktx"}, k = 1, mv = {1, 1, 13})
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongSparseArray f1026b;
    private int index;

    public LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.f1026b = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.f1026b.size();
    }

    public long nextLong() {
        LongSparseArray longSparseArray = this.f1026b;
        int i11 = this.index;
        this.index = i11 + 1;
        return longSparseArray.keyAt(i11);
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }
}
