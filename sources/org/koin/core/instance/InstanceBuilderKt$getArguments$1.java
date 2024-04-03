package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class InstanceBuilderKt$getArguments$1 extends Lambda implements Function0<ParametersHolder> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ParametersHolder f62724g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstanceBuilderKt$getArguments$1(ParametersHolder parametersHolder) {
        super(0);
        this.f62724g = parametersHolder;
    }

    @NotNull
    public final ParametersHolder invoke() {
        return this.f62724g;
    }
}
