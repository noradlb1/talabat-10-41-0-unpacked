package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestVoucherResult;", "", "tag", "", "title", "deeplink", "validTillDays", "", "description", "thumbnailURL", "minOrderValue", "", "termsAndConditions", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getDescription", "getMinOrderValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTag", "getTermsAndConditions", "getThumbnailURL", "getTitle", "getValidTillDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestVoucherResult;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestVoucherResult {
    @SerializedName("deeplink")
    @Nullable
    private final String deeplink;
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
    @SerializedName("thumbnailURL")
    @Nullable
    private final String thumbnailURL;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("validTillDays")
    @Nullable
    private final Integer validTillDays;

    public GuestVoucherResult(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6) {
        this.tag = str;
        this.title = str2;
        this.deeplink = str3;
        this.validTillDays = num;
        this.description = str4;
        this.thumbnailURL = str5;
        this.minOrderValue = f11;
        this.termsAndConditions = str6;
    }

    public static /* synthetic */ GuestVoucherResult copy$default(GuestVoucherResult guestVoucherResult, String str, String str2, String str3, Integer num, String str4, String str5, Float f11, String str6, int i11, Object obj) {
        GuestVoucherResult guestVoucherResult2 = guestVoucherResult;
        int i12 = i11;
        return guestVoucherResult.copy((i12 & 1) != 0 ? guestVoucherResult2.tag : str, (i12 & 2) != 0 ? guestVoucherResult2.title : str2, (i12 & 4) != 0 ? guestVoucherResult2.deeplink : str3, (i12 & 8) != 0 ? guestVoucherResult2.validTillDays : num, (i12 & 16) != 0 ? guestVoucherResult2.description : str4, (i12 & 32) != 0 ? guestVoucherResult2.thumbnailURL : str5, (i12 & 64) != 0 ? guestVoucherResult2.minOrderValue : f11, (i12 & 128) != 0 ? guestVoucherResult2.termsAndConditions : str6);
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
    public final String component3() {
        return this.deeplink;
    }

    @Nullable
    public final Integer component4() {
        return this.validTillDays;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @Nullable
    public final String component6() {
        return this.thumbnailURL;
    }

    @Nullable
    public final Float component7() {
        return this.minOrderValue;
    }

    @Nullable
    public final String component8() {
        return this.termsAndConditions;
    }

    @NotNull
    public final GuestVoucherResult copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6) {
        return new GuestVoucherResult(str, str2, str3, num, str4, str5, f11, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestVoucherResult)) {
            return false;
        }
        GuestVoucherResult guestVoucherResult = (GuestVoucherResult) obj;
        return Intrinsics.areEqual((Object) this.tag, (Object) guestVoucherResult.tag) && Intrinsics.areEqual((Object) this.title, (Object) guestVoucherResult.title) && Intrinsics.areEqual((Object) this.deeplink, (Object) guestVoucherResult.deeplink) && Intrinsics.areEqual((Object) this.validTillDays, (Object) guestVoucherResult.validTillDays) && Intrinsics.areEqual((Object) this.description, (Object) guestVoucherResult.description) && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) guestVoucherResult.thumbnailURL) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) guestVoucherResult.minOrderValue) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) guestVoucherResult.termsAndConditions);
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
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
    public final String getThumbnailURL() {
        return this.thumbnailURL;
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
        String str3 = this.deeplink;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.validTillDays;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.description;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.thumbnailURL;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f11 = this.minOrderValue;
        int hashCode7 = (hashCode6 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str6 = this.termsAndConditions;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.tag;
        String str2 = this.title;
        String str3 = this.deeplink;
        Integer num = this.validTillDays;
        String str4 = this.description;
        String str5 = this.thumbnailURL;
        Float f11 = this.minOrderValue;
        String str6 = this.termsAndConditions;
        return "GuestVoucherResult(tag=" + str + ", title=" + str2 + ", deeplink=" + str3 + ", validTillDays=" + num + ", description=" + str4 + ", thumbnailURL=" + str5 + ", minOrderValue=" + f11 + ", termsAndConditions=" + str6 + ")";
    }
}
