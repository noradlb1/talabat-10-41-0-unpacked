package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$SmallTopAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6448g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6449h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6450i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6451j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6452k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6453l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6454m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6455n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6456o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$SmallTopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6448g = function2;
        this.f6449h = modifier;
        this.f6450i = function22;
        this.f6451j = function3;
        this.f6452k = windowInsets;
        this.f6453l = topAppBarColors;
        this.f6454m = topAppBarScrollBehavior;
        this.f6455n = i11;
        this.f6456o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.SmallTopAppBar(this.f6448g, this.f6449h, this.f6450i, this.f6451j, this.f6452k, this.f6453l, this.f6454m, composer, this.f6455n | 1, this.f6456o);
    }
}
