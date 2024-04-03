package com.talabat.feature.tmart.growth.domain.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "", "deeplink", "", "infoDescription", "infoLogoUrl", "infoTitle", "successDescription", "successIconUrl", "successTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getInfoDescription", "getInfoLogoUrl", "getInfoTitle", "getSuccessDescription", "getSuccessIconUrl", "getSuccessTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimConfirmation {
    @NotNull
    private final String deeplink;
    @NotNull
    private final String infoDescription;
    @NotNull
    private final String infoLogoUrl;
    @NotNull
    private final String infoTitle;
    @NotNull
    private final String successDescription;
    @NotNull
    private final String successIconUrl;
    @NotNull
    private final String successTitle;

    public TMartGrowthClaimConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(str2, "infoDescription");
        Intrinsics.checkNotNullParameter(str3, "infoLogoUrl");
        Intrinsics.checkNotNullParameter(str4, "infoTitle");
        Intrinsics.checkNotNullParameter(str5, "successDescription");
        Intrinsics.checkNotNullParameter(str6, "successIconUrl");
        Intrinsics.checkNotNullParameter(str7, "successTitle");
        this.deeplink = str;
        this.infoDescription = str2;
        this.infoLogoUrl = str3;
        this.infoTitle = str4;
        this.successDescription = str5;
        this.successIconUrl = str6;
        this.successTitle = str7;
    }

    public static /* synthetic */ TMartGrowthClaimConfirmation copy$default(TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tMartGrowthClaimConfirmation.deeplink;
        }
        if ((i11 & 2) != 0) {
            str2 = tMartGrowthClaimConfirmation.infoDescription;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = tMartGrowthClaimConfirmation.infoLogoUrl;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = tMartGrowthClaimConfirmation.infoTitle;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = tMartGrowthClaimConfirmation.successDescription;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = tMartGrowthClaimConfirmation.successIconUrl;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = tMartGrowthClaimConfirmation.successTitle;
        }
        return tMartGrowthClaimConfirmation.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.deeplink;
    }

    @NotNull
    public final String component2() {
        return this.infoDescription;
    }

    @NotNull
    public final String component3() {
        return this.infoLogoUrl;
    }

    @NotNull
    public final String component4() {
        return this.infoTitle;
    }

    @NotNull
    public final String component5() {
        return this.successDescription;
    }

    @NotNull
    public final String component6() {
        return this.successIconUrl;
    }

    @NotNull
    public final String component7() {
        return this.successTitle;
    }

    @NotNull
    public final TMartGrowthClaimConfirmation copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(str2, "infoDescription");
        Intrinsics.checkNotNullParameter(str3, "infoLogoUrl");
        Intrinsics.checkNotNullParameter(str4, "infoTitle");
        Intrinsics.checkNotNullParameter(str5, "successDescription");
        Intrinsics.checkNotNullParameter(str6, "successIconUrl");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, "successTitle");
        return new TMartGrowthClaimConfirmation(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthClaimConfirmation)) {
            return false;
        }
        TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation = (TMartGrowthClaimConfirmation) obj;
        return Intrinsics.areEqual((Object) this.deeplink, (Object) tMartGrowthClaimConfirmation.deeplink) && Intrinsics.areEqual((Object) this.infoDescription, (Object) tMartGrowthClaimConfirmation.infoDescription) && Intrinsics.areEqual((Object) this.infoLogoUrl, (Object) tMartGrowthClaimConfirmation.infoLogoUrl) && Intrinsics.areEqual((Object) this.infoTitle, (Object) tMartGrowthClaimConfirmation.infoTitle) && Intrinsics.areEqual((Object) this.successDescription, (Object) tMartGrowthClaimConfirmation.successDescription) && Intrinsics.areEqual((Object) this.successIconUrl, (Object) tMartGrowthClaimConfirmation.successIconUrl) && Intrinsics.areEqual((Object) this.successTitle, (Object) tMartGrowthClaimConfirmation.successTitle);
    }

    @NotNull
    public final String getDeeplink() {
        return this.deeplink;
    }

    @NotNull
    public final String getInfoDescription() {
        return this.infoDescription;
    }

    @NotNull
    public final String getInfoLogoUrl() {
        return this.infoLogoUrl;
    }

    @NotNull
    public final String getInfoTitle() {
        return this.infoTitle;
    }

    @NotNull
    public final String getSuccessDescription() {
        return this.successDescription;
    }

    @NotNull
    public final String getSuccessIconUrl() {
        return this.successIconUrl;
    }

    @NotNull
    public final String getSuccessTitle() {
        return this.successTitle;
    }

    public int hashCode() {
        return (((((((((((this.deeplink.hashCode() * 31) + this.infoDescription.hashCode()) * 31) + this.infoLogoUrl.hashCode()) * 31) + this.infoTitle.hashCode()) * 31) + this.successDescription.hashCode()) * 31) + this.successIconUrl.hashCode()) * 31) + this.successTitle.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.deeplink;
        String str2 = this.infoDescription;
        String str3 = this.infoLogoUrl;
        String str4 = this.infoTitle;
        String str5 = this.successDescription;
        String str6 = this.successIconUrl;
        String str7 = this.successTitle;
        return "TMartGrowthClaimConfirmation(deeplink=" + str + ", infoDescription=" + str2 + ", infoLogoUrl=" + str3 + ", infoTitle=" + str4 + ", successDescription=" + str5 + ", successIconUrl=" + str6 + ", successTitle=" + str7 + ")";
    }
}
