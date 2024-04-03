package s2;

import android.util.Pair;
import androidx.window.embedding.EmbeddingAdapter;
import j$.util.function.Predicate;
import java.util.Set;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmbeddingAdapter f44391a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f44392b;

    public /* synthetic */ a(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f44391a = embeddingAdapter;
        this.f44392b = set;
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
        return EmbeddingAdapter.m9123translateActivityIntentPredicates$lambda3(this.f44391a, this.f44392b, (Pair) obj);
    }
}
