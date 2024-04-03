package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarKt$Snackbar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8297g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8298h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8299i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8300j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f8301k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8302l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f8303m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8304n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f8305o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8306p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8307q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f8308r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z11, Shape shape, long j11, long j12, long j13, long j14, Function2<? super Composer, ? super Integer, Unit> function23, int i11, int i12) {
        super(2);
        this.f8297g = modifier;
        this.f8298h = function2;
        this.f8299i = function22;
        this.f8300j = z11;
        this.f8301k = shape;
        this.f8302l = j11;
        this.f8303m = j12;
        this.f8304n = j13;
        this.f8305o = j14;
        this.f8306p = function23;
        this.f8307q = i11;
        this.f8308r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f8297g;
        Modifier modifier2 = modifier;
        SnackbarKt.m1827SnackbareQBnUkQ(modifier2, this.f8298h, this.f8299i, this.f8300j, this.f8301k, this.f8302l, this.f8303m, this.f8304n, this.f8305o, this.f8306p, composer2, this.f8307q | 1, this.f8308r);
    }
}
