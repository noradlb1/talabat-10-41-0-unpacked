package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$4$sourceCenterInRoot$2$1 extends Lambda implements Function0<Offset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Density f1763g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Density, Offset>> f1764h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Offset> f1765i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(Density density, State<? extends Function1<? super Density, Offset>> state, MutableState<Offset> mutableState) {
        super(0);
        this.f1763g = density;
        this.f1764h = state;
        this.f1765i = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m2665boximpl(m246invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m246invokeF1C5BW0() {
        long r02 = ((Offset) MagnifierKt$magnifier$4.m240invoke$lambda3(this.f1764h).invoke(this.f1763g)).m2686unboximpl();
        if (!OffsetKt.m2695isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m237invoke$lambda1(this.f1765i)) || !OffsetKt.m2695isSpecifiedk4lQ0M(r02)) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        return Offset.m2681plusMKHz9U(MagnifierKt$magnifier$4.m237invoke$lambda1(this.f1765i), r02);
    }
}
