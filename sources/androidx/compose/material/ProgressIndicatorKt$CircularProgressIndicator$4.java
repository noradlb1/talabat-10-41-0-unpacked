package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4949g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4950h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4951i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4952j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4953k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$4(Modifier modifier, long j11, float f11, int i11, int i12) {
        super(2);
        this.f4949g = modifier;
        this.f4950h = j11;
        this.f4951i = f11;
        this.f4952j = i11;
        this.f4953k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1324CircularProgressIndicatoraMcp0Q(this.f4949g, this.f4950h, this.f4951i, composer, this.f4952j | 1, this.f4953k);
    }
}
