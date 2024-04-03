package com.instabug.bug.screenshot;

import com.instabug.bug.screenshot.viewhierarchy.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class c extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f45726g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ b f45727h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(f fVar, b bVar) {
        super(0);
        this.f45726g = fVar;
        this.f45727h = bVar;
    }

    public final void a() {
        this.f45726g.b(this.f45727h);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
