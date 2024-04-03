package kotlin.reflect.jvm.internal.impl.utils;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SmartSet<T> extends AbstractSet<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private Object data;
    private int size;

    public static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator, j$.util.Iterator {
        @NotNull
        private final Iterator<T> arrayIterator;

        public ArrayIterator(@NotNull T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(tArr);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        public T next() {
            return this.arrayIterator.next();
        }

        @NotNull
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create() {
            return new SmartSet<>((DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create(@NotNull Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "set");
            SmartSet<T> smartSet = new SmartSet<>((DefaultConstructorMarker) null);
            smartSet.addAll(collection);
            return smartSet;
        }
    }

    public static final class SingletonIterator<T> implements java.util.Iterator<T>, KMutableIterator, j$.util.Iterator {
        private final T element;
        private boolean hasNext = true;

        public SingletonIterator(T t11) {
            this.element = t11;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            throw new NoSuchElementException();
        }

        @NotNull
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private SmartSet() {
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean add(T r5) {
        /*
            r4 = this;
            int r0 = r4.size()
            r1 = 1
            if (r0 != 0) goto L_0x000a
            r4.data = r5
            goto L_0x0078
        L_0x000a:
            int r0 = r4.size()
            r2 = 0
            if (r0 != r1) goto L_0x0026
            java.lang.Object r0 = r4.data
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Object r3 = r4.data
            r0[r2] = r3
            r0[r1] = r5
            r4.data = r0
            goto L_0x0078
        L_0x0026:
            int r0 = r4.size()
            r3 = 5
            if (r0 >= r3) goto L_0x0066
            java.lang.Object r0 = r4.data
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            boolean r3 = kotlin.collections.ArraysKt___ArraysKt.contains((T[]) r0, r5)
            if (r3 == 0) goto L_0x003d
            return r2
        L_0x003d:
            int r2 = r4.size()
            r3 = 4
            if (r2 != r3) goto L_0x0051
            int r2 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            java.util.LinkedHashSet r0 = kotlin.collections.SetsKt__SetsKt.linkedSetOf(r0)
            r0.add(r5)
            goto L_0x0063
        L_0x0051:
            int r2 = r4.size()
            int r2 = r2 + r1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            java.lang.String r2 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r0.length
            int r2 = r2 - r1
            r0[r2] = r5
        L_0x0063:
            r4.data = r0
            goto L_0x0078
        L_0x0066:
            java.lang.Object r0 = r4.data
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            java.util.Set r0 = kotlin.jvm.internal.TypeIntrinsics.asMutableSet(r0)
            boolean r5 = r0.add(r5)
            if (r5 != 0) goto L_0x0078
            return r2
        L_0x0078:
            int r5 = r4.size()
            int r5 = r5 + r1
            r4.setSize(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.utils.SmartSet.add(java.lang.Object):boolean");
    }

    public void clear() {
        this.data = null;
        setSize(0);
    }

    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return Intrinsics.areEqual(this.data, obj);
        }
        if (size() < 5) {
            Object obj2 = this.data;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ArraysKt___ArraysKt.contains((T[]) (Object[]) obj2, obj);
        }
        Object obj3 = this.data;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public java.util.Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new SingletonIterator(this.data);
        }
        if (size() < 5) {
            Object obj = this.data;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new ArrayIterator((Object[]) obj);
        }
        Object obj2 = this.data;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(obj2).iterator();
    }

    public void setSize(int i11) {
        this.size = i11;
    }

    public final /* bridge */ int size() {
        return getSize();
    }
}
