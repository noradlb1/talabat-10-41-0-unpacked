package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-ro_MJ88  reason: not valid java name */
    public final RadioButtonColors m1809colorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-351083046);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getSelectedIconColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getUnselectedIconColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-351083046, i11, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:144)");
        }
        RadioButtonColors radioButtonColors = new RadioButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return radioButtonColors;
    }
}
