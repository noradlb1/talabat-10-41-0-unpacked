package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BooleanSupplier;
import j$.util.function.C0158i0;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import java.util.List;
import java.util.Set;

/* renamed from: j$.util.stream.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0194a implements Supplier, Function, BiConsumer, C0158i0, Consumer, BooleanSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29077a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f29078b;

    public /* synthetic */ C0194a(int i11, Object obj) {
        this.f29077a = i11;
        this.f29078b = obj;
    }

    public final void accept(Object obj) {
        int i11 = this.f29077a;
        Object obj2 = this.f29078b;
        switch (i11) {
            case 5:
                ((C0272p2) obj2).accept(obj);
                return;
            default:
                ((List) obj2).add(obj);
                return;
        }
    }

    public final void accept(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        Set set = Collectors.f28907a;
        jArr[0] = ((ToLongFunction) this.f29078b).applyAsLong(obj2) + jArr[0];
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29077a) {
            case 5:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(long j11) {
        int i11 = M0.f28975k;
        return C0314y0.D0(j11, (IntFunction) this.f29078b);
    }

    public final Object apply(Object obj) {
        Set set = Collectors.f28907a;
        return ((Supplier) this.f29078b).get();
    }

    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }

    public final Object get() {
        int i11 = this.f29077a;
        Object obj = this.f29078b;
        switch (i11) {
            case 0:
                return (Spliterator) obj;
            default:
                return ((C0204c) obj).q1();
        }
    }

    public final boolean getAsBoolean() {
        int i11 = this.f29077a;
        Object obj = this.f29078b;
        switch (i11) {
            case 6:
                C0292t3 t3Var = (C0292t3) obj;
                return t3Var.f29146d.a(t3Var.f29147e);
            case 7:
                C0302v3 v3Var = (C0302v3) obj;
                return v3Var.f29146d.a(v3Var.f29147e);
            case 8:
                C0312x3 x3Var = (C0312x3) obj;
                return x3Var.f29146d.a(x3Var.f29147e);
            default:
                P3 p32 = (P3) obj;
                return p32.f29146d.a(p32.f29147e);
        }
    }
}
