package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m5478constructorimpl((float) 20);

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void BackLayerTransition(BackdropValue backdropValue, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        BackdropValue backdropValue2 = backdropValue;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-950970976);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) backdropValue2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        int i17 = i12;
        if ((i17 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (backdropValue2 == BackdropValue.Revealed) {
                f11 = 0.0f;
            } else {
                f11 = 2.0f;
            }
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
            float r62 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).m5447toPx0680j_4(AnimationSlideOffset);
            float f12 = (float) 1;
            float coerceIn = RangesKt___RangesKt.coerceIn(m1092BackLayerTransition$lambda7(animateFloatAsState) - f12, 0.0f, 1.0f);
            float coerceIn2 = RangesKt___RangesKt.coerceIn(f12 - m1092BackLayerTransition$lambda7(animateFloatAsState), 0.0f, 1.0f);
            startRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Composer r02 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r02, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r02, density, companion3.getSetDensity());
            Updater.m2543setimpl(r02, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r02, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(2065804710);
            Modifier r72 = GraphicsLayerModifierKt.m3056graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(companion, coerceIn), 0.0f, 0.0f, coerceIn, 0.0f, (f12 - coerceIn) * r62, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
            Composer r03 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r03, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r03, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r03, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r03, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-1057690836);
            function23.invoke(startRestartGroup, Integer.valueOf((i17 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier r04 = GraphicsLayerModifierKt.m3056graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(companion, coerceIn2), 0.0f, 0.0f, coerceIn2, 0.0f, (f12 - coerceIn2) * (-r62), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r04);
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
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration3, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-676544093);
            function24 = function22;
            function24.invoke(startRestartGroup, Integer.valueOf((i17 >> 6) & 14));
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
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackLayerTransition$2(backdropValue, function23, function24, i11));
        }
    }

    /* renamed from: BackLayerTransition$lambda-7  reason: not valid java name */
    private static final float m1092BackLayerTransition$lambda7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v1, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v2, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v3, resolved type: kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a0, code lost:
        if (r12.changed((java.lang.Object) r8) != false) goto L_0x01a7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0141  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: BackdropScaffold-BZszfkY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1093BackdropScaffoldBZszfkY(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r56, @org.jetbrains.annotations.Nullable androidx.compose.material.BackdropScaffoldState r57, boolean r58, float r59, float r60, boolean r61, boolean r62, long r63, long r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r67, float r68, long r69, long r71, long r73, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r76, int r77, int r78, int r79) {
        /*
            r1 = r53
            r2 = r54
            r0 = r55
            r14 = r77
            r15 = r78
            r13 = r79
            java.lang.String r3 = "appBar"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "backLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = "frontLayerContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 1397420093(0x534af03d, float:8.7161392E11)
            r4 = r76
            androidx.compose.runtime.Composer r12 = r4.startRestartGroup(r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x002b
            r3 = r14 | 6
            goto L_0x003b
        L_0x002b:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x003a
            boolean r3 = r12.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0037
            r3 = 4
            goto L_0x0038
        L_0x0037:
            r3 = 2
        L_0x0038:
            r3 = r3 | r14
            goto L_0x003b
        L_0x003a:
            r3 = r14
        L_0x003b:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0042
            r3 = r3 | 48
            goto L_0x0052
        L_0x0042:
            r6 = r14 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0052
            boolean r6 = r12.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r3 = r3 | r6
        L_0x0052:
            r6 = r13 & 4
            r9 = 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x005b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x005b:
            r6 = r14 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006a
            boolean r6 = r12.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x0067
            r6 = r9
            goto L_0x0069
        L_0x0067:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r3 = r3 | r6
        L_0x006a:
            r6 = r13 & 8
            r16 = 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0073
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0087
            r4 = r56
            boolean r17 = r12.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x0082
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r17 = r16
        L_0x0084:
            r3 = r3 | r17
            goto L_0x0089
        L_0x0087:
            r4 = r56
        L_0x0089:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r14 & r17
            r18 = 8192(0x2000, float:1.14794E-41)
            r19 = 16384(0x4000, float:2.2959E-41)
            if (r17 != 0) goto L_0x00a8
            r17 = r13 & 16
            r5 = r57
            if (r17 != 0) goto L_0x00a3
            boolean r20 = r12.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00a3
            r20 = r19
            goto L_0x00a5
        L_0x00a3:
            r20 = r18
        L_0x00a5:
            r3 = r3 | r20
            goto L_0x00aa
        L_0x00a8:
            r5 = r57
        L_0x00aa:
            r20 = r13 & 32
            r21 = 131072(0x20000, float:1.83671E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r20 == 0) goto L_0x00b9
            r23 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r23
            r11 = r58
            goto L_0x00ce
        L_0x00b9:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r14 & r23
            r11 = r58
            if (r23 != 0) goto L_0x00ce
            boolean r24 = r12.changed((boolean) r11)
            if (r24 == 0) goto L_0x00ca
            r24 = r21
            goto L_0x00cc
        L_0x00ca:
            r24 = r22
        L_0x00cc:
            r3 = r3 | r24
        L_0x00ce:
            r24 = r13 & 64
            if (r24 == 0) goto L_0x00d9
            r25 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r25
            r10 = r59
            goto L_0x00ee
        L_0x00d9:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r14 & r25
            r10 = r59
            if (r25 != 0) goto L_0x00ee
            boolean r26 = r12.changed((float) r10)
            if (r26 == 0) goto L_0x00ea
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r3 = r3 | r26
        L_0x00ee:
            r10 = r13 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00f7
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r26
            goto L_0x010f
        L_0x00f7:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r14 & r26
            if (r26 != 0) goto L_0x010f
            r26 = r10
            r10 = r60
            boolean r27 = r12.changed((float) r10)
            if (r27 == 0) goto L_0x010a
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r3 = r3 | r27
            goto L_0x0113
        L_0x010f:
            r26 = r10
            r10 = r60
        L_0x0113:
            r10 = r13 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x011c
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r27
            goto L_0x0134
        L_0x011c:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r14 & r27
            if (r27 != 0) goto L_0x0134
            r27 = r10
            r10 = r61
            boolean r28 = r12.changed((boolean) r10)
            if (r28 == 0) goto L_0x012f
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0131
        L_0x012f:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0131:
            r3 = r3 | r28
            goto L_0x0138
        L_0x0134:
            r27 = r10
            r10 = r61
        L_0x0138:
            r10 = r13 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0141
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r28
            goto L_0x0159
        L_0x0141:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r14 & r28
            if (r28 != 0) goto L_0x0159
            r28 = r10
            r10 = r62
            boolean r29 = r12.changed((boolean) r10)
            if (r29 == 0) goto L_0x0154
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0156
        L_0x0154:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0156:
            r3 = r3 | r29
            goto L_0x015d
        L_0x0159:
            r28 = r10
            r10 = r62
        L_0x015d:
            r29 = r15 & 14
            if (r29 != 0) goto L_0x0175
            r7 = r13 & 1024(0x400, float:1.435E-42)
            r10 = r63
            if (r7 != 0) goto L_0x0170
            boolean r7 = r12.changed((long) r10)
            if (r7 == 0) goto L_0x0170
            r17 = 4
            goto L_0x0172
        L_0x0170:
            r17 = 2
        L_0x0172:
            r7 = r15 | r17
            goto L_0x0178
        L_0x0175:
            r10 = r63
            r7 = r15
        L_0x0178:
            r17 = r15 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x0190
            r8 = r13 & 2048(0x800, float:2.87E-42)
            r10 = r65
            if (r8 != 0) goto L_0x018b
            boolean r8 = r12.changed((long) r10)
            if (r8 == 0) goto L_0x018b
            r29 = 32
            goto L_0x018d
        L_0x018b:
            r29 = 16
        L_0x018d:
            r7 = r7 | r29
            goto L_0x0192
        L_0x0190:
            r10 = r65
        L_0x0192:
            r8 = r15 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01a9
            r8 = r13 & 4096(0x1000, float:5.74E-42)
            if (r8 != 0) goto L_0x01a3
            r8 = r67
            boolean r17 = r12.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x01a5
            goto L_0x01a7
        L_0x01a3:
            r8 = r67
        L_0x01a5:
            r9 = 128(0x80, float:1.794E-43)
        L_0x01a7:
            r7 = r7 | r9
            goto L_0x01ab
        L_0x01a9:
            r8 = r67
        L_0x01ab:
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01b2
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c6
        L_0x01b2:
            r0 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x01c6
            r0 = r68
            boolean r17 = r12.changed((float) r0)
            if (r17 == 0) goto L_0x01c1
            r23 = 2048(0x800, float:2.87E-42)
            goto L_0x01c3
        L_0x01c1:
            r23 = r16
        L_0x01c3:
            r7 = r7 | r23
            goto L_0x01c8
        L_0x01c6:
            r0 = r68
        L_0x01c8:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x01e0
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            r10 = r69
            if (r0 != 0) goto L_0x01dd
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x01dd
            r18 = r19
        L_0x01dd:
            r7 = r7 | r18
            goto L_0x01e2
        L_0x01e0:
            r10 = r69
        L_0x01e2:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r15
            r16 = 32768(0x8000, float:4.5918E-41)
            if (r0 != 0) goto L_0x01fd
            r0 = r13 & r16
            r10 = r71
            if (r0 != 0) goto L_0x01f9
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x01f9
            r0 = r21
            goto L_0x01fb
        L_0x01f9:
            r0 = r22
        L_0x01fb:
            r7 = r7 | r0
            goto L_0x01ff
        L_0x01fd:
            r10 = r71
        L_0x01ff:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x0217
            r0 = r13 & r22
            r10 = r73
            if (r0 != 0) goto L_0x0213
            boolean r0 = r12.changed((long) r10)
            if (r0 == 0) goto L_0x0213
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0215
        L_0x0213:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x0215:
            r7 = r7 | r0
            goto L_0x0219
        L_0x0217:
            r10 = r73
        L_0x0219:
            r0 = r13 & r21
            if (r0 == 0) goto L_0x0224
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r7 = r7 | r17
            r10 = r75
            goto L_0x0238
        L_0x0224:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            r10 = r75
            if (r17 != 0) goto L_0x0238
            boolean r11 = r12.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0235
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0237
        L_0x0235:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x0237:
            r7 = r7 | r11
        L_0x0238:
            r11 = r7
            r7 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r7 & r3
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r1) goto L_0x0271
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r11
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r7) goto L_0x0271
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x0252
            goto L_0x0271
        L_0x0252:
            r12.skipToGroupEnd()
            r6 = r58
            r7 = r59
            r9 = r61
            r13 = r65
            r16 = r68
            r17 = r69
            r19 = r71
            r21 = r73
            r15 = r8
            r23 = r10
            r1 = r12
            r8 = r60
            r10 = r62
            r11 = r63
            goto L_0x04f0
        L_0x0271:
            r12.startDefaults()
            r1 = r14 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r7 = 6
            r10 = 1
            if (r1 == 0) goto L_0x02d7
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0284
            goto L_0x02d7
        L_0x0284:
            r12.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x028d
            r3 = r3 & r17
        L_0x028d:
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0293
            r11 = r11 & -15
        L_0x0293:
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0299
            r11 = r11 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0299:
            r0 = r13 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x029f
            r11 = r11 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x029f:
            r0 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x02a5
            r11 = r11 & r17
        L_0x02a5:
            r0 = r13 & r16
            if (r0 == 0) goto L_0x02ad
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r11 = r11 & r0
        L_0x02ad:
            r0 = r13 & r22
            if (r0 == 0) goto L_0x02b5
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r11 = r11 & r0
        L_0x02b5:
            r2 = r58
            r10 = r60
            r27 = r61
            r28 = r62
            r30 = r63
            r32 = r65
            r34 = r68
            r35 = r69
            r37 = r71
            r39 = r73
            r41 = r75
            r16 = r3
            r0 = r4
            r1 = r5
            r29 = r8
            r42 = r11
            r11 = r59
            goto L_0x040f
        L_0x02d7:
            if (r6 == 0) goto L_0x02dc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x02dd
        L_0x02dc:
            r1 = r4
        L_0x02dd:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x0305
            androidx.compose.material.BackdropValue r4 = androidx.compose.material.BackdropValue.Concealed
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 6
            r21 = 14
            r7 = r18
            r8 = r12
            r18 = r9
            r9 = r19
            r56 = r1
            r1 = r10
            r19 = r26
            r23 = r27
            r25 = r28
            r10 = r21
            androidx.compose.material.BackdropScaffoldState r4 = rememberBackdropScaffoldState(r4, r5, r6, r7, r8, r9, r10)
            r3 = r3 & r17
            r5 = r4
            goto L_0x0310
        L_0x0305:
            r56 = r1
            r18 = r9
            r1 = r10
            r19 = r26
            r23 = r27
            r25 = r28
        L_0x0310:
            if (r20 == 0) goto L_0x0314
            r4 = r1
            goto L_0x0316
        L_0x0314:
            r4 = r58
        L_0x0316:
            if (r24 == 0) goto L_0x031f
            androidx.compose.material.BackdropScaffoldDefaults r6 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r6 = r6.m1091getPeekHeightD9Ej5fM()
            goto L_0x0321
        L_0x031f:
            r6 = r59
        L_0x0321:
            if (r19 == 0) goto L_0x032a
            androidx.compose.material.BackdropScaffoldDefaults r7 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r7 = r7.m1090getHeaderHeightD9Ej5fM()
            goto L_0x032c
        L_0x032a:
            r7 = r60
        L_0x032c:
            if (r23 == 0) goto L_0x0330
            r8 = r1
            goto L_0x0332
        L_0x0330:
            r8 = r61
        L_0x0332:
            if (r25 == 0) goto L_0x0336
            r9 = r1
            goto L_0x0338
        L_0x0336:
            r9 = r62
        L_0x0338:
            r10 = r13 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0350
            androidx.compose.material.MaterialTheme r10 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Colors r10 = r10.getColors(r12, r1)
            long r19 = r10.m1179getPrimary0d7_KjU()
            r11 = r11 & -15
            r51 = r19
            r19 = r11
            r10 = r51
            goto L_0x0355
        L_0x0350:
            r1 = 6
            r19 = r11
            r10 = r63
        L_0x0355:
            r1 = r13 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0362
            r1 = r19 & 14
            long r20 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r10, r12, r1)
            r19 = r19 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0364
        L_0x0362:
            r20 = r65
        L_0x0364:
            r1 = r19
            r2 = r13 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0376
            androidx.compose.material.BackdropScaffoldDefaults r2 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r57 = r3
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getFrontLayerShape(r12, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x037a
        L_0x0376:
            r57 = r3
            r2 = r67
        L_0x037a:
            if (r18 == 0) goto L_0x0383
            androidx.compose.material.BackdropScaffoldDefaults r3 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            float r3 = r3.m1089getFrontLayerElevationD9Ej5fM()
            goto L_0x0385
        L_0x0383:
            r3 = r68
        L_0x0385:
            r58 = r2
            r2 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x039b
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r59 = r3
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r12, r3)
            long r2 = r2.m1183getSurface0d7_KjU()
            r1 = r1 & r17
            goto L_0x039f
        L_0x039b:
            r59 = r3
            r2 = r69
        L_0x039f:
            r16 = r13 & r16
            if (r16 == 0) goto L_0x03b2
            int r16 = r1 >> 12
            r76 = r4
            r4 = r16 & 14
            long r16 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r2, r12, r4)
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r4
            goto L_0x03b6
        L_0x03b2:
            r76 = r4
            r16 = r71
        L_0x03b6:
            r4 = r13 & r22
            if (r4 == 0) goto L_0x03c8
            androidx.compose.material.BackdropScaffoldDefaults r4 = androidx.compose.material.BackdropScaffoldDefaults.INSTANCE
            r18 = r2
            r2 = 6
            long r3 = r4.getFrontLayerScrimColor(r12, r2)
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r2
            goto L_0x03cc
        L_0x03c8:
            r18 = r2
            r3 = r73
        L_0x03cc:
            if (r0 == 0) goto L_0x03f0
            androidx.compose.material.ComposableSingletons$BackdropScaffoldKt r0 = androidx.compose.material.ComposableSingletons$BackdropScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r0 = r0.m1203getLambda1$material_release()
            r29 = r58
            r34 = r59
            r2 = r76
            r41 = r0
            r42 = r1
            r39 = r3
            r1 = r5
            r27 = r8
            r28 = r9
            r30 = r10
            r37 = r16
            r35 = r18
            r32 = r20
            r0 = r56
            goto L_0x040b
        L_0x03f0:
            r0 = r56
            r29 = r58
            r34 = r59
            r41 = r75
            r2 = r76
            r42 = r1
            r39 = r3
            r1 = r5
            r27 = r8
            r28 = r9
            r30 = r10
            r37 = r16
            r35 = r18
            r32 = r20
        L_0x040b:
            r16 = r57
            r11 = r6
            r10 = r7
        L_0x040f:
            r12.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            float r17 = r3.m5447toPx0680j_4(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            float r7 = r3.m5447toPx0680j_4(r10)
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1 r3 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
            r56 = r3
            r57 = r27
            r58 = r1
            r59 = r53
            r60 = r54
            r61 = r16
            r56.<init>(r57, r58, r59, r60, r61)
            r4 = 1744778315(0x67ff344b, float:2.4103362E24)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r4, r5, r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r4)
            boolean r3 = r12.changed((java.lang.Object) r3)
            java.lang.Object r4 = r12.rememberedValue()
            if (r3 != 0) goto L_0x0463
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x046b
        L_0x0463:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
            r4.<init>(r7)
            r12.updateRememberedValue(r4)
        L_0x046b:
            r12.endReplaceableGroup()
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1 r9 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
            r3 = r9
            r4 = r0
            r5 = r8
            r8 = r28
            r68 = r0
            r0 = r9
            r9 = r2
            r47 = r10
            r10 = r1
            r48 = r11
            r11 = r17
            r69 = r1
            r1 = r12
            r12 = r16
            r13 = r29
            r14 = r35
            r16 = r37
            r18 = r34
            r19 = r42
            r20 = r47
            r21 = r48
            r22 = r55
            r23 = r39
            r25 = r41
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r25)
            r3 = -1049909631(0xffffffffc16ba681, float:-14.72815)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r3, r4, r0)
            r3 = 6
            int r3 = r42 << 6
            r4 = r3 & 896(0x380, float:1.256E-42)
            r5 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r5
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 51
            r56 = r43
            r57 = r44
            r58 = r30
            r60 = r32
            r62 = r45
            r63 = r46
            r64 = r0
            r65 = r1
            r66 = r3
            r67 = r4
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r56, r57, r58, r60, r62, r63, r64, r65, r66, r67)
            r4 = r68
            r5 = r69
            r6 = r2
            r9 = r27
            r10 = r28
            r15 = r29
            r11 = r30
            r13 = r32
            r16 = r34
            r17 = r35
            r19 = r37
            r21 = r39
            r23 = r41
            r8 = r47
            r7 = r48
        L_0x04f0:
            androidx.compose.runtime.ScopeUpdateScope r3 = r1.endRestartGroup()
            if (r3 != 0) goto L_0x04f7
            goto L_0x0514
        L_0x04f7:
            androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2 r2 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
            r0 = r2
            r1 = r53
            r49 = r2
            r2 = r54
            r50 = r3
            r3 = r55
            r24 = r77
            r25 = r78
            r26 = r79
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r19, r21, r23, r24, r25, r26)
            r1 = r49
            r0 = r50
            r0.updateScope(r1)
        L_0x0514:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m1093BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    @UiComposable
    public static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1248995194);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function1)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function4)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if ((i12 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed((Object) function2) | startRestartGroup.changed((Object) function1) | startRestartGroup.changed((Object) function4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BackdropScaffoldKt$BackdropStack$1$1(function2, function1, function4, i12);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, i12 & 14, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$BackdropStack$2(modifier, function2, function1, function4, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1094Scrim3JVO9M(long j11, Function0<Unit> function0, boolean z11, Composer composer, int i11) {
        int i12;
        boolean z12;
        float f11;
        Modifier modifier;
        int i13;
        int i14;
        int i15;
        long j12 = j11;
        Function0<Unit> function02 = function0;
        boolean z13 = z11;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-92141505);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed(j12)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(z13)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (j12 != Color.Companion.m2955getUnspecified0d7_KjU()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (z13) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
                startRestartGroup.startReplaceableGroup(1010547004);
                if (z13) {
                    Modifier.Companion companion = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function02, (Continuation<? super BackdropScaffoldKt$Scrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                Color r82 = Color.m2909boximpl(j11);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed2 = startRestartGroup.changed((Object) r82) | startRestartGroup.changed((Object) animateFloatAsState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new BackdropScaffoldKt$Scrim$1$1(j12, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(j11, function0, z11, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-4  reason: not valid java name */
    public static final float m1095Scrim_3J_VO9M$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final BackdropScaffoldState rememberBackdropScaffoldState(@NotNull BackdropValue backdropValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super BackdropValue, Boolean> function1, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(backdropValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        SpringSpec<Float> springSpec = animationSpec;
        if ((i12 & 2) != 0) {
            springSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        BackdropScaffoldKt$rememberBackdropScaffoldState$1 backdropScaffoldKt$rememberBackdropScaffoldState$1 = function1;
        if ((i12 & 4) != 0) {
            backdropScaffoldKt$rememberBackdropScaffoldState$1 = BackdropScaffoldKt$rememberBackdropScaffoldState$1.INSTANCE;
        }
        if ((i12 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(new Object[]{springSpec, backdropScaffoldKt$rememberBackdropScaffoldState$1, snackbarHostState}, BackdropScaffoldState.Companion.Saver(springSpec, backdropScaffoldKt$rememberBackdropScaffoldState$1, snackbarHostState), (String) null, new BackdropScaffoldKt$rememberBackdropScaffoldState$3(backdropValue, springSpec, backdropScaffoldKt$rememberBackdropScaffoldState$1, snackbarHostState), composer, 72, 4);
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }
}
