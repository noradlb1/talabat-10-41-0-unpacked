package b1;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class r implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f11572a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f11573b;

    public /* synthetic */ r(Class cls, Predicate predicate) {
        this.f11572a = cls;
        this.f11573b = predicate;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return j.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return j.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return j.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f11572a, this.f11573b, obj);
    }
}
