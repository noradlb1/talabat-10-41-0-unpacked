package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$TempRangeSliderTrack$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8110g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8111h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8112i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8113j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f8114k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float[] f8115l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f8116m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f8117n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8118o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$TempRangeSliderTrack$3(Modifier modifier, SliderColors sliderColors, boolean z11, float f11, float f12, float[] fArr, float f13, float f14, int i11) {
        super(2);
        this.f8110g = modifier;
        this.f8111h = sliderColors;
        this.f8112i = z11;
        this.f8113j = f11;
        this.f8114k = f12;
        this.f8115l = fArr;
        this.f8116m = f13;
        this.f8117n = f14;
        this.f8118o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.m1817TempRangeSliderTrackau3_HiA(this.f8110g, this.f8111h, this.f8112i, this.f8113j, this.f8114k, this.f8115l, this.f8116m, this.f8117n, composer, this.f8118o | 1);
    }
}
