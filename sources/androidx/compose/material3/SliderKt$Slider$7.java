package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$Slider$7 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8047g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8048h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8049i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8050j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8051k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8052l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8053m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8054n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8055o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> f8056p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8057q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8058r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$7(float f11, Function1<? super Float, Unit> function1, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, int i12, int i13) {
        super(2);
        this.f8047g = f11;
        this.f8048h = function1;
        this.f8049i = modifier;
        this.f8050j = z11;
        this.f8051k = closedFloatingPointRange;
        this.f8052l = i11;
        this.f8053m = function0;
        this.f8054n = sliderColors;
        this.f8055o = mutableInteractionSource;
        this.f8056p = function3;
        this.f8057q = i12;
        this.f8058r = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.Slider(this.f8047g, this.f8048h, this.f8049i, this.f8050j, this.f8051k, this.f8052l, this.f8053m, this.f8054n, this.f8055o, this.f8056p, composer, this.f8057q | 1, this.f8058r);
    }
}
