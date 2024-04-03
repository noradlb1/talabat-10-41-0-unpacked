package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "", "title", "", "tag", "description", "deepLink", "validTillDays", "", "minOrderValue", "", "termsAndConditions", "voucherImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Ljava/lang/String;)V", "getDeepLink", "()Ljava/lang/String;", "getDescription", "getMinOrderValue", "()F", "getTag", "getTermsAndConditions", "getTitle", "getValidTillDays", "()I", "getVoucherImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestVoucherDomainModel {
    @NotNull
    private final String deepLink;
    @NotNull
    private final String description;
    private final float minOrderValue;
    @NotNull
    private final String tag;
    @NotNull
    private final String termsAndConditions;
    @NotNull
    private final String title;
    private final int validTillDays;
    @NotNull
    private final String voucherImage;

    public GuestVoucherDomainModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, float f11, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "deepLink");
        Intrinsics.checkNotNullParameter(str5, "termsAndConditions");
        Intrinsics.checkNotNullParameter(str6, "voucherImage");
        this.title = str;
        this.tag = str2;
        this.description = str3;
        this.deepLink = str4;
        this.validTillDays = i11;
        this.minOrderValue = f11;
        this.termsAndConditions = str5;
        this.voucherImage = str6;
    }

    public static /* synthetic */ GuestVoucherDomainModel copy$default(GuestVoucherDomainModel guestVoucherDomainModel, String str, String str2, String str3, String str4, int i11, float f11, String str5, String str6, int i12, Object obj) {
        GuestVoucherDomainModel guestVoucherDomainModel2 = guestVoucherDomainModel;
        int i13 = i12;
        return guestVoucherDomainModel.copy((i13 & 1) != 0 ? guestVoucherDomainModel2.title : str, (i13 & 2) != 0 ? guestVoucherDomainModel2.tag : str2, (i13 & 4) != 0 ? guestVoucherDomainModel2.description : str3, (i13 & 8) != 0 ? guestVoucherDomainModel2.deepLink : str4, (i13 & 16) != 0 ? guestVoucherDomainModel2.validTillDays : i11, (i13 & 32) != 0 ? guestVoucherDomainModel2.minOrderValue : f11, (i13 & 64) != 0 ? guestVoucherDomainModel2.termsAndConditions : str5, (i13 & 128) != 0 ? guestVoucherDomainModel2.voucherImage : str6);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.tag;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.deepLink;
    }

    public final int component5() {
        return this.validTillDays;
    }

    public final float component6() {
        return this.minOrderValue;
    }

    @NotNull
    public final String component7() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String component8() {
        return this.voucherImage;
    }

    @NotNull
    public final GuestVoucherDomainModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, float f11, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "deepLink");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "termsAndConditions");
        String str8 = str6;
        Intrinsics.checkNotNullParameter(str8, "voucherImage");
        return new GuestVoucherDomainModel(str, str2, str3, str4, i11, f11, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestVoucherDomainModel)) {
            return false;
        }
        GuestVoucherDomainModel guestVoucherDomainModel = (GuestVoucherDomainModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) guestVoucherDomainModel.title) && Intrinsics.areEqual((Object) this.tag, (Object) guestVoucherDomainModel.tag) && Intrinsics.areEqual((Object) this.description, (Object) guestVoucherDomainModel.description) && Intrinsics.areEqual((Object) this.deepLink, (Object) guestVoucherDomainModel.deepLink) && this.validTillDays == guestVoucherDomainModel.validTillDays && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(guestVoucherDomainModel.minOrderValue)) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) guestVoucherDomainModel.termsAndConditions) && Intrinsics.areEqual((Object) this.voucherImage, (Object) guestVoucherDomainModel.voucherImage);
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getValidTillDays() {
        return this.validTillDays;
    }

    @NotNull
    public final String getVoucherImage() {
        return this.voucherImage;
    }

    public int hashCode() {
        return (((((((((((((this.title.hashCode() * 31) + this.tag.hashCode()) * 31) + this.description.hashCode()) * 31) + this.deepLink.hashCode()) * 31) + this.validTillDays) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.termsAndConditions.hashCode()) * 31) + this.voucherImage.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.tag;
        String str3 = this.description;
        String str4 = this.deepLink;
        int i11 = this.validTillDays;
        float f11 = this.minOrderValue;
        String str5 = this.termsAndConditions;
        String str6 = this.voucherImage;
        return "GuestVoucherDomainModel(title=" + str + ", tag=" + str2 + ", description=" + str3 + ", deepLink=" + str4 + ", validTillDays=" + i11 + ", minOrderValue=" + f11 + ", termsAndConditions=" + str5 + ", voucherImage=" + str6 + ")";
    }
}
