package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.instance.InstanceBuilderKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"Landroidx/fragment/app/Fragment;", "T", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ModuleExtKt$fragment$1 extends Lambda implements Function2<Scope, ParametersHolder, T> {
    public ModuleExtKt$fragment$1() {
        super(2);
    }

    @NotNull
    public final T invoke(@NotNull Scope scope, @NotNull ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (Fragment) InstanceBuilderKt.newInstance(scope, Reflection.getOrCreateKotlinClass(Object.class), parametersHolder);
    }
}
