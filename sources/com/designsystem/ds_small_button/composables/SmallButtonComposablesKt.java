package com.designsystem.ds_small_button.composables;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"SmallButtonTitleText", "", "title", "", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "SmallButtonTitleText-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SmallButtonComposablesKt {
    @Composable
    /* renamed from: SmallButtonTitleText-3IgeMak  reason: not valid java name */
    public static final void m8576SmallButtonTitleText3IgeMak(@NotNull String str, long j11, @Nullable TextStyle textStyle, @Nullable Composer composer, int i11, int i12) {
        int i13;
        TextStyle textStyle2;
        Composer composer2;
        int i14;
        int i15;
        int i16;
        String str2 = str;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str2, "title");
        Composer startRestartGroup = composer.startRestartGroup(985226593);
        if ((i12 & 1) != 0) {
            i13 = i17 | 6;
        } else if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i17;
        } else {
            i13 = i17;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
            long j12 = j11;
        } else {
            long j13 = j11;
            if ((i17 & 112) == 0) {
                if (startRestartGroup.changed(j13)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i13 |= i15;
            }
        }
        if ((i17 & 896) == 0) {
            if ((i12 & 4) == 0) {
                textStyle2 = textStyle;
                if (startRestartGroup.changed((Object) textStyle2)) {
                    i14 = 256;
                    i13 |= i14;
                }
            } else {
                textStyle2 = textStyle;
            }
            i14 = 128;
            i13 |= i14;
        } else {
            textStyle2 = textStyle;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if ((i17 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.startDefaults();
                if ((i12 & 4) != 0) {
                    textStyle2 = DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsLink();
                    i13 &= -897;
                }
                startRestartGroup.endDefaults();
            } else {
                startRestartGroup.skipCurrentGroup();
                if ((i12 & 4) != 0) {
                    i13 &= -897;
                }
            }
            int i18 = i13;
            TextStyle textStyle3 = textStyle2;
            composer2 = startRestartGroup;
            String str3 = str;
            long j14 = j11;
            TextKt.m1461TextfLXpl1I(str3, (Modifier) null, j14, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m5359boximpl(TextAlign.Companion.m5366getCentere0LSkKk()), 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, textStyle3, composer2, (i18 & 14) | 1073741824 | ((i18 << 3) & 896), ((i18 << 9) & Opcodes.ASM7) | 3136, 22010);
            textStyle2 = textStyle3;
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SmallButtonComposablesKt$SmallButtonTitleText$1(str, j11, textStyle2, i11, i12));
        }
    }
}
