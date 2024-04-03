package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
public final class SliderKt$Slider$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8033g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8034h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8035i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8036j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8037k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8038l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8039m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8040n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8041o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8042p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8043q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$4(float f11, Function1<? super Float, Unit> function1, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i12, int i13) {
        super(2);
        this.f8033g = f11;
        this.f8034h = function1;
        this.f8035i = modifier;
        this.f8036j = z11;
        this.f8037k = closedFloatingPointRange;
        this.f8038l = i11;
        this.f8039m = function0;
        this.f8040n = sliderColors;
        this.f8041o = mutableInteractionSource;
        this.f8042p = i12;
        this.f8043q = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.Slider(this.f8033g, this.f8034h, this.f8035i, this.f8036j, this.f8037k, this.f8038l, this.f8039m, this.f8040n, this.f8041o, composer, this.f8042p | 1, this.f8043q);
    }
}
