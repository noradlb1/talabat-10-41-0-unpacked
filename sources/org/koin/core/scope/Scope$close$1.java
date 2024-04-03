package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Scope$close$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scope f62741g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Scope$close$1(Scope scope) {
        super(0);
        this.f62741g = scope;
    }

    public final void invoke() {
        this.f62741g._closed = true;
        this.f62741g.clearData();
        this.f62741g.get_koin().getScopeRegistry().deleteScope$koin_core(this.f62741g);
    }
}
