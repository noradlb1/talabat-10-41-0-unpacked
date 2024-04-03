package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: j$.util.stream.d3  reason: case insensitive filesystem */
enum C0213d3 {
    DISTINCT(0, r2),
    SORTED(1, r6),
    ORDERED(2, r8),
    SIZED(3, r11),
    SHORT_CIRCUIT(12, r14);
    

    /* renamed from: f  reason: collision with root package name */
    static final int f29109f = 0;

    /* renamed from: g  reason: collision with root package name */
    static final int f29110g = 0;

    /* renamed from: h  reason: collision with root package name */
    static final int f29111h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f29112i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final int f29113j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static final int f29114k = 0;

    /* renamed from: l  reason: collision with root package name */
    static final int f29115l = 0;

    /* renamed from: m  reason: collision with root package name */
    static final int f29116m = 0;

    /* renamed from: n  reason: collision with root package name */
    static final int f29117n = 0;

    /* renamed from: o  reason: collision with root package name */
    static final int f29118o = 0;

    /* renamed from: p  reason: collision with root package name */
    static final int f29119p = 0;

    /* renamed from: q  reason: collision with root package name */
    static final int f29120q = 0;

    /* renamed from: r  reason: collision with root package name */
    static final int f29121r = 0;

    /* renamed from: s  reason: collision with root package name */
    static final int f29122s = 0;

    /* renamed from: t  reason: collision with root package name */
    static final int f29123t = 0;

    /* renamed from: u  reason: collision with root package name */
    static final int f29124u = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Map f29126a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29127b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29128c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29129d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29130e;

    static {
        C0208c3 c3Var;
        C0208c3 c3Var2;
        C0208c3 c3Var3;
        int i11;
        C0208c3 c3Var4;
        C0208c3 c3Var5;
        f29109f = g(c3Var);
        f29110g = g(c3Var2);
        f29111h = g(c3Var3);
        g(c3Var4);
        g(c3Var5);
        int i12 = 0;
        for (C0213d3 d3Var : values()) {
            i12 |= d3Var.f29130e;
        }
        f29112i = i12;
        int i13 = f29110g;
        f29113j = i13;
        int i14 = i13 << 1;
        f29114k = i14;
        f29115l = i13 | i14;
        C0213d3 d3Var2 = DISTINCT;
        f29116m = d3Var2.f29128c;
        f29117n = d3Var2.f29129d;
        C0213d3 d3Var3 = SORTED;
        f29118o = d3Var3.f29128c;
        f29119p = d3Var3.f29129d;
        C0213d3 d3Var4 = ORDERED;
        f29120q = d3Var4.f29128c;
        f29121r = d3Var4.f29129d;
        C0213d3 d3Var5 = SIZED;
        f29122s = d3Var5.f29128c;
        f29123t = d3Var5.f29129d;
        f29124u = SHORT_CIRCUIT.f29128c;
    }

    private C0213d3(int i11, C0203b3 b3Var) {
        C0208c3[] values = C0208c3.values();
        int length = values.length;
        int i12 = 0;
        while (true) {
            Map map = b3Var.f29087a;
            if (i12 < length) {
                Map.EL.putIfAbsent(map, values[i12], 0);
                i12++;
            } else {
                this.f29126a = map;
                int i13 = i11 * 2;
                this.f29127b = i13;
                this.f29128c = 1 << i13;
                this.f29129d = 2 << i13;
                this.f29130e = 3 << i13;
                return;
            }
        }
    }

    static int B(int i11) {
        return i11 & ((~i11) >> 1) & f29113j;
    }

    static int f(int i11, int i12) {
        return i11 | (i12 & (i11 == 0 ? f29112i : ~(((f29113j & i11) << 1) | i11 | ((f29114k & i11) >> 1))));
    }

    private static int g(C0208c3 c3Var) {
        int i11 = 0;
        for (C0213d3 d3Var : values()) {
            i11 |= ((Integer) d3Var.f29126a.get(c3Var)).intValue() << d3Var.f29127b;
        }
        return i11;
    }

    static int h(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        int i11 = characteristics & 4;
        int i12 = f29109f;
        return (i11 == 0 || spliterator.getComparator() == null) ? characteristics & i12 : characteristics & i12 & -5;
    }

    private static C0203b3 v(C0208c3 c3Var) {
        C0203b3 b3Var = new C0203b3(new EnumMap(C0208c3.class));
        b3Var.a(c3Var);
        return b3Var;
    }

    /* access modifiers changed from: package-private */
    public final boolean k(int i11) {
        return (i11 & this.f29130e) == this.f29128c;
    }

    /* access modifiers changed from: package-private */
    public final boolean s(int i11) {
        int i12 = this.f29130e;
        return (i11 & i12) == i12;
    }
}
