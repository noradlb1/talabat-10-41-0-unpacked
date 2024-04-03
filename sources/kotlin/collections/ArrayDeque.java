package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int defaultMinCapacity = 10;
    @NotNull
    private static final Object[] emptyElementData = new Object[0];
    private static final int maxArraySize = 2147483639;
    @NotNull
    private Object[] elementData;
    private int head;
    private int size;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int i11, int i12) {
            int i13 = i11 + (i11 >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            if (i13 - ArrayDeque.maxArraySize <= 0) {
                return i13;
            }
            if (i12 > ArrayDeque.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return ArrayDeque.maxArraySize;
        }
    }

    public ArrayDeque(int i11) {
        Object[] objArr;
        if (i11 == 0) {
            objArr = emptyElementData;
        } else if (i11 > 0) {
            objArr = new Object[i11];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i11);
        }
        this.elementData = objArr;
    }

    private final void copyCollectionElements(int i11, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (i11 < length && it.hasNext()) {
            this.elementData[i11] = it.next();
            i11++;
        }
        int i12 = this.head;
        for (int i13 = 0; i13 < i12 && it.hasNext(); i13++) {
            this.elementData[i13] = it.next();
        }
        this.size = size() + collection.size();
    }

    private final void copyElements(int i11) {
        Object[] objArr = new Object[i11];
        Object[] objArr2 = this.elementData;
        Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i12 = this.head;
        Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr3, (T[]) objArr, length - i12, 0, i12);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int i11) {
        return i11 == 0 ? ArraysKt___ArraysKt.getLastIndex((T[]) this.elementData) : i11 - 1;
    }

    private final void ensureCapacity(int i11) {
        if (i11 >= 0) {
            Object[] objArr = this.elementData;
            if (i11 > objArr.length) {
                if (objArr == emptyElementData) {
                    this.elementData = new Object[RangesKt___RangesKt.coerceAtLeast(i11, 10)];
                } else {
                    copyElements(Companion.newCapacity$kotlin_stdlib(objArr.length, i11));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean filterInPlace(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x00a0
            java.lang.Object[] r0 = r11.elementData
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x000f
            r0 = r2
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            if (r0 == 0) goto L_0x0014
            goto L_0x00a0
        L_0x0014:
            int r0 = r11.head
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.positiveMod(r0)
            int r3 = r11.head
            r4 = 0
            if (r3 >= r0) goto L_0x0049
            r5 = r3
        L_0x0025:
            if (r3 >= r0) goto L_0x0043
            java.lang.Object[] r6 = r11.elementData
            r6 = r6[r3]
            java.lang.Object r7 = r12.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x003f
            java.lang.Object[] r7 = r11.elementData
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x0043:
            java.lang.Object[] r12 = r11.elementData
            kotlin.collections.ArraysKt___ArraysJvmKt.fill((T[]) r12, r4, (int) r5, (int) r0)
            goto L_0x0095
        L_0x0049:
            java.lang.Object[] r5 = r11.elementData
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x004e:
            if (r3 >= r5) goto L_0x006e
            java.lang.Object[] r8 = r11.elementData
            r9 = r8[r3]
            r8[r3] = r4
            java.lang.Object r8 = r12.invoke(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x006a
            java.lang.Object[] r8 = r11.elementData
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x006b
        L_0x006a:
            r7 = r2
        L_0x006b:
            int r3 = r3 + 1
            goto L_0x004e
        L_0x006e:
            int r3 = r11.positiveMod(r6)
            r5 = r3
        L_0x0073:
            if (r1 >= r0) goto L_0x0094
            java.lang.Object[] r3 = r11.elementData
            r6 = r3[r1]
            r3[r1] = r4
            java.lang.Object r3 = r12.invoke(r6)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0090
            java.lang.Object[] r3 = r11.elementData
            r3[r5] = r6
            int r5 = r11.incremented(r5)
            goto L_0x0091
        L_0x0090:
            r7 = r2
        L_0x0091:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x0094:
            r1 = r7
        L_0x0095:
            if (r1 == 0) goto L_0x00a0
            int r12 = r11.head
            int r5 = r5 - r12
            int r12 = r11.negativeMod(r5)
            r11.size = r12
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.filterInPlace(kotlin.jvm.functions.Function1):boolean");
    }

    private final int incremented(int i11) {
        if (i11 == ArraysKt___ArraysKt.getLastIndex((T[]) this.elementData)) {
            return 0;
        }
        return i11 + 1;
    }

    @InlineOnly
    private final E internalGet(int i11) {
        return this.elementData[i11];
    }

    @InlineOnly
    private final int internalIndex(int i11) {
        return positiveMod(this.head + i11);
    }

    private final int negativeMod(int i11) {
        return i11 < 0 ? i11 + this.elementData.length : i11;
    }

    private final int positiveMod(int i11) {
        Object[] objArr = this.elementData;
        return i11 >= objArr.length ? i11 - objArr.length : i11;
    }

    public boolean add(E e11) {
        addLast(e11);
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + collection.size());
        copyCollectionElements(positiveMod(this.head + size()), collection);
        return true;
    }

    public final void addFirst(E e11) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = e11;
        this.size = size() + 1;
    }

    public final void addLast(E e11) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e11;
        this.size = size() + 1;
    }

    public void clear() {
        int positiveMod = positiveMod(this.head + size());
        int i11 = this.head;
        if (i11 < positiveMod) {
            ArraysKt___ArraysJvmKt.fill((T[]) this.elementData, null, i11, positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.fill((T[]) objArr, null, this.head, objArr.length);
            ArraysKt___ArraysJvmKt.fill((T[]) this.elementData, null, 0, positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (!isEmpty()) {
            return this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.head];
    }

    public E get(int i11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, size());
        return this.elementData[positiveMod(this.head + i11)];
    }

    public int getSize() {
        return this.size;
    }

    public int indexOf(Object obj) {
        int i11;
        int positiveMod = positiveMod(this.head + size());
        int i12 = this.head;
        if (i12 < positiveMod) {
            while (i12 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[i12])) {
                    i11 = this.head;
                } else {
                    i12++;
                }
            }
            return -1;
        } else if (i12 < positiveMod) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (true) {
                if (i12 >= length) {
                    int i13 = 0;
                    while (i13 < positiveMod) {
                        if (Intrinsics.areEqual(obj, this.elementData[i13])) {
                            i12 = i13 + this.elementData.length;
                            i11 = this.head;
                        } else {
                            i13++;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.elementData[i12])) {
                    i11 = this.head;
                    break;
                } else {
                    i12++;
                }
            }
        }
        return i12 - i11;
    }

    public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> function2) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(function2, "structure");
        int positiveMod = positiveMod(this.head + size());
        if (isEmpty() || (i12 = this.head) < positiveMod) {
            i11 = this.head;
        } else {
            i11 = i12 - this.elementData.length;
        }
        function2.invoke(Integer.valueOf(i11), toArray());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (!isEmpty()) {
            return this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object obj) {
        int i11;
        int i12;
        int positiveMod = positiveMod(this.head + size());
        int i13 = this.head;
        if (i13 < positiveMod) {
            i11 = positiveMod - 1;
            if (i13 <= i11) {
                while (!Intrinsics.areEqual(obj, this.elementData[i11])) {
                    if (i11 != i13) {
                        i11--;
                    }
                }
                i12 = this.head;
            }
            return -1;
        }
        if (i13 > positiveMod) {
            int i14 = positiveMod - 1;
            while (true) {
                if (-1 >= i14) {
                    int lastIndex = ArraysKt___ArraysKt.getLastIndex((T[]) this.elementData);
                    int i15 = this.head;
                    if (i15 <= lastIndex) {
                        while (!Intrinsics.areEqual(obj, this.elementData[i11])) {
                            if (i11 != i15) {
                                lastIndex = i11 - 1;
                            }
                        }
                        i12 = this.head;
                    }
                } else if (Intrinsics.areEqual(obj, this.elementData[i14])) {
                    i11 = i14 + this.elementData.length;
                    i12 = this.head;
                    break;
                } else {
                    i14--;
                }
            }
        }
        return -1;
        return i11 - i12;
    }

    @Nullable
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0096
            java.lang.Object[] r0 = r11.elementData
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0096
        L_0x0019:
            int r0 = r11.head
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.positiveMod(r0)
            int r3 = r11.head
            r4 = 0
            if (r3 >= r0) goto L_0x0049
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0043
            java.lang.Object[] r6 = r11.elementData
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003f
            java.lang.Object[] r7 = r11.elementData
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0043:
            java.lang.Object[] r12 = r11.elementData
            kotlin.collections.ArraysKt___ArraysJvmKt.fill((T[]) r12, r4, (int) r5, (int) r0)
            goto L_0x008b
        L_0x0049:
            java.lang.Object[] r5 = r11.elementData
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x004e:
            if (r3 >= r5) goto L_0x0069
            java.lang.Object[] r8 = r11.elementData
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0065
            java.lang.Object[] r8 = r11.elementData
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0066
        L_0x0065:
            r7 = r2
        L_0x0066:
            int r3 = r3 + 1
            goto L_0x004e
        L_0x0069:
            int r3 = r11.positiveMod(r6)
            r5 = r3
        L_0x006e:
            if (r1 >= r0) goto L_0x008a
            java.lang.Object[] r3 = r11.elementData
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0086
            java.lang.Object[] r3 = r11.elementData
            r3[r5] = r6
            int r5 = r11.incremented(r5)
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x006e
        L_0x008a:
            r1 = r7
        L_0x008b:
            if (r1 == 0) goto L_0x0096
            int r12 = r11.head
            int r5 = r5 - r12
            int r12 = r11.negativeMod(r5)
            r11.size = r12
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    public E removeAt(int i11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, size());
        if (i11 == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i11 == 0) {
            return removeFirst();
        }
        int positiveMod = positiveMod(this.head + i11);
        E e11 = this.elementData[positiveMod];
        if (i11 < (size() >> 1)) {
            int i12 = this.head;
            if (positiveMod >= i12) {
                Object[] objArr = this.elementData;
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i12 + 1, i12, positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) objArr2, 1, 0, positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i13 = this.head;
                Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr3, (T[]) objArr3, i13 + 1, i13, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i14 = this.head;
            objArr4[i14] = null;
            this.head = incremented(i14);
        } else {
            int positiveMod2 = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
            if (positiveMod <= positiveMod2) {
                Object[] objArr5 = this.elementData;
                Object[] unused4 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr5, (T[]) objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                Object[] unused5 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr6, (T[]) objArr6, positiveMod, positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                Object[] unused6 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e11;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.elementData;
            int i11 = this.head;
            E e11 = eArr[i11];
            eArr[i11] = null;
            this.head = incremented(i11);
            this.size = size() - 1;
            return e11;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int positiveMod = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
            E[] eArr = this.elementData;
            E e11 = eArr[positiveMod];
            eArr[positiveMod] = null;
            this.size = size() - 1;
            return e11;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0093
            java.lang.Object[] r0 = r11.elementData
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0093
        L_0x0019:
            int r0 = r11.head
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.positiveMod(r0)
            int r3 = r11.head
            r4 = 0
            if (r3 >= r0) goto L_0x0048
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0042
            java.lang.Object[] r6 = r11.elementData
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x003e
            java.lang.Object[] r7 = r11.elementData
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0042:
            java.lang.Object[] r12 = r11.elementData
            kotlin.collections.ArraysKt___ArraysJvmKt.fill((T[]) r12, r4, (int) r5, (int) r0)
            goto L_0x0088
        L_0x0048:
            java.lang.Object[] r5 = r11.elementData
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x004d:
            if (r3 >= r5) goto L_0x0067
            java.lang.Object[] r8 = r11.elementData
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x0063
            java.lang.Object[] r8 = r11.elementData
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0064
        L_0x0063:
            r7 = r2
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0067:
            int r3 = r11.positiveMod(r6)
            r5 = r3
        L_0x006c:
            if (r1 >= r0) goto L_0x0087
            java.lang.Object[] r3 = r11.elementData
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x0083
            java.lang.Object[] r3 = r11.elementData
            r3[r5] = r6
            int r5 = r11.incremented(r5)
            goto L_0x0084
        L_0x0083:
            r7 = r2
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x006c
        L_0x0087:
            r1 = r7
        L_0x0088:
            if (r1 == 0) goto L_0x0093
            int r12 = r11.head
            int r5 = r5 - r12
            int r12 = r11.negativeMod(r5)
            r11.size = r12
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    public E set(int i11, E e11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i11, size());
        int positiveMod = positiveMod(this.head + i11);
        E[] eArr = this.elementData;
        E e12 = eArr[positiveMod];
        eArr[positiveMod] = e11;
        return e12;
    }

    @NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return toArray(tArr);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = ArraysKt__ArraysJVMKt.arrayOfNulls(tArr, size());
        }
        Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int positiveMod = positiveMod(this.head + size());
        int i11 = this.head;
        if (i11 < positiveMod) {
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, (Object[]) tArr, 0, i11, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, tArr, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, tArr, objArr2.length - this.head, 0, positiveMod);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public void add(int i11, E e11) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i11, size());
        if (i11 == size()) {
            addLast(e11);
        } else if (i11 == 0) {
            addFirst(e11);
        } else {
            ensureCapacity(size() + 1);
            int positiveMod = positiveMod(this.head + i11);
            if (i11 < ((size() + 1) >> 1)) {
                int decremented = decremented(positiveMod);
                int decremented2 = decremented(this.head);
                int i12 = this.head;
                if (decremented >= i12) {
                    Object[] objArr = this.elementData;
                    objArr[decremented2] = objArr[i12];
                    Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i12, i12 + 1, decremented + 1);
                } else {
                    Object[] objArr2 = this.elementData;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) objArr2, i12 - 1, i12, objArr2.length);
                    Object[] objArr3 = this.elementData;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr3, (T[]) objArr3, 0, 1, decremented + 1);
                }
                this.elementData[decremented] = e11;
                this.head = decremented2;
            } else {
                int positiveMod2 = positiveMod(this.head + size());
                if (positiveMod < positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    Object[] unused4 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr4, (T[]) objArr4, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    Object[] objArr5 = this.elementData;
                    Object[] unused5 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr5, (T[]) objArr5, 1, 0, positiveMod2);
                    Object[] objArr6 = this.elementData;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    Object[] unused6 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr6, (T[]) objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
                }
                this.elementData[positiveMod] = e11;
            }
            this.size = size() + 1;
        }
    }

    @NotNull
    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public boolean addAll(int i11, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i11, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i11 == size()) {
            return addAll(collection);
        }
        ensureCapacity(size() + collection.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + i11);
        int size2 = collection.size();
        if (i11 < ((size() + 1) >> 1)) {
            int i12 = this.head;
            int i13 = i12 - size2;
            if (positiveMod2 < i12) {
                Object[] objArr = this.elementData;
                Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i13, i12, objArr.length);
                if (size2 >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr2, (T[]) objArr2, objArr2.length - size2, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    Object[] unused3 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr3, (T[]) objArr3, objArr3.length - size2, 0, size2);
                    Object[] objArr4 = this.elementData;
                    Object[] unused4 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr4, (T[]) objArr4, 0, size2, positiveMod2);
                }
            } else if (i13 >= 0) {
                Object[] objArr5 = this.elementData;
                Object[] unused5 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr5, (T[]) objArr5, i13, i12, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i13 += objArr6.length;
                int i14 = positiveMod2 - i12;
                int length = objArr6.length - i13;
                if (length >= i14) {
                    Object[] unused6 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr6, (T[]) objArr6, i13, i12, positiveMod2);
                } else {
                    Object[] unused7 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr6, (T[]) objArr6, i13, i12, i12 + length);
                    Object[] objArr7 = this.elementData;
                    Object[] unused8 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i13;
            copyCollectionElements(negativeMod(positiveMod2 - size2), collection);
        } else {
            int i15 = positiveMod2 + size2;
            if (positiveMod2 < positiveMod) {
                int i16 = size2 + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i16 <= objArr8.length) {
                    Object[] unused9 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr8, (T[]) objArr8, i15, positiveMod2, positiveMod);
                } else if (i15 >= objArr8.length) {
                    Object[] unused10 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr8, (T[]) objArr8, i15 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i16 - objArr8.length);
                    Object[] unused11 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr8, (T[]) objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    Object[] unused12 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr9, (T[]) objArr9, i15, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                Object[] unused13 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr10, (T[]) objArr10, size2, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i15 >= objArr11.length) {
                    Object[] unused14 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr11, (T[]) objArr11, i15 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    Object[] unused15 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr11, (T[]) objArr11, 0, objArr11.length - size2, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    Object[] unused16 = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr12, (T[]) objArr12, i15, positiveMod2, objArr12.length - size2);
                }
            }
            copyCollectionElements(positiveMod2, collection);
        }
        return true;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean z11 = false;
        Object[] array = collection.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0 ? true : z11) {
            this.elementData = emptyElementData;
        }
    }

    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
