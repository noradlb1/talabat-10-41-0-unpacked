package s2;

import android.util.Pair;
import androidx.window.embedding.EmbeddingAdapter;
import j$.util.function.Predicate;
import java.util.Set;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f44396a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f44397b;

    public /* synthetic */ e(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f44396a = embeddingAdapter;
        this.f44397b = set;
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
        return EmbeddingAdapter.m9124translateActivityPairPredicates$lambda1(this.f44396a, this.f44397b, (Pair) obj);
    }
}
