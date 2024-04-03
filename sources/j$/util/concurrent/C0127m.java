package j$.util.concurrent;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.util.concurrent.m  reason: case insensitive filesystem */
final class C0127m extends N implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f28718i;

    /* renamed from: j  reason: collision with root package name */
    long f28719j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0127m(E[] eArr, int i11, int i12, int i13, long j11, int i14) {
        super(eArr, i11, i12, i13);
        this.f28718i = i14;
        this.f28719j = j11;
    }

    public final boolean a(Consumer consumer) {
        switch (this.f28718i) {
            case 0:
                consumer.getClass();
                E f11 = f();
                if (f11 == null) {
                    return false;
                }
                consumer.accept(f11.f28632b);
                return true;
            default:
                consumer.getClass();
                E f12 = f();
                if (f12 == null) {
                    return false;
                }
                consumer.accept(f12.f28633c);
                return true;
        }
    }

    public final int characteristics() {
        switch (this.f28718i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    public final long estimateSize() {
        switch (this.f28718i) {
            case 0:
                return this.f28719j;
            default:
                return this.f28719j;
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        switch (this.f28718i) {
            case 0:
                consumer.getClass();
                while (true) {
                    E f11 = f();
                    if (f11 != null) {
                        consumer.accept(f11.f28632b);
                    } else {
                        return;
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    E f12 = f();
                    if (f12 != null) {
                        consumer.accept(f12.f28633c);
                    } else {
                        return;
                    }
                }
        }
    }

    public final Comparator getComparator() {
        switch (this.f28718i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f28718i) {
            case 0:
                return C0189n.i(this);
            default:
                return C0189n.i(this);
        }
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        switch (this.f28718i) {
            case 0:
                return C0189n.k(this, i11);
            default:
                return C0189n.k(this, i11);
        }
    }

    public final Spliterator trySplit() {
        switch (this.f28718i) {
            case 0:
                int i11 = this.f28659f;
                int i12 = this.f28660g;
                int i13 = (i11 + i12) >>> 1;
                if (i13 <= i11) {
                    return null;
                }
                E[] eArr = this.f28654a;
                int i14 = this.f28661h;
                this.f28660g = i13;
                long j11 = this.f28719j >>> 1;
                this.f28719j = j11;
                return new C0127m(eArr, i14, i13, i12, j11, 0);
            default:
                int i15 = this.f28659f;
                int i16 = this.f28660g;
                int i17 = (i15 + i16) >>> 1;
                if (i17 <= i15) {
                    return null;
                }
                E[] eArr2 = this.f28654a;
                int i18 = this.f28661h;
                this.f28660g = i17;
                long j12 = this.f28719j >>> 1;
                this.f28719j = j12;
                return new C0127m(eArr2, i18, i17, i16, j12, 1);
        }
    }
}
