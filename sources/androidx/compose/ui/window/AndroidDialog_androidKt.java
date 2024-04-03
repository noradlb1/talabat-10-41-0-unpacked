package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
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

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0088, code lost:
        if ((r24 & 2) != 0) goto L_0x009a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015d  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Dialog(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.DialogProperties r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r19
            r8 = r21
            r9 = r23
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -2032877254(0xffffffff86d4c13a, float:-8.002946E-35)
            r1 = r22
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x0020
            r1 = r9 | 6
            goto L_0x0030
        L_0x0020:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002f
            boolean r1 = r6.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x002c
            r1 = 4
            goto L_0x002d
        L_0x002c:
            r1 = 2
        L_0x002d:
            r1 = r1 | r9
            goto L_0x0030
        L_0x002f:
            r1 = r9
        L_0x0030:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0049
            r2 = r24 & 2
            if (r2 != 0) goto L_0x0043
            r2 = r20
            boolean r3 = r6.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0045
            r3 = 32
            goto L_0x0047
        L_0x0043:
            r2 = r20
        L_0x0045:
            r3 = 16
        L_0x0047:
            r1 = r1 | r3
            goto L_0x004b
        L_0x0049:
            r2 = r20
        L_0x004b:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x0052:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0062
            boolean r3 = r6.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x005f
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r3
        L_0x0062:
            r3 = r1 & 731(0x2db, float:1.024E-42)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L_0x0075
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            r6.skipToGroupEnd()
            r15 = r6
            goto L_0x0161
        L_0x0075:
            r6.startDefaults()
            r3 = r9 & 1
            if (r3 == 0) goto L_0x008b
            boolean r3 = r6.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0083
            goto L_0x008b
        L_0x0083:
            r6.skipToGroupEnd()
            r3 = r24 & 2
            if (r3 == 0) goto L_0x009c
            goto L_0x009a
        L_0x008b:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x009c
            androidx.compose.ui.window.DialogProperties r2 = new androidx.compose.ui.window.DialogProperties
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            r10 = r2
            r10.<init>((boolean) r11, (boolean) r12, (androidx.compose.ui.window.SecureFlagPolicy) r13, (int) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
        L_0x009a:
            r1 = r1 & -113(0xffffffffffffff8f, float:NaN)
        L_0x009c:
            r5 = r2
            r6.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ac
            r2 = -1
            java.lang.String r3 = "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:154)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00ac:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r0 = r6.consume(r0)
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r6.consume(r0)
            r4 = r0
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r0 = r6.consume(r0)
            r2 = r0
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            r0 = 0
            androidx.compose.runtime.CompositionContext r15 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r0)
            int r1 = r1 >> 6
            r1 = r1 & 14
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r1)
            java.lang.Object[] r10 = new java.lang.Object[r0]
            r11 = 0
            r12 = 0
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1 r13 = androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r14 = r6
            r18 = r15
            r15 = r16
            r16 = r17
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r11)
            boolean r11 = r6.changed((java.lang.Object) r3)
            boolean r12 = r6.changed((java.lang.Object) r4)
            r11 = r11 | r12
            java.lang.Object r12 = r6.rememberedValue()
            if (r11 != 0) goto L_0x0113
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x010f
            goto L_0x0113
        L_0x010f:
            r14 = r2
            r11 = r5
            r15 = r6
            goto L_0x013f
        L_0x0113:
            androidx.compose.ui.window.DialogWrapper r12 = new androidx.compose.ui.window.DialogWrapper
            java.lang.String r11 = "dialogId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r11 = r0
            r0 = r12
            r13 = r1
            r1 = r19
            r14 = r2
            r2 = r5
            r15 = r4
            r4 = r14
            r11 = r5
            r5 = r15
            r15 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            r0.<init>(r13)
            r1 = 488261145(0x1d1a4619, float:2.041797E-21)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            r1 = r18
            r12.setContent(r1, r0)
            r15.updateRememberedValue(r12)
        L_0x013f:
            r15.endReplaceableGroup()
            androidx.compose.ui.window.DialogWrapper r12 = (androidx.compose.ui.window.DialogWrapper) r12
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1
            r0.<init>(r12)
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2
            r0.<init>(r12, r7, r11, r14)
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r15, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0160
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0160:
            r2 = r11
        L_0x0161:
            androidx.compose.runtime.ScopeUpdateScope r6 = r15.endRestartGroup()
            if (r6 != 0) goto L_0x0168
            goto L_0x0179
        L_0x0168:
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3 r10 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
            r0 = r10
            r1 = r19
            r3 = r21
            r4 = r23
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r10)
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Dialog$lambda-0  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m5724Dialog$lambda0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1177876616);
        int i16 = i12 & 1;
        if (i16 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if ((i13 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i16 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177876616, i13, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:442)");
            }
            AndroidDialog_androidKt$DialogLayout$1 androidDialog_androidKt$DialogLayout$1 = AndroidDialog_androidKt$DialogLayout$1.INSTANCE;
            int i17 = ((i13 >> 3) & 14) | ((i13 << 3) & 112);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i18 = ((i17 << 9) & 7168) | 6;
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
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, androidDialog_androidKt$DialogLayout$1, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i18 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i18 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidDialog_androidKt$DialogLayout$2(modifier, function2, i11, i12));
        }
    }
}
