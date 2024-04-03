package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¨\u0006\u0004"}, d2 = {"T", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "it", "org/koin/core/registry/InstanceRegistry$declareInstance$def$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$declare$1$invoke$$inlined$declareInstance$1 extends Lambda implements Function2<Scope, ParametersHolder, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f62740g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$declare$1$invoke$$inlined$declareInstance$1(Object obj) {
        super(2);
        this.f62740g = obj;
    }

    public final T invoke(@NotNull Scope scope, @NotNull ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$createDefinition");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        return this.f62740g;
    }
}
