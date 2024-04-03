package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class DividerKt$Divider$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6950g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f6951h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6952i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6953j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6954k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DividerKt$Divider$1(Modifier modifier, float f11, long j11, int i11, int i12) {
        super(2);
        this.f6950g = modifier;
        this.f6951h = f11;
        this.f6952i = j11;
        this.f6953j = i11;
        this.f6954k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DividerKt.m1645Divider9IZ8Weo(this.f6950g, this.f6951h, this.f6952i, composer, this.f6953j | 1, this.f6954k);
    }
}
