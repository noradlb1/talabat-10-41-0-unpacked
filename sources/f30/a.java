package f30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62034a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConditionEvaluationResult f62036c;

    public /* synthetic */ a(Class cls, ExtensionContext extensionContext, ConditionEvaluationResult conditionEvaluationResult) {
        this.f62034a = cls;
        this.f62035b = extensionContext;
        this.f62036c = conditionEvaluationResult;
    }

    public final Object get() {
        return String.format("Evaluation of condition [%s] on [%s] resulted in: %s", new Object[]{this.f62034a.getName(), this.f62035b.getElement().get(), this.f62036c});
    }
}
