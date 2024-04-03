package a40;

import j$.util.function.Predicate;
import java.util.Map;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;

public final /* synthetic */ class c implements Predicate {
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
        return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$2((Map.Entry) obj);
    }
}
