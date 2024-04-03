package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BasicTextKt$BasicText$selectableId$1 extends Lambda implements Function0<Long> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionRegistrar f3337g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$selectableId$1(SelectionRegistrar selectionRegistrar) {
        super(0);
        this.f3337g = selectionRegistrar;
    }

    @NotNull
    public final Long invoke() {
        return Long.valueOf(this.f3337g.nextSelectableId());
    }
}
