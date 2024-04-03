package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class TextFieldTransitionScope {
    @NotNull
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* renamed from: Transition_DTcfvLk$lambda-1  reason: not valid java name */
    private static final float m1455Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3  reason: not valid java name */
    private static final float m1456Transition_DTcfvLk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5  reason: not valid java name */
    private static final long m1457Transition_DTcfvLk$lambda5(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-6  reason: not valid java name */
    private static final long m1458Transition_DTcfvLk$lambda6(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0182, code lost:
        if (r8 != false) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ab, code lost:
        if (r8 != false) goto L_0x01b0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0249  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0][0]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1459TransitionDTcfvLk(@org.jetbrains.annotations.NotNull androidx.compose.material.InputPhase r28, long r29, long r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r33, boolean r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r36, int r37) {
        /*
            r27 = this;
            r2 = r28
            r7 = r33
            r8 = r34
            r5 = r35
            r6 = r37
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1988729962(0x76899c6a, float:1.3955413E33)
            r1 = r36
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r6 & 14
            r3 = 2
            if (r1 != 0) goto L_0x0032
            boolean r1 = r0.changed((java.lang.Object) r2)
            if (r1 == 0) goto L_0x002f
            r1 = 4
            goto L_0x0030
        L_0x002f:
            r1 = r3
        L_0x0030:
            r1 = r1 | r6
            goto L_0x0033
        L_0x0032:
            r1 = r6
        L_0x0033:
            r4 = r6 & 112(0x70, float:1.57E-43)
            r14 = r29
            if (r4 != 0) goto L_0x0045
            boolean r4 = r0.changed((long) r14)
            if (r4 == 0) goto L_0x0042
            r4 = 32
            goto L_0x0044
        L_0x0042:
            r4 = 16
        L_0x0044:
            r1 = r1 | r4
        L_0x0045:
            r4 = r6 & 896(0x380, float:1.256E-42)
            r12 = r31
            if (r4 != 0) goto L_0x0057
            boolean r4 = r0.changed((long) r12)
            if (r4 == 0) goto L_0x0054
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0056
        L_0x0054:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0056:
            r1 = r1 | r4
        L_0x0057:
            r4 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0067
            boolean r4 = r0.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0064
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0066
        L_0x0064:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0066:
            r1 = r1 | r4
        L_0x0067:
            r4 = 57344(0xe000, float:8.0356E-41)
            r9 = r6 & r4
            if (r9 != 0) goto L_0x007a
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x0077
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0079
        L_0x0077:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0079:
            r1 = r1 | r9
        L_0x007a:
            r17 = 458752(0x70000, float:6.42848E-40)
            r9 = r6 & r17
            if (r9 != 0) goto L_0x008c
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0089
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x008b
        L_0x0089:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x008b:
            r1 = r1 | r9
        L_0x008c:
            r9 = 374491(0x5b6db, float:5.24774E-40)
            r9 = r9 & r1
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r9 != r10) goto L_0x00a1
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x009c
            goto L_0x00a1
        L_0x009c:
            r0.skipToGroupEnd()
            goto L_0x037b
        L_0x00a1:
            r9 = r1 & 14
            r9 = r9 | 48
            java.lang.String r10 = "TextFieldInputState"
            r11 = 0
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r9, (int) r11)
            androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            java.lang.String r16 = "LabelProgress"
            r10 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r10)
            kotlin.jvm.internal.FloatCompanionObject r19 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r20 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r19)
            r4 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r4)
            java.lang.Object r21 = r18.getCurrentState()
            androidx.compose.material.InputPhase r21 = (androidx.compose.material.InputPhase) r21
            r10 = -1158004136(0xffffffffbafa4258, float:-0.0019093258)
            r0.startReplaceableGroup(r10)
            int[] r22 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r21 = r21.ordinal()
            r4 = r22[r21]
            r21 = 0
            r11 = 3
            r10 = 1
            r24 = 1065353216(0x3f800000, float:1.0)
            if (r4 == r10) goto L_0x00ec
            if (r4 == r3) goto L_0x00e9
            if (r4 != r11) goto L_0x00e3
            goto L_0x00ec
        L_0x00e3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00e9:
            r4 = r21
            goto L_0x00ee
        L_0x00ec:
            r4 = r24
        L_0x00ee:
            r0.endReplaceableGroup()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r25 = r18.getTargetState()
            androidx.compose.material.InputPhase r25 = (androidx.compose.material.InputPhase) r25
            r11 = -1158004136(0xffffffffbafa4258, float:-0.0019093258)
            r0.startReplaceableGroup(r11)
            int r11 = r25.ordinal()
            r11 = r22[r11]
            if (r11 == r10) goto L_0x0119
            if (r11 == r3) goto L_0x0115
            r3 = 3
            if (r11 != r3) goto L_0x010f
            goto L_0x011a
        L_0x010f:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0115:
            r3 = 3
            r11 = r21
            goto L_0x011c
        L_0x0119:
            r3 = 3
        L_0x011a:
            r11 = r24
        L_0x011c:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            androidx.compose.animation.core.Transition$Segment r3 = r18.getSegment()
            r23 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r23)
            java.lang.Object r3 = r9.invoke(r3, r0, r10)
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            r26 = 196608(0x30000, float:2.75506E-40)
            r9 = r18
            r2 = 1399891485(0x5370a61d, float:1.03357907E12)
            r10 = r4
            r4 = 3
            r12 = r3
            r13 = r20
            r14 = r16
            r15 = r0
            r16 = r26
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            java.lang.String r14 = "PlaceholderOpacity"
            r0.startReplaceableGroup(r2)
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r19)
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r2)
            java.lang.Object r2 = r18.getCurrentState()
            androidx.compose.material.InputPhase r2 = (androidx.compose.material.InputPhase) r2
            r10 = -1376159017(0xffffffffadf97ad7, float:-2.8362574E-11)
            r0.startReplaceableGroup(r10)
            int r2 = r2.ordinal()
            r2 = r22[r2]
            r15 = 1
            if (r2 == r15) goto L_0x0185
            r11 = 2
            if (r2 == r11) goto L_0x0182
            if (r2 != r4) goto L_0x017c
        L_0x0179:
            r2 = r21
            goto L_0x0187
        L_0x017c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0182:
            if (r8 == 0) goto L_0x0185
            goto L_0x0179
        L_0x0185:
            r2 = r24
        L_0x0187:
            r0.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r11 = r18.getTargetState()
            androidx.compose.material.InputPhase r11 = (androidx.compose.material.InputPhase) r11
            r0.startReplaceableGroup(r10)
            int r10 = r11.ordinal()
            r10 = r22[r10]
            if (r10 == r15) goto L_0x01ae
            r11 = 2
            if (r10 == r11) goto L_0x01ab
            if (r10 != r4) goto L_0x01a5
            goto L_0x01b0
        L_0x01a5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01ab:
            if (r8 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r21 = r24
        L_0x01b0:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r10 = r18.getSegment()
            r12 = 0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r12)
            java.lang.Object r9 = r9.invoke(r10, r0, r15)
            r12 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r9 = r18
            r10 = r2
            r2 = 1
            r15 = r0
            r16 = r26
            androidx.compose.runtime.State r19 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            java.lang.String r14 = "LabelTextStyleColor"
            r15 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r0.startReplaceableGroup(r15)
            java.lang.Object r10 = r18.getTargetState()
            androidx.compose.material.InputPhase r10 = (androidx.compose.material.InputPhase) r10
            r11 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            r0.startReplaceableGroup(r11)
            int r10 = r10.ordinal()
            r10 = r22[r10]
            if (r10 != r2) goto L_0x01f9
            r12 = r29
            goto L_0x01fb
        L_0x01f9:
            r12 = r31
        L_0x01fb:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r12)
            r13 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r13)
            boolean r12 = r0.changed((java.lang.Object) r10)
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x021a
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x022a
        L_0x021a:
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r12 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r12)
            java.lang.Object r10 = r12.invoke(r10)
            r13 = r10
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r0.updateRememberedValue(r13)
        L_0x022a:
            r0.endReplaceableGroup()
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r10 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r10)
            java.lang.Object r10 = r18.getCurrentState()
            androidx.compose.material.InputPhase r10 = (androidx.compose.material.InputPhase) r10
            r0.startReplaceableGroup(r11)
            int r10 = r10.ordinal()
            r10 = r22[r10]
            if (r10 != r2) goto L_0x0249
            r20 = r29
            goto L_0x024b
        L_0x0249:
            r20 = r31
        L_0x024b:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m2909boximpl(r20)
            java.lang.Object r12 = r18.getTargetState()
            androidx.compose.material.InputPhase r12 = (androidx.compose.material.InputPhase) r12
            r0.startReplaceableGroup(r11)
            int r11 = r12.ordinal()
            r11 = r22[r11]
            if (r11 != r2) goto L_0x0266
            r11 = r29
            goto L_0x0268
        L_0x0266:
            r11 = r31
        L_0x0268:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r11)
            androidx.compose.animation.core.Transition$Segment r2 = r18.getSegment()
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r2 = r9.invoke(r2, r0, r12)
            r12 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r2 = 229376(0x38000, float:3.21424E-40)
            r9 = r18
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r4 = r15
            r15 = r0
            r16 = r2
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            java.lang.String r14 = "LabelContentColor"
            r10 = r1 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 384(0x180, float:5.38E-43)
            r0.startReplaceableGroup(r4)
            java.lang.Object r4 = r18.getTargetState()
            int r11 = r10 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object r4 = r7.invoke(r4, r0, r11)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r11 = r4.m2929unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r11)
            r11 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r11)
            boolean r11 = r0.changed((java.lang.Object) r4)
            java.lang.Object r12 = r0.rememberedValue()
            if (r11 != 0) goto L_0x02d2
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x02e2
        L_0x02d2:
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r11 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r11)
            java.lang.Object r4 = r11.invoke(r4)
            r12 = r4
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r0.updateRememberedValue(r12)
        L_0x02e2:
            r0.endReplaceableGroup()
            r13 = r12
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r4 = r10 & 14
            r4 = r4 | 64
            r11 = 3
            int r10 = r10 << r11
            r11 = r10 & 896(0x380, float:1.256E-42)
            r4 = r4 | r11
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r4 = r4 | r10
            r10 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r10)
            java.lang.Object r10 = r18.getCurrentState()
            int r11 = r4 >> 9
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            java.lang.Object r10 = r7.invoke(r10, r0, r12)
            java.lang.Object r12 = r18.getTargetState()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object r11 = r7.invoke(r12, r0, r11)
            androidx.compose.animation.core.Transition$Segment r12 = r18.getSegment()
            int r15 = r4 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.Object r9 = r9.invoke(r12, r0, r15)
            r12 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r9 = r4 & 14
            int r15 = r4 << 9
            r16 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r16
            r9 = r9 | r15
            int r4 = r4 << 6
            r4 = r4 & r17
            r16 = r9 | r4
            r9 = r18
            r15 = r0
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            float r3 = m1455Transition_DTcfvLk$lambda1(r3)
            java.lang.Float r10 = java.lang.Float.valueOf(r3)
            long r2 = m1457Transition_DTcfvLk$lambda5(r2)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r2)
            long r2 = m1458Transition_DTcfvLk$lambda6(r4)
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m2909boximpl(r2)
            float r2 = m1456Transition_DTcfvLk$lambda3(r19)
            java.lang.Float r13 = java.lang.Float.valueOf(r2)
            r2 = 3
            int r1 = r1 >> r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            java.lang.Integer r15 = java.lang.Integer.valueOf(r1)
            r9 = r35
            r14 = r0
            r9.invoke(r10, r11, r12, r13, r14, r15)
        L_0x037b:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x0382
            goto L_0x039b
        L_0x0382:
            androidx.compose.material.TextFieldTransitionScope$Transition$1 r12 = new androidx.compose.material.TextFieldTransitionScope$Transition$1
            r0 = r12
            r1 = r27
            r2 = r28
            r3 = r29
            r5 = r31
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = r37
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1459TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }
}
