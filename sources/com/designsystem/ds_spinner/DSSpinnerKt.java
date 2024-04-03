package com.designsystem.ds_spinner;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.ds_theme.DSThemeKt;
import com.designsystem.marshmallow.R;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0011\u0010\t\u001a\u00020\n*\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000b\u001a\u0014\u0010\t\u001a\u00020\f*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"DSSpinner", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Lcom/designsystem/ds_spinner/DSSpinnerColor;", "size", "Lcom/designsystem/ds_spinner/DSSpinnerSize;", "(Landroidx/compose/ui/Modifier;Lcom/designsystem/ds_spinner/DSSpinnerColor;Lcom/designsystem/ds_spinner/DSSpinnerSize;Landroidx/compose/runtime/Composer;II)V", "value", "", "(Lcom/designsystem/ds_spinner/DSSpinnerColor;Landroidx/compose/runtime/Composer;I)I", "Landroidx/compose/ui/unit/Dp;", "(Lcom/designsystem/ds_spinner/DSSpinnerSize;Landroidx/compose/runtime/Composer;I)F", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSpinnerKt {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DSSpinnerColor.values().length];
            iArr[DSSpinnerColor.Orange.ordinal()] = 1;
            iArr[DSSpinnerColor.White.ordinal()] = 2;
            iArr[DSSpinnerColor.Black.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DSSpinnerSize.values().length];
            iArr2[DSSpinnerSize.Normal.ordinal()] = 1;
            iArr2[DSSpinnerSize.Small.ordinal()] = 2;
            iArr2[DSSpinnerSize.VerySmall.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Composable
    public static final void DSSpinner(@Nullable Modifier modifier, @Nullable DSSpinnerColor dSSpinnerColor, @Nullable DSSpinnerSize dSSpinnerSize, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(2067595873);
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
        int i18 = i12 & 2;
        if (i18 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) dSSpinnerColor)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        int i19 = i12 & 4;
        if (i19 != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) dSSpinnerSize)) {
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
                dSSpinnerColor = DSSpinnerColor.Orange;
            }
            if (i19 != 0) {
                dSSpinnerSize = DSSpinnerSize.Normal;
            }
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819895472, true, new DSSpinnerKt$DSSpinner$1(dSSpinnerColor, i13, modifier, dSSpinnerSize)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        DSSpinnerColor dSSpinnerColor2 = dSSpinnerColor;
        DSSpinnerSize dSSpinnerSize2 = dSSpinnerSize;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSpinnerKt$DSSpinner$2(modifier2, dSSpinnerColor2, dSSpinnerSize2, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final int value(DSSpinnerColor dSSpinnerColor, Composer composer, int i11) {
        int i12;
        composer.startReplaceableGroup(-1742632549);
        int i13 = WhenMappings.$EnumSwitchMapping$0[dSSpinnerColor.ordinal()];
        if (i13 == 1) {
            i12 = R.raw.circular_loader_orange;
        } else if (i13 == 2) {
            i12 = R.raw.circular_loader_white;
        } else if (i13 == 3) {
            i12 = R.raw.circular_loader_black;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return i12;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final float value(DSSpinnerSize dSSpinnerSize, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(-1742632313);
        int i12 = WhenMappings.$EnumSwitchMapping$1[dSSpinnerSize.ordinal()];
        if (i12 == 1) {
            composer.startReplaceableGroup(-1742632228);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8845getDsXxlD9Ej5fM();
            composer.endReplaceableGroup();
        } else if (i12 == 2) {
            composer.startReplaceableGroup(-1742632180);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8840getDsLD9Ej5fM();
            composer.endReplaceableGroup();
        } else if (i12 == 3) {
            composer.startReplaceableGroup(-1742632130);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8841getDsMD9Ej5fM();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1742636129);
            composer.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return f11;
    }
}
