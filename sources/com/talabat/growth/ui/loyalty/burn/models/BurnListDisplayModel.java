package com.talabat.growth.ui.loyalty.burn.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "", "pageNumber", "", "pageSize", "totalCount", "data", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "(IIILjava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getPageNumber", "()I", "setPageNumber", "(I)V", "getPageSize", "setPageSize", "getTotalCount", "setTotalCount", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnListDisplayModel {
    @NotNull
    private List<BurnItemCategoryDisplayModel> data;
    private int pageNumber;
    private int pageSize;
    private int totalCount;

    public BurnListDisplayModel() {
        this(0, 0, 0, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public BurnListDisplayModel(int i11, int i12, int i13, @NotNull List<BurnItemCategoryDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.pageNumber = i11;
        this.pageSize = i12;
        this.totalCount = i13;
        this.data = list;
    }

    @NotNull
    public final List<BurnItemCategoryDisplayModel> getData() {
        return this.data;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setData(@NotNull List<BurnItemCategoryDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setTotalCount(int i11) {
        this.totalCount = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BurnListDisplayModel(int i11, int i12, int i13, List list, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 1 : i11, (i14 & 2) != 0 ? 20 : i12, (i14 & 4) != 0 ? 0 : i13, (i14 & 8) != 0 ? new ArrayList() : list);
    }
}
