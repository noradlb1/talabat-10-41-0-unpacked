package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends Lambda implements Function1<Size, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8753g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Size> f8754h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$1$1(float f11, MutableState<Size> mutableState) {
        super(1);
        this.f8753g = f11;
        this.f8754h = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1925invokeuvyYCjk(((Size) obj).m2750unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m1925invokeuvyYCjk(long j11) {
        boolean z11;
        float r02 = Size.m2745getWidthimpl(j11) * this.f8753g;
        float r62 = Size.m2742getHeightimpl(j11) * this.f8753g;
        boolean z12 = true;
        if (Size.m2745getWidthimpl(this.f8754h.getValue().m2750unboximpl()) == r02) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (Size.m2742getHeightimpl(this.f8754h.getValue().m2750unboximpl()) != r62) {
                z12 = false;
            }
            if (z12) {
                return;
            }
        }
        this.f8754h.setValue(Size.m2733boximpl(SizeKt.Size(r02, r62)));
    }
}
