package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0006\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0017\u0010\t\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b0\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"DSFixedFooterWithHorizontalButtons", "", "modifier", "Landroidx/compose/ui/Modifier;", "isElevated", "", "topContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "buttons", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithHorizontalButtonsKt {
    @Composable
    public static final void DSFixedFooterWithHorizontalButtons(@Nullable Modifier modifier, boolean z11, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "buttons");
        Composer startRestartGroup = composer.startRestartGroup(811574096);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        if ((i12 & 4) != 0) {
            function2 = null;
        }
        DSFixedFooterWithButtonsKt.DSFixedFooterWithButtons(modifier, z11, function2, list, ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt.INSTANCE.m8346getLambda1$marshmallow_release(), startRestartGroup, (i11 & 14) | 4096 | (i11 & 112) | (i11 & 896), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSFixedFooterWithHorizontalButtonsKt$DSFixedFooterWithHorizontalButtons$1(modifier, z11, function2, list, i11, i12));
        }
    }
}
