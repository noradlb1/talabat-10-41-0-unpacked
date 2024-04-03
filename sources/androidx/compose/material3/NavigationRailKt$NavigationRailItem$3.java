package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7573g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7574h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7575i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f7576j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7577k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7578l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f7579m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ NavigationRailItemColors f7580n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7581o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7582p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7583q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$3(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, boolean z13, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f7573g = z11;
        this.f7574h = function0;
        this.f7575i = function2;
        this.f7576j = modifier;
        this.f7577k = z12;
        this.f7578l = function22;
        this.f7579m = z13;
        this.f7580n = navigationRailItemColors;
        this.f7581o = mutableInteractionSource;
        this.f7582p = i11;
        this.f7583q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.NavigationRailItem(this.f7573g, this.f7574h, this.f7575i, this.f7576j, this.f7577k, this.f7578l, this.f7579m, this.f7580n, this.f7581o, composer, this.f7582p | 1, this.f7583q);
    }
}
