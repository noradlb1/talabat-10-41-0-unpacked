package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0013JQ\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'J=\u0010(\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u0013JQ\u0010*\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "cardColors", "Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: cardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1529cardColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-1589582123);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(FilledCardTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            FilledCardTokens filledCardTokens = FilledCardTokens.INSTANCE;
            j17 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(filledCardTokens.getDisabledContainerColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1614surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), filledCardTokens.m2210getDisabledContainerElevationD9Ej5fM()));
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i13, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:455)");
        }
        CardColors cardColors = new CardColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @NotNull
    @Composable
    /* renamed from: cardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1530cardElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(-574898487);
        if ((i12 & 1) != 0) {
            f17 = FilledCardTokens.INSTANCE.m2209getContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = FilledCardTokens.INSTANCE.m2215getPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = FilledCardTokens.INSTANCE.m2212getFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = FilledCardTokens.INSTANCE.m2213getHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = FilledCardTokens.INSTANCE.m2211getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = FilledCardTokens.INSTANCE.m2210getDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i11, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:373)");
        }
        CardElevation cardElevation = new CardElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1531elevatedCardColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(139558303);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(ElevatedCardTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            ElevatedCardTokens elevatedCardTokens = ElevatedCardTokens.INSTANCE;
            j17 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(elevatedCardTokens.getDisabledContainerColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1614surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), elevatedCardTokens.m2126getDisabledContainerElevationD9Ej5fM()));
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(j16, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i13, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:484)");
        }
        CardColors cardColors = new CardColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @NotNull
    @Composable
    /* renamed from: elevatedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1532elevatedCardElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(1154241939);
        if ((i12 & 1) != 0) {
            f17 = ElevatedCardTokens.INSTANCE.m2125getContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = ElevatedCardTokens.INSTANCE.m2131getPressedContainerElevationD9Ej5fM();
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = ElevatedCardTokens.INSTANCE.m2128getFocusContainerElevationD9Ej5fM();
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = ElevatedCardTokens.INSTANCE.m2129getHoverContainerElevationD9Ej5fM();
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = ElevatedCardTokens.INSTANCE.m2127getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = ElevatedCardTokens.INSTANCE.m2126getDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i11, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:401)");
        }
        CardElevation cardElevation = new CardElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    @NotNull
    @Composable
    @JvmName(name = "getElevatedShape")
    public final Shape getElevatedShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-133496185);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i11, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:357)");
        }
        Shape shape = ShapesKt.toShape(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    @JvmName(name = "getOutlinedShape")
    public final Shape getOutlinedShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1095404023);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i11, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:360)");
        }
        Shape shape = ShapesKt.toShape(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
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
        composer.startReplaceableGroup(1266660211);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i11, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:354)");
        }
        Shape shape = ShapesKt.toShape(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @NotNull
    @Composable
    public final BorderStroke outlinedCardBorder(boolean z11, @Nullable Composer composer, int i11, int i12) {
        long j11;
        composer.startReplaceableGroup(-392936593);
        if ((i12 & 1) != 0) {
            z11 = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i11, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:533)");
        }
        if (z11) {
            composer.startReplaceableGroup(-31428837);
            j11 = ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-31428766);
            OutlinedCardTokens outlinedCardTokens = OutlinedCardTokens.INSTANCE;
            j11 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(outlinedCardTokens.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1614surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), outlinedCardTokens.m2310getDisabledContainerElevationD9Ej5fM()));
            composer.endReplaceableGroup();
        }
        Color r92 = Color.m2909boximpl(j11);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) r92);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m2315getOutlineWidthD9Ej5fM(), j11);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BorderStroke borderStroke = (BorderStroke) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1533outlinedCardColorsro_MJ88(long j11, long j12, long j13, long j14, @Nullable Composer composer, int i11, int i12) {
        long j15;
        long j16;
        long j17;
        long j18;
        Composer composer2 = composer;
        int i13 = i11;
        composer2.startReplaceableGroup(-1112362409);
        if ((i12 & 1) != 0) {
            j15 = ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = ColorSchemeKt.m1609contentColorForek8zF_U(j15, composer2, i13 & 14);
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            j17 = j15;
        } else {
            j17 = j13;
        }
        if ((i12 & 8) != 0) {
            j18 = Color.m2918copywmQWz5c$default(j16, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j18 = j14;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i13, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:514)");
        }
        CardColors cardColors = new CardColors(j15, j16, j17, j18, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColors;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1534outlinedCardElevationaqJV_2Y(float f11, float f12, float f13, float f14, float f15, float f16, @Nullable Composer composer, int i11, int i12) {
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        composer.startReplaceableGroup(-97678773);
        if ((i12 & 1) != 0) {
            f17 = OutlinedCardTokens.INSTANCE.m2309getContainerElevationD9Ej5fM();
        } else {
            f17 = f11;
        }
        if ((i12 & 2) != 0) {
            f18 = f17;
        } else {
            f18 = f12;
        }
        if ((i12 & 4) != 0) {
            f19 = f17;
        } else {
            f19 = f13;
        }
        if ((i12 & 8) != 0) {
            f21 = f17;
        } else {
            f21 = f14;
        }
        if ((i12 & 16) != 0) {
            f22 = OutlinedCardTokens.INSTANCE.m2311getDraggedContainerElevationD9Ej5fM();
        } else {
            f22 = f15;
        }
        if ((i12 & 32) != 0) {
            f23 = OutlinedCardTokens.INSTANCE.m2310getDisabledContainerElevationD9Ej5fM();
        } else {
            f23 = f16;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i11, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:429)");
        }
        CardElevation cardElevation = new CardElevation(f17, f18, f19, f21, f22, f23, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }
}
