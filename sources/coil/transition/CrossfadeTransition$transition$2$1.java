package coil.transition;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.drawable.CrossfadeDrawable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"coil/transition/CrossfadeTransition$transition$2$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CrossfadeTransition$transition$2$1 extends Animatable2Compat.AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrossfadeDrawable f39812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f39813b;

    public CrossfadeTransition$transition$2$1(CrossfadeDrawable crossfadeDrawable, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f39812a = crossfadeDrawable;
        this.f39813b = cancellableContinuation;
    }

    public void onAnimationEnd(@Nullable Drawable drawable) {
        this.f39812a.unregisterAnimationCallback(this);
        this.f39813b.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
