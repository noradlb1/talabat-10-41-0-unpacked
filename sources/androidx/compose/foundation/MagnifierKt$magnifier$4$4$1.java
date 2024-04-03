package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$4$4$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Offset> f1760g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$4$1(State<Offset> state) {
        super(1);
        this.f1760g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertyKey<Function0<Offset>> magnifierPositionInRoot = MagnifierKt.getMagnifierPositionInRoot();
        final State<Offset> state = this.f1760g;
        semanticsPropertyReceiver.set(magnifierPositionInRoot, new Function0<Offset>() {
            public /* bridge */ /* synthetic */ Object invoke() {
                return Offset.m2665boximpl(m245invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0  reason: not valid java name */
            public final long m245invokeF1C5BW0() {
                return MagnifierKt$magnifier$4.m244invoke$lambda8(state);
            }
        });
    }
}
