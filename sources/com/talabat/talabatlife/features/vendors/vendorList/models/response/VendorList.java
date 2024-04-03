package com.talabat.talabatlife.features.vendors.vendorList.models.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/VendorList;", "", "()V", "data", "", "Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/Vendor;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "newTagText", "", "getNewTagText", "()Ljava/lang/String;", "pageNumber", "", "getPageNumber", "()Ljava/lang/Integer;", "setPageNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageSize", "getPageSize", "setPageSize", "totalCount", "getTotalCount", "setTotalCount", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorList {
    @SerializedName("data")
    @Nullable
    private List<Vendor> data;
    @SerializedName("newTitle")
    @NotNull
    private final String newTagText = "";
    @SerializedName("pageNumber")
    @Nullable
    private Integer pageNumber;
    @SerializedName("pageSize")
    @Nullable
    private Integer pageSize;
    @SerializedName("totalCount")
    @Nullable
    private Integer totalCount;

    @Nullable
    public final List<Vendor> getData() {
        return this.data;
    }

    @NotNull
    public final String getNewTagText() {
        return this.newTagText;
    }

    @Nullable
    public final Integer getPageNumber() {
        return this.pageNumber;
    }

    @Nullable
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @Nullable
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setData(@Nullable List<Vendor> list) {
        this.data = list;
    }

    public final void setPageNumber(@Nullable Integer num) {
        this.pageNumber = num;
    }

    public final void setPageSize(@Nullable Integer num) {
        this.pageSize = num;
    }

    public final void setTotalCount(@Nullable Integer num) {
        this.totalCount = num;
    }
}
