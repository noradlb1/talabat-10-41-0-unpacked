package org.koin.android.scope;

import android.app.Service;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lorg/koin/core/scope/Scope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ServiceExtKt$serviceScope$1 extends Lambda implements Function0<Scope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Service f62647g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceExtKt$serviceScope$1(Service service2) {
        super(0);
        this.f62647g = service2;
    }

    @NotNull
    public final Scope invoke() {
        Scope scopeOrNull = ServiceExtKt.getScopeOrNull(this.f62647g);
        return scopeOrNull == null ? ServiceExtKt.createScope$default(this.f62647g, (Object) null, 1, (Object) null) : scopeOrNull;
    }
}
