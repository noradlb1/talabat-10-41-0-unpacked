package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Slider$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5210g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f5211h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5212i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5213j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5214k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5215l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5216m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5217n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5218o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5219p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f5220q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$4(float f11, Function1<? super Float, Unit> function1, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, int i12, int i13) {
        super(2);
        this.f5210g = f11;
        this.f5211h = function1;
        this.f5212i = modifier;
        this.f5213j = z11;
        this.f5214k = closedFloatingPointRange;
        this.f5215l = i11;
        this.f5216m = function0;
        this.f5217n = mutableInteractionSource;
        this.f5218o = sliderColors;
        this.f5219p = i12;
        this.f5220q = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.Slider(this.f5210g, this.f5211h, this.f5212i, this.f5213j, this.f5214k, this.f5215l, this.f5216m, this.f5217n, this.f5218o, composer, this.f5219p | 1, this.f5220q);
    }
}
