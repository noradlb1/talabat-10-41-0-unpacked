package androidx.compose.runtime.collection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\b¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u001a \u0010\u0010\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", "T", "capacity", "", "size", "init", "Lkotlin/Function1;", "mutableVectorOf", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "checkIndex", "", "", "index", "checkSubIndex", "fromIndex", "toIndex", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MutableVectorKt {
    public static /* synthetic */ MutableVector MutableVector$default(int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 16;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[i11], 0);
    }

    /* access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i11) {
        int size = list.size();
        if (i11 < 0 || i11 >= size) {
            throw new IndexOutOfBoundsException("Index " + i11 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i11, int i12) {
        int size = list.size();
        if (i11 > i12) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than 0.");
        } else if (i12 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is more than than the list size (" + size + ')');
        }
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int i11, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] objArr = new Object[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = function1.invoke(Integer.valueOf(i12));
        }
        return new MutableVector<>(objArr, i11);
    }
}
