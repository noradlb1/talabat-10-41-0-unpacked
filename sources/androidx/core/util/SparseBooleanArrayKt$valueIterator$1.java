package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"androidx/core/util/SparseBooleanArrayKt$valueIterator$1", "Lkotlin/collections/BooleanIterator;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "nextBoolean", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SparseBooleanArray f11452b;
    private int index;

    public SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.f11452b = sparseBooleanArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.f11452b.size();
    }

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.f11452b;
        int i11 = this.index;
        this.index = i11 + 1;
        return sparseBooleanArray.valueAt(i11);
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }
}
