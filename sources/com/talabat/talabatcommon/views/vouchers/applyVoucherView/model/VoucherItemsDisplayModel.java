package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "", "timestamp", "", "result", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;", "baseUrl", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getResult", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;", "setResult", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsDisplayModel {
    @NotNull
    private String baseUrl;
    @NotNull
    private VoucherItemsResult result;
    @NotNull
    private String timestamp;

    public VoucherItemsDisplayModel() {
        this((String) null, (VoucherItemsResult) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public VoucherItemsDisplayModel(@NotNull String str, @NotNull VoucherItemsResult voucherItemsResult, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(voucherItemsResult, "result");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        this.timestamp = str;
        this.result = voucherItemsResult;
        this.baseUrl = str2;
    }

    public static /* synthetic */ VoucherItemsDisplayModel copy$default(VoucherItemsDisplayModel voucherItemsDisplayModel, String str, VoucherItemsResult voucherItemsResult, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherItemsDisplayModel.timestamp;
        }
        if ((i11 & 2) != 0) {
            voucherItemsResult = voucherItemsDisplayModel.result;
        }
        if ((i11 & 4) != 0) {
            str2 = voucherItemsDisplayModel.baseUrl;
        }
        return voucherItemsDisplayModel.copy(str, voucherItemsResult, str2);
    }

    @NotNull
    public final String component1() {
        return this.timestamp;
    }

    @NotNull
    public final VoucherItemsResult component2() {
        return this.result;
    }

    @NotNull
    public final String component3() {
        return this.baseUrl;
    }

    @NotNull
    public final VoucherItemsDisplayModel copy(@NotNull String str, @NotNull VoucherItemsResult voucherItemsResult, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(voucherItemsResult, "result");
        Intrinsics.checkNotNullParameter(str2, "baseUrl");
        return new VoucherItemsDisplayModel(str, voucherItemsResult, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherItemsDisplayModel)) {
            return false;
        }
        VoucherItemsDisplayModel voucherItemsDisplayModel = (VoucherItemsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) voucherItemsDisplayModel.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) voucherItemsDisplayModel.result) && Intrinsics.areEqual((Object) this.baseUrl, (Object) voucherItemsDisplayModel.baseUrl);
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final VoucherItemsResult getResult() {
        return this.result;
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((this.timestamp.hashCode() * 31) + this.result.hashCode()) * 31) + this.baseUrl.hashCode();
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setResult(@NotNull VoucherItemsResult voucherItemsResult) {
        Intrinsics.checkNotNullParameter(voucherItemsResult, "<set-?>");
        this.result = voucherItemsResult;
    }

    public final void setTimestamp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timestamp = str;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        VoucherItemsResult voucherItemsResult = this.result;
        String str2 = this.baseUrl;
        return "VoucherItemsDisplayModel(timestamp=" + str + ", result=" + voucherItemsResult + ", baseUrl=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherItemsDisplayModel(String str, VoucherItemsResult voucherItemsResult, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? new VoucherItemsResult(0, (String) null, (String) null, 0.0f, (String) null, 31, (DefaultConstructorMarker) null) : voucherItemsResult, (i11 & 4) != 0 ? "" : str2);
    }
}
