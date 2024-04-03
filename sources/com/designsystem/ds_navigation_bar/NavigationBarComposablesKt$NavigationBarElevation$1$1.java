package com.designsystem.ds_navigation_bar;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt$NavigationBarElevation$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Float f32434g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarComposablesKt$NavigationBarElevation$1$1(Float f11) {
        super(1);
        this.f32434g = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        Brush.Companion companion = Brush.Companion;
        Color[] colorArr = new Color[2];
        Color.Companion companion2 = Color.Companion;
        long r42 = companion2.m2945getBlack0d7_KjU();
        Float f11 = this.f32434g;
        colorArr[0] = Color.m2909boximpl(Color.m2918copywmQWz5c$default(r42, (f11 == null ? 0.0f : f11.floatValue()) * 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        colorArr[1] = Color.m2909boximpl(companion2.m2954getTransparent0d7_KjU());
        b.J(drawScope, Brush.Companion.m2871verticalGradient8A3gB4$default(companion, CollectionsKt__CollectionsKt.listOf(colorArr), 0.0f, 0.0f, 0, 14, (Object) null), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
    }
}
