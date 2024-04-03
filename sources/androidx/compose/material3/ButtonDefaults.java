package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102JG\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J=\u0010<\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u00102JG\u0010>\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010;J=\u0010@\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u00102JG\u0010B\u001a\u0002042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010;J=\u0010D\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u00102J=\u0010F\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u00102R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0011\u0010&\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b)\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    @NotNull
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconHorizontalStartPadding;
    @NotNull
    private static final PaddingValues ContentPadding;
    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize = FilledButtonTokens.INSTANCE.m2207getIconSizeD9Ej5fM();
    private static final float IconSpacing;
    private static final float MinHeight = Dp.m5478constructorimpl((float) 40);
    private static final float MinWidth = Dp.m5478constructorimpl((float) 58);
    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float r02 = Dp.m5478constructorimpl((float) 24);
        ButtonHorizontalPadding = r02;
        float f11 = (float) 8;
        float r22 = Dp.m5478constructorimpl(f11);
        ButtonVerticalPadding = r22;
        PaddingValues r32 = PaddingKt.m482PaddingValuesa9UjIt4(r02, r22, r02, r22);
        ContentPadding = r32;
        float r42 = Dp.m5478constructorimpl((float) 16);
        ButtonWithIconHorizontalStartPadding = r42;
        ButtonWithIconContentPadding = PaddingKt.m482PaddingValuesa9UjIt4(r42, r22, r02, r22);
        float r03 = Dp.m5478constructorimpl((float) 12);
        TextButtonHorizontalPadding = r03;
        TextButtonContentPadding = PaddingKt.m482PaddingValuesa9UjIt4(r03, r32.m499calculateTopPaddingD9Ej5fM(), r03, r32.m496calculateBottomPaddingD9Ej5fM());
        IconSpacing = Dp.m5478constructorimpl(f11);
    }

    private ButtonDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1517buttonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-339300779);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i11, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:547)");
        }
        ButtonColors buttonColors = new ButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @NotNull
    @Composable
    /* renamed from: buttonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1518buttonElevationR_JCAzs(float f11, float f12, float f13, float f14, float f15, @Nullable Composer composer, int i11, int i12) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f21;
        composer.startReplaceableGroup(1827791191);
        if ((i12 & 1) != 0) {
            f16 = FilledButtonTokens.INSTANCE.m2202getContainerElevationD9Ej5fM();
        } else {
            f16 = f11;
        }
        if ((i12 & 2) != 0) {
            f17 = FilledButtonTokens.INSTANCE.m2208getPressedContainerElevationD9Ej5fM();
        } else {
            f17 = f12;
        }
        if ((i12 & 4) != 0) {
            f18 = FilledButtonTokens.INSTANCE.m2205getFocusContainerElevationD9Ej5fM();
        } else {
            f18 = f13;
        }
        if ((i12 & 8) != 0) {
            f19 = FilledButtonTokens.INSTANCE.m2206getHoverContainerElevationD9Ej5fM();
        } else {
            f19 = f14;
        }
        if ((i12 & 16) != 0) {
            f21 = FilledButtonTokens.INSTANCE.m2204getDisabledContainerElevationD9Ej5fM();
        } else {
            f21 = f15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i11, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:674)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f16, f17, f18, f19, f21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1519elevatedButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1507908383);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, i11, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:572)");
        }
        ButtonColors buttonColors = new ButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedButtonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1520elevatedButtonElevationR_JCAzs(float f11, float f12, float f13, float f14, float f15, @Nullable Composer composer, int i11, int i12) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f21;
        composer.startReplaceableGroup(1065482445);
        if ((i12 & 1) != 0) {
            f16 = ElevatedButtonTokens.INSTANCE.m2118getContainerElevationD9Ej5fM();
        } else {
            f16 = f11;
        }
        if ((i12 & 2) != 0) {
            f17 = ElevatedButtonTokens.INSTANCE.m2124getPressedContainerElevationD9Ej5fM();
        } else {
            f17 = f12;
        }
        if ((i12 & 4) != 0) {
            f18 = ElevatedButtonTokens.INSTANCE.m2121getFocusContainerElevationD9Ej5fM();
        } else {
            f18 = f13;
        }
        if ((i12 & 8) != 0) {
            f19 = ElevatedButtonTokens.INSTANCE.m2122getHoverContainerElevationD9Ej5fM();
        } else {
            f19 = f14;
        }
        if ((i12 & 16) != 0) {
            f21 = ElevatedButtonTokens.INSTANCE.m2120getDisabledContainerElevationD9Ej5fM();
        } else {
            f21 = f15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, i11, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:700)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f16, f17, f18, f19, f21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @NotNull
    @Composable
    /* renamed from: filledTonalButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1521filledTonalButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1670757653);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, i11, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:598)");
        }
        ButtonColors buttonColors = new ButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @NotNull
    @Composable
    /* renamed from: filledTonalButtonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1522filledTonalButtonElevationR_JCAzs(float f11, float f12, float f13, float f14, float f15, @Nullable Composer composer, int i11, int i12) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f21;
        composer.startReplaceableGroup(5982871);
        if ((i12 & 1) != 0) {
            f16 = FilledTonalButtonTokens.INSTANCE.m2225getContainerElevationD9Ej5fM();
        } else {
            f16 = f11;
        }
        if ((i12 & 2) != 0) {
            f17 = FilledTonalButtonTokens.INSTANCE.m2231getPressedContainerElevationD9Ej5fM();
        } else {
            f17 = f12;
        }
        if ((i12 & 4) != 0) {
            f18 = FilledTonalButtonTokens.INSTANCE.m2228getFocusContainerElevationD9Ej5fM();
        } else {
            f18 = f13;
        }
        if ((i12 & 8) != 0) {
            f19 = FilledTonalButtonTokens.INSTANCE.m2229getHoverContainerElevationD9Ej5fM();
        } else {
            f19 = f14;
        }
        if ((i12 & 16) != 0) {
            f21 = Dp.m5478constructorimpl((float) 0);
        } else {
            f21 = f15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, i11, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:727)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f16, f17, f18, f19, f21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    @NotNull
    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    @NotNull
    @Composable
    @JvmName(name = "getElevatedShape")
    public final Shape getElevatedShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(2143958791);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:526)");
        }
        Shape shape = ShapesKt.toShape(ElevatedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getFilledTonalShape")
    public final Shape getFilledTonalShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-886584987);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:529)");
        }
        Shape shape = ShapesKt.toShape(FilledTonalButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1523getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m1524getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1525getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1526getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedButtonBorder")
    public final BorderStroke getOutlinedButtonBorder(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-563957672);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:744)");
        }
        OutlinedButtonTokens outlinedButtonTokens = OutlinedButtonTokens.INSTANCE;
        BorderStroke r52 = BorderStrokeKt.m191BorderStrokecXLIe8U(outlinedButtonTokens.m2308getOutlineWidthD9Ej5fM(), ColorSchemeKt.toColor(outlinedButtonTokens.getOutlineColor(), composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r52;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedShape")
    public final Shape getOutlinedShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-2045213065);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:532)");
        }
        Shape shape = ShapesKt.toShape(OutlinedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1234923021);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:523)");
        }
        Shape shape = ShapesKt.toShape(FilledButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @NotNull
    @Composable
    @JvmName(name = "getTextShape")
    public final Shape getTextShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-349121587);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i11, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:535)");
        }
        Shape shape = ShapesKt.toShape(TextButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1527outlinedButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1778526249);
        if ((i12 & 1) != 0) {
            j15 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, i11, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:624)");
        }
        ButtonColors buttonColors = new ButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }

    @NotNull
    @Composable
    /* renamed from: textButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1528textButtonColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1402274782);
        if ((i12 & 1) != 0) {
            j15 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getLabelTextColor(), composer2, 6);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i11, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:648)");
        }
        ButtonColors buttonColors = new ButtonColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonColors;
    }
}
