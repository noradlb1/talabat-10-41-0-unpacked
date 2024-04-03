package coil.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.MainThread;
import coil.annotation.ExperimentalCoilApi;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcoil/transition/TransitionTarget;", "Lcoil/target/Target;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalCoilApi
public interface TransitionTarget extends Target {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @MainThread
        public static void onError(@NotNull TransitionTarget transitionTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(transitionTarget, "this");
            Target.DefaultImpls.onError(transitionTarget, drawable);
        }

        @MainThread
        public static void onStart(@NotNull TransitionTarget transitionTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(transitionTarget, "this");
            Target.DefaultImpls.onStart(transitionTarget, drawable);
        }

        @MainThread
        public static void onSuccess(@NotNull TransitionTarget transitionTarget, @NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(transitionTarget, "this");
            Intrinsics.checkNotNullParameter(drawable, "result");
            Target.DefaultImpls.onSuccess(transitionTarget, drawable);
        }
    }

    @Nullable
    Drawable getDrawable();

    @NotNull
    View getView();
}
