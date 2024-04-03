package f30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.execution.ConditionEvaluator;

public final /* synthetic */ class b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConditionEvaluator f62037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62038b;

    public /* synthetic */ b(ConditionEvaluator conditionEvaluator, ExtensionContext extensionContext) {
        this.f62037a = conditionEvaluator;
        this.f62038b = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62037a.lambda$evaluate$0(this.f62038b, (ExecutionCondition) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
