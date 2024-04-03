package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m5478constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m5478constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset = Dp.m5478constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m5478constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightOneLine = Dp.m5478constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightTwoLines = Dp.m5478constructorimpl((float) 68);
    private static final float SnackbarVerticalPadding = Dp.m5478constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing;

    static {
        float f11 = (float) 8;
        HorizontalSpacingButtonSide = Dp.m5478constructorimpl(f11);
        TextEndExtraSpacing = Dp.m5478constructorimpl(f11);
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void NewLineButtonSnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1229075900);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null);
            float f11 = HorizontalSpacing;
            float f12 = HorizontalSpacingButtonSide;
            Modifier r72 = PaddingKt.m490paddingqDBjuR0$default(fillMaxWidth$default, f11, 0.0f, f12, SeparateButtonExtraY, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
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
            Composer r102 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r102, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion3.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1214415430);
            Modifier r62 = PaddingKt.m490paddingqDBjuR0$default(AlignmentLineKt.m374paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f12, 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r62);
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
            Composer r73 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r73, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r73, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r73, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r73, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1193033152);
            function23.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier align = columnScopeInstance.align(companion, companion2.getEnd());
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(align);
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
            Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r12, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r12, viewConfiguration3, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-2100387721);
            function24.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
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
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function23, function24, i15));
        }
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void OneRowSnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-534813202);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            Modifier r62 = PaddingKt.m490paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, (Object) null);
            SnackbarKt$OneRowSnackbar$2 snackbarKt$OneRowSnackbar$2 = new SnackbarKt$OneRowSnackbar$2(NativeProtocol.WEB_DIALOG_ACTION, "text");
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r62);
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
            Composer r102 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r102, snackbarKt$OneRowSnackbar$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion2.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-643033641);
            Modifier r72 = PaddingKt.m488paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r72);
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
            Composer r63 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r63, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r63, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r63, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r63, viewConfiguration2, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1616738193);
            function23.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
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
            Composer r11 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r11, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density3, companion2.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection3, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r11, viewConfiguration3, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-1690150342);
            function24.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function23, function24, i15));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0117  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Snackbar-7zSek6w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1364Snackbar7zSek6w(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r10 = r38
            r11 = r40
            r12 = r41
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            r1 = r39
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001e
            r2 = r11 | 6
            r3 = r2
            r2 = r29
            goto L_0x0032
        L_0x001e:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r29
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r11
            goto L_0x0032
        L_0x002f:
            r2 = r29
            r3 = r11
        L_0x0032:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r30
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r30
        L_0x004e:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r11 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r31
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r31
        L_0x006a:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0083
            r8 = r12 & 8
            if (r8 != 0) goto L_0x007d
            r8 = r32
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r8 = r32
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r9
            goto L_0x0085
        L_0x0083:
            r8 = r32
        L_0x0085:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x009e
            r9 = r12 & 16
            r13 = r33
            if (r9 != 0) goto L_0x009a
            boolean r9 = r0.changed((long) r13)
            if (r9 == 0) goto L_0x009a
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r9
            goto L_0x00a0
        L_0x009e:
            r13 = r33
        L_0x00a0:
            r9 = 458752(0x70000, float:6.42848E-40)
            r15 = r11 & r9
            if (r15 != 0) goto L_0x00b9
            r15 = r12 & 32
            r9 = r35
            if (r15 != 0) goto L_0x00b5
            boolean r15 = r0.changed((long) r9)
            if (r15 == 0) goto L_0x00b5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r15
            goto L_0x00bb
        L_0x00b9:
            r9 = r35
        L_0x00bb:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c6
            r3 = r3 | r16
            r2 = r37
            goto L_0x00db
        L_0x00c6:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r11 & r17
            r2 = r37
            if (r17 != 0) goto L_0x00db
            boolean r17 = r0.changed((float) r2)
            if (r17 == 0) goto L_0x00d7
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r3 = r3 | r17
        L_0x00db:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e5
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r2
            r10 = r38
            goto L_0x00f8
        L_0x00e5:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r11
            r10 = r38
            if (r2 != 0) goto L_0x00f8
            boolean r2 = r0.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x00f5
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r2 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r3 = r3 | r2
        L_0x00f8:
            r2 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r2 & r3
            r9 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r9) goto L_0x0117
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0108
            goto L_0x0117
        L_0x0108:
            r0.skipToGroupEnd()
            r1 = r29
            r9 = r37
            r2 = r5
            r3 = r7
            r4 = r8
            r5 = r13
            r7 = r35
            goto L_0x01d8
        L_0x0117:
            r0.startDefaults()
            r2 = r11 & 1
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r2 == 0) goto L_0x0148
            boolean r2 = r0.getDefaultsInvalid()
            if (r2 == 0) goto L_0x012b
            goto L_0x0148
        L_0x012b:
            r0.skipToGroupEnd()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0134
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x013a
            r3 = r3 & r17
        L_0x013a:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x013f
            r3 = r3 & r9
        L_0x013f:
            r1 = r29
            r25 = r35
            r4 = r37
            r6 = r3
            r2 = r13
            goto L_0x0198
        L_0x0148:
            if (r1 == 0) goto L_0x014d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x014f
        L_0x014d:
            r1 = r29
        L_0x014f:
            if (r4 == 0) goto L_0x0153
            r2 = 0
            r5 = r2
        L_0x0153:
            if (r6 == 0) goto L_0x0157
            r2 = 0
            r7 = r2
        L_0x0157:
            r2 = r12 & 8
            r4 = 6
            if (r2 == 0) goto L_0x0169
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r0, r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x0169:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0175
            androidx.compose.material.SnackbarDefaults r2 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r13 = r2.getBackgroundColor(r0, r4)
            r3 = r3 & r17
        L_0x0175:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x0187
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r4)
            long r17 = r2.m1183getSurface0d7_KjU()
            r2 = r3 & r9
            r3 = r2
            goto L_0x0189
        L_0x0187:
            r17 = r35
        L_0x0189:
            if (r15 == 0) goto L_0x0192
            float r2 = (float) r4
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
            r4 = r2
            goto L_0x0194
        L_0x0192:
            r4 = r37
        L_0x0194:
            r6 = r3
            r2 = r13
            r25 = r17
        L_0x0198:
            r0.endDefaults()
            r19 = 0
            androidx.compose.material.SnackbarKt$Snackbar$1 r9 = new androidx.compose.material.SnackbarKt$Snackbar$1
            r9.<init>(r5, r10, r6, r7)
            r13 = -2084221700(0xffffffff83c54cfc, float:-1.1596294E-36)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r21 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r13, r14, r9)
            r9 = r6 & 14
            r9 = r9 | r16
            int r13 = r6 >> 6
            r14 = r13 & 112(0x70, float:1.57E-43)
            r9 = r9 | r14
            r14 = r13 & 896(0x380, float:1.256E-42)
            r9 = r9 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r13
            int r6 = r6 >> 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r13
            r23 = r9 | r6
            r24 = 16
            r13 = r1
            r14 = r8
            r15 = r2
            r17 = r25
            r20 = r4
            r22 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24)
            r9 = r4
            r4 = r8
            r27 = r2
            r2 = r5
            r5 = r27
            r3 = r7
            r7 = r25
        L_0x01d8:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01df
            goto L_0x01ee
        L_0x01df:
            androidx.compose.material.SnackbarKt$Snackbar$2 r14 = new androidx.compose.material.SnackbarKt$Snackbar$2
            r0 = r14
            r10 = r38
            r11 = r40
            r12 = r41
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1364Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0114  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Snackbar-sPrSdHI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1365SnackbarsPrSdHI(@org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarData r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, long r37, float r39, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r29
            r12 = r41
            r13 = r42
            java.lang.String r0 = "snackbarData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 258660814(0xf6ad9ce, float:1.15790384E-29)
            r2 = r40
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r12 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002a
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r12
            goto L_0x002b
        L_0x002a:
            r2 = r12
        L_0x002b:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            r4 = r30
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r30
        L_0x0047:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0061
            r6 = r31
            boolean r7 = r0.changed((boolean) r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r31
        L_0x0063:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007c
            r7 = r13 & 8
            if (r7 != 0) goto L_0x0076
            r7 = r32
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0078
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r7 = r32
        L_0x0078:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r8
            goto L_0x007e
        L_0x007c:
            r7 = r32
        L_0x007e:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r12 & r8
            if (r9 != 0) goto L_0x009a
            r9 = r13 & 16
            if (r9 != 0) goto L_0x0094
            r9 = r33
            boolean r11 = r0.changed((long) r9)
            if (r11 == 0) goto L_0x0096
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r9 = r33
        L_0x0096:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r11
            goto L_0x009c
        L_0x009a:
            r9 = r33
        L_0x009c:
            r11 = 458752(0x70000, float:6.42848E-40)
            r14 = r12 & r11
            if (r14 != 0) goto L_0x00b8
            r14 = r13 & 32
            if (r14 != 0) goto L_0x00b1
            r14 = r35
            boolean r16 = r0.changed((long) r14)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b1:
            r14 = r35
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r16
            goto L_0x00ba
        L_0x00b8:
            r14 = r35
        L_0x00ba:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r16
            if (r17 != 0) goto L_0x00d3
            r17 = r13 & 64
            r8 = r37
            if (r17 != 0) goto L_0x00cf
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x00cf
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r2 = r2 | r10
            goto L_0x00d5
        L_0x00d3:
            r8 = r37
        L_0x00d5:
            r10 = r13 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00e0
            r2 = r2 | r17
            r11 = r39
            goto L_0x00f5
        L_0x00e0:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r12 & r18
            r11 = r39
            if (r18 != 0) goto L_0x00f5
            boolean r19 = r0.changed((float) r11)
            if (r19 == 0) goto L_0x00f1
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r2 = r2 | r19
        L_0x00f5:
            r19 = 23967451(0x16db6db, float:4.3661218E-38)
            r4 = r2 & r19
            r6 = 4793490(0x492492, float:6.71711E-39)
            if (r4 != r6) goto L_0x0114
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0106
            goto L_0x0114
        L_0x0106:
            r0.skipToGroupEnd()
            r2 = r30
            r3 = r31
            r5 = r33
            r4 = r7
            r9 = r8
            r7 = r14
            goto L_0x0228
        L_0x0114:
            r0.startDefaults()
            r4 = r12 & 1
            r6 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x0155
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x012b
            goto L_0x0155
        L_0x012b:
            r0.skipToGroupEnd()
            r3 = r13 & 8
            if (r3 == 0) goto L_0x0134
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r3 = r13 & 16
            if (r3 == 0) goto L_0x013a
            r2 = r2 & r20
        L_0x013a:
            r3 = r13 & 32
            if (r3 == 0) goto L_0x0140
            r2 = r2 & r19
        L_0x0140:
            r3 = r13 & 64
            if (r3 == 0) goto L_0x0145
            r2 = r2 & r6
        L_0x0145:
            r3 = r30
            r4 = r31
            r5 = r7
            r6 = r33
            r27 = r14
            r14 = r2
            r2 = r11
            r10 = r8
            r8 = r27
            goto L_0x01b9
        L_0x0155:
            if (r3 == 0) goto L_0x015a
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x015c
        L_0x015a:
            r3 = r30
        L_0x015c:
            if (r5 == 0) goto L_0x0160
            r4 = 0
            goto L_0x0162
        L_0x0160:
            r4 = r31
        L_0x0162:
            r5 = r13 & 8
            r6 = 6
            if (r5 == 0) goto L_0x0174
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r5 = r5.getShapes(r0, r6)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0175
        L_0x0174:
            r5 = r7
        L_0x0175:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0182
            androidx.compose.material.SnackbarDefaults r7 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r22 = r7.getBackgroundColor(r0, r6)
            r2 = r2 & r20
            goto L_0x0184
        L_0x0182:
            r22 = r33
        L_0x0184:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0194
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r0, r6)
            long r14 = r7.m1183getSurface0d7_KjU()
            r2 = r2 & r19
        L_0x0194:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x01a3
            androidx.compose.material.SnackbarDefaults r7 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r7 = r7.getPrimaryActionColor(r0, r6)
            r9 = -3670017(0xffffffffffc7ffff, float:NaN)
            r2 = r2 & r9
            goto L_0x01a4
        L_0x01a3:
            r7 = r8
        L_0x01a4:
            if (r10 == 0) goto L_0x01b0
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            r10 = r7
            r8 = r14
            r14 = r2
            r2 = r6
            goto L_0x01b7
        L_0x01b0:
            r27 = r14
            r14 = r2
            r2 = r11
            r10 = r7
            r8 = r27
        L_0x01b7:
            r6 = r22
        L_0x01b9:
            r0.endDefaults()
            java.lang.String r15 = r29.getActionLabel()
            if (r15 == 0) goto L_0x01dc
            androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1 r12 = new androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
            r30 = r12
            r31 = r10
            r33 = r14
            r34 = r29
            r35 = r15
            r30.<init>(r31, r33, r34, r35)
            r15 = 1843479216(0x6de142b0, float:8.7143434E27)
            r30 = r10
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r10, r12)
            goto L_0x01e0
        L_0x01dc:
            r30 = r10
            r10 = 1
            r11 = 0
        L_0x01e0:
            r15 = r11
            r11 = 12
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r11)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.PaddingKt.m486padding3ABfNKs(r3, r11)
            androidx.compose.material.SnackbarKt$Snackbar$3 r12 = new androidx.compose.material.SnackbarKt$Snackbar$3
            r12.<init>(r1)
            r1 = -261845785(0xfffffffff0648ce7, float:-2.829317E29)
            androidx.compose.runtime.internal.ComposableLambda r23 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r10, r12)
            r1 = r14 & 896(0x380, float:1.256E-42)
            r1 = r1 | r17
            r10 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r10
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r14
            r1 = r1 | r10
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r14
            r1 = r1 | r10
            int r10 = r14 >> 3
            r10 = r10 & r16
            r25 = r1 | r10
            r26 = 0
            r14 = r11
            r16 = r4
            r17 = r5
            r18 = r6
            r20 = r8
            r22 = r2
            r24 = r0
            m1364Snackbar7zSek6w(r14, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26)
            r11 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r7 = r8
            r9 = r30
        L_0x0228:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x022f
            goto L_0x023e
        L_0x022f:
            androidx.compose.material.SnackbarKt$Snackbar$4 r15 = new androidx.compose.material.SnackbarKt$Snackbar$4
            r0 = r15
            r1 = r29
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13)
            r14.updateScope(r15)
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1365SnackbarsPrSdHI(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void TextOnlySnackbar(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(917397959);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            SnackbarKt$TextOnlySnackbar$2 snackbarKt$TextOnlySnackbar$2 = SnackbarKt$TextOnlySnackbar$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, snackbarKt$TextOnlySnackbar$2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion2.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-266728784);
            Modifier r32 = PaddingKt.m487paddingVpY3zN4(companion, HorizontalSpacing, SnackbarVerticalPadding);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r32);
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
            Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration2, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1392363114);
            function2.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$TextOnlySnackbar$3(function2, i11));
        }
    }
}
