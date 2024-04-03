package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/animation/ExitTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "exit", "Companion", "Landroidx/compose/animation/ExitTransitionImpl;", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ExitTransition {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ExitTransition None = new ExitTransitionImpl(new TransitionData((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, 15, (DefaultConstructorMarker) null));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/ExitTransition$Companion;", "", "()V", "None", "Landroidx/compose/animation/ExitTransition;", "getNone", "()Landroidx/compose/animation/ExitTransition;", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExitTransition getNone() {
            return ExitTransition.None;
        }
    }

    private ExitTransition() {
    }

    public /* synthetic */ ExitTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ExitTransition) && Intrinsics.areEqual((Object) ((ExitTransition) obj).getData$animation_release(), (Object) getData$animation_release());
    }

    @NotNull
    public abstract TransitionData getData$animation_release();

    public int hashCode() {
        return getData$animation_release().hashCode();
    }

    @NotNull
    @Stable
    public final ExitTransition plus(@NotNull ExitTransition exitTransition) {
        Intrinsics.checkNotNullParameter(exitTransition, "exit");
        Fade fade = getData$animation_release().getFade();
        if (fade == null) {
            fade = exitTransition.getData$animation_release().getFade();
        }
        Slide slide = getData$animation_release().getSlide();
        if (slide == null) {
            slide = exitTransition.getData$animation_release().getSlide();
        }
        ChangeSize changeSize = getData$animation_release().getChangeSize();
        if (changeSize == null) {
            changeSize = exitTransition.getData$animation_release().getChangeSize();
        }
        Scale scale = getData$animation_release().getScale();
        if (scale == null) {
            scale = exitTransition.getData$animation_release().getScale();
        }
        return new ExitTransitionImpl(new TransitionData(fade, slide, changeSize, scale));
    }
}
