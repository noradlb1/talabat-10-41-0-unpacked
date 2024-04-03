package kotlin.collections.builders;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    /* access modifiers changed from: private */
    @NotNull
    public E[] array;
    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public int length;
    /* access modifiers changed from: private */
    public int offset;
    @Nullable
    private final ListBuilder<E> root;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator, Iterator {
        private int index;
        private int lastIndex = -1;
        @NotNull
        private final ListBuilder<E> list;

        public Itr(@NotNull ListBuilder<E> listBuilder, int i11) {
            Intrinsics.checkNotNullParameter(listBuilder, DefaultCardView.CARD_LIST);
            this.list = listBuilder;
            this.index = i11;
        }

        public void add(E e11) {
            ListBuilder<E> listBuilder = this.list;
            int i11 = this.index;
            this.index = i11 + 1;
            listBuilder.add(i11, e11);
            this.lastIndex = -1;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.index < this.list.length;
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public E next() {
            if (this.index < this.list.length) {
                int i11 = this.index;
                this.index = i11 + 1;
                this.lastIndex = i11;
                return this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i11 = this.index;
            if (i11 > 0) {
                int i12 = i11 - 1;
                this.index = i12;
                this.lastIndex = i12;
                return this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            boolean z11;
            int i11 = this.lastIndex;
            if (i11 != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.list.remove(i11);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(E e11) {
            boolean z11;
            int i11 = this.lastIndex;
            if (i11 != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.list.set(i11, e11);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i11, int i12, boolean z11, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i11;
        this.length = i12;
        this.isReadOnly = z11;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i11, Collection<? extends E> collection, int i12) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i11, collection, i12);
            this.array = this.backing.array;
            this.length += i12;
            return;
        }
        insertAtInternal(i11, i12);
        java.util.Iterator<? extends E> it = collection.iterator();
        for (int i13 = 0; i13 < i12; i13++) {
            this.array[i11 + i13] = it.next();
        }
    }

    private final void addAtInternal(int i11, E e11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i11, e11);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i11, 1);
        this.array[i11] = e11;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, list);
    }

    private final void ensureCapacity(int i11) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (i11 >= 0) {
            E[] eArr = this.array;
            if (i11 > eArr.length) {
                this.array = ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.Companion.newCapacity$kotlin_stdlib(eArr.length, i11));
            }
        } else {
            throw new OutOfMemoryError();
        }
    }

    private final void ensureExtraCapacity(int i11) {
        ensureCapacity(this.length + i11);
    }

    private final void insertAtInternal(int i11, int i12) {
        ensureExtraCapacity(i12);
        E[] eArr = this.array;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) eArr, (T[]) eArr, i11 + i12, i11, this.offset + this.length);
        this.length += i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.root;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isEffectivelyReadOnly() {
        /*
            r1 = this;
            boolean r0 = r1.isReadOnly
            if (r0 != 0) goto L_0x000f
            kotlin.collections.builders.ListBuilder<E> r0 = r1.root
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isReadOnly
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.isEffectivelyReadOnly():boolean");
    }

    private final E removeAtInternal(int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i11);
        }
        E[] eArr = this.array;
        E e11 = eArr[i11];
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) eArr, (T[]) eArr, i11, i11 + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e11;
    }

    private final void removeRangeInternal(int i11, int i12) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i11, i12);
        } else {
            E[] eArr = this.array;
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) eArr, (T[]) eArr, i11, i11 + i12, this.length);
            E[] eArr2 = this.array;
            int i13 = this.length;
            ListBuilderKt.resetRange(eArr2, i13 - i12, i13);
        }
        this.length -= i12;
    }

    private final int retainOrRemoveAllInternal(int i11, int i12, Collection<? extends E> collection, boolean z11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i11, i12, collection, z11);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int i15 = i11 + i13;
            if (collection.contains(this.array[i15]) == z11) {
                E[] eArr = this.array;
                i13++;
                eArr[i14 + i11] = eArr[i15];
                i14++;
            } else {
                i13++;
            }
        }
        int i16 = i12 - i14;
        E[] eArr2 = this.array;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) eArr2, (T[]) eArr2, i11 + i14, i12 + i11, this.length);
        E[] eArr3 = this.array;
        int i17 = this.length;
        ListBuilderKt.resetRange(eArr3, i17 - i16, i17);
        this.length -= i16;
        return i16;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public boolean add(E e11) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e11);
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.offset + this.length, collection, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    public E get(int i11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, this.length);
        return this.array[this.offset + i11];
    }

    public int getSize() {
        return this.length;
    }

    public int hashCode() {
        return ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
    }

    public int indexOf(Object obj) {
        for (int i11 = 0; i11 < this.length; i11++) {
            if (Intrinsics.areEqual((Object) this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @NotNull
    public java.util.Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    public int lastIndexOf(Object obj) {
        for (int i11 = this.length - 1; i11 >= 0; i11--) {
            if (Intrinsics.areEqual((Object) this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public E removeAt(int i11) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, this.length);
        return removeAtInternal(this.offset + i11);
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public E set(int i11, E e11) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset;
        E e12 = eArr[i12 + i11];
        eArr[i12 + i11] = e11;
        return e12;
    }

    @NotNull
    public List<E> subList(int i11, int i12) {
        ListBuilder<E> listBuilder;
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i11, i12, this.length);
        E[] eArr = this.array;
        int i13 = this.offset + i11;
        int i14 = i12 - i11;
        boolean z11 = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i13, i14, z11, this, listBuilder);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "destination");
        int length2 = tArr.length;
        int i11 = this.length;
        if (length2 < i11) {
            E[] eArr = this.array;
            int i12 = this.offset;
            T[] copyOfRange = Arrays.copyOfRange(eArr, i12, i11 + i12, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return copyOfRange;
        }
        E[] eArr2 = this.array;
        Intrinsics.checkNotNull(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i13 = this.offset;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) eArr2, tArr, 0, i13, this.length + i13);
        int length3 = tArr.length;
        int i14 = this.length;
        if (length3 > i14) {
            tArr[i14] = null;
        }
        return tArr;
    }

    @NotNull
    public String toString() {
        return ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length);
    }

    @NotNull
    public ListIterator<E> listIterator(int i11) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i11, this.length);
        return new Itr(this, i11);
    }

    public void add(int i11, E e11) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i11, this.length);
        addAtInternal(this.offset + i11, e11);
    }

    public boolean addAll(int i11, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i11, this.length);
        int size = collection.size();
        addAllInternal(this.offset + i11, collection, size);
        return size > 0;
    }

    @NotNull
    public Object[] toArray() {
        E[] eArr = this.array;
        int i11 = this.offset;
        Object[] copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange((T[]) eArr, i11, this.length + i11);
        Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return copyOfRange;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i11) {
        this(ListBuilderKt.arrayOfUninitializedElements(i11), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }
}
