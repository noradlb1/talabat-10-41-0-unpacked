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
public final class AppBarKt$TopAppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6457g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6458h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6459i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6460j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6461k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TopAppBarColors f6462l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6463m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6464n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6465o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i11, int i12) {
        super(2);
        this.f6457g = function2;
        this.f6458h = modifier;
        this.f6459i = function22;
        this.f6460j = function3;
        this.f6461k = windowInsets;
        this.f6462l = topAppBarColors;
        this.f6463m = topAppBarScrollBehavior;
        this.f6464n = i11;
        this.f6465o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.TopAppBar(this.f6457g, this.f6458h, this.f6459i, this.f6460j, this.f6461k, this.f6462l, this.f6463m, composer, this.f6464n | 1, this.f6465o);
    }
}
