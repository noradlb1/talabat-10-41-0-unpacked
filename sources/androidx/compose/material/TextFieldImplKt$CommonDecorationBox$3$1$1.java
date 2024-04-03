package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends Lambda implements Function1<Size, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5948g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Size> f5949h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$1$1(float f11, MutableState<Size> mutableState) {
        super(1);
        this.f5948g = f11;
        this.f5949h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1448invokeuvyYCjk(((Size) obj).m2750unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m1448invokeuvyYCjk(long j11) {
        boolean z11;
        float r02 = Size.m2745getWidthimpl(j11) * this.f5948g;
        float r62 = Size.m2742getHeightimpl(j11) * this.f5948g;
        boolean z12 = true;
        if (Size.m2745getWidthimpl(this.f5949h.getValue().m2750unboximpl()) == r02) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (Size.m2742getHeightimpl(this.f5949h.getValue().m2750unboximpl()) != r62) {
                z12 = false;
            }
            if (z12) {
                return;
            }
        }
        this.f5949h.setValue(Size.m2733boximpl(SizeKt.Size(r02, r62)));
    }
}
