package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableLambdaImpl$invoke$10 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposableLambdaImpl f9266g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9267h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9268i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f9269j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f9270k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9271l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9272m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f9273n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Object f9274o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Object f9275p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Object f9276q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f9277r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableLambdaImpl$invoke$10(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, int i11) {
        super(2);
        this.f9266g = composableLambdaImpl;
        this.f9267h = obj;
        this.f9268i = obj2;
        this.f9269j = obj3;
        this.f9270k = obj4;
        this.f9271l = obj5;
        this.f9272m = obj6;
        this.f9273n = obj7;
        this.f9274o = obj8;
        this.f9275p = obj9;
        this.f9276q = obj10;
        this.f9277r = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(composer2, "nc");
        ComposableLambdaImpl composableLambdaImpl = this.f9266g;
        Object obj = this.f9267h;
        Object obj2 = this.f9268i;
        Object obj3 = this.f9269j;
        Object obj4 = this.f9270k;
        Object obj5 = this.f9271l;
        Object obj6 = this.f9272m;
        Object obj7 = this.f9273n;
        Object obj8 = this.f9274o;
        Object obj9 = this.f9275p;
        Object obj10 = this.f9276q;
        int i12 = this.f9277r;
        composableLambdaImpl.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, composer2, i12 | 1, i12);
    }
}
