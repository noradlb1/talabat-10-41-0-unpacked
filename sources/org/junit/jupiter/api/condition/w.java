package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import java.lang.annotation.Annotation;

public final /* synthetic */ class w implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedCondition f57142a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Annotation f57143b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f57144c;

    public /* synthetic */ w(MethodBasedCondition methodBasedCondition, Annotation annotation, boolean z11) {
        this.f57142a = methodBasedCondition;
        this.f57143b = annotation;
        this.f57144c = z11;
    }

    public final Object get() {
        return this.f57142a.lambda$buildConditionEvaluationResult$7(this.f57143b, this.f57144c);
    }
}
