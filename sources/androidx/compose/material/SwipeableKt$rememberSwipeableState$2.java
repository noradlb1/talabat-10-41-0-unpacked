package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeableKt$rememberSwipeableState$2 extends Lambda implements Function0<SwipeableState<T>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f5618g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f5619h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Boolean> f5620i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$rememberSwipeableState$2(T t11, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        super(0);
        this.f5618g = t11;
        this.f5619h = animationSpec;
        this.f5620i = function1;
    }

    @NotNull
    public final SwipeableState<T> invoke() {
        return new SwipeableState<>(this.f5618g, this.f5619h, this.f5620i);
    }
}
