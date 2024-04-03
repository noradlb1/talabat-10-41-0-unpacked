package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9426g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9427h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9428i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9429j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9430k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f9431l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$4(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, int i11) {
        super(2);
        this.f9426g = composableLambdaImpl;
        this.f9427h = obj;
        this.f9428i = obj2;
        this.f9429j = obj3;
        this.f9430k = obj4;
        this.f9431l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.f9426g.invoke(this.f9427h, this.f9428i, this.f9429j, this.f9430k, composer, this.f9431l | 1);
    }
}
