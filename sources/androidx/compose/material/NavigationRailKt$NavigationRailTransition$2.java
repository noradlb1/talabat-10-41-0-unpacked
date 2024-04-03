package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailTransition$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4803g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4804h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4805i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<Float, Composer, Integer, Unit> f4806j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4807k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailTransition$2(long j11, long j12, boolean z11, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f4803g = j11;
        this.f4804h = j12;
        this.f4805i = z11;
        this.f4806j = function3;
        this.f4807k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.m1307NavigationRailTransitionKlgxPg(this.f4803g, this.f4804h, this.f4805i, this.f4806j, composer, this.f4807k | 1);
    }
}
