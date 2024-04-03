package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$8 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9456g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9457h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9458i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9459j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9460k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9461l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9462m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9463n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9464o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f9465p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$8(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, int i11) {
        super(2);
        this.f9456g = composableLambdaImpl;
        this.f9457h = obj;
        this.f9458i = obj2;
        this.f9459j = obj3;
        this.f9460k = obj4;
        this.f9461l = obj5;
        this.f9462m = obj6;
        this.f9463n = obj7;
        this.f9464o = obj8;
        this.f9465p = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.f9456g.invoke(this.f9457h, this.f9458i, this.f9459j, this.f9460k, this.f9461l, this.f9462m, this.f9463n, this.f9464o, composer, this.f9465p | 1);
    }
}
