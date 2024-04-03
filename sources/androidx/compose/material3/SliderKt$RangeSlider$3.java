package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSlider$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7973g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> f7974h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7975i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7976j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7977k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7978l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7979m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SliderColors f7980n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7981o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7982p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i11, Function0<Unit> function0, SliderColors sliderColors, int i12, int i13) {
        super(2);
        this.f7973g = closedFloatingPointRange;
        this.f7974h = function1;
        this.f7975i = modifier;
        this.f7976j = z11;
        this.f7977k = closedFloatingPointRange2;
        this.f7978l = i11;
        this.f7979m = function0;
        this.f7980n = sliderColors;
        this.f7981o = i12;
        this.f7982p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.RangeSlider(this.f7973g, this.f7974h, this.f7975i, this.f7976j, this.f7977k, this.f7978l, this.f7979m, this.f7980n, composer, this.f7981o | 1, this.f7982p);
    }
}
