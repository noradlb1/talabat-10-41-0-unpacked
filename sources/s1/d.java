package s1;

import android.content.ClipData;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j$.util.function.Predicate f11612a;

    public /* synthetic */ d(j$.util.function.Predicate predicate) {
        this.f11612a = predicate;
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
        return this.f11612a.test((ClipData.Item) obj);
    }
}
