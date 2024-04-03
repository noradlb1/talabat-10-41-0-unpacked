package androidx.paging;

import androidx.annotation.VisibleForTesting;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "generationId", "", "hint", "Landroidx/paging/ViewportHint;", "(ILandroidx/paging/ViewportHint;)V", "getGenerationId", "()I", "getHint", "()Landroidx/paging/ViewportHint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "presentedItemsBeyondAnchor", "loadType", "Landroidx/paging/LoadType;", "presentedItemsBeyondAnchor$paging_common", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting
public final class GenerationalViewportHint {
    private final int generationId;
    @NotNull
    private final ViewportHint hint;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
        }
    }

    public GenerationalViewportHint(int i11, @NotNull ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, ViewHierarchyConstants.HINT_KEY);
        this.generationId = i11;
        this.hint = viewportHint;
    }

    public static /* synthetic */ GenerationalViewportHint copy$default(GenerationalViewportHint generationalViewportHint, int i11, ViewportHint viewportHint, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = generationalViewportHint.generationId;
        }
        if ((i12 & 2) != 0) {
            viewportHint = generationalViewportHint.hint;
        }
        return generationalViewportHint.copy(i11, viewportHint);
    }

    public final int component1() {
        return this.generationId;
    }

    @NotNull
    public final ViewportHint component2() {
        return this.hint;
    }

    @NotNull
    public final GenerationalViewportHint copy(int i11, @NotNull ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, ViewHierarchyConstants.HINT_KEY);
        return new GenerationalViewportHint(i11, viewportHint);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenerationalViewportHint)) {
            return false;
        }
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) obj;
        return this.generationId == generationalViewportHint.generationId && Intrinsics.areEqual((Object) this.hint, (Object) generationalViewportHint.hint);
    }

    public final int getGenerationId() {
        return this.generationId;
    }

    @NotNull
    public final ViewportHint getHint() {
        return this.hint;
    }

    public int hashCode() {
        int i11 = this.generationId * 31;
        ViewportHint viewportHint = this.hint;
        return i11 + (viewportHint != null ? viewportHint.hashCode() : 0);
    }

    public final int presentedItemsBeyondAnchor$paging_common(@NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i11 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i11 == 1) {
            throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
        } else if (i11 == 2) {
            return this.hint.getPresentedItemsBefore();
        } else {
            if (i11 == 3) {
                return this.hint.getPresentedItemsAfter();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.generationId + ", hint=" + this.hint + ")";
    }
}
