package datamodels;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Ldatamodels/ReorderItemMissingModel;", "", "isReOrderModified", "", "itemStatus", "", "Ldatamodels/ReorderItemStatus;", "(ZLjava/util/List;)V", "()Z", "getItemStatus", "()Ljava/util/List;", "reorderStatusContent", "", "getReorderStatusContent", "()Ljava/lang/String;", "reorderStatusTitle", "getReorderStatusTitle", "component1", "component2", "copy", "equals", "other", "hasReorderStatus", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReorderItemMissingModel {
    private final boolean isReOrderModified;
    @NotNull
    private final List<ReorderItemStatus> itemStatus;
    @NotNull
    private final String reorderStatusContent;
    @NotNull
    private final String reorderStatusTitle;

    public ReorderItemMissingModel() {
        this(false, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public ReorderItemMissingModel(boolean z11, @NotNull List<ReorderItemStatus> list) {
        Intrinsics.checkNotNullParameter(list, "itemStatus");
        this.isReOrderModified = z11;
        this.itemStatus = list;
        String str = "";
        this.reorderStatusContent = (!hasReorderStatus() || !(StringsKt__StringsJVMKt.isBlank(list.get(0).getMessage()) ^ true)) ? str : list.get(0).getMessage();
        if (hasReorderStatus() && (!StringsKt__StringsJVMKt.isBlank(list.get(0).getTitle()))) {
            str = list.get(0).getTitle() + " - ";
        }
        this.reorderStatusTitle = str;
    }

    public static /* synthetic */ ReorderItemMissingModel copy$default(ReorderItemMissingModel reorderItemMissingModel, boolean z11, List<ReorderItemStatus> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = reorderItemMissingModel.isReOrderModified;
        }
        if ((i11 & 2) != 0) {
            list = reorderItemMissingModel.itemStatus;
        }
        return reorderItemMissingModel.copy(z11, list);
    }

    public final boolean component1() {
        return this.isReOrderModified;
    }

    @NotNull
    public final List<ReorderItemStatus> component2() {
        return this.itemStatus;
    }

    @NotNull
    public final ReorderItemMissingModel copy(boolean z11, @NotNull List<ReorderItemStatus> list) {
        Intrinsics.checkNotNullParameter(list, "itemStatus");
        return new ReorderItemMissingModel(z11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReorderItemMissingModel)) {
            return false;
        }
        ReorderItemMissingModel reorderItemMissingModel = (ReorderItemMissingModel) obj;
        return this.isReOrderModified == reorderItemMissingModel.isReOrderModified && Intrinsics.areEqual((Object) this.itemStatus, (Object) reorderItemMissingModel.itemStatus);
    }

    @NotNull
    public final List<ReorderItemStatus> getItemStatus() {
        return this.itemStatus;
    }

    @NotNull
    public final String getReorderStatusContent() {
        return this.reorderStatusContent;
    }

    @NotNull
    public final String getReorderStatusTitle() {
        return this.reorderStatusTitle;
    }

    public final boolean hasReorderStatus() {
        return (this.itemStatus.isEmpty() ^ true) && this.isReOrderModified;
    }

    public int hashCode() {
        boolean z11 = this.isReOrderModified;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.itemStatus.hashCode();
    }

    public final boolean isReOrderModified() {
        return this.isReOrderModified;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isReOrderModified;
        List<ReorderItemStatus> list = this.itemStatus;
        return "ReorderItemMissingModel(isReOrderModified=" + z11 + ", itemStatus=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderItemMissingModel(boolean z11, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? new ArrayList() : list);
    }
}
