package androidx.compose.animation;

import a0.a;
import a0.b;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003UVWB%\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0004\b>\u0010?JP\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002002\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u0002060D2#\b\u0002\u0010E\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020G0Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJP\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u0002002\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u0002060D2#\b\u0002\u0010O\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020G0Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020=*\u00020=2\b\u0010S\u001a\u0004\u0018\u00010TH\u0004R%\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\f8BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f8@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R)\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0'X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/*\u0002008BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b1\u00102R\u001b\u00103\u001a\u00020/*\u0002008BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u00102\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/animation/AnimatedContentScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "transition", "Landroidx/compose/animation/core/Transition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "animatedSize", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/IntSize;", "getAnimatedSize$animation_release", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation_release", "(Landroidx/compose/runtime/State;)V", "getContentAlignment$animation_release", "()Landroidx/compose/ui/Alignment;", "setContentAlignment$animation_release", "(Landroidx/compose/ui/Alignment;)V", "currentSize", "getCurrentSize-YbymL2g", "()J", "initialState", "getInitialState", "()Ljava/lang/Object;", "getLayoutDirection$animation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "measuredSize", "getMeasuredSize-YbymL2g$animation_release", "setMeasuredSize-ozmzZPI$animation_release", "(J)V", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "targetSizeMap", "", "getTargetSizeMap$animation_release", "()Ljava/util/Map;", "targetState", "getTargetState", "getTransition$animation_release", "()Landroidx/compose/animation/core/Transition;", "isLeft", "", "Landroidx/compose/animation/AnimatedContentScope$SlideDirection;", "isLeft-9jb1Dl8", "(I)Z", "isRight", "isRight-9jb1Dl8", "calculateOffset", "Landroidx/compose/ui/unit/IntOffset;", "fullSize", "calculateOffset-emnUabE", "(JJ)J", "createSizeAnimationModifier", "Landroidx/compose/ui/Modifier;", "contentTransform", "Landroidx/compose/animation/ContentTransform;", "createSizeAnimationModifier$animation_release", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-HTTW7Ok", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-HTTW7Ok", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "ChildData", "SizeModifier", "SlideDirection", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentScope<S> implements Transition.Segment<S> {
    public static final int $stable = 8;
    @Nullable
    private State<IntSize> animatedSize;
    @NotNull
    private Alignment contentAlignment;
    @NotNull
    private LayoutDirection layoutDirection;
    @NotNull
    private final MutableState measuredSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m5630boximpl(IntSize.Companion.m5643getZeroYbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final Map<S, State<IntSize>> targetSizeMap = new LinkedHashMap();
    @NotNull
    private final Transition<S> transition;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0016\u0010\u0010\u001a\u00020\u000b*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/AnimatedContentScope$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "(Z)V", "()Z", "setTarget", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ChildData implements ParentDataModifier {
        private boolean isTarget;

        public ChildData(boolean z11) {
            this.isTarget = z11;
        }

        public static /* synthetic */ ChildData copy$default(ChildData childData, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = childData.isTarget;
            }
            return childData.copy(z11);
        }

        public /* synthetic */ boolean all(Function1 function1) {
            return b.a(this, function1);
        }

        public /* synthetic */ boolean any(Function1 function1) {
            return b.b(this, function1);
        }

        public final boolean component1() {
            return this.isTarget;
        }

        @NotNull
        public final ChildData copy(boolean z11) {
            return new ChildData(z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChildData) && this.isTarget == ((ChildData) obj).isTarget;
        }

        public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
            return b.c(this, obj, function2);
        }

        public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
            return b.d(this, obj, function2);
        }

        public int hashCode() {
            boolean z11 = this.isTarget;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public final boolean isTarget() {
            return this.isTarget;
        }

        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return this;
        }

        public final void setTarget(boolean z11) {
            this.isTarget = z11;
        }

        public /* synthetic */ Modifier then(Modifier modifier) {
            return a.a(this, modifier);
        }

        @NotNull
        public String toString() {
            return "ChildData(isTarget=" + this.isTarget + ')';
        }
    }

    @ExperimentalAnimationApi
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B6\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/AnimatedContentScope$SizeModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/compose/animation/AnimatedContentScope;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AnimatedContentScope<S> f1094b;
        @NotNull
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        @NotNull
        private final State<SizeTransform> sizeTransform;

        public SizeModifier(@NotNull AnimatedContentScope animatedContentScope, @NotNull Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, State<? extends SizeTransform> state) {
            Intrinsics.checkNotNullParameter(deferredAnimation, "sizeAnimation");
            Intrinsics.checkNotNullParameter(state, "sizeTransform");
            this.f1094b = animatedContentScope;
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = state;
        }

        @NotNull
        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        @NotNull
        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @NotNull
        /* renamed from: measure-3p2s80s  reason: not valid java name */
        public MeasureResult m25measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            Placeable r13 = measurable.m4508measureBRTryo0(j11);
            State<IntSize> animate = this.sizeAnimation.animate(new AnimatedContentScope$SizeModifier$measure$size$1(this.f1094b, this), new AnimatedContentScope$SizeModifier$measure$size$2(this.f1094b));
            this.f1094b.setAnimatedSize$animation_release(animate);
            return MeasureScope.CC.p(measureScope, IntSize.m5638getWidthimpl(animate.getValue().m5642unboximpl()), IntSize.m5637getHeightimpl(animate.getValue().m5642unboximpl()), (Map) null, new AnimatedContentScope$SizeModifier$measure$1(r13, this.f1094b.getContentAlignment$animation_release().m2554alignKFBX0sM(IntSizeKt.IntSize(r13.getWidth(), r13.getHeight()), animate.getValue().m5642unboximpl(), LayoutDirection.Ltr)), 4, (Object) null);
        }
    }

    @Immutable
    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SlideDirection {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Down = m28constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int End = m28constructorimpl(5);
        /* access modifiers changed from: private */
        public static final int Left = m28constructorimpl(0);
        /* access modifiers changed from: private */
        public static final int Right = m28constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Start = m28constructorimpl(4);
        /* access modifiers changed from: private */
        public static final int Up = m28constructorimpl(2);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentScope$SlideDirection$Companion;", "", "()V", "Down", "Landroidx/compose/animation/AnimatedContentScope$SlideDirection;", "getDown-aUPqQNE", "()I", "I", "End", "getEnd-aUPqQNE", "Left", "getLeft-aUPqQNE", "Right", "getRight-aUPqQNE", "Start", "getStart-aUPqQNE", "Up", "getUp-aUPqQNE", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDown-aUPqQNE  reason: not valid java name */
            public final int m34getDownaUPqQNE() {
                return SlideDirection.Down;
            }

            /* renamed from: getEnd-aUPqQNE  reason: not valid java name */
            public final int m35getEndaUPqQNE() {
                return SlideDirection.End;
            }

            /* renamed from: getLeft-aUPqQNE  reason: not valid java name */
            public final int m36getLeftaUPqQNE() {
                return SlideDirection.Left;
            }

            /* renamed from: getRight-aUPqQNE  reason: not valid java name */
            public final int m37getRightaUPqQNE() {
                return SlideDirection.Right;
            }

            /* renamed from: getStart-aUPqQNE  reason: not valid java name */
            public final int m38getStartaUPqQNE() {
                return SlideDirection.Start;
            }

            /* renamed from: getUp-aUPqQNE  reason: not valid java name */
            public final int m39getUpaUPqQNE() {
                return SlideDirection.Up;
            }
        }

        private /* synthetic */ SlideDirection(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ SlideDirection m27boximpl(int i11) {
            return new SlideDirection(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m28constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m29equalsimpl(int i11, Object obj) {
            return (obj instanceof SlideDirection) && i11 == ((SlideDirection) obj).m33unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m30equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m31hashCodeimpl(int i11) {
            return i11;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m32toStringimpl(int i11) {
            if (m30equalsimpl0(i11, Left)) {
                return "Left";
            }
            if (m30equalsimpl0(i11, Right)) {
                return "Right";
            }
            if (m30equalsimpl0(i11, Up)) {
                return "Up";
            }
            if (m30equalsimpl0(i11, Down)) {
                return "Down";
            }
            if (m30equalsimpl0(i11, Start)) {
                return "Start";
            }
            if (m30equalsimpl0(i11, End)) {
                return "End";
            }
            return "Invalid";
        }

        public boolean equals(Object obj) {
            return m29equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m31hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m32toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m33unboximpl() {
            return this.value;
        }
    }

    public AnimatedContentScope(@NotNull Transition<S> transition2, @NotNull Alignment alignment, @NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(transition2, "transition");
        Intrinsics.checkNotNullParameter(alignment, "contentAlignment");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        this.transition = transition2;
        this.contentAlignment = alignment;
        this.layoutDirection = layoutDirection2;
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateOffset-emnUabE  reason: not valid java name */
    public final long m13calculateOffsetemnUabE(long j11, long j12) {
        return this.contentAlignment.m2554alignKFBX0sM(j11, j12, LayoutDirection.Ltr);
    }

    /* renamed from: createSizeAnimationModifier$lambda-2  reason: not valid java name */
    private static final boolean m14createSizeAnimationModifier$lambda2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* renamed from: createSizeAnimationModifier$lambda-3  reason: not valid java name */
    private static final void m15createSizeAnimationModifier$lambda3(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: getCurrentSize-YbymL2g  reason: not valid java name */
    public final long m16getCurrentSizeYbymL2g() {
        State<IntSize> state = this.animatedSize;
        return state != null ? state.getValue().m5642unboximpl() : m21getMeasuredSizeYbymL2g$animation_release();
    }

    /* renamed from: isLeft-9jb1Dl8  reason: not valid java name */
    private final boolean m17isLeft9jb1Dl8(int i11) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        if (SlideDirection.m30equalsimpl0(i11, companion.m36getLeftaUPqQNE()) || ((SlideDirection.m30equalsimpl0(i11, companion.m38getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr) || (SlideDirection.m30equalsimpl0(i11, companion.m35getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl))) {
            return true;
        }
        return false;
    }

    /* renamed from: isRight-9jb1Dl8  reason: not valid java name */
    private final boolean m18isRight9jb1Dl8(int i11) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        if (SlideDirection.m30equalsimpl0(i11, companion.m37getRightaUPqQNE()) || ((SlideDirection.m30equalsimpl0(i11, companion.m38getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl) || (SlideDirection.m30equalsimpl0(i11, companion.m35getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr))) {
            return true;
        }
        return false;
    }

    /* renamed from: slideIntoContainer-HTTW7Ok$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m19slideIntoContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i11, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
        }
        if ((i12 & 4) != 0) {
            function1 = AnimatedContentScope$slideIntoContainer$1.INSTANCE;
        }
        return animatedContentScope.m23slideIntoContainerHTTW7Ok(i11, finiteAnimationSpec, function1);
    }

    /* renamed from: slideOutOfContainer-HTTW7Ok$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m20slideOutOfContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i11, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, (Object) null);
        }
        if ((i12 & 4) != 0) {
            function1 = AnimatedContentScope$slideOutOfContainer$1.INSTANCE;
        }
        return animatedContentScope.m24slideOutOfContainerHTTW7Ok(i11, finiteAnimationSpec, function1);
    }

    @NotNull
    @Composable
    public final Modifier createSizeAnimationModifier$animation_release(@NotNull ContentTransform contentTransform, @Nullable Composer composer, int i11) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(contentTransform, "contentTransform");
        composer.startReplaceableGroup(-1349251863);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) this);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        boolean z11 = false;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (Intrinsics.areEqual((Object) this.transition.getCurrentState(), (Object) this.transition.getTargetState())) {
            m15createSizeAnimationModifier$lambda3(mutableState, false);
        } else if (rememberUpdatedState.getValue() != null) {
            m15createSizeAnimationModifier$lambda3(mutableState, true);
        }
        if (m14createSizeAnimationModifier$lambda2(mutableState)) {
            Transition.DeferredAnimation<IntSize, AnimationVector2D> createDeferredAnimation = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), (String) null, composer, 64, 2);
            composer.startReplaceableGroup(1157296644);
            boolean changed2 = composer.changed((Object) createDeferredAnimation);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                SizeTransform sizeTransform = (SizeTransform) rememberUpdatedState.getValue();
                if (sizeTransform != null && !sizeTransform.getClip()) {
                    z11 = true;
                }
                Modifier modifier2 = Modifier.Companion;
                if (!z11) {
                    modifier2 = ClipKt.clipToBounds(modifier2);
                }
                rememberedValue2 = modifier2.then(new SizeModifier(this, createDeferredAnimation, rememberUpdatedState));
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            modifier = (Modifier) rememberedValue2;
        } else {
            this.animatedSize = null;
            modifier = Modifier.Companion;
        }
        composer.endReplaceableGroup();
        return modifier;
    }

    @Nullable
    public final State<IntSize> getAnimatedSize$animation_release() {
        return this.animatedSize;
    }

    @NotNull
    public final Alignment getContentAlignment$animation_release() {
        return this.contentAlignment;
    }

    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection$animation_release() {
        return this.layoutDirection;
    }

    /* renamed from: getMeasuredSize-YbymL2g$animation_release  reason: not valid java name */
    public final long m21getMeasuredSizeYbymL2g$animation_release() {
        return ((IntSize) this.measuredSize$delegate.getValue()).m5642unboximpl();
    }

    @NotNull
    public final Map<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    @NotNull
    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
        return c.a(this, obj, obj2);
    }

    public final void setAnimatedSize$animation_release(@Nullable State<IntSize> state) {
        this.animatedSize = state;
    }

    public final void setContentAlignment$animation_release(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.contentAlignment = alignment;
    }

    public final void setLayoutDirection$animation_release(@NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    /* renamed from: setMeasuredSize-ozmzZPI$animation_release  reason: not valid java name */
    public final void m22setMeasuredSizeozmzZPI$animation_release(long j11) {
        this.measuredSize$delegate.setValue(IntSize.m5630boximpl(j11));
    }

    @NotNull
    /* renamed from: slideIntoContainer-HTTW7Ok  reason: not valid java name */
    public final EnterTransition m23slideIntoContainerHTTW7Ok(int i11, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        if (m17isLeft9jb1Dl8(i11)) {
            return EnterExitTransitionKt.slideInHorizontally(finiteAnimationSpec, new AnimatedContentScope$slideIntoContainer$2(function1, this));
        }
        if (m18isRight9jb1Dl8(i11)) {
            return EnterExitTransitionKt.slideInHorizontally(finiteAnimationSpec, new AnimatedContentScope$slideIntoContainer$3(function1, this));
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        if (SlideDirection.m30equalsimpl0(i11, companion.m39getUpaUPqQNE())) {
            return EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new AnimatedContentScope$slideIntoContainer$4(function1, this));
        }
        if (SlideDirection.m30equalsimpl0(i11, companion.m34getDownaUPqQNE())) {
            return EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new AnimatedContentScope$slideIntoContainer$5(function1, this));
        }
        return EnterTransition.Companion.getNone();
    }

    @NotNull
    /* renamed from: slideOutOfContainer-HTTW7Ok  reason: not valid java name */
    public final ExitTransition m24slideOutOfContainerHTTW7Ok(int i11, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        if (m17isLeft9jb1Dl8(i11)) {
            return EnterExitTransitionKt.slideOutHorizontally(finiteAnimationSpec, new AnimatedContentScope$slideOutOfContainer$2(this, function1));
        }
        if (m18isRight9jb1Dl8(i11)) {
            return EnterExitTransitionKt.slideOutHorizontally(finiteAnimationSpec, new AnimatedContentScope$slideOutOfContainer$3(this, function1));
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        if (SlideDirection.m30equalsimpl0(i11, companion.m39getUpaUPqQNE())) {
            return EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new AnimatedContentScope$slideOutOfContainer$4(this, function1));
        }
        if (SlideDirection.m30equalsimpl0(i11, companion.m34getDownaUPqQNE())) {
            return EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new AnimatedContentScope$slideOutOfContainer$5(this, function1));
        }
        return ExitTransition.Companion.getNone();
    }

    @NotNull
    @ExperimentalAnimationApi
    public final ContentTransform using(@NotNull ContentTransform contentTransform, @Nullable SizeTransform sizeTransform) {
        Intrinsics.checkNotNullParameter(contentTransform, "<this>");
        contentTransform.setSizeTransform$animation_release(sizeTransform);
        return contentTransform;
    }
}
