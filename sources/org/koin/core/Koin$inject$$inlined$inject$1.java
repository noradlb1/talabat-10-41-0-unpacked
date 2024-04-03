package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/core/scope/Scope$inject$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$inject$$inlined$inject$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62702g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62703h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f62704i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$inject$$inlined$inject$1(Scope scope, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f62702g = scope;
        this.f62703h = qualifier;
        this.f62704i = function0;
    }

    @NotNull
    public final T invoke() {
        Scope scope = this.f62702g;
        Qualifier qualifier = this.f62703h;
        Function0 function0 = this.f62704i;
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }
}
