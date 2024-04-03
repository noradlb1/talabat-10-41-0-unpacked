package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7799g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f7800h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f7801i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7802j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7803k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$4(Modifier modifier, long j11, float f11, int i11, int i12) {
        super(2);
        this.f7799g = modifier;
        this.f7800h = j11;
        this.f7801i = f11;
        this.f7802j = i11;
        this.f7803k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1797CircularProgressIndicatoraMcp0Q(this.f7799g, this.f7800h, this.f7801i, composer, this.f7802j | 1, this.f7803k);
    }
}
