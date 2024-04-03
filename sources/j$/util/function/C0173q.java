package j$.util.function;

import java.util.function.DoublePredicate;

/* renamed from: j$.util.function.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0173q implements C0174s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoublePredicate f28860a;

    private /* synthetic */ C0173q(DoublePredicate doublePredicate) {
        this.f28860a = doublePredicate;
    }

    public static /* synthetic */ C0174s b(DoublePredicate doublePredicate) {
        if (doublePredicate == null) {
            return null;
        }
        return doublePredicate instanceof r ? ((r) doublePredicate).f28862a : new C0173q(doublePredicate);
    }

    public final /* synthetic */ C0174s a(C0174s sVar) {
        return b(this.f28860a.and(r.a(sVar)));
    }

    public final /* synthetic */ C0174s c() {
        return b(this.f28860a.negate());
    }

    public final /* synthetic */ C0174s d(C0174s sVar) {
        return b(this.f28860a.or(r.a(sVar)));
    }

    public final /* synthetic */ boolean e(double d11) {
        return this.f28860a.test(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0173q) {
            obj = ((C0173q) obj).f28860a;
        }
        return this.f28860a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28860a.hashCode();
    }
}
