package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.Disabled;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisabledCondition f62584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f62585b;

    public /* synthetic */ a(DisabledCondition disabledCondition, AnnotatedElement annotatedElement) {
        this.f62584a = disabledCondition;
        this.f62585b = annotatedElement;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62584a.lambda$evaluateExecutionCondition$0(this.f62585b, (Disabled) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
