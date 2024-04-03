package b1;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class h0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f11568a;

    public /* synthetic */ h0(UriMatcher uriMatcher) {
        this.f11568a = uriMatcher;
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
        return UriMatcherCompat.lambda$asPredicate$0(this.f11568a, (Uri) obj);
    }
}
