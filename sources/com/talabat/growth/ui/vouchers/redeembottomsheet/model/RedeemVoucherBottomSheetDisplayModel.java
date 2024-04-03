package com.talabat.growth.ui.vouchers.redeembottomsheet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;", "", "title", "", "description", "tag", "validTilDate", "validForDays", "minOrderAmount", "deepLink", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeepLink", "()Ljava/lang/String;", "getDescription", "getImage", "getMinOrderAmount", "getTag", "getTitle", "getValidForDays", "getValidTilDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getTermsAndConditions", "hashCode", "", "toString", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherBottomSheetDisplayModel {
    @NotNull
    private final String deepLink;
    @NotNull
    private final String description;
    @NotNull
    private final String image;
    @NotNull
    private final String minOrderAmount;
    @NotNull
    private final String tag;
    @NotNull
    private final String title;
    @NotNull
    private final String validForDays;
    @NotNull
    private final String validTilDate;

    public RedeemVoucherBottomSheetDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "tag");
        Intrinsics.checkNotNullParameter(str4, "validTilDate");
        Intrinsics.checkNotNullParameter(str5, "validForDays");
        Intrinsics.checkNotNullParameter(str6, "minOrderAmount");
        Intrinsics.checkNotNullParameter(str7, "deepLink");
        Intrinsics.checkNotNullParameter(str8, "image");
        this.title = str;
        this.description = str2;
        this.tag = str3;
        this.validTilDate = str4;
        this.validForDays = str5;
        this.minOrderAmount = str6;
        this.deepLink = str7;
        this.image = str8;
    }

    public static /* synthetic */ RedeemVoucherBottomSheetDisplayModel copy$default(RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel2 = redeemVoucherBottomSheetDisplayModel;
        int i12 = i11;
        return redeemVoucherBottomSheetDisplayModel.copy((i12 & 1) != 0 ? redeemVoucherBottomSheetDisplayModel2.title : str, (i12 & 2) != 0 ? redeemVoucherBottomSheetDisplayModel2.description : str2, (i12 & 4) != 0 ? redeemVoucherBottomSheetDisplayModel2.tag : str3, (i12 & 8) != 0 ? redeemVoucherBottomSheetDisplayModel2.validTilDate : str4, (i12 & 16) != 0 ? redeemVoucherBottomSheetDisplayModel2.validForDays : str5, (i12 & 32) != 0 ? redeemVoucherBottomSheetDisplayModel2.minOrderAmount : str6, (i12 & 64) != 0 ? redeemVoucherBottomSheetDisplayModel2.deepLink : str7, (i12 & 128) != 0 ? redeemVoucherBottomSheetDisplayModel2.image : str8);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final String component3() {
        return this.tag;
    }

    @NotNull
    public final String component4() {
        return this.validTilDate;
    }

    @NotNull
    public final String component5() {
        return this.validForDays;
    }

    @NotNull
    public final String component6() {
        return this.minOrderAmount;
    }

    @NotNull
    public final String component7() {
        return this.deepLink;
    }

    @NotNull
    public final String component8() {
        return this.image;
    }

    @NotNull
    public final RedeemVoucherBottomSheetDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "tag");
        Intrinsics.checkNotNullParameter(str4, "validTilDate");
        Intrinsics.checkNotNullParameter(str5, "validForDays");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "minOrderAmount");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "deepLink");
        String str11 = str8;
        Intrinsics.checkNotNullParameter(str11, "image");
        return new RedeemVoucherBottomSheetDisplayModel(str, str2, str3, str4, str5, str9, str10, str11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemVoucherBottomSheetDisplayModel)) {
            return false;
        }
        RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel = (RedeemVoucherBottomSheetDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) redeemVoucherBottomSheetDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) redeemVoucherBottomSheetDisplayModel.description) && Intrinsics.areEqual((Object) this.tag, (Object) redeemVoucherBottomSheetDisplayModel.tag) && Intrinsics.areEqual((Object) this.validTilDate, (Object) redeemVoucherBottomSheetDisplayModel.validTilDate) && Intrinsics.areEqual((Object) this.validForDays, (Object) redeemVoucherBottomSheetDisplayModel.validForDays) && Intrinsics.areEqual((Object) this.minOrderAmount, (Object) redeemVoucherBottomSheetDisplayModel.minOrderAmount) && Intrinsics.areEqual((Object) this.deepLink, (Object) redeemVoucherBottomSheetDisplayModel.deepLink) && Intrinsics.areEqual((Object) this.image, (Object) redeemVoucherBottomSheetDisplayModel.image);
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getMinOrderAmount() {
        return this.minOrderAmount;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTermsAndConditions() {
        String str;
        String str2 = this.minOrderAmount;
        if (StringsKt__StringsJVMKt.isBlank(this.validForDays)) {
            str = "";
        } else {
            str = " • " + this.validForDays;
        }
        return str2 + str;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getValidForDays() {
        return this.validForDays;
    }

    @NotNull
    public final String getValidTilDate() {
        return this.validTilDate;
    }

    public int hashCode() {
        return (((((((((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.validTilDate.hashCode()) * 31) + this.validForDays.hashCode()) * 31) + this.minOrderAmount.hashCode()) * 31) + this.deepLink.hashCode()) * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.tag;
        String str4 = this.validTilDate;
        String str5 = this.validForDays;
        String str6 = this.minOrderAmount;
        String str7 = this.deepLink;
        String str8 = this.image;
        return "RedeemVoucherBottomSheetDisplayModel(title=" + str + ", description=" + str2 + ", tag=" + str3 + ", validTilDate=" + str4 + ", validForDays=" + str5 + ", minOrderAmount=" + str6 + ", deepLink=" + str7 + ", image=" + str8 + ")";
    }
}
