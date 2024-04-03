package s2;

import android.content.Intent;
import androidx.window.embedding.EmbeddingAdapter;
import j$.util.function.Predicate;
import java.util.Set;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f44395a;

    public /* synthetic */ d(Set set) {
        this.f44395a = set;
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
        return EmbeddingAdapter.m9126translateIntentPredicates$lambda8(this.f44395a, (Intent) obj);
    }
}
