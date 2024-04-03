package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3797g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3798h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3799i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3800j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f3801k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f3802l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f3803m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3804n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f3805o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j11, long j12, int i11, int i12) {
        super(2);
        this.f3797g = function2;
        this.f3798h = modifier;
        this.f3799i = function22;
        this.f3800j = function23;
        this.f3801k = shape;
        this.f3802l = j11;
        this.f3803m = j12;
        this.f3804n = i11;
        this.f3805o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AlertDialogKt.m1075AlertDialogContentWMdw5o4(this.f3797g, this.f3798h, this.f3799i, this.f3800j, this.f3801k, this.f3802l, this.f3803m, composer, this.f3804n | 1, this.f3805o);
    }
}
