package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AccessibilityManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material/SnackbarHostState;", "snackbar", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FadeInFadeOutWithScale(androidx.compose.material.SnackbarData r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r18
            r3 = r20
            r4 = r22
            r0 = 2036134589(0x795cf2bd, float:7.170179E34)
            r2 = r21
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r23 & 1
            if (r2 == 0) goto L_0x0016
            r2 = r4 | 6
            goto L_0x0026
        L_0x0016:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0025
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0022
            r2 = 4
            goto L_0x0023
        L_0x0022:
            r2 = 2
        L_0x0023:
            r2 = r2 | r4
            goto L_0x0026
        L_0x0025:
            r2 = r4
        L_0x0026:
            r6 = r23 & 2
            if (r6 == 0) goto L_0x002d
            r2 = r2 | 48
            goto L_0x0040
        L_0x002d:
            r8 = r4 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0040
            r8 = r19
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x003c
            r9 = 32
            goto L_0x003e
        L_0x003c:
            r9 = 16
        L_0x003e:
            r2 = r2 | r9
            goto L_0x0042
        L_0x0040:
            r8 = r19
        L_0x0042:
            r9 = r23 & 4
            if (r9 == 0) goto L_0x0049
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0059
        L_0x0049:
            r9 = r4 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0059
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0056
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r2 = r2 | r9
        L_0x0059:
            r9 = r2 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x006c
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            r0.skipToGroupEnd()
            r2 = r8
            goto L_0x0251
        L_0x006c:
            if (r6 == 0) goto L_0x0071
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            goto L_0x0072
        L_0x0071:
            r6 = r8
        L_0x0072:
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r8)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x008c
            androidx.compose.material.FadeInFadeOutState r8 = new androidx.compose.material.FadeInFadeOutState
            r8.<init>()
            r0.updateRememberedValue(r8)
        L_0x008c:
            r0.endReplaceableGroup()
            androidx.compose.material.FadeInFadeOutState r8 = (androidx.compose.material.FadeInFadeOutState) r8
            java.lang.Object r9 = r8.getCurrent()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            r10 = 1
            if (r9 != 0) goto L_0x0112
            r8.setCurrent(r1)
            java.util.List r9 = r8.getItems()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r9, r12)
            r11.<init>(r12)
            java.util.Iterator r9 = r9.iterator()
        L_0x00b4:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x00ca
            java.lang.Object r12 = r9.next()
            androidx.compose.material.FadeInFadeOutAnimationItem r12 = (androidx.compose.material.FadeInFadeOutAnimationItem) r12
            java.lang.Object r12 = r12.getKey()
            androidx.compose.material.SnackbarData r12 = (androidx.compose.material.SnackbarData) r12
            r11.add(r12)
            goto L_0x00b4
        L_0x00ca:
            java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r11)
            boolean r11 = r9.contains(r1)
            if (r11 != 0) goto L_0x00d7
            r9.add(r1)
        L_0x00d7:
            java.util.List r11 = r8.getItems()
            r11.clear()
            r11 = r9
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r12 = r8.getItems()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x00f1:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0112
            java.lang.Object r13 = r11.next()
            androidx.compose.material.SnackbarData r13 = (androidx.compose.material.SnackbarData) r13
            androidx.compose.material.FadeInFadeOutAnimationItem r14 = new androidx.compose.material.FadeInFadeOutAnimationItem
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1 r15 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1
            r15.<init>(r13, r1, r9, r8)
            r7 = -94104314(0xfffffffffa641506, float:-2.9606752E35)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r10, r15)
            r14.<init>(r13, r7)
            r12.add(r14)
            goto L_0x00f1
        L_0x0112:
            int r7 = r2 >> 3
            r7 = r7 & 14
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            int r11 = r7 >> 3
            r12 = r11 & 14
            r11 = r11 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r12, r0, r11)
            int r11 = r7 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.platform.ViewConfiguration r15 = (androidx.compose.ui.platform.ViewConfiguration) r15
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            int r11 = r11 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r17 = 6
            r11 = r11 | 6
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0173
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0173:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x0180
            r0.createNode(r10)
            goto L_0x0183
        L_0x0180:
            r0.useNode()
        L_0x0183:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r10 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r9, r10)
            kotlin.jvm.functions.Function2 r9 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r13, r9)
            kotlin.jvm.functions.Function2 r9 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r14, r9)
            kotlin.jvm.functions.Function2 r9 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r15, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r5)
            int r9 = r11 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r12.invoke(r5, r0, r9)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            int r5 = r11 >> 9
            r5 = r5 & 14
            r9 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r9)
            r5 = r5 & 11
            r9 = 2
            if (r5 != r9) goto L_0x01dc
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x01d8
            goto L_0x01dc
        L_0x01d8:
            r0.skipToGroupEnd()
            goto L_0x0241
        L_0x01dc:
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r5 = r7 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 6
            r7 = -1788016521(0xffffffff956d0877, float:-4.7868446E-26)
            r0.startReplaceableGroup(r7)
            r5 = r5 & 81
            r7 = 16
            if (r5 != r7) goto L_0x01fb
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x01f7
            goto L_0x01fb
        L_0x01f7:
            r0.skipToGroupEnd()
            goto L_0x023e
        L_0x01fb:
            r5 = 0
            androidx.compose.runtime.RecomposeScope r7 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r0, r5)
            r8.setScope(r7)
            java.util.List r7 = r8.getItems()
            int r8 = r7.size()
            r12 = r5
        L_0x020c:
            if (r12 >= r8) goto L_0x023e
            java.lang.Object r5 = r7.get(r12)
            androidx.compose.material.FadeInFadeOutAnimationItem r5 = (androidx.compose.material.FadeInFadeOutAnimationItem) r5
            java.lang.Object r9 = r5.component1()
            androidx.compose.material.SnackbarData r9 = (androidx.compose.material.SnackbarData) r9
            kotlin.jvm.functions.Function3 r5 = r5.component2()
            r10 = -208579897(0xfffffffff39152c7, float:-2.3027404E31)
            r0.startMovableGroup(r10, r9)
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 r10 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
            r10.<init>(r3, r9, r2)
            r9 = 2041982076(0x79b62c7c, float:1.1823753E35)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r11, r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r17)
            r5.invoke(r9, r0, r10)
            r0.endMovableGroup()
            int r12 = r12 + 1
            goto L_0x020c
        L_0x023e:
            r0.endReplaceableGroup()
        L_0x0241:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r6
        L_0x0251:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0258
            goto L_0x0269
        L_0x0258:
            androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3 r7 = new androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3
            r0 = r7
            r1 = r18
            r3 = r20
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.FadeInFadeOutWithScale(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SnackbarHost(@org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarHostState r12, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r14, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r1 = r12
            r4 = r16
            java.lang.String r0 = "hostState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 431012348(0x19b0b9fc, float:1.8273092E-23)
            r2 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            r2 = r17 & 1
            if (r2 == 0) goto L_0x0017
            r2 = r4 | 6
            goto L_0x0027
        L_0x0017:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0026
            boolean r2 = r0.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0024
        L_0x0023:
            r2 = 2
        L_0x0024:
            r2 = r2 | r4
            goto L_0x0027
        L_0x0026:
            r2 = r4
        L_0x0027:
            r3 = r17 & 2
            if (r3 == 0) goto L_0x002e
            r2 = r2 | 48
            goto L_0x0040
        L_0x002e:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0040
            r5 = r13
            boolean r6 = r0.changed((java.lang.Object) r13)
            if (r6 == 0) goto L_0x003c
            r6 = 32
            goto L_0x003e
        L_0x003c:
            r6 = 16
        L_0x003e:
            r2 = r2 | r6
            goto L_0x0041
        L_0x0040:
            r5 = r13
        L_0x0041:
            r6 = r17 & 4
            if (r6 == 0) goto L_0x0048
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005a
        L_0x0048:
            r7 = r4 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005a
            r7 = r14
            boolean r8 = r0.changed((java.lang.Object) r14)
            if (r8 == 0) goto L_0x0056
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r2 = r2 | r8
            goto L_0x005b
        L_0x005a:
            r7 = r14
        L_0x005b:
            r8 = r2 & 731(0x2db, float:1.024E-42)
            r9 = 146(0x92, float:2.05E-43)
            if (r8 != r9) goto L_0x006e
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0068
            goto L_0x006e
        L_0x0068:
            r0.skipToGroupEnd()
            r2 = r5
            r3 = r7
            goto L_0x00aa
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0074
        L_0x0073:
            r3 = r5
        L_0x0074:
            if (r6 == 0) goto L_0x007e
            androidx.compose.material.ComposableSingletons$SnackbarHostKt r5 = androidx.compose.material.ComposableSingletons$SnackbarHostKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1209getLambda1$material_release()
            r11 = r5
            goto L_0x007f
        L_0x007e:
            r11 = r7
        L_0x007f:
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalAccessibilityManager()
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.ui.platform.AccessibilityManager r6 = (androidx.compose.ui.platform.AccessibilityManager) r6
            androidx.compose.material.SnackbarHostKt$SnackbarHost$1 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$1
            r8 = 0
            r7.<init>(r5, r6, r8)
            r6 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r5, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r0, (int) r6)
            androidx.compose.material.SnackbarData r5 = r12.getCurrentSnackbarData()
            r6 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 & 896(0x380, float:1.256E-42)
            r9 = r6 | r2
            r10 = 0
            r6 = r3
            r7 = r11
            r8 = r0
            FadeInFadeOutWithScale(r5, r6, r7, r8, r9, r10)
            r2 = r3
            r3 = r11
        L_0x00aa:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00b1
            goto L_0x00bf
        L_0x00b1:
            androidx.compose.material.SnackbarHostKt$SnackbarHost$2 r7 = new androidx.compose.material.SnackbarHostKt$SnackbarHost$2
            r0 = r7
            r1 = r12
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.SnackbarHost(androidx.compose.material.SnackbarHostState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z11, Function0<Unit> function0, Composer composer, int i11, int i12) {
        float f11;
        composer.startReplaceableGroup(1016418159);
        if ((i12 & 4) != 0) {
            function0 = SnackbarHostKt$animatedOpacity$1.INSTANCE;
        }
        Function0<Unit> function02 = function0;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            if (!z11) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            rememberedValue = AnimatableKt.Animatable$default(f11, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z11), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedOpacity$2(animatable, z11, animationSpec, function02, (Continuation<? super SnackbarHostKt$animatedOpacity$2>) null), composer, (i11 >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z11, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(2003504988);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            if (!z11) {
                f11 = 1.0f;
            } else {
                f11 = 0.8f;
            }
            rememberedValue = AnimatableKt.Animatable$default(f11, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z11), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnackbarHostKt$animatedScale$1(animatable, z11, animationSpec, (Continuation<? super SnackbarHostKt$animatedScale$1>) null), composer, (i11 >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    public static final long toMillis(@NotNull SnackbarDuration snackbarDuration, boolean z11, @Nullable AccessibilityManager accessibilityManager) {
        long j11;
        Intrinsics.checkNotNullParameter(snackbarDuration, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i11 == 1) {
            j11 = Long.MAX_VALUE;
        } else if (i11 == 2) {
            j11 = 10000;
        } else if (i11 == 3) {
            j11 = 4000;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        long j12 = j11;
        if (accessibilityManager == null) {
            return j12;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(j12, true, true, z11);
    }
}
