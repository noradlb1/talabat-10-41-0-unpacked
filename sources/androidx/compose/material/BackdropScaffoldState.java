package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Stable
@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/BackdropValue;", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;)V", "isConcealed", "()Z", "isRevealed", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "conceal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reveal", "Companion", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldState extends SwipeableState<BackdropValue> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final NestedScrollConnection nestedScrollConnection;
    @NotNull
    private final SnackbarHostState snackbarHostState;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BackdropScaffoldState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BackdropValue;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<BackdropScaffoldState, ?> Saver(@NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super BackdropValue, Boolean> function1, @NotNull SnackbarHostState snackbarHostState) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
            return SaverKt.Saver(BackdropScaffoldState$Companion$Saver$1.INSTANCE, new BackdropScaffoldState$Companion$Saver$2(animationSpec, function1, snackbarHostState));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(backdropValue, (i11 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function1, (i11 & 8) != 0 ? new SnackbarHostState() : snackbarHostState2);
    }

    @Nullable
    public final Object conceal(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Concealed, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    @NotNull
    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final boolean isConcealed() {
        return getCurrentValue() == BackdropValue.Concealed;
    }

    public final boolean isRevealed() {
        return getCurrentValue() == BackdropValue.Revealed;
    }

    @Nullable
    public final Object reveal(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Revealed, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState(@NotNull BackdropValue backdropValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super BackdropValue, Boolean> function1, @NotNull SnackbarHostState snackbarHostState2) {
        super(backdropValue, animationSpec, function1);
        Intrinsics.checkNotNullParameter(backdropValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        Intrinsics.checkNotNullParameter(snackbarHostState2, "snackbarHostState");
        this.snackbarHostState = snackbarHostState2;
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
