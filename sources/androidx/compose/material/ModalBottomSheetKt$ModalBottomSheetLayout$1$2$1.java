package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1 extends Lambda implements Function1<Density, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModalBottomSheetState f4716g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4717h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1(ModalBottomSheetState modalBottomSheetState, float f11) {
        super(1);
        this.f4716g = modalBottomSheetState;
        this.f4717h = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5587boximpl(m1302invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1302invokeBjo55l4(@NotNull Density density) {
        int i11;
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        if (this.f4716g.getAnchors$material_release().isEmpty()) {
            i11 = MathKt__MathJVMKt.roundToInt(this.f4717h);
        } else {
            i11 = MathKt__MathJVMKt.roundToInt(this.f4716g.getOffset().getValue().floatValue());
        }
        return IntOffsetKt.IntOffset(0, i11);
    }
}
