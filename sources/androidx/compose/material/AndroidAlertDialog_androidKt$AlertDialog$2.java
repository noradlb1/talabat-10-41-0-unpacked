package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt$AlertDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3823g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3824h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3825i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3826j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3827k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3828l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Shape f3829m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f3830n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f3831o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f3832p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f3833q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f3834r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j11, long j12, DialogProperties dialogProperties, int i11, int i12) {
        super(2);
        this.f3823g = function0;
        this.f3824h = function2;
        this.f3825i = modifier;
        this.f3826j = function22;
        this.f3827k = function23;
        this.f3828l = function24;
        this.f3829m = shape;
        this.f3830n = j11;
        this.f3831o = j12;
        this.f3832p = dialogProperties;
        this.f3833q = i11;
        this.f3834r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidAlertDialog_androidKt.m1079AlertDialog6oU6zVQ(this.f3823g, this.f3824h, this.f3825i, this.f3826j, this.f3827k, this.f3828l, this.f3829m, this.f3830n, this.f3831o, this.f3832p, composer, this.f3833q | 1, this.f3834r);
    }
}
