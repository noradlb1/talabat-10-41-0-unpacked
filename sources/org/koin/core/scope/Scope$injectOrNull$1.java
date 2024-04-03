package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.Nullable;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$injectOrNull$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62754g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62755h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62756i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$injectOrNull$1(Scope scope, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.f62754g = scope;
        this.f62755h = qualifier;
        this.f62756i = function0;
    }

    @Nullable
    public final T invoke() {
        Scope scope = this.f62754g;
        Qualifier qualifier = this.f62755h;
        Function0<ParametersHolder> function0 = this.f62756i;
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }
}
