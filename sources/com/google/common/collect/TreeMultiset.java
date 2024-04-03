package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final transient AvlNode<E> header;
    /* access modifiers changed from: private */
    public final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* renamed from: com.google.common.collect.TreeMultiset$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.collect.BoundType[] r0 = com.google.common.collect.BoundType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$common$collect$BoundType = r0
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$common$collect$BoundType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.AnonymousClass4.<clinit>():void");
        }
    }

    public enum Aggregate {
        SIZE {
            public int nodeAggregate(AvlNode<?> avlNode) {
                return avlNode.elemCount;
            }

            public long treeAggregate(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.totalCount;
            }
        },
        DISTINCT {
            public int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            public long treeAggregate(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return (long) avlNode.distinctElements;
            }
        };

        public abstract int nodeAggregate(AvlNode<?> avlNode);

        public abstract long treeAggregate(@CheckForNull AvlNode<?> avlNode);
    }

    public static final class Reference<T> {
        @CheckForNull
        private T value;

        private Reference() {
        }

        public void checkAndSet(@CheckForNull T t11, @CheckForNull T t12) {
            if (this.value == t11) {
                this.value = t12;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void clear() {
            this.value = null;
        }

        @CheckForNull
        public T get() {
            return this.value;
        }
    }

    public TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.comparator());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    private long aggregateAboveRange(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateAboveRange;
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint()), avlNode.getElement());
        if (compare > 0) {
            return aggregateAboveRange(aggregate, avlNode.right);
        }
        if (compare == 0) {
            int i11 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
            if (i11 == 1) {
                treeAggregate = (long) aggregate.nodeAggregate(avlNode);
                aggregateAboveRange = aggregate.treeAggregate(avlNode.right);
            } else if (i11 == 2) {
                return aggregate.treeAggregate(avlNode.right);
            } else {
                throw new AssertionError();
            }
        } else {
            treeAggregate = aggregate.treeAggregate(avlNode.right) + ((long) aggregate.nodeAggregate(avlNode));
            aggregateAboveRange = aggregateAboveRange(aggregate, avlNode.left);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateBelowRange;
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint()), avlNode.getElement());
        if (compare < 0) {
            return aggregateBelowRange(aggregate, avlNode.left);
        }
        if (compare == 0) {
            int i11 = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
            if (i11 == 1) {
                treeAggregate = (long) aggregate.nodeAggregate(avlNode);
                aggregateBelowRange = aggregate.treeAggregate(avlNode.left);
            } else if (i11 == 2) {
                return aggregate.treeAggregate(avlNode.left);
            } else {
                throw new AssertionError();
            }
        } else {
            treeAggregate = aggregate.treeAggregate(avlNode.left) + ((long) aggregate.nodeAggregate(avlNode));
            aggregateBelowRange = aggregateBelowRange(aggregate, avlNode.right);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        AvlNode avlNode = this.rootReference.get();
        long treeAggregate = aggregate.treeAggregate(avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, avlNode);
        }
        if (this.range.hasUpperBound()) {
            return treeAggregate - aggregateAboveRange(aggregate, avlNode);
        }
        return treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> firstNode() {
        AvlNode<E> avlNode;
        AvlNode avlNode2 = this.rootReference.get();
        if (avlNode2 == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint());
            avlNode = avlNode2.ceiling(comparator(), uncheckedCastNullableTToT);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(uncheckedCastNullableTToT, avlNode.getElement()) == 0) {
                avlNode = avlNode.succ();
            }
        } else {
            avlNode = this.header.succ();
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> lastNode() {
        AvlNode<E> avlNode;
        AvlNode avlNode2 = this.rootReference.get();
        if (avlNode2 == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint());
            avlNode = avlNode2.floor(comparator(), uncheckedCastNullableTToT);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(uncheckedCastNullableTToT, avlNode.getElement()) == 0) {
                avlNode = avlNode.pred();
            }
        } else {
            avlNode = this.header.pred();
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, (Object) comparator);
        Class<TreeMultiset> cls = TreeMultiset.class;
        Serialization.getFieldSetter(cls, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE).set(this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(cls, "rootReference").set(this, (Object) new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.getFieldSetter(cls, "header").set(this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset(this, objectInputStream);
    }

    /* access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        AvlNode unused = avlNode.succ = avlNode2;
        AvlNode unused2 = avlNode2.pred = avlNode;
    }

    /* access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() {
            public int getCount() {
                int count = avlNode.getCount();
                if (count == 0) {
                    return TreeMultiset.this.count(getElement());
                }
                return count;
            }

            @ParametricNullness
            public E getElement() {
                return avlNode.getElement();
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public int add(@ParametricNullness E e11, int i11) {
        CollectPreconditions.checkNonnegative(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        Preconditions.checkArgument(this.range.contains(e11));
        AvlNode avlNode = this.rootReference.get();
        if (avlNode == null) {
            comparator().compare(e11, e11);
            AvlNode avlNode2 = new AvlNode(e11, i11);
            AvlNode<E> avlNode3 = this.header;
            successor(avlNode3, avlNode2, avlNode3);
            this.rootReference.checkAndSet(avlNode, avlNode2);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.add(comparator(), e11, i11, iArr));
        return iArr[0];
    }

    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> access$700 = this.header.succ();
        while (true) {
            AvlNode<E> avlNode = this.header;
            if (access$700 != avlNode) {
                AvlNode<E> access$7002 = access$700.succ();
                int unused = access$700.elemCount = 0;
                AvlNode unused2 = access$700.left = null;
                AvlNode unused3 = access$700.right = null;
                AvlNode unused4 = access$700.pred = null;
                AvlNode unused5 = access$700.succ = null;
                access$700 = access$7002;
            } else {
                successor(avlNode, avlNode);
                this.rootReference.clear();
                return;
            }
        }
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    public int count(@CheckForNull Object obj) {
        try {
            AvlNode avlNode = this.rootReference.get();
            if (this.range.contains(obj)) {
                if (avlNode != null) {
                    return avlNode.count(comparator(), obj);
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Object() {
            @CheckForNull
            AvlNode<E> current;
            @CheckForNull
            Multiset.Entry<E> prevEntry = null;

            {
                this.current = TreeMultiset.this.lastNode();
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public void remove() {
                boolean z11;
                if (this.prevEntry != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkState(z11, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Objects.requireNonNull(this.current);
                    Multiset.Entry<E> access$1500 = TreeMultiset.this.wrapEntry(this.current);
                    this.prevEntry = access$1500;
                    if (this.current.pred() == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.pred();
                    }
                    return access$1500;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    public int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    public java.util.Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
        return new Object() {
            @CheckForNull
            AvlNode<E> current;
            @CheckForNull
            Multiset.Entry<E> prevEntry;

            {
                this.current = TreeMultiset.this.firstNode();
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public void remove() {
                boolean z11;
                if (this.prevEntry != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkState(z11, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    TreeMultiset treeMultiset = TreeMultiset.this;
                    AvlNode<E> avlNode = this.current;
                    Objects.requireNonNull(avlNode);
                    Multiset.Entry<E> access$1500 = treeMultiset.wrapEntry(avlNode);
                    this.prevEntry = access$1500;
                    if (this.current.succ() == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.succ();
                    }
                    return access$1500;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    public SortedMultiset<E> headMultiset(@ParametricNullness E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e11, boundType)), this.header);
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public java.util.Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i11) {
        CollectPreconditions.checkNonnegative(i11, "occurrences");
        if (i11 == 0) {
            return count(obj);
        }
        AvlNode avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj)) {
                if (avlNode != null) {
                    this.rootReference.checkAndSet(avlNode, avlNode.remove(comparator(), obj, i11, iArr));
                    return iArr[0];
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public int setCount(@ParametricNullness E e11, int i11) {
        CollectPreconditions.checkNonnegative(i11, "count");
        boolean z11 = true;
        if (!this.range.contains(e11)) {
            if (i11 != 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            return 0;
        }
        AvlNode avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (i11 > 0) {
                add(e11, i11);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e11, i11, iArr));
        return iArr[0];
    }

    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    public SortedMultiset<E> tailMultiset(@ParametricNullness E e11, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e11, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static int distinctElements(@CheckForNull AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return avlNode.distinctElements;
    }

    /* access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        AvlNode<E> avlNode = new AvlNode<>();
        this.header = avlNode;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@ParametricNullness E e11, int i11, int i12) {
        CollectPreconditions.checkNonnegative(i12, "newCount");
        CollectPreconditions.checkNonnegative(i11, "oldCount");
        Preconditions.checkArgument(this.range.contains(e11));
        AvlNode avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e11, i11, i12, iArr));
            if (iArr[0] == i11) {
                return true;
            }
            return false;
        } else if (i11 != 0) {
            return false;
        } else {
            if (i12 > 0) {
                add(e11, i12);
            }
            return true;
        }
    }

    public static final class AvlNode<E> {
        /* access modifiers changed from: private */
        public int distinctElements;
        @CheckForNull
        private final E elem;
        /* access modifiers changed from: private */
        public int elemCount;
        private int height;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> left;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> pred;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> right;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> succ;
        /* access modifiers changed from: private */
        public long totalCount;

        public AvlNode(@ParametricNullness E e11, int i11) {
            Preconditions.checkArgument(i11 > 0);
            this.elem = e11;
            this.elemCount = i11;
            this.totalCount = (long) i11;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        private AvlNode<E> addLeftChild(@ParametricNullness E e11, int i11) {
            this.left = new AvlNode<>(e11, i11);
            TreeMultiset.successor(pred(), this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) i11;
            return this;
        }

        private AvlNode<E> addRightChild(@ParametricNullness E e11, int i11) {
            AvlNode<E> avlNode = new AvlNode<>(e11, i11);
            this.right = avlNode;
            TreeMultiset.successor(this, avlNode, succ());
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) i11;
            return this;
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> ceiling(Comparator<? super E> comparator, @ParametricNullness E e11) {
            int compare = comparator.compare(e11, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return this;
                }
                return (AvlNode) MoreObjects.firstNonNull(avlNode.ceiling(comparator, e11), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.ceiling(comparator, e11);
            }
        }

        @CheckForNull
        private AvlNode<E> deleteMe() {
            int i11 = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(pred(), succ());
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                AvlNode pred2 = pred();
                pred2.left = this.left.removeMax(pred2);
                pred2.right = this.right;
                pred2.distinctElements = this.distinctElements - 1;
                pred2.totalCount = this.totalCount - ((long) i11);
                return pred2.rebalance();
            }
            AvlNode succ2 = succ();
            succ2.right = this.right.removeMin(succ2);
            succ2.left = this.left;
            succ2.distinctElements = this.distinctElements - 1;
            succ2.totalCount = this.totalCount - ((long) i11);
            return succ2.rebalance();
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> floor(Comparator<? super E> comparator, @ParametricNullness E e11) {
            int compare = comparator.compare(e11, getElement());
            if (compare > 0) {
                AvlNode<E> avlNode = this.right;
                if (avlNode == null) {
                    return this;
                }
                return (AvlNode) MoreObjects.firstNonNull(avlNode.floor(comparator, e11), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.left;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.floor(comparator, e11);
            }
        }

        private static int height(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.height;
        }

        /* access modifiers changed from: private */
        public AvlNode<E> pred() {
            AvlNode<E> avlNode = this.pred;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor == -2) {
                Objects.requireNonNull(this.right);
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return rotateLeft();
            } else if (balanceFactor != 2) {
                recomputeHeight();
                return this;
            } else {
                Objects.requireNonNull(this.left);
                if (this.left.balanceFactor() < 0) {
                    this.left = this.left.rotateLeft();
                }
                return rotateRight();
            }
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = ((long) this.elemCount) + totalCount(this.left) + totalCount(this.right);
        }

        @CheckForNull
        private AvlNode<E> removeMax(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return this.left;
            }
            this.right = avlNode2.removeMax(avlNode);
            this.distinctElements--;
            this.totalCount -= (long) avlNode.elemCount;
            return rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMin(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return this.right;
            }
            this.left = avlNode2.removeMin(avlNode);
            this.distinctElements--;
            this.totalCount -= (long) avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> rotateLeft() {
            boolean z11;
            if (this.right != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            boolean z11;
            if (this.left != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        /* access modifiers changed from: private */
        public AvlNode<E> succ() {
            AvlNode<E> avlNode = this.succ;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private static long totalCount(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.totalCount;
        }

        public AvlNode<E> add(Comparator<? super E> comparator, @ParametricNullness E e11, int i11, int[] iArr) {
            int compare = comparator.compare(e11, getElement());
            boolean z11 = true;
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return addLeftChild(e11, i11);
                }
                int i12 = avlNode.height;
                AvlNode<E> add = avlNode.add(comparator, e11, i11, iArr);
                this.left = add;
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) i11;
                if (add.height == i12) {
                    return this;
                }
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return addRightChild(e11, i11);
                }
                int i13 = avlNode2.height;
                AvlNode<E> add2 = avlNode2.add(comparator, e11, i11, iArr);
                this.right = add2;
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) i11;
                if (add2.height == i13) {
                    return this;
                }
                return rebalance();
            } else {
                int i14 = this.elemCount;
                iArr[0] = i14;
                long j11 = (long) i11;
                if (((long) i14) + j11 > 2147483647L) {
                    z11 = false;
                }
                Preconditions.checkArgument(z11);
                this.elemCount += i11;
                this.totalCount += j11;
                return this;
            }
        }

        public int count(Comparator<? super E> comparator, @ParametricNullness E e11) {
            int compare = comparator.compare(e11, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(comparator, e11);
            } else if (compare <= 0) {
                return this.elemCount;
            } else {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    return 0;
                }
                return avlNode2.count(comparator, e11);
            }
        }

        public int getCount() {
            return this.elemCount;
        }

        @ParametricNullness
        public E getElement() {
            return NullnessCasts.uncheckedCastNullableTToT(this.elem);
        }

        @CheckForNull
        public AvlNode<E> remove(Comparator<? super E> comparator, @ParametricNullness E e11, int i11, int[] iArr) {
            int compare = comparator.compare(e11, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.left = avlNode.remove(comparator, e11, i11, iArr);
                int i12 = iArr[0];
                if (i12 > 0) {
                    if (i11 >= i12) {
                        this.distinctElements--;
                        this.totalCount -= (long) i12;
                    } else {
                        this.totalCount -= (long) i11;
                    }
                }
                if (i12 == 0) {
                    return this;
                }
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.right = avlNode2.remove(comparator, e11, i11, iArr);
                int i13 = iArr[0];
                if (i13 > 0) {
                    if (i11 >= i13) {
                        this.distinctElements--;
                        this.totalCount -= (long) i13;
                    } else {
                        this.totalCount -= (long) i11;
                    }
                }
                return rebalance();
            } else {
                int i14 = this.elemCount;
                iArr[0] = i14;
                if (i11 >= i14) {
                    return deleteMe();
                }
                this.elemCount = i14 - i11;
                this.totalCount -= (long) i11;
                return this;
            }
        }

        @CheckForNull
        public AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e11, int i11, int[] iArr) {
            int compare = comparator.compare(e11, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i11 > 0 ? addLeftChild(e11, i11) : this;
                }
                this.left = avlNode.setCount(comparator, e11, i11, iArr);
                if (i11 == 0 && iArr[0] != 0) {
                    this.distinctElements--;
                } else if (i11 > 0 && iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (i11 - iArr[0]);
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return i11 > 0 ? addRightChild(e11, i11) : this;
                }
                this.right = avlNode2.setCount(comparator, e11, i11, iArr);
                if (i11 == 0 && iArr[0] != 0) {
                    this.distinctElements--;
                } else if (i11 > 0 && iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (i11 - iArr[0]);
                return rebalance();
            } else {
                int i12 = this.elemCount;
                iArr[0] = i12;
                if (i11 == 0) {
                    return deleteMe();
                }
                this.totalCount += (long) (i11 - i12);
                this.elemCount = i11;
                return this;
            }
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }

        public AvlNode() {
            this.elem = null;
            this.elemCount = 1;
        }

        @CheckForNull
        public AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e11, int i11, int i12, int[] iArr) {
            int compare = comparator.compare(e11, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i11 != 0 || i12 <= 0) ? this : addLeftChild(e11, i12);
                }
                this.left = avlNode.setCount(comparator, e11, i11, i12, iArr);
                int i13 = iArr[0];
                if (i13 == i11) {
                    if (i12 == 0 && i13 != 0) {
                        this.distinctElements--;
                    } else if (i12 > 0 && i13 == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (i12 - i13);
                }
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return (i11 != 0 || i12 <= 0) ? this : addRightChild(e11, i12);
                }
                this.right = avlNode2.setCount(comparator, e11, i11, i12, iArr);
                int i14 = iArr[0];
                if (i14 == i11) {
                    if (i12 == 0 && i14 != 0) {
                        this.distinctElements--;
                    } else if (i12 > 0 && i14 == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (i12 - i14);
                }
                return rebalance();
            } else {
                int i15 = this.elemCount;
                iArr[0] = i15;
                if (i11 == i15) {
                    if (i12 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += (long) (i12 - i15);
                    this.elemCount = i12;
                }
                return this;
            }
        }
    }
}
