package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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
public final class ScaffoldKt$Scaffold$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7846g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7847h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7848i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7849j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7850k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7851l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f7852m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f7853n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7854o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f7855p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7856q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f7857r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int i11, long j11, long j12, WindowInsets windowInsets, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, int i12, int i13) {
        super(2);
        this.f7846g = modifier;
        this.f7847h = function2;
        this.f7848i = function22;
        this.f7849j = function23;
        this.f7850k = function24;
        this.f7851l = i11;
        this.f7852m = j11;
        this.f7853n = j12;
        this.f7854o = windowInsets;
        this.f7855p = function3;
        this.f7856q = i12;
        this.f7857r = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ScaffoldKt.m1810ScaffoldTvnljyQ(this.f7846g, this.f7847h, this.f7848i, this.f7849j, this.f7850k, this.f7851l, this.f7852m, this.f7853n, this.f7854o, this.f7855p, composer, this.f7856q | 1, this.f7857r);
    }
}
