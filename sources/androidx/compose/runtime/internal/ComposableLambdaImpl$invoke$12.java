package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$12 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9292g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9293h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9294i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9295j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9296k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9297l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9298m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9299n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9300o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Object f9301p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Object f9302q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f9303r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Object f9304s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f9305t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f9306u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$12(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, int i11, int i12) {
        super(2);
        this.f9292g = composableLambdaImpl;
        this.f9293h = obj;
        this.f9294i = obj2;
        this.f9295j = obj3;
        this.f9296k = obj4;
        this.f9297l = obj5;
        this.f9298m = obj6;
        this.f9299n = obj7;
        this.f9300o = obj8;
        this.f9301p = obj9;
        this.f9302q = obj10;
        this.f9303r = obj11;
        this.f9304s = obj12;
        this.f9305t = i11;
        this.f9306u = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(composer2, "nc");
        this.f9292g.invoke(this.f9293h, this.f9294i, this.f9295j, this.f9296k, this.f9297l, this.f9298m, this.f9299n, this.f9300o, this.f9301p, this.f9302q, this.f9303r, this.f9304s, composer2, this.f9305t | 1, this.f9306u);
    }
}
