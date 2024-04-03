package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    /* access modifiers changed from: private */
    @NotNull
    public final Object[] buffer;
    /* access modifiers changed from: private */
    public final int capacity;
    private int size;
    /* access modifiers changed from: private */
    public int startIndex;

    public RingBuffer(@NotNull Object[] objArr, int i11) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.buffer = objArr;
        boolean z11 = true;
        if (i11 >= 0) {
            if (i11 > objArr.length ? false : z11) {
                this.capacity = objArr.length;
                this.size = i11;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i11 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i11).toString());
    }

    private final int forward(int i11, int i12) {
        return (i11 + i12) % this.capacity;
    }

    public final void add(T t11) {
        if (!isFull()) {
            this.buffer[(this.startIndex + size()) % this.capacity] = t11;
            this.size = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    @NotNull
    public final RingBuffer<T> expanded(int i11) {
        Object[] objArr;
        int i12 = this.capacity;
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i12 + (i12 >> 1) + 1, i11);
        if (this.startIndex == 0) {
            objArr = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(objArr, size());
    }

    public T get(int i11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, size());
        return this.buffer[(this.startIndex + i11) % this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new RingBuffer$iterator$1(this);
    }

    public final void removeFirst(int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i11 > size()) {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i11 + ", size = " + size()).toString());
            } else if (i11 > 0) {
                int i12 = this.startIndex;
                int access$getCapacity$p = (i12 + i11) % this.capacity;
                if (i12 > access$getCapacity$p) {
                    ArraysKt___ArraysJvmKt.fill((T[]) this.buffer, null, i12, this.capacity);
                    ArraysKt___ArraysJvmKt.fill((T[]) this.buffer, null, 0, access$getCapacity$p);
                } else {
                    ArraysKt___ArraysJvmKt.fill((T[]) this.buffer, null, i12, access$getCapacity$p);
                }
                this.startIndex = access$getCapacity$p;
                this.size = size() - i11;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i11).toString());
        }
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOf(this, newSize)");
        }
        int size2 = size();
        int i11 = this.startIndex;
        int i12 = 0;
        int i13 = 0;
        while (i13 < size2 && i11 < this.capacity) {
            tArr[i13] = this.buffer[i11];
            i13++;
            i11++;
        }
        while (i13 < size2) {
            tArr[i13] = this.buffer[i12];
            i13++;
            i12++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return tArr;
    }

    public RingBuffer(int i11) {
        this(new Object[i11], 0);
    }

    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
