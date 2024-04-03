package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$TabTransition$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f5780g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f5781h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5782i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5783j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5784k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$TabTransition$1(long j11, long j12, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f5780g = j11;
        this.f5781h = j12;
        this.f5782i = z11;
        this.f5783j = function2;
        this.f5784k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1410TabTransitionKlgxPg(this.f5780g, this.f5781h, this.f5782i, this.f5783j, composer, this.f5784k | 1);
    }
}
