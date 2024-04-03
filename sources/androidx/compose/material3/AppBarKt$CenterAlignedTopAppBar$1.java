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
public final class AppBarKt$CenterAlignedTopAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6393g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6394h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6395i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6396j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6397k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6398l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6399m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6400n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6401o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$CenterAlignedTopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6393g = function2;
        this.f6394h = modifier;
        this.f6395i = function22;
        this.f6396j = function3;
        this.f6397k = windowInsets;
        this.f6398l = topAppBarColors;
        this.f6399m = topAppBarScrollBehavior;
        this.f6400n = i11;
        this.f6401o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.CenterAlignedTopAppBar(this.f6393g, this.f6394h, this.f6395i, this.f6396j, this.f6397k, this.f6398l, this.f6399m, composer, this.f6400n | 1, this.f6401o);
    }
}
