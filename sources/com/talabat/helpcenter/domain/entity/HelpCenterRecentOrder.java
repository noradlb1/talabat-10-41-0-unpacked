package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/talabat/helpcenter/domain/entity/HelpCenterRecentOrder;", "", "encryptedOrderId", "", "vendorName", "orderDate", "itemsCountText", "totalAmount", "", "vendorImageUrl", "verticalId", "", "vendorPhoneNumber", "isDeliveredByTalabat", "", "canTrack", "canRate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanRate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanTrack", "getEncryptedOrderId", "()Ljava/lang/String;", "getItemsCountText", "getOrderDate", "getTotalAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVendorImageUrl", "getVendorName", "getVendorPhoneNumber", "getVerticalId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/helpcenter/domain/entity/HelpCenterRecentOrder;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterRecentOrder {
    @Nullable
    private final Boolean canRate;
    @Nullable
    private final Boolean canTrack;
    @Nullable
    private final String encryptedOrderId;
    @Nullable
    private final Boolean isDeliveredByTalabat;
    @Nullable
    private final String itemsCountText;
    @Nullable
    private final String orderDate;
    @Nullable
    private final Double totalAmount;
    @Nullable
    private final String vendorImageUrl;
    @Nullable
    private final String vendorName;
    @Nullable
    private final String vendorPhoneNumber;
    @Nullable
    private final Integer verticalId;

    public HelpCenterRecentOrder() {
        this((String) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, 2047, (DefaultConstructorMarker) null);
    }

    public HelpCenterRecentOrder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        this.encryptedOrderId = str;
        this.vendorName = str2;
        this.orderDate = str3;
        this.itemsCountText = str4;
        this.totalAmount = d11;
        this.vendorImageUrl = str5;
        this.verticalId = num;
        this.vendorPhoneNumber = str6;
        this.isDeliveredByTalabat = bool;
        this.canTrack = bool2;
        this.canRate = bool3;
    }

    public static /* synthetic */ HelpCenterRecentOrder copy$default(HelpCenterRecentOrder helpCenterRecentOrder, String str, String str2, String str3, String str4, Double d11, String str5, Integer num, String str6, Boolean bool, Boolean bool2, Boolean bool3, int i11, Object obj) {
        HelpCenterRecentOrder helpCenterRecentOrder2 = helpCenterRecentOrder;
        int i12 = i11;
        return helpCenterRecentOrder.copy((i12 & 1) != 0 ? helpCenterRecentOrder2.encryptedOrderId : str, (i12 & 2) != 0 ? helpCenterRecentOrder2.vendorName : str2, (i12 & 4) != 0 ? helpCenterRecentOrder2.orderDate : str3, (i12 & 8) != 0 ? helpCenterRecentOrder2.itemsCountText : str4, (i12 & 16) != 0 ? helpCenterRecentOrder2.totalAmount : d11, (i12 & 32) != 0 ? helpCenterRecentOrder2.vendorImageUrl : str5, (i12 & 64) != 0 ? helpCenterRecentOrder2.verticalId : num, (i12 & 128) != 0 ? helpCenterRecentOrder2.vendorPhoneNumber : str6, (i12 & 256) != 0 ? helpCenterRecentOrder2.isDeliveredByTalabat : bool, (i12 & 512) != 0 ? helpCenterRecentOrder2.canTrack : bool2, (i12 & 1024) != 0 ? helpCenterRecentOrder2.canRate : bool3);
    }

    @Nullable
    public final String component1() {
        return this.encryptedOrderId;
    }

    @Nullable
    public final Boolean component10() {
        return this.canTrack;
    }

    @Nullable
    public final Boolean component11() {
        return this.canRate;
    }

    @Nullable
    public final String component2() {
        return this.vendorName;
    }

    @Nullable
    public final String component3() {
        return this.orderDate;
    }

    @Nullable
    public final String component4() {
        return this.itemsCountText;
    }

    @Nullable
    public final Double component5() {
        return this.totalAmount;
    }

    @Nullable
    public final String component6() {
        return this.vendorImageUrl;
    }

    @Nullable
    public final Integer component7() {
        return this.verticalId;
    }

    @Nullable
    public final String component8() {
        return this.vendorPhoneNumber;
    }

    @Nullable
    public final Boolean component9() {
        return this.isDeliveredByTalabat;
    }

    @NotNull
    public final HelpCenterRecentOrder copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        return new HelpCenterRecentOrder(str, str2, str3, str4, d11, str5, num, str6, bool, bool2, bool3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterRecentOrder)) {
            return false;
        }
        HelpCenterRecentOrder helpCenterRecentOrder = (HelpCenterRecentOrder) obj;
        return Intrinsics.areEqual((Object) this.encryptedOrderId, (Object) helpCenterRecentOrder.encryptedOrderId) && Intrinsics.areEqual((Object) this.vendorName, (Object) helpCenterRecentOrder.vendorName) && Intrinsics.areEqual((Object) this.orderDate, (Object) helpCenterRecentOrder.orderDate) && Intrinsics.areEqual((Object) this.itemsCountText, (Object) helpCenterRecentOrder.itemsCountText) && Intrinsics.areEqual((Object) this.totalAmount, (Object) helpCenterRecentOrder.totalAmount) && Intrinsics.areEqual((Object) this.vendorImageUrl, (Object) helpCenterRecentOrder.vendorImageUrl) && Intrinsics.areEqual((Object) this.verticalId, (Object) helpCenterRecentOrder.verticalId) && Intrinsics.areEqual((Object) this.vendorPhoneNumber, (Object) helpCenterRecentOrder.vendorPhoneNumber) && Intrinsics.areEqual((Object) this.isDeliveredByTalabat, (Object) helpCenterRecentOrder.isDeliveredByTalabat) && Intrinsics.areEqual((Object) this.canTrack, (Object) helpCenterRecentOrder.canTrack) && Intrinsics.areEqual((Object) this.canRate, (Object) helpCenterRecentOrder.canRate);
    }

    @Nullable
    public final Boolean getCanRate() {
        return this.canRate;
    }

    @Nullable
    public final Boolean getCanTrack() {
        return this.canTrack;
    }

    @Nullable
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @Nullable
    public final String getItemsCountText() {
        return this.itemsCountText;
    }

    @Nullable
    public final String getOrderDate() {
        return this.orderDate;
    }

    @Nullable
    public final Double getTotalAmount() {
        return this.totalAmount;
    }

    @Nullable
    public final String getVendorImageUrl() {
        return this.vendorImageUrl;
    }

    @Nullable
    public final String getVendorName() {
        return this.vendorName;
    }

    @Nullable
    public final String getVendorPhoneNumber() {
        return this.vendorPhoneNumber;
    }

    @Nullable
    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        String str = this.encryptedOrderId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderDate;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.itemsCountText;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d11 = this.totalAmount;
        int hashCode5 = (hashCode4 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str5 = this.vendorImageUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.verticalId;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.vendorPhoneNumber;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.isDeliveredByTalabat;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.canTrack;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canRate;
        if (bool3 != null) {
            i11 = bool3.hashCode();
        }
        return hashCode10 + i11;
    }

    @Nullable
    public final Boolean isDeliveredByTalabat() {
        return this.isDeliveredByTalabat;
    }

    @NotNull
    public String toString() {
        String str = this.encryptedOrderId;
        String str2 = this.vendorName;
        String str3 = this.orderDate;
        String str4 = this.itemsCountText;
        Double d11 = this.totalAmount;
        String str5 = this.vendorImageUrl;
        Integer num = this.verticalId;
        String str6 = this.vendorPhoneNumber;
        Boolean bool = this.isDeliveredByTalabat;
        Boolean bool2 = this.canTrack;
        Boolean bool3 = this.canRate;
        return "HelpCenterRecentOrder(encryptedOrderId=" + str + ", vendorName=" + str2 + ", orderDate=" + str3 + ", itemsCountText=" + str4 + ", totalAmount=" + d11 + ", vendorImageUrl=" + str5 + ", verticalId=" + num + ", vendorPhoneNumber=" + str6 + ", isDeliveredByTalabat=" + bool + ", canTrack=" + bool2 + ", canRate=" + bool3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HelpCenterRecentOrder(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Double r17, java.lang.String r18, java.lang.Integer r19, java.lang.String r20, java.lang.Boolean r21, java.lang.Boolean r22, java.lang.Boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.domain.entity.HelpCenterRecentOrder.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
