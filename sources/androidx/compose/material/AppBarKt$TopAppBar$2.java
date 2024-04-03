package androidx.compose.material;

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
public final class AppBarKt$TopAppBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3908g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3910i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3911j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f3912k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f3913l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f3914m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3915n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3916o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBar$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j11, long j12, float f11, int i11, int i12) {
        super(2);
        this.f3908g = function2;
        this.f3909h = modifier;
        this.f3910i = function22;
        this.f3911j = function3;
        this.f3912k = j11;
        this.f3913l = j12;
        this.f3914m = f11;
        this.f3915n = i11;
        this.f3916o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AppBarKt.m1087TopAppBarxWeB9s(this.f3908g, this.f3909h, this.f3910i, this.f3911j, this.f3912k, this.f3913l, this.f3914m, composer, this.f3915n | 1, this.f3916o);
    }
}
