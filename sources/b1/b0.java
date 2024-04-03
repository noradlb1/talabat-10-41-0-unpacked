package b1;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class b0 implements Predicate {
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
        return IntentSanitizer.Builder.lambda$new$4((String) obj);
    }
}
