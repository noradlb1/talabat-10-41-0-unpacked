package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$9 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9467h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9468i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9469j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9470k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9471l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9472m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9473n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9474o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Object f9475p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f9476q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$9(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, int i11) {
        super(2);
        this.f9466g = composableLambdaImpl;
        this.f9467h = obj;
        this.f9468i = obj2;
        this.f9469j = obj3;
        this.f9470k = obj4;
        this.f9471l = obj5;
        this.f9472m = obj6;
        this.f9473n = obj7;
        this.f9474o = obj8;
        this.f9475p = obj9;
        this.f9476q = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.f9466g.invoke(this.f9467h, this.f9468i, this.f9469j, this.f9470k, this.f9471l, this.f9472m, this.f9473n, this.f9474o, this.f9475p, composer, this.f9476q | 1);
    }
}
