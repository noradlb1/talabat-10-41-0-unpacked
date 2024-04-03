package androidx.paging;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Landroidx/paging/UiReceiver;", "", "accessHint", "", "viewportHint", "Landroidx/paging/ViewportHint;", "refresh", "retry", "paging-common"}, k = 1, mv = {1, 4, 2})
public interface UiReceiver {
    void accessHint(@NotNull ViewportHint viewportHint);

    void refresh();

    void retry();
}
