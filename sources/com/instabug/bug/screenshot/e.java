package com.instabug.bug.screenshot;

import android.app.Activity;
import com.instabug.bug.screenshot.viewhierarchy.b;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class e extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f45731g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f45732h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f45733i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, Activity activity, b bVar) {
        super(1);
        this.f45731g = fVar;
        this.f45732h = activity;
        this.f45733i = bVar;
    }

    public final void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        f fVar = this.f45731g;
        Activity activity = this.f45732h;
        fVar.a(activity, list, (Function0) new d(fVar, activity, this.f45733i));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.INSTANCE;
    }
}
