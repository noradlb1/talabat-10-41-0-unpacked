package d30;

import j$.util.function.Predicate;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class v0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f61924a;

    public /* synthetic */ v0(AnnotatedElement annotatedElement) {
        this.f61924a = annotatedElement;
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
        return JupiterTestDescriptor.lambda$getTags$1(this.f61924a, (String) obj);
    }
}
