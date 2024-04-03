package com.talabat.talabatcommon.feature.vouchers.monolith.model.requestModel;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/requestModel/GetVoucherItemsRequestModel;", "", "id", "", "branchId", "(Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVoucherItemsRequestModel {
    @NotNull
    private final String branchId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f61686id;

    public GetVoucherItemsRequestModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public GetVoucherItemsRequestModel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        this.f61686id = str;
        this.branchId = str2;
    }

    public static /* synthetic */ GetVoucherItemsRequestModel copy$default(GetVoucherItemsRequestModel getVoucherItemsRequestModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getVoucherItemsRequestModel.f61686id;
        }
        if ((i11 & 2) != 0) {
            str2 = getVoucherItemsRequestModel.branchId;
        }
        return getVoucherItemsRequestModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f61686id;
    }

    @NotNull
    public final String component2() {
        return this.branchId;
    }

    @NotNull
    public final GetVoucherItemsRequestModel copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        return new GetVoucherItemsRequestModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetVoucherItemsRequestModel)) {
            return false;
        }
        GetVoucherItemsRequestModel getVoucherItemsRequestModel = (GetVoucherItemsRequestModel) obj;
        return Intrinsics.areEqual((Object) this.f61686id, (Object) getVoucherItemsRequestModel.f61686id) && Intrinsics.areEqual((Object) this.branchId, (Object) getVoucherItemsRequestModel.branchId);
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getId() {
        return this.f61686id;
    }

    public int hashCode() {
        return (this.f61686id.hashCode() * 31) + this.branchId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f61686id;
        String str2 = this.branchId;
        return "GetVoucherItemsRequestModel(id=" + str + ", branchId=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetVoucherItemsRequestModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2);
    }
}
