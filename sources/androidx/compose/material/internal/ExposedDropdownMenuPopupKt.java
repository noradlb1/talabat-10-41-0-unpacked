package androidx.compose.material.internal;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt {
    @NotNull
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, ExposedDropdownMenuPopupKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: androidx.compose.material.internal.PopupLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: androidx.compose.material.internal.PopupLayout} */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuPopup(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r21, @org.jetbrains.annotations.NotNull androidx.compose.ui.window.PopupPositionProvider r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r22
            r8 = r23
            r9 = r25
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -841446797(0xffffffffcdd88a73, float:-4.54119008E8)
            r1 = r24
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r0 = r26 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r9 | 6
            r2 = r1
            r1 = r21
            goto L_0x0037
        L_0x0023:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r21
            boolean r2 = r6.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r9
            goto L_0x0037
        L_0x0034:
            r1 = r21
            r2 = r9
        L_0x0037:
            r3 = r26 & 2
            if (r3 == 0) goto L_0x003e
            r2 = r2 | 48
            goto L_0x004e
        L_0x003e:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004e
            boolean r3 = r6.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r2 = r2 | r3
        L_0x004e:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0055:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r6.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0062
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r3
        L_0x0065:
            r5 = r2
            r2 = r5 & 731(0x2db, float:1.024E-42)
            r3 = 146(0x92, float:2.05E-43)
            if (r2 != r3) goto L_0x0079
            boolean r2 = r6.getSkipping()
            if (r2 != 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            r6.skipToGroupEnd()
            r12 = r6
            goto L_0x01e4
        L_0x0079:
            if (r0 == 0) goto L_0x007e
            r0 = 0
            r4 = r0
            goto L_0x007f
        L_0x007e:
            r4 = r1
        L_0x007f:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r0 = r6.consume(r0)
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r6.consume(r0)
            r17 = r0
            androidx.compose.ui.unit.Density r17 = (androidx.compose.ui.unit.Density) r17
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            java.lang.Object r0 = r6.consume(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r0 = r6.consume(r0)
            r1 = r0
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            r0 = 0
            androidx.compose.runtime.CompositionContext r15 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r0)
            int r10 = r5 >> 6
            r10 = r10 & 14
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r10)
            java.lang.Object[] r10 = new java.lang.Object[r0]
            r11 = 0
            r12 = 0
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1 r13 = androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE
            r16 = 3080(0xc08, float:4.316E-42)
            r18 = 6
            r19 = r14
            r14 = r6
            r20 = r15
            r15 = r16
            r16 = r18
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r11)
            java.lang.Object r11 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r11 != r12) goto L_0x0112
            androidx.compose.material.internal.PopupLayout r11 = new androidx.compose.material.internal.PopupLayout
            java.lang.String r12 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            r12 = r0
            r0 = r11
            r13 = r1
            r1 = r4
            r14 = r2
            r15 = r4
            r4 = r17
            r16 = r5
            r5 = r22
            r12 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
            r1 = r19
            r0.<init>(r11, r1)
            r1 = 144472904(0x89c7b48, float:9.417892E-34)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            r1 = r20
            r11.setContent(r1, r0)
            r12.updateRememberedValue(r11)
            goto L_0x0118
        L_0x0112:
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r5
            r12 = r6
        L_0x0118:
            r12.endReplaceableGroup()
            androidx.compose.material.internal.PopupLayout r11 = (androidx.compose.material.internal.PopupLayout) r11
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1
            r0.<init>(r11, r15, r14, r13)
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r12, (int) r1)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2
            r0.<init>(r11, r15, r14, r13)
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r12, r1)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3
            r0.<init>(r11, r7)
            int r1 = r16 >> 3
            r1 = r1 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r12, (int) r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5
            r1.<init>(r11)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r1)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6
            r1.<init>(r11, r13)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r12.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r12.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r4 = r12.consume(r4)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r10 = r12.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0185
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0185:
            r12.startReusableNode()
            boolean r10 = r12.getInserting()
            if (r10 == 0) goto L_0x0192
            r12.createNode(r6)
            goto L_0x0195
        L_0x0192:
            r12.useNode()
        L_0x0195:
            r12.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2536constructorimpl(r12)
            kotlin.jvm.functions.Function2 r10 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r1, r10)
            kotlin.jvm.functions.Function2 r1 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r3, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            r12.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r12, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            r0 = -261830998(0xfffffffff064c6aa, float:-2.83211E29)
            r12.startReplaceableGroup(r0)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r1 = r15
        L_0x01e4:
            androidx.compose.runtime.ScopeUpdateScope r6 = r12.endRestartGroup()
            if (r6 != 0) goto L_0x01eb
            goto L_0x01fc
        L_0x01eb:
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7 r10 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7
            r0 = r10
            r2 = r22
            r3 = r23
            r4 = r25
            r5 = r26
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r10)
        L_0x01fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuPopup$lambda-0  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m1465ExposedDropdownMenuPopup$lambda0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        composer.startReplaceableGroup(1769324208);
        ExposedDropdownMenuPopupKt$SimpleStack$1 exposedDropdownMenuPopupKt$SimpleStack$1 = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i12 = (((((i11 << 3) & 112) | ((i11 >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r52 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r52, exposedDropdownMenuPopupKt$SimpleStack$1, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r52, density, companion.getSetDensity());
        Updater.m2543setimpl(r52, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r52, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i12 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }
}
