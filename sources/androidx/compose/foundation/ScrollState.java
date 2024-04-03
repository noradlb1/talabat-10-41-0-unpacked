package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00032\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016JB\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2'\u0010*\u001a#\b\u0001\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0-\u0012\u0006\u0012\u0004\u0018\u00010.0+¢\u0006\u0002\b/H@ø\u0001\u0000¢\u0006\u0002\u00100J\u0019\u00101\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u00102R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038F@@X\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0004R\u000e\u0010\u0019\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initial", "", "(I)V", "_maxValueState", "Landroidx/compose/runtime/MutableState;", "accumulator", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "", "()Z", "newMax", "maxValue", "getMaxValue", "()I", "setMaxValue$foundation_release", "scrollableState", "<set-?>", "value", "getValue", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableState;", "animateScrollTo", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class ScrollState implements ScrollableState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<ScrollState, ?> Saver = SaverKt.Saver(ScrollState$Companion$Saver$1.INSTANCE, ScrollState$Companion$Saver$2.INSTANCE);
    @NotNull
    private MutableState<Integer> _maxValueState = SnapshotStateKt.mutableStateOf(Integer.MAX_VALUE, SnapshotStateKt.structuralEqualityPolicy());
    /* access modifiers changed from: private */
    public float accumulator;
    @NotNull
    private final MutableInteractionSource internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
    @NotNull
    private final ScrollableState scrollableState = ScrollableStateKt.ScrollableState(new ScrollState$scrollableState$1(this));
    @NotNull
    private final MutableState value$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/ScrollState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<ScrollState, ?> getSaver() {
            return ScrollState.Saver;
        }
    }

    public ScrollState(int i11) {
        this.value$delegate = SnapshotStateKt.mutableStateOf(Integer.valueOf(i11), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object animateScrollTo$default(androidx.compose.foundation.ScrollState r6, int r7, androidx.compose.animation.core.AnimationSpec r8, kotlin.coroutines.Continuation r9, int r10, java.lang.Object r11) {
        /*
            r10 = r10 & 2
            if (r10 == 0) goto L_0x000f
            androidx.compose.animation.core.SpringSpec r8 = new androidx.compose.animation.core.SpringSpec
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x000f:
            java.lang.Object r6 = r6.animateScrollTo(r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ScrollState.animateScrollTo$default(androidx.compose.foundation.ScrollState, int, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void setValue(int i11) {
        this.value$delegate.setValue(Integer.valueOf(i11));
    }

    @Nullable
    public final Object animateScrollTo(int i11, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollBy = ScrollExtensionsKt.animateScrollBy(this, (float) (i11 - getValue()), animationSpec, continuation);
        return animateScrollBy == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy : Unit.INSTANCE;
    }

    public float dispatchRawDelta(float f11) {
        return this.scrollableState.dispatchRawDelta(f11);
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final int getMaxValue() {
        return this._maxValueState.getValue().intValue();
    }

    public final int getValue() {
        return ((Number) this.value$delegate.getValue()).intValue();
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Nullable
    public Object scroll(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, function2, continuation);
        return scroll == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    @Nullable
    public final Object scrollTo(int i11, @NotNull Continuation<? super Float> continuation) {
        return ScrollExtensionsKt.scrollBy(this, (float) (i11 - getValue()), continuation);
    }

    public final void setMaxValue$foundation_release(int i11) {
        this._maxValueState.setValue(Integer.valueOf(i11));
        if (getValue() > i11) {
            setValue(i11);
        }
    }
}
