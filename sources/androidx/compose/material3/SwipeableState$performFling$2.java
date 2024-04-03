package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "", "", "anchors", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SwipeableState$performFling$2 implements FlowCollector<Map<Float, ? extends T>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8454b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f8455c;

    public SwipeableState$performFling$2(SwipeableState<T> swipeableState, float f11) {
        this.f8454b = swipeableState;
        this.f8455c = f11;
    }

    @Nullable
    public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) {
        Float access$getOffset = SwipeableKt.getOffset(map, this.f8454b.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float floatValue = access$getOffset.floatValue();
        Object obj = map.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.f8454b.getOffset().getValue().floatValue(), floatValue, map.keySet(), this.f8454b.getThresholds$material3_release(), this.f8455c, this.f8454b.getVelocityThreshold$material3_release())));
        if (obj == null || !this.f8454b.getConfirmStateChange$material3_release().invoke(obj).booleanValue()) {
            SwipeableState<T> swipeableState = this.f8454b;
            Object access$animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, swipeableState.getAnimationSpec$material3_release(), continuation);
            return access$animateInternalToOffset == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateInternalToOffset : Unit.INSTANCE;
        }
        Object animateTo$material3_release$default = SwipeableState.animateTo$material3_release$default(this.f8454b, obj, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$material3_release$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }
}
