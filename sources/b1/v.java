package b1;

import android.content.ComponentName;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class v implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f11577a;

    public /* synthetic */ v(ComponentName componentName) {
        this.f11577a = componentName;
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
        return this.f11577a.equals((ComponentName) obj);
    }
}
