package y20;

import j$.util.function.Predicate;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;

public final /* synthetic */ class a implements Predicate {
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
        return ((ConditionEvaluationResult) obj).isDisabled();
    }
}
