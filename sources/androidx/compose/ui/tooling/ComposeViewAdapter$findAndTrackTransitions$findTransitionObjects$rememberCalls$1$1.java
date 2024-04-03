package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/compose/ui/tooling/data/Group;", "call", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1 extends Lambda implements Function1<Group, Boolean> {
    public static final ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1 INSTANCE = new ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1();

    public ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, NotificationCompat.CATEGORY_CALL);
        return Boolean.valueOf(Intrinsics.areEqual((Object) group.getName(), (Object) "remember"));
    }
}
