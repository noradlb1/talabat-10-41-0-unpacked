package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1 extends Lambda implements Function0<Offset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Offset> f3694g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1(State<Offset> state) {
        super(0);
        this.f3694g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m2665boximpl(m989invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m989invokeF1C5BW0() {
        return SelectionMagnifierKt$animatedSelectionMagnifier$1.m988invoke$lambda0(this.f3694g);
    }
}
