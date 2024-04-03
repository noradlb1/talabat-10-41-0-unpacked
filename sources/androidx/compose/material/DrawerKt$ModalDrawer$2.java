package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
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
public final class DrawerKt$ModalDrawer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4483g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4484h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f4485i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4486j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f4487k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f4488l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4489m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4490n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f4491o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4492p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4493q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4494r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$2(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean z11, Shape shape, float f11, long j11, long j12, long j13, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4483g = function3;
        this.f4484h = modifier;
        this.f4485i = drawerState;
        this.f4486j = z11;
        this.f4487k = shape;
        this.f4488l = f11;
        this.f4489m = j11;
        this.f4490n = j12;
        this.f4491o = j13;
        this.f4492p = function2;
        this.f4493q = i11;
        this.f4494r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DrawerKt.m1228ModalDrawerGs3lGvM(this.f4483g, this.f4484h, this.f4485i, this.f4486j, this.f4487k, this.f4488l, this.f4489m, this.f4490n, this.f4491o, this.f4492p, composer, this.f4493q | 1, this.f4494r);
    }
}
