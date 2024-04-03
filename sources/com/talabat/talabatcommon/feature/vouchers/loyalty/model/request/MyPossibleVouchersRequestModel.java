package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/MyPossibleVouchersRequestModel;", "", "country", "", "brandID", "", "areaId", "verticalId", "(ILjava/lang/String;II)V", "getAreaId", "()I", "setAreaId", "(I)V", "getBrandID", "()Ljava/lang/String;", "setBrandID", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getVerticalId", "setVerticalId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyPossibleVouchersRequestModel {
    private int areaId;
    @NotNull
    private String brandID;
    private int country;
    private int verticalId;

    public MyPossibleVouchersRequestModel(int i11, @NotNull String str, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "brandID");
        this.country = i11;
        this.brandID = str;
        this.areaId = i12;
        this.verticalId = i13;
    }

    public static /* synthetic */ MyPossibleVouchersRequestModel copy$default(MyPossibleVouchersRequestModel myPossibleVouchersRequestModel, int i11, String str, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = myPossibleVouchersRequestModel.country;
        }
        if ((i14 & 2) != 0) {
            str = myPossibleVouchersRequestModel.brandID;
        }
        if ((i14 & 4) != 0) {
            i12 = myPossibleVouchersRequestModel.areaId;
        }
        if ((i14 & 8) != 0) {
            i13 = myPossibleVouchersRequestModel.verticalId;
        }
        return myPossibleVouchersRequestModel.copy(i11, str, i12, i13);
    }

    public final int component1() {
        return this.country;
    }

    @NotNull
    public final String component2() {
        return this.brandID;
    }

    public final int component3() {
        return this.areaId;
    }

    public final int component4() {
        return this.verticalId;
    }

    @NotNull
    public final MyPossibleVouchersRequestModel copy(int i11, @NotNull String str, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "brandID");
        return new MyPossibleVouchersRequestModel(i11, str, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyPossibleVouchersRequestModel)) {
            return false;
        }
        MyPossibleVouchersRequestModel myPossibleVouchersRequestModel = (MyPossibleVouchersRequestModel) obj;
        return this.country == myPossibleVouchersRequestModel.country && Intrinsics.areEqual((Object) this.brandID, (Object) myPossibleVouchersRequestModel.brandID) && this.areaId == myPossibleVouchersRequestModel.areaId && this.verticalId == myPossibleVouchersRequestModel.verticalId;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getBrandID() {
        return this.brandID;
    }

    public final int getCountry() {
        return this.country;
    }

    public final int getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        return (((((this.country * 31) + this.brandID.hashCode()) * 31) + this.areaId) * 31) + this.verticalId;
    }

    public final void setAreaId(int i11) {
        this.areaId = i11;
    }

    public final void setBrandID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brandID = str;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setVerticalId(int i11) {
        this.verticalId = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.country;
        String str = this.brandID;
        int i12 = this.areaId;
        int i13 = this.verticalId;
        return "MyPossibleVouchersRequestModel(country=" + i11 + ", brandID=" + str + ", areaId=" + i12 + ", verticalId=" + i13 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyPossibleVouchersRequestModel(int i11, String str, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? -1 : i11, (i14 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, i12, i13);
    }
}
