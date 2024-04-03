package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DividerKt$Divider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4389g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4390h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4391i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f4392j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4393k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4394l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DividerKt$Divider$1(Modifier modifier, long j11, float f11, float f12, int i11, int i12) {
        super(2);
        this.f4389g = modifier;
        this.f4390h = j11;
        this.f4391i = f11;
        this.f4392j = f12;
        this.f4393k = i11;
        this.f4394l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DividerKt.m1219DivideroMI9zvI(this.f4389g, this.f4390h, this.f4391i, this.f4392j, composer, this.f4393k | 1, this.f4394l);
    }
}
