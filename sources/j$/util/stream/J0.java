package j$.util.stream;

abstract class J0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    protected final H0 f28948a;

    /* renamed from: b  reason: collision with root package name */
    protected final H0 f28949b;

    /* renamed from: c  reason: collision with root package name */
    private final long f28950c;

    J0(H0 h02, H0 h03) {
        this.f28948a = h02;
        this.f28949b = h03;
        this.f28950c = h02.count() + h03.count();
    }

    public final H0 a(int i11) {
        if (i11 == 0) {
            return this.f28948a;
        }
        if (i11 == 1) {
            return this.f28949b;
        }
        throw new IndexOutOfBoundsException();
    }

    public final long count() {
        return this.f28950c;
    }

    public final int j() {
        return 2;
    }
}
