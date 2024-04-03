package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class InfiniteTransitionKt$animateValue$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f1339g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> f1340h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ T f1341i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InfiniteRepeatableSpec<T> f1342j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfiniteTransitionKt$animateValue$1(T t11, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState, T t12, InfiniteRepeatableSpec<T> infiniteRepeatableSpec) {
        super(0);
        this.f1339g = t11;
        this.f1340h = transitionAnimationState;
        this.f1341i = t12;
        this.f1342j = infiniteRepeatableSpec;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.f1339g, (Object) this.f1340h.getInitialValue()) || !Intrinsics.areEqual((Object) this.f1341i, (Object) this.f1340h.getTargetValue())) {
            this.f1340h.updateValues(this.f1339g, this.f1341i, this.f1342j);
        }
    }
}
