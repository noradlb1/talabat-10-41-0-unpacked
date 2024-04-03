package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"getStepperStyle", "Lcom/designsystem/ds_stepper/DSStepperStyle;", "useMM2", "", "(ZLandroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_stepper/DSStepperStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StepperStyleKt {
    @NotNull
    @Composable
    public static final DSStepperStyle getStepperStyle(boolean z11, @Nullable Composer composer, int i11) {
        DSStepperStyle dSStepperStyle;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(714178537);
        if (z11) {
            composer2.startReplaceableGroup(714178615);
            DSTheme dSTheme = DSTheme.INSTANCE;
            dSStepperStyle = new DSStepperStyle(dSTheme.getDimens(composer2, 0).m8840getDsLD9Ej5fM(), dSTheme.getColors(composer2, 0).m8779getDsOrange500d7_KjU(), dSTheme.getColors(composer2, 0).m8761getDsNeutral10V20d7_KjU(), dSTheme.getTypography(composer2, 0).getDsSubheadingMedium(), dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU(), dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), dSTheme.getColors(composer2, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(714179064);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            dSStepperStyle = new DSStepperStyle(dSTheme2.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM(), dSTheme2.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), dSTheme2.getColors(composer2, 0).m8794getDsPrimary300d7_KjU(), dSTheme2.getTypography(composer2, 0).getDsButton(), dSTheme2.getColors(composer2, 0).m8760getDsNeutral1000d7_KjU(), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme2.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), (DefaultConstructorMarker) null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return dSStepperStyle;
    }
}
