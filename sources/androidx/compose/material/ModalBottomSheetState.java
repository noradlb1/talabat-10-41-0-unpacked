package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB5\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0011\u0010\u001c\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001d\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0014\u0010\r\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/ModalBottomSheetValue;", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "isSkipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;)V", "hasHalfExpandedState", "getHasHalfExpandedState$material_release", "()Z", "isSkipHalfExpanded$material_release", "isVisible", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "expand", "", "expand$material_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material_release", "hide", "show", "Companion", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetState extends SwipeableState<ModalBottomSheetValue> {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isSkipHalfExpanded;
    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007J:\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<ModalBottomSheetState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, boolean z11, @NotNull Function1<? super ModalBottomSheetValue, Boolean> function1) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return SaverKt.Saver(ModalBottomSheetState$Companion$Saver$1.INSTANCE, new ModalBottomSheetState$Companion$Saver$2(animationSpec, z11, function1));
        }

        @NotNull
        @Deprecated(message = "Please specify the skipHalfExpanded parameter", replaceWith = @ReplaceWith(expression = "ModalBottomSheetState.Saver(animationSpec = animationSpec,skipHalfExpanded = ,confirmStateChange = confirmStateChange)", imports = {}))
        public final Saver<ModalBottomSheetState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super ModalBottomSheetValue, Boolean> function1) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return Saver(animationSpec, false, function1);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, boolean z11, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(modalBottomSheetValue, (i11 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, z11, (i11 & 8) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    @Nullable
    public final Object expand$material_release(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.Expanded, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return getAnchors$material_release().values().contains(ModalBottomSheetValue.HalfExpanded);
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    @Nullable
    public final Object halfExpand$material_release(@NotNull Continuation<? super Unit> continuation) {
        if (!getHasHalfExpandedState$material_release()) {
            return Unit.INSTANCE;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.HalfExpanded, (AnimationSpec) null, continuation, 2, (Object) null);
        if (animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo$default;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object hide(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, ModalBottomSheetValue.Hidden, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final boolean isSkipHalfExpanded$material_release() {
        return this.isSkipHalfExpanded;
    }

    public final boolean isVisible() {
        return getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    @Nullable
    public final Object show(@NotNull Continuation<? super Unit> continuation) {
        ModalBottomSheetValue modalBottomSheetValue;
        if (getHasHalfExpandedState$material_release()) {
            modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
        } else {
            modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this, modalBottomSheetValue, (AnimationSpec) null, continuation, 2, (Object) null);
        if (animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo$default;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState(@NotNull ModalBottomSheetValue modalBottomSheetValue, @NotNull AnimationSpec<Float> animationSpec, boolean z11, @NotNull Function1<? super ModalBottomSheetValue, Boolean> function1) {
        super(modalBottomSheetValue, animationSpec, function1);
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.isSkipHalfExpanded = z11;
        if (z11) {
            if (!(modalBottomSheetValue != ModalBottomSheetValue.HalfExpanded)) {
                throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
            }
        }
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(modalBottomSheetValue, (i11 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i11 & 4) != 0 ? AnonymousClass2.INSTANCE : function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState(@NotNull ModalBottomSheetValue modalBottomSheetValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super ModalBottomSheetValue, Boolean> function1) {
        this(modalBottomSheetValue, animationSpec, false, function1);
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
    }
}
