package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Track$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f5250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5251h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5252i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5253j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5254k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5255l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5256m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f5257n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5258o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Track$2(Modifier modifier, SliderColors sliderColors, boolean z11, float f11, float f12, List<Float> list, float f13, float f14, int i11) {
        super(2);
        this.f5250g = modifier;
        this.f5251h = sliderColors;
        this.f5252i = z11;
        this.f5253j = f11;
        this.f5254k = f12;
        this.f5255l = list;
        this.f5256m = f13;
        this.f5257n = f14;
        this.f5258o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.Track(this.f5250g, this.f5251h, this.f5252i, this.f5253j, this.f5254k, this.f5255l, this.f5256m, this.f5257n, composer, this.f5258o | 1);
    }
}
