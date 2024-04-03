package com.designsystem.ds_navigation_bar;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt$NavigationBarSurface$1$2$1$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Dp, Composer, Integer, Unit> f32443g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32444h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarComposablesKt$NavigationBarSurface$1$2$1$1(Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(3);
        this.f32443g = function3;
        this.f32444h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) boxWithConstraintsScope) ? 4 : 2;
        }
        if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            this.f32443g.invoke(Dp.m5476boximpl(boxWithConstraintsScope.m436getMaxWidthD9Ej5fM()), composer, Integer.valueOf((this.f32444h >> 9) & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
