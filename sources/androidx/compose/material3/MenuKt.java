package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.MenuTokens;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\u000e2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0002\b\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\u0010*\u001a \u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0002\u0010/\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0019\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m5478constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m5478constructorimpl((float) 112);
    /* access modifiers changed from: private */
    public static final float DropdownMenuItemHorizontalPadding = Dp.m5478constructorimpl((float) 12);
    private static final float DropdownMenuVerticalPadding = Dp.m5478constructorimpl((float) 8);
    public static final int InTransitionDuration = 120;
    private static final float MenuVerticalMargin = Dp.m5478constructorimpl((float) 48);
    public static final int OutTransitionDuration = 75;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuContent(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r22, @org.jetbrains.annotations.NotNull androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.TransformOrigin> r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r22
            r2 = r23
            r4 = r25
            r5 = r27
            java.lang.String r0 = "expandedStates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "transformOriginState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -159754260(0xfffffffff67a57ec, float:-1.2693921E33)
            r3 = r26
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            r6 = r28 & 1
            if (r6 == 0) goto L_0x0027
            r6 = r5 | 6
            goto L_0x0037
        L_0x0027:
            r6 = r5 & 14
            if (r6 != 0) goto L_0x0036
            boolean r6 = r3.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x0033
            r6 = 4
            goto L_0x0034
        L_0x0033:
            r6 = 2
        L_0x0034:
            r6 = r6 | r5
            goto L_0x0037
        L_0x0036:
            r6 = r5
        L_0x0037:
            r7 = r28 & 2
            if (r7 == 0) goto L_0x003e
            r6 = r6 | 48
            goto L_0x004e
        L_0x003e:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004e
            boolean r7 = r3.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x004b
            r7 = 32
            goto L_0x004d
        L_0x004b:
            r7 = 16
        L_0x004d:
            r6 = r6 | r7
        L_0x004e:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x0055
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0068
            r8 = r24
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0064
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r6 = r6 | r9
            goto L_0x006a
        L_0x0068:
            r8 = r24
        L_0x006a:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x0071
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0081
            boolean r9 = r3.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x007e
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r6 = r6 | r9
        L_0x0081:
            r14 = r6
            r6 = r14 & 5851(0x16db, float:8.199E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r6 != r9) goto L_0x0094
            boolean r6 = r3.getSkipping()
            if (r6 != 0) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            r3.skipToGroupEnd()
            goto L_0x025e
        L_0x0094:
            if (r7 == 0) goto L_0x009a
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r15 = r6
            goto L_0x009b
        L_0x009a:
            r15 = r8
        L_0x009b:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r13 = -1
            if (r6 == 0) goto L_0x00a7
            java.lang.String r6 = "androidx.compose.material3.DropdownMenuContent (Menu.kt:65)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r13, r6)
        L_0x00a7:
            int r0 = androidx.compose.animation.core.MutableTransitionState.$stable
            r0 = r0 | 48
            r6 = r14 & 14
            r0 = r0 | r6
            java.lang.String r6 = "DropDownMenu"
            r12 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r6, (androidx.compose.runtime.Composer) r3, (int) r0, (int) r12)
            androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2 r6 = androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2.INSTANCE
            r11 = 1399891485(0x5370a61d, float:1.03357907E12)
            r3.startReplaceableGroup(r11)
            java.lang.String r16 = "FloatAnimation"
            kotlin.jvm.internal.FloatCompanionObject r17 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r17)
            r9 = 1847725064(0x6e220c08, float:1.2537779E28)
            r3.startReplaceableGroup(r9)
            java.lang.Object r7 = r0.getCurrentState()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 1808111696(0x6bc59850, float:4.7775532E26)
            r3.startReplaceableGroup(r8)
            boolean r18 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r9 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)"
            if (r18 == 0) goto L_0x00e6
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r12, r13, r9)
        L_0x00e6:
            r18 = 1061997773(0x3f4ccccd, float:0.8)
            r19 = 1065353216(0x3f800000, float:1.0)
            if (r7 == 0) goto L_0x00f0
            r7 = r19
            goto L_0x00f2
        L_0x00f0:
            r7 = r18
        L_0x00f2:
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r20 == 0) goto L_0x00fb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00fb:
            r3.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r20 = r0.getTargetState()
            java.lang.Boolean r20 = (java.lang.Boolean) r20
            boolean r20 = r20.booleanValue()
            r3.startReplaceableGroup(r8)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r21 == 0) goto L_0x0118
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r12, r13, r9)
        L_0x0118:
            if (r20 == 0) goto L_0x011c
            r18 = r19
        L_0x011c:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0125
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0125:
            r3.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r9 = r0.getSegment()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            java.lang.Object r6 = r6.invoke(r9, r3, r11)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r18 = 0
            r6 = r0
            r11 = 1847725064(0x6e220c08, float:1.2537779E28)
            r11 = r16
            r1 = r12
            r12 = r3
            r5 = r13
            r13 = r18
            androidx.compose.runtime.State r13 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2 r6 = androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2.INSTANCE
            r7 = 1399891485(0x5370a61d, float:1.03357907E12)
            r3.startReplaceableGroup(r7)
            java.lang.String r11 = "FloatAnimation"
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r17)
            r7 = 1847725064(0x6e220c08, float:1.2537779E28)
            r3.startReplaceableGroup(r7)
            java.lang.Object r7 = r0.getCurrentState()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 1864763068(0x6f2606bc, float:5.1382653E28)
            r3.startReplaceableGroup(r8)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r12 = "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)"
            if (r9 == 0) goto L_0x0181
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r1, r5, r12)
        L_0x0181:
            r9 = 0
            if (r7 == 0) goto L_0x0187
            r7 = r19
            goto L_0x0188
        L_0x0187:
            r7 = r9
        L_0x0188:
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0191
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0191:
            r3.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r16 = r0.getTargetState()
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            boolean r16 = r16.booleanValue()
            r3.startReplaceableGroup(r8)
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x01ae
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r1, r5, r12)
        L_0x01ae:
            if (r16 == 0) goto L_0x01b1
            goto L_0x01b3
        L_0x01b1:
            r19 = r9
        L_0x01b3:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01bc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01bc:
            r3.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r19)
            androidx.compose.animation.core.Transition$Segment r5 = r0.getSegment()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r6.invoke(r5, r3, r1)
            r9 = r1
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r6 = r0
            r12 = r3
            r0 = r13
            r13 = r18
            androidx.compose.runtime.State r1 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r6 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r6)
            boolean r6 = r3.changed((java.lang.Object) r0)
            boolean r7 = r3.changed((java.lang.Object) r1)
            r6 = r6 | r7
            boolean r7 = r3.changed((java.lang.Object) r2)
            r6 = r6 | r7
            java.lang.Object r7 = r3.rememberedValue()
            if (r6 != 0) goto L_0x0205
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x020d
        L_0x0205:
            androidx.compose.material3.MenuKt$DropdownMenuContent$1$1 r7 = new androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
            r7.<init>(r2, r0, r1)
            r3.updateRememberedValue(r7)
        L_0x020d:
            r3.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r5, r7)
            androidx.compose.material3.tokens.MenuTokens r0 = androidx.compose.material3.tokens.MenuTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r1 = r0.getContainerShape()
            r5 = 6
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.material3.ShapesKt.toShape(r1, r3, r5)
            androidx.compose.material3.MaterialTheme r1 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r1 = r1.getColorScheme(r3, r5)
            androidx.compose.material3.tokens.ColorSchemeKeyTokens r5 = r0.getContainerColor()
            long r8 = androidx.compose.material3.ColorSchemeKt.fromToken(r1, r5)
            r10 = 0
            float r12 = r0.m2274getContainerElevationD9Ej5fM()
            float r13 = r0.m2274getContainerElevationD9Ej5fM()
            r0 = 0
            androidx.compose.material3.MenuKt$DropdownMenuContent$2 r1 = new androidx.compose.material3.MenuKt$DropdownMenuContent$2
            r1.<init>(r15, r4, r14)
            r5 = -1651673913(0xffffffff9d8d74c7, float:-3.7443134E-21)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r5, r14, r1)
            r17 = 12804096(0xc36000, float:1.794236E-38)
            r18 = 72
            r14 = r0
            r0 = r15
            r15 = r1
            r16 = r3
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x025d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025d:
            r8 = r0
        L_0x025e:
            androidx.compose.runtime.ScopeUpdateScope r7 = r3.endRestartGroup()
            if (r7 != 0) goto L_0x0265
            goto L_0x0279
        L_0x0265:
            androidx.compose.material3.MenuKt$DropdownMenuContent$3 r9 = new androidx.compose.material3.MenuKt$DropdownMenuContent$3
            r0 = r9
            r1 = r22
            r2 = r23
            r3 = r8
            r4 = r25
            r5 = r27
            r6 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r9)
        L_0x0279:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-1  reason: not valid java name */
    public static final float m1739DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-3  reason: not valid java name */
    public static final float m1740DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void DropdownMenuItemContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Modifier modifier, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, boolean z11, @NotNull MenuItemColors menuItemColors, @NotNull PaddingValues paddingValues, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        Function0<Unit> function02 = function0;
        Modifier modifier2 = modifier;
        MenuItemColors menuItemColors2 = menuItemColors;
        PaddingValues paddingValues2 = paddingValues;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        int i23 = i11;
        Intrinsics.checkNotNullParameter(function24, "text");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(menuItemColors2, "colors");
        Intrinsics.checkNotNullParameter(paddingValues2, "contentPadding");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Composer startRestartGroup = composer.startRestartGroup(-1564716777);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i12 = i22 | i23;
        } else {
            i12 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i12 |= i21;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i12 |= i19;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function25)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i12 |= i18;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed((Object) function26)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        }
        boolean z12 = z11;
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed(z12)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i12 |= i16;
        }
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed((Object) menuItemColors2)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i12 |= i15;
        }
        if ((29360128 & i23) == 0) {
            if (startRestartGroup.changed((Object) paddingValues2)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i12 |= i14;
        }
        if ((234881024 & i23) == 0) {
            if (startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i12 |= i13;
        }
        int i24 = i12;
        if ((191739611 & i24) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, i24, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:142)");
            }
            int i25 = i24;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(ClickableKt.m194clickableO2vRcR0$default(modifier, mutableInteractionSource, RippleKt.m1485rememberRipple9IZ8Weo(true, 0.0f, 0, startRestartGroup, 6, 6), z11, (String) null, (Role) null, function0, 24, (Object) null), 0.0f, 1, (Object) null);
            float f11 = DropdownMenuItemDefaultMinWidth;
            float f12 = DropdownMenuItemDefaultMaxWidth;
            MenuTokens menuTokens = MenuTokens.INSTANCE;
            Modifier padding = PaddingKt.padding(SizeKt.m562sizeInqDBjuR0$default(fillMaxWidth$default, f11, menuTokens.m2275getListItemContainerHeightD9Ej5fM(), f12, 0.0f, 8, (Object) null), paddingValues2);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(padding);
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
            Composer r11 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r11, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density, companion.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r11, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-837672837);
            composer2 = startRestartGroup;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), menuTokens.getListItemLabelTextFont()), ComposableLambdaKt.composableLambda(composer2, 1065051884, true, new MenuKt$DropdownMenuItemContent$1$1(function22, menuItemColors, z11, i25, function23, rowScopeInstance, function2)), composer2, 48);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MenuKt$DropdownMenuItemContent$2(function2, function0, modifier, function22, function23, z11, menuItemColors, paddingValues, mutableInteractionSource, i11));
        }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
