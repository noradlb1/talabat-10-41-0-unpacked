package j$.util.stream;

import j$.util.C0189n;
import j$.util.D;
import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Comparator;
import java.util.Objects;

final class S3 implements D {

    /* renamed from: a  reason: collision with root package name */
    private int f29034a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29035b;

    /* renamed from: c  reason: collision with root package name */
    private int f29036c;

    private S3(int i11, int i12, int i13) {
        this.f29034a = i11;
        this.f29035b = i12;
        this.f29036c = i13;
    }

    S3(int i11, int i12, boolean z11) {
        this(i11, i12, z11 ? 1 : 0);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* renamed from: c */
    public final void forEachRemaining(K k11) {
        Objects.requireNonNull(k11);
        int i11 = this.f29034a;
        int i12 = this.f29036c;
        int i13 = this.f29035b;
        this.f29034a = i13;
        this.f29036c = 0;
        while (i11 < i13) {
            k11.accept(i11);
            i11++;
        }
        if (i12 > 0) {
            k11.accept(i11);
        }
    }

    public final int characteristics() {
        return 17749;
    }

    public final long estimateSize() {
        return (((long) this.f29035b) - ((long) this.f29034a)) + ((long) this.f29036c);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    public final Comparator getComparator() {
        return null;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* renamed from: j */
    public final boolean tryAdvance(K k11) {
        Objects.requireNonNull(k11);
        int i11 = this.f29034a;
        if (i11 < this.f29035b) {
            this.f29034a = i11 + 1;
        } else if (this.f29036c <= 0) {
            return false;
        } else {
            this.f29036c = 0;
        }
        k11.accept(i11);
        return true;
    }

    public final D trySplit() {
        long estimateSize = estimateSize();
        if (estimateSize <= 1) {
            return null;
        }
        int i11 = this.f29034a;
        int i12 = ((int) (estimateSize / ((long) (estimateSize < 16777216 ? 2 : 8)))) + i11;
        this.f29034a = i12;
        return new S3(i11, i12, 0);
    }
}
