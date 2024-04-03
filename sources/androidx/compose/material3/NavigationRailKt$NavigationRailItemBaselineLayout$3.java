package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$NavigationRailItemBaselineLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7600g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7601h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7602i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7603j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7604k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f7605l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7606m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItemBaselineLayout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, float f11, int i11) {
        super(2);
        this.f7600g = function2;
        this.f7601h = function22;
        this.f7602i = function23;
        this.f7603j = function24;
        this.f7604k = z11;
        this.f7605l = f11;
        this.f7606m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.NavigationRailItemBaselineLayout(this.f7600g, this.f7601h, this.f7602i, this.f7603j, this.f7604k, this.f7605l, composer, this.f7606m | 1);
    }
}
