package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ap\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a%\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a;\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SurfaceKt {
    @NotNull
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, SurfaceKt$LocalAbsoluteTonalElevation$1.INSTANCE, 1, (Object) null);

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Surface-T9BRK9s  reason: not valid java name */
    public static final void m1857SurfaceT9BRK9s(@Nullable Modifier modifier, @Nullable Shape shape, long j11, long j12, float f11, float f12, @Nullable BorderStroke borderStroke, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        Shape shape2;
        long j13;
        long j14;
        float f13;
        float f14;
        BorderStroke borderStroke2;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(-513881741);
        if ((i12 & 1) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i12 & 2) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i12 & 4) != 0) {
            j13 = MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU();
        } else {
            j13 = j11;
        }
        if ((i12 & 8) != 0) {
            j14 = ColorSchemeKt.m1609contentColorForek8zF_U(j13, composer2, (i13 >> 6) & 14);
        } else {
            j14 = j12;
        }
        if ((i12 & 16) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        } else {
            f13 = f11;
        }
        if ((i12 & 32) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        } else {
            f14 = f12;
        }
        if ((i12 & 64) != 0) {
            borderStroke2 = null;
        } else {
            borderStroke2 = borderStroke;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i13, -1, "androidx.compose.material3.Surface (Surface.kt:98)");
        }
        ProvidableCompositionLocal providableCompositionLocal = LocalAbsoluteTonalElevation;
        float r62 = Dp.m5478constructorimpl(((Dp) composer2.consume(providableCompositionLocal)).m5492unboximpl() + f13);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j14)), providableCompositionLocal.provides(Dp.m5476boximpl(r62))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -70914509, true, new SurfaceKt$Surface$1(modifier2, shape2, j13, r62, i11, borderStroke2, f14, function2)), composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m1858Surfaced85dljk(boolean z11, @NotNull Function0<Unit> function0, @Nullable Modifier modifier, boolean z12, @Nullable Shape shape, long j11, long j12, float f11, float f12, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12, int i13) {
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i14 = i11;
        int i15 = i13;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(540296512);
        Modifier modifier2 = (i15 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z13 = (i15 & 8) != 0 ? true : z12;
        Shape rectangleShape = (i15 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r52 = (i15 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU() : j11;
        long r82 = (i15 & 64) != 0 ? ColorSchemeKt.m1609contentColorForek8zF_U(r52, composer2, (i14 >> 15) & 14) : j12;
        float r102 = (i15 & 128) != 0 ? Dp.m5478constructorimpl((float) 0) : f11;
        float r15 = (i15 & 256) != 0 ? Dp.m5478constructorimpl((float) 0) : f12;
        BorderStroke borderStroke2 = (i15 & 512) != 0 ? null : borderStroke;
        if ((i15 & 1024) != 0) {
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, i14, i12, "androidx.compose.material3.Surface (Surface.kt:311)");
        } else {
            int i16 = i12;
        }
        ProvidableCompositionLocal providableCompositionLocal = LocalAbsoluteTonalElevation;
        float r103 = Dp.m5478constructorimpl(((Dp) composer2.consume(providableCompositionLocal)).m5492unboximpl() + r102);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(r82)), providableCompositionLocal.provides(Dp.m5476boximpl(r103))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -1164547968, true, new SurfaceKt$Surface$5(modifier2, rectangleShape, r52, r103, i11, borderStroke2, r15, z11, mutableInteractionSource2, z13, function0, function2, i12)), composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Surface-o_FOJdg  reason: not valid java name */
    public static final void m1860Surfaceo_FOJdg(@NotNull Function0<Unit> function0, @Nullable Modifier modifier, boolean z11, @Nullable Shape shape, long j11, long j12, float f11, float f12, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12, int i13) {
        Modifier modifier2;
        boolean z12;
        Shape shape2;
        long j13;
        long j14;
        float f13;
        float f14;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i14 = i11;
        int i15 = i13;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(-789752804);
        if ((i15 & 2) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i15 & 4) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i15 & 8) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i15 & 16) != 0) {
            j13 = MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU();
        } else {
            j13 = j11;
        }
        if ((i15 & 32) != 0) {
            j14 = ColorSchemeKt.m1609contentColorForek8zF_U(j13, composer2, (i14 >> 12) & 14);
        } else {
            j14 = j12;
        }
        if ((i15 & 64) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        } else {
            f13 = f11;
        }
        if ((i15 & 128) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        } else {
            f14 = f12;
        }
        if ((i15 & 256) != 0) {
            borderStroke2 = null;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i15 & 512) != 0) {
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, i14, i12, "androidx.compose.material3.Surface (Surface.kt:200)");
        } else {
            int i16 = i12;
        }
        ProvidableCompositionLocal providableCompositionLocal = LocalAbsoluteTonalElevation;
        float r102 = Dp.m5478constructorimpl(((Dp) composer2.consume(providableCompositionLocal)).m5492unboximpl() + f13);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j14)), providableCompositionLocal.provides(Dp.m5476boximpl(r102))};
        ProvidedValue[] providedValueArr2 = providedValueArr;
        SurfaceKt$Surface$3 surfaceKt$Surface$3 = r1;
        SurfaceKt$Surface$3 surfaceKt$Surface$32 = new SurfaceKt$Surface$3(modifier2, shape2, j13, r102, i11, borderStroke2, f14, mutableInteractionSource2, z12, function0, function2, i12);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1279702876, true, surfaceKt$Surface$3), composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg  reason: not valid java name */
    public static final Modifier m1863surface8ww4TTg(Modifier modifier, Shape shape, long j11, BorderStroke borderStroke, float f11) {
        Modifier modifier2;
        Modifier r102 = ShadowKt.m2593shadows4CzXII$default(modifier, f11, shape, false, 0, 0, 24, (Object) null);
        if (borderStroke != null) {
            modifier2 = BorderKt.border(Modifier.Companion, borderStroke, shape);
        } else {
            modifier2 = Modifier.Companion;
        }
        return ClipKt.clip(BackgroundKt.m176backgroundbw27NRU(r102.then(modifier2), j11, shape), shape);
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: surfaceColorAtElevation-CLU3JFs  reason: not valid java name */
    public static final long m1864surfaceColorAtElevationCLU3JFs(long j11, float f11, Composer composer, int i11) {
        composer.startReplaceableGroup(-2079918090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i11, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:481)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        if (Color.m2920equalsimpl0(j11, materialTheme.getColorScheme(composer, 6).m1573getSurface0d7_KjU())) {
            j11 = ColorSchemeKt.m1614surfaceColorAtElevation3ABfNKs(materialTheme.getColorScheme(composer, 6), f11);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j11;
    }

    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m1859Surfaced85dljk(boolean z11, @NotNull Function1<? super Boolean, Unit> function1, @Nullable Modifier modifier, boolean z12, @Nullable Shape shape, long j11, long j12, float f11, float f12, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12, int i13) {
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i14 = i11;
        int i15 = i13;
        Intrinsics.checkNotNullParameter(function1, "onCheckedChange");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(-1877401889);
        Modifier modifier2 = (i15 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z13 = (i15 & 8) != 0 ? true : z12;
        Shape rectangleShape = (i15 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r52 = (i15 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU() : j11;
        long r82 = (i15 & 64) != 0 ? ColorSchemeKt.m1609contentColorForek8zF_U(r52, composer2, (i14 >> 15) & 14) : j12;
        float r102 = (i15 & 128) != 0 ? Dp.m5478constructorimpl((float) 0) : f11;
        float r15 = (i15 & 256) != 0 ? Dp.m5478constructorimpl((float) 0) : f12;
        BorderStroke borderStroke2 = (i15 & 512) != 0 ? null : borderStroke;
        if ((i15 & 1024) != 0) {
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, i14, i12, "androidx.compose.material3.Surface (Surface.kt:424)");
        } else {
            int i16 = i12;
        }
        ProvidableCompositionLocal providableCompositionLocal = LocalAbsoluteTonalElevation;
        float r103 = Dp.m5478constructorimpl(((Dp) composer2.consume(providableCompositionLocal)).m5492unboximpl() + r102);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(r82)), providableCompositionLocal.provides(Dp.m5476boximpl(r103))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 712720927, true, new SurfaceKt$Surface$7(modifier2, rectangleShape, r52, r103, i11, borderStroke2, r15, z11, mutableInteractionSource2, z13, function1, function2, i12)), composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
