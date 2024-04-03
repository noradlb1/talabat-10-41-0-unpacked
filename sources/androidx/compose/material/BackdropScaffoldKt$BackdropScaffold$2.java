package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropScaffold$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3989g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3990h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3991i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f3992j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BackdropScaffoldState f3993k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f3994l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f3995m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f3996n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f3997o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f3998p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f3999q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f4000r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Shape f4001s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ float f4002t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ long f4003u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ long f4004v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ long f4005w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f4006x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f4007y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f4008z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Modifier modifier, BackdropScaffoldState backdropScaffoldState, boolean z11, float f11, float f12, boolean z12, boolean z13, long j11, long j12, Shape shape, float f13, long j13, long j14, long j15, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, int i11, int i12, int i13) {
        super(2);
        this.f3989g = function2;
        this.f3990h = function22;
        this.f3991i = function23;
        this.f3992j = modifier;
        this.f3993k = backdropScaffoldState;
        this.f3994l = z11;
        this.f3995m = f11;
        this.f3996n = f12;
        this.f3997o = z12;
        this.f3998p = z13;
        this.f3999q = j11;
        this.f4000r = j12;
        this.f4001s = shape;
        this.f4002t = f13;
        this.f4003u = j13;
        this.f4004v = j14;
        this.f4005w = j15;
        this.f4006x = function3;
        this.f4007y = i11;
        this.f4008z = i12;
        this.A = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Function2<Composer, Integer, Unit> function2 = this.f3989g;
        Function2<Composer, Integer, Unit> function22 = function2;
        BackdropScaffoldKt.m1093BackdropScaffoldBZszfkY(function22, this.f3990h, this.f3991i, this.f3992j, this.f3993k, this.f3994l, this.f3995m, this.f3996n, this.f3997o, this.f3998p, this.f3999q, this.f4000r, this.f4001s, this.f4002t, this.f4003u, this.f4004v, this.f4005w, this.f4006x, composer2, this.f4007y | 1, this.f4008z, this.A);
    }
}
