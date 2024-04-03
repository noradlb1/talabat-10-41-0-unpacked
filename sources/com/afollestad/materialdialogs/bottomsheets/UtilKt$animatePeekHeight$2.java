package com.afollestad.materialdialogs.bottomsheets;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 15})
public final class UtilKt$animatePeekHeight$2 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Animator f40382g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UtilKt$animatePeekHeight$2(Animator animator) {
        super(1);
        this.f40382g = animator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        this.f40382g.cancel();
    }
}
