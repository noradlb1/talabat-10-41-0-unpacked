package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSliderImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7999g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f8000h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f8001i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float[] f8002j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8003k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f8004l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8005m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8006n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Modifier f8007o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Modifier f8008p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Modifier f8009q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8010r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8011s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$2(boolean z11, float f11, float f12, float[] fArr, SliderColors sliderColors, float f13, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i11, int i12) {
        super(2);
        this.f7999g = z11;
        this.f8000h = f11;
        this.f8001i = f12;
        this.f8002j = fArr;
        this.f8003k = sliderColors;
        this.f8004l = f13;
        this.f8005m = mutableInteractionSource;
        this.f8006n = mutableInteractionSource2;
        this.f8007o = modifier;
        this.f8008p = modifier2;
        this.f8009q = modifier3;
        this.f8010r = i11;
        this.f8011s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.RangeSliderImpl(this.f7999g, this.f8000h, this.f8001i, this.f8002j, this.f8003k, this.f8004l, this.f8005m, this.f8006n, this.f8007o, this.f8008p, this.f8009q, composer, this.f8010r | 1, this.f8011s);
    }
}
