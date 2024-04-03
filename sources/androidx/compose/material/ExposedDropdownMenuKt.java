package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r24
            java.lang.String r0 = "onExpandedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1456052980(0x56c99af4, float:1.10833678E14)
            r3 = r23
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r25 & 1
            r6 = 2
            if (r3 == 0) goto L_0x0023
            r3 = r5 | 6
            goto L_0x0033
        L_0x0023:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.changed((boolean) r1)
            if (r3 == 0) goto L_0x002f
            r3 = 4
            goto L_0x0030
        L_0x002f:
            r3 = r6
        L_0x0030:
            r3 = r3 | r5
            goto L_0x0033
        L_0x0032:
            r3 = r5
        L_0x0033:
            r7 = r25 & 2
            if (r7 == 0) goto L_0x003a
            r3 = r3 | 48
            goto L_0x004a
        L_0x003a:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004a
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0047
            r7 = 32
            goto L_0x0049
        L_0x0047:
            r7 = 16
        L_0x0049:
            r3 = r3 | r7
        L_0x004a:
            r7 = r25 & 4
            if (r7 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0064
            r8 = r21
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0060
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r9
            goto L_0x0066
        L_0x0064:
            r8 = r21
        L_0x0066:
            r9 = r25 & 8
            if (r9 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006d:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007d
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x007a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r3 = r3 | r9
        L_0x007d:
            r9 = r3 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x0090
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x008a
            goto L_0x0090
        L_0x008a:
            r0.skipToGroupEnd()
            r3 = r8
            goto L_0x029d
        L_0x0090:
            if (r7 == 0) goto L_0x0095
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            goto L_0x0096
        L_0x0095:
            r7 = r8
        L_0x0096:
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r9 = r0.consume(r9)
            android.view.View r9 = (android.view.View) r9
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r10)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r16.getEmpty()
            r13 = 0
            r15 = 0
            if (r11 != r12) goto L_0x00c9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r15)
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r13, r6, r13)
            r0.updateRememberedValue(r11)
        L_0x00c9:
            r0.endReplaceableGroup()
            r14 = r11
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            r0.startReplaceableGroup(r10)
            java.lang.Object r11 = r0.rememberedValue()
            java.lang.Object r12 = r16.getEmpty()
            if (r11 != r12) goto L_0x00e7
            java.lang.Integer r11 = java.lang.Integer.valueOf(r15)
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r13, r6, r13)
            r0.updateRememberedValue(r11)
        L_0x00e7:
            r0.endReplaceableGroup()
            r6 = r11
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            float r11 = androidx.compose.material.MenuKt.getMenuVerticalMargin()
            int r13 = r8.m5441roundToPx0680j_4(r11)
            r0.startReplaceableGroup(r10)
            java.lang.Object r11 = r0.rememberedValue()
            java.lang.Object r12 = r16.getEmpty()
            if (r11 != r12) goto L_0x010a
            androidx.compose.ui.node.Ref r11 = new androidx.compose.ui.node.Ref
            r11.<init>()
            r0.updateRememberedValue(r11)
        L_0x010a:
            r0.endReplaceableGroup()
            r12 = r11
            androidx.compose.ui.node.Ref r12 = (androidx.compose.ui.node.Ref) r12
            int r11 = m1255ExposedDropdownMenuBox$lambda4(r6)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r17 = m1253ExposedDropdownMenuBox$lambda1(r14)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r17)
            r10 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r10)
            boolean r10 = r0.changed((java.lang.Object) r8)
            boolean r11 = r0.changed((java.lang.Object) r11)
            r10 = r10 | r11
            boolean r11 = r0.changed((java.lang.Object) r15)
            r10 = r10 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r10 != 0) goto L_0x0140
            java.lang.Object r10 = r16.getEmpty()
            if (r11 != r10) goto L_0x0148
        L_0x0140:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r11 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
            r11.<init>(r8, r6, r14)
            r0.updateRememberedValue(r11)
        L_0x0148:
            r0.endReplaceableGroup()
            r8 = r11
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r8 = (androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r8
            r10 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r10)
            java.lang.Object r10 = r0.rememberedValue()
            java.lang.Object r11 = r16.getEmpty()
            if (r10 != r11) goto L_0x0166
            androidx.compose.ui.focus.FocusRequester r10 = new androidx.compose.ui.focus.FocusRequester
            r10.<init>()
            r0.updateRememberedValue(r10)
        L_0x0166:
            r0.endReplaceableGroup()
            r15 = r10
            androidx.compose.ui.focus.FocusRequester r15 = (androidx.compose.ui.focus.FocusRequester) r15
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 r11 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
            r10 = r11
            r5 = r11
            r11 = r12
            r18 = r12
            r12 = r9
            r23 = r13
            r17 = r9
            r9 = r15
            r4 = 0
            r15 = r6
            r10.<init>(r11, r12, r13, r14, r15)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r7, r5)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r19)
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r11)
            boolean r11 = r0.changed((java.lang.Object) r2)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r10 = r10 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r10 != 0) goto L_0x01a1
            java.lang.Object r10 = r16.getEmpty()
            if (r11 != r10) goto L_0x01a9
        L_0x01a1:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1 r11 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
            r11.<init>(r2, r1)
            r0.updateRememberedValue(r11)
        L_0x01a9:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            androidx.compose.material.Strings$Companion r10 = androidx.compose.material.Strings.Companion
            int r10 = r10.m1378getExposedDropdownMenuUdPEhr4()
            r12 = 6
            java.lang.String r10 = androidx.compose.material.Strings_androidKt.m1382getString4foXLRw(r10, r0, r12)
            androidx.compose.ui.Modifier r5 = expandable(r5, r11, r10)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r5, r9)
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r10)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r4, r0, r4)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r4 = r0.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x020a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020a:
            r0.startReusableNode()
            boolean r4 = r0.getInserting()
            if (r4 == 0) goto L_0x0217
            r0.createNode(r12)
            goto L_0x021a
        L_0x0217:
            r0.useNode()
        L_0x021a:
            r0.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r12 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r10, r12)
            kotlin.jvm.functions.Function2 r10 = r15.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r11, r10)
            kotlin.jvm.functions.Function2 r10 = r15.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r13, r10)
            kotlin.jvm.functions.Function2 r10 = r15.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r14, r10)
            r0.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r4)
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r5.invoke(r4, r0, r11)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r4)
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r4)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r4 = -443225682(0xffffffffe594e9ae, float:-8.790261E22)
            r0.startReplaceableGroup(r4)
            r4 = 6
            int r3 = r3 >> r4
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r22
            r5 = r10
            r4.invoke(r8, r0, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4 r3 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
            r3.<init>(r1, r9)
            androidx.compose.runtime.EffectsKt.SideEffect(r3, r0, r5)
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 r3 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
            r5 = r23
            r9 = r17
            r11 = r18
            r3.<init>(r9, r11, r5, r6)
            r5 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r9, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r0, (int) r5)
            r3 = r7
        L_0x029d:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x02a4
            goto L_0x02b7
        L_0x02a4:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6 r8 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6
            r0 = r8
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r24
            r6 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x02b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-1  reason: not valid java name */
    public static final int m1253ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-2  reason: not valid java name */
    public static final void m1254ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-4  reason: not valid java name */
    public static final int m1255ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-5  reason: not valid java name */
    public static final void m1256ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    private static final Modifier expandable(Modifier modifier, Function0<Unit> function0, String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenuKt$expandable$1(function0, (Continuation<? super ExposedDropdownMenuKt$expandable$1>) null)), false, new ExposedDropdownMenuKt$expandable$2(str, function0), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i11, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates != null) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            float top = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop();
            int i12 = rect.top;
            function1.invoke(Integer.valueOf(((int) Math.max(top - ((float) i12), ((float) (rect.bottom - i12)) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i11));
        }
    }
}
