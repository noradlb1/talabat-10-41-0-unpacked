package j$.util.function;

import j$.util.function.BiPredicate;
import j$.util.function.IntPredicate;
import j$.util.function.Predicate;

/* renamed from: j$.util.function.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0145c implements BiPredicate, IntPredicate, Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f28836b;

    public /* synthetic */ C0145c(int i11, Object obj) {
        this.f28835a = i11;
        this.f28836b = obj;
    }

    public final /* synthetic */ BiPredicate and(BiPredicate biPredicate) {
        return BiPredicate.CC.$default$and(this, biPredicate);
    }

    public final /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return IntPredicate.CC.$default$and(this, intPredicate);
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f28835a) {
            case 2:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    public final /* synthetic */ BiPredicate or(BiPredicate biPredicate) {
        return BiPredicate.CC.$default$or(this, biPredicate);
    }

    public final /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return IntPredicate.CC.$default$or(this, intPredicate);
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f28835a) {
            case 2:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    public final boolean test(int i11) {
        return !((IntPredicate) this.f28836b).test(i11);
    }

    public final boolean test(Object obj) {
        int i11 = this.f28835a;
        Object obj2 = this.f28836b;
        switch (i11) {
            case 2:
                return obj2.equals(obj);
            default:
                return !((Predicate) obj2).test(obj);
        }
    }

    public final boolean test(Object obj, Object obj2) {
        return !((BiPredicate) this.f28836b).test(obj, obj2);
    }
}
