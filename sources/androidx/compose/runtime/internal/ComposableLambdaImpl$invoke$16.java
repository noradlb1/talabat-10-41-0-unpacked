package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$16 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9358g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9359h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9360i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9361j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9362k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9363l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9364m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9365n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9366o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Object f9367p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Object f9368q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f9369r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Object f9370s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f9371t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Object f9372u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Object f9373v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Object f9374w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f9375x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f9376y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$16(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, int i11, int i12) {
        super(2);
        this.f9358g = composableLambdaImpl;
        this.f9359h = obj;
        this.f9360i = obj2;
        this.f9361j = obj3;
        this.f9362k = obj4;
        this.f9363l = obj5;
        this.f9364m = obj6;
        this.f9365n = obj7;
        this.f9366o = obj8;
        this.f9367p = obj9;
        this.f9368q = obj10;
        this.f9369r = obj11;
        this.f9370s = obj12;
        this.f9371t = obj13;
        this.f9372u = obj14;
        this.f9373v = obj15;
        this.f9374w = obj16;
        this.f9375x = i11;
        this.f9376y = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(composer, "nc");
        ComposableLambdaImpl composableLambdaImpl = this.f9358g;
        ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
        composableLambdaImpl2.invoke(this.f9359h, this.f9360i, this.f9361j, this.f9362k, this.f9363l, this.f9364m, this.f9365n, this.f9366o, this.f9367p, this.f9368q, this.f9369r, this.f9370s, this.f9371t, this.f9372u, this.f9373v, this.f9374w, composer2, this.f9375x | 1, this.f9376y);
    }
}
