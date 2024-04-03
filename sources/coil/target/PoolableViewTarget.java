package coil.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.MainThread;
import coil.target.ViewTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcoil/target/PoolableViewTarget;", "T", "Landroid/view/View;", "Lcoil/target/ViewTarget;", "onClear", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface PoolableViewTarget<T extends View> extends ViewTarget<T> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @MainThread
        public static <T extends View> void onError(@NotNull PoolableViewTarget<T> poolableViewTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(poolableViewTarget, "this");
            ViewTarget.DefaultImpls.onError(poolableViewTarget, drawable);
        }

        @MainThread
        public static <T extends View> void onStart(@NotNull PoolableViewTarget<T> poolableViewTarget, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(poolableViewTarget, "this");
            ViewTarget.DefaultImpls.onStart(poolableViewTarget, drawable);
        }

        @MainThread
        public static <T extends View> void onSuccess(@NotNull PoolableViewTarget<T> poolableViewTarget, @NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(poolableViewTarget, "this");
            Intrinsics.checkNotNullParameter(drawable, "result");
            ViewTarget.DefaultImpls.onSuccess(poolableViewTarget, drawable);
        }
    }

    @MainThread
    void onClear();
}
