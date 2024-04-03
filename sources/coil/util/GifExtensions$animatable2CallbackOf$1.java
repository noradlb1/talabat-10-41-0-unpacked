package coil.util;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"coil/util/-GifExtensions$animatable2CallbackOf$1", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationStart", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: coil.util.-GifExtensions$animatable2CallbackOf$1  reason: invalid class name */
public final class GifExtensions$animatable2CallbackOf$1 extends Animatable2.AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f39815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f39816b;

    public GifExtensions$animatable2CallbackOf$1(Function0<Unit> function0, Function0<Unit> function02) {
        this.f39815a = function0;
        this.f39816b = function02;
    }

    public void onAnimationEnd(@Nullable Drawable drawable) {
        Function0<Unit> function0 = this.f39816b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onAnimationStart(@Nullable Drawable drawable) {
        Function0<Unit> function0 = this.f39815a;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
