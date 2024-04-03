package com.instabug.bug.screenshot;

import android.app.Activity;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class b extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f45722g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f45723h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List f45724i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0 f45725j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(f fVar, Activity activity, List list, Function0 function0) {
        super(0);
        this.f45722g = fVar;
        this.f45723h = activity;
        this.f45724i = list;
        this.f45725j = function0;
    }

    public final void a() {
        f fVar = this.f45722g;
        Activity activity = this.f45723h;
        List list = this.f45724i;
        fVar.a(activity, list.subList(1, list.size()), this.f45725j);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
