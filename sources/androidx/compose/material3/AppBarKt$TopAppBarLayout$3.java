package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TopAppBarLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6484g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6485h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6486i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6487j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f6488k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6489l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6490m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f6491n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f6492o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f6493p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6494q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f6495r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6496s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6497t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6498u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6499v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBarLayout$3(Modifier modifier, float f11, long j11, long j12, long j13, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f12, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i11, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i12, int i13) {
        super(2);
        this.f6484g = modifier;
        this.f6485h = f11;
        this.f6486i = j11;
        this.f6487j = j12;
        this.f6488k = j13;
        this.f6489l = function2;
        this.f6490m = textStyle;
        this.f6491n = f12;
        this.f6492o = vertical;
        this.f6493p = horizontal;
        this.f6494q = i11;
        this.f6495r = z11;
        this.f6496s = function22;
        this.f6497t = function23;
        this.f6498u = i12;
        this.f6499v = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f6484g;
        Modifier modifier2 = modifier;
        AppBarKt.m1501TopAppBarLayoutkXwM9vE(modifier2, this.f6485h, this.f6486i, this.f6487j, this.f6488k, this.f6489l, this.f6490m, this.f6491n, this.f6492o, this.f6493p, this.f6494q, this.f6495r, this.f6496s, this.f6497t, composer2, this.f6498u | 1, this.f6499v);
    }
}
