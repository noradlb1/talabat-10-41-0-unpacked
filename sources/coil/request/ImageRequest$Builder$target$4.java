package coil.request;

import android.graphics.drawable.Drawable;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"coil/request/ImageRequest$Builder$target$4", "Lcoil/target/Target;", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageRequest$Builder$target$4 implements Target {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<Drawable, Unit> f39794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<Drawable, Unit> f39795c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1<Drawable, Unit> f39796d;

    public ImageRequest$Builder$target$4(Function1<? super Drawable, Unit> function1, Function1<? super Drawable, Unit> function12, Function1<? super Drawable, Unit> function13) {
        this.f39794b = function1;
        this.f39795c = function12;
        this.f39796d = function13;
    }

    public void onError(@Nullable Drawable drawable) {
        this.f39795c.invoke(drawable);
    }

    public void onStart(@Nullable Drawable drawable) {
        this.f39794b.invoke(drawable);
    }

    public void onSuccess(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "result");
        this.f39796d.invoke(drawable);
    }
}
