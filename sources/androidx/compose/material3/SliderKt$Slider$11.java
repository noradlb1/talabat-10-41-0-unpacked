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
public final class SliderKt$Slider$11 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8012g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8013h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> f8014i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f8015j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8016k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8017l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8018m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8019n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8020o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8021p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> f8022q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8023r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8024s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f8025t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$11(float f11, Function1<? super Float, Unit> function1, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, int i12, int i13, int i14) {
        super(2);
        this.f8012g = f11;
        this.f8013h = function1;
        this.f8014i = function3;
        this.f8015j = modifier;
        this.f8016k = z11;
        this.f8017l = closedFloatingPointRange;
        this.f8018m = i11;
        this.f8019n = function0;
        this.f8020o = sliderColors;
        this.f8021p = mutableInteractionSource;
        this.f8022q = function32;
        this.f8023r = i12;
        this.f8024s = i13;
        this.f8025t = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.Slider(this.f8012g, this.f8013h, this.f8014i, this.f8015j, this.f8016k, this.f8017l, this.f8018m, this.f8019n, this.f8020o, this.f8021p, this.f8022q, composer, this.f8023r | 1, this.f8024s, this.f8025t);
    }
}
