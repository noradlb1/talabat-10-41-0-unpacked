package androidx.compose.ui.node;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002=>B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0018\u0010\u001b\u001a\u00020\u001cH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0014J)\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'¢\u0006\u0002\u0010(J1\u0010)\u001a\u00020\u00112\u0006\u0010$\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0014H\u0016J\u0016\u00100\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0014J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0002J\u0015\u00103\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000052\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u00106\u001a\u00020\u0011H\u0002J\u001a\u00107\u001a\u00020\u00112\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110'H\bø\u0001\u0003J1\u00109\u001a\u00020\u00112\u0006\u0010$\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'¢\u0006\u0002\u0010,J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u0016\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006?"}, d2 = {"Landroidx/compose/ui/node/HitTestResult;", "T", "", "()V", "distanceFromEdgeAndInLayer", "", "hitDepth", "", "<set-?>", "size", "getSize", "()I", "values", "", "", "[Ljava/lang/Object;", "acceptHits", "", "clear", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "ensureContainerSize", "findBestHitDistance", "Landroidx/compose/ui/node/DistanceAndInLayer;", "findBestHitDistance-ptXAw2c", "()J", "get", "index", "(I)Ljava/lang/Object;", "hasHit", "hit", "node", "isInLayer", "childHitTest", "Lkotlin/Function0;", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "hitInMinimumTouchTarget", "distanceFromEdge", "", "(Ljava/lang/Object;FZLkotlin/jvm/functions/Function0;)V", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "isHitInMinimumTouchTargetBetter", "iterator", "", "lastIndexOf", "listIterator", "", "resizeToHitDepth", "siblingHits", "block", "speculativeHit", "subList", "fromIndex", "toIndex", "HitTestResultIterator", "SubList", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HitTestResult<T> implements List<T>, KMappedMarker, j$.util.List {
    @NotNull
    private long[] distanceFromEdgeAndInLayer = new long[16];
    /* access modifiers changed from: private */
    public int hitDepth = -1;
    private int size;
    /* access modifiers changed from: private */
    @NotNull
    public Object[] values = new Object[16];

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007¨\u0006 "}, d2 = {"Landroidx/compose/ui/node/HitTestResult$SubList;", "", "minIndex", "", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;II)V", "getMaxIndex", "()I", "getMinIndex", "size", "getSize", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class SubList implements List<T>, KMappedMarker, j$.util.List {
        private final int maxIndex;
        private final int minIndex;

        public SubList(int i11, int i12) {
            this.minIndex = i11;
            this.maxIndex = i12;
        }

        public void add(int i11, T t11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean add(T t11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(int i11, Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(Object obj) {
            return indexOf(obj) != -1;
        }

        public boolean containsAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        public T get(int i11) {
            return HitTestResult.this.values[i11 + this.minIndex];
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        public int indexOf(Object obj) {
            int i11 = this.minIndex;
            int i12 = this.maxIndex;
            if (i11 > i12) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i11], obj)) {
                if (i11 == i12) {
                    return -1;
                }
                i11++;
            }
            return i11 - this.minIndex;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        @NotNull
        public Iterator<T> iterator() {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i11 = this.minIndex;
            return new HitTestResultIterator(i11, i11, this.maxIndex);
        }

        public int lastIndexOf(Object obj) {
            int i11 = this.maxIndex;
            int i12 = this.minIndex;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i11], obj)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.minIndex;
        }

        @NotNull
        public ListIterator<T> listIterator() {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i11 = this.minIndex;
            return new HitTestResultIterator(i11, i11, this.maxIndex);
        }

        public T remove(int i11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf(Predicate.VivifiedWrapper.convert(predicate));
        }

        public void replaceAll(UnaryOperator<T> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
            replaceAll(UnaryOperator.VivifiedWrapper.convert(unaryOperator));
        }

        public boolean retainAll(java.util.Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public T set(int i11, T t11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public void sort(Comparator<? super T> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @NotNull
        public List<T> subList(int i11, int i12) {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i13 = this.minIndex;
            return new SubList(i11 + i13, i13 + i12);
        }

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        @NotNull
        public ListIterator<T> listIterator(int i11) {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i12 = this.minIndex;
            return new HitTestResultIterator(i11 + i12, i12, this.maxIndex);
        }
    }

    private final void ensureContainerSize() {
        int i11 = this.hitDepth;
        Object[] objArr = this.values;
        if (i11 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.values = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.distanceFromEdgeAndInLayer, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = copyOf2;
        }
    }

    /* renamed from: findBestHitDistance-ptXAw2c  reason: not valid java name */
    private final long m4605findBestHitDistanceptXAw2c() {
        long access$DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int i11 = this.hitDepth + 1;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i11 <= lastIndex) {
            while (true) {
                long r42 = DistanceAndInLayer.m4597constructorimpl(this.distanceFromEdgeAndInLayer[i11]);
                if (DistanceAndInLayer.m4596compareToS_HNhKs(r42, access$DistanceAndInLayer) < 0) {
                    access$DistanceAndInLayer = r42;
                }
                if (DistanceAndInLayer.m4600getDistanceimpl(access$DistanceAndInLayer) >= 0.0f || !DistanceAndInLayer.m4602isInLayerimpl(access$DistanceAndInLayer)) {
                    if (i11 == lastIndex) {
                        break;
                    }
                    i11++;
                } else {
                    return access$DistanceAndInLayer;
                }
            }
        }
        return access$DistanceAndInLayer;
    }

    private final void resizeToHitDepth() {
        int i11 = this.hitDepth + 1;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i11 <= lastIndex) {
            while (true) {
                this.values[i11] = null;
                if (i11 == lastIndex) {
                    break;
                }
                i11++;
            }
        }
        this.size = this.hitDepth + 1;
    }

    public final void acceptHits() {
        this.hitDepth = size() - 1;
    }

    public void add(int i11, T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, java.util.Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(java.util.Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(@NotNull java.util.Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public T get(int i11) {
        return this.values[i11];
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasHit() {
        long r02 = m4605findBestHitDistanceptXAw2c();
        if (DistanceAndInLayer.m4600getDistanceimpl(r02) >= 0.0f || !DistanceAndInLayer.m4602isInLayerimpl(r02)) {
            return false;
        }
        return true;
    }

    public final void hit(T t11, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "childHitTest");
        hitInMinimumTouchTarget(t11, -1.0f, z11, function0);
    }

    public final void hitInMinimumTouchTarget(T t11, float f11, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "childHitTest");
        int i11 = this.hitDepth;
        this.hitDepth = i11 + 1;
        ensureContainerSize();
        Object[] objArr = this.values;
        int i12 = this.hitDepth;
        objArr[i12] = t11;
        this.distanceFromEdgeAndInLayer[i12] = HitTestResultKt.DistanceAndInLayer(f11, z11);
        resizeToHitDepth();
        function0.invoke();
        this.hitDepth = i11;
    }

    public int indexOf(Object obj) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (lastIndex < 0) {
            return -1;
        }
        int i11 = 0;
        while (!Intrinsics.areEqual(this.values[i11], obj)) {
            if (i11 == lastIndex) {
                return -1;
            }
            i11++;
        }
        return i11;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isHitInMinimumTouchTargetBetter(float f11, boolean z11) {
        if (this.hitDepth == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return true;
        }
        if (DistanceAndInLayer.m4596compareToS_HNhKs(m4605findBestHitDistanceptXAw2c(), HitTestResultKt.DistanceAndInLayer(f11, z11)) > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public int lastIndexOf(Object obj) {
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(this.values[lastIndex], obj)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<T> listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public T remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
        replaceAll(UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T set(int i11, T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void siblingHits(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        int access$getHitDepth$p = this.hitDepth;
        function0.invoke();
        this.hitDepth = access$getHitDepth$p;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void speculativeHit(T t11, float f11, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "childHitTest");
        if (this.hitDepth == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            hitInMinimumTouchTarget(t11, f11, z11, function0);
            if (this.hitDepth + 1 == CollectionsKt__CollectionsKt.getLastIndex(this)) {
                resizeToHitDepth();
                return;
            }
            return;
        }
        long r02 = m4605findBestHitDistanceptXAw2c();
        int i11 = this.hitDepth;
        this.hitDepth = CollectionsKt__CollectionsKt.getLastIndex(this);
        hitInMinimumTouchTarget(t11, f11, z11, function0);
        if (this.hitDepth + 1 < CollectionsKt__CollectionsKt.getLastIndex(this) && DistanceAndInLayer.m4596compareToS_HNhKs(r02, m4605findBestHitDistanceptXAw2c()) > 0) {
            int i12 = this.hitDepth + 1;
            int i13 = i11 + 1;
            Object[] objArr = this.values;
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto((T[]) objArr, (T[]) objArr, i13, i12, size());
            long[] jArr = this.distanceFromEdgeAndInLayer;
            long[] unused2 = ArraysKt___ArraysJvmKt.copyInto(jArr, jArr, i13, i12, size());
            this.hitDepth = ((size() + i11) - this.hitDepth) - 1;
        }
        resizeToHitDepth();
        this.hitDepth = i11;
    }

    @NotNull
    public List<T> subList(int i11, int i12) {
        return new SubList(i11, i12);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    @NotNull
    public ListIterator<T> listIterator(int i11) {
        return new HitTestResultIterator(this, i11, 0, 0, 6, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\r\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/HitTestResult$HitTestResultIterator;", "", "index", "", "minIndex", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;III)V", "getIndex", "()I", "setIndex", "(I)V", "getMaxIndex", "getMinIndex", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class HitTestResultIterator implements ListIterator<T>, KMappedMarker, j$.util.Iterator {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        public HitTestResultIterator(int i11, int i12, int i13) {
            this.index = i11;
            this.minIndex = i12;
            this.maxIndex = i13;
        }

        public void add(T t11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public boolean hasNext() {
            return this.index < this.maxIndex;
        }

        public boolean hasPrevious() {
            return this.index > this.minIndex;
        }

        public T next() {
            T[] access$getValues$p = HitTestResult.this.values;
            int i11 = this.index;
            this.index = i11 + 1;
            return access$getValues$p[i11];
        }

        public int nextIndex() {
            return this.index - this.minIndex;
        }

        public T previous() {
            T[] access$getValues$p = HitTestResult.this.values;
            int i11 = this.index - 1;
            this.index = i11;
            return access$getValues$p[i11];
        }

        public int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(T t11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i11) {
            this.index = i11;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this((i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? 0 : i12, (i14 & 4) != 0 ? hitTestResult.size() : i13);
        }
    }
}
