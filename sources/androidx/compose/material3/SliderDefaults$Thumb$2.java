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
public final class SliderDefaults$Thumb$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SliderDefaults f7916g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7917h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7918i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SliderColors f7919j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7920k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f7921l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7922m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7923n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderDefaults$Thumb$2(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z11, long j11, int i11, int i12) {
        super(2);
        this.f7916g = sliderDefaults;
        this.f7917h = mutableInteractionSource;
        this.f7918i = modifier;
        this.f7919j = sliderColors;
        this.f7920k = z11;
        this.f7921l = j11;
        this.f7922m = i11;
        this.f7923n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f7916g.m1814Thumb9LiSoMs(this.f7917h, this.f7918i, this.f7919j, this.f7920k, this.f7921l, composer, this.f7922m | 1, this.f7923n);
    }
}
