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
public final class AppBarKt$SingleRowTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6431g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6432h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6433i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6434j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6435k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6436l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6437m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6438n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6439o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6440p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6441q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$SingleRowTopAppBar$3(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6431g = modifier;
        this.f6432h = function2;
        this.f6433i = textStyle;
        this.f6434j = z11;
        this.f6435k = function22;
        this.f6436l = function3;
        this.f6437m = windowInsets;
        this.f6438n = topAppBarColors;
        this.f6439o = topAppBarScrollBehavior;
        this.f6440p = i11;
        this.f6441q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.SingleRowTopAppBar(this.f6431g, this.f6432h, this.f6433i, this.f6434j, this.f6435k, this.f6436l, this.f6437m, this.f6438n, this.f6439o, composer, this.f6440p | 1, this.f6441q);
    }
}
