package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$2 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBottomNavigationBarItem f30564g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30565h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f30566i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$2(DSBottomNavigationBarItem dSBottomNavigationBarItem, int i11, MutableState<Integer> mutableState) {
        super(3);
        this.f30564g = dSBottomNavigationBarItem;
        this.f30565h = i11;
        this.f30566i = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull ColumnScope columnScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$NavigationBarItemContainer");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            boolean z11 = true;
            BottomNavigationBarComposablesKt.NavigationBarIcon(this.f30564g, this.f30565h == BottomNavigationBarComposablesKt.m8252NavigationBarSurface$lambda6(this.f30566i), composer, 0);
            String title = this.f30564g.getTitle();
            if (this.f30565h != BottomNavigationBarComposablesKt.m8252NavigationBarSurface$lambda6(this.f30566i)) {
                z11 = false;
            }
            BottomNavigationBarComposablesKt.FixedFontScaleText(title, BottomNavigationBarComposablesKt.getLabelTextStyle(z11, composer, 0), composer, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
