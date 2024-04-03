package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0002H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0002H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableState;", "", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt {
    @NotNull
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
    @NotNull
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x034e  */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier createModifier(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r24, @org.jetbrains.annotations.NotNull androidx.compose.animation.EnterTransition r25, @org.jetbrains.annotations.NotNull androidx.compose.animation.ExitTransition r26, @org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29) {
        /*
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "enter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "exit"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 914000546(0x367a8aa2, float:3.7333598E-6)
            r12.startReplaceableGroup(r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.animation.TransitionData r1 = r25.getData$animation_release()
            androidx.compose.animation.Slide r1 = r1.getSlide()
            r2 = 0
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r2)
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.Slide r3 = r3.getSlide()
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r3, r12, r2)
            androidx.compose.ui.Modifier r0 = slideInOut(r0, r8, r1, r3, r11)
            androidx.compose.animation.TransitionData r1 = r25.getData$animation_release()
            androidx.compose.animation.ChangeSize r1 = r1.getChangeSize()
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r12, r2)
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.ChangeSize r3 = r3.getChangeSize()
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r3, r12, r2)
            androidx.compose.ui.Modifier r13 = shrinkExpand(r0, r8, r1, r3, r11)
            r14 = r29 & 14
            r0 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r0)
            boolean r1 = r12.changed((java.lang.Object) r8)
            java.lang.Object r3 = r28.rememberedValue()
            r15 = 2
            r7 = 0
            if (r1 != 0) goto L_0x007b
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0084
        L_0x007b:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r7, r15, r7)
            r12.updateRememberedValue(r3)
        L_0x0084:
            r28.endReplaceableGroup()
            r6 = r3
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r12.startReplaceableGroup(r0)
            boolean r0 = r12.changed((java.lang.Object) r8)
            java.lang.Object r1 = r28.rememberedValue()
            if (r0 != 0) goto L_0x009f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00a8
        L_0x009f:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r7, r15, r7)
            r12.updateRememberedValue(r1)
        L_0x00a8:
            r28.endReplaceableGroup()
            r5 = r1
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            java.lang.Object r0 = r24.getCurrentState()
            java.lang.Object r1 = r24.getTargetState()
            r4 = 1
            if (r0 != r1) goto L_0x00c6
            boolean r0 = r24.isSeeking()
            if (r0 != 0) goto L_0x00c6
            m52createModifier$lambda2(r6, r2)
            m54createModifier$lambda5(r5, r2)
            goto L_0x00f4
        L_0x00c6:
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            if (r0 != 0) goto L_0x00da
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Fade r0 = r0.getFade()
            if (r0 == 0) goto L_0x00dd
        L_0x00da:
            m52createModifier$lambda2(r6, r4)
        L_0x00dd:
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 != 0) goto L_0x00f1
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x00f4
        L_0x00f1:
            m54createModifier$lambda5(r5, r4)
        L_0x00f4:
            r0 = 1657240548(0x62c77be4, float:1.8399147E21)
            r12.startReplaceableGroup(r0)
            boolean r0 = m49createModifier$lambda1(r6)
            r3 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r16 = 458752(0x70000, float:6.42848E-40)
            r1 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r17 = 57344(0xe000, float:8.0356E-41)
            r15 = 3
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0228
            androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2
            r0.<init>(r9, r10)
            r12.startReplaceableGroup(r2)
            java.lang.Object r2 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r20.getEmpty()
            if (r2 != r7) goto L_0x0139
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            java.lang.String r7 = " alpha"
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r12.updateRememberedValue(r2)
        L_0x0139:
            r28.endReplaceableGroup()
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            r2 = r14 | 384(0x180, float:5.38E-43)
            r12.startReplaceableGroup(r3)
            kotlin.jvm.internal.FloatCompanionObject r20 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r20 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r20)
            r22 = r2 & 14
            int r2 = r2 << r15
            r3 = r2 & 896(0x380, float:1.256E-42)
            r3 = r22 | r3
            r15 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r15
            r2 = r2 & r17
            r2 = r2 | r3
            r12.startReplaceableGroup(r1)
            java.lang.Object r3 = r24.getCurrentState()
            androidx.compose.animation.EnterExitState r3 = (androidx.compose.animation.EnterExitState) r3
            r15 = 755689166(0x2d0ae6ce, float:7.895641E-12)
            r12.startReplaceableGroup(r15)
            int[] r23 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r23[r3]
            if (r3 == r4) goto L_0x019a
            r1 = 2
            if (r3 == r1) goto L_0x018b
            r1 = 3
            if (r3 != r1) goto L_0x0185
            androidx.compose.animation.TransitionData r1 = r26.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            if (r1 == 0) goto L_0x019a
            float r1 = r1.getAlpha()
            goto L_0x019c
        L_0x0185:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x018b:
            androidx.compose.animation.TransitionData r1 = r25.getData$animation_release()
            androidx.compose.animation.Fade r1 = r1.getFade()
            if (r1 == 0) goto L_0x019a
            float r1 = r1.getAlpha()
            goto L_0x019c
        L_0x019a:
            r1 = r18
        L_0x019c:
            r28.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r3 = r24.getTargetState()
            androidx.compose.animation.EnterExitState r3 = (androidx.compose.animation.EnterExitState) r3
            r12.startReplaceableGroup(r15)
            int r3 = r3.ordinal()
            r3 = r23[r3]
            if (r3 == r4) goto L_0x01de
            r15 = 2
            if (r3 == r15) goto L_0x01cf
            r15 = 3
            if (r3 != r15) goto L_0x01c9
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 == 0) goto L_0x01de
            float r3 = r3.getAlpha()
            goto L_0x01e0
        L_0x01c9:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01cf:
            androidx.compose.animation.TransitionData r3 = r25.getData$animation_release()
            androidx.compose.animation.Fade r3 = r3.getFade()
            if (r3 == 0) goto L_0x01de
            float r3 = r3.getAlpha()
            goto L_0x01e0
        L_0x01de:
            r3 = r18
        L_0x01e0:
            r28.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.animation.core.Transition$Segment r15 = r24.getSegment()
            int r23 = r2 >> 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r23)
            java.lang.Object r0 = r0.invoke(r15, r12, r4)
            r4 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4
            r0 = r2 & 14
            int r15 = r2 << 9
            r15 = r15 & r17
            r0 = r0 | r15
            int r2 = r2 << 6
            r2 = r2 & r16
            r15 = r0 | r2
            r0 = r24
            r2 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2 = r3
            r3 = r4
            r4 = r20
            r19 = r5
            r5 = r7
            r20 = r6
            r6 = r28
            r21 = 0
            r7 = r15
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r28.endReplaceableGroup()
            r28.endReplaceableGroup()
            goto L_0x0231
        L_0x0228:
            r8 = r2
            r19 = r5
            r20 = r6
            r21 = r7
            androidx.compose.runtime.MutableState<java.lang.Float> r0 = DefaultAlpha
        L_0x0231:
            r15 = r0
            r28.endReplaceableGroup()
            boolean r0 = m53createModifier$lambda4(r19)
            if (r0 == 0) goto L_0x04b5
            androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2
            r0.<init>(r9, r10)
            r12.startReplaceableGroup(r8)
            java.lang.Object r1 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0263
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r2 = " scale"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r12.updateRememberedValue(r1)
        L_0x0263:
            r28.endReplaceableGroup()
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r1 = r14 | 384(0x180, float:5.38E-43)
            r2 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r12.startReplaceableGroup(r2)
            kotlin.jvm.internal.FloatCompanionObject r2 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r4 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r2)
            r2 = r1 & 14
            r3 = 3
            int r1 = r1 << r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r1 = r1 & r17
            r1 = r1 | r2
            r8 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r8)
            java.lang.Object r2 = r24.getCurrentState()
            androidx.compose.animation.EnterExitState r2 = (androidx.compose.animation.EnterExitState) r2
            r3 = -596129937(0xffffffffdc77c76f, float:-2.78974395E17)
            r12.startReplaceableGroup(r3)
            int[] r11 = androidx.compose.animation.EnterExitTransitionKt.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r11[r2]
            r7 = 1
            if (r2 == r7) goto L_0x02cb
            r6 = 2
            if (r2 == r6) goto L_0x02bc
            r6 = 3
            if (r2 != r6) goto L_0x02b6
            androidx.compose.animation.TransitionData r2 = r26.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 == 0) goto L_0x02cb
            float r2 = r2.getScale()
            goto L_0x02cd
        L_0x02b6:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02bc:
            androidx.compose.animation.TransitionData r2 = r25.getData$animation_release()
            androidx.compose.animation.Scale r2 = r2.getScale()
            if (r2 == 0) goto L_0x02cb
            float r2 = r2.getScale()
            goto L_0x02cd
        L_0x02cb:
            r2 = r18
        L_0x02cd:
            r28.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r6 = r24.getTargetState()
            androidx.compose.animation.EnterExitState r6 = (androidx.compose.animation.EnterExitState) r6
            r12.startReplaceableGroup(r3)
            int r3 = r6.ordinal()
            r3 = r11[r3]
            if (r3 == r7) goto L_0x030e
            r6 = 2
            if (r3 == r6) goto L_0x0300
            r6 = 3
            if (r3 != r6) goto L_0x02fa
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x030e
            float r18 = r3.getScale()
            goto L_0x030e
        L_0x02fa:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0300:
            androidx.compose.animation.TransitionData r3 = r25.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x030e
            float r18 = r3.getScale()
        L_0x030e:
            r28.endReplaceableGroup()
            java.lang.Float r3 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r6 = r24.getSegment()
            int r18 = r1 >> 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r0.invoke(r6, r12, r7)
            r6 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r6 = (androidx.compose.animation.core.FiniteAnimationSpec) r6
            r0 = r1 & 14
            int r7 = r1 << 9
            r7 = r7 & r17
            r0 = r0 | r7
            int r1 = r1 << 6
            r1 = r1 & r16
            r7 = r0 | r1
            r0 = r24
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r28
            androidx.compose.runtime.State r7 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r28.endReplaceableGroup()
            r28.endReplaceableGroup()
            java.lang.Object r0 = r24.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r0 != r1) goto L_0x036c
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0361
        L_0x0358:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r0)
            goto L_0x038c
        L_0x0361:
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x038a
            goto L_0x0358
        L_0x036c:
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x037f
        L_0x0376:
            long r0 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r0)
            goto L_0x038c
        L_0x037f:
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x038a
            goto L_0x0376
        L_0x038a:
            r0 = r21
        L_0x038c:
            androidx.compose.animation.core.TwoWayConverter<androidx.compose.ui.graphics.TransformOrigin, androidx.compose.animation.core.AnimationVector2D> r4 = TransformOriginVectorConverter
            java.lang.String r5 = "TransformOriginInterruptionHandling"
            r1 = r14 | 3136(0xc40, float:4.394E-42)
            r12.startReplaceableGroup(r8)
            androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1 r2 = androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1.INSTANCE
            java.lang.Object r3 = r24.getCurrentState()
            androidx.compose.animation.EnterExitState r3 = (androidx.compose.animation.EnterExitState) r3
            r6 = -288165413(0xffffffffeed2f1db, float:-3.2642119E28)
            r12.startReplaceableGroup(r6)
            int r3 = r3.ordinal()
            r3 = r11[r3]
            r8 = 1
            if (r3 == r8) goto L_0x03f7
            r14 = 2
            if (r3 == r14) goto L_0x03d6
            r14 = 3
            if (r3 != r14) goto L_0x03d0
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x03c5
        L_0x03bc:
            long r18 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r3 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r18)
            goto L_0x03f8
        L_0x03c5:
            androidx.compose.animation.TransitionData r3 = r25.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x03f4
            goto L_0x03bc
        L_0x03d0:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x03d6:
            androidx.compose.animation.TransitionData r3 = r25.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x03e9
        L_0x03e0:
            long r18 = r3.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r3 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r18)
            goto L_0x03f8
        L_0x03e9:
            androidx.compose.animation.TransitionData r3 = r26.getData$animation_release()
            androidx.compose.animation.Scale r3 = r3.getScale()
            if (r3 == 0) goto L_0x03f4
            goto L_0x03e0
        L_0x03f4:
            r3 = r21
            goto L_0x03f8
        L_0x03f7:
            r3 = r0
        L_0x03f8:
            if (r3 == 0) goto L_0x03ff
            long r18 = r3.m3291unboximpl()
            goto L_0x0405
        L_0x03ff:
            androidx.compose.ui.graphics.TransformOrigin$Companion r3 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r18 = r3.m3292getCenterSzJe1aQ()
        L_0x0405:
            r28.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r3 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r18)
            java.lang.Object r14 = r24.getTargetState()
            androidx.compose.animation.EnterExitState r14 = (androidx.compose.animation.EnterExitState) r14
            r12.startReplaceableGroup(r6)
            int r6 = r14.ordinal()
            r6 = r11[r6]
            if (r6 == r8) goto L_0x0467
            r8 = 2
            if (r6 == r8) goto L_0x0447
            r0 = 3
            if (r6 != r0) goto L_0x0441
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0436
        L_0x042d:
            long r8 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r8)
            goto L_0x0467
        L_0x0436:
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0465
            goto L_0x042d
        L_0x0441:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0447:
            androidx.compose.animation.TransitionData r0 = r25.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x045a
        L_0x0451:
            long r8 = r0.m84getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r8)
            goto L_0x0467
        L_0x045a:
            androidx.compose.animation.TransitionData r0 = r26.getData$animation_release()
            androidx.compose.animation.Scale r0 = r0.getScale()
            if (r0 == 0) goto L_0x0465
            goto L_0x0451
        L_0x0465:
            r0 = r21
        L_0x0467:
            if (r0 == 0) goto L_0x046e
            long r8 = r0.m3291unboximpl()
            goto L_0x0474
        L_0x046e:
            androidx.compose.ui.graphics.TransformOrigin$Companion r0 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r8 = r0.m3292getCenterSzJe1aQ()
        L_0x0474:
            r28.endReplaceableGroup()
            androidx.compose.ui.graphics.TransformOrigin r6 = androidx.compose.ui.graphics.TransformOrigin.m3279boximpl(r8)
            androidx.compose.animation.core.Transition$Segment r0 = r24.getSegment()
            int r8 = r1 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object r0 = r2.invoke(r0, r12, r8)
            r8 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            r0 = r1 & 14
            int r2 = r1 << 9
            r2 = r2 & r17
            r0 = r0 | r2
            int r1 = r1 << 6
            r1 = r1 & r16
            r9 = r0 | r1
            r0 = r24
            r1 = r3
            r2 = r6
            r3 = r8
            r6 = r28
            r8 = r7
            r7 = r9
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r28.endReplaceableGroup()
            androidx.compose.animation.EnterExitTransitionKt$createModifier$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$1
            r1.<init>(r15, r8, r0)
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r13, r1)
            goto L_0x04c4
        L_0x04b5:
            boolean r0 = m49createModifier$lambda1(r20)
            if (r0 == 0) goto L_0x04c4
            androidx.compose.animation.EnterExitTransitionKt$createModifier$2 r0 = new androidx.compose.animation.EnterExitTransitionKt$createModifier$2
            r0.<init>(r15)
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r13, r0)
        L_0x04c4:
            r28.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* renamed from: createModifier$lambda-1  reason: not valid java name */
    private static final boolean m49createModifier$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-11  reason: not valid java name */
    public static final float m50createModifier$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-13  reason: not valid java name */
    public static final long m51createModifier$lambda13(State<TransformOrigin> state) {
        return state.getValue().m3291unboximpl();
    }

    /* renamed from: createModifier$lambda-2  reason: not valid java name */
    private static final void m52createModifier$lambda2(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* renamed from: createModifier$lambda-4  reason: not valid java name */
    private static final boolean m53createModifier$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* renamed from: createModifier$lambda-5  reason: not valid java name */
    private static final void m54createModifier$lambda5(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: createModifier$lambda-8  reason: not valid java name */
    public static final float m55createModifier$lambda8(State<Float> state) {
        return state.getValue().floatValue();
    }

    @NotNull
    @Stable
    public static final EnterTransition expandHorizontally(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment.Horizontal horizontal, boolean z11, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(horizontal, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialWidth");
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z11, new EnterExitTransitionKt$expandHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$expandHorizontally$1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z11, function1);
    }

    @NotNull
    @Stable
    public static final EnterTransition expandIn(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment alignment, boolean z11, @NotNull Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialSize");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z11), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$expandIn$1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z11, function1);
    }

    @NotNull
    @Stable
    public static final EnterTransition expandVertically(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment.Vertical vertical, boolean z11, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(vertical, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialHeight");
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z11, new EnterExitTransitionKt$expandVertically$2(function1));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$expandVertically$1.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z11, function1);
    }

    @NotNull
    @Stable
    public static final EnterTransition fadeIn(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f11) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f11, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f11);
    }

    @NotNull
    @Stable
    public static final ExitTransition fadeOut(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f11) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f11, finiteAnimationSpec), (Slide) null, (ChangeSize) null, (Scale) null, 14, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f11);
    }

    @ExperimentalAnimationApi
    @Stable
    @NotNull
    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m56scaleInL8ZKhE(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f11, long j11) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f11, j11, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m57scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f11, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            j11 = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        }
        return m56scaleInL8ZKhE(finiteAnimationSpec, f11, j11);
    }

    @ExperimentalAnimationApi
    @Stable
    @NotNull
    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m58scaleOutL8ZKhE(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f11, long j11) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, new Scale(f11, j11, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, (DefaultConstructorMarker) null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m59scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f11, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i11 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            j11 = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        }
        return m58scaleOutL8ZKhE(finiteAnimationSpec, f11, j11);
    }

    private static final Modifier shrinkExpand(Modifier modifier, Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new EnterExitTransitionKt$shrinkExpand$1(transition, state, state2, str), 1, (Object) null);
    }

    @NotNull
    @Stable
    public static final ExitTransition shrinkHorizontally(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment.Horizontal horizontal, boolean z11, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(horizontal, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetWidth");
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z11, new EnterExitTransitionKt$shrinkHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkHorizontally$1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z11, function1);
    }

    @NotNull
    @Stable
    public static final ExitTransition shrinkOut(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment alignment, boolean z11, @NotNull Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetSize");
        return new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, new ChangeSize(alignment, function1, finiteAnimationSpec, z11), (Scale) null, 11, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkOut$1.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z11, function1);
    }

    @NotNull
    @Stable
    public static final ExitTransition shrinkVertically(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment.Vertical vertical, boolean z11, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(vertical, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetHeight");
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z11, new EnterExitTransitionKt$shrinkVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5630boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        if ((i11 & 8) != 0) {
            function1 = EnterExitTransitionKt$shrinkVertically$1.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z11, function1);
    }

    @NotNull
    @Stable
    public static final EnterTransition slideIn(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        return new EnterTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    @NotNull
    @Stable
    public static final EnterTransition slideInHorizontally(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetX");
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInHorizontally$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInHorizontally$1.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    private static final Modifier slideInOut(Modifier modifier, Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new EnterExitTransitionKt$slideInOut$1(transition, state, state2, str), 1, (Object) null);
    }

    @NotNull
    @Stable
    public static final EnterTransition slideInVertically(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetY");
        return slideIn(finiteAnimationSpec, new EnterExitTransitionKt$slideInVertically$2(function1));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            function1 = EnterExitTransitionKt$slideInVertically$1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    @NotNull
    @Stable
    public static final ExitTransition slideOut(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        return new ExitTransitionImpl(new TransitionData((Fade) null, new Slide(function1, finiteAnimationSpec), (ChangeSize) null, (Scale) null, 13, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    @NotNull
    @Stable
    public static final ExitTransition slideOutHorizontally(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetX");
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutHorizontally$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutHorizontally$1.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    @NotNull
    @Stable
    public static final ExitTransition slideOutVertically(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetY");
        return slideOut(finiteAnimationSpec, new EnterExitTransitionKt$slideOutVertically$2(function1));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i11 & 2) != 0) {
            function1 = EnterExitTransitionKt$slideOutVertically$1.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual((Object) horizontal, (Object) companion.getStart())) {
            return companion.getCenterStart();
        }
        if (Intrinsics.areEqual((Object) horizontal, (Object) companion.getEnd())) {
            return companion.getCenterEnd();
        }
        return companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual((Object) vertical, (Object) companion.getTop())) {
            return companion.getTopCenter();
        }
        if (Intrinsics.areEqual((Object) vertical, (Object) companion.getBottom())) {
            return companion.getBottomCenter();
        }
        return companion.getCenter();
    }
}
