package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSThemeKt;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"DSTextLink", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTextLinkKt {
    @Composable
    public static final void DSTextLink(@NotNull String str, @Nullable Modifier modifier, boolean z11, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        int i14;
        int i15;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(182594488);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i11;
        } else {
            i13 = i11;
        }
        int i18 = i12 & 2;
        if (i18 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        int i19 = i12 & 4;
        if (i19 != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i13 |= i15;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        int i21 = i13;
        if (((i21 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                modifier = Modifier.Companion;
            }
            if (i19 != 0) {
                z11 = true;
            }
            modifier2 = modifier;
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819896164, true, new DSTextLinkKt$DSTextLink$1(modifier2, str, z11, function0, i21)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        boolean z12 = z11;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSTextLinkKt$DSTextLink$2(str, modifier2, z12, function0, i11, i12));
        }
    }
}
