package com.talabat.talabatlife.ui.vendorList.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "", "()V", "pageNumber", "", "getPageNumber", "()I", "setPageNumber", "(I)V", "pageSize", "getPageSize", "setPageSize", "totalCount", "getTotalCount", "setTotalCount", "vendors", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "getVendors", "()Ljava/util/List;", "setVendors", "(Ljava/util/List;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListDisplayModel {
    private int pageNumber;
    private int pageSize;
    private int totalCount;
    @NotNull
    private List<VendorDisplayModel> vendors = new ArrayList();

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    @NotNull
    public final List<VendorDisplayModel> getVendors() {
        return this.vendors;
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

    public final void setVendors(@NotNull List<VendorDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.vendors = list;
    }
}
