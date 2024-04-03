package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/MyActiveVouchersRequestModel;", "", "country", "", "brandID", "", "(ILjava/lang/String;)V", "getBrandID", "()Ljava/lang/String;", "setBrandID", "(Ljava/lang/String;)V", "getCountry", "()I", "setCountry", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MyActiveVouchersRequestModel {
    @NotNull
    private String brandID;
    private int country;

    public MyActiveVouchersRequestModel() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public MyActiveVouchersRequestModel(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "brandID");
        this.country = i11;
        this.brandID = str;
    }

    public static /* synthetic */ MyActiveVouchersRequestModel copy$default(MyActiveVouchersRequestModel myActiveVouchersRequestModel, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = myActiveVouchersRequestModel.country;
        }
        if ((i12 & 2) != 0) {
            str = myActiveVouchersRequestModel.brandID;
        }
        return myActiveVouchersRequestModel.copy(i11, str);
    }

    public final int component1() {
        return this.country;
    }

    @NotNull
    public final String component2() {
        return this.brandID;
    }

    @NotNull
    public final MyActiveVouchersRequestModel copy(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "brandID");
        return new MyActiveVouchersRequestModel(i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyActiveVouchersRequestModel)) {
            return false;
        }
        MyActiveVouchersRequestModel myActiveVouchersRequestModel = (MyActiveVouchersRequestModel) obj;
        return this.country == myActiveVouchersRequestModel.country && Intrinsics.areEqual((Object) this.brandID, (Object) myActiveVouchersRequestModel.brandID);
    }

    @NotNull
    public final String getBrandID() {
        return this.brandID;
    }

    public final int getCountry() {
        return this.country;
    }

    public int hashCode() {
        return (this.country * 31) + this.brandID.hashCode();
    }

    public final void setBrandID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brandID = str;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.country;
        String str = this.brandID;
        return "MyActiveVouchersRequestModel(country=" + i11 + ", brandID=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyActiveVouchersRequestModel(int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
