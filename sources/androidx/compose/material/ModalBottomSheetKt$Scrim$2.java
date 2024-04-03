package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4748g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4749h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4750i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4751j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$Scrim$2(long j11, Function0<Unit> function0, boolean z11, int i11) {
        super(2);
        this.f4748g = j11;
        this.f4749h = function0;
        this.f4750i = z11;
        this.f4751j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ModalBottomSheetKt.m1298Scrim3JVO9M(this.f4748g, this.f4749h, this.f4750i, composer, this.f4751j | 1);
    }
}
