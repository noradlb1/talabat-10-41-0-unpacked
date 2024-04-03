package com.instabug.bug.screenshot;

import android.app.Activity;
import com.instabug.bug.screenshot.viewhierarchy.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class d extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f45728g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f45729h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f45730i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(f fVar, Activity activity, b bVar) {
        super(0);
        this.f45728g = fVar;
        this.f45729h = activity;
        this.f45730i = bVar;
    }

    public final void a() {
        f fVar = this.f45728g;
        Activity activity = this.f45729h;
        b bVar = this.f45730i;
        fVar.a(activity, bVar, (Function0) new c(fVar, bVar));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
