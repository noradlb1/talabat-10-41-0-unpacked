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
public final class AndroidAlertDialog_androidKt$AlertDialog$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3843g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3844h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3845i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3846j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3847k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f3848l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f3849m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f3850n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f3851o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f3852p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f3853q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$4(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j11, long j12, DialogProperties dialogProperties, int i11, int i12) {
        super(2);
        this.f3843g = function0;
        this.f3844h = function2;
        this.f3845i = modifier;
        this.f3846j = function22;
        this.f3847k = function23;
        this.f3848l = shape;
        this.f3849m = j11;
        this.f3850n = j12;
        this.f3851o = dialogProperties;
        this.f3852p = i11;
        this.f3853q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidAlertDialog_androidKt.m1080AlertDialogwqdebIU(this.f3843g, this.f3844h, this.f3845i, this.f3846j, this.f3847k, this.f3848l, this.f3849m, this.f3850n, this.f3851o, composer, this.f3852p | 1, this.f3853q);
    }
}
