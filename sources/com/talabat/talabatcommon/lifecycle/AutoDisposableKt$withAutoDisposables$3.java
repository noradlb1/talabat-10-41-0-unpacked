package com.talabat.talabatcommon.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$withAutoDisposables$3 extends Lambda implements Function1<AutoDisposable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<AutoDisposable, Unit> f61763g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$withAutoDisposables$3(Function1<? super AutoDisposable, Unit> function1) {
        super(1);
        this.f61763g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AutoDisposable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AutoDisposable autoDisposable) {
        Intrinsics.checkNotNullParameter(autoDisposable, "$this$withLifecycleAutoDisposables");
        this.f61763g.invoke(autoDisposable);
    }
}
