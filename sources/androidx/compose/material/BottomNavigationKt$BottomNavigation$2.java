package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt$BottomNavigation$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4071g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4072h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4073i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f4074j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4075k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4076l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4077m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$BottomNavigation$2(Modifier modifier, long j11, long j12, float f11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4071g = modifier;
        this.f4072h = j11;
        this.f4073i = j12;
        this.f4074j = f11;
        this.f4075k = function3;
        this.f4076l = i11;
        this.f4077m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationKt.m1107BottomNavigationPEIptTM(this.f4071g, this.f4072h, this.f4073i, this.f4074j, this.f4075k, composer, this.f4076l | 1, this.f4077m);
    }
}
