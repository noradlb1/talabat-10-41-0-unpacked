package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aa\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010(\u001a \u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0000ø\u0001\u0000¢\u0006\u0002\u0010-\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\b\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m5478constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m5478constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m5478constructorimpl((float) 16);
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;

    static {
        float f11 = (float) 8;
        MenuElevation = Dp.m5478constructorimpl(f11);
        float f12 = (float) 48;
        MenuVerticalMargin = Dp.m5478constructorimpl(f12);
        DropdownMenuVerticalPadding = Dp.m5478constructorimpl(f11);
        DropdownMenuItemDefaultMinHeight = Dp.m5478constructorimpl(f12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuContent(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r20, @org.jetbrains.annotations.NotNull androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.TransformOrigin> r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r20
            r2 = r21
            r4 = r23
            r5 = r25
            java.lang.String r0 = "expandedStates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "transformOriginState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1164283597(0x45658ecd, float:3672.925)
            r3 = r24
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r26 & 1
            if (r3 == 0) goto L_0x0027
            r3 = r5 | 6
            goto L_0x0037
        L_0x0027:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0036
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r5
            goto L_0x0037
        L_0x0036:
            r3 = r5
        L_0x0037:
            r6 = r26 & 2
            if (r6 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x004e
        L_0x003e:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004e
            boolean r6 = r0.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x004b
            r6 = 32
            goto L_0x004d
        L_0x004b:
            r6 = 16
        L_0x004d:
            r3 = r3 | r6
        L_0x004e:
            r6 = r26 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r5 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r22
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r22
        L_0x006a:
            r8 = r26 & 8
            if (r8 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r8 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0081
            boolean r8 = r0.changed((java.lang.Object) r4)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r8
        L_0x0081:
            r8 = r3 & 5851(0x16db, float:8.199E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r8 != r9) goto L_0x0094
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x008e
            goto L_0x0094
        L_0x008e:
            r0.skipToGroupEnd()
            r3 = r7
            goto L_0x01d9
        L_0x0094:
            if (r6 == 0) goto L_0x009a
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r15 = r6
            goto L_0x009b
        L_0x009a:
            r15 = r7
        L_0x009b:
            int r6 = androidx.compose.animation.core.MutableTransitionState.$stable
            r6 = r6 | 48
            r7 = r3 & 14
            r6 = r6 | r7
            java.lang.String r7 = "DropDownMenu"
            r14 = 0
            androidx.compose.animation.core.Transition r16 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r7, (androidx.compose.runtime.Composer) r0, (int) r6, (int) r14)
            androidx.compose.material.MenuKt$DropdownMenuContent$scale$2 r6 = androidx.compose.material.MenuKt$DropdownMenuContent$scale$2.INSTANCE
            r13 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r13)
            java.lang.String r11 = "FloatAnimation"
            kotlin.jvm.internal.FloatCompanionObject r17 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r17)
            r12 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r12)
            java.lang.Object r7 = r16.getCurrentState()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = -1958825495(0xffffffff8b3eb1e9, float:-3.6726514E-32)
            r0.startReplaceableGroup(r8)
            r9 = 1061997773(0x3f4ccccd, float:0.8)
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r7 == 0) goto L_0x00d9
            r7 = r18
            goto L_0x00da
        L_0x00d9:
            r7 = r9
        L_0x00da:
            r0.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r19 = r16.getTargetState()
            java.lang.Boolean r19 = (java.lang.Boolean) r19
            boolean r19 = r19.booleanValue()
            r0.startReplaceableGroup(r8)
            if (r19 == 0) goto L_0x00f2
            r9 = r18
        L_0x00f2:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r9)
            androidx.compose.animation.core.Transition$Segment r9 = r16.getSegment()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r6.invoke(r9, r0, r12)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r19 = 0
            r6 = r16
            r14 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12 = r0
            r14 = r13
            r13 = r19
            androidx.compose.runtime.State r13 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2 r6 = androidx.compose.material.MenuKt$DropdownMenuContent$alpha$2.INSTANCE
            r0.startReplaceableGroup(r14)
            java.lang.String r11 = "FloatAnimation"
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r17)
            r7 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r7)
            java.lang.Object r7 = r16.getCurrentState()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = -1541356035(0xffffffffa420c5fd, float:-3.4862172E-17)
            r0.startReplaceableGroup(r8)
            r9 = 0
            if (r7 == 0) goto L_0x0144
            r7 = r18
            goto L_0x0145
        L_0x0144:
            r7 = r9
        L_0x0145:
            r0.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r12 = r16.getTargetState()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r0.startReplaceableGroup(r8)
            if (r12 == 0) goto L_0x015c
            goto L_0x015e
        L_0x015c:
            r18 = r9
        L_0x015e:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r9 = r16.getSegment()
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r6 = r6.invoke(r9, r0, r12)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r6 = r16
            r12 = r0
            r14 = r13
            r13 = r19
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r8 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r8)
            boolean r8 = r0.changed((java.lang.Object) r14)
            boolean r9 = r0.changed((java.lang.Object) r6)
            r8 = r8 | r9
            boolean r9 = r0.changed((java.lang.Object) r2)
            r8 = r8 | r9
            java.lang.Object r9 = r0.rememberedValue()
            if (r8 != 0) goto L_0x01a9
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x01b1
        L_0x01a9:
            androidx.compose.material.MenuKt$DropdownMenuContent$1$1 r9 = new androidx.compose.material.MenuKt$DropdownMenuContent$1$1
            r9.<init>(r2, r14, r6)
            r0.updateRememberedValue(r9)
        L_0x01b1:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r7, r9)
            r7 = 0
            r8 = 0
            r10 = 0
            float r13 = MenuElevation
            androidx.compose.material.MenuKt$DropdownMenuContent$2 r14 = new androidx.compose.material.MenuKt$DropdownMenuContent$2
            r14.<init>(r15, r4, r3)
            r3 = -242468534(0xfffffffff18c394a, float:-1.3887091E30)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r12, r14)
            r16 = 1769472(0x1b0000, float:2.479558E-39)
            r17 = 30
            r3 = 0
            r12 = r3
            r3 = r15
            r15 = r0
            androidx.compose.material.CardKt.m1142CardFjzlyU(r6, r7, r8, r10, r12, r13, r14, r15, r16, r17)
        L_0x01d9:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x01e0
            goto L_0x01f3
        L_0x01e0:
            androidx.compose.material.MenuKt$DropdownMenuContent$3 r8 = new androidx.compose.material.MenuKt$DropdownMenuContent$3
            r0 = r8
            r1 = r20
            r2 = r21
            r4 = r23
            r5 = r25
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x01f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-1  reason: not valid java name */
    public static final float m1290DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-3  reason: not valid java name */
    public static final float m1291DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItemContent(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, boolean r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r26
            r10 = r31
            r11 = r33
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 87134531(0x5319143, float:8.3491804E-36)
            r1 = r32
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r34 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r11 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r11
            goto L_0x0030
        L_0x002f:
            r0 = r11
        L_0x0030:
            r1 = r34 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r27
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
            goto L_0x004c
        L_0x004a:
            r2 = r27
        L_0x004c:
            r3 = r34 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r28
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r28
        L_0x0068:
            r5 = r34 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r29
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r7
            goto L_0x0084
        L_0x0082:
            r6 = r29
        L_0x0084:
            r7 = r34 & 16
            if (r7 == 0) goto L_0x008b
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00a0
            r8 = r30
            boolean r13 = r12.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x009c
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r0 = r0 | r13
            goto L_0x00a2
        L_0x00a0:
            r8 = r30
        L_0x00a2:
            r13 = r34 & 32
            if (r13 == 0) goto L_0x00aa
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00a8:
            r0 = r0 | r13
            goto L_0x00bb
        L_0x00aa:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00bb
            boolean r13 = r12.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x00b8
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a8
        L_0x00b8:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a8
        L_0x00bb:
            r13 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r0 & r13
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r0 != r14) goto L_0x00d4
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x00cc
            goto L_0x00d4
        L_0x00cc:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r8
            goto L_0x0232
        L_0x00d4:
            if (r1 == 0) goto L_0x00da
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r14 = r0
            goto L_0x00db
        L_0x00da:
            r14 = r2
        L_0x00db:
            r15 = 1
            if (r3 == 0) goto L_0x00e1
            r16 = r15
            goto L_0x00e3
        L_0x00e1:
            r16 = r4
        L_0x00e3:
            if (r5 == 0) goto L_0x00ec
            androidx.compose.material.MenuDefaults r0 = androidx.compose.material.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getDropdownMenuItemContentPadding()
            goto L_0x00ed
        L_0x00ec:
            r0 = r6
        L_0x00ed:
            if (r7 == 0) goto L_0x0110
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r1)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0108
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r1)
        L_0x0108:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r17 = r1
            goto L_0x0112
        L_0x0110:
            r17 = r8
        L_0x0112:
            r1 = 1
            r2 = 0
            r3 = 0
            r6 = 6
            r7 = 6
            r5 = r12
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r4 = 0
            r5 = 0
            r7 = 24
            r8 = 0
            r6 = r0
            r0 = r14
            r1 = r17
            r3 = r16
            r18 = r6
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
            r2 = 0
            androidx.compose.ui.Modifier r19 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r1, r15, r2)
            float r20 = DropdownMenuItemDefaultMinWidth
            float r22 = DropdownMenuItemDefaultMaxWidth
            float r21 = DropdownMenuItemDefaultMinHeight
            r23 = 0
            r24 = 8
            r25 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m562sizeInqDBjuR0$default(r19, r20, r21, r22, r23, r24, r25)
            r6 = r18
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.padding(r0, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getCenterVertically()
            r2 = 693286680(0x2952b718, float:4.6788176E-14)
            r12.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            r7 = 48
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r1, r12, r7)
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
            kotlin.jvm.functions.Function0 r8 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r7 = r12.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x019d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x019d:
            r12.startReusableNode()
            boolean r7 = r12.getInserting()
            if (r7 == 0) goto L_0x01aa
            r12.createNode(r8)
            goto L_0x01ad
        L_0x01aa:
            r12.useNode()
        L_0x01ad:
            r12.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r12)
            kotlin.jvm.functions.Function2 r8 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r1, r8)
            kotlin.jvm.functions.Function2 r1 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r3, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r4, r1)
            r12.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r12, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            r0 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r12.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.RowScopeInstance r3 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r0 = 1664959143(0x633d42a7, float:3.4912374E21)
            r12.startReplaceableGroup(r0)
            r4 = 6
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Typography r0 = r0.getTypography(r12, r1)
            androidx.compose.ui.text.TextStyle r7 = r0.getSubtitle1()
            androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1 r8 = new androidx.compose.material.MenuKt$DropdownMenuItemContent$2$1
            r0 = r8
            r1 = r16
            r2 = r31
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 1190489496(0x46f56d98, float:31414.797)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r15, r8)
            r1 = 48
            androidx.compose.material.TextKt.ProvideTextStyle(r7, r0, r12, r1)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r4 = r6
            r2 = r14
            r3 = r16
            r5 = r17
        L_0x0232:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x0239
            goto L_0x024a
        L_0x0239:
            androidx.compose.material.MenuKt$DropdownMenuItemContent$3 r13 = new androidx.compose.material.MenuKt$DropdownMenuItemContent$3
            r0 = r13
            r1 = r26
            r6 = r31
            r7 = r33
            r8 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r12.updateScope(r13)
        L_0x024a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.DropdownMenuItemContent(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long calculateTransformOrigin(@org.jetbrains.annotations.NotNull androidx.compose.ui.unit.IntRect r5, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.IntRect r6) {
        /*
            java.lang.String r0 = "parentBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "menuBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r6.getLeft()
            int r1 = r5.getRight()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto L_0x0019
        L_0x0017:
            r0 = r3
            goto L_0x0053
        L_0x0019:
            int r0 = r6.getRight()
            int r1 = r5.getLeft()
            if (r0 > r1) goto L_0x0025
            r0 = r2
            goto L_0x0053
        L_0x0025:
            int r0 = r6.getWidth()
            if (r0 != 0) goto L_0x002c
            goto L_0x0017
        L_0x002c:
            int r0 = r5.getLeft()
            int r1 = r6.getLeft()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.getRight()
            int r4 = r6.getRight()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
        L_0x0053:
            int r1 = r6.getTop()
            int r4 = r5.getBottom()
            if (r1 < r4) goto L_0x005f
        L_0x005d:
            r2 = r3
            goto L_0x0099
        L_0x005f:
            int r1 = r6.getBottom()
            int r4 = r5.getTop()
            if (r1 > r4) goto L_0x006a
            goto L_0x0099
        L_0x006a:
            int r1 = r6.getHeight()
            if (r1 != 0) goto L_0x0071
            goto L_0x005d
        L_0x0071:
            int r1 = r5.getTop()
            int r2 = r6.getTop()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.getBottom()
            int r2 = r6.getBottom()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.getTop()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r2 = r5 / r6
        L_0x0099:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
