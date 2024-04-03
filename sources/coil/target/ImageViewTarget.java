package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.transition.TransitionTarget;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010\u001c\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcoil/target/ImageViewTarget;", "Lcoil/target/PoolableViewTarget;", "Landroid/widget/ImageView;", "Lcoil/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/graphics/drawable/Drawable;", "placeholder", "", "onStart", "error", "onError", "result", "onSuccess", "onClear", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onStop", "drawable", "a", "b", "", "other", "", "equals", "", "hashCode", "", "toString", "view", "Landroid/widget/ImageView;", "getView", "()Landroid/widget/ImageView;", "isStarted", "Z", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/widget/ImageView;)V", "coil-base_release"}, k = 1, mv = {1, 5, 1})
public class ImageViewTarget implements PoolableViewTarget<ImageView>, TransitionTarget, DefaultLifecycleObserver {
    private boolean isStarted;
    @NotNull
    private final ImageView view;

    public ImageViewTarget(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        this.view = imageView;
    }

    public void a(@Nullable Drawable drawable) {
        Animatable animatable;
        Drawable drawable2 = getView().getDrawable();
        if (drawable2 instanceof Animatable) {
            animatable = (Animatable) drawable2;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            animatable.stop();
        }
        getView().setImageDrawable(drawable);
        b();
    }

    public void b() {
        Animatable animatable;
        Drawable drawable = getView().getDrawable();
        if (drawable instanceof Animatable) {
            animatable = (Animatable) drawable;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            if (this.isStarted) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || ((obj instanceof ImageViewTarget) && Intrinsics.areEqual((Object) getView(), (Object) ((ImageViewTarget) obj).getView()));
    }

    @Nullable
    public Drawable getDrawable() {
        return getView().getDrawable();
    }

    public int hashCode() {
        return getView().hashCode();
    }

    public void onClear() {
        a((Drawable) null);
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    public void onError(@Nullable Drawable drawable) {
        a(drawable);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        a.d(this, lifecycleOwner);
    }

    public void onStart(@Nullable Drawable drawable) {
        a(drawable);
    }

    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.isStarted = false;
        b();
    }

    public void onSuccess(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "result");
        a(drawable);
    }

    @NotNull
    public String toString() {
        return "ImageViewTarget(view=" + getView() + ')';
    }

    @NotNull
    public ImageView getView() {
        return this.view;
    }

    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.isStarted = true;
        b();
    }
}
