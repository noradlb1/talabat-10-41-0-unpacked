package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowDefaults$Indicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabRowDefaults f8576g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8577h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f8578i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8579j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8580k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8581l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowDefaults$Indicator$1(TabRowDefaults tabRowDefaults, Modifier modifier, float f11, long j11, int i11, int i12) {
        super(2);
        this.f8576g = tabRowDefaults;
        this.f8577h = modifier;
        this.f8578i = f11;
        this.f8579j = j11;
        this.f8580k = i11;
        this.f8581l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f8576g.m1891Indicator9IZ8Weo(this.f8577h, this.f8578i, this.f8579j, composer, this.f8580k | 1, this.f8581l);
    }
}
