package com.designsystem.ds_branded_button;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.ds_theme.DSThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"DSBaseBrandedButton", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "isMM2", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "buttonMM1Style", "Lcom/designsystem/ds_branded_button/DSBrandedButtonStyle;", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_branded_button/DSBrandedButtonStyle;", "buttonMM2Style", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBaseBrandedButtonKt {
    @Composable
    public static final void DSBaseBrandedButton(@NotNull DSButtonTheme dSButtonTheme, @NotNull String str, @NotNull Modifier modifier, @Nullable @DrawableRes Integer num, boolean z11, boolean z12, boolean z13, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        DSButtonTheme dSButtonTheme2 = dSButtonTheme;
        String str2 = str;
        Modifier modifier2 = modifier;
        Function0<Unit> function02 = function0;
        int i22 = i11;
        Intrinsics.checkNotNullParameter(dSButtonTheme2, "theme");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-803784608);
        if ((i22 & 14) == 0) {
            if (startRestartGroup.changed((Object) dSButtonTheme2)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i12 = i21 | i22;
        } else {
            i12 = i22;
        }
        if ((i22 & 112) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i12 |= i19;
        }
        if ((i22 & 896) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i12 |= i18;
        }
        Integer num2 = num;
        if ((i22 & 7168) == 0) {
            if (startRestartGroup.changed((Object) num2)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i12 |= i17;
        }
        boolean z14 = z11;
        if ((57344 & i22) == 0) {
            if (startRestartGroup.changed(z14)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i12 |= i16;
        }
        boolean z15 = z12;
        if ((458752 & i22) == 0) {
            if (startRestartGroup.changed(z15)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i12 |= i15;
        }
        boolean z16 = z13;
        if ((3670016 & i22) == 0) {
            if (startRestartGroup.changed(z16)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i12 |= i14;
        }
        if ((29360128 & i22) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i12 |= i13;
        }
        int i23 = i12;
        if (((23967451 & i23) ^ 4793490) != 0 || !startRestartGroup.getSkipping()) {
            DSBaseBrandedButtonKt$DSBaseBrandedButton$1 dSBaseBrandedButtonKt$DSBaseBrandedButton$1 = r0;
            DSBaseBrandedButtonKt$DSBaseBrandedButton$1 dSBaseBrandedButtonKt$DSBaseBrandedButton$12 = new DSBaseBrandedButtonKt$DSBaseBrandedButton$1(dSButtonTheme, z11, z12, i23, z13, str, modifier, num, function0);
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819895561, true, dSBaseBrandedButtonKt$DSBaseBrandedButton$1), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSBaseBrandedButtonKt$DSBaseBrandedButton$2(dSButtonTheme, str, modifier, num, z11, z12, z13, function0, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSBrandedButtonStyle buttonMM1Style(Composer composer, int i11) {
        composer.startReplaceableGroup(1641890620);
        DSBrandedButtonStyle dSBrandedButtonStyle = new DSBrandedButtonStyle(true, DSTheme.INSTANCE.getTypography(composer, 0).getDsButton(), 0.3f);
        composer.endReplaceableGroup();
        return dSBrandedButtonStyle;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSBrandedButtonStyle buttonMM2Style(Composer composer, int i11) {
        composer.startReplaceableGroup(-1765572803);
        DSBrandedButtonStyle dSBrandedButtonStyle = new DSBrandedButtonStyle(false, DSTheme.INSTANCE.getTypography(composer, 0).getDsSubheadingMedium(), 0.4f);
        composer.endReplaceableGroup();
        return dSBrandedButtonStyle;
    }
}
