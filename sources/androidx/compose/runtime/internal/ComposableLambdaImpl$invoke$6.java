package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9439g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9440h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9441i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9442j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9443k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9444l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9445m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f9446n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$6(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i11) {
        super(2);
        this.f9439g = composableLambdaImpl;
        this.f9440h = obj;
        this.f9441i = obj2;
        this.f9442j = obj3;
        this.f9443k = obj4;
        this.f9444l = obj5;
        this.f9445m = obj6;
        this.f9446n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.f9439g.invoke(this.f9440h, this.f9441i, this.f9442j, this.f9443k, this.f9444l, this.f9445m, composer, this.f9446n | 1);
    }
}
