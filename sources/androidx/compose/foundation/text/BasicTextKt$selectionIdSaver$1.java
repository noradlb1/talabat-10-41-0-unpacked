package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt$selectionIdSaver$1 extends Lambda implements Function2<SaverScope, Long, Long> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionRegistrar f3339g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextKt$selectionIdSaver$1(SelectionRegistrar selectionRegistrar) {
        super(2);
        this.f3339g = selectionRegistrar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SaverScope) obj, ((Number) obj2).longValue());
    }

    @Nullable
    public final Long invoke(@NotNull SaverScope saverScope, long j11) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        if (SelectionRegistrarKt.hasSelection(this.f3339g, j11)) {
            return Long.valueOf(j11);
        }
        return null;
    }
}
