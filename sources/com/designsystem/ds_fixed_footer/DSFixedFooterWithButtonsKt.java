package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0006\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0017\u0010\t\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b0\n27\u0010\u000b\u001a3\u0012$\u0012\"\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b0\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSFixedFooterWithButtons", "", "modifier", "Landroidx/compose/ui/Modifier;", "isElevated", "", "topContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "buttons", "", "buttonsBox", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Ljava/util/List;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithButtonsKt {
    @Composable
    public static final void DSFixedFooterWithButtons(@NotNull Modifier modifier, boolean z11, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @NotNull Function3<? super List<? extends Function2<? super Composer, ? super Integer, Unit>>, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        boolean z12;
        Function2<? super Composer, ? super Integer, Unit> function22;
        List<? extends Function2<? super Composer, ? super Integer, Unit>> list2 = list;
        Function3<? super List<? extends Function2<? super Composer, ? super Integer, Unit>>, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i13 = i11;
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(list2, "buttons");
        Intrinsics.checkNotNullParameter(function32, "buttonsBox");
        Composer startRestartGroup = composer.startRestartGroup(-469917052);
        if ((i12 & 2) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i12 & 4) != 0) {
            function22 = null;
        } else {
            function22 = function2;
        }
        DSFixedFooterKt.DSFixedFooter(modifier, z12, function22, ComposableLambdaKt.composableLambda(startRestartGroup, -819894945, true, new DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$1(list2, function32, i13)), startRestartGroup, (i13 & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | (i13 & 112) | (i13 & 896), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$2(modifier, z12, function22, list, function3, i11, i12));
        }
    }
}
