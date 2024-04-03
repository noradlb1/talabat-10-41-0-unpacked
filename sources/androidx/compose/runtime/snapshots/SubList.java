package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0012H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00060"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", "T", "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "modification", "offset", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SubList<T> implements List<T>, KMutableList {
    private int modification;
    private final int offset;
    @NotNull
    private final SnapshotStateList<T> parentList;
    private int size;

    public SubList(@NotNull SnapshotStateList<T> snapshotStateList, int i11, int i12) {
        Intrinsics.checkNotNullParameter(snapshotStateList, "parentList");
        this.parentList = snapshotStateList;
        this.offset = i11;
        this.modification = snapshotStateList.getModification$runtime_release();
        this.size = i12 - i11;
    }

    private final void validateModification() {
        if (this.parentList.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean add(T t11) {
        validateModification();
        this.parentList.add(this.offset + size(), t11);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
        return true;
    }

    public boolean addAll(int i11, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        validateModification();
        boolean addAll = this.parentList.addAll(i11 + this.offset, collection);
        if (addAll) {
            this.size = size() + collection.size();
            this.modification = this.parentList.getModification$runtime_release();
        }
        return addAll;
    }

    public void clear() {
        if (size() > 0) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i11 = this.offset;
            snapshotStateList.removeRange(i11, size() + i11);
            this.size = 0;
            this.modification = this.parentList.getModification$runtime_release();
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public T get(int i11) {
        validateModification();
        SnapshotStateListKt.validateRange(i11, size());
        return this.parentList.get(this.offset + i11);
    }

    @NotNull
    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    public int indexOf(Object obj) {
        validateModification();
        int i11 = this.offset;
        Iterator it = RangesKt___RangesKt.until(i11, size() + i11).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(obj, (Object) this.parentList.get(nextInt))) {
                return nextInt - this.offset;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        validateModification();
        int size2 = this.offset + size();
        while (true) {
            size2--;
            if (size2 < this.offset) {
                return -1;
            }
            if (Intrinsics.areEqual(obj, (Object) this.parentList.get(size2))) {
                return size2 - this.offset;
            }
        }
    }

    @NotNull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public final /* bridge */ T remove(int i11) {
        return removeAt(i11);
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            boolean z11 = false;
            while (true) {
                if (!it.hasNext()) {
                    return z11;
                }
                if (remove((Object) it.next()) || z11) {
                    z11 = true;
                }
            }
        }
    }

    public T removeAt(int i11) {
        validateModification();
        T remove = this.parentList.remove(this.offset + i11);
        this.size = size() - 1;
        this.modification = this.parentList.getModification$runtime_release();
        return remove;
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i11 = this.offset;
        int retainAllInRange$runtime_release = snapshotStateList.retainAllInRange$runtime_release(collection, i11, size() + i11);
        if (retainAllInRange$runtime_release > 0) {
            this.modification = this.parentList.getModification$runtime_release();
            this.size = size() - retainAllInRange$runtime_release;
        }
        if (retainAllInRange$runtime_release > 0) {
            return true;
        }
        return false;
    }

    public T set(int i11, T t11) {
        SnapshotStateListKt.validateRange(i11, size());
        validateModification();
        T t12 = this.parentList.set(i11 + this.offset, t11);
        this.modification = this.parentList.getModification$runtime_release();
        return t12;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public List<T> subList(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 < 0 || i11 > i12) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || i12 > size()) {
            z12 = false;
        }
        if (z12) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i13 = this.offset;
            return new SubList(snapshotStateList, i11 + i13, i12 + i13);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    @NotNull
    public ListIterator<T> listIterator(int i11) {
        validateModification();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11 - 1;
        return new SubList$listIterator$1(intRef, this);
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public void add(int i11, T t11) {
        validateModification();
        this.parentList.add(this.offset + i11, t11);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
    }

    public boolean addAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return addAll(size(), collection);
    }
}
