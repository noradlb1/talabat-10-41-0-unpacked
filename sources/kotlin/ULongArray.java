package kotlin;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@ExperimentalUnsignedTypes
@JvmInline
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0001\u0007\u0001\u00020\bø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    @NotNull
    private final long[] storage;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000ø\u0001\u0001\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker, j$.util.Iterator {
        @NotNull
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, "array");
            this.array = jArr;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return ULong.m6495boximpl(m6570nextsVKNKU());
        }

        /* renamed from: next-s-VKNKU  reason: not valid java name */
        public long m6570nextsVKNKU() {
            int i11 = this.index;
            long[] jArr = this.array;
            if (i11 < jArr.length) {
                this.index = i11 + 1;
                return ULong.m6501constructorimpl(jArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULongArray m6553boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m6554constructorimpl(int i11) {
        return m6555constructorimpl(new long[i11]);
    }

    @NotNull
    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m6555constructorimpl(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "storage");
        return jArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m6557containsAllimpl(long[] jArr, @NotNull Collection<ULong> collection) {
        boolean z11;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof ULong) || !ArraysKt___ArraysKt.contains(jArr, ((ULong) next).m6552unboximpl())) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (!z11) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6558equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual((Object) jArr, (Object) ((ULongArray) obj).m6569unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6559equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual((Object) jArr, (Object) jArr2);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m6560getsVKNKU(long[] jArr, int i11) {
        return ULong.m6501constructorimpl(jArr[i11]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m6561getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6562hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m6563isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<ULong> m6564iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m6565setk8EXiF4(long[] jArr, int i11, long j11) {
        jArr[i11] = j11;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6566toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public boolean m6567addVKZWuLQ(long j11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        return m6568containsVKZWuLQ(((ULong) obj).m6552unboximpl());
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m6568containsVKZWuLQ(long j11) {
        return m6556containsVKZWuLQ(this.storage, j11);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m6557containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m6558equalsimpl(this.storage, obj);
    }

    /* renamed from: getSize */
    public int size() {
        return m6561getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m6562hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m6563isEmptyimpl(this.storage);
    }

    @NotNull
    public java.util.Iterator<ULong> iterator() {
        return m6564iteratorimpl(this.storage);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m6566toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long[] m6569unboximpl() {
        return this.storage;
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m6556containsVKZWuLQ(long[] jArr, long j11) {
        return ArraysKt___ArraysKt.contains(jArr, j11);
    }
}
