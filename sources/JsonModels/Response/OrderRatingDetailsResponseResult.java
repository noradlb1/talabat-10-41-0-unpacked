package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006,"}, d2 = {"LJsonModels/Response/OrderRatingDetailsResponseResult;", "", "canRate", "", "showReasons", "vendorExperienceRatingTitle", "", "deliveryExperienceRatingTitle", "orderId", "vendorName", "branchId", "", "vendorId", "vendorLogoUrl", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCanRate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDeliveryExperienceRatingTitle", "()Ljava/lang/String;", "getOrderId", "getShowReasons", "getVendorExperienceRatingTitle", "getVendorId", "getVendorLogoUrl", "getVendorName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)LJsonModels/Response/OrderRatingDetailsResponseResult;", "equals", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingDetailsResponseResult {
    @SerializedName("branchId")
    @Nullable
    private final Integer branchId;
    @SerializedName("canRate")
    @Nullable
    private final Boolean canRate;
    @SerializedName("deliveryExperienceRatingTitle")
    @Nullable
    private final String deliveryExperienceRatingTitle;
    @SerializedName("orderId")
    @Nullable
    private final String orderId;
    @SerializedName("showReasons")
    @Nullable
    private final Boolean showReasons;
    @SerializedName("vendorExperienceRatingTitle")
    @Nullable
    private final String vendorExperienceRatingTitle;
    @SerializedName("vendorId")
    @Nullable
    private final Integer vendorId;
    @SerializedName("vendorLogoUrl")
    @Nullable
    private final String vendorLogoUrl;
    @SerializedName("vendorName")
    @Nullable
    private final String vendorName;

    public OrderRatingDetailsResponseResult() {
        this((Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public OrderRatingDetailsResponseResult(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable String str5) {
        this.canRate = bool;
        this.showReasons = bool2;
        this.vendorExperienceRatingTitle = str;
        this.deliveryExperienceRatingTitle = str2;
        this.orderId = str3;
        this.vendorName = str4;
        this.branchId = num;
        this.vendorId = num2;
        this.vendorLogoUrl = str5;
    }

    public static /* synthetic */ OrderRatingDetailsResponseResult copy$default(OrderRatingDetailsResponseResult orderRatingDetailsResponseResult, Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, int i11, Object obj) {
        OrderRatingDetailsResponseResult orderRatingDetailsResponseResult2 = orderRatingDetailsResponseResult;
        int i12 = i11;
        return orderRatingDetailsResponseResult.copy((i12 & 1) != 0 ? orderRatingDetailsResponseResult2.canRate : bool, (i12 & 2) != 0 ? orderRatingDetailsResponseResult2.showReasons : bool2, (i12 & 4) != 0 ? orderRatingDetailsResponseResult2.vendorExperienceRatingTitle : str, (i12 & 8) != 0 ? orderRatingDetailsResponseResult2.deliveryExperienceRatingTitle : str2, (i12 & 16) != 0 ? orderRatingDetailsResponseResult2.orderId : str3, (i12 & 32) != 0 ? orderRatingDetailsResponseResult2.vendorName : str4, (i12 & 64) != 0 ? orderRatingDetailsResponseResult2.branchId : num, (i12 & 128) != 0 ? orderRatingDetailsResponseResult2.vendorId : num2, (i12 & 256) != 0 ? orderRatingDetailsResponseResult2.vendorLogoUrl : str5);
    }

    @Nullable
    public final Boolean component1() {
        return this.canRate;
    }

    @Nullable
    public final Boolean component2() {
        return this.showReasons;
    }

    @Nullable
    public final String component3() {
        return this.vendorExperienceRatingTitle;
    }

    @Nullable
    public final String component4() {
        return this.deliveryExperienceRatingTitle;
    }

    @Nullable
    public final String component5() {
        return this.orderId;
    }

    @Nullable
    public final String component6() {
        return this.vendorName;
    }

    @Nullable
    public final Integer component7() {
        return this.branchId;
    }

    @Nullable
    public final Integer component8() {
        return this.vendorId;
    }

    @Nullable
    public final String component9() {
        return this.vendorLogoUrl;
    }

    @NotNull
    public final OrderRatingDetailsResponseResult copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable String str5) {
        return new OrderRatingDetailsResponseResult(bool, bool2, str, str2, str3, str4, num, num2, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRatingDetailsResponseResult)) {
            return false;
        }
        OrderRatingDetailsResponseResult orderRatingDetailsResponseResult = (OrderRatingDetailsResponseResult) obj;
        return Intrinsics.areEqual((Object) this.canRate, (Object) orderRatingDetailsResponseResult.canRate) && Intrinsics.areEqual((Object) this.showReasons, (Object) orderRatingDetailsResponseResult.showReasons) && Intrinsics.areEqual((Object) this.vendorExperienceRatingTitle, (Object) orderRatingDetailsResponseResult.vendorExperienceRatingTitle) && Intrinsics.areEqual((Object) this.deliveryExperienceRatingTitle, (Object) orderRatingDetailsResponseResult.deliveryExperienceRatingTitle) && Intrinsics.areEqual((Object) this.orderId, (Object) orderRatingDetailsResponseResult.orderId) && Intrinsics.areEqual((Object) this.vendorName, (Object) orderRatingDetailsResponseResult.vendorName) && Intrinsics.areEqual((Object) this.branchId, (Object) orderRatingDetailsResponseResult.branchId) && Intrinsics.areEqual((Object) this.vendorId, (Object) orderRatingDetailsResponseResult.vendorId) && Intrinsics.areEqual((Object) this.vendorLogoUrl, (Object) orderRatingDetailsResponseResult.vendorLogoUrl);
    }

    @Nullable
    public final Integer getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final Boolean getCanRate() {
        return this.canRate;
    }

    @Nullable
    public final String getDeliveryExperienceRatingTitle() {
        return this.deliveryExperienceRatingTitle;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final Boolean getShowReasons() {
        return this.showReasons;
    }

    @Nullable
    public final String getVendorExperienceRatingTitle() {
        return this.vendorExperienceRatingTitle;
    }

    @Nullable
    public final Integer getVendorId() {
        return this.vendorId;
    }

    @Nullable
    public final String getVendorLogoUrl() {
        return this.vendorLogoUrl;
    }

    @Nullable
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        Boolean bool = this.canRate;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.showReasons;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.vendorExperienceRatingTitle;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deliveryExperienceRatingTitle;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.vendorName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.branchId;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.vendorId;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.vendorLogoUrl;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.canRate;
        Boolean bool2 = this.showReasons;
        String str = this.vendorExperienceRatingTitle;
        String str2 = this.deliveryExperienceRatingTitle;
        String str3 = this.orderId;
        String str4 = this.vendorName;
        Integer num = this.branchId;
        Integer num2 = this.vendorId;
        String str5 = this.vendorLogoUrl;
        return "OrderRatingDetailsResponseResult(canRate=" + bool + ", showReasons=" + bool2 + ", vendorExperienceRatingTitle=" + str + ", deliveryExperienceRatingTitle=" + str2 + ", orderId=" + str3 + ", vendorName=" + str4 + ", branchId=" + num + ", vendorId=" + num2 + ", vendorLogoUrl=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderRatingDetailsResponseResult(java.lang.Boolean r11, java.lang.Boolean r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = ""
            goto L_0x0046
        L_0x0044:
            r0 = r19
        L_0x0046:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.OrderRatingDetailsResponseResult.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
