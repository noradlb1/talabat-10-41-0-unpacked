package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f7807g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7808h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7809i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7810j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7811k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7812l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$2(float f11, Modifier modifier, long j11, long j12, int i11, int i12) {
        super(2);
        this.f7807g = f11;
        this.f7808h = modifier;
        this.f7809i = j11;
        this.f7810j = j12;
        this.f7811k = i11;
        this.f7812l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1799LinearProgressIndicatoreaDK9VM(this.f7807g, this.f7808h, this.f7809i, this.f7810j, composer, this.f7811k | 1, this.f7812l);
    }
}
