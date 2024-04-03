package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.Nullable;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"", "T", "org/koin/core/scope/Scope$injectOrNull$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$injectOrNull$$inlined$injectOrNull$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62705g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62706h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0 f62707i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$injectOrNull$$inlined$injectOrNull$1(Scope scope, Qualifier qualifier, Function0 function0) {
        super(0);
        this.f62705g = scope;
        this.f62706h = qualifier;
        this.f62707i = function0;
    }

    @Nullable
    public final T invoke() {
        Scope scope = this.f62705g;
        Qualifier qualifier = this.f62706h;
        Function0 function0 = this.f62707i;
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }
}
