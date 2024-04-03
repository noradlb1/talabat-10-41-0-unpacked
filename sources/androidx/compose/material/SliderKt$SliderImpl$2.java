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
public final class SliderKt$SliderImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5221g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f5222h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SliderColors f5224j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5225k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5226l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Modifier f5227m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5228n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$2(boolean z11, float f11, List<Float> list, SliderColors sliderColors, float f12, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i11) {
        super(2);
        this.f5221g = z11;
        this.f5222h = f11;
        this.f5223i = list;
        this.f5224j = sliderColors;
        this.f5225k = f12;
        this.f5226l = mutableInteractionSource;
        this.f5227m = modifier;
        this.f5228n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SliderKt.SliderImpl(this.f5221g, this.f5222h, this.f5223i, this.f5224j, this.f5225k, this.f5226l, this.f5227m, composer, this.f5228n | 1);
    }
}
