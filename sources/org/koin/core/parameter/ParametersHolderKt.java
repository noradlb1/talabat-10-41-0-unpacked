package org.koin.core.parameter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a#\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006*\u0016\u0010\u0007\"\b\u0012\u0004\u0012\u00020\u00010\b2\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"emptyParametersHolder", "Lorg/koin/core/parameter/ParametersHolder;", "parametersOf", "parameters", "", "", "([Ljava/lang/Object;)Lorg/koin/core/parameter/ParametersHolder;", "ParametersDefinition", "Lkotlin/Function0;", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParametersHolderKt {
    @NotNull
    public static final ParametersHolder emptyParametersHolder() {
        return new ParametersHolder((List) null, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final ParametersHolder parametersOf(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "parameters");
        return new ParametersHolder(ArraysKt___ArraysKt.toMutableList((T[]) objArr));
    }
}
