package j$.util.stream;

import j$.util.C0182g;
import j$.util.C0183h;
import j$.util.function.A0;
import j$.util.function.BiConsumer;
import j$.util.function.C0144b0;
import j$.util.function.C0158i0;
import j$.util.function.Consumer;
import j$.util.function.D0;
import j$.util.function.G;
import j$.util.function.IntFunction;

public final /* synthetic */ class X implements G, A0, BiConsumer, IntFunction, C0144b0, C0158i0, D0, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29060a;

    public /* synthetic */ X(int i11) {
        this.f29060a = i11;
    }

    public final void accept(Object obj) {
    }

    public final void accept(Object obj, int i11) {
        ((C0182g) obj).accept(i11);
    }

    public final void accept(Object obj, long j11) {
        ((C0183h) obj).accept(j11);
    }

    public final void accept(Object obj, Object obj2) {
        switch (this.f29060a) {
            case 2:
                ((C0182g) obj).a((C0182g) obj2);
                return;
            default:
                ((C0183h) obj).a((C0183h) obj2);
                return;
        }
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f29060a) {
            case 2:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object apply(int i11) {
        return Integer.valueOf(i11);
    }

    public final Object apply(long j11) {
        return Long.valueOf(j11);
    }

    public final int applyAsInt(int i11, int i12) {
        switch (this.f29060a) {
            case 0:
                return i11 + i12;
            default:
                return Math.max(i11, i12);
        }
    }

    public final long applyAsLong(long j11, long j12) {
        switch (this.f29060a) {
            case 5:
                return Math.max(j11, j12);
            case 7:
                return j11 + j12;
            default:
                return Math.min(j11, j12);
        }
    }
}
