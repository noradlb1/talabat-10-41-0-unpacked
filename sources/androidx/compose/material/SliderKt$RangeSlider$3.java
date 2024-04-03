package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$RangeSlider$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5151g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> f5152h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5153i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5154j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5155k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5156l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5157m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5158n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5159o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5160p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i11, Function0<Unit> function0, SliderColors sliderColors, int i12, int i13) {
        super(2);
        this.f5151g = closedFloatingPointRange;
        this.f5152h = function1;
        this.f5153i = modifier;
        this.f5154j = z11;
        this.f5155k = closedFloatingPointRange2;
        this.f5156l = i11;
        this.f5157m = function0;
        this.f5158n = sliderColors;
        this.f5159o = i12;
        this.f5160p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.RangeSlider(this.f5151g, this.f5152h, this.f5153i, this.f5154j, this.f5155k, this.f5156l, this.f5157m, this.f5158n, composer, this.f5159o | 1, this.f5160p);
    }
}
