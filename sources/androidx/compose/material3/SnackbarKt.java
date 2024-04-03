package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ah\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001am\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float ContainerMaxWidth = Dp.m5478constructorimpl((float) 600);
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m5478constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m5478constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset = Dp.m5478constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m5478constructorimpl((float) 2);
    private static final float SnackbarVerticalPadding = Dp.m5478constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing;

    static {
        float f11 = (float) 8;
        HorizontalSpacingButtonSide = Dp.m5478constructorimpl(f11);
        TextEndExtraSpacing = Dp.m5478constructorimpl(f11);
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: NewLineButtonSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m1825NewLineButtonSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j11, long j12, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i19 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed((Object) function26)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        long j13 = j11;
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed(j13)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        long j14 = j12;
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed(j14)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        if ((374491 & i12) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i12, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:248)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier r72 = PaddingKt.m490paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m565widthInVpY3zN4$default(companion, 0.0f, ContainerMaxWidth, 1, (Object) null), 0.0f, 1, (Object) null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r72);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r12, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density, companion3.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r12, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-363148767);
            Modifier r202 = AlignmentLineKt.m374paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f12 = HorizontalSpacingButtonSide;
            Modifier r122 = PaddingKt.m490paddingqDBjuR0$default(r202, 0.0f, 0.0f, f12, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            float f13 = f12;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r122);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r22 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r22, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r22, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r22, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r22, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(74621659);
            function24.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier align = columnScopeInstance.align(companion, companion2.getEnd());
            if (function26 == null) {
                f11 = f13;
            } else {
                f11 = Dp.m5478constructorimpl((float) 0);
            }
            Modifier r73 = PaddingKt.m490paddingqDBjuR0$default(align, 0.0f, 0.0f, f11, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r73);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r14 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r14, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r14, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r14, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r14, viewConfiguration3, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(1640608516);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r102 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r102, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density4, companion3.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection4, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration4, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1595822816);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j11)), TextKt.getLocalTextStyle().provides(textStyle2)}, function22, startRestartGroup, (i12 & 112) | 8);
            if (function26 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j12))}, function26, startRestartGroup, ((i12 >> 3) & 112) | 8);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function27 = function25;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function2, function22, function23, textStyle, j11, j12, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: OneRowSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m1826OneRowSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j11, long j12, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        TextStyle textStyle2 = textStyle;
        int i19 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed((Object) function26)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        long j13 = j11;
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed(j13)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        long j14 = j12;
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed(j14)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        if ((374491 & i12) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i12, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:293)");
            }
            Modifier.Companion companion = Modifier.Companion;
            float f12 = HorizontalSpacing;
            if (function26 == null) {
                f11 = HorizontalSpacingButtonSide;
            } else {
                f11 = Dp.m5478constructorimpl((float) 0);
            }
            Modifier r14 = PaddingKt.m490paddingqDBjuR0$default(companion, f12, 0.0f, f11, 0.0f, 10, (Object) null);
            SnackbarKt$OneRowSnackbar$2 snackbarKt$OneRowSnackbar$2 = new SnackbarKt$OneRowSnackbar$2(NativeProtocol.WEB_DIALOG_ACTION, "dismissAction", "text");
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Object obj = "dismissAction";
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r14);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r32 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r32, snackbarKt$OneRowSnackbar$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r32, density, companion2.getSetDensity());
            Updater.m2543setimpl(r32, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r32, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1961334364);
            Modifier r82 = PaddingKt.m488paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r82);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r33 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r33, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r33, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r33, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r33, viewConfiguration2, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-789862614);
            function24.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-167734710);
            if (function25 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(companion, NativeProtocol.WEB_DIALOG_ACTION);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r142 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r142, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r142, density3, companion2.getSetDensity());
                Updater.m2543setimpl(r142, layoutDirection3, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r142, viewConfiguration3, companion2.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(801714373);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j11)), TextKt.getLocalTextStyle().provides(textStyle2)}, function25, startRestartGroup, (i12 & 112) | 8);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            Function2<? super Composer, ? super Integer, Unit> function27 = function23;
            if (function27 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(companion, obj);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(layoutId2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r12, rememberBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r12, density4, companion2.getSetDensity());
                Updater.m2543setimpl(r12, layoutDirection4, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r12, viewConfiguration4, companion2.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(88411260);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j12))}, function27, startRestartGroup, ((i12 >> 3) & 112) | 8);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function28 = function26;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function2, function22, function23, textStyle, j11, j12, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0113  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Snackbar-eQBnUkQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1827SnackbareQBnUkQ(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, boolean r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r29, long r30, long r32, long r34, long r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r14 = r38
            r15 = r40
            r12 = r41
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            r1 = r39
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001e
            r3 = r15 | 6
            r4 = r3
            r3 = r25
            goto L_0x0032
        L_0x001e:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x002f
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r15
            goto L_0x0032
        L_0x002f:
            r3 = r25
            r4 = r15
        L_0x0032:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r26
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r4 = r4 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r26
        L_0x004e:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r8 = r15 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0068
            r8 = r27
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0064
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r9
            goto L_0x006a
        L_0x0068:
            r8 = r27
        L_0x006a:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0071
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r10 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0084
            r10 = r28
            boolean r11 = r1.changed((boolean) r10)
            if (r11 == 0) goto L_0x0080
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r4 = r4 | r11
            goto L_0x0086
        L_0x0084:
            r10 = r28
        L_0x0086:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r15
            if (r11 != 0) goto L_0x00a1
            r11 = r12 & 16
            if (r11 != 0) goto L_0x009b
            r11 = r29
            boolean r13 = r1.changed((java.lang.Object) r11)
            if (r13 == 0) goto L_0x009d
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r11 = r29
        L_0x009d:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r4 = r4 | r13
            goto L_0x00a3
        L_0x00a1:
            r11 = r29
        L_0x00a3:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x00bb
            r13 = r12 & 32
            r10 = r30
            if (r13 != 0) goto L_0x00b7
            boolean r13 = r1.changed((long) r10)
            if (r13 == 0) goto L_0x00b7
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r4 = r4 | r13
            goto L_0x00bd
        L_0x00bb:
            r10 = r30
        L_0x00bd:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x00d5
            r13 = r12 & 64
            r10 = r32
            if (r13 != 0) goto L_0x00d1
            boolean r13 = r1.changed((long) r10)
            if (r13 == 0) goto L_0x00d1
            r13 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r13 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r4 = r4 | r13
            goto L_0x00d7
        L_0x00d5:
            r10 = r32
        L_0x00d7:
            r13 = 29360128(0x1c00000, float:7.052966E-38)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x00ef
            r13 = r12 & 128(0x80, float:1.794E-43)
            r10 = r34
            if (r13 != 0) goto L_0x00eb
            boolean r13 = r1.changed((long) r10)
            if (r13 == 0) goto L_0x00eb
            r13 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00eb:
            r13 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r4 = r4 | r13
            goto L_0x00f1
        L_0x00ef:
            r10 = r34
        L_0x00f1:
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x0109
            r13 = r12 & 256(0x100, float:3.59E-43)
            r10 = r36
            if (r13 != 0) goto L_0x0105
            boolean r13 = r1.changed((long) r10)
            if (r13 == 0) goto L_0x0105
            r13 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0107
        L_0x0105:
            r13 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0107:
            r4 = r4 | r13
            goto L_0x010b
        L_0x0109:
            r10 = r36
        L_0x010b:
            r13 = r12 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0113
            r13 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0111:
            r4 = r4 | r13
            goto L_0x0124
        L_0x0113:
            r13 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r15
            if (r13 != 0) goto L_0x0124
            boolean r13 = r1.changed((java.lang.Object) r14)
            if (r13 == 0) goto L_0x0121
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0111
        L_0x0121:
            r13 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0111
        L_0x0124:
            r13 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r13 = r13 & r4
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r13 != r0) goto L_0x0145
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0134
            goto L_0x0145
        L_0x0134:
            r1.skipToGroupEnd()
            r4 = r28
            r5 = r29
            r19 = r32
            r2 = r6
            r12 = r10
            r6 = r30
            r10 = r34
            goto L_0x0265
        L_0x0145:
            r1.startDefaults()
            r0 = r15 & 1
            r13 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0190
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0162
            goto L_0x0190
        L_0x0162:
            r1.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x016b
            r4 = r4 & r20
        L_0x016b:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0171
            r4 = r4 & r19
        L_0x0171:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0177
            r4 = r4 & r18
        L_0x0177:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x017d
            r4 = r4 & r17
        L_0x017d:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0182
            r4 = r4 & r13
        L_0x0182:
            r5 = r29
            r19 = r32
            r21 = r34
            r0 = r3
            r2 = r8
            r3 = r28
            r8 = r30
            goto L_0x01ef
        L_0x0190:
            if (r2 == 0) goto L_0x0195
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0196
        L_0x0195:
            r0 = r3
        L_0x0196:
            r2 = 0
            if (r5 == 0) goto L_0x019a
            r6 = r2
        L_0x019a:
            if (r7 == 0) goto L_0x019d
            goto L_0x019e
        L_0x019d:
            r2 = r8
        L_0x019e:
            if (r9 == 0) goto L_0x01a2
            r3 = 0
            goto L_0x01a4
        L_0x01a2:
            r3 = r28
        L_0x01a4:
            r5 = r12 & 16
            r7 = 6
            if (r5 == 0) goto L_0x01b2
            androidx.compose.material3.SnackbarDefaults r5 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r1, r7)
            r4 = r4 & r20
            goto L_0x01b4
        L_0x01b2:
            r5 = r29
        L_0x01b4:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01c1
            androidx.compose.material3.SnackbarDefaults r8 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r8 = r8.getColor(r1, r7)
            r4 = r4 & r19
            goto L_0x01c3
        L_0x01c1:
            r8 = r30
        L_0x01c3:
            r19 = r12 & 64
            if (r19 == 0) goto L_0x01d0
            androidx.compose.material3.SnackbarDefaults r13 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r19 = r13.getContentColor(r1, r7)
            r4 = r4 & r18
            goto L_0x01d2
        L_0x01d0:
            r19 = r32
        L_0x01d2:
            r13 = r12 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x01df
            androidx.compose.material3.SnackbarDefaults r13 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r21 = r13.getActionContentColor(r1, r7)
            r4 = r4 & r17
            goto L_0x01e1
        L_0x01df:
            r21 = r34
        L_0x01e1:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x01ef
            androidx.compose.material3.SnackbarDefaults r10 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r10 = r10.getDismissActionContentColor(r1, r7)
            r7 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r4 = r4 & r7
        L_0x01ef:
            r1.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0201
            r7 = -1
            java.lang.String r13 = "androidx.compose.material3.Snackbar (Snackbar.kt:91)"
            r12 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r7, r13)
        L_0x0201:
            androidx.compose.material3.tokens.SnackbarTokens r12 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r12 = r12.m2427getContainerElevationD9Ej5fM()
            androidx.compose.material3.SnackbarKt$Snackbar$1 r13 = new androidx.compose.material3.SnackbarKt$Snackbar$1
            r25 = r13
            r26 = r6
            r27 = r38
            r28 = r2
            r29 = r21
            r31 = r10
            r33 = r4
            r34 = r3
            r25.<init>(r26, r27, r28, r29, r31, r33, r34)
            r7 = -1829663446(0xffffffff92f18d2a, float:-1.5244038E-27)
            r39 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r2, r13)
            r7 = 12779520(0xc30000, float:1.7907922E-38)
            r13 = r4 & 14
            r7 = r7 | r13
            int r4 = r4 >> 9
            r13 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r13
            r13 = r4 & 896(0x380, float:1.256E-42)
            r7 = r7 | r13
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r7
            r7 = 80
            r25 = r0
            r26 = r5
            r27 = r8
            r29 = r19
            r13 = 0
            r31 = r13
            r32 = r12
            r12 = 0
            r33 = r12
            r34 = r2
            r35 = r1
            r36 = r4
            r37 = r7
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r25, r26, r27, r29, r31, r32, r33, r34, r35, r36, r37)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x025c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025c:
            r4 = r3
            r2 = r6
            r6 = r8
            r12 = r10
            r10 = r21
            r8 = r39
            r3 = r0
        L_0x0265:
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 != 0) goto L_0x026c
            goto L_0x0287
        L_0x026c:
            androidx.compose.material3.SnackbarKt$Snackbar$2 r1 = new androidx.compose.material3.SnackbarKt$Snackbar$2
            r0 = r1
            r23 = r1
            r1 = r3
            r3 = r8
            r24 = r9
            r8 = r19
            r14 = r38
            r15 = r40
            r16 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r15, r16)
            r1 = r23
            r0 = r24
            r0.updateScope(r1)
        L_0x0287:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m1827SnackbareQBnUkQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Snackbar-sDKtq54  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1828SnackbarsDKtq54(@org.jetbrains.annotations.NotNull androidx.compose.material3.SnackbarData r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r40, boolean r41, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r42, long r43, long r45, long r47, long r49, long r51, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r53, int r54, int r55) {
        /*
            r1 = r39
            r15 = r54
            r13 = r55
            java.lang.String r0 = "snackbarData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 274621471(0x105e641f, float:4.385891E-29)
            r2 = r53
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r15
            goto L_0x002b
        L_0x002a:
            r3 = r15
        L_0x002b:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r15 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r40
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r40
        L_0x0047:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r15 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0061
            r7 = r41
            boolean r8 = r2.changed((boolean) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r41
        L_0x0063:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007c
            r8 = r13 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r42
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r42
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
            goto L_0x007e
        L_0x007c:
            r8 = r42
        L_0x007e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r10 = r15 & r9
            if (r10 != 0) goto L_0x009a
            r10 = r13 & 16
            if (r10 != 0) goto L_0x0094
            r10 = r43
            boolean r12 = r2.changed((long) r10)
            if (r12 == 0) goto L_0x0096
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r10 = r43
        L_0x0096:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r12
            goto L_0x009c
        L_0x009a:
            r10 = r43
        L_0x009c:
            r12 = 458752(0x70000, float:6.42848E-40)
            r14 = r15 & r12
            if (r14 != 0) goto L_0x00b5
            r14 = r13 & 32
            r9 = r45
            if (r14 != 0) goto L_0x00b1
            boolean r11 = r2.changed((long) r9)
            if (r11 == 0) goto L_0x00b1
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r11
            goto L_0x00b7
        L_0x00b5:
            r9 = r45
        L_0x00b7:
            r11 = 3670016(0x380000, float:5.142788E-39)
            r14 = r15 & r11
            if (r14 != 0) goto L_0x00d1
            r14 = r13 & 64
            r11 = r47
            if (r14 != 0) goto L_0x00cc
            boolean r16 = r2.changed((long) r11)
            if (r16 == 0) goto L_0x00cc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r3 = r3 | r16
            goto L_0x00d3
        L_0x00d1:
            r11 = r47
        L_0x00d3:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r15 & r18
            if (r16 != 0) goto L_0x00ed
            r14 = r13 & 128(0x80, float:1.794E-43)
            r0 = r49
            if (r14 != 0) goto L_0x00e8
            boolean r16 = r2.changed((long) r0)
            if (r16 == 0) goto L_0x00e8
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r3 = r3 | r16
            goto L_0x00ef
        L_0x00ed:
            r0 = r49
        L_0x00ef:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r15 & r20
            if (r16 != 0) goto L_0x0108
            r14 = r13 & 256(0x100, float:3.59E-43)
            r0 = r51
            if (r14 != 0) goto L_0x0104
            boolean r14 = r2.changed((long) r0)
            if (r14 == 0) goto L_0x0104
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0106
        L_0x0104:
            r14 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0106:
            r3 = r3 | r14
            goto L_0x010a
        L_0x0108:
            r0 = r51
        L_0x010a:
            r14 = 191739611(0xb6db6db, float:4.5782105E-32)
            r14 = r14 & r3
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r14 != r0) goto L_0x0129
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x011a
            goto L_0x0129
        L_0x011a:
            r2.skipToGroupEnd()
            r6 = r39
            r33 = r49
            r35 = r51
            r3 = r7
            r4 = r8
            r7 = r43
            goto L_0x028c
        L_0x0129:
            r2.startDefaults()
            r0 = r15 & 1
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r14 = -3670017(0xffffffffffc7ffff, float:NaN)
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r22 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0175
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0143
            goto L_0x0175
        L_0x0143:
            r2.skipToGroupEnd()
            r0 = r13 & 8
            if (r0 == 0) goto L_0x014c
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014c:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0152
            r3 = r3 & r22
        L_0x0152:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x0158
            r3 = r3 & r21
        L_0x0158:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x015d
            r3 = r3 & r14
        L_0x015d:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0162
            r3 = r3 & r1
        L_0x0162:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x016a
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r0
        L_0x016a:
            r33 = r49
            r35 = r51
            r0 = r5
            r4 = r7
            r5 = r8
            r7 = r43
            goto L_0x01db
        L_0x0175:
            if (r4 == 0) goto L_0x017a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x017b
        L_0x017a:
            r0 = r5
        L_0x017b:
            if (r6 == 0) goto L_0x017f
            r4 = 0
            goto L_0x0180
        L_0x017f:
            r4 = r7
        L_0x0180:
            r5 = r13 & 8
            r6 = 6
            if (r5 == 0) goto L_0x018e
            androidx.compose.material3.SnackbarDefaults r5 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r2, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x018f
        L_0x018e:
            r5 = r8
        L_0x018f:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x019c
            androidx.compose.material3.SnackbarDefaults r7 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r7 = r7.getColor(r2, r6)
            r3 = r3 & r22
            goto L_0x019e
        L_0x019c:
            r7 = r43
        L_0x019e:
            r22 = r13 & 32
            if (r22 == 0) goto L_0x01aa
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r9 = r9.getContentColor(r2, r6)
            r3 = r3 & r21
        L_0x01aa:
            r21 = r13 & 64
            if (r21 == 0) goto L_0x01b5
            androidx.compose.material3.SnackbarDefaults r11 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r11 = r11.getActionColor(r2, r6)
            r3 = r3 & r14
        L_0x01b5:
            r14 = r13 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x01c2
            androidx.compose.material3.SnackbarDefaults r14 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r21 = r14.getActionContentColor(r2, r6)
            r1 = r1 & r3
            r3 = r1
            goto L_0x01c4
        L_0x01c2:
            r21 = r49
        L_0x01c4:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01d7
            androidx.compose.material3.SnackbarDefaults r1 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r23 = r1.getDismissActionContentColor(r2, r6)
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r1
            r33 = r21
            r35 = r23
            goto L_0x01db
        L_0x01d7:
            r35 = r51
            r33 = r21
        L_0x01db:
            r2.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01ed
            r1 = -1
            java.lang.String r6 = "androidx.compose.material3.Snackbar (Snackbar.kt:194)"
            r14 = 274621471(0x105e641f, float:4.385891E-29)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r3, r1, r6)
        L_0x01ed:
            androidx.compose.material3.SnackbarVisuals r1 = r39.getVisuals()
            java.lang.String r1 = r1.getActionLabel()
            r6 = 1
            if (r1 == 0) goto L_0x020f
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1 r14 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
            r40 = r14
            r41 = r11
            r43 = r3
            r44 = r39
            r45 = r1
            r40.<init>(r41, r43, r44, r45)
            r1 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r1, r6, r14)
            goto L_0x0210
        L_0x020f:
            r1 = 0
        L_0x0210:
            androidx.compose.material3.SnackbarVisuals r14 = r39.getVisuals()
            boolean r14 = r14.getWithDismissAction()
            if (r14 == 0) goto L_0x022c
            androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1 r14 = new androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
            r6 = r39
            r14.<init>(r6, r3)
            r41 = r11
            r11 = -1812633777(0xffffffff93f5674f, float:-6.1948565E-27)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r11, r12, r14)
            goto L_0x0231
        L_0x022c:
            r6 = r39
            r41 = r11
            r11 = 0
        L_0x0231:
            r12 = 12
            float r12 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r12)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m486padding3ABfNKs(r0, r12)
            androidx.compose.material3.SnackbarKt$Snackbar$3 r12 = new androidx.compose.material3.SnackbarKt$Snackbar$3
            r12.<init>(r6)
            r14 = -1266389126(0xffffffffb4846f7a, float:-2.4668026E-7)
            r43 = r0
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r29 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r14, r0, r12)
            int r0 = r3 << 3
            r12 = r0 & 7168(0x1c00, float:1.0045E-41)
            r14 = 805306368(0x30000000, float:4.656613E-10)
            r12 = r12 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r0
            r12 = r12 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r0
            r12 = r12 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r14
            r0 = r0 | r12
            r12 = r3 & r18
            r0 = r0 | r12
            r3 = r3 & r20
            r31 = r0 | r3
            r32 = 0
            r17 = r1
            r18 = r11
            r19 = r4
            r20 = r5
            r21 = r7
            r23 = r9
            r25 = r33
            r27 = r35
            r30 = r2
            m1827SnackbareQBnUkQ(r16, r17, r18, r19, r20, r21, r23, r25, r27, r29, r30, r31, r32)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0286
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0286:
            r11 = r41
            r3 = r4
            r4 = r5
            r5 = r43
        L_0x028c:
            androidx.compose.runtime.ScopeUpdateScope r14 = r2.endRestartGroup()
            if (r14 != 0) goto L_0x0293
            goto L_0x02b3
        L_0x0293:
            androidx.compose.material3.SnackbarKt$Snackbar$4 r2 = new androidx.compose.material3.SnackbarKt$Snackbar$4
            r0 = r2
            r1 = r39
            r6 = r2
            r2 = r5
            r37 = r6
            r5 = r7
            r7 = r9
            r9 = r11
            r11 = r33
            r38 = r14
            r13 = r35
            r15 = r54
            r16 = r55
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r13, r15, r16)
            r1 = r37
            r0 = r38
            r0.updateScope(r1)
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m1828SnackbarsDKtq54(androidx.compose.material3.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
