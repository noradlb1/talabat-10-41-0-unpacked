package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabRowDefaults$Indicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabRowDefaults f5792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f5795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5796k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5797l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowDefaults$Indicator$1(TabRowDefaults tabRowDefaults, Modifier modifier, float f11, long j11, int i11, int i12) {
        super(2);
        this.f5792g = tabRowDefaults;
        this.f5793h = modifier;
        this.f5794i = f11;
        this.f5795j = j11;
        this.f5796k = i11;
        this.f5797l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f5792g.m1418Indicator9IZ8Weo(this.f5793h, this.f5794i, this.f5795j, composer, this.f5796k | 1, this.f5797l);
    }
}
