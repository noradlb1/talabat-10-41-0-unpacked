package com.designsystem.ds_fixed_footer;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u00020\u00012\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"FixedFooterCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "isElevated", "", "withTopContent", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FixedFooterTopContent", "topContent", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FixedFooterComposablesKt {
    @Composable
    public static final void FixedFooterCard(@NotNull Modifier modifier, boolean z11, boolean z12, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        Modifier modifier2 = modifier;
        boolean z13 = z11;
        boolean z14 = z12;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer startRestartGroup = composer.startRestartGroup(147142910);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed(z13)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed(z14)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        int i18 = i12;
        if (((i18 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            FixedFooter fixedFooter = FixedFooter.INSTANCE;
            if (z13) {
                f11 = fixedFooter.m8348getElevationMediumD9Ej5fM();
            } else {
                f11 = fixedFooter.m8349getElevationZeroD9Ej5fM();
            }
            float f12 = f11;
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(BackgroundKt.m177backgroundbw27NRU$default(modifier, DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            Dp r12 = Dp.m5476boximpl(f12);
            startRestartGroup.startReplaceableGroup(-3686930);
            boolean changed = startRestartGroup.changed((Object) r12);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new FixedFooterComposablesKt$FixedFooterCard$1$1(f12);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            CardKt.m1142CardFjzlyU(SemanticsModifierKt.semantics$default(wrapContentHeight$default, false, (Function1) rememberedValue, 1, (Object) null), RectangleShapeKt.getRectangleShape(), 0, 0, (BorderStroke) null, f12, ComposableLambdaKt.composableLambda(startRestartGroup, -819895474, true, new FixedFooterComposablesKt$FixedFooterCard$2(z14, function32, i18)), composer2, 1572912, 28);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FixedFooterComposablesKt$FixedFooterCard$3(modifier, z11, z12, function3, i11));
        }
    }

    @Composable
    public static final void FixedFooterTopContent(@Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1723287838);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((2 ^ (i12 & 11)) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (function2 != null) {
            startRestartGroup.startReplaceableGroup(-1723287737);
            function2.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1723287649);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FixedFooterComposablesKt$FixedFooterTopContent$1(function2, i11));
        }
    }
}
