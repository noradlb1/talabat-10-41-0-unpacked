package androidx.compose.runtime.snapshots;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SubList$listIterator$1", "", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SubList$listIterator$1 implements ListIterator<T>, KMutableListIterator, Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f9548b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubList<T> f9549c;

    public SubList$listIterator$1(Ref.IntRef intRef, SubList<T> subList) {
        this.f9548b = intRef;
        this.f9549c = subList;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.f9548b.element < this.f9549c.size() - 1;
    }

    public boolean hasPrevious() {
        return this.f9548b.element >= 0;
    }

    public T next() {
        int i11 = this.f9548b.element + 1;
        SnapshotStateListKt.validateRange(i11, this.f9549c.size());
        this.f9548b.element = i11;
        return this.f9549c.get(i11);
    }

    public int nextIndex() {
        return this.f9548b.element + 1;
    }

    public T previous() {
        int i11 = this.f9548b.element;
        SnapshotStateListKt.validateRange(i11, this.f9549c.size());
        this.f9548b.element = i11 - 1;
        return this.f9549c.get(i11);
    }

    public int previousIndex() {
        return this.f9548b.element;
    }

    @NotNull
    public Void add(T t11) {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void remove() {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void set(T t11) {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }
}
