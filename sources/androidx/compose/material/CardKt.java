package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CardKt {
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @ExperimentalMaterialApi
    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    @Composable
    /* renamed from: Card-9VG74zQ  reason: not valid java name */
    public static final void m1141Card9VG74zQ(@NotNull Function0<Unit> function0, @Nullable Modifier modifier, @Nullable Shape shape, long j11, long j12, @Nullable BorderStroke borderStroke, float f11, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z11, @Nullable String str, @Nullable Role role, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12, int i13) {
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i14 = i11;
        int i15 = i12;
        int i16 = i13;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(1353606722);
        Modifier modifier2 = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        Shape medium = (i16 & 4) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium() : shape;
        long r62 = (i16 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU() : j11;
        long r82 = (i16 & 16) != 0 ? ColorsKt.m1197contentColorForek8zF_U(r62, composer2, (i14 >> 9) & 14) : j12;
        BorderStroke borderStroke2 = (i16 & 32) != 0 ? null : borderStroke;
        float r12 = (i16 & 64) != 0 ? Dp.m5478constructorimpl((float) 1) : f11;
        if ((i16 & 128) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        SurfaceKt.m1383Surface9VG74zQ(function0, modifier2, medium, r62, r82, borderStroke2, r12, mutableInteractionSource2, (i16 & 256) != 0 ? (Indication) composer2.consume(IndicationKt.getLocalIndication()) : indication, (i16 & 512) != 0 ? true : z11, (i16 & 1024) != 0 ? null : str, (i16 & 2048) != 0 ? null : role, function2, composer, (i14 & 14) | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), (i15 & 14) | (i15 & 112) | (i15 & 896), 0);
        composer.endReplaceableGroup();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Card-F-jzlyU  reason: not valid java name */
    public static final void m1142CardFjzlyU(@Nullable Modifier modifier, @Nullable Shape shape, long j11, long j12, @Nullable BorderStroke borderStroke, float f11, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        Shape shape2;
        long j13;
        long j14;
        BorderStroke borderStroke2;
        float f12;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(1956755640);
        if ((i12 & 1) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i12 & 2) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium();
        } else {
            shape2 = shape;
        }
        if ((i12 & 4) != 0) {
            j13 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j13 = j11;
        }
        if ((i12 & 8) != 0) {
            j14 = ColorsKt.m1197contentColorForek8zF_U(j13, composer2, (i13 >> 6) & 14);
        } else {
            j14 = j12;
        }
        if ((i12 & 16) != 0) {
            borderStroke2 = null;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i12 & 32) != 0) {
            f12 = Dp.m5478constructorimpl((float) 1);
        } else {
            f12 = f11;
        }
        SurfaceKt.m1384SurfaceFjzlyU(modifier2, shape2, j13, j14, borderStroke2, f12, function2, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
        composer.endReplaceableGroup();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @ExperimentalMaterialApi
    @Composable
    /* renamed from: Card-LPr_se0  reason: not valid java name */
    public static final void m1143CardLPr_se0(@NotNull Function0<Unit> function0, @Nullable Modifier modifier, boolean z11, @Nullable Shape shape, long j11, long j12, @Nullable BorderStroke borderStroke, float f11, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        boolean z12;
        Shape shape2;
        long j13;
        long j14;
        BorderStroke borderStroke2;
        float f12;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i13 = i11;
        int i14 = i12;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(778538979);
        if ((i14 & 2) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i14 & 4) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i14 & 8) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium();
        } else {
            shape2 = shape;
        }
        if ((i14 & 16) != 0) {
            j13 = MaterialTheme.INSTANCE.getColors(composer2, 6).m1183getSurface0d7_KjU();
        } else {
            j13 = j11;
        }
        if ((i14 & 32) != 0) {
            j14 = ColorsKt.m1197contentColorForek8zF_U(j13, composer2, (i13 >> 12) & 14);
        } else {
            j14 = j12;
        }
        if ((i14 & 64) != 0) {
            borderStroke2 = null;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i14 & 128) != 0) {
            f12 = Dp.m5478constructorimpl((float) 1);
        } else {
            f12 = f11;
        }
        if ((i14 & 256) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        SurfaceKt.m1385SurfaceLPr_se0(function0, modifier2, z12, shape2, j13, j14, borderStroke2, f12, mutableInteractionSource2, function2, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192), 0);
        composer.endReplaceableGroup();
    }
}
