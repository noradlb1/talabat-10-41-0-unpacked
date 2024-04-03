package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TwoRowsTopAppBar$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6520g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6521h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6522i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f6523j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6524k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6525l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6526m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6527n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6528o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6529p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ float f6530q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ float f6531r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6532s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6533t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6534u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6535v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$4(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f11, Function2<? super Composer, ? super Integer, Unit> function22, TextStyle textStyle2, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, float f12, float f13, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12, int i13) {
        super(2);
        this.f6520g = modifier;
        this.f6521h = function2;
        this.f6522i = textStyle;
        this.f6523j = f11;
        this.f6524k = function22;
        this.f6525l = textStyle2;
        this.f6526m = function23;
        this.f6527n = function3;
        this.f6528o = windowInsets;
        this.f6529p = topAppBarColors;
        this.f6530q = f12;
        this.f6531r = f13;
        this.f6532s = topAppBarScrollBehavior;
        this.f6533t = i11;
        this.f6534u = i12;
        this.f6535v = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Modifier modifier = this.f6520g;
        Modifier modifier2 = modifier;
        AppBarKt.m1502TwoRowsTopAppBartjU4iQQ(modifier2, this.f6521h, this.f6522i, this.f6523j, this.f6524k, this.f6525l, this.f6526m, this.f6527n, this.f6528o, this.f6529p, this.f6530q, this.f6531r, this.f6532s, composer, this.f6533t | 1, this.f6534u, this.f6535v);
    }
}
