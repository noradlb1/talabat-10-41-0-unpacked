package androidx.compose.material;

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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "", "", "anchors", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class SwipeableState$performFling$2 implements FlowCollector<Map<Float, ? extends T>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f5676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f5677c;

    public SwipeableState$performFling$2(SwipeableState<T> swipeableState, float f11) {
        this.f5676b = swipeableState;
        this.f5677c = f11;
    }

    @Nullable
    public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) {
        Float access$getOffset = SwipeableKt.getOffset(map, this.f5676b.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float floatValue = access$getOffset.floatValue();
        Object obj = map.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.f5676b.getOffset().getValue().floatValue(), floatValue, map.keySet(), this.f5676b.getThresholds$material_release(), this.f5677c, this.f5676b.getVelocityThreshold$material_release())));
        if (obj == null || !this.f5676b.getConfirmStateChange$material_release().invoke(obj).booleanValue()) {
            SwipeableState<T> swipeableState = this.f5676b;
            Object access$animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, swipeableState.getAnimationSpec$material_release(), continuation);
            return access$animateInternalToOffset == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateInternalToOffset : Unit.INSTANCE;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this.f5676b, obj, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }
}
