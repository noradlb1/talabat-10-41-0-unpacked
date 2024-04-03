package androidx.compose.foundation.selection;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectableKt$selectable$4$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3226g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableKt$selectable$4$1(boolean z11) {
        super(1);
        this.f3226g = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, this.f3226g);
    }
}
