package coil.transition;

import coil.annotation.ExperimentalCoilApi;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcoil/transition/NoneTransition;", "Lcoil/transition/Transition;", "()V", "toString", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalCoilApi
public final class NoneTransition implements Transition {
    @NotNull
    public static final NoneTransition INSTANCE = new NoneTransition();

    private NoneTransition() {
    }

    @NotNull
    public String toString() {
        return "coil.transition.NoneTransition";
    }

    @Nullable
    public Object transition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult, @NotNull Continuation<? super Unit> continuation) {
        if (imageResult instanceof SuccessResult) {
            transitionTarget.onSuccess(((SuccessResult) imageResult).getDrawable());
        } else if (imageResult instanceof ErrorResult) {
            transitionTarget.onError(imageResult.getDrawable());
        }
        return Unit.INSTANCE;
    }
}
