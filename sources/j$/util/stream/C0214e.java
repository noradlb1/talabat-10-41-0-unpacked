package j$.util.stream;

/* renamed from: j$.util.stream.e  reason: case insensitive filesystem */
abstract class C0214e {

    /* renamed from: a  reason: collision with root package name */
    protected final int f29131a;

    /* renamed from: b  reason: collision with root package name */
    protected int f29132b;

    /* renamed from: c  reason: collision with root package name */
    protected int f29133c;

    /* renamed from: d  reason: collision with root package name */
    protected long[] f29134d;

    protected C0214e() {
        this.f29131a = 4;
    }

    protected C0214e(int i11) {
        if (i11 >= 0) {
            this.f29131a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i11 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i11);
    }

    public abstract void clear();

    public final long count() {
        int i11 = this.f29133c;
        return i11 == 0 ? (long) this.f29132b : this.f29134d[i11] + ((long) this.f29132b);
    }
}
