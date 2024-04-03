package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$RangeSliderImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5163g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f5164h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5165i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5166j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5167k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f5168l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5169m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5170n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Modifier f5171o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Modifier f5172p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Modifier f5173q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f5174r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f5175s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$2(boolean z11, float f11, float f12, List<Float> list, SliderColors sliderColors, float f13, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i11, int i12) {
        super(2);
        this.f5163g = z11;
        this.f5164h = f11;
        this.f5165i = f12;
        this.f5166j = list;
        this.f5167k = sliderColors;
        this.f5168l = f13;
        this.f5169m = mutableInteractionSource;
        this.f5170n = mutableInteractionSource2;
        this.f5171o = modifier;
        this.f5172p = modifier2;
        this.f5173q = modifier3;
        this.f5174r = i11;
        this.f5175s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.RangeSliderImpl(this.f5163g, this.f5164h, this.f5165i, this.f5166j, this.f5167k, this.f5168l, this.f5169m, this.f5170n, this.f5171o, this.f5172p, this.f5173q, composer, this.f5174r | 1, this.f5175s);
    }
}
