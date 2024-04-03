package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7542g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7543h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Float> f7544i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7545j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7546k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$Scrim$2(boolean z11, Function0<Unit> function0, Function0<Float> function02, long j11, int i11) {
        super(2);
        this.f7542g = z11;
        this.f7543h = function0;
        this.f7544i = function02;
        this.f7545j = j11;
        this.f7546k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.m1768ScrimBx497Mc(this.f7542g, this.f7543h, this.f7544i, this.f7545j, composer, this.f7546k | 1);
    }
}
