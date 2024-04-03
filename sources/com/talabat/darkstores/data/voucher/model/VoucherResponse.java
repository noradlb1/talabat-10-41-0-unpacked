package com.talabat.darkstores.data.voucher.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/voucher/model/VoucherResponse;", "", "type", "", "data", "Lcom/talabat/darkstores/data/voucher/model/Voucher;", "(Ljava/lang/String;Lcom/talabat/darkstores/data/voucher/model/Voucher;)V", "getData", "()Lcom/talabat/darkstores/data/voucher/model/Voucher;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherResponse {
    @Nullable
    private final Voucher data;
    @Nullable
    private final String type;

    public VoucherResponse() {
        this((String) null, (Voucher) null, 3, (DefaultConstructorMarker) null);
    }

    public VoucherResponse(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "data") Voucher voucher) {
        this.type = str;
        this.data = voucher;
    }

    public static /* synthetic */ VoucherResponse copy$default(VoucherResponse voucherResponse, String str, Voucher voucher, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherResponse.type;
        }
        if ((i11 & 2) != 0) {
            voucher = voucherResponse.data;
        }
        return voucherResponse.copy(str, voucher);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final Voucher component2() {
        return this.data;
    }

    @NotNull
    public final VoucherResponse copy(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "data") Voucher voucher) {
        return new VoucherResponse(str, voucher);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherResponse)) {
            return false;
        }
        VoucherResponse voucherResponse = (VoucherResponse) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) voucherResponse.type) && Intrinsics.areEqual((Object) this.data, (Object) voucherResponse.data);
    }

    @Nullable
    public final Voucher getData() {
        return this.data;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Voucher voucher = this.data;
        if (voucher != null) {
            i11 = voucher.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        Voucher voucher = this.data;
        return "VoucherResponse(type=" + str + ", data=" + voucher + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherResponse(String str, Voucher voucher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : voucher);
    }
}
