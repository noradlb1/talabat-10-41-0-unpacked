package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-5tl4gsc  reason: not valid java name */
    public final CheckboxColors m1535colors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-89536160);
        if ((i12 & 1) != 0) {
            j17 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), CheckboxTokens.INSTANCE.getSelectedContainerColor());
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), CheckboxTokens.INSTANCE.getUnselectedOutlineColor());
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), CheckboxTokens.INSTANCE.getSelectedIconColor());
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = Color.m2918copywmQWz5c$default(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = j21;
        } else {
            j23 = j16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, i11, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:195)");
        }
        CheckboxColors checkboxColors = new CheckboxColors(j19, Color.m2918copywmQWz5c$default(j19, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j17, Color.m2918copywmQWz5c$default(j17, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j21, Color.m2918copywmQWz5c$default(j22, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j23, j17, j18, j21, j23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return checkboxColors;
    }
}
