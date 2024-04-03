package com.instabug.library.diagnostics.sdkEvents;

import com.instabug.library.diagnostics.sdkEvents.models.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class c extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ e f34323g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ a f34324h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(e eVar, a aVar) {
        super(0);
        this.f34323g = eVar;
        this.f34324h = aVar;
    }

    public final void a() {
        this.f34323g.b().a(this.f34324h);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
