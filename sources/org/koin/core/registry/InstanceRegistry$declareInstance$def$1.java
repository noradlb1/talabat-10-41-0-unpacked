package org.koin.core.registry;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"T", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class InstanceRegistry$declareInstance$def$1 extends Lambda implements Function2<Scope, ParametersHolder, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f62734g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstanceRegistry$declareInstance$def$1(T t11) {
        super(2);
        this.f62734g = t11;
    }

    public final T invoke(@NotNull Scope scope, @NotNull ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$createDefinition");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        return this.f62734g;
    }
}
