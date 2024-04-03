package com.talabat.growth.ui.vouchers.list.model;

import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "", "pageNumber", "", "pageSize", "totalCount", "records", "", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "(IIILjava/util/List;)V", "getPageNumber", "()I", "setPageNumber", "(I)V", "getPageSize", "setPageSize", "getRecords", "()Ljava/util/List;", "setRecords", "(Ljava/util/List;)V", "getTotalCount", "setTotalCount", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherListDisplayModel {
    private int pageNumber;
    private int pageSize;
    @NotNull
    private List<VoucherItemDisplayModel> records;
    private int totalCount;

    public VoucherListDisplayModel() {
        this(0, 0, 0, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public VoucherListDisplayModel(int i11, int i12, int i13, @NotNull List<VoucherItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.pageNumber = i11;
        this.pageSize = i12;
        this.totalCount = i13;
        this.records = list;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final List<VoucherItemDisplayModel> getRecords() {
        return this.records;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setRecords(@NotNull List<VoucherItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.records = list;
    }

    public final void setTotalCount(int i11) {
        this.totalCount = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherListDisplayModel(int i11, int i12, int i13, List list, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 1 : i11, (i14 & 2) != 0 ? 20 : i12, (i14 & 4) != 0 ? 0 : i13, (i14 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
