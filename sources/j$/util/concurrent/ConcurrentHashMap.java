package j$.util.concurrent;

import j$.sun.misc.b;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0144b0;
import j$.util.function.C0157i;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.G;
import j$.util.function.IntFunction;
import j$.util.function.J0;
import j$.util.function.L0;
import j$.util.function.N0;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    private static final int ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    static final int RESERVED = -3;
    private static final int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final b U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient C0118d[] counterCells;
    private transient C0120f entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient E[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient E[] table;
    private volatile transient int transferIndex;
    private transient Q values;

    public static class KeySetView<K, V> extends C0117c implements Set<K>, j$.util.Set<K> {
        private static final long serialVersionUID = 7249069246763182397L;

        /* renamed from: b  reason: collision with root package name */
        private final Object f28624b;

        KeySetView(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
            this.f28624b = obj;
        }

        public final boolean add(Object obj) {
            Object obj2 = this.f28624b;
            if (obj2 != null) {
                return this.f28705a.putVal(obj, obj2, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            Object obj = this.f28624b;
            if (obj != null) {
                boolean z11 = false;
                for (Object putVal : collection) {
                    if (this.f28705a.putVal(putVal, obj, true) == null) {
                        z11 = true;
                    }
                }
                return z11;
            }
            throw new UnsupportedOperationException();
        }

        public final boolean contains(Object obj) {
            return this.f28705a.containsKey(obj);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r2 = (java.util.Set) r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r2 instanceof java.util.Set
                if (r0 == 0) goto L_0x0016
                java.util.Set r2 = (java.util.Set) r2
                if (r2 == r1) goto L_0x0014
                boolean r0 = r1.containsAll(r2)
                if (r0 == 0) goto L_0x0016
                boolean r2 = r2.containsAll(r1)
                if (r2 == 0) goto L_0x0016
            L_0x0014:
                r2 = 1
                goto L_0x0017
            L_0x0016:
                r2 = 0
            L_0x0017:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.KeySetView.equals(java.lang.Object):boolean");
        }

        public final void forEach(Consumer consumer) {
            consumer.getClass();
            E[] eArr = this.f28705a.table;
            if (eArr != null) {
                N n11 = new N(eArr, eArr.length, 0, eArr.length);
                while (true) {
                    E f11 = n11.f();
                    if (f11 != null) {
                        consumer.accept(f11.f28632b);
                    } else {
                        return;
                    }
                }
            }
        }

        public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final int hashCode() {
            Iterator it = iterator();
            int i11 = 0;
            while (it.hasNext()) {
                i11 += it.next().hashCode();
            }
            return i11;
        }

        public final Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.f28705a;
            E[] eArr = concurrentHashMap.table;
            int length = eArr == null ? 0 : eArr.length;
            return new C0126l(eArr, length, length, concurrentHashMap, 0);
        }

        public final boolean remove(Object obj) {
            return this.f28705a.remove(obj) != null;
        }

        public final /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf(Predicate.VivifiedWrapper.convert(predicate));
        }

        public final Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.f28705a;
            long sumCount = concurrentHashMap.sumCount();
            E[] eArr = concurrentHashMap.table;
            int length = eArr == null ? 0 : eArr.length;
            long j11 = 0;
            if (sumCount >= 0) {
                j11 = sumCount;
            }
            return new C0127m(eArr, length, 0, length, j11, 0);
        }

        public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.$default$toArray(this, intFunction);
        }

        public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", L[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        b h11 = b.h();
        U = h11;
        Class<ConcurrentHashMap> cls2 = ConcurrentHashMap.class;
        SIZECTL = h11.j(cls2, "sizeCtl");
        TRANSFERINDEX = h11.j(cls2, "transferIndex");
        BASECOUNT = h11.j(cls2, "baseCount");
        CELLSBUSY = h11.j(cls2, "cellsBusy");
        CELLVALUE = h11.j(C0118d.class, "value");
        Class<E[]> cls3 = E[].class;
        ABASE = h11.a(cls3);
        int b11 = h11.b(cls3);
        if (((b11 - 1) & b11) == 0) {
            ASHIFT = 31 - Integer.numberOfLeadingZeros(b11);
            return;
        }
        throw new ExceptionInInitializerError("array index scale not a power of two");
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i11) {
        this(i11, 0.75f, 1);
    }

    public ConcurrentHashMap(int i11, float f11) {
        this(i11, f11, 1);
    }

    public ConcurrentHashMap(int i11, float f11, int i12) {
        if (f11 <= 0.0f || i11 < 0 || i12 <= 0) {
            throw new IllegalArgumentException();
        }
        long j11 = (long) (((double) (((float) ((long) (i11 < i12 ? i12 : i11))) / f11)) + 1.0d);
        this.sizeCtl = j11 >= 1073741824 ? 1073741824 : tableSizeFor((int) j11);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r1.d(r11, r3, r5, r9) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addCount(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.d[] r0 = r11.counterCells
            if (r0 != 0) goto L_0x0014
            j$.sun.misc.b r1 = U
            long r3 = BASECOUNT
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.d(r2, r3, r5, r7)
            if (r1 != 0) goto L_0x003b
        L_0x0014:
            r1 = 1
            if (r0 == 0) goto L_0x0094
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L_0x0094
            int r3 = j$.util.concurrent.ThreadLocalRandom.b()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L_0x0094
            j$.sun.misc.b r3 = U
            long r5 = CELLVALUE
            long r7 = r4.value
            long r9 = r7 + r12
            boolean r0 = r3.d(r4, r5, r7, r9)
            if (r0 != 0) goto L_0x0034
            r1 = r0
            goto L_0x0094
        L_0x0034:
            if (r14 > r1) goto L_0x0037
            return
        L_0x0037:
            long r9 = r11.sumCount()
        L_0x003b:
            if (r14 < 0) goto L_0x0093
        L_0x003d:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r12 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r12 < 0) goto L_0x0093
            j$.util.concurrent.E[] r12 = r11.table
            if (r12 == 0) goto L_0x0093
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L_0x0093
            int r13 = resizeStamp(r13)
            if (r4 >= 0) goto L_0x007b
            int r14 = r4 >>> 16
            if (r14 != r13) goto L_0x0093
            int r14 = r13 + 1
            if (r4 == r14) goto L_0x0093
            r14 = 65535(0xffff, float:9.1834E-41)
            int r13 = r13 + r14
            if (r4 == r13) goto L_0x0093
            j$.util.concurrent.E[] r13 = r11.nextTable
            if (r13 == 0) goto L_0x0093
            int r14 = r11.transferIndex
            if (r14 > 0) goto L_0x006a
            goto L_0x0093
        L_0x006a:
            j$.sun.misc.b r0 = U
            long r2 = SIZECTL
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.c(r1, r2, r4, r5)
            if (r14 == 0) goto L_0x008e
            r11.transfer(r12, r13)
            goto L_0x008e
        L_0x007b:
            j$.sun.misc.b r0 = U
            long r2 = SIZECTL
            int r13 = r13 << 16
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.c(r1, r2, r4, r5)
            if (r13 == 0) goto L_0x008e
            r13 = 0
            r11.transfer(r12, r13)
        L_0x008e:
            long r9 = r11.sumCount()
            goto L_0x003d
        L_0x0093:
            return
        L_0x0094:
            r11.fullAddCount(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final <K, V> boolean casTabAt(E[] eArr, int i11, E e11, E e12) {
        return U.e(eArr, (((long) i11) << ASHIFT) + ((long) ABASE), e11, e12);
    }

    static Class<?> comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009d, code lost:
        if (r9.counterCells != r7) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009f, code lost:
        r9.counterCells = (j$.util.concurrent.C0118d[]) java.util.Arrays.copyOf(r7, r8 << 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x001b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fullAddCount(long r25, boolean r27) {
        /*
            r24 = this;
            r9 = r24
            r10 = r25
            int r0 = j$.util.concurrent.ThreadLocalRandom.b()
            r12 = 1
            if (r0 != 0) goto L_0x0015
            j$.util.concurrent.ThreadLocalRandom.f()
            int r0 = j$.util.concurrent.ThreadLocalRandom.b()
            r1 = r0
            r0 = r12
            goto L_0x0018
        L_0x0015:
            r1 = r0
            r0 = r27
        L_0x0018:
            r13 = 0
            r14 = r1
        L_0x001a:
            r15 = r13
        L_0x001b:
            j$.util.concurrent.d[] r7 = r9.counterCells
            if (r7 == 0) goto L_0x00b8
            int r8 = r7.length
            if (r8 <= 0) goto L_0x00b8
            int r1 = r8 + -1
            r1 = r1 & r14
            r1 = r7[r1]
            if (r1 != 0) goto L_0x0063
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x0061
            j$.util.concurrent.d r7 = new j$.util.concurrent.d
            r7.<init>(r10)
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x0061
            j$.sun.misc.b r1 = U
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r2 = r24
            boolean r1 = r1.c(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x0061
            j$.util.concurrent.d[] r1 = r9.counterCells     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0056
            int r2 = r1.length     // Catch:{ all -> 0x005d }
            if (r2 <= 0) goto L_0x0056
            int r2 = r2 + -1
            r2 = r2 & r14
            r3 = r1[r2]     // Catch:{ all -> 0x005d }
            if (r3 != 0) goto L_0x0056
            r1[r2] = r7     // Catch:{ all -> 0x005d }
            r1 = r12
            goto L_0x0057
        L_0x0056:
            r1 = r13
        L_0x0057:
            r9.cellsBusy = r13
            if (r1 == 0) goto L_0x001b
            goto L_0x00fc
        L_0x005d:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x0061:
            r15 = r13
            goto L_0x00b1
        L_0x0063:
            if (r0 != 0) goto L_0x0067
            r0 = r12
            goto L_0x00b1
        L_0x0067:
            j$.sun.misc.b r2 = U
            long r18 = CELLVALUE
            long r3 = r1.value
            long r22 = r3 + r10
            r16 = r2
            r17 = r1
            r20 = r3
            boolean r1 = r16.d(r17, r18, r20, r22)
            if (r1 == 0) goto L_0x007d
            goto L_0x00fc
        L_0x007d:
            j$.util.concurrent.d[] r1 = r9.counterCells
            if (r1 != r7) goto L_0x0061
            int r1 = NCPU
            if (r8 < r1) goto L_0x0086
            goto L_0x0061
        L_0x0086:
            if (r15 != 0) goto L_0x008a
            r15 = r12
            goto L_0x00b1
        L_0x008a:
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00b1
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r1 = r2
            r2 = r24
            boolean r1 = r1.c(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x00b1
            j$.util.concurrent.d[] r1 = r9.counterCells     // Catch:{ all -> 0x00ad }
            if (r1 != r7) goto L_0x00a9
            int r1 = r8 << 1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r7, r1)     // Catch:{ all -> 0x00ad }
            j$.util.concurrent.d[] r1 = (j$.util.concurrent.C0118d[]) r1     // Catch:{ all -> 0x00ad }
            r9.counterCells = r1     // Catch:{ all -> 0x00ad }
        L_0x00a9:
            r9.cellsBusy = r13
            goto L_0x001a
        L_0x00ad:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x00b1:
            int r1 = j$.util.concurrent.ThreadLocalRandom.a(r14)
            r14 = r1
            goto L_0x001b
        L_0x00b8:
            int r1 = r9.cellsBusy
            if (r1 != 0) goto L_0x00ec
            j$.util.concurrent.d[] r1 = r9.counterCells
            if (r1 != r7) goto L_0x00ec
            j$.sun.misc.b r1 = U
            long r3 = CELLSBUSY
            r5 = 0
            r6 = 1
            r2 = r24
            boolean r1 = r1.c(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x00ec
            j$.util.concurrent.d[] r1 = r9.counterCells     // Catch:{ all -> 0x00e8 }
            if (r1 != r7) goto L_0x00e2
            r1 = 2
            j$.util.concurrent.d[] r1 = new j$.util.concurrent.C0118d[r1]     // Catch:{ all -> 0x00e8 }
            r2 = r14 & 1
            j$.util.concurrent.d r3 = new j$.util.concurrent.d     // Catch:{ all -> 0x00e8 }
            r3.<init>(r10)     // Catch:{ all -> 0x00e8 }
            r1[r2] = r3     // Catch:{ all -> 0x00e8 }
            r9.counterCells = r1     // Catch:{ all -> 0x00e8 }
            r1 = r12
            goto L_0x00e3
        L_0x00e2:
            r1 = r13
        L_0x00e3:
            r9.cellsBusy = r13
            if (r1 == 0) goto L_0x001b
            goto L_0x00fc
        L_0x00e8:
            r0 = move-exception
            r9.cellsBusy = r13
            throw r0
        L_0x00ec:
            j$.sun.misc.b r1 = U
            long r3 = BASECOUNT
            long r5 = r9.baseCount
            long r7 = r5 + r10
            r2 = r24
            boolean r1 = r1.d(r2, r3, r5, r7)
            if (r1 == 0) goto L_0x001b
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.fullAddCount(long, boolean):void");
    }

    /* JADX INFO: finally extract failed */
    private final E[] initTable() {
        while (true) {
            E[] eArr = this.table;
            if (eArr != null && eArr.length != 0) {
                return eArr;
            }
            int i11 = this.sizeCtl;
            if (i11 < 0) {
                Thread.yield();
            } else {
                if (U.c(this, SIZECTL, i11, -1)) {
                    try {
                        E[] eArr2 = this.table;
                        if (eArr2 == null || eArr2.length == 0) {
                            int i12 = i11 > 0 ? i11 : 16;
                            E[] eArr3 = new E[i12];
                            this.table = eArr3;
                            i11 = i12 - (i12 >>> 2);
                            eArr2 = eArr3;
                        }
                        this.sizeCtl = i11;
                        return eArr2;
                    } catch (Throwable th2) {
                        this.sizeCtl = i11;
                        throw th2;
                    }
                }
            }
        }
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMap(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int i11) {
        return new KeySetView<>(new ConcurrentHashMap(i11), Boolean.TRUE);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j11;
        boolean z11;
        boolean z12;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j12 = 0;
        long j13 = 0;
        E e11 = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j11 = 1;
            if (readObject != null && readObject2 != null) {
                j13++;
                e11 = new E(spread(readObject.hashCode()), readObject, readObject2, e11);
            }
        }
        if (j13 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j14 = (long) (((double) (((float) j13) / 0.75f)) + 1.0d);
        int tableSizeFor = j14 >= 1073741824 ? 1073741824 : tableSizeFor((int) j14);
        E[] eArr = new E[tableSizeFor];
        int i11 = tableSizeFor - 1;
        while (e11 != null) {
            E e12 = e11.f28634d;
            int i12 = e11.f28631a;
            int i13 = i12 & i11;
            E tabAt = tabAt(eArr, i13);
            if (tabAt == null) {
                z11 = true;
            } else {
                Object obj2 = e11.f28632b;
                if (tabAt.f28631a >= 0) {
                    E e13 = tabAt;
                    int i14 = 0;
                    while (true) {
                        if (e13 == null) {
                            z12 = true;
                            break;
                        } else if (e13.f28631a != i12 || ((obj = e13.f28632b) != obj2 && (obj == null || !obj2.equals(obj)))) {
                            i14++;
                            e13 = e13.f28634d;
                        }
                    }
                    z12 = false;
                    if (!z12 || i14 < 8) {
                        z11 = z12;
                    } else {
                        long j15 = j12 + 1;
                        e11.f28634d = tabAt;
                        E e14 = e11;
                        P p11 = null;
                        P p12 = null;
                        while (e14 != null) {
                            long j16 = j15;
                            P p13 = new P(e14.f28631a, e14.f28632b, e14.f28633c, (P) null, (P) null);
                            p13.f28670h = p12;
                            if (p12 == null) {
                                p11 = p13;
                            } else {
                                p12.f28634d = p13;
                            }
                            e14 = e14.f28634d;
                            p12 = p13;
                            j15 = j16;
                        }
                        setTabAt(eArr, i13, new O(p11));
                        j12 = j15;
                    }
                } else if (((O) tabAt).e(i12, obj2, e11.f28633c) == null) {
                    j12 += j11;
                }
                z11 = false;
            }
            if (z11) {
                j12++;
                e11.f28634d = tabAt;
                setTabAt(eArr, i13, e11);
            }
            j11 = 1;
            e11 = e12;
        }
        this.table = eArr;
        this.sizeCtl = tableSizeFor - (tableSizeFor >>> 2);
        this.baseCount = j12;
    }

    static final int resizeStamp(int i11) {
        return Integer.numberOfLeadingZeros(i11) | 32768;
    }

    static final <K, V> void setTabAt(E[] eArr, int i11, E e11) {
        U.l(eArr, (((long) i11) << ASHIFT) + ((long) ABASE), e11);
    }

    static final int spread(int i11) {
        return (i11 ^ (i11 >>> 16)) & Integer.MAX_VALUE;
    }

    static final <K, V> E tabAt(E[] eArr, int i11) {
        return (E) U.g(eArr, (((long) i11) << ASHIFT) + ((long) ABASE));
    }

    private static final int tableSizeFor(int i11) {
        int numberOfLeadingZeros = -1 >>> Integer.numberOfLeadingZeros(i11 - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        if (numberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return 1 + numberOfLeadingZeros;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: j$.util.concurrent.E} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: j$.util.concurrent.P} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: j$.util.concurrent.P} */
    /* JADX WARNING: type inference failed for: r6v12, types: [j$.util.concurrent.E] */
    /* JADX WARNING: type inference failed for: r13v11, types: [j$.util.concurrent.E] */
    /* JADX WARNING: type inference failed for: r6v17, types: [j$.util.concurrent.E] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void transfer(j$.util.concurrent.E[] r31, j$.util.concurrent.E[] r32) {
        /*
            r30 = this;
            r7 = r30
            r0 = r31
            int r8 = r0.length
            int r1 = NCPU
            r9 = 1
            if (r1 <= r9) goto L_0x000e
            int r2 = r8 >>> 3
            int r2 = r2 / r1
            goto L_0x000f
        L_0x000e:
            r2 = r8
        L_0x000f:
            r10 = 16
            if (r2 >= r10) goto L_0x0015
            r11 = r10
            goto L_0x0016
        L_0x0015:
            r11 = r2
        L_0x0016:
            if (r32 != 0) goto L_0x0028
            int r1 = r8 << 1
            j$.util.concurrent.E[] r1 = new j$.util.concurrent.E[r1]     // Catch:{ all -> 0x0022 }
            r7.nextTable = r1
            r7.transferIndex = r8
            r12 = r1
            goto L_0x002a
        L_0x0022:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r7.sizeCtl = r0
            return
        L_0x0028:
            r12 = r32
        L_0x002a:
            int r13 = r12.length
            j$.util.concurrent.k r14 = new j$.util.concurrent.k
            r14.<init>(r12)
            r4 = r0
            r3 = r7
            r16 = r9
            r5 = 0
            r6 = 0
            r17 = 0
        L_0x0038:
            r1 = -1
            if (r16 == 0) goto L_0x008c
            int r5 = r5 + -1
            if (r5 >= r6) goto L_0x007b
            if (r17 == 0) goto L_0x0042
            goto L_0x007b
        L_0x0042:
            int r2 = r3.transferIndex
            if (r2 > 0) goto L_0x004b
            r5 = r1
            r22 = r3
            r15 = r4
            goto L_0x0086
        L_0x004b:
            j$.sun.misc.b r1 = U
            long r18 = TRANSFERINDEX
            if (r2 <= r11) goto L_0x0054
            int r20 = r2 - r11
            goto L_0x0056
        L_0x0054:
            r20 = 0
        L_0x0056:
            r21 = r2
            r2 = r30
            r22 = r3
            r15 = r4
            r3 = r18
            r18 = r5
            r5 = r21
            r19 = r6
            r6 = r20
            boolean r1 = r1.c(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x0073
            int r2 = r21 + -1
            r5 = r2
            r6 = r20
            goto L_0x0086
        L_0x0073:
            r4 = r15
            r5 = r18
            r6 = r19
            r3 = r22
            goto L_0x0038
        L_0x007b:
            r22 = r3
            r15 = r4
            r18 = r5
            r19 = r6
            r5 = r18
            r6 = r19
        L_0x0086:
            r4 = r15
            r3 = r22
            r16 = 0
            goto L_0x0038
        L_0x008c:
            r22 = r3
            r15 = r4
            r19 = r6
            r2 = 0
            if (r5 < 0) goto L_0x01b6
            if (r5 >= r8) goto L_0x01b6
            int r3 = r5 + r8
            if (r3 < r13) goto L_0x009c
            goto L_0x01b6
        L_0x009c:
            j$.util.concurrent.E r4 = tabAt(r15, r5)
            if (r4 != 0) goto L_0x00a7
            boolean r1 = casTabAt(r15, r5, r2, r14)
            goto L_0x00ac
        L_0x00a7:
            int r6 = r4.f28631a
            if (r6 != r1) goto L_0x00bb
            r1 = r9
        L_0x00ac:
            r16 = r1
            r2 = r10
            r21 = r11
            r4 = r15
            r3 = r22
            r10 = r9
            r22 = r13
            r9 = r7
            r7 = r14
            goto L_0x01f9
        L_0x00bb:
            monitor-enter(r4)
            j$.util.concurrent.E r1 = tabAt(r15, r5)     // Catch:{ all -> 0x01b3 }
            if (r1 != r4) goto L_0x01a5
            if (r6 < 0) goto L_0x0117
            r1 = r6 & r8
            j$.util.concurrent.E r6 = r4.f28634d     // Catch:{ all -> 0x01b3 }
            r10 = r4
        L_0x00c9:
            if (r6 == 0) goto L_0x00d6
            int r9 = r6.f28631a     // Catch:{ all -> 0x01b3 }
            r9 = r9 & r8
            if (r9 == r1) goto L_0x00d2
            r10 = r6
            r1 = r9
        L_0x00d2:
            j$.util.concurrent.E r6 = r6.f28634d     // Catch:{ all -> 0x01b3 }
            r9 = 1
            goto L_0x00c9
        L_0x00d6:
            if (r1 != 0) goto L_0x00da
            r1 = r10
            goto L_0x00dc
        L_0x00da:
            r1 = r2
            r2 = r10
        L_0x00dc:
            r6 = r4
        L_0x00dd:
            if (r6 == r10) goto L_0x0107
            int r9 = r6.f28631a     // Catch:{ all -> 0x01b3 }
            r16 = r10
            java.lang.Object r10 = r6.f28632b     // Catch:{ all -> 0x01b3 }
            r21 = r11
            java.lang.Object r11 = r6.f28633c     // Catch:{ all -> 0x01b3 }
            r22 = r9 & r8
            if (r22 != 0) goto L_0x00f6
            r22 = r13
            j$.util.concurrent.E r13 = new j$.util.concurrent.E     // Catch:{ all -> 0x01b3 }
            r13.<init>(r9, r10, r11, r1)     // Catch:{ all -> 0x01b3 }
            r1 = r13
            goto L_0x00fe
        L_0x00f6:
            r22 = r13
            j$.util.concurrent.E r13 = new j$.util.concurrent.E     // Catch:{ all -> 0x01b3 }
            r13.<init>(r9, r10, r11, r2)     // Catch:{ all -> 0x01b3 }
            r2 = r13
        L_0x00fe:
            j$.util.concurrent.E r6 = r6.f28634d     // Catch:{ all -> 0x01b3 }
            r10 = r16
            r11 = r21
            r13 = r22
            goto L_0x00dd
        L_0x0107:
            r21 = r11
            r22 = r13
            setTabAt(r12, r5, r1)     // Catch:{ all -> 0x01b3 }
            setTabAt(r12, r3, r2)     // Catch:{ all -> 0x01b3 }
            setTabAt(r15, r5, r14)     // Catch:{ all -> 0x01b3 }
            r7 = r14
            goto L_0x01a2
        L_0x0117:
            r21 = r11
            r22 = r13
            boolean r1 = r4 instanceof j$.util.concurrent.O     // Catch:{ all -> 0x01b3 }
            if (r1 == 0) goto L_0x01a9
            r1 = r4
            j$.util.concurrent.O r1 = (j$.util.concurrent.O) r1     // Catch:{ all -> 0x01b3 }
            j$.util.concurrent.P r6 = r1.f28665f     // Catch:{ all -> 0x01b3 }
            r9 = r2
            r10 = r9
            r11 = r6
            r13 = 0
            r15 = 0
            r6 = r10
        L_0x012a:
            if (r11 == 0) goto L_0x016d
            r16 = r1
            int r1 = r11.f28631a     // Catch:{ all -> 0x01b3 }
            j$.util.concurrent.P r7 = new j$.util.concurrent.P     // Catch:{ all -> 0x01b3 }
            java.lang.Object r0 = r11.f28632b     // Catch:{ all -> 0x01b3 }
            r29 = r14
            java.lang.Object r14 = r11.f28633c     // Catch:{ all -> 0x01b3 }
            r27 = 0
            r28 = 0
            r23 = r7
            r24 = r1
            r25 = r0
            r26 = r14
            r23.<init>(r24, r25, r26, r27, r28)     // Catch:{ all -> 0x01b3 }
            r0 = r1 & r8
            if (r0 != 0) goto L_0x0157
            r7.f28670h = r10     // Catch:{ all -> 0x01b3 }
            if (r10 != 0) goto L_0x0151
            r2 = r7
            goto L_0x0153
        L_0x0151:
            r10.f28634d = r7     // Catch:{ all -> 0x01b3 }
        L_0x0153:
            int r13 = r13 + 1
            r10 = r7
            goto L_0x0162
        L_0x0157:
            r7.f28670h = r9     // Catch:{ all -> 0x01b3 }
            if (r9 != 0) goto L_0x015d
            r6 = r7
            goto L_0x015f
        L_0x015d:
            r9.f28634d = r7     // Catch:{ all -> 0x01b3 }
        L_0x015f:
            int r15 = r15 + 1
            r9 = r7
        L_0x0162:
            j$.util.concurrent.E r11 = r11.f28634d     // Catch:{ all -> 0x01b3 }
            r7 = r30
            r0 = r31
            r1 = r16
            r14 = r29
            goto L_0x012a
        L_0x016d:
            r16 = r1
            r29 = r14
            r0 = 6
            if (r13 > r0) goto L_0x0179
            j$.util.concurrent.E r1 = untreeify(r2)     // Catch:{ all -> 0x01b3 }
            goto L_0x0183
        L_0x0179:
            if (r15 == 0) goto L_0x0181
            j$.util.concurrent.O r1 = new j$.util.concurrent.O     // Catch:{ all -> 0x01b3 }
            r1.<init>(r2)     // Catch:{ all -> 0x01b3 }
            goto L_0x0183
        L_0x0181:
            r1 = r16
        L_0x0183:
            if (r15 > r0) goto L_0x018a
            j$.util.concurrent.E r0 = untreeify(r6)     // Catch:{ all -> 0x01b3 }
            goto L_0x0194
        L_0x018a:
            if (r13 == 0) goto L_0x0192
            j$.util.concurrent.O r0 = new j$.util.concurrent.O     // Catch:{ all -> 0x01b3 }
            r0.<init>(r6)     // Catch:{ all -> 0x01b3 }
            goto L_0x0194
        L_0x0192:
            r0 = r16
        L_0x0194:
            setTabAt(r12, r5, r1)     // Catch:{ all -> 0x01b3 }
            setTabAt(r12, r3, r0)     // Catch:{ all -> 0x01b3 }
            r0 = r31
            r7 = r29
            setTabAt(r0, r5, r7)     // Catch:{ all -> 0x01b3 }
            r15 = r0
        L_0x01a2:
            r16 = 1
            goto L_0x01aa
        L_0x01a5:
            r21 = r11
            r22 = r13
        L_0x01a9:
            r7 = r14
        L_0x01aa:
            monitor-exit(r4)     // Catch:{ all -> 0x01b3 }
            r3 = r30
            r4 = r15
            r2 = 16
            r10 = 1
            r9 = r3
            goto L_0x01f9
        L_0x01b3:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x01b3 }
            throw r0
        L_0x01b6:
            r21 = r11
            r22 = r13
            r7 = r14
            if (r17 == 0) goto L_0x01cc
            r9 = r30
            r9.nextTable = r2
            r9.table = r12
            int r0 = r8 << 1
            r10 = 1
            int r1 = r8 >>> 1
            int r0 = r0 - r1
            r9.sizeCtl = r0
            return
        L_0x01cc:
            r10 = 1
            r9 = r30
            j$.sun.misc.b r1 = U
            long r3 = SIZECTL
            int r11 = r9.sizeCtl
            int r6 = r11 + -1
            r2 = r30
            r13 = r5
            r5 = r11
            boolean r1 = r1.c(r2, r3, r5, r6)
            if (r1 == 0) goto L_0x01f4
            int r11 = r11 + -2
            int r1 = resizeStamp(r8)
            r2 = 16
            int r1 = r1 << r2
            if (r11 == r1) goto L_0x01ed
            return
        L_0x01ed:
            r5 = r8
            r3 = r9
            r16 = r10
            r17 = r16
            goto L_0x01f8
        L_0x01f4:
            r2 = 16
            r3 = r9
            r5 = r13
        L_0x01f8:
            r4 = r15
        L_0x01f9:
            r14 = r7
            r7 = r9
            r9 = r10
            r6 = r19
            r11 = r21
            r13 = r22
            r10 = r2
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.transfer(j$.util.concurrent.E[], j$.util.concurrent.E[]):void");
    }

    private final void treeifyBin(E[] eArr, int i11) {
        if (eArr != null) {
            int length = eArr.length;
            if (length < 64) {
                tryPresize(length << 1);
                return;
            }
            E tabAt = tabAt(eArr, i11);
            if (tabAt != null && tabAt.f28631a >= 0) {
                synchronized (tabAt) {
                    if (tabAt(eArr, i11) == tabAt) {
                        P p11 = null;
                        E e11 = tabAt;
                        P p12 = null;
                        while (e11 != null) {
                            P p13 = new P(e11.f28631a, e11.f28632b, e11.f28633c, (P) null, (P) null);
                            p13.f28670h = p12;
                            if (p12 == null) {
                                p11 = p13;
                            } else {
                                p12.f28634d = p13;
                            }
                            e11 = e11.f28634d;
                            p12 = p13;
                        }
                        setTabAt(eArr, i11, new O(p11));
                    }
                }
            }
        }
    }

    private final void tryPresize(int i11) {
        int length;
        int tableSizeFor = i11 >= 536870912 ? 1073741824 : tableSizeFor(i11 + (i11 >>> 1) + 1);
        while (true) {
            int i12 = this.sizeCtl;
            if (i12 >= 0) {
                E[] eArr = this.table;
                if (eArr == null || (length = eArr.length) == 0) {
                    int i13 = i12 > tableSizeFor ? i12 : tableSizeFor;
                    if (U.c(this, SIZECTL, i12, -1)) {
                        try {
                            if (this.table == eArr) {
                                this.table = new E[i13];
                                i12 = i13 - (i13 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = i12;
                        }
                    }
                } else if (tableSizeFor > i12 && length < 1073741824) {
                    if (eArr == this.table) {
                        if (U.c(this, SIZECTL, i12, (resizeStamp(length) << 16) + 2)) {
                            transfer(eArr, (E[]) null);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static <K, V> E untreeify(E e11) {
        E e12 = null;
        E e13 = null;
        while (e11 != null) {
            E e14 = new E(e11.f28631a, e11.f28632b, e11.f28633c);
            if (e13 == null) {
                e12 = e14;
            } else {
                e13.f28634d = e14;
            }
            e11 = e11.f28634d;
            e13 = e14;
        }
        return e12;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i11 = 0;
        int i12 = 1;
        while (i12 < 16) {
            i11++;
            i12 <<= 1;
        }
        int i13 = 32 - i11;
        int i14 = i12 - 1;
        L[] lArr = new L[16];
        for (int i15 = 0; i15 < 16; i15++) {
            lArr[i15] = new L();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", lArr);
        putFields.put("segmentShift", i13);
        putFields.put("segmentMask", i14);
        objectOutputStream.writeFields();
        E[] eArr = this.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                objectOutputStream.writeObject(f11.f28632b);
                objectOutputStream.writeObject(f11.f28633c);
            }
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject((Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int batchFor(long j11) {
        if (j11 == Long.MAX_VALUE) {
            return 0;
        }
        long sumCount = sumCount();
        if (sumCount <= 1 || sumCount < j11) {
            return 0;
        }
        int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism() << 2;
        if (j11 <= 0) {
            return commonPoolParallelism;
        }
        long j12 = sumCount / j11;
        return j12 >= ((long) commonPoolParallelism) ? commonPoolParallelism : (int) j12;
    }

    public void clear() {
        E[] eArr = this.table;
        long j11 = 0;
        loop0:
        while (true) {
            int i11 = 0;
            while (eArr != null && i11 < eArr.length) {
                E tabAt = tabAt(eArr, i11);
                if (tabAt == null) {
                    i11++;
                } else {
                    int i12 = tabAt.f28631a;
                    if (i12 == -1) {
                        eArr = helpTransfer(eArr, tabAt);
                    } else {
                        synchronized (tabAt) {
                            if (tabAt(eArr, i11) == tabAt) {
                                for (E e11 = i12 >= 0 ? tabAt : tabAt instanceof O ? ((O) tabAt).f28665f : null; e11 != null; e11 = e11.f28634d) {
                                    j11--;
                                }
                                setTabAt(eArr, i11, (E) null);
                                i11++;
                            }
                        }
                    }
                }
            }
        }
        if (j11 != 0) {
            addCount(j11, -1);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x010a, code lost:
        if (r4 == 0) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x010c, code lost:
        addCount((long) r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0110, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V compute(K r14, j$.util.function.BiFunction<? super K, ? super V, ? extends V> r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x011a
            if (r15 == 0) goto L_0x011a
            int r1 = r14.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.E[] r2 = r13.table
            r3 = 0
            r5 = r0
            r4 = r3
        L_0x0012:
            if (r2 == 0) goto L_0x0114
            int r6 = r2.length
            if (r6 != 0) goto L_0x0019
            goto L_0x0114
        L_0x0019:
            int r6 = r6 + -1
            r6 = r6 & r1
            j$.util.concurrent.E r7 = tabAt(r2, r6)
            r8 = 1
            if (r7 != 0) goto L_0x0052
            j$.util.concurrent.I r9 = new j$.util.concurrent.I
            r9.<init>()
            monitor-enter(r9)
            boolean r7 = casTabAt(r2, r6, r0, r9)     // Catch:{ all -> 0x004f }
            if (r7 == 0) goto L_0x004a
            java.lang.Object r3 = r15.apply(r14, r0)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003c
            j$.util.concurrent.E r4 = new j$.util.concurrent.E     // Catch:{ all -> 0x0045 }
            r4.<init>(r1, r14, r3)     // Catch:{ all -> 0x0045 }
            r5 = r8
            goto L_0x003e
        L_0x003c:
            r5 = r4
            r4 = r0
        L_0x003e:
            setTabAt(r2, r6, r4)     // Catch:{ all -> 0x004f }
            r4 = r5
            r5 = r3
            r3 = r8
            goto L_0x004a
        L_0x0045:
            r14 = move-exception
            setTabAt(r2, r6, r0)     // Catch:{ all -> 0x004f }
            throw r14     // Catch:{ all -> 0x004f }
        L_0x004a:
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x0012
            goto L_0x010a
        L_0x004f:
            r14 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004f }
            throw r14
        L_0x0052:
            int r9 = r7.f28631a
            r10 = -1
            if (r9 != r10) goto L_0x005c
            j$.util.concurrent.E[] r2 = r13.helpTransfer(r2, r7)
            goto L_0x0012
        L_0x005c:
            monitor-enter(r7)
            j$.util.concurrent.E r11 = tabAt(r2, r6)     // Catch:{ all -> 0x0111 }
            if (r11 != r7) goto L_0x0100
            if (r9 < 0) goto L_0x00b7
            r9 = r0
            r5 = r7
            r3 = r8
        L_0x0068:
            int r11 = r5.f28631a     // Catch:{ all -> 0x0111 }
            if (r11 != r1) goto L_0x008f
            java.lang.Object r11 = r5.f28632b     // Catch:{ all -> 0x0111 }
            if (r11 == r14) goto L_0x0078
            if (r11 == 0) goto L_0x008f
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0111 }
            if (r11 == 0) goto L_0x008f
        L_0x0078:
            java.lang.Object r8 = r5.f28633c     // Catch:{ all -> 0x0111 }
            java.lang.Object r8 = r15.apply(r14, r8)     // Catch:{ all -> 0x0111 }
            if (r8 == 0) goto L_0x0083
            r5.f28633c = r8     // Catch:{ all -> 0x0111 }
            goto L_0x00af
        L_0x0083:
            j$.util.concurrent.E r4 = r5.f28634d     // Catch:{ all -> 0x0111 }
            if (r9 == 0) goto L_0x008a
            r9.f28634d = r4     // Catch:{ all -> 0x0111 }
            goto L_0x008d
        L_0x008a:
            setTabAt(r2, r6, r4)     // Catch:{ all -> 0x0111 }
        L_0x008d:
            r4 = r10
            goto L_0x00af
        L_0x008f:
            j$.util.concurrent.E r9 = r5.f28634d     // Catch:{ all -> 0x0111 }
            if (r9 != 0) goto L_0x00b1
            java.lang.Object r9 = r15.apply(r14, r0)     // Catch:{ all -> 0x0111 }
            if (r9 == 0) goto L_0x00ae
            j$.util.concurrent.E r4 = r5.f28634d     // Catch:{ all -> 0x0111 }
            if (r4 != 0) goto L_0x00a6
            j$.util.concurrent.E r4 = new j$.util.concurrent.E     // Catch:{ all -> 0x0111 }
            r4.<init>(r1, r14, r9)     // Catch:{ all -> 0x0111 }
            r5.f28634d = r4     // Catch:{ all -> 0x0111 }
            r4 = r8
            goto L_0x00ae
        L_0x00a6:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0111 }
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch:{ all -> 0x0111 }
            throw r14     // Catch:{ all -> 0x0111 }
        L_0x00ae:
            r8 = r9
        L_0x00af:
            r5 = r8
            goto L_0x0100
        L_0x00b1:
            int r3 = r3 + 1
            r12 = r9
            r9 = r5
            r5 = r12
            goto L_0x0068
        L_0x00b7:
            boolean r9 = r7 instanceof j$.util.concurrent.O     // Catch:{ all -> 0x0111 }
            if (r9 == 0) goto L_0x00f3
            r3 = r7
            j$.util.concurrent.O r3 = (j$.util.concurrent.O) r3     // Catch:{ all -> 0x0111 }
            j$.util.concurrent.P r5 = r3.f28664e     // Catch:{ all -> 0x0111 }
            if (r5 == 0) goto L_0x00c7
            j$.util.concurrent.P r5 = r5.b(r1, r14, r0)     // Catch:{ all -> 0x0111 }
            goto L_0x00c8
        L_0x00c7:
            r5 = r0
        L_0x00c8:
            if (r5 != 0) goto L_0x00cc
            r9 = r0
            goto L_0x00ce
        L_0x00cc:
            java.lang.Object r9 = r5.f28633c     // Catch:{ all -> 0x0111 }
        L_0x00ce:
            java.lang.Object r9 = r15.apply(r14, r9)     // Catch:{ all -> 0x0111 }
            if (r9 == 0) goto L_0x00de
            if (r5 == 0) goto L_0x00d9
            r5.f28633c = r9     // Catch:{ all -> 0x0111 }
            goto L_0x00f0
        L_0x00d9:
            r3.e(r1, r14, r9)     // Catch:{ all -> 0x0111 }
            r4 = r8
            goto L_0x00f0
        L_0x00de:
            if (r5 == 0) goto L_0x00f0
            boolean r4 = r3.f(r5)     // Catch:{ all -> 0x0111 }
            if (r4 == 0) goto L_0x00ef
            j$.util.concurrent.P r3 = r3.f28665f     // Catch:{ all -> 0x0111 }
            j$.util.concurrent.E r3 = untreeify(r3)     // Catch:{ all -> 0x0111 }
            setTabAt(r2, r6, r3)     // Catch:{ all -> 0x0111 }
        L_0x00ef:
            r4 = r10
        L_0x00f0:
            r3 = r8
            r5 = r9
            goto L_0x0100
        L_0x00f3:
            boolean r8 = r7 instanceof j$.util.concurrent.I     // Catch:{ all -> 0x0111 }
            if (r8 != 0) goto L_0x00f8
            goto L_0x0100
        L_0x00f8:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0111 }
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch:{ all -> 0x0111 }
            throw r14     // Catch:{ all -> 0x0111 }
        L_0x0100:
            monitor-exit(r7)     // Catch:{ all -> 0x0111 }
            if (r3 == 0) goto L_0x0012
            r14 = 8
            if (r3 < r14) goto L_0x010a
            r13.treeifyBin(r2, r6)
        L_0x010a:
            if (r4 == 0) goto L_0x0110
            long r14 = (long) r4
            r13.addCount(r14, r3)
        L_0x0110:
            return r5
        L_0x0111:
            r14 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0111 }
            throw r14
        L_0x0114:
            j$.util.concurrent.E[] r2 = r13.initTable()
            goto L_0x0012
        L_0x011a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.compute(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00f1, code lost:
        if (r5 == null) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x00f3, code lost:
        addCount(1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x00f8, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V computeIfAbsent(K r13, j$.util.function.Function<? super K, ? extends V> r14) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0102
            if (r14 == 0) goto L_0x0102
            int r1 = r13.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.E[] r2 = r12.table
            r3 = 0
            r5 = r0
            r4 = r3
        L_0x0012:
            if (r2 == 0) goto L_0x00fc
            int r6 = r2.length
            if (r6 != 0) goto L_0x0019
            goto L_0x00fc
        L_0x0019:
            int r6 = r6 + -1
            r6 = r6 & r1
            j$.util.concurrent.E r7 = tabAt(r2, r6)
            r8 = 1
            if (r7 != 0) goto L_0x004f
            j$.util.concurrent.I r9 = new j$.util.concurrent.I
            r9.<init>()
            monitor-enter(r9)
            boolean r7 = casTabAt(r2, r6, r0, r9)     // Catch:{ all -> 0x004c }
            if (r7 == 0) goto L_0x0047
            java.lang.Object r4 = r14.apply(r13)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x003b
            j$.util.concurrent.E r5 = new j$.util.concurrent.E     // Catch:{ all -> 0x0042 }
            r5.<init>(r1, r13, r4)     // Catch:{ all -> 0x0042 }
            goto L_0x003c
        L_0x003b:
            r5 = r0
        L_0x003c:
            setTabAt(r2, r6, r5)     // Catch:{ all -> 0x004c }
            r5 = r4
            r4 = r8
            goto L_0x0047
        L_0x0042:
            r13 = move-exception
            setTabAt(r2, r6, r0)     // Catch:{ all -> 0x004c }
            throw r13     // Catch:{ all -> 0x004c }
        L_0x0047:
            monitor-exit(r9)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x0012
            goto L_0x00f1
        L_0x004c:
            r13 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004c }
            throw r13
        L_0x004f:
            int r9 = r7.f28631a
            r10 = -1
            if (r9 != r10) goto L_0x0059
            j$.util.concurrent.E[] r2 = r12.helpTransfer(r2, r7)
            goto L_0x0012
        L_0x0059:
            if (r9 != r1) goto L_0x006c
            java.lang.Object r10 = r7.f28632b
            if (r10 == r13) goto L_0x0067
            if (r10 == 0) goto L_0x006c
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x006c
        L_0x0067:
            java.lang.Object r10 = r7.f28633c
            if (r10 == 0) goto L_0x006c
            return r10
        L_0x006c:
            monitor-enter(r7)
            j$.util.concurrent.E r10 = tabAt(r2, r6)     // Catch:{ all -> 0x00f9 }
            if (r10 != r7) goto L_0x00e3
            if (r9 < 0) goto L_0x00b0
            r4 = r7
            r5 = r8
        L_0x0077:
            int r9 = r4.f28631a     // Catch:{ all -> 0x00f9 }
            if (r9 != r1) goto L_0x008b
            java.lang.Object r9 = r4.f28632b     // Catch:{ all -> 0x00f9 }
            if (r9 == r13) goto L_0x0087
            if (r9 == 0) goto L_0x008b
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x00f9 }
            if (r9 == 0) goto L_0x008b
        L_0x0087:
            java.lang.Object r4 = r4.f28633c     // Catch:{ all -> 0x00f9 }
            r8 = r3
            goto L_0x00d2
        L_0x008b:
            j$.util.concurrent.E r9 = r4.f28634d     // Catch:{ all -> 0x00f9 }
            if (r9 != 0) goto L_0x00ac
            java.lang.Object r9 = r14.apply(r13)     // Catch:{ all -> 0x00f9 }
            if (r9 == 0) goto L_0x00a9
            j$.util.concurrent.E r10 = r4.f28634d     // Catch:{ all -> 0x00f9 }
            if (r10 != 0) goto L_0x00a1
            j$.util.concurrent.E r10 = new j$.util.concurrent.E     // Catch:{ all -> 0x00f9 }
            r10.<init>(r1, r13, r9)     // Catch:{ all -> 0x00f9 }
            r4.f28634d = r10     // Catch:{ all -> 0x00f9 }
            goto L_0x00aa
        L_0x00a1:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f9 }
            java.lang.String r14 = "Recursive update"
            r13.<init>(r14)     // Catch:{ all -> 0x00f9 }
            throw r13     // Catch:{ all -> 0x00f9 }
        L_0x00a9:
            r8 = r3
        L_0x00aa:
            r4 = r9
            goto L_0x00d2
        L_0x00ac:
            int r5 = r5 + 1
            r4 = r9
            goto L_0x0077
        L_0x00b0:
            boolean r9 = r7 instanceof j$.util.concurrent.O     // Catch:{ all -> 0x00f9 }
            if (r9 == 0) goto L_0x00d6
            r4 = r7
            j$.util.concurrent.O r4 = (j$.util.concurrent.O) r4     // Catch:{ all -> 0x00f9 }
            j$.util.concurrent.P r5 = r4.f28664e     // Catch:{ all -> 0x00f9 }
            if (r5 == 0) goto L_0x00c5
            j$.util.concurrent.P r5 = r5.b(r1, r13, r0)     // Catch:{ all -> 0x00f9 }
            if (r5 == 0) goto L_0x00c5
            java.lang.Object r4 = r5.f28633c     // Catch:{ all -> 0x00f9 }
            r8 = r3
            goto L_0x00d1
        L_0x00c5:
            java.lang.Object r5 = r14.apply(r13)     // Catch:{ all -> 0x00f9 }
            if (r5 == 0) goto L_0x00cf
            r4.e(r1, r13, r5)     // Catch:{ all -> 0x00f9 }
            goto L_0x00d0
        L_0x00cf:
            r8 = r3
        L_0x00d0:
            r4 = r5
        L_0x00d1:
            r5 = 2
        L_0x00d2:
            r11 = r5
            r5 = r4
            r4 = r11
            goto L_0x00e4
        L_0x00d6:
            boolean r8 = r7 instanceof j$.util.concurrent.I     // Catch:{ all -> 0x00f9 }
            if (r8 != 0) goto L_0x00db
            goto L_0x00e3
        L_0x00db:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f9 }
            java.lang.String r14 = "Recursive update"
            r13.<init>(r14)     // Catch:{ all -> 0x00f9 }
            throw r13     // Catch:{ all -> 0x00f9 }
        L_0x00e3:
            r8 = r3
        L_0x00e4:
            monitor-exit(r7)     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x0012
            r13 = 8
            if (r4 < r13) goto L_0x00ee
            r12.treeifyBin(r2, r6)
        L_0x00ee:
            if (r8 != 0) goto L_0x00f1
            return r5
        L_0x00f1:
            if (r5 == 0) goto L_0x00f8
            r13 = 1
            r12.addCount(r13, r4)
        L_0x00f8:
            return r5
        L_0x00f9:
            r13 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00f9 }
            throw r13
        L_0x00fc:
            j$.util.concurrent.E[] r2 = r12.initTable()
            goto L_0x0012
        L_0x0102:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, j$.util.function.Function):java.lang.Object");
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00aa, code lost:
        if (r3 == 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ac, code lost:
        addCount((long) r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b0, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V computeIfPresent(K r14, j$.util.function.BiFunction<? super K, ? super V, ? extends V> r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x00ba
            if (r15 == 0) goto L_0x00ba
            int r1 = r14.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.E[] r2 = r13.table
            r3 = 0
            r5 = r0
            r4 = r3
        L_0x0012:
            if (r2 == 0) goto L_0x00b4
            int r6 = r2.length
            if (r6 != 0) goto L_0x0019
            goto L_0x00b4
        L_0x0019:
            int r6 = r6 + -1
            r6 = r6 & r1
            j$.util.concurrent.E r7 = tabAt(r2, r6)
            if (r7 != 0) goto L_0x0024
            goto L_0x00aa
        L_0x0024:
            int r8 = r7.f28631a
            r9 = -1
            if (r8 != r9) goto L_0x002e
            j$.util.concurrent.E[] r2 = r13.helpTransfer(r2, r7)
            goto L_0x0012
        L_0x002e:
            monitor-enter(r7)
            j$.util.concurrent.E r10 = tabAt(r2, r6)     // Catch:{ all -> 0x00b1 }
            if (r10 != r7) goto L_0x00a7
            if (r8 < 0) goto L_0x006c
            r4 = 1
            r10 = r0
            r8 = r7
        L_0x003a:
            int r11 = r8.f28631a     // Catch:{ all -> 0x00b1 }
            if (r11 != r1) goto L_0x0061
            java.lang.Object r11 = r8.f28632b     // Catch:{ all -> 0x00b1 }
            if (r11 == r14) goto L_0x004a
            if (r11 == 0) goto L_0x0061
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x00b1 }
            if (r11 == 0) goto L_0x0061
        L_0x004a:
            java.lang.Object r5 = r8.f28633c     // Catch:{ all -> 0x00b1 }
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x0055
            r8.f28633c = r5     // Catch:{ all -> 0x00b1 }
            goto L_0x00a7
        L_0x0055:
            j$.util.concurrent.E r3 = r8.f28634d     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x005c
            r10.f28634d = r3     // Catch:{ all -> 0x00b1 }
            goto L_0x005f
        L_0x005c:
            setTabAt(r2, r6, r3)     // Catch:{ all -> 0x00b1 }
        L_0x005f:
            r3 = r9
            goto L_0x00a7
        L_0x0061:
            j$.util.concurrent.E r10 = r8.f28634d     // Catch:{ all -> 0x00b1 }
            if (r10 != 0) goto L_0x0066
            goto L_0x00a7
        L_0x0066:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L_0x003a
        L_0x006c:
            boolean r8 = r7 instanceof j$.util.concurrent.O     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x009a
            r4 = r7
            j$.util.concurrent.O r4 = (j$.util.concurrent.O) r4     // Catch:{ all -> 0x00b1 }
            j$.util.concurrent.P r8 = r4.f28664e     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x0098
            j$.util.concurrent.P r8 = r8.b(r1, r14, r0)     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x0098
            java.lang.Object r5 = r8.f28633c     // Catch:{ all -> 0x00b1 }
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x0088
            r8.f28633c = r5     // Catch:{ all -> 0x00b1 }
            goto L_0x0098
        L_0x0088:
            boolean r3 = r4.f(r8)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x0097
            j$.util.concurrent.P r3 = r4.f28665f     // Catch:{ all -> 0x00b1 }
            j$.util.concurrent.E r3 = untreeify(r3)     // Catch:{ all -> 0x00b1 }
            setTabAt(r2, r6, r3)     // Catch:{ all -> 0x00b1 }
        L_0x0097:
            r3 = r9
        L_0x0098:
            r4 = 2
            goto L_0x00a7
        L_0x009a:
            boolean r6 = r7 instanceof j$.util.concurrent.I     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x009f
            goto L_0x00a7
        L_0x009f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b1 }
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch:{ all -> 0x00b1 }
            throw r14     // Catch:{ all -> 0x00b1 }
        L_0x00a7:
            monitor-exit(r7)     // Catch:{ all -> 0x00b1 }
            if (r4 == 0) goto L_0x0012
        L_0x00aa:
            if (r3 == 0) goto L_0x00b0
            long r14 = (long) r3
            r13.addCount(r14, r4)
        L_0x00b0:
            return r5
        L_0x00b1:
            r14 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00b1 }
            throw r14
        L_0x00b4:
            j$.util.concurrent.E[] r2 = r13.initTable()
            goto L_0x0012
        L_0x00ba:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        obj.getClass();
        E[] eArr = this.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                Object obj2 = f11.f28633c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Enumeration<V> elements() {
        E[] eArr = this.table;
        int length = eArr == null ? 0 : eArr.length;
        return new C0126l(eArr, length, length, this, 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        C0120f fVar = this.entrySet;
        if (fVar != null) {
            return fVar;
        }
        C0120f fVar2 = new C0120f(this);
        this.entrySet = fVar2;
        return fVar2;
    }

    public boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        E[] eArr = this.table;
        int length = eArr == null ? 0 : eArr.length;
        N n11 = new N(eArr, length, 0, length);
        while (true) {
            E f11 = n11.f();
            if (f11 != null) {
                Object obj3 = f11.f28633c;
                Object obj4 = map.get(f11.f28632b);
                if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                    return false;
                }
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void forEach(long j11, BiConsumer<? super K, ? super V> biConsumer) {
        biConsumer.getClass();
        new C0122h((C0116b) null, batchFor(j11), 0, 0, this.table, biConsumer, 3).invoke();
    }

    public <U> void forEach(long j11, j$.util.function.BiFunction<? super K, ? super V, ? extends U> biFunction, Consumer<? super U> consumer) {
        if (biFunction == null || consumer == null) {
            throw null;
        }
        new C0124j((C0116b) null, batchFor(j11), 0, 0, this.table, biFunction, consumer, 0).invoke();
    }

    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        biConsumer.getClass();
        E[] eArr = this.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 != null) {
                    biConsumer.accept(f11.f28632b, f11.f28633c);
                } else {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public void forEachEntry(long j11, Consumer<? super Map.Entry<K, V>> consumer) {
        consumer.getClass();
        new C0122h((C0116b) null, batchFor(j11), 0, 0, this.table, consumer, 0).invoke();
    }

    public <U> void forEachEntry(long j11, j$.util.function.Function<Map.Entry<K, V>, ? extends U> function, Consumer<? super U> consumer) {
        if (function == null || consumer == null) {
            throw null;
        }
        new C0123i((C0116b) null, batchFor(j11), 0, 0, this.table, function, consumer, 0).invoke();
    }

    public void forEachKey(long j11, Consumer<? super K> consumer) {
        consumer.getClass();
        new C0122h((C0116b) null, batchFor(j11), 0, 0, this.table, consumer, 1).invoke();
    }

    public <U> void forEachKey(long j11, j$.util.function.Function<? super K, ? extends U> function, Consumer<? super U> consumer) {
        if (function == null || consumer == null) {
            throw null;
        }
        new C0123i((C0116b) null, batchFor(j11), 0, 0, this.table, function, consumer, 1).invoke();
    }

    public void forEachValue(long j11, Consumer<? super V> consumer) {
        consumer.getClass();
        new C0122h((C0116b) null, batchFor(j11), 0, 0, this.table, consumer, 2).invoke();
    }

    public <U> void forEachValue(long j11, j$.util.function.Function<? super V, ? extends U> function, Consumer<? super U> consumer) {
        if (function == null || consumer == null) {
            throw null;
        }
        new C0123i((C0116b) null, batchFor(j11), 0, 0, this.table, function, consumer, 2).invoke();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        return r1.f28633c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.E[] r1 = r4.table
            r2 = 0
            if (r1 == 0) goto L_0x004e
            int r3 = r1.length
            if (r3 <= 0) goto L_0x004e
            int r3 = r3 + -1
            r3 = r3 & r0
            j$.util.concurrent.E r1 = tabAt(r1, r3)
            if (r1 == 0) goto L_0x004e
            int r3 = r1.f28631a
            if (r3 != r0) goto L_0x002c
            java.lang.Object r3 = r1.f28632b
            if (r3 == r5) goto L_0x0029
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0029:
            java.lang.Object r5 = r1.f28633c
            return r5
        L_0x002c:
            if (r3 >= 0) goto L_0x0037
            j$.util.concurrent.E r5 = r1.a(r0, r5)
            if (r5 == 0) goto L_0x0036
            java.lang.Object r2 = r5.f28633c
        L_0x0036:
            return r2
        L_0x0037:
            j$.util.concurrent.E r1 = r1.f28634d
            if (r1 == 0) goto L_0x004e
            int r3 = r1.f28631a
            if (r3 != r0) goto L_0x0037
            java.lang.Object r3 = r1.f28632b
            if (r3 == r5) goto L_0x004b
            if (r3 == 0) goto L_0x0037
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
        L_0x004b:
            java.lang.Object r5 = r1.f28633c
            return r5
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    public V getOrDefault(Object obj, V v11) {
        V v12 = get(obj);
        return v12 == null ? v11 : v12;
    }

    public int hashCode() {
        E[] eArr = this.table;
        int i11 = 0;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                i11 += f11.f28633c.hashCode() ^ f11.f28632b.hashCode();
            }
        }
        return i11;
    }

    /* access modifiers changed from: package-private */
    public final E[] helpTransfer(E[] eArr, E e11) {
        E[] eArr2;
        int i11;
        if (eArr == null || !(e11 instanceof C0125k) || (eArr2 = ((C0125k) e11).f28716e) == null) {
            return this.table;
        }
        int resizeStamp = resizeStamp(eArr.length);
        while (true) {
            if (eArr2 != this.nextTable || this.table != eArr || (i11 = this.sizeCtl) >= 0 || (i11 >>> 16) != resizeStamp || i11 == resizeStamp + 1 || i11 == 65535 + resizeStamp || this.transferIndex <= 0) {
                break;
            }
            if (U.c(this, SIZECTL, i11, i11 + 1)) {
                transfer(eArr, eArr2);
                break;
            }
        }
        return eArr2;
    }

    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    public KeySetView<K, V> keySet(V v11) {
        v11.getClass();
        return new KeySetView<>(this, v11);
    }

    public Set<K> keySet() {
        KeySetView<K, V> keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView<K, V> keySetView2 = new KeySetView<>(this, (Object) null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    public Enumeration<K> keys() {
        E[] eArr = this.table;
        int length = eArr == null ? 0 : eArr.length;
        return new C0126l(eArr, length, length, this, 0);
    }

    public long mappingCount() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        return sumCount;
    }

    public V merge(K k11, V v11, j$.util.function.BiFunction<? super V, ? super V, ? extends V> biFunction) {
        int i11;
        V v12;
        K k12;
        K k13 = k11;
        V v13 = v11;
        j$.util.function.BiFunction<? super V, ? super V, ? extends V> biFunction2 = biFunction;
        if (k13 == null || v13 == null || biFunction2 == null) {
            throw null;
        }
        int spread = spread(k11.hashCode());
        E[] eArr = this.table;
        int i12 = 0;
        V v14 = null;
        int i13 = 0;
        while (true) {
            if (eArr != null) {
                int length = eArr.length;
                if (length != 0) {
                    int i14 = (length - 1) & spread;
                    E tabAt = tabAt(eArr, i14);
                    i11 = 1;
                    if (tabAt != null) {
                        int i15 = tabAt.f28631a;
                        if (i15 == -1) {
                            eArr = helpTransfer(eArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(eArr, i14) == tabAt) {
                                    if (i15 >= 0) {
                                        E e11 = null;
                                        E e12 = tabAt;
                                        int i16 = 1;
                                        while (true) {
                                            if (e12.f28631a != spread || ((k12 = e12.f28632b) != k13 && (k12 == null || !k13.equals(k12)))) {
                                                E e13 = e12.f28634d;
                                                if (e13 == null) {
                                                    e12.f28634d = new E(spread, k13, v13);
                                                    i13 = 1;
                                                    v12 = v13;
                                                    break;
                                                }
                                                i16++;
                                                E e14 = e13;
                                                e11 = e12;
                                                e12 = e14;
                                            }
                                        }
                                        v12 = biFunction2.apply(e12.f28633c, v13);
                                        if (v12 != null) {
                                            e12.f28633c = v12;
                                        } else {
                                            E e15 = e12.f28634d;
                                            if (e11 != null) {
                                                e11.f28634d = e15;
                                            } else {
                                                setTabAt(eArr, i14, e15);
                                            }
                                            i13 = -1;
                                        }
                                        i12 = i16;
                                        v14 = v12;
                                    } else if (tabAt instanceof O) {
                                        O o11 = (O) tabAt;
                                        P p11 = o11.f28664e;
                                        P b11 = p11 == null ? null : p11.b(spread, k13, (Class) null);
                                        V apply = b11 == null ? v13 : biFunction2.apply(b11.f28633c, v13);
                                        if (apply != null) {
                                            if (b11 != null) {
                                                b11.f28633c = apply;
                                            } else {
                                                o11.e(spread, k13, apply);
                                                i13 = 1;
                                            }
                                        } else if (b11 != null) {
                                            if (o11.f(b11)) {
                                                setTabAt(eArr, i14, untreeify(o11.f28665f));
                                            }
                                            i13 = -1;
                                        }
                                        i12 = 2;
                                        v14 = apply;
                                    } else if (tabAt instanceof I) {
                                        throw new IllegalStateException("Recursive update");
                                    }
                                }
                            }
                            if (i12 != 0) {
                                if (i12 >= 8) {
                                    treeifyBin(eArr, i14);
                                }
                                i11 = i13;
                                v13 = v14;
                            }
                        }
                    } else if (casTabAt(eArr, i14, (E) null, new E(spread, k13, v13))) {
                        break;
                    }
                }
            }
            eArr = initTable();
        }
        if (i11 != 0) {
            addCount((long) i11, i12);
        }
        return v13;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public V put(K k11, V v11) {
        return putVal(k11, v11, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry next : map.entrySet()) {
            putVal(next.getKey(), next.getValue(), false);
        }
    }

    public V putIfAbsent(K k11, V v11) {
        return putVal(k11, v11, true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b1, code lost:
        addCount(1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b6, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V putVal(K r9, V r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x00c0
            if (r10 == 0) goto L_0x00c0
            int r1 = r9.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.E[] r2 = r8.table
            r3 = 0
        L_0x0010:
            if (r2 == 0) goto L_0x00ba
            int r4 = r2.length
            if (r4 != 0) goto L_0x0017
            goto L_0x00ba
        L_0x0017:
            int r4 = r4 + -1
            r4 = r4 & r1
            j$.util.concurrent.E r5 = tabAt(r2, r4)
            if (r5 != 0) goto L_0x002d
            j$.util.concurrent.E r5 = new j$.util.concurrent.E
            r5.<init>(r1, r9, r10)
            boolean r4 = casTabAt(r2, r4, r0, r5)
            if (r4 == 0) goto L_0x0010
            goto L_0x00b1
        L_0x002d:
            int r6 = r5.f28631a
            r7 = -1
            if (r6 != r7) goto L_0x0037
            j$.util.concurrent.E[] r2 = r8.helpTransfer(r2, r5)
            goto L_0x0010
        L_0x0037:
            if (r11 == 0) goto L_0x004c
            if (r6 != r1) goto L_0x004c
            java.lang.Object r7 = r5.f28632b
            if (r7 == r9) goto L_0x0047
            if (r7 == 0) goto L_0x004c
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x004c
        L_0x0047:
            java.lang.Object r7 = r5.f28633c
            if (r7 == 0) goto L_0x004c
            return r7
        L_0x004c:
            monitor-enter(r5)
            j$.util.concurrent.E r7 = tabAt(r2, r4)     // Catch:{ all -> 0x00b7 }
            if (r7 != r5) goto L_0x00a3
            if (r6 < 0) goto L_0x007e
            r3 = 1
            r6 = r5
        L_0x0057:
            int r7 = r6.f28631a     // Catch:{ all -> 0x00b7 }
            if (r7 != r1) goto L_0x006e
            java.lang.Object r7 = r6.f28632b     // Catch:{ all -> 0x00b7 }
            if (r7 == r9) goto L_0x0067
            if (r7 == 0) goto L_0x006e
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x006e
        L_0x0067:
            java.lang.Object r7 = r6.f28633c     // Catch:{ all -> 0x00b7 }
            if (r11 != 0) goto L_0x00a4
            r6.f28633c = r10     // Catch:{ all -> 0x00b7 }
            goto L_0x00a4
        L_0x006e:
            j$.util.concurrent.E r7 = r6.f28634d     // Catch:{ all -> 0x00b7 }
            if (r7 != 0) goto L_0x007a
            j$.util.concurrent.E r7 = new j$.util.concurrent.E     // Catch:{ all -> 0x00b7 }
            r7.<init>(r1, r9, r10)     // Catch:{ all -> 0x00b7 }
            r6.f28634d = r7     // Catch:{ all -> 0x00b7 }
            goto L_0x00a3
        L_0x007a:
            int r3 = r3 + 1
            r6 = r7
            goto L_0x0057
        L_0x007e:
            boolean r6 = r5 instanceof j$.util.concurrent.O     // Catch:{ all -> 0x00b7 }
            if (r6 == 0) goto L_0x0096
            r3 = r5
            j$.util.concurrent.O r3 = (j$.util.concurrent.O) r3     // Catch:{ all -> 0x00b7 }
            j$.util.concurrent.P r3 = r3.e(r1, r9, r10)     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x0093
            java.lang.Object r6 = r3.f28633c     // Catch:{ all -> 0x00b7 }
            if (r11 != 0) goto L_0x0091
            r3.f28633c = r10     // Catch:{ all -> 0x00b7 }
        L_0x0091:
            r7 = r6
            goto L_0x0094
        L_0x0093:
            r7 = r0
        L_0x0094:
            r3 = 2
            goto L_0x00a4
        L_0x0096:
            boolean r6 = r5 instanceof j$.util.concurrent.I     // Catch:{ all -> 0x00b7 }
            if (r6 != 0) goto L_0x009b
            goto L_0x00a3
        L_0x009b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
            java.lang.String r10 = "Recursive update"
            r9.<init>(r10)     // Catch:{ all -> 0x00b7 }
            throw r9     // Catch:{ all -> 0x00b7 }
        L_0x00a3:
            r7 = r0
        L_0x00a4:
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x0010
            r9 = 8
            if (r3 < r9) goto L_0x00ae
            r8.treeifyBin(r2, r4)
        L_0x00ae:
            if (r7 == 0) goto L_0x00b1
            return r7
        L_0x00b1:
            r9 = 1
            r8.addCount(r9, r3)
            return r0
        L_0x00b7:
            r9 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            throw r9
        L_0x00ba:
            j$.util.concurrent.E[] r2 = r8.initTable()
            goto L_0x0010
        L_0x00c0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.putVal(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    public <U> U reduce(long j11, j$.util.function.BiFunction<? super K, ? super V, ? extends U> biFunction, j$.util.function.BiFunction<? super U, ? super U, ? extends U> biFunction2) {
        if (biFunction != null && biFunction2 != null) {
            return new C0136w((C0116b) null, batchFor(j11), 0, 0, this.table, (C0136w) null, biFunction, biFunction2).invoke();
        }
        throw null;
    }

    public <U> U reduceEntries(long j11, j$.util.function.Function<Map.Entry<K, V>, ? extends U> function, j$.util.function.BiFunction<? super U, ? super U, ? extends U> biFunction) {
        if (function != null && biFunction != null) {
            return new C0129o((C0116b) null, batchFor(j11), 0, 0, this.table, (C0129o) null, function, biFunction).invoke();
        }
        throw null;
    }

    public Map.Entry<K, V> reduceEntries(long j11, j$.util.function.BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFunction) {
        biFunction.getClass();
        return (Map.Entry) new F((C0116b) null, batchFor(j11), 0, 0, this.table, (F) null, biFunction).invoke();
    }

    public double reduceEntriesToDouble(long j11, ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction, double d11, C0157i iVar) {
        if (toDoubleFunction != null && iVar != null) {
            return ((Double) new C0130p((C0116b) null, batchFor(j11), 0, 0, this.table, (C0130p) null, toDoubleFunction, d11, iVar).invoke()).doubleValue();
        }
        throw null;
    }

    public int reduceEntriesToInt(long j11, ToIntFunction<Map.Entry<K, V>> toIntFunction, int i11, G g11) {
        if (toIntFunction != null && g11 != null) {
            return ((Integer) new C0131q((C0116b) null, batchFor(j11), 0, 0, this.table, (C0131q) null, toIntFunction, i11, g11).invoke()).intValue();
        }
        throw null;
    }

    public long reduceEntriesToLong(long j11, ToLongFunction<Map.Entry<K, V>> toLongFunction, long j12, C0144b0 b0Var) {
        if (toLongFunction != null && b0Var != null) {
            return ((Long) new r((C0116b) null, batchFor(j11), 0, 0, this.table, (r) null, toLongFunction, j12, b0Var).invoke()).longValue();
        }
        throw null;
    }

    public K reduceKeys(long j11, j$.util.function.BiFunction<? super K, ? super K, ? extends K> biFunction) {
        biFunction.getClass();
        return new G((C0116b) null, batchFor(j11), 0, 0, this.table, (G) null, biFunction).invoke();
    }

    public <U> U reduceKeys(long j11, j$.util.function.Function<? super K, ? extends U> function, j$.util.function.BiFunction<? super U, ? super U, ? extends U> biFunction) {
        if (function != null && biFunction != null) {
            return new C0132s((C0116b) null, batchFor(j11), 0, 0, this.table, (C0132s) null, function, biFunction).invoke();
        }
        throw null;
    }

    public double reduceKeysToDouble(long j11, ToDoubleFunction<? super K> toDoubleFunction, double d11, C0157i iVar) {
        if (toDoubleFunction != null && iVar != null) {
            return ((Double) new C0133t((C0116b) null, batchFor(j11), 0, 0, this.table, (C0133t) null, toDoubleFunction, d11, iVar).invoke()).doubleValue();
        }
        throw null;
    }

    public int reduceKeysToInt(long j11, ToIntFunction<? super K> toIntFunction, int i11, G g11) {
        if (toIntFunction != null && g11 != null) {
            return ((Integer) new C0134u((C0116b) null, batchFor(j11), 0, 0, this.table, (C0134u) null, toIntFunction, i11, g11).invoke()).intValue();
        }
        throw null;
    }

    public long reduceKeysToLong(long j11, ToLongFunction<? super K> toLongFunction, long j12, C0144b0 b0Var) {
        if (toLongFunction != null && b0Var != null) {
            return ((Long) new C0135v((C0116b) null, batchFor(j11), 0, 0, this.table, (C0135v) null, toLongFunction, j12, b0Var).invoke()).longValue();
        }
        throw null;
    }

    public double reduceToDouble(long j11, J0 j02, double d11, C0157i iVar) {
        if (j02 != null && iVar != null) {
            return ((Double) new C0137x(batchFor(j11), this.table, d11, iVar).invoke()).doubleValue();
        }
        throw null;
    }

    public int reduceToInt(long j11, L0 l02, int i11, G g11) {
        if (l02 != null && g11 != null) {
            return ((Integer) new y(batchFor(j11), this.table, i11, g11).invoke()).intValue();
        }
        throw null;
    }

    public long reduceToLong(long j11, N0 n02, long j12, C0144b0 b0Var) {
        if (n02 != null && b0Var != null) {
            return ((Long) new z(batchFor(j11), this.table, j12, b0Var).invoke()).longValue();
        }
        throw null;
    }

    public V reduceValues(long j11, j$.util.function.BiFunction<? super V, ? super V, ? extends V> biFunction) {
        biFunction.getClass();
        return new H((C0116b) null, batchFor(j11), 0, 0, this.table, (H) null, biFunction).invoke();
    }

    public <U> U reduceValues(long j11, j$.util.function.Function<? super V, ? extends U> function, j$.util.function.BiFunction<? super U, ? super U, ? extends U> biFunction) {
        if (function != null && biFunction != null) {
            return new A((C0116b) null, batchFor(j11), 0, 0, this.table, (A) null, function, biFunction).invoke();
        }
        throw null;
    }

    public double reduceValuesToDouble(long j11, ToDoubleFunction<? super V> toDoubleFunction, double d11, C0157i iVar) {
        if (toDoubleFunction != null && iVar != null) {
            return ((Double) new B((C0116b) null, batchFor(j11), 0, 0, this.table, (B) null, toDoubleFunction, d11, iVar).invoke()).doubleValue();
        }
        throw null;
    }

    public int reduceValuesToInt(long j11, ToIntFunction<? super V> toIntFunction, int i11, G g11) {
        if (toIntFunction != null && g11 != null) {
            return ((Integer) new C((C0116b) null, batchFor(j11), 0, 0, this.table, (C) null, toIntFunction, i11, g11).invoke()).intValue();
        }
        throw null;
    }

    public long reduceValuesToLong(long j11, ToLongFunction<? super V> toLongFunction, long j12, C0144b0 b0Var) {
        if (toLongFunction != null && b0Var != null) {
            return ((Long) new D((C0116b) null, batchFor(j11), 0, 0, this.table, (D) null, toLongFunction, j12, b0Var).invoke()).longValue();
        }
        throw null;
    }

    public V remove(Object obj) {
        return replaceNode(obj, (Object) null, (Object) null);
    }

    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || replaceNode(obj, (Object) null, obj2) == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean removeEntryIf(Predicate<? super Map.Entry<K, V>> predicate) {
        predicate.getClass();
        E[] eArr = this.table;
        boolean z11 = false;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                Object obj = f11.f28632b;
                Object obj2 = f11.f28633c;
                if (predicate.test(new AbstractMap.SimpleImmutableEntry(obj, obj2)) && replaceNode(obj, (Object) null, obj2) != null) {
                    z11 = true;
                }
            }
        }
        return z11;
    }

    /* access modifiers changed from: package-private */
    public boolean removeValueIf(Predicate<? super V> predicate) {
        predicate.getClass();
        E[] eArr = this.table;
        boolean z11 = false;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                Object obj = f11.f28632b;
                Object obj2 = f11.f28633c;
                if (predicate.test(obj2) && replaceNode(obj, (Object) null, obj2) != null) {
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public V replace(K k11, V v11) {
        if (k11 != null && v11 != null) {
            return replaceNode(k11, v11, (Object) null);
        }
        throw null;
    }

    public boolean replace(K k11, V v11, V v12) {
        if (k11 != null && v11 != null && v12 != null) {
            return replaceNode(k11, v12, v11) != null;
        }
        throw null;
    }

    public void replaceAll(j$.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        biFunction.getClass();
        E[] eArr = this.table;
        if (eArr != null) {
            N n11 = new N(eArr, eArr.length, 0, eArr.length);
            while (true) {
                E f11 = n11.f();
                if (f11 != null) {
                    Object obj = f11.f28633c;
                    Object obj2 = f11.f28632b;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        apply.getClass();
                        if (replaceNode(obj2, apply, obj) != null || (obj = get(obj2)) == null) {
                        }
                        Object apply2 = biFunction.apply(obj2, obj);
                        apply2.getClass();
                        break;
                    } while ((obj = get(obj2)) == null);
                } else {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    /* access modifiers changed from: package-private */
    public final V replaceNode(Object obj, V v11, Object obj2) {
        int length;
        int i11;
        E tabAt;
        V v12;
        boolean z11;
        P b11;
        E untreeify;
        Object obj3;
        int spread = spread(obj.hashCode());
        E[] eArr = this.table;
        while (true) {
            if (eArr == null || (length = eArr.length) == 0 || (tabAt = tabAt(eArr, i11)) == null) {
                break;
            }
            int i12 = tabAt.f28631a;
            if (i12 == -1) {
                eArr = helpTransfer(eArr, tabAt);
            } else {
                synchronized (tabAt) {
                    if (tabAt(eArr, (i11 = (length - 1) & spread)) == tabAt) {
                        z11 = true;
                        if (i12 >= 0) {
                            E e11 = null;
                            E e12 = tabAt;
                            while (true) {
                                if (e12.f28631a != spread || ((obj3 = e12.f28632b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                    E e13 = e12.f28634d;
                                    if (e13 == null) {
                                        break;
                                    }
                                    E e14 = e13;
                                    e11 = e12;
                                    e12 = e14;
                                }
                            }
                            v12 = e12.f28633c;
                            if (obj2 == null || obj2 == v12 || (v12 != null && obj2.equals(v12))) {
                                if (v11 != null) {
                                    e12.f28633c = v11;
                                } else if (e11 != null) {
                                    e11.f28634d = e12.f28634d;
                                } else {
                                    untreeify = e12.f28634d;
                                }
                            }
                            v12 = null;
                        } else if (tabAt instanceof O) {
                            O o11 = (O) tabAt;
                            P p11 = o11.f28664e;
                            if (p11 != null && (b11 = p11.b(spread, obj, (Class) null)) != null) {
                                v12 = b11.f28633c;
                                if (obj2 == null || obj2 == v12 || (v12 != null && obj2.equals(v12))) {
                                    if (v11 != null) {
                                        b11.f28633c = v11;
                                    } else if (o11.f(b11)) {
                                        untreeify = untreeify(o11.f28665f);
                                    }
                                }
                            }
                            v12 = null;
                        } else if (tabAt instanceof I) {
                            throw new IllegalStateException("Recursive update");
                        }
                        setTabAt(eArr, i11, untreeify);
                    }
                    z11 = false;
                    v12 = null;
                }
                if (z11) {
                    if (v12 != null) {
                        if (v11 == null) {
                            addCount(-1, -1);
                        }
                        return v12;
                    }
                }
            }
        }
        return null;
    }

    public <U> U search(long j11, j$.util.function.BiFunction<? super K, ? super V, ? extends U> biFunction) {
        biFunction.getClass();
        return new C0124j((C0116b) null, batchFor(j11), 0, 0, this.table, biFunction, new AtomicReference(), 1).invoke();
    }

    public <U> U searchEntries(long j11, j$.util.function.Function<Map.Entry<K, V>, ? extends U> function) {
        function.getClass();
        return new K((C0116b) null, batchFor(j11), 0, 0, this.table, function, new AtomicReference(), 0).invoke();
    }

    public <U> U searchKeys(long j11, j$.util.function.Function<? super K, ? extends U> function) {
        function.getClass();
        return new K((C0116b) null, batchFor(j11), 0, 0, this.table, function, new AtomicReference(), 1).invoke();
    }

    public <U> U searchValues(long j11, j$.util.function.Function<? super V, ? extends U> function) {
        function.getClass();
        return new K((C0116b) null, batchFor(j11), 0, 0, this.table, function, new AtomicReference(), 2).invoke();
    }

    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    /* access modifiers changed from: package-private */
    public final long sumCount() {
        C0118d[] dVarArr = this.counterCells;
        long j11 = this.baseCount;
        if (dVarArr != null) {
            for (C0118d dVar : dVarArr) {
                if (dVar != null) {
                    j11 += dVar.value;
                }
            }
        }
        return j11;
    }

    public String toString() {
        E[] eArr = this.table;
        int length = eArr == null ? 0 : eArr.length;
        N n11 = new N(eArr, length, 0, length);
        StringBuilder sb2 = new StringBuilder("{");
        E f11 = n11.f();
        if (f11 != null) {
            while (true) {
                Object obj = f11.f28632b;
                Object obj2 = f11.f28633c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb2.append(obj);
                sb2.append(SignatureVisitor.INSTANCEOF);
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb2.append(obj2);
                f11 = n11.f();
                if (f11 == null) {
                    break;
                }
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    public java.util.Collection<V> values() {
        Q q11 = this.values;
        if (q11 != null) {
            return q11;
        }
        Q q12 = new Q(this);
        this.values = q12;
        return q12;
    }
}
