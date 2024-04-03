package s2;

import android.app.Activity;
import androidx.window.embedding.EmbeddingAdapter;
import j$.util.function.Predicate;
import java.util.Set;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f44393a;

    public /* synthetic */ b(Set set) {
        this.f44393a = set;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m9125translateActivityPredicates$lambda6(this.f44393a, (Activity) obj);
    }
}
