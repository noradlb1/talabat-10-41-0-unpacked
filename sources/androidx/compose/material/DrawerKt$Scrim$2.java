package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4497g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4498h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Float> f4499i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f4500j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4501k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$Scrim$2(boolean z11, Function0<Unit> function0, Function0<Float> function02, long j11, int i11) {
        super(2);
        this.f4497g = z11;
        this.f4498h = function0;
        this.f4499i = function02;
        this.f4500j = j11;
        this.f4501k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DrawerKt.m1229ScrimBx497Mc(this.f4497g, this.f4498h, this.f4499i, this.f4500j, composer, this.f4501k | 1);
    }
}
