package com.talabat.feature.pickup.data.events.swimlanes;

import com.visa.checkout.PurchaseInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 92\u00020\u0001:\u00019Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\bHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014¨\u0006:"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "", "swimlaneTitleList", "", "swimlaneStrategyList", "swimlaneStrategy", "shopIds", "index", "", "slug", "swimlanesTotal", "shopsTotal", "requestId", "tilesDisplayed", "vendorId", "branchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getBranchId", "()Ljava/lang/Integer;", "setBranchId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIndex", "()I", "getRequestId", "()Ljava/lang/String;", "getShopIds", "getShopsTotal", "getSlug", "getSwimlaneStrategy", "getSwimlaneStrategyList", "getSwimlaneTitleList", "getSwimlanesTotal", "getTilesDisplayed", "setTilesDisplayed", "(I)V", "getVendorId", "setVendorId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "equals", "", "other", "hashCode", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesTracking {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private Integer branchId;
    private final int index;
    @NotNull
    private final String requestId;
    @NotNull
    private final String shopIds;
    private final int shopsTotal;
    @NotNull
    private final String slug;
    @NotNull
    private final String swimlaneStrategy;
    @NotNull
    private final String swimlaneStrategyList;
    @NotNull
    private final String swimlaneTitleList;
    private final int swimlanesTotal;
    private int tilesDisplayed;
    @Nullable
    private Integer vendorId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking$Companion;", "", "()V", "commonAttributes", "", "", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<String, Object> commonAttributes(@NotNull SwimlanesTracking swimlanesTracking) {
            Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
            return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", "pickup_vendor_list"), TuplesKt.to("screenType", "shop_list"), TuplesKt.to("swimlaneTilesDisplayed", Integer.valueOf(swimlanesTracking.getTilesDisplayed())), TuplesKt.to("swimlaneTotal", Integer.valueOf(swimlanesTracking.getSwimlanesTotal())), TuplesKt.to("swimlanePosition", Integer.valueOf(swimlanesTracking.getIndex() + 1)), TuplesKt.to("swimlaneTitle", swimlanesTracking.getSlug()), TuplesKt.to("swimlaneTitleList", swimlanesTracking.getSwimlaneTitleList()), TuplesKt.to("swimlaneStrategyList", swimlanesTracking.getSwimlaneStrategyList()), TuplesKt.to("swimlaneStrategy", swimlanesTracking.getSwimlaneStrategy()), TuplesKt.to("swimlaneLength", Integer.valueOf(swimlanesTracking.getShopsTotal())), TuplesKt.to("swimlaneRequestId", swimlanesTracking.getRequestId()), TuplesKt.to("shopsIds", swimlanesTracking.getShopIds()));
        }
    }

    public SwimlanesTracking(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull String str5, int i12, int i13, @NotNull String str6, int i14, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "swimlaneTitleList");
        Intrinsics.checkNotNullParameter(str2, "swimlaneStrategyList");
        Intrinsics.checkNotNullParameter(str3, "swimlaneStrategy");
        Intrinsics.checkNotNullParameter(str4, "shopIds");
        Intrinsics.checkNotNullParameter(str5, "slug");
        Intrinsics.checkNotNullParameter(str6, PurchaseInfo.REQUEST_ID);
        this.swimlaneTitleList = str;
        this.swimlaneStrategyList = str2;
        this.swimlaneStrategy = str3;
        this.shopIds = str4;
        this.index = i11;
        this.slug = str5;
        this.swimlanesTotal = i12;
        this.shopsTotal = i13;
        this.requestId = str6;
        this.tilesDisplayed = i14;
        this.vendorId = num;
        this.branchId = num2;
    }

    public static /* synthetic */ SwimlanesTracking copy$default(SwimlanesTracking swimlanesTracking, String str, String str2, String str3, String str4, int i11, String str5, int i12, int i13, String str6, int i14, Integer num, Integer num2, int i15, Object obj) {
        SwimlanesTracking swimlanesTracking2 = swimlanesTracking;
        int i16 = i15;
        return swimlanesTracking.copy((i16 & 1) != 0 ? swimlanesTracking2.swimlaneTitleList : str, (i16 & 2) != 0 ? swimlanesTracking2.swimlaneStrategyList : str2, (i16 & 4) != 0 ? swimlanesTracking2.swimlaneStrategy : str3, (i16 & 8) != 0 ? swimlanesTracking2.shopIds : str4, (i16 & 16) != 0 ? swimlanesTracking2.index : i11, (i16 & 32) != 0 ? swimlanesTracking2.slug : str5, (i16 & 64) != 0 ? swimlanesTracking2.swimlanesTotal : i12, (i16 & 128) != 0 ? swimlanesTracking2.shopsTotal : i13, (i16 & 256) != 0 ? swimlanesTracking2.requestId : str6, (i16 & 512) != 0 ? swimlanesTracking2.tilesDisplayed : i14, (i16 & 1024) != 0 ? swimlanesTracking2.vendorId : num, (i16 & 2048) != 0 ? swimlanesTracking2.branchId : num2);
    }

    @NotNull
    public final String component1() {
        return this.swimlaneTitleList;
    }

    public final int component10() {
        return this.tilesDisplayed;
    }

    @Nullable
    public final Integer component11() {
        return this.vendorId;
    }

    @Nullable
    public final Integer component12() {
        return this.branchId;
    }

    @NotNull
    public final String component2() {
        return this.swimlaneStrategyList;
    }

    @NotNull
    public final String component3() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final String component4() {
        return this.shopIds;
    }

    public final int component5() {
        return this.index;
    }

    @NotNull
    public final String component6() {
        return this.slug;
    }

    public final int component7() {
        return this.swimlanesTotal;
    }

    public final int component8() {
        return this.shopsTotal;
    }

    @NotNull
    public final String component9() {
        return this.requestId;
    }

    @NotNull
    public final SwimlanesTracking copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull String str5, int i12, int i13, @NotNull String str6, int i14, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "swimlaneTitleList");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "swimlaneStrategyList");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "swimlaneStrategy");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "shopIds");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "slug");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, PurchaseInfo.REQUEST_ID);
        return new SwimlanesTracking(str, str7, str8, str9, i11, str10, i12, i13, str11, i14, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesTracking)) {
            return false;
        }
        SwimlanesTracking swimlanesTracking = (SwimlanesTracking) obj;
        return Intrinsics.areEqual((Object) this.swimlaneTitleList, (Object) swimlanesTracking.swimlaneTitleList) && Intrinsics.areEqual((Object) this.swimlaneStrategyList, (Object) swimlanesTracking.swimlaneStrategyList) && Intrinsics.areEqual((Object) this.swimlaneStrategy, (Object) swimlanesTracking.swimlaneStrategy) && Intrinsics.areEqual((Object) this.shopIds, (Object) swimlanesTracking.shopIds) && this.index == swimlanesTracking.index && Intrinsics.areEqual((Object) this.slug, (Object) swimlanesTracking.slug) && this.swimlanesTotal == swimlanesTracking.swimlanesTotal && this.shopsTotal == swimlanesTracking.shopsTotal && Intrinsics.areEqual((Object) this.requestId, (Object) swimlanesTracking.requestId) && this.tilesDisplayed == swimlanesTracking.tilesDisplayed && Intrinsics.areEqual((Object) this.vendorId, (Object) swimlanesTracking.vendorId) && Intrinsics.areEqual((Object) this.branchId, (Object) swimlanesTracking.branchId);
    }

    @Nullable
    public final Integer getBranchId() {
        return this.branchId;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getShopIds() {
        return this.shopIds;
    }

    public final int getShopsTotal() {
        return this.shopsTotal;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getSwimlaneStrategy() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final String getSwimlaneStrategyList() {
        return this.swimlaneStrategyList;
    }

    @NotNull
    public final String getSwimlaneTitleList() {
        return this.swimlaneTitleList;
    }

    public final int getSwimlanesTotal() {
        return this.swimlanesTotal;
    }

    public final int getTilesDisplayed() {
        return this.tilesDisplayed;
    }

    @Nullable
    public final Integer getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.swimlaneTitleList.hashCode() * 31) + this.swimlaneStrategyList.hashCode()) * 31) + this.swimlaneStrategy.hashCode()) * 31) + this.shopIds.hashCode()) * 31) + this.index) * 31) + this.slug.hashCode()) * 31) + this.swimlanesTotal) * 31) + this.shopsTotal) * 31) + this.requestId.hashCode()) * 31) + this.tilesDisplayed) * 31;
        Integer num = this.vendorId;
        int i11 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.branchId;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setBranchId(@Nullable Integer num) {
        this.branchId = num;
    }

    public final void setTilesDisplayed(int i11) {
        this.tilesDisplayed = i11;
    }

    public final void setVendorId(@Nullable Integer num) {
        this.vendorId = num;
    }

    @NotNull
    public String toString() {
        String str = this.swimlaneTitleList;
        String str2 = this.swimlaneStrategyList;
        String str3 = this.swimlaneStrategy;
        String str4 = this.shopIds;
        int i11 = this.index;
        String str5 = this.slug;
        int i12 = this.swimlanesTotal;
        int i13 = this.shopsTotal;
        String str6 = this.requestId;
        int i14 = this.tilesDisplayed;
        Integer num = this.vendorId;
        Integer num2 = this.branchId;
        return "SwimlanesTracking(swimlaneTitleList=" + str + ", swimlaneStrategyList=" + str2 + ", swimlaneStrategy=" + str3 + ", shopIds=" + str4 + ", index=" + i11 + ", slug=" + str5 + ", swimlanesTotal=" + i12 + ", shopsTotal=" + i13 + ", requestId=" + str6 + ", tilesDisplayed=" + i14 + ", vendorId=" + num + ", branchId=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SwimlanesTracking(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, int r22, int r23, java.lang.String r24, int r25, java.lang.Integer r26, java.lang.Integer r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 3
            r12 = r1
            goto L_0x000b
        L_0x0009:
            r12 = r25
        L_0x000b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r13 = r2
            goto L_0x0014
        L_0x0012:
            r13 = r26
        L_0x0014:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x001a
            r14 = r2
            goto L_0x001c
        L_0x001a:
            r14 = r27
        L_0x001c:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, java.lang.String, int, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
