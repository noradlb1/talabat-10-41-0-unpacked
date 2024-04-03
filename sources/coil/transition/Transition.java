package coil.transition;

import androidx.annotation.MainThread;
import coil.annotation.ExperimentalCoilApi;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcoil/transition/Transition;", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalCoilApi
public interface Transition {
    @NotNull
    public static final Companion Companion = Companion.f39814a;
    @NotNull
    @JvmField
    public static final Transition NONE = NoneTransition.INSTANCE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil/transition/Transition$Companion;", "", "()V", "NONE", "Lcoil/transition/Transition;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39814a = new Companion();

        private Companion() {
        }
    }

    @Nullable
    @MainThread
    Object transition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult, @NotNull Continuation<? super Unit> continuation);
}
