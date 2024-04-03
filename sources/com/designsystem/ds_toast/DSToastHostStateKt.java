package com.designsystem.ds_toast;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u000e\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a\u001a\u0010\u001b\u001a\u00020\u0005*\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0000*b\b\u0002\u0010\u001d\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b¨\u0006 "}, d2 = {"FadeInFadeOutWithScale", "", "current", "Lcom/designsystem/ds_toast/DSToastHostState$ToastData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Lcom/designsystem/ds_toast/DSToastHostState$ToastData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ToastHost", "hostState", "Lcom/designsystem/ds_toast/DSToastHostState;", "toast", "(Lcom/designsystem/ds_toast/DSToastHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOffset", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animatedOpacity", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "swipeToDismiss", "onDismissed", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FadeInFadeOutWithScale(com.designsystem.ds_toast.DSToastHostState.ToastData r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function3<? super com.designsystem.ds_toast.DSToastHostState.ToastData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r16
            r3 = r18
            r4 = r20
            r0 = 1076138273(0x40249121, float:2.571358)
            r2 = r19
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r21 & 1
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
            r6 = r21 & 2
            if (r6 == 0) goto L_0x002d
            r2 = r2 | 48
            goto L_0x0040
        L_0x002d:
            r8 = r4 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0040
            r8 = r17
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
            r8 = r17
        L_0x0042:
            r9 = r21 & 4
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
            r9 = r9 ^ 146(0x92, float:2.05E-43)
            if (r9 != 0) goto L_0x006c
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            r0.skipToGroupEnd()
            r2 = r8
            goto L_0x0237
        L_0x006c:
            if (r6 == 0) goto L_0x0071
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            goto L_0x0072
        L_0x0071:
            r6 = r8
        L_0x0072:
            r8 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r8)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x008c
            com.designsystem.ds_toast.FadeInFadeOutState r8 = new com.designsystem.ds_toast.FadeInFadeOutState
            r8.<init>()
            r0.updateRememberedValue(r8)
        L_0x008c:
            r0.endReplaceableGroup()
            com.designsystem.ds_toast.FadeInFadeOutState r8 = (com.designsystem.ds_toast.FadeInFadeOutState) r8
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
            com.designsystem.ds_toast.FadeInFadeOutAnimationItem r12 = (com.designsystem.ds_toast.FadeInFadeOutAnimationItem) r12
            java.lang.Object r12 = r12.getKey()
            com.designsystem.ds_toast.DSToastHostState$ToastData r12 = (com.designsystem.ds_toast.DSToastHostState.ToastData) r12
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
            com.designsystem.ds_toast.DSToastHostState$ToastData r13 = (com.designsystem.ds_toast.DSToastHostState.ToastData) r13
            com.designsystem.ds_toast.FadeInFadeOutAnimationItem r14 = new com.designsystem.ds_toast.FadeInFadeOutAnimationItem
            com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$1$1 r15 = new com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$1$1
            r15.<init>(r13, r1, r9, r8)
            r7 = -985538144(0xffffffffc541e1a0, float:-3102.1016)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r7, r10, r15)
            r14.<init>(r13, r7)
            r12.add(r14)
            goto L_0x00f1
        L_0x0112:
            int r7 = r2 >> 3
            r7 = r7 & 14
            r9 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
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
            r13 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            int r11 = r11 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0165
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0165:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x0172
            r0.createNode(r10)
            goto L_0x0175
        L_0x0172:
            r0.useNode()
        L_0x0175:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r10 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r9, r10)
            kotlin.jvm.functions.Function2 r9 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r13, r9)
            kotlin.jvm.functions.Function2 r9 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r14, r9)
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
            r9 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r9)
            r5 = r5 & 11
            r9 = 2
            r5 = r5 ^ r9
            if (r5 != 0) goto L_0x01c8
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x01c4
            goto L_0x01c8
        L_0x01c4:
            r0.skipToGroupEnd()
            goto L_0x0227
        L_0x01c8:
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r5 = 6
            int r7 = r7 >> r5
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r5
            r7 = r7 & 81
            r9 = 16
            r7 = r7 ^ r9
            if (r7 != 0) goto L_0x01e1
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L_0x01dd
            goto L_0x01e1
        L_0x01dd:
            r0.skipToGroupEnd()
            goto L_0x0227
        L_0x01e1:
            r7 = 0
            androidx.compose.runtime.RecomposeScope r7 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r0, r7)
            r8.setScope(r7)
            java.util.List r7 = r8.getItems()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x01f3:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0227
            java.lang.Object r8 = r7.next()
            com.designsystem.ds_toast.FadeInFadeOutAnimationItem r8 = (com.designsystem.ds_toast.FadeInFadeOutAnimationItem) r8
            java.lang.Object r9 = r8.component1()
            com.designsystem.ds_toast.DSToastHostState$ToastData r9 = (com.designsystem.ds_toast.DSToastHostState.ToastData) r9
            kotlin.jvm.functions.Function3 r8 = r8.component2()
            r10 = 1504114705(0x59a6f811, float:5.8746998E15)
            r0.startMovableGroup(r10, r9)
            com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$2$1$1 r10 = new com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$2$1$1
            r10.<init>(r3, r9, r2)
            r9 = -819888537(0xffffffffcf217e67, float:-2.70941568E9)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r11, r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            r8.invoke(r9, r0, r10)
            r0.endMovableGroup()
            goto L_0x01f3
        L_0x0227:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r6
        L_0x0237:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x023e
            goto L_0x024f
        L_0x023e:
            com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$3 r7 = new com.designsystem.ds_toast.DSToastHostStateKt$FadeInFadeOutWithScale$3
            r0 = r7
            r1 = r16
            r3 = r18
            r4 = r20
            r5 = r21
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x024f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.DSToastHostStateKt.FadeInFadeOutWithScale(com.designsystem.ds_toast.DSToastHostState$ToastData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ToastHost(@org.jetbrains.annotations.NotNull com.designsystem.ds_toast.DSToastHostState r11, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super com.designsystem.ds_toast.DSToastHostState.ToastData, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r13, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15, int r16) {
        /*
            r1 = r11
            r8 = r13
            r9 = r15
            java.lang.String r0 = "hostState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "toast"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1430309407(0xffffffffaabf35e1, float:-3.3965802E-13)
            r2 = r14
            androidx.compose.runtime.Composer r0 = r14.startRestartGroup(r0)
            r2 = r16 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r9 | 6
            goto L_0x002c
        L_0x001c:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r0.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r9
            goto L_0x002c
        L_0x002b:
            r2 = r9
        L_0x002c:
            r3 = r16 & 2
            if (r3 == 0) goto L_0x0033
            r2 = r2 | 48
            goto L_0x0045
        L_0x0033:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            r4 = r12
            boolean r5 = r0.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0046
        L_0x0045:
            r4 = r12
        L_0x0046:
            r5 = r16 & 4
            if (r5 == 0) goto L_0x004d
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004d:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005d
            boolean r5 = r0.changed((java.lang.Object) r13)
            if (r5 == 0) goto L_0x005a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r2 = r2 | r5
        L_0x005d:
            r5 = r2 & 731(0x2db, float:1.024E-42)
            r5 = r5 ^ 146(0x92, float:2.05E-43)
            if (r5 != 0) goto L_0x006f
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x006a
            goto L_0x006f
        L_0x006a:
            r0.skipToGroupEnd()
            r2 = r4
            goto L_0x00b7
        L_0x006f:
            if (r3 == 0) goto L_0x0075
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r10 = r3
            goto L_0x0076
        L_0x0075:
            r10 = r4
        L_0x0076:
            com.designsystem.ds_toast.DSToastHostState$ToastData r3 = r11.getCurrentToastData$marshmallow_release()
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r4)
            boolean r4 = r0.changed((java.lang.Object) r3)
            java.lang.Object r5 = r0.rememberedValue()
            if (r4 != 0) goto L_0x0092
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x009b
        L_0x0092:
            com.designsystem.ds_toast.DSToastHostStateKt$ToastHost$1$1 r5 = new com.designsystem.ds_toast.DSToastHostStateKt$ToastHost$1$1
            r4 = 0
            r5.<init>(r3, r4)
            r0.updateRememberedValue(r5)
        L_0x009b:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r4 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5, (androidx.compose.runtime.Composer) r0, (int) r4)
            com.designsystem.ds_toast.DSToastHostState$ToastData r3 = r11.getCurrentToastData$marshmallow_release()
            r4 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 & 896(0x380, float:1.256E-42)
            r6 = r4 | r2
            r7 = 0
            r2 = r3
            r3 = r10
            r4 = r13
            r5 = r0
            FadeInFadeOutWithScale(r2, r3, r4, r5, r6, r7)
            r2 = r10
        L_0x00b7:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00be
            goto L_0x00cc
        L_0x00be:
            com.designsystem.ds_toast.DSToastHostStateKt$ToastHost$2 r7 = new com.designsystem.ds_toast.DSToastHostStateKt$ToastHost$2
            r0 = r7
            r1 = r11
            r3 = r13
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.DSToastHostStateKt.ToastHost(com.designsystem.ds_toast.DSToastHostState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedOffset(AnimationSpec<Float> animationSpec, boolean z11, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(1249854655);
        composer.startReplaceableGroup(1249854763);
        float f12 = -((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).m5447toPx0680j_4(DSTheme.INSTANCE.getDimens(composer, 0).m8842getDsSD9Ej5fM());
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            if (!z11) {
                f11 = 0.0f;
            } else {
                f11 = f12;
            }
            rememberedValue = AnimatableKt.Animatable$default(f11, 0.0f, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z11), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new DSToastHostStateKt$animatedOffset$1(animatable, z11, f12, animationSpec, (Continuation<? super DSToastHostStateKt$animatedOffset$1>) null), composer, (i11 >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z11, Function0<Unit> function0, Composer composer, int i11, int i12) {
        float f11;
        composer.startReplaceableGroup(217869736);
        if ((i12 & 4) != 0) {
            function0 = DSToastHostStateKt$animatedOpacity$1.INSTANCE;
        }
        Function0<Unit> function02 = function0;
        composer.startReplaceableGroup(-3687241);
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
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z11), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new DSToastHostStateKt$animatedOpacity$2(animatable, z11, animationSpec, function02, (Continuation<? super DSToastHostStateKt$animatedOpacity$2>) null), composer, (i11 >> 3) & 14);
        State<Float> asState = animatable.asState();
        composer.endReplaceableGroup();
        return asState;
    }

    @NotNull
    public static final Modifier swipeToDismiss(@NotNull Modifier modifier, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onDismissed");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new DSToastHostStateKt$swipeToDismiss$1(function0), 1, (Object) null);
    }
}
