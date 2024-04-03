package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"areObjectsOfSameType", "", "a", "", "b", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActualKt {
    public static final boolean areObjectsOfSameType(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "a");
        Intrinsics.checkNotNullParameter(obj2, "b");
        if (obj.getClass() == obj2.getClass()) {
            return true;
        }
        return false;
    }
}
