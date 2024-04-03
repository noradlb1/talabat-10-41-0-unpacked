package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt$Switch$valueToOffset$1$1 extends Lambda implements Function1<Boolean, Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8488g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f8489h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$valueToOffset$1$1(float f11, float f12) {
        super(1);
        this.f8488g = f11;
        this.f8489h = f12;
    }

    @NotNull
    public final Float invoke(boolean z11) {
        return Float.valueOf(z11 ? this.f8488g : this.f8489h);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }
}
