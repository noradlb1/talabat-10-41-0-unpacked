package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4032g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4033h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4034i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4035j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$Scrim$2(long j11, Function0<Unit> function0, boolean z11, int i11) {
        super(2);
        this.f4032g = j11;
        this.f4033h = function0;
        this.f4034i = z11;
        this.f4035j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BackdropScaffoldKt.m1094Scrim3JVO9M(this.f4032g, this.f4033h, this.f4034i, composer, this.f4035j | 1);
    }
}
