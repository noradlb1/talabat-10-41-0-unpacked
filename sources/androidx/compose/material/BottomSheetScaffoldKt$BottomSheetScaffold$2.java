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
public final class BottomSheetScaffoldKt$BottomSheetScaffold$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ long A;
    public final /* synthetic */ long B;
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> C;
    public final /* synthetic */ int D;
    public final /* synthetic */ int E;
    public final /* synthetic */ int F;
    public final /* synthetic */ int G;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4132g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4133h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BottomSheetScaffoldState f4134i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4135j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f4136k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4137l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4138m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f4139n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Shape f4140o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f4141p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f4142q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ long f4143r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f4144s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4145t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ boolean f4146u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Shape f4147v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ float f4148w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ long f4149x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ long f4150y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ long f4151z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$2(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, int i11, boolean z11, Shape shape, float f11, long j11, long j12, float f12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, boolean z12, Shape shape2, float f13, long j13, long j14, long j15, long j16, long j17, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function34, int i12, int i13, int i14, int i15) {
        super(2);
        this.f4132g = function3;
        this.f4133h = modifier;
        this.f4134i = bottomSheetScaffoldState;
        this.f4135j = function2;
        this.f4136k = function32;
        this.f4137l = function22;
        this.f4138m = i11;
        this.f4139n = z11;
        this.f4140o = shape;
        this.f4141p = f11;
        this.f4142q = j11;
        this.f4143r = j12;
        this.f4144s = f12;
        this.f4145t = function33;
        this.f4146u = z12;
        this.f4147v = shape2;
        this.f4148w = f13;
        this.f4149x = j13;
        this.f4150y = j14;
        this.f4151z = j15;
        this.A = j16;
        this.B = j17;
        this.C = function34;
        this.D = i12;
        this.E = i13;
        this.F = i14;
        this.G = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f4132g;
        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
        BottomSheetScaffoldKt.m1120BottomSheetScaffoldbGncdBI(function32, this.f4133h, this.f4134i, this.f4135j, this.f4136k, this.f4137l, this.f4138m, this.f4139n, this.f4140o, this.f4141p, this.f4142q, this.f4143r, this.f4144s, this.f4145t, this.f4146u, this.f4147v, this.f4148w, this.f4149x, this.f4150y, this.f4151z, this.A, this.B, this.C, composer2, this.D | 1, this.E, this.F, this.G);
    }
}
