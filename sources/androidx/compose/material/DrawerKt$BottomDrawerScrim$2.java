package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawerScrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4444g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4445h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4446i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4447j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawerScrim$2(long j11, Function0<Unit> function0, boolean z11, int i11) {
        super(2);
        this.f4444g = j11;
        this.f4445h = function0;
        this.f4446i = z11;
        this.f4447j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DrawerKt.m1226BottomDrawerScrim3JVO9M(this.f4444g, this.f4445h, this.f4446i, composer, this.f4447j | 1);
    }
}
