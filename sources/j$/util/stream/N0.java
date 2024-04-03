package j$.util.stream;

import j$.util.C0140f;
import j$.util.C0182g;
import j$.util.C0183h;
import j$.util.C0185j;
import j$.util.C0186k;
import j$.util.C0187l;
import j$.util.Optional;
import j$.util.StringJoiner;
import j$.util.function.BiConsumer;
import j$.util.function.C0157i;
import j$.util.function.C0158i0;
import j$.util.function.C0171p;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.G;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class N0 implements C0158i0, IntFunction, Consumer, BiConsumer, Supplier, Function, C0157i, C0171p, x0, Predicate, G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28984a;

    public /* synthetic */ N0(int i11) {
        this.f28984a = i11;
    }

    public final void accept(Object obj) {
    }

    public final void accept(Object obj, double d11) {
        ((C0140f) obj).accept(d11);
    }

    public final void accept(Object obj, Object obj2) {
        switch (this.f28984a) {
            case 7:
                ((Collection) obj).add(obj2);
                return;
            case 10:
                ((Set) obj).add(obj2);
                return;
            case 11:
                ((StringJoiner) obj).add((CharSequence) obj2);
                return;
            case 16:
                ((List) obj).add(obj2);
                return;
            case 18:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 19:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            default:
                ((C0140f) obj).a((C0140f) obj2);
                return;
        }
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f28984a) {
            case 25:
                return Predicate.CC.$default$and(this, predicate);
            case 26:
                return Predicate.CC.$default$and(this, predicate);
            case 27:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f28984a) {
            case 7:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 10:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 11:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 16:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 18:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 19:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f28984a) {
            case 5:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(double d11) {
        return Double.valueOf(d11);
    }

    public final Object apply(int i11) {
        switch (this.f28984a) {
            case 1:
                return new Object[i11];
            case 2:
                return new Integer[i11];
            case 3:
                return new Long[i11];
            default:
                return new Double[i11];
        }
    }

    public final Object apply(long j11) {
        return C0314y0.V0(j11);
    }

    public final Object apply(Object obj) {
        return ((StringJoiner) obj).toString();
    }

    public final double applyAsDouble(double d11, double d12) {
        switch (this.f28984a) {
            case 20:
                return Math.min(d11, d12);
            default:
                return Math.max(d11, d12);
        }
    }

    public final int applyAsInt(int i11, int i12) {
        return Math.min(i11, i12);
    }

    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }

    public final Object get() {
        switch (this.f28984a) {
            case 8:
                return new C0140f();
            case 9:
                return new HashSet();
            case 13:
                return new C0182g();
            case 14:
                return new C0183h();
            case 15:
                return new ArrayList();
            default:
                return new LinkedHashSet();
        }
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f28984a) {
            case 25:
                return Predicate.CC.$default$negate(this);
            case 26:
                return Predicate.CC.$default$negate(this);
            case 27:
                return Predicate.CC.$default$negate(this);
            default:
                return Predicate.CC.$default$negate(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f28984a) {
            case 25:
                return Predicate.CC.$default$or(this, predicate);
            case 26:
                return Predicate.CC.$default$or(this, predicate);
            case 27:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    public final boolean test(Object obj) {
        switch (this.f28984a) {
            case 25:
                return ((C0185j) obj).c();
            case 26:
                return ((C0186k) obj).c();
            case 27:
                return ((C0187l) obj).c();
            default:
                return ((Optional) obj).isPresent();
        }
    }
}
