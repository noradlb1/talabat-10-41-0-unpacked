package com.designsystem.ds_bottom_sheet_v2;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/graphics/Canvas;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RoundedCoordinatorLayout$draw$1 extends Lambda implements Function1<Canvas, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RoundedCoordinatorLayout f30601g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Canvas f30602h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout$draw$1(RoundedCoordinatorLayout roundedCoordinatorLayout, Canvas canvas) {
        super(1);
        this.f30601g = roundedCoordinatorLayout;
        this.f30602h = canvas;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "it");
        RoundedCoordinatorLayout$draw$1.super.draw(this.f30602h);
    }
}
