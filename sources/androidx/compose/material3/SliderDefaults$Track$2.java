package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderDefaults$Track$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SliderDefaults f7929g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderPositions f7930h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7931i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SliderColors f7932j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7933k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7934l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7935m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderDefaults$Track$2(SliderDefaults sliderDefaults, SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z11, int i11, int i12) {
        super(2);
        this.f7929g = sliderDefaults;
        this.f7930h = sliderPositions;
        this.f7931i = modifier;
        this.f7932j = sliderColors;
        this.f7933k = z11;
        this.f7934l = i11;
        this.f7935m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f7929g.Track(this.f7930h, this.f7931i, this.f7932j, this.f7933k, composer, this.f7934l | 1, this.f7935m);
    }
}
