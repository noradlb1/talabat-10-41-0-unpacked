package org.koin.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Koin$createEagerInstances$duration$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Koin f62708g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Koin$createEagerInstances$duration$1(Koin koin) {
        super(0);
        this.f62708g = koin;
    }

    public final void invoke() {
        this.f62708g.getInstanceRegistry().createAllEagerInstances$koin_core();
    }
}
