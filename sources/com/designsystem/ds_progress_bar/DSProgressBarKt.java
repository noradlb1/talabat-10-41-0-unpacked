package com.designsystem.ds_progress_bar;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.designsystem.ds_theme.DSThemeKt;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"DSProgressBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "progress", "", "color", "Landroidx/compose/ui/graphics/Color;", "DSProgressBar-gKt5lHk", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSProgressBarKt {
    @Composable
    /* renamed from: DSProgressBar-gKt5lHk  reason: not valid java name */
    public static final void m8514DSProgressBargKt5lHk(@Nullable Modifier modifier, float f11, @Nullable Color color, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1193580316);
        int i17 = i12 & 1;
        if (i17 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(f11)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        int i18 = i12 & 4;
        if (i18 != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) color)) {
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
            if (i18 != 0) {
                color = null;
            }
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819896080, true, new DSProgressBarKt$DSProgressBar$1(f11, modifier, color, i13)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        Color color2 = color;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSProgressBarKt$DSProgressBar$2(modifier2, f11, color2, i11, i12));
        }
    }
}
