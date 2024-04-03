package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7819g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f7820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7821i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7822j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7823k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$4(Modifier modifier, long j11, long j12, int i11, int i12) {
        super(2);
        this.f7819g = modifier;
        this.f7820h = j11;
        this.f7821i = j12;
        this.f7822j = i11;
        this.f7823k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1798LinearProgressIndicatorRIQooxk(this.f7819g, this.f7820h, this.f7821i, composer, this.f7822j | 1, this.f7823k);
    }
}
