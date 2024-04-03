package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ExitUntilCollapsedScrollBehavior;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function0;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "isPinned", "()Z", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setNestedScrollConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getState", "()Landroidx/compose/material3/TopAppBarState;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ExitUntilCollapsedScrollBehavior implements TopAppBarScrollBehavior {
    @NotNull
    private final Function0<Boolean> canScroll;
    @Nullable
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final boolean isPinned;
    @NotNull
    private NestedScrollConnection nestedScrollConnection;
    @Nullable
    private final AnimationSpec<Float> snapAnimationSpec;
    @NotNull
    private final TopAppBarState state;

    public ExitUntilCollapsedScrollBehavior(@NotNull TopAppBarState topAppBarState, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(topAppBarState, "state");
        Intrinsics.checkNotNullParameter(function0, "canScroll");
        this.state = topAppBarState;
        this.snapAnimationSpec = animationSpec;
        this.flingAnimationSpec = decayAnimationSpec;
        this.canScroll = function0;
        this.nestedScrollConnection = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(this);
    }

    @NotNull
    public final Function0<Boolean> getCanScroll() {
        return this.canScroll;
    }

    @Nullable
    public DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @NotNull
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    @Nullable
    public AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @NotNull
    public TopAppBarState getState() {
        return this.state;
    }

    public boolean isPinned() {
        return this.isPinned;
    }

    public void setNestedScrollConnection(@NotNull NestedScrollConnection nestedScrollConnection2) {
        Intrinsics.checkNotNullParameter(nestedScrollConnection2, "<set-?>");
        this.nestedScrollConnection = nestedScrollConnection2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(topAppBarState, animationSpec, decayAnimationSpec, (i11 & 8) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
