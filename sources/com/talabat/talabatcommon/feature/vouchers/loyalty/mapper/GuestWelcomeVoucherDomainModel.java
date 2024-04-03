package com.talabat.talabatcommon.feature.vouchers.loyalty.mapper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "", "title", "", "tag", "description", "validTillDays", "", "minOrderValue", "", "termsAndConditions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getMinOrderValue", "()F", "getTag", "getTermsAndConditions", "getTitle", "getValidTillDays", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestWelcomeVoucherDomainModel {
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

    public GuestWelcomeVoucherDomainModel(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "termsAndConditions");
        this.title = str;
        this.tag = str2;
        this.description = str3;
        this.validTillDays = i11;
        this.minOrderValue = f11;
        this.termsAndConditions = str4;
    }

    public static /* synthetic */ GuestWelcomeVoucherDomainModel copy$default(GuestWelcomeVoucherDomainModel guestWelcomeVoucherDomainModel, String str, String str2, String str3, int i11, float f11, String str4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = guestWelcomeVoucherDomainModel.title;
        }
        if ((i12 & 2) != 0) {
            str2 = guestWelcomeVoucherDomainModel.tag;
        }
        String str5 = str2;
        if ((i12 & 4) != 0) {
            str3 = guestWelcomeVoucherDomainModel.description;
        }
        String str6 = str3;
        if ((i12 & 8) != 0) {
            i11 = guestWelcomeVoucherDomainModel.validTillDays;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            f11 = guestWelcomeVoucherDomainModel.minOrderValue;
        }
        float f12 = f11;
        if ((i12 & 32) != 0) {
            str4 = guestWelcomeVoucherDomainModel.termsAndConditions;
        }
        return guestWelcomeVoucherDomainModel.copy(str, str5, str6, i13, f12, str4);
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

    public final int component4() {
        return this.validTillDays;
    }

    public final float component5() {
        return this.minOrderValue;
    }

    @NotNull
    public final String component6() {
        return this.termsAndConditions;
    }

    @NotNull
    public final GuestWelcomeVoucherDomainModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, float f11, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "termsAndConditions");
        return new GuestWelcomeVoucherDomainModel(str, str2, str3, i11, f11, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestWelcomeVoucherDomainModel)) {
            return false;
        }
        GuestWelcomeVoucherDomainModel guestWelcomeVoucherDomainModel = (GuestWelcomeVoucherDomainModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) guestWelcomeVoucherDomainModel.title) && Intrinsics.areEqual((Object) this.tag, (Object) guestWelcomeVoucherDomainModel.tag) && Intrinsics.areEqual((Object) this.description, (Object) guestWelcomeVoucherDomainModel.description) && this.validTillDays == guestWelcomeVoucherDomainModel.validTillDays && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(guestWelcomeVoucherDomainModel.minOrderValue)) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) guestWelcomeVoucherDomainModel.termsAndConditions);
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

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.tag.hashCode()) * 31) + this.description.hashCode()) * 31) + this.validTillDays) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.termsAndConditions.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.tag;
        String str3 = this.description;
        int i11 = this.validTillDays;
        float f11 = this.minOrderValue;
        String str4 = this.termsAndConditions;
        return "GuestWelcomeVoucherDomainModel(title=" + str + ", tag=" + str2 + ", description=" + str3 + ", validTillDays=" + i11 + ", minOrderValue=" + f11 + ", termsAndConditions=" + str4 + ")";
    }
}
