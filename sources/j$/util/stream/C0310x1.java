package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.x1  reason: case insensitive filesystem */
abstract class C0310x1 extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    protected final H0 f29268a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f29269b;

    C0310x1(H0 h02) {
        this.f29268a = h02;
        this.f29269b = 0;
    }

    C0310x1(C0310x1 x1Var, H0 h02, int i11) {
        super(x1Var);
        this.f29268a = h02;
        this.f29269b = i11;
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract C0305w1 b(int i11, int i12);

    public final void compute() {
        C0310x1 x1Var = this;
        while (x1Var.f29268a.j() != 0) {
            x1Var.setPendingCount(x1Var.f29268a.j() - 1);
            int i11 = 0;
            int i12 = 0;
            while (i11 < x1Var.f29268a.j() - 1) {
                C0305w1 b11 = x1Var.b(i11, x1Var.f29269b + i12);
                i12 = (int) (((long) i12) + b11.f29268a.count());
                b11.fork();
                i11++;
            }
            x1Var = x1Var.b(i11, x1Var.f29269b + i12);
        }
        x1Var.a();
        x1Var.propagateCompletion();
    }
}
