package org.koin.core.component;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lorg/koin/core/component/KoinScopeComponent;", "T", "Lorg/koin/core/scope/Scope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KoinScopeComponentKt$newScope$1 extends Lambda implements Function0<Scope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f62723g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoinScopeComponentKt$newScope$1(T t11) {
        super(0);
        this.f62723g = t11;
    }

    @NotNull
    public final Scope invoke() {
        return KoinScopeComponentKt.createScope$default(this.f62723g, (Object) null, 1, (Object) null);
    }
}
