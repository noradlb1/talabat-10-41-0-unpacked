package org.koin.core.instance;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class InstanceBuilderKt$newInstance$args$1 extends Lambda implements Function0<Object[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Constructor<?> f62727g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Scope f62728h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ParametersHolder f62729i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstanceBuilderKt$newInstance$args$1(Constructor<?> constructor, Scope scope, ParametersHolder parametersHolder) {
        super(0);
        this.f62727g = constructor;
        this.f62728h = scope;
        this.f62729i = parametersHolder;
    }

    @NotNull
    public final Object[] invoke() {
        return InstanceBuilderKt.getArguments(this.f62727g, this.f62728h, this.f62729i);
    }
}
