package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Bt\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010(J)\u0010+\u001a\u00020,*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R*\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR1\u0010\u001d\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001e¢\u0006\u0002\b!ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/animation/ExpandShrinkModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getAlignment", "()Landroidx/compose/runtime/State;", "currentAlignment", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getExpand", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getShrink", "getSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    @NotNull
    private final State<Alignment> alignment;
    @Nullable
    private Alignment currentAlignment;
    @NotNull
    private final State<ChangeSize> expand;
    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    @NotNull
    private final State<ChangeSize> shrink;
    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    @NotNull
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new ExpandShrinkModifier$sizeTransitionSpec$1(this);

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

    public ExpandShrinkModifier(@NotNull Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, @NotNull Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, @NotNull State<ChangeSize> state, @NotNull State<ChangeSize> state2, @NotNull State<? extends Alignment> state3) {
        Intrinsics.checkNotNullParameter(deferredAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(deferredAnimation2, "offsetAnimation");
        Intrinsics.checkNotNullParameter(state, "expand");
        Intrinsics.checkNotNullParameter(state2, "shrink");
        Intrinsics.checkNotNullParameter(state3, "alignment");
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.expand = state;
        this.shrink = state2;
        this.alignment = state3;
    }

    @NotNull
    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    @NotNull
    public final State<ChangeSize> getExpand() {
        return this.expand;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    @NotNull
    public final State<ChangeSize> getShrink() {
        return this.shrink;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    @NotNull
    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m76measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        long j12;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable r42 = measurable.m4508measureBRTryo0(j11);
        long IntSize = IntSizeKt.IntSize(r42.getWidth(), r42.getHeight());
        long r11 = this.sizeAnimation.animate(this.sizeTransitionSpec, new ExpandShrinkModifier$measure$currentSize$1(this, IntSize)).getValue().m5642unboximpl();
        long r13 = this.offsetAnimation.animate(ExpandShrinkModifier$measure$offsetDelta$1.INSTANCE, new ExpandShrinkModifier$measure$offsetDelta$2(this, IntSize)).getValue().m5605unboximpl();
        Alignment alignment2 = this.currentAlignment;
        if (alignment2 != null) {
            j12 = alignment2.m2554alignKFBX0sM(IntSize, r11, LayoutDirection.Ltr);
        } else {
            j12 = IntOffset.Companion.m5606getZeronOccac();
        }
        return MeasureScope.CC.p(measureScope, IntSize.m5638getWidthimpl(r11), IntSize.m5637getHeightimpl(r11), (Map) null, new ExpandShrinkModifier$measure$1(r42, j12, r13), 4, (Object) null);
    }

    public final void setCurrentAlignment(@Nullable Alignment alignment2) {
        this.currentAlignment = alignment2;
    }

    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    public final long m77sizeByStateUzc_VyU(@NotNull EnterExitState enterExitState, long j11) {
        long j12;
        long j13;
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        ChangeSize value = this.expand.getValue();
        if (value != null) {
            j12 = value.getSize().invoke(IntSize.m5630boximpl(j11)).m5642unboximpl();
        } else {
            j12 = j11;
        }
        ChangeSize value2 = this.shrink.getValue();
        if (value2 != null) {
            j13 = value2.getSize().invoke(IntSize.m5630boximpl(j11)).m5642unboximpl();
        } else {
            j13 = j11;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i11 == 1) {
            return j11;
        }
        if (i11 == 2) {
            return j12;
        }
        if (i11 == 3) {
            return j13;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m78targetOffsetByStateoFUgxo0(@NotNull EnterExitState enterExitState, long j11) {
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m5606getZeronOccac();
        }
        if (this.alignment.getValue() == null) {
            return IntOffset.Companion.m5606getZeronOccac();
        }
        if (Intrinsics.areEqual((Object) this.currentAlignment, (Object) this.alignment.getValue())) {
            return IntOffset.Companion.m5606getZeronOccac();
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i11 == 1) {
            return IntOffset.Companion.m5606getZeronOccac();
        }
        if (i11 == 2) {
            return IntOffset.Companion.m5606getZeronOccac();
        }
        if (i11 == 3) {
            ChangeSize value = this.shrink.getValue();
            if (value == null) {
                return IntOffset.Companion.m5606getZeronOccac();
            }
            long r62 = value.getSize().invoke(IntSize.m5630boximpl(j11)).m5642unboximpl();
            Alignment value2 = this.alignment.getValue();
            Intrinsics.checkNotNull(value2);
            long j12 = j11;
            long j13 = r62;
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            long r82 = value2.m2554alignKFBX0sM(j12, j13, layoutDirection);
            Alignment alignment2 = this.currentAlignment;
            Intrinsics.checkNotNull(alignment2);
            long r11 = alignment2.m2554alignKFBX0sM(j12, j13, layoutDirection);
            return IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r82) - IntOffset.m5596getXimpl(r11), IntOffset.m5597getYimpl(r82) - IntOffset.m5597getYimpl(r11));
        }
        throw new NoWhenBranchMatchedException();
    }
}
