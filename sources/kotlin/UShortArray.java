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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0001\u0007\u0001\u00020\bø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", "get", "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    @NotNull
    private final short[] storage;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000ø\u0001\u0001\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "array", "", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker, j$.util.Iterator {
        @NotNull
        private final short[] array;
        private int index;

        public Iterator(@NotNull short[] sArr) {
            Intrinsics.checkNotNullParameter(sArr, "array");
            this.array = sArr;
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
            return UShort.m6601boximpl(m6674nextMh2AYeg());
        }

        /* renamed from: next-Mh2AYeg  reason: not valid java name */
        public short m6674nextMh2AYeg() {
            int i11 = this.index;
            short[] sArr = this.array;
            if (i11 < sArr.length) {
                this.index = i11 + 1;
                return UShort.m6607constructorimpl(sArr[i11]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UShortArray(short[] sArr) {
        this.storage = sArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShortArray m6657boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m6658constructorimpl(int i11) {
        return m6659constructorimpl(new short[i11]);
    }

    @NotNull
    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m6659constructorimpl(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m6661containsAllimpl(short[] sArr, @NotNull Collection<UShort> collection) {
        boolean z11;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object next : iterable) {
            if (!(next instanceof UShort) || !ArraysKt___ArraysKt.contains(sArr, ((UShort) next).m6656unboximpl())) {
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
    public static boolean m6662equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual((Object) sArr, (Object) ((UShortArray) obj).m6673unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6663equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual((Object) sArr, (Object) sArr2);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public static final short m6664getMh2AYeg(short[] sArr, int i11) {
        return UShort.m6607constructorimpl(sArr[i11]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m6665getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6666hashCodeimpl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m6667isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UShort> m6668iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    /* renamed from: set-01HTLdE  reason: not valid java name */
    public static final void m6669set01HTLdE(short[] sArr, int i11, short s11) {
        sArr[i11] = s11;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6670toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw  reason: not valid java name */
    public boolean m6671addxj2QHRw(short s11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return m6672containsxj2QHRw(((UShort) obj).m6656unboximpl());
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m6672containsxj2QHRw(short s11) {
        return m6660containsxj2QHRw(this.storage, s11);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m6661containsAllimpl(this.storage, collection);
    }

    public boolean equals(Object obj) {
        return m6662equalsimpl(this.storage, obj);
    }

    /* renamed from: getSize */
    public int size() {
        return m6665getSizeimpl(this.storage);
    }

    public int hashCode() {
        return m6666hashCodeimpl(this.storage);
    }

    public boolean isEmpty() {
        return m6667isEmptyimpl(this.storage);
    }

    @NotNull
    public java.util.Iterator<UShort> iterator() {
        return m6668iteratorimpl(this.storage);
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
        return m6670toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short[] m6673unboximpl() {
        return this.storage;
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public static boolean m6660containsxj2QHRw(short[] sArr, short s11) {
        return ArraysKt___ArraysKt.contains(sArr, s11);
    }
}
