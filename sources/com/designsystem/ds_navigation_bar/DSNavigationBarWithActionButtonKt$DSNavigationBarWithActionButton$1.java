package com.designsystem.ds_navigation_bar;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import com.designsystem.ds_small_button.DSTertiarySmallButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarActionButtonModel f32408g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$1(DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel) {
        super(2);
        this.f32408g = dSNavigationBarActionButtonModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            DSTertiarySmallButtonKt.DSTertiarySmallButton(this.f32408g.getTitle(), SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, (Object) null), (Integer) null, false, false, false, this.f32408g.getOnTap(), composer, 0, 60);
            return;
        }
        composer.skipToGroupEnd();
    }
}
