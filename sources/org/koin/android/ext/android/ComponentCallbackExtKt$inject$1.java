package org.koin.android.ext.android;

import android.content.ComponentCallbacks;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComponentCallbackExtKt$inject$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComponentCallbacks f62638g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Qualifier f62639h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<ParametersHolder> f62640i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentCallbackExtKt$inject$1(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        super(0);
        this.f62638g = componentCallbacks;
        this.f62639h = qualifier;
        this.f62640i = function0;
    }

    @NotNull
    public final T invoke() {
        ComponentCallbacks componentCallbacks = this.f62638g;
        Qualifier qualifier = this.f62639h;
        Function0<ParametersHolder> function0 = this.f62640i;
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentCallbacks);
        Intrinsics.reifiedOperationMarker(4, "T");
        return koinScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }
}
