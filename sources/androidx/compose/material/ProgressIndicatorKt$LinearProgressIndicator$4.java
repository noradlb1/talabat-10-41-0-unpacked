package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4969g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4970h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4971i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4972j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4973k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$4(Modifier modifier, long j11, long j12, int i11, int i12) {
        super(2);
        this.f4969g = modifier;
        this.f4970h = j11;
        this.f4971i = j12;
        this.f4972j = i11;
        this.f4973k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1329LinearProgressIndicatorRIQooxk(this.f4969g, this.f4970h, this.f4971i, composer, this.f4972j | 1, this.f4973k);
    }
}
