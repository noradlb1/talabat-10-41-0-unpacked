package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestWelcomeVoucherResult;", "", "tag", "", "title", "validTillDays", "", "description", "minOrderValue", "", "termsAndConditions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getMinOrderValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTag", "getTermsAndConditions", "getTitle", "getValidTillDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestWelcomeVoucherResult;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestWelcomeVoucherResult {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("minOrderValue")
    @Nullable
    private final Float minOrderValue;
    @SerializedName("tag")
    @Nullable
    private final String tag;
    @SerializedName("termsAndConditions")
    @Nullable
    private final String termsAndConditions;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("validTillDays")
    @Nullable
    private final Integer validTillDays;

    public GuestWelcomeVoucherResult(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Float f11, @Nullable String str4) {
        this.tag = str;
        this.title = str2;
        this.validTillDays = num;
        this.description = str3;
        this.minOrderValue = f11;
        this.termsAndConditions = str4;
    }

    public static /* synthetic */ GuestWelcomeVoucherResult copy$default(GuestWelcomeVoucherResult guestWelcomeVoucherResult, String str, String str2, Integer num, String str3, Float f11, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = guestWelcomeVoucherResult.tag;
        }
        if ((i11 & 2) != 0) {
            str2 = guestWelcomeVoucherResult.title;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            num = guestWelcomeVoucherResult.validTillDays;
        }
        Integer num2 = num;
        if ((i11 & 8) != 0) {
            str3 = guestWelcomeVoucherResult.description;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            f11 = guestWelcomeVoucherResult.minOrderValue;
        }
        Float f12 = f11;
        if ((i11 & 32) != 0) {
            str4 = guestWelcomeVoucherResult.termsAndConditions;
        }
        return guestWelcomeVoucherResult.copy(str, str5, num2, str6, f12, str4);
    }

    @Nullable
    public final String component1() {
        return this.tag;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.validTillDays;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final Float component5() {
        return this.minOrderValue;
    }

    @Nullable
    public final String component6() {
        return this.termsAndConditions;
    }

    @NotNull
    public final GuestWelcomeVoucherResult copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Float f11, @Nullable String str4) {
        return new GuestWelcomeVoucherResult(str, str2, num, str3, f11, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestWelcomeVoucherResult)) {
            return false;
        }
        GuestWelcomeVoucherResult guestWelcomeVoucherResult = (GuestWelcomeVoucherResult) obj;
        return Intrinsics.areEqual((Object) this.tag, (Object) guestWelcomeVoucherResult.tag) && Intrinsics.areEqual((Object) this.title, (Object) guestWelcomeVoucherResult.title) && Intrinsics.areEqual((Object) this.validTillDays, (Object) guestWelcomeVoucherResult.validTillDays) && Intrinsics.areEqual((Object) this.description, (Object) guestWelcomeVoucherResult.description) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) guestWelcomeVoucherResult.minOrderValue) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) guestWelcomeVoucherResult.termsAndConditions);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Float getMinOrderValue() {
        return this.minOrderValue;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getValidTillDays() {
        return this.validTillDays;
    }

    public int hashCode() {
        String str = this.tag;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.validTillDays;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f11 = this.minOrderValue;
        int hashCode5 = (hashCode4 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str4 = this.termsAndConditions;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.tag;
        String str2 = this.title;
        Integer num = this.validTillDays;
        String str3 = this.description;
        Float f11 = this.minOrderValue;
        String str4 = this.termsAndConditions;
        return "GuestWelcomeVoucherResult(tag=" + str + ", title=" + str2 + ", validTillDays=" + num + ", description=" + str3 + ", minOrderValue=" + f11 + ", termsAndConditions=" + str4 + ")";
    }
}
