package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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
public final class AppBarKt$BottomAppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6370g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6371h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6372i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6373j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f6374k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f6375l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6376m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f6377n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f6378o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6379p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$BottomAppBar$2(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j11, long j12, float f11, PaddingValues paddingValues, WindowInsets windowInsets, int i11, int i12) {
        super(2);
        this.f6370g = function3;
        this.f6371h = modifier;
        this.f6372i = function2;
        this.f6373j = j11;
        this.f6374k = j12;
        this.f6375l = f11;
        this.f6376m = paddingValues;
        this.f6377n = windowInsets;
        this.f6378o = i11;
        this.f6379p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1499BottomAppBarSnr_uVM(this.f6370g, this.f6371h, this.f6372i, this.f6373j, this.f6374k, this.f6375l, this.f6376m, this.f6377n, composer, this.f6378o | 1, this.f6379p);
    }
}
