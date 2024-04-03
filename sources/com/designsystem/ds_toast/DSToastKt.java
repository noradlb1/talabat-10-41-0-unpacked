package com.designsystem.ds_toast;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSThemeKt;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"DSToast", "", "hostState", "Lcom/designsystem/ds_toast/DSToastHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/designsystem/ds_toast/DSToastHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSToastKt {
    @Composable
    public static final void DSToast(@NotNull DSToastHostState dSToastHostState, @Nullable Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(dSToastHostState, "hostState");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-688429888);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) dSToastHostState)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i17 = i12 & 2;
        if (i17 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                modifier = Modifier.Companion;
            }
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819896011, true, new DSToastKt$DSToast$1(function2, i13, modifier, dSToastHostState)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSToastKt$DSToast$2(dSToastHostState, modifier2, function2, i11, i12));
        }
    }
}
