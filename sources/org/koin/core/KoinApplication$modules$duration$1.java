package org.koin.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KoinApplication$modules$duration$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KoinApplication f62717g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Module> f62718h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoinApplication$modules$duration$1(KoinApplication koinApplication, List<Module> list) {
        super(0);
        this.f62717g = koinApplication;
        this.f62718h = list;
    }

    public final void invoke() {
        this.f62717g.loadModules(this.f62718h);
    }
}
