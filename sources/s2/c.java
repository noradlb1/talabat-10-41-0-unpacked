package s2;

import android.view.WindowMetrics;
import androidx.window.embedding.EmbeddingAdapter;
import androidx.window.embedding.SplitRule;
import j$.util.function.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplitRule f44394a;

    public /* synthetic */ c(SplitRule splitRule) {
        this.f44394a = splitRule;
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
        return EmbeddingAdapter.m9127translateParentMetricsPredicate$lambda4(this.f44394a, (WindowMetrics) obj);
    }
}
