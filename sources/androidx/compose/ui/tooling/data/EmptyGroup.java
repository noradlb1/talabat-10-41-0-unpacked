package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/tooling/data/EmptyGroup;", "Landroidx/compose/ui/tooling/data/Group;", "()V", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
final class EmptyGroup extends Group {
    @NotNull
    public static final EmptyGroup INSTANCE = new EmptyGroup();

    private EmptyGroup() {
        super((Object) null, (String) null, (SourceLocation) null, SlotTreeKt.getEmptyBox(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), (DefaultConstructorMarker) null);
    }
}
