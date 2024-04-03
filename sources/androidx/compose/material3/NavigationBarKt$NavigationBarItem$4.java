package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBarItem$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RowScope f7377g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f7378h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7379i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7380j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f7381k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f7382l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7383m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f7384n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ NavigationBarItemColors f7385o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7386p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7387q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f7388r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBarItem$4(RowScope rowScope, boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, boolean z13, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f7377g = rowScope;
        this.f7378h = z11;
        this.f7379i = function0;
        this.f7380j = function2;
        this.f7381k = modifier;
        this.f7382l = z12;
        this.f7383m = function22;
        this.f7384n = z13;
        this.f7385o = navigationBarItemColors;
        this.f7386p = mutableInteractionSource;
        this.f7387q = i11;
        this.f7388r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationBarKt.NavigationBarItem(this.f7377g, this.f7378h, this.f7379i, this.f7380j, this.f7381k, this.f7382l, this.f7383m, this.f7384n, this.f7385o, this.f7386p, composer, this.f7387q | 1, this.f7388r);
    }
}
