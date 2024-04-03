package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4780g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4781h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4782i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f4783j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f4784k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4785l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f4786m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4787n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f4788o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f4789p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4790q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4791r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$3(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, boolean z13, MutableInteractionSource mutableInteractionSource, long j11, long j12, int i11, int i12) {
        super(2);
        this.f4780g = z11;
        this.f4781h = function0;
        this.f4782i = function2;
        this.f4783j = modifier;
        this.f4784k = z12;
        this.f4785l = function22;
        this.f4786m = z13;
        this.f4787n = mutableInteractionSource;
        this.f4788o = j11;
        this.f4789p = j12;
        this.f4790q = i11;
        this.f4791r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.m1306NavigationRailItem0S3VyRs(this.f4780g, this.f4781h, this.f4782i, this.f4783j, this.f4784k, this.f4785l, this.f4786m, this.f4787n, this.f4788o, this.f4789p, composer, this.f4790q | 1, this.f4791r);
    }
}
