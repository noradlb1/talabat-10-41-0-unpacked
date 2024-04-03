package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt$TopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3917g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f3918h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f3919i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f3920j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3921k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3922l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3923m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3924n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBar$3(Modifier modifier, long j11, long j12, float f11, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f3917g = modifier;
        this.f3918h = j11;
        this.f3919i = j12;
        this.f3920j = f11;
        this.f3921k = paddingValues;
        this.f3922l = function3;
        this.f3923m = i11;
        this.f3924n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1086TopAppBarHsRjFd4(this.f3917g, this.f3918h, this.f3919i, this.f3920j, this.f3921k, this.f3922l, composer, this.f3923m | 1, this.f3924n);
    }
}
