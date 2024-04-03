package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
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
public final class ScaffoldKt$Scaffold$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4989g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ScaffoldState f4990h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4991i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4992j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f4993k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4994l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4995m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f4996n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4997o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f4998p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Shape f4999q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ float f5000r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ long f5001s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ long f5002t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ long f5003u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ long f5004v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ long f5005w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f5006x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f5007y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f5008z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$2(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i11, boolean z11, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z12, Shape shape, float f11, long j11, long j12, long j13, long j14, long j15, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, int i12, int i13, int i14) {
        super(2);
        this.f4989g = modifier;
        this.f4990h = scaffoldState;
        this.f4991i = function2;
        this.f4992j = function22;
        this.f4993k = function3;
        this.f4994l = function23;
        this.f4995m = i11;
        this.f4996n = z11;
        this.f4997o = function32;
        this.f4998p = z12;
        this.f4999q = shape;
        this.f5000r = f11;
        this.f5001s = j11;
        this.f5002t = j12;
        this.f5003u = j13;
        this.f5004v = j14;
        this.f5005w = j15;
        this.f5006x = function33;
        this.f5007y = i12;
        this.f5008z = i13;
        this.A = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f4989g;
        Modifier modifier2 = modifier;
        ScaffoldKt.m1353Scaffold27mzLpw(modifier2, this.f4990h, this.f4991i, this.f4992j, this.f4993k, this.f4994l, this.f4995m, this.f4996n, this.f4997o, this.f4998p, this.f4999q, this.f5000r, this.f5001s, this.f5002t, this.f5003u, this.f5004v, this.f5005w, this.f5006x, composer2, this.f5007y | 1, this.f5008z, this.A);
    }
}
