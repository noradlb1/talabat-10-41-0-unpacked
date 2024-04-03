package coil.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.MainThread;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/target/ViewTarget;", "T", "Landroid/view/View;", "Lcoil/target/Target;", "view", "getView", "()Landroid/view/View;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ViewTarget<T extends View> extends Target {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @MainThread
        public static <T extends View> void onError(@NotNull ViewTarget<T> viewTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(viewTarget, "this");
            Target.DefaultImpls.onError(viewTarget, drawable);
        }

        @MainThread
        public static <T extends View> void onStart(@NotNull ViewTarget<T> viewTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(viewTarget, "this");
            Target.DefaultImpls.onStart(viewTarget, drawable);
        }

        @MainThread
        public static <T extends View> void onSuccess(@NotNull ViewTarget<T> viewTarget, @NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(viewTarget, "this");
            Intrinsics.checkNotNullParameter(drawable, "result");
            Target.DefaultImpls.onSuccess(viewTarget, drawable);
        }
    }

    @NotNull
    T getView();
}
