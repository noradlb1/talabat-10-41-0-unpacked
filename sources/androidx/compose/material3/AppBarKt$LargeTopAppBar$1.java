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
public final class AppBarKt$LargeTopAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6402g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6403h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6404i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6405j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6406k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6407l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6408m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6409n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6410o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$LargeTopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6402g = function2;
        this.f6403h = modifier;
        this.f6404i = function22;
        this.f6405j = function3;
        this.f6406k = windowInsets;
        this.f6407l = topAppBarColors;
        this.f6408m = topAppBarScrollBehavior;
        this.f6409n = i11;
        this.f6410o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.LargeTopAppBar(this.f6402g, this.f6403h, this.f6404i, this.f6405j, this.f6406k, this.f6407l, this.f6408m, composer, this.f6409n | 1, this.f6410o);
    }
}
