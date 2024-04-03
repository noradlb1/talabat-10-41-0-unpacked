package com.designsystem.ds_image;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u000b"}, d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.designsystem.ds_image.ComposableSingletons$RatioImageComposablesKt$lambda-3$1  reason: invalid class name */
public final class ComposableSingletons$RatioImageComposablesKt$lambda3$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$RatioImageComposablesKt$lambda3$1 INSTANCE = new ComposableSingletons$RatioImageComposablesKt$lambda3$1();

    public ComposableSingletons$RatioImageComposablesKt$lambda3$1() {
        super(3);
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
            IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ds_no_image, composer, 0), (String) null, SizeKt.m558size3ABfNKs(Modifier.Companion, RatioImageComposablesKt.m8367iconSize8Feqmps(Dp.m5478constructorimpl(Math.min(boxWithConstraintsScope.m435getMaxHeightD9Ej5fM(), boxWithConstraintsScope.m436getMaxWidthD9Ej5fM())), composer, 0)), DSTheme.INSTANCE.getColors(composer, 0).m8759getDsNeutral100d7_KjU(), composer, 56, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
