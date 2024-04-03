package com.talabat.talabatcommon.feature.vouchers.monolith.model.requestModel;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/requestModel/GetGroceryItemDetailsRequestModel;", "", "groceryVendorId", "", "sku", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroceryVendorId", "()Ljava/lang/String;", "getSku", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetGroceryItemDetailsRequestModel {
    @NotNull
    private final String groceryVendorId;
    @NotNull
    private final String sku;

    public GetGroceryItemDetailsRequestModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public GetGroceryItemDetailsRequestModel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groceryVendorId");
        Intrinsics.checkNotNullParameter(str2, "sku");
        this.groceryVendorId = str;
        this.sku = str2;
    }

    public static /* synthetic */ GetGroceryItemDetailsRequestModel copy$default(GetGroceryItemDetailsRequestModel getGroceryItemDetailsRequestModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getGroceryItemDetailsRequestModel.groceryVendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = getGroceryItemDetailsRequestModel.sku;
        }
        return getGroceryItemDetailsRequestModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.groceryVendorId;
    }

    @NotNull
    public final String component2() {
        return this.sku;
    }

    @NotNull
    public final GetGroceryItemDetailsRequestModel copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "groceryVendorId");
        Intrinsics.checkNotNullParameter(str2, "sku");
        return new GetGroceryItemDetailsRequestModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetGroceryItemDetailsRequestModel)) {
            return false;
        }
        GetGroceryItemDetailsRequestModel getGroceryItemDetailsRequestModel = (GetGroceryItemDetailsRequestModel) obj;
        return Intrinsics.areEqual((Object) this.groceryVendorId, (Object) getGroceryItemDetailsRequestModel.groceryVendorId) && Intrinsics.areEqual((Object) this.sku, (Object) getGroceryItemDetailsRequestModel.sku);
    }

    @NotNull
    public final String getGroceryVendorId() {
        return this.groceryVendorId;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        return (this.groceryVendorId.hashCode() * 31) + this.sku.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.groceryVendorId;
        String str2 = this.sku;
        return "GetGroceryItemDetailsRequestModel(groceryVendorId=" + str + ", sku=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetGroceryItemDetailsRequestModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2);
    }
}
