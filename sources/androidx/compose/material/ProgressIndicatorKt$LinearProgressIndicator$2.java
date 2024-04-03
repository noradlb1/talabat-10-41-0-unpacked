package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4957g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4958h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4959i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f4960j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4961k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4962l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$2(float f11, Modifier modifier, long j11, long j12, int i11, int i12) {
        super(2);
        this.f4957g = f11;
        this.f4958h = modifier;
        this.f4959i = j11;
        this.f4960j = j12;
        this.f4961k = i11;
        this.f4962l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1330LinearProgressIndicatoreaDK9VM(this.f4957g, this.f4958h, this.f4959i, this.f4960j, composer, this.f4961k | 1, this.f4962l);
    }
}
