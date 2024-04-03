package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$18 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ int A;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9397g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9398h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9399i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9400j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9401k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9402l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9403m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9404n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9405o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Object f9406p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Object f9407q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f9408r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Object f9409s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f9410t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Object f9411u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Object f9412v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Object f9413w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Object f9414x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Object f9415y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f9416z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$18(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, int i11, int i12) {
        super(2);
        this.f9397g = composableLambdaImpl;
        this.f9398h = obj;
        this.f9399i = obj2;
        this.f9400j = obj3;
        this.f9401k = obj4;
        this.f9402l = obj5;
        this.f9403m = obj6;
        this.f9404n = obj7;
        this.f9405o = obj8;
        this.f9406p = obj9;
        this.f9407q = obj10;
        this.f9408r = obj11;
        this.f9409s = obj12;
        this.f9410t = obj13;
        this.f9411u = obj14;
        this.f9412v = obj15;
        this.f9413w = obj16;
        this.f9414x = obj17;
        this.f9415y = obj18;
        this.f9416z = i11;
        this.A = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(composer, "nc");
        ComposableLambdaImpl composableLambdaImpl = this.f9397g;
        ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
        composableLambdaImpl2.invoke(this.f9398h, this.f9399i, this.f9400j, this.f9401k, this.f9402l, this.f9403m, this.f9404n, this.f9405o, this.f9406p, this.f9407q, this.f9408r, this.f9409s, this.f9410t, this.f9411u, this.f9412v, this.f9413w, this.f9414x, this.f9415y, composer2, this.f9416z | 1, this.A);
    }
}
