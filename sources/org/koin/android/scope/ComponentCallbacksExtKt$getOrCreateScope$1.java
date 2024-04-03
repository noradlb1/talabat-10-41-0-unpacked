package org.koin.android.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/ComponentCallbacks;", "T", "Lorg/koin/core/scope/Scope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComponentCallbacksExtKt$getOrCreateScope$1 extends Lambda implements Function0<Scope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f62645g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentCallbacksExtKt$getOrCreateScope$1(T t11) {
        super(0);
        this.f62645g = t11;
    }

    @NotNull
    public final Scope invoke() {
        Scope scopeOrNull = ComponentCallbacksExtKt.getScopeOrNull(this.f62645g);
        return scopeOrNull == null ? ComponentCallbacksExtKt.createScope$default(this.f62645g, (Object) null, 1, (Object) null) : scopeOrNull;
    }
}
