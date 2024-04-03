package com.designsystem.ds_toast;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.designsystem.ds_icon_button.DSIconButtonKt;
import com.designsystem.ds_icon_button.DSIconButtonSize;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastWithIconButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f33278g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33279h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33280i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastWithIconButton$1(Integer num, Function0<Unit> function0, int i11) {
        super(2);
        this.f33278g = num;
        this.f33279h = function0;
        this.f33280i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Integer num = this.f33278g;
            if (num == null) {
                composer.startReplaceableGroup(629320367);
            } else {
                composer.startReplaceableGroup(1128679314);
                Integer num2 = this.f33278g;
                Function0<Unit> function0 = this.f33279h;
                int i12 = this.f33280i;
                num.intValue();
                Modifier.Companion companion = Modifier.Companion;
                DSTheme dSTheme = DSTheme.INSTANCE;
                Modifier r42 = PaddingKt.m490paddingqDBjuR0$default(companion, 0.0f, 0.0f, dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM(), 0.0f, 11, (Object) null);
                DSIconButtonSize dSIconButtonSize = DSIconButtonSize.SMALL;
                long r72 = dSTheme.getColors(composer, 0).m8774getDsNeutralWhite0d7_KjU();
                DSIconButtonKt.m8355DSIconButton_trzpw(r42, num2.intValue(), function0, Color.m2909boximpl(r72), false, dSIconButtonSize, composer, ((i12 >> 6) & 112) | 221184 | (i12 & 896), 0);
            }
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
