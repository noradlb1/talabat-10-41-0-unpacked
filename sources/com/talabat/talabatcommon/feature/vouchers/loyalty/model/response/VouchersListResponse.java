package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JR\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VouchersListResponse;", "", "pageNumber", "", "pageSize", "totalCount", "totalPages", "data", "", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherItemResponse;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getPageNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getTotalCount", "getTotalPages", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VouchersListResponse;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListResponse {
    @SerializedName("data")
    @Nullable
    private final List<VoucherItemResponse> data;
    @SerializedName("pageNumber")
    @Nullable
    private final Integer pageNumber;
    @SerializedName("pageSize")
    @Nullable
    private final Integer pageSize;
    @SerializedName("totalCount")
    @Nullable
    private final Integer totalCount;
    @SerializedName("totalPages")
    @Nullable
    private final Integer totalPages;

    public VouchersListResponse() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public VouchersListResponse(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable List<VoucherItemResponse> list) {
        this.pageNumber = num;
        this.pageSize = num2;
        this.totalCount = num3;
        this.totalPages = num4;
        this.data = list;
    }

    public static /* synthetic */ VouchersListResponse copy$default(VouchersListResponse vouchersListResponse, Integer num, Integer num2, Integer num3, Integer num4, List<VoucherItemResponse> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = vouchersListResponse.pageNumber;
        }
        if ((i11 & 2) != 0) {
            num2 = vouchersListResponse.pageSize;
        }
        Integer num5 = num2;
        if ((i11 & 4) != 0) {
            num3 = vouchersListResponse.totalCount;
        }
        Integer num6 = num3;
        if ((i11 & 8) != 0) {
            num4 = vouchersListResponse.totalPages;
        }
        Integer num7 = num4;
        if ((i11 & 16) != 0) {
            list = vouchersListResponse.data;
        }
        return vouchersListResponse.copy(num, num5, num6, num7, list);
    }

    @Nullable
    public final Integer component1() {
        return this.pageNumber;
    }

    @Nullable
    public final Integer component2() {
        return this.pageSize;
    }

    @Nullable
    public final Integer component3() {
        return this.totalCount;
    }

    @Nullable
    public final Integer component4() {
        return this.totalPages;
    }

    @Nullable
    public final List<VoucherItemResponse> component5() {
        return this.data;
    }

    @NotNull
    public final VouchersListResponse copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable List<VoucherItemResponse> list) {
        return new VouchersListResponse(num, num2, num3, num4, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VouchersListResponse)) {
            return false;
        }
        VouchersListResponse vouchersListResponse = (VouchersListResponse) obj;
        return Intrinsics.areEqual((Object) this.pageNumber, (Object) vouchersListResponse.pageNumber) && Intrinsics.areEqual((Object) this.pageSize, (Object) vouchersListResponse.pageSize) && Intrinsics.areEqual((Object) this.totalCount, (Object) vouchersListResponse.totalCount) && Intrinsics.areEqual((Object) this.totalPages, (Object) vouchersListResponse.totalPages) && Intrinsics.areEqual((Object) this.data, (Object) vouchersListResponse.data);
    }

    @Nullable
    public final List<VoucherItemResponse> getData() {
        return this.data;
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

    @Nullable
    public final Integer getTotalPages() {
        return this.totalPages;
    }

    public int hashCode() {
        Integer num = this.pageNumber;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pageSize;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.totalCount;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.totalPages;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        List<VoucherItemResponse> list = this.data;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.pageNumber;
        Integer num2 = this.pageSize;
        Integer num3 = this.totalCount;
        Integer num4 = this.totalPages;
        List<VoucherItemResponse> list = this.data;
        return "VouchersListResponse(pageNumber=" + num + ", pageSize=" + num2 + ", totalCount=" + num3 + ", totalPages=" + num4 + ", data=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VouchersListResponse(java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Integer r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VouchersListResponse.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
