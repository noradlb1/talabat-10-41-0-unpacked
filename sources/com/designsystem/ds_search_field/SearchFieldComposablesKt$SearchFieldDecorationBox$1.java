package com.designsystem.ds_search_field;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SearchFieldComposablesKt$SearchFieldDecorationBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32620g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32621h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32622i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32623j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f32624k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFieldComposablesKt$SearchFieldDecorationBox$1(String str, Function0<Unit> function0, int i11, Function2<? super Composer, ? super Integer, Unit> function2, String str2) {
        super(2);
        this.f32620g = str;
        this.f32621h = function0;
        this.f32622i = i11;
        this.f32623j = function2;
        this.f32624k = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0186: MOVE  (r2v26 java.lang.String) = (r18v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    @androidx.compose.runtime.Composable
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21 & 11
            r2 = r2 ^ 2
            if (r2 != 0) goto L_0x0016
            boolean r2 = r20.getSkipping()
            if (r2 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r20.skipToGroupEnd()
            goto L_0x01f5
        L_0x0016:
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r2.getCenterVertically()
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            r11 = 0
            r12 = 1
            r13 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r10, r11, r12, r13)
            r14 = 0
            r5 = 3
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r4, r13, r14, r5, r13)
            java.lang.String r15 = r0.f32620g
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r0.f32621h
            int r8 = r0.f32622i
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.f32623j
            java.lang.String r6 = r0.f32624k
            r5 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r1.startReplaceableGroup(r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r3, r1, r14)
            r5 = 1376089335(0x520574f7, float:1.43298249E11)
            r1.startReplaceableGroup(r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r5 = r1.consume(r5)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r11 = r1.consume(r11)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r13 = r20.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0074
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0074:
            r20.startReusableNode()
            boolean r13 = r20.getInserting()
            if (r13 == 0) goto L_0x0081
            r1.createNode(r12)
            goto L_0x0084
        L_0x0081:
            r20.useNode()
        L_0x0084:
            r20.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2536constructorimpl(r20)
            kotlin.jvm.functions.Function2 r13 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r3, r13)
            kotlin.jvm.functions.Function2 r3 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r5, r3)
            kotlin.jvm.functions.Function2 r3 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r11, r3)
            r20.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r20)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r4.invoke(r3, r1, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r3)
            r4 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r1.startReplaceableGroup(r4)
            androidx.compose.foundation.layout.RowScopeInstance r4 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            com.designsystem.ds_search_field.SearchFieldComposablesKt.SearchFieldLeadingIcon(r1, r14)
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r13 = 2
            r17 = 0
            r3 = 1376089335(0x520574f7, float:1.43298249E11)
            r5 = r10
            r18 = r6
            r6 = r11
            r11 = r7
            r7 = r12
            r12 = r8
            r8 = r13
            r13 = r9
            r9 = r17
            androidx.compose.ui.Modifier r4 = p.e.a(r4, r5, r6, r7, r8, r9)
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r6 = r5.getDimens(r1, r14)
            float r6 = r6.m8842getDsSD9Ej5fM()
            r7 = 0
            r8 = 0
            r9 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m488paddingVpY3zN4$default(r4, r7, r6, r9, r8)
            r6 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r1.startReplaceableGroup(r6)
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r14, r1, r14)
            r1.startReplaceableGroup(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r1.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r6 = r1.consume(r6)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            kotlin.jvm.functions.Function0 r7 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r8 = r20.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0124
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0124:
            r20.startReusableNode()
            boolean r8 = r20.getInserting()
            if (r8 == 0) goto L_0x0131
            r1.createNode(r7)
            goto L_0x0134
        L_0x0131:
            r20.useNode()
        L_0x0134:
            r20.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r20)
            kotlin.jvm.functions.Function2 r8 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r2, r8)
            kotlin.jvm.functions.Function2 r2 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r3, r2)
            kotlin.jvm.functions.Function2 r2 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r6, r2)
            r20.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r20)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            r4.invoke(r2, r1, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r2)
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r1.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r12 >> 6
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r1, r2)
            int r2 = r15.length()
            if (r2 != 0) goto L_0x0183
            r2 = r9
            goto L_0x0184
        L_0x0183:
            r2 = r14
        L_0x0184:
            if (r2 == 0) goto L_0x019b
            r2 = r18
            if (r2 == 0) goto L_0x019b
            r3 = -363070571(0xffffffffea5bfb95, float:-6.6485704E25)
            r1.startReplaceableGroup(r3)
            int r3 = r12 >> 3
            r3 = r3 & 14
            com.designsystem.ds_search_field.SearchFieldComposablesKt.SearchFieldHintText(r2, r1, r3)
            r20.endReplaceableGroup()
            goto L_0x01a4
        L_0x019b:
            r2 = -363070506(0xffffffffea5bfbd6, float:-6.6486004E25)
            r1.startReplaceableGroup(r2)
            r20.endReplaceableGroup()
        L_0x01a4:
            r20.endReplaceableGroup()
            r20.endReplaceableGroup()
            r20.endNode()
            r20.endReplaceableGroup()
            r20.endReplaceableGroup()
            int r2 = r15.length()
            if (r2 <= 0) goto L_0x01ba
            goto L_0x01bb
        L_0x01ba:
            r9 = r14
        L_0x01bb:
            if (r9 == 0) goto L_0x01ce
            r2 = 130472168(0x7c6d8e8, float:2.9919215E-34)
            r1.startReplaceableGroup(r2)
            int r2 = r12 >> 9
            r2 = r2 & 14
            com.designsystem.ds_search_field.SearchFieldComposablesKt.SearchFieldTrailingIcon(r13, r1, r2)
            r20.endReplaceableGroup()
            goto L_0x01e6
        L_0x01ce:
            r2 = 130472247(0x7c6d937, float:2.9919396E-34)
            r1.startReplaceableGroup(r2)
            com.designsystem.ds_theme.DSDimens r2 = r5.getDimens(r1, r14)
            float r2 = r2.m8844getDsXsD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r10, r2)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r1, r14)
            r20.endReplaceableGroup()
        L_0x01e6:
            r20.endReplaceableGroup()
            r20.endReplaceableGroup()
            r20.endNode()
            r20.endReplaceableGroup()
            r20.endReplaceableGroup()
        L_0x01f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_search_field.SearchFieldComposablesKt$SearchFieldDecorationBox$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
