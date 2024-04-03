package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwipeableKt$rememberSwipeableState$2 extends Lambda implements Function0<SwipeableState<T>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f8396g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f8397h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Boolean> f8398i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$rememberSwipeableState$2(T t11, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        super(0);
        this.f8396g = t11;
        this.f8397h = animationSpec;
        this.f8398i = function1;
    }

    @NotNull
    public final SwipeableState<T> invoke() {
        return new SwipeableState<>(this.f8396g, this.f8397h, this.f8398i);
    }
}
