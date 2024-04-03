package androidx.paging;

import androidx.paging.ViewportHint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"shouldPrioritizeOver", "", "Landroidx/paging/GenerationalViewportHint;", "previous", "loadType", "Landroidx/paging/LoadType;", "paging-common"}, k = 2, mv = {1, 4, 2})
public final class PageFetcherSnapshotKt {
    public static final boolean shouldPrioritizeOver(@NotNull GenerationalViewportHint generationalViewportHint, @NotNull GenerationalViewportHint generationalViewportHint2, @NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(generationalViewportHint, "$this$shouldPrioritizeOver");
        Intrinsics.checkNotNullParameter(generationalViewportHint2, "previous");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        if (generationalViewportHint.getGenerationId() > generationalViewportHint2.getGenerationId()) {
            return true;
        }
        if ((generationalViewportHint2.getHint() instanceof ViewportHint.Initial) && (generationalViewportHint.getHint() instanceof ViewportHint.Access)) {
            return true;
        }
        if (!(generationalViewportHint.getHint() instanceof ViewportHint.Initial) || !(generationalViewportHint2.getHint() instanceof ViewportHint.Access)) {
            if (generationalViewportHint.getHint().getOriginalPageOffsetFirst() != generationalViewportHint2.getHint().getOriginalPageOffsetFirst() || generationalViewportHint.getHint().getOriginalPageOffsetLast() != generationalViewportHint2.getHint().getOriginalPageOffsetLast()) {
                return true;
            }
            if ((loadType != LoadType.PREPEND || generationalViewportHint2.getHint().getPresentedItemsBefore() >= generationalViewportHint.getHint().getPresentedItemsBefore()) && (loadType != LoadType.APPEND || generationalViewportHint2.getHint().getPresentedItemsAfter() >= generationalViewportHint.getHint().getPresentedItemsAfter())) {
                return true;
            }
        }
        return false;
    }
}
