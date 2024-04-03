package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$CorrectValueSideEffect$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Float> f5090g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5091h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5092i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5093j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5094k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5095l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$CorrectValueSideEffect$2(Function1<? super Float, Float> function1, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, MutableState<Float> mutableState, float f11, int i11) {
        super(2);
        this.f5090g = function1;
        this.f5091h = closedFloatingPointRange;
        this.f5092i = closedFloatingPointRange2;
        this.f5093j = mutableState;
        this.f5094k = f11;
        this.f5095l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.CorrectValueSideEffect(this.f5090g, this.f5091h, this.f5092i, this.f5093j, this.f5094k, composer, this.f5095l | 1);
    }
}
