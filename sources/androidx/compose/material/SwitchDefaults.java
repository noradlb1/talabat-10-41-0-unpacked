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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-SQMK_m0  reason: not valid java name */
    public final SwitchColors m1400colorsSQMK_m0(long j11, long j12, float f11, long j13, long j14, float f12, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i11, int i12, int i13) {
        long j19;
        long j21;
        float f13;
        long j22;
        long j23;
        float f14;
        long j24;
        long j25;
        float f15;
        long j26;
        long j27;
        long j28;
        int i14;
        long j29;
        Composer composer2 = composer;
        int i15 = i13;
        composer2.startReplaceableGroup(-1032127534);
        if ((i15 & 1) != 0) {
            j19 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1182getSecondaryVariant0d7_KjU();
        } else {
            j19 = j11;
        }
        if ((i15 & 2) != 0) {
            j21 = j19;
        } else {
            j21 = j12;
        }
        if ((i15 & 4) != 0) {
            f13 = 0.54f;
        } else {
            f13 = f11;
        }
        if ((i15 & 8) != 0) {
            j22 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j22 = j13;
        }
        if ((i15 & 16) != 0) {
            j23 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU();
        } else {
            j23 = j14;
        }
        if ((i15 & 32) != 0) {
            f14 = 0.38f;
        } else {
            f14 = f12;
        }
        if ((i15 & 64) != 0) {
            j24 = j19;
            j25 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(j19, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j24 = j19;
            j25 = j15;
        }
        if ((i15 & 128) != 0) {
            f15 = f14;
            j26 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(j21, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            f15 = f14;
            j26 = j16;
        }
        if ((i15 & 256) != 0) {
            j27 = j25;
            i14 = 6;
            j28 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j27 = j25;
            i14 = 6;
            j28 = j17;
        }
        if ((i15 & 512) != 0) {
            j29 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(j23, ContentAlpha.INSTANCE.getDisabled(composer2, i14), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j29 = j18;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j24, Color.m2918copywmQWz5c$default(j21, f13, 0.0f, 0.0f, 0.0f, 14, (Object) null), j22, Color.m2918copywmQWz5c$default(j23, f15, 0.0f, 0.0f, 0.0f, 14, (Object) null), j27, Color.m2918copywmQWz5c$default(j26, f13, 0.0f, 0.0f, 0.0f, 14, (Object) null), j28, Color.m2918copywmQWz5c$default(j29, f15, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
