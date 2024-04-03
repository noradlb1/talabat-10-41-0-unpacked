package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4936g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4937h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4938i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f4939j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4940k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4941l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$2(float f11, Modifier modifier, long j11, float f12, int i11, int i12) {
        super(2);
        this.f4936g = f11;
        this.f4937h = modifier;
        this.f4938i = j11;
        this.f4939j = f12;
        this.f4940k = i11;
        this.f4941l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressIndicatorKt.m1323CircularProgressIndicatorMBs18nI(this.f4936g, this.f4937h, this.f4938i, this.f4939j, composer, this.f4940k | 1, this.f4941l);
    }
}
