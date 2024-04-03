package com.talabat.growth.ui.loyalty.burn.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\t\u0010F\u001a\u00020\u0006HÖ\u0001J\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\u0019\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006R"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "Landroid/os/Parcelable;", "id", "", "title", "country", "", "thumbnailURL", "imageURL", "pointsCost", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "description", "tag", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "subscriptionRestriction", "Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;", "voucherOfferType", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;)V", "getBurnOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "setBurnOptionType", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;)V", "getCountry", "()I", "setCountry", "(I)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "setId", "getImageURL", "setImageURL", "getPointsCost", "setPointsCost", "getSubscriptionRestriction", "()Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;", "setSubscriptionRestriction", "(Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;)V", "getTag", "setTag", "getThumbnailURL", "setThumbnailURL", "getTitle", "setTitle", "getVoucherOfferType", "()Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "setVoucherOfferType", "(Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;)V", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "setVoucherOptionType", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class BurnItemDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<BurnItemDisplayModel> CREATOR = new Creator();
    @NotNull
    private LoyaltyBurnOptionType burnOptionType;
    private int country;
    @NotNull
    private String description;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f60647id;
    @NotNull
    private String imageURL;
    private int pointsCost;
    @NotNull
    private SubscriptionRestriction subscriptionRestriction;
    @NotNull
    private String tag;
    @NotNull
    private String thumbnailURL;
    @NotNull
    private String title;
    @NotNull
    private VoucherOfferType voucherOfferType;
    @NotNull
    private VoucherOptionType voucherOptionType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BurnItemDisplayModel> {
        @NotNull
        public final BurnItemDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BurnItemDisplayModel(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), LoyaltyBurnOptionType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), VoucherOptionType.valueOf(parcel.readString()), SubscriptionRestriction.valueOf(parcel.readString()), (VoucherOfferType) parcel.readParcelable(BurnItemDisplayModel.class.getClassLoader()));
        }

        @NotNull
        public final BurnItemDisplayModel[] newArray(int i11) {
            return new BurnItemDisplayModel[i11];
        }
    }

    public BurnItemDisplayModel() {
        this((String) null, (String) null, 0, (String) null, (String) null, 0, (LoyaltyBurnOptionType) null, (String) null, (String) null, (VoucherOptionType) null, (SubscriptionRestriction) null, (VoucherOfferType) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    }

    public BurnItemDisplayModel(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, int i12, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull String str5, @NotNull String str6, @NotNull VoucherOptionType voucherOptionType2, @NotNull SubscriptionRestriction subscriptionRestriction2, @NotNull VoucherOfferType voucherOfferType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "thumbnailURL");
        Intrinsics.checkNotNullParameter(str4, "imageURL");
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType, "burnOptionType");
        Intrinsics.checkNotNullParameter(str5, "description");
        Intrinsics.checkNotNullParameter(str6, "tag");
        Intrinsics.checkNotNullParameter(voucherOptionType2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        Intrinsics.checkNotNullParameter(subscriptionRestriction2, "subscriptionRestriction");
        Intrinsics.checkNotNullParameter(voucherOfferType2, "voucherOfferType");
        this.f60647id = str;
        this.title = str2;
        this.country = i11;
        this.thumbnailURL = str3;
        this.imageURL = str4;
        this.pointsCost = i12;
        this.burnOptionType = loyaltyBurnOptionType;
        this.description = str5;
        this.tag = str6;
        this.voucherOptionType = voucherOptionType2;
        this.subscriptionRestriction = subscriptionRestriction2;
        this.voucherOfferType = voucherOfferType2;
    }

    public static /* synthetic */ BurnItemDisplayModel copy$default(BurnItemDisplayModel burnItemDisplayModel, String str, String str2, int i11, String str3, String str4, int i12, LoyaltyBurnOptionType loyaltyBurnOptionType, String str5, String str6, VoucherOptionType voucherOptionType2, SubscriptionRestriction subscriptionRestriction2, VoucherOfferType voucherOfferType2, int i13, Object obj) {
        BurnItemDisplayModel burnItemDisplayModel2 = burnItemDisplayModel;
        int i14 = i13;
        return burnItemDisplayModel.copy((i14 & 1) != 0 ? burnItemDisplayModel2.f60647id : str, (i14 & 2) != 0 ? burnItemDisplayModel2.title : str2, (i14 & 4) != 0 ? burnItemDisplayModel2.country : i11, (i14 & 8) != 0 ? burnItemDisplayModel2.thumbnailURL : str3, (i14 & 16) != 0 ? burnItemDisplayModel2.imageURL : str4, (i14 & 32) != 0 ? burnItemDisplayModel2.pointsCost : i12, (i14 & 64) != 0 ? burnItemDisplayModel2.burnOptionType : loyaltyBurnOptionType, (i14 & 128) != 0 ? burnItemDisplayModel2.description : str5, (i14 & 256) != 0 ? burnItemDisplayModel2.tag : str6, (i14 & 512) != 0 ? burnItemDisplayModel2.voucherOptionType : voucherOptionType2, (i14 & 1024) != 0 ? burnItemDisplayModel2.subscriptionRestriction : subscriptionRestriction2, (i14 & 2048) != 0 ? burnItemDisplayModel2.voucherOfferType : voucherOfferType2);
    }

    @NotNull
    public final String component1() {
        return this.f60647id;
    }

    @NotNull
    public final VoucherOptionType component10() {
        return this.voucherOptionType;
    }

    @NotNull
    public final SubscriptionRestriction component11() {
        return this.subscriptionRestriction;
    }

    @NotNull
    public final VoucherOfferType component12() {
        return this.voucherOfferType;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.country;
    }

    @NotNull
    public final String component4() {
        return this.thumbnailURL;
    }

    @NotNull
    public final String component5() {
        return this.imageURL;
    }

    public final int component6() {
        return this.pointsCost;
    }

    @NotNull
    public final LoyaltyBurnOptionType component7() {
        return this.burnOptionType;
    }

    @NotNull
    public final String component8() {
        return this.description;
    }

    @NotNull
    public final String component9() {
        return this.tag;
    }

    @NotNull
    public final BurnItemDisplayModel copy(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, int i12, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull String str5, @NotNull String str6, @NotNull VoucherOptionType voucherOptionType2, @NotNull SubscriptionRestriction subscriptionRestriction2, @NotNull VoucherOfferType voucherOfferType2) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "title");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "thumbnailURL");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "imageURL");
        LoyaltyBurnOptionType loyaltyBurnOptionType2 = loyaltyBurnOptionType;
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType2, "burnOptionType");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "description");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "tag");
        VoucherOptionType voucherOptionType3 = voucherOptionType2;
        Intrinsics.checkNotNullParameter(voucherOptionType3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        SubscriptionRestriction subscriptionRestriction3 = subscriptionRestriction2;
        Intrinsics.checkNotNullParameter(subscriptionRestriction3, "subscriptionRestriction");
        VoucherOfferType voucherOfferType3 = voucherOfferType2;
        Intrinsics.checkNotNullParameter(voucherOfferType3, "voucherOfferType");
        return new BurnItemDisplayModel(str, str7, i11, str8, str9, i12, loyaltyBurnOptionType2, str10, str11, voucherOptionType3, subscriptionRestriction3, voucherOfferType3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BurnItemDisplayModel)) {
            return false;
        }
        BurnItemDisplayModel burnItemDisplayModel = (BurnItemDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.f60647id, (Object) burnItemDisplayModel.f60647id) && Intrinsics.areEqual((Object) this.title, (Object) burnItemDisplayModel.title) && this.country == burnItemDisplayModel.country && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) burnItemDisplayModel.thumbnailURL) && Intrinsics.areEqual((Object) this.imageURL, (Object) burnItemDisplayModel.imageURL) && this.pointsCost == burnItemDisplayModel.pointsCost && this.burnOptionType == burnItemDisplayModel.burnOptionType && Intrinsics.areEqual((Object) this.description, (Object) burnItemDisplayModel.description) && Intrinsics.areEqual((Object) this.tag, (Object) burnItemDisplayModel.tag) && this.voucherOptionType == burnItemDisplayModel.voucherOptionType && this.subscriptionRestriction == burnItemDisplayModel.subscriptionRestriction && Intrinsics.areEqual((Object) this.voucherOfferType, (Object) burnItemDisplayModel.voucherOfferType);
    }

    @NotNull
    public final LoyaltyBurnOptionType getBurnOptionType() {
        return this.burnOptionType;
    }

    public final int getCountry() {
        return this.country;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.f60647id;
    }

    @NotNull
    public final String getImageURL() {
        return this.imageURL;
    }

    public final int getPointsCost() {
        return this.pointsCost;
    }

    @NotNull
    public final SubscriptionRestriction getSubscriptionRestriction() {
        return this.subscriptionRestriction;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getThumbnailURL() {
        return this.thumbnailURL;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final VoucherOfferType getVoucherOfferType() {
        return this.voucherOfferType;
    }

    @NotNull
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f60647id.hashCode() * 31) + this.title.hashCode()) * 31) + this.country) * 31) + this.thumbnailURL.hashCode()) * 31) + this.imageURL.hashCode()) * 31) + this.pointsCost) * 31) + this.burnOptionType.hashCode()) * 31) + this.description.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.voucherOptionType.hashCode()) * 31) + this.subscriptionRestriction.hashCode()) * 31) + this.voucherOfferType.hashCode();
    }

    public final void setBurnOptionType(@NotNull LoyaltyBurnOptionType loyaltyBurnOptionType) {
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType, "<set-?>");
        this.burnOptionType = loyaltyBurnOptionType;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f60647id = str;
    }

    public final void setImageURL(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageURL = str;
    }

    public final void setPointsCost(int i11) {
        this.pointsCost = i11;
    }

    public final void setSubscriptionRestriction(@NotNull SubscriptionRestriction subscriptionRestriction2) {
        Intrinsics.checkNotNullParameter(subscriptionRestriction2, "<set-?>");
        this.subscriptionRestriction = subscriptionRestriction2;
    }

    public final void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    public final void setThumbnailURL(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbnailURL = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setVoucherOfferType(@NotNull VoucherOfferType voucherOfferType2) {
        Intrinsics.checkNotNullParameter(voucherOfferType2, "<set-?>");
        this.voucherOfferType = voucherOfferType2;
    }

    public final void setVoucherOptionType(@NotNull VoucherOptionType voucherOptionType2) {
        Intrinsics.checkNotNullParameter(voucherOptionType2, "<set-?>");
        this.voucherOptionType = voucherOptionType2;
    }

    @NotNull
    public String toString() {
        String str = this.f60647id;
        String str2 = this.title;
        int i11 = this.country;
        String str3 = this.thumbnailURL;
        String str4 = this.imageURL;
        int i12 = this.pointsCost;
        LoyaltyBurnOptionType loyaltyBurnOptionType = this.burnOptionType;
        String str5 = this.description;
        String str6 = this.tag;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        SubscriptionRestriction subscriptionRestriction2 = this.subscriptionRestriction;
        VoucherOfferType voucherOfferType2 = this.voucherOfferType;
        return "BurnItemDisplayModel(id=" + str + ", title=" + str2 + ", country=" + i11 + ", thumbnailURL=" + str3 + ", imageURL=" + str4 + ", pointsCost=" + i12 + ", burnOptionType=" + loyaltyBurnOptionType + ", description=" + str5 + ", tag=" + str6 + ", voucherOptionType=" + voucherOptionType2 + ", subscriptionRestriction=" + subscriptionRestriction2 + ", voucherOfferType=" + voucherOfferType2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f60647id);
        parcel.writeString(this.title);
        parcel.writeInt(this.country);
        parcel.writeString(this.thumbnailURL);
        parcel.writeString(this.imageURL);
        parcel.writeInt(this.pointsCost);
        parcel.writeString(this.burnOptionType.name());
        parcel.writeString(this.description);
        parcel.writeString(this.tag);
        parcel.writeString(this.voucherOptionType.name());
        parcel.writeString(this.subscriptionRestriction.name());
        parcel.writeParcelable(this.voucherOfferType, i11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BurnItemDisplayModel(java.lang.String r13, java.lang.String r14, int r15, java.lang.String r16, java.lang.String r17, int r18, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType r19, java.lang.String r20, java.lang.String r21, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r22, com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction r23, com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000e
        L_0x000d:
            r1 = r13
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001a
        L_0x0019:
            r2 = r14
        L_0x001a:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0021
            r3 = r4
            goto L_0x0022
        L_0x0021:
            r3 = r15
        L_0x0022:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002d
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x002f
        L_0x002d:
            r5 = r16
        L_0x002f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x003a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
            goto L_0x003c
        L_0x003a:
            r6 = r17
        L_0x003c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r4 = r18
        L_0x0043:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004a
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType r7 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType.UNDEFINED
            goto L_0x004c
        L_0x004a:
            r7 = r19
        L_0x004c:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0057
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x0059
        L_0x0057:
            r8 = r20
        L_0x0059:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0064
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x0066
        L_0x0064:
            r9 = r21
        L_0x0066:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x006d
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r10 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType.NONE
            goto L_0x006f
        L_0x006d:
            r10 = r22
        L_0x006f:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0076
            com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction r11 = com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction.UNRESTRICTED
            goto L_0x0078
        L_0x0076:
            r11 = r23
        L_0x0078:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0082
            com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType$Unknown r0 = new com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType$Unknown
            r0.<init>()
            goto L_0x0084
        L_0x0082:
            r0 = r24
        L_0x0084:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = r4
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType, java.lang.String, java.lang.String, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType, com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction, com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
