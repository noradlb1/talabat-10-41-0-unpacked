package com.talabat.talabatcommon.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$withViewHolder$1$1 extends Lambda implements Function1<AutoDisposable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f61768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f61769h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$withViewHolder$1$1(Function1<? super View, Unit> function1, View view) {
        super(1);
        this.f61768g = function1;
        this.f61769h = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AutoDisposable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AutoDisposable autoDisposable) {
        Intrinsics.checkNotNullParameter(autoDisposable, "$this$null");
        Function1<View, Unit> function1 = this.f61768g;
        View view = this.f61769h;
        Intrinsics.checkNotNullExpressionValue(view, "");
        function1.invoke(view);
    }
}
