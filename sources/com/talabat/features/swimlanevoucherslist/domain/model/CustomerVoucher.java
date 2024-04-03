package com.talabat.features.swimlanevoucherslist.domain.model;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J_\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "", "id", "", "campaignTitle", "voucherTitle", "voucherDescription", "voucherType", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;", "discountType", "Lcom/talabat/features/swimlanevoucherslist/domain/model/DiscountType;", "imageUrl", "skuIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;Lcom/talabat/features/swimlanevoucherslist/domain/model/DiscountType;Ljava/lang/String;Ljava/util/List;)V", "getCampaignTitle", "()Ljava/lang/String;", "getDiscountType", "()Lcom/talabat/features/swimlanevoucherslist/domain/model/DiscountType;", "getId", "getImageUrl", "getSkuIds", "()Ljava/util/List;", "getVoucherDescription", "getVoucherTitle", "getVoucherType", "()Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_customer-vouchers-swimlane_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerVoucher {
    @NotNull
    private final String campaignTitle;
    @NotNull
    private final DiscountType discountType;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f59462id;
    @NotNull
    private final String imageUrl;
    @NotNull
    private final List<String> skuIds;
    @NotNull
    private final String voucherDescription;
    @NotNull
    private final String voucherTitle;
    @NotNull
    private final VoucherType voucherType;

    public CustomerVoucher(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull VoucherType voucherType2, @NotNull DiscountType discountType2, @NotNull String str5, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "campaignTitle");
        Intrinsics.checkNotNullParameter(str3, "voucherTitle");
        Intrinsics.checkNotNullParameter(str4, "voucherDescription");
        Intrinsics.checkNotNullParameter(voucherType2, "voucherType");
        Intrinsics.checkNotNullParameter(discountType2, "discountType");
        Intrinsics.checkNotNullParameter(str5, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(list, "skuIds");
        this.f59462id = str;
        this.campaignTitle = str2;
        this.voucherTitle = str3;
        this.voucherDescription = str4;
        this.voucherType = voucherType2;
        this.discountType = discountType2;
        this.imageUrl = str5;
        this.skuIds = list;
    }

    public static /* synthetic */ CustomerVoucher copy$default(CustomerVoucher customerVoucher, String str, String str2, String str3, String str4, VoucherType voucherType2, DiscountType discountType2, String str5, List list, int i11, Object obj) {
        CustomerVoucher customerVoucher2 = customerVoucher;
        int i12 = i11;
        return customerVoucher.copy((i12 & 1) != 0 ? customerVoucher2.f59462id : str, (i12 & 2) != 0 ? customerVoucher2.campaignTitle : str2, (i12 & 4) != 0 ? customerVoucher2.voucherTitle : str3, (i12 & 8) != 0 ? customerVoucher2.voucherDescription : str4, (i12 & 16) != 0 ? customerVoucher2.voucherType : voucherType2, (i12 & 32) != 0 ? customerVoucher2.discountType : discountType2, (i12 & 64) != 0 ? customerVoucher2.imageUrl : str5, (i12 & 128) != 0 ? customerVoucher2.skuIds : list);
    }

    @NotNull
    public final String component1() {
        return this.f59462id;
    }

    @NotNull
    public final String component2() {
        return this.campaignTitle;
    }

    @NotNull
    public final String component3() {
        return this.voucherTitle;
    }

    @NotNull
    public final String component4() {
        return this.voucherDescription;
    }

    @NotNull
    public final VoucherType component5() {
        return this.voucherType;
    }

    @NotNull
    public final DiscountType component6() {
        return this.discountType;
    }

    @NotNull
    public final String component7() {
        return this.imageUrl;
    }

    @NotNull
    public final List<String> component8() {
        return this.skuIds;
    }

    @NotNull
    public final CustomerVoucher copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull VoucherType voucherType2, @NotNull DiscountType discountType2, @NotNull String str5, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "campaignTitle");
        Intrinsics.checkNotNullParameter(str3, "voucherTitle");
        Intrinsics.checkNotNullParameter(str4, "voucherDescription");
        Intrinsics.checkNotNullParameter(voucherType2, "voucherType");
        DiscountType discountType3 = discountType2;
        Intrinsics.checkNotNullParameter(discountType3, "discountType");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, ObservableAttributesNames.IMAGE_URL_V2);
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "skuIds");
        return new CustomerVoucher(str, str2, str3, str4, voucherType2, discountType3, str6, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerVoucher)) {
            return false;
        }
        CustomerVoucher customerVoucher = (CustomerVoucher) obj;
        return Intrinsics.areEqual((Object) this.f59462id, (Object) customerVoucher.f59462id) && Intrinsics.areEqual((Object) this.campaignTitle, (Object) customerVoucher.campaignTitle) && Intrinsics.areEqual((Object) this.voucherTitle, (Object) customerVoucher.voucherTitle) && Intrinsics.areEqual((Object) this.voucherDescription, (Object) customerVoucher.voucherDescription) && this.voucherType == customerVoucher.voucherType && this.discountType == customerVoucher.discountType && Intrinsics.areEqual((Object) this.imageUrl, (Object) customerVoucher.imageUrl) && Intrinsics.areEqual((Object) this.skuIds, (Object) customerVoucher.skuIds);
    }

    @NotNull
    public final String getCampaignTitle() {
        return this.campaignTitle;
    }

    @NotNull
    public final DiscountType getDiscountType() {
        return this.discountType;
    }

    @NotNull
    public final String getId() {
        return this.f59462id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final List<String> getSkuIds() {
        return this.skuIds;
    }

    @NotNull
    public final String getVoucherDescription() {
        return this.voucherDescription;
    }

    @NotNull
    public final String getVoucherTitle() {
        return this.voucherTitle;
    }

    @NotNull
    public final VoucherType getVoucherType() {
        return this.voucherType;
    }

    public int hashCode() {
        return (((((((((((((this.f59462id.hashCode() * 31) + this.campaignTitle.hashCode()) * 31) + this.voucherTitle.hashCode()) * 31) + this.voucherDescription.hashCode()) * 31) + this.voucherType.hashCode()) * 31) + this.discountType.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.skuIds.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f59462id;
        String str2 = this.campaignTitle;
        String str3 = this.voucherTitle;
        String str4 = this.voucherDescription;
        VoucherType voucherType2 = this.voucherType;
        DiscountType discountType2 = this.discountType;
        String str5 = this.imageUrl;
        List<String> list = this.skuIds;
        return "CustomerVoucher(id=" + str + ", campaignTitle=" + str2 + ", voucherTitle=" + str3 + ", voucherDescription=" + str4 + ", voucherType=" + voucherType2 + ", discountType=" + discountType2 + ", imageUrl=" + str5 + ", skuIds=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerVoucher(String str, String str2, String str3, String str4, VoucherType voucherType2, DiscountType discountType2, String str5, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, voucherType2, discountType2, str5, (i11 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
