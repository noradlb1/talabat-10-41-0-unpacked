package j$.util.function;

import java.util.function.DoublePredicate;

public final /* synthetic */ class r implements DoublePredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0174s f28862a;

    private /* synthetic */ r(C0174s sVar) {
        this.f28862a = sVar;
    }

    public static /* synthetic */ DoublePredicate a(C0174s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar instanceof C0173q ? ((C0173q) sVar).f28860a : new r(sVar);
    }

    public final /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return a(((C0173q) this.f28862a).a(C0173q.b(doublePredicate)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0174s sVar = this.f28862a;
        if (obj instanceof r) {
            obj = ((r) obj).f28862a;
        }
        return sVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28862a.hashCode();
    }

    public final /* synthetic */ DoublePredicate negate() {
        return a(((C0173q) this.f28862a).c());
    }

    public final /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return a(((C0173q) this.f28862a).d(C0173q.b(doublePredicate)));
    }

    public final /* synthetic */ boolean test(double d11) {
        return ((C0173q) this.f28862a).e(d11);
    }
}
