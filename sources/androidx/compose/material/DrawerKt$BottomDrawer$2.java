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
public final class DrawerKt$BottomDrawer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4430g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4431h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BottomDrawerState f4432i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4433j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f4434k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f4435l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4436m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4437n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f4438o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4439p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4440q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4441r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$2(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomDrawerState bottomDrawerState, boolean z11, Shape shape, float f11, long j11, long j12, long j13, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4430g = function3;
        this.f4431h = modifier;
        this.f4432i = bottomDrawerState;
        this.f4433j = z11;
        this.f4434k = shape;
        this.f4435l = f11;
        this.f4436m = j11;
        this.f4437n = j12;
        this.f4438o = j13;
        this.f4439p = function2;
        this.f4440q = i11;
        this.f4441r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DrawerKt.m1225BottomDrawerGs3lGvM(this.f4430g, this.f4431h, this.f4432i, this.f4433j, this.f4434k, this.f4435l, this.f4436m, this.f4437n, this.f4438o, this.f4439p, composer, this.f4440q | 1, this.f4441r);
    }
}
