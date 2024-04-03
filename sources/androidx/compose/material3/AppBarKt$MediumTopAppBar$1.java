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
public final class AppBarKt$MediumTopAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6411g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6412h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6413i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6414j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6415k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6416l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6417m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6418n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6419o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$MediumTopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6411g = function2;
        this.f6412h = modifier;
        this.f6413i = function22;
        this.f6414j = function3;
        this.f6415k = windowInsets;
        this.f6416l = topAppBarColors;
        this.f6417m = topAppBarScrollBehavior;
        this.f6418n = i11;
        this.f6419o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.MediumTopAppBar(this.f6411g, this.f6412h, this.f6413i, this.f6414j, this.f6415k, this.f6416l, this.f6417m, composer, this.f6418n | 1, this.f6419o);
    }
}
