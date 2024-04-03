package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import com.apptimize.c;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime_release", "checkPositionIndex", "checkPositionIndex$runtime_release", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime_release", "orderedEquals", "", "c", "", "other", "orderedEquals$runtime_release", "orderedHashCode", "orderedHashCode$runtime_release", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListImplementation {
    @NotNull
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    @JvmStatic
    public static final void checkElementIndex$runtime_release(int i11, int i12) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
        }
    }

    @JvmStatic
    public static final void checkPositionIndex$runtime_release(int i11, int i12) {
        if (i11 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
        }
    }

    @JvmStatic
    public static final void checkRangeIndexes$runtime_release(int i11, int i12, int i13) {
        if (i11 < 0 || i12 > i13) {
            throw new IndexOutOfBoundsException("fromIndex: " + i11 + ", toIndex: " + i12 + ", size: " + i13);
        } else if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex: " + i11 + " > toIndex: " + i12);
        }
    }

    @JvmStatic
    public static final boolean orderedEquals$runtime_release(@NotNull Collection<?> collection, @NotNull Collection<?> collection2) {
        Intrinsics.checkNotNullParameter(collection, c.f41585a);
        Intrinsics.checkNotNullParameter(collection2, "other");
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        for (Object areEqual : collection) {
            if (!Intrinsics.areEqual((Object) areEqual, (Object) it.next())) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final int orderedHashCode$runtime_release(@NotNull Collection<?> collection) {
        int i11;
        Intrinsics.checkNotNullParameter(collection, c.f41585a);
        int i12 = 1;
        for (Object next : collection) {
            int i13 = i12 * 31;
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 = i13 + i11;
        }
        return i12;
    }
}
