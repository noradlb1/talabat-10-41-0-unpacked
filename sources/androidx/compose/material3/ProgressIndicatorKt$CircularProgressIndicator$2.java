package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f7786g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7787h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7788i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f7789j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7790k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7791l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$2(float f11, Modifier modifier, long j11, float f12, int i11, int i12) {
        super(2);
        this.f7786g = f11;
        this.f7787h = modifier;
        this.f7788i = j11;
        this.f7789j = f12;
        this.f7790k = i11;
        this.f7791l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1796CircularProgressIndicatorMBs18nI(this.f7786g, this.f7787h, this.f7788i, this.f7789j, composer, this.f7790k | 1, this.f7791l);
    }
}
