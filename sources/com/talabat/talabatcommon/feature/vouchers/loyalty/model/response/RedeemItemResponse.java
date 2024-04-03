package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0005\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemItemResponse;", "", "customerVoucherId", "", "couponCode", "isSuccess", "", "partnerLink", "partnerButtonLink", "brandId", "", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getBrandId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponCode", "()Ljava/lang/String;", "getCustomerVoucherId", "getDescription", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPartnerButtonLink", "getPartnerLink", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemItemResponse;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemItemResponse {
    @SerializedName("brandId")
    @Nullable
    private final Integer brandId;
    @SerializedName("couponCode")
    @Nullable
    private final String couponCode;
    @SerializedName("customerVoucherId")
    @Nullable
    private final String customerVoucherId;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("isSuccess")
    @Nullable
    private final Boolean isSuccess;
    @SerializedName("partnerUrlText")
    @Nullable
    private final String partnerButtonLink;
    @SerializedName("partnerUrl")
    @Nullable
    private final String partnerLink;

    public RedeemItemResponse() {
        this((String) null, (String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public RedeemItemResponse(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5) {
        this.customerVoucherId = str;
        this.couponCode = str2;
        this.isSuccess = bool;
        this.partnerLink = str3;
        this.partnerButtonLink = str4;
        this.brandId = num;
        this.description = str5;
    }

    public static /* synthetic */ RedeemItemResponse copy$default(RedeemItemResponse redeemItemResponse, String str, String str2, Boolean bool, String str3, String str4, Integer num, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = redeemItemResponse.customerVoucherId;
        }
        if ((i11 & 2) != 0) {
            str2 = redeemItemResponse.couponCode;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            bool = redeemItemResponse.isSuccess;
        }
        Boolean bool2 = bool;
        if ((i11 & 8) != 0) {
            str3 = redeemItemResponse.partnerLink;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = redeemItemResponse.partnerButtonLink;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            num = redeemItemResponse.brandId;
        }
        Integer num2 = num;
        if ((i11 & 64) != 0) {
            str5 = redeemItemResponse.description;
        }
        return redeemItemResponse.copy(str, str6, bool2, str7, str8, num2, str5);
    }

    @Nullable
    public final String component1() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String component2() {
        return this.couponCode;
    }

    @Nullable
    public final Boolean component3() {
        return this.isSuccess;
    }

    @Nullable
    public final String component4() {
        return this.partnerLink;
    }

    @Nullable
    public final String component5() {
        return this.partnerButtonLink;
    }

    @Nullable
    public final Integer component6() {
        return this.brandId;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @NotNull
    public final RedeemItemResponse copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5) {
        return new RedeemItemResponse(str, str2, bool, str3, str4, num, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemItemResponse)) {
            return false;
        }
        RedeemItemResponse redeemItemResponse = (RedeemItemResponse) obj;
        return Intrinsics.areEqual((Object) this.customerVoucherId, (Object) redeemItemResponse.customerVoucherId) && Intrinsics.areEqual((Object) this.couponCode, (Object) redeemItemResponse.couponCode) && Intrinsics.areEqual((Object) this.isSuccess, (Object) redeemItemResponse.isSuccess) && Intrinsics.areEqual((Object) this.partnerLink, (Object) redeemItemResponse.partnerLink) && Intrinsics.areEqual((Object) this.partnerButtonLink, (Object) redeemItemResponse.partnerButtonLink) && Intrinsics.areEqual((Object) this.brandId, (Object) redeemItemResponse.brandId) && Intrinsics.areEqual((Object) this.description, (Object) redeemItemResponse.description);
    }

    @Nullable
    public final Integer getBrandId() {
        return this.brandId;
    }

    @Nullable
    public final String getCouponCode() {
        return this.couponCode;
    }

    @Nullable
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getPartnerButtonLink() {
        return this.partnerButtonLink;
    }

    @Nullable
    public final String getPartnerLink() {
        return this.partnerLink;
    }

    public int hashCode() {
        String str = this.customerVoucherId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.couponCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isSuccess;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.partnerLink;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.partnerButtonLink;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.brandId;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.description;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode6 + i11;
    }

    @Nullable
    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    @NotNull
    public String toString() {
        String str = this.customerVoucherId;
        String str2 = this.couponCode;
        Boolean bool = this.isSuccess;
        String str3 = this.partnerLink;
        String str4 = this.partnerButtonLink;
        Integer num = this.brandId;
        String str5 = this.description;
        return "RedeemItemResponse(customerVoucherId=" + str + ", couponCode=" + str2 + ", isSuccess=" + bool + ", partnerLink=" + str3 + ", partnerButtonLink=" + str4 + ", brandId=" + num + ", description=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedeemItemResponse(java.lang.String r7, java.lang.String r8, java.lang.Boolean r9, java.lang.String r10, java.lang.String r11, java.lang.Integer r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemItemResponse.<init>(java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
