package b1;

import android.net.Uri;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class p implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f11571a;

    public /* synthetic */ p(String str) {
        this.f11571a = str;
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
        return this.f11571a.equals(((Uri) obj).getAuthority());
    }
}
