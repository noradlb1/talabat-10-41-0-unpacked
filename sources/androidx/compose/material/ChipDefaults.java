package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalMaterialApi
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    @NotNull
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    public static final float LeadingIconOpacity = 0.54f;
    private static final float LeadingIconSize = Dp.m5478constructorimpl((float) 20);
    private static final float MinHeight = Dp.m5478constructorimpl((float) 32);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m5478constructorimpl((float) 1);
    private static final float SelectedIconSize = Dp.m5478constructorimpl((float) 18);

    private ChipDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: chipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1159chipColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1838505436);
        if ((i12 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j17 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.m2918copywmQWz5c$default(j18, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            j21 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme2.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme2.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(j18, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = Color.m2918copywmQWz5c$default(j19, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j16;
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(j17, j18, j19, j21, j22, j23, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    @NotNull
    @Composable
    /* renamed from: filterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m1160filterChipColorsJ08w3E(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, @Nullable Composer composer, int i11, int i12) {
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        Composer composer2 = composer;
        int i13 = i12;
        composer2.startReplaceableGroup(830140629);
        if ((i13 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j21 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j21 = j11;
        }
        if ((i13 & 2) != 0) {
            j22 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j12;
        }
        if ((i13 & 4) != 0) {
            j23 = Color.m2918copywmQWz5c$default(j22, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j13;
        }
        if ((i13 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            j24 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(materialTheme2.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme2.getColors(composer2, 6).m1183getSurface0d7_KjU());
        } else {
            j24 = j14;
        }
        if ((i13 & 16) != 0) {
            j25 = Color.m2918copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j25 = j15;
        }
        if ((i13 & 32) != 0) {
            j26 = Color.m2918copywmQWz5c$default(j23, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j26 = j16;
        }
        if ((i13 & 64) != 0) {
            j27 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j21);
        } else {
            j27 = j17;
        }
        if ((i13 & 128) != 0) {
            j28 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j22);
        } else {
            j28 = j18;
        }
        if ((i13 & 256) != 0) {
            j29 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j23);
        } else {
            j29 = j19;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(j21, j22, j23, j24, j25, j26, j27, j28, j29, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1161getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1162getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedBorder")
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1650225597);
        BorderStroke r11 = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedBorderSize, Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1178getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        composer.endReplaceableGroup();
        return r11;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m1163getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1164getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1165outlinedChipColors5tl4gsc(long j11, long j12, long j13, long j14, long j15, long j16, @Nullable Composer composer, int i11, int i12) {
        long j17;
        long j18;
        long j19;
        long j21;
        long j22;
        long j23;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-1763922662);
        if ((i12 & 1) != 0) {
            j17 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j17 = j11;
        }
        if ((i12 & 2) != 0) {
            j18 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j12;
        }
        if ((i12 & 4) != 0) {
            j19 = Color.m2918copywmQWz5c$default(j18, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j19 = j13;
        }
        if ((i12 & 8) != 0) {
            j21 = j17;
        } else {
            j21 = j14;
        }
        if ((i12 & 16) != 0) {
            j22 = Color.m2918copywmQWz5c$default(j18, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j15;
        }
        if ((i12 & 32) != 0) {
            j23 = Color.m2918copywmQWz5c$default(j19, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j16;
        }
        ChipColors r02 = m1159chipColors5tl4gsc(j17, j18, j19, j21, j22, j23, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
        composer.endReplaceableGroup();
        return r02;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedFilterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m1166outlinedFilterChipColorsJ08w3E(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, @Nullable Composer composer, int i11, int i12) {
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        Composer composer2 = composer;
        int i13 = i12;
        composer2.startReplaceableGroup(346878099);
        if ((i13 & 1) != 0) {
            j21 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j21 = j11;
        }
        if ((i13 & 2) != 0) {
            j22 = Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j12;
        }
        if ((i13 & 4) != 0) {
            j23 = Color.m2918copywmQWz5c$default(j22, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j13;
        }
        if ((i13 & 8) != 0) {
            j24 = j21;
        } else {
            j24 = j14;
        }
        if ((i13 & 16) != 0) {
            j25 = Color.m2918copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j25 = j15;
        }
        if ((i13 & 32) != 0) {
            j26 = Color.m2918copywmQWz5c$default(j23, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j26 = j16;
        }
        if ((i13 & 64) != 0) {
            j27 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j21);
        } else {
            j27 = j17;
        }
        if ((i13 & 128) != 0) {
            j28 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j22);
        } else {
            j28 = j18;
        }
        if ((i13 & 256) != 0) {
            j29 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1178getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j23);
        } else {
            j29 = j19;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(j21, j22, j23, j24, j25, j26, j27, j28, j29, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }
}
