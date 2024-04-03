package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lorg/koin/core/instance/InstanceContext;", "", "koin", "Lorg/koin/core/Koin;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "(Lorg/koin/core/Koin;Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)V", "getKoin", "()Lorg/koin/core/Koin;", "getParameters", "()Lorg/koin/core/parameter/ParametersHolder;", "getScope", "()Lorg/koin/core/scope/Scope;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstanceContext {
    @NotNull
    private final Koin koin;
    @Nullable
    private final ParametersHolder parameters;
    @NotNull
    private final Scope scope;

    public InstanceContext(@NotNull Koin koin2, @NotNull Scope scope2, @Nullable ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(koin2, "koin");
        Intrinsics.checkNotNullParameter(scope2, "scope");
        this.koin = koin2;
        this.scope = scope2;
        this.parameters = parametersHolder;
    }

    @NotNull
    public final Koin getKoin() {
        return this.koin;
    }

    @Nullable
    public final ParametersHolder getParameters() {
        return this.parameters;
    }

    @NotNull
    public final Scope getScope() {
        return this.scope;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstanceContext(Koin koin2, Scope scope2, ParametersHolder parametersHolder, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(koin2, scope2, (i11 & 4) != 0 ? null : parametersHolder);
    }
}
