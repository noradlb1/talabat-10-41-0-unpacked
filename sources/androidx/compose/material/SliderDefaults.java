package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    @NotNull
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m1357colorsq0g_0yA(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, @Nullable Composer composer, int i11, int i12, int i13) {
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j31;
        long j32;
        Composer composer2 = composer;
        int i14 = i13;
        composer2.startReplaceableGroup(436017687);
        if ((i14 & 1) != 0) {
            j22 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU();
        } else {
            j22 = j11;
        }
        if ((i14 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j23 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j23 = j12;
        }
        if ((i14 & 4) != 0) {
            j24 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1179getPrimary0d7_KjU();
        } else {
            j24 = j13;
        }
        if ((i14 & 8) != 0) {
            j25 = Color.m2918copywmQWz5c$default(j24, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j25 = j14;
        }
        if ((i14 & 16) != 0) {
            j26 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j26 = j15;
        }
        if ((i14 & 32) != 0) {
            j27 = Color.m2918copywmQWz5c$default(j26, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j27 = j16;
        }
        if ((i14 & 64) != 0) {
            j28 = Color.m2918copywmQWz5c$default(ColorsKt.m1197contentColorForek8zF_U(j24, composer2, (i11 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j28 = j17;
        }
        if ((i14 & 128) != 0) {
            j29 = Color.m2918copywmQWz5c$default(j24, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j29 = j18;
        }
        if ((i14 & 256) != 0) {
            j31 = Color.m2918copywmQWz5c$default(j28, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j31 = j19;
        }
        if ((i14 & 512) != 0) {
            j32 = Color.m2918copywmQWz5c$default(j27, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j32 = j21;
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
