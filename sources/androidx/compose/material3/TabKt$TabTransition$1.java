package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$TabTransition$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f8570g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f8571h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8572i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8573j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8574k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$TabTransition$1(long j11, long j12, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f8570g = j11;
        this.f8571h = j12;
        this.f8572i = z11;
        this.f8573j = function2;
        this.f8574k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1884TabTransitionKlgxPg(this.f8570g, this.f8571h, this.f8572i, this.f8573j, composer, this.f8574k | 1);
    }
}
