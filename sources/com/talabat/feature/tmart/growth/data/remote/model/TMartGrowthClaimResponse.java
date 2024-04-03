package com.talabat.feature.tmart.growth.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse;", "", "confirmation", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$Confirmation;", "postConfirmation", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;", "(Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$Confirmation;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;)V", "getConfirmation", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$Confirmation;", "getPostConfirmation", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Confirmation", "PostConfirmation", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimResponse {
    @NotNull
    private final Confirmation confirmation;
    @NotNull
    private final PostConfirmation postConfirmation;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$Confirmation;", "", "deeplink", "", "title", "logoUrl", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getDescription", "getLogoUrl", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Confirmation {
        @NotNull
        private final String deeplink;
        @NotNull
        private final String description;
        @NotNull
        private final String logoUrl;
        @NotNull
        private final String title;

        public Confirmation(@NotNull @Json(name = "deeplink") String str, @NotNull @Json(name = "headline") String str2, @NotNull @Json(name = "logo_url") String str3, @NotNull @Json(name = "subtext") String str4) {
            Intrinsics.checkNotNullParameter(str, "deeplink");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, Profile.LOGO_URL);
            Intrinsics.checkNotNullParameter(str4, "description");
            this.deeplink = str;
            this.title = str2;
            this.logoUrl = str3;
            this.description = str4;
        }

        public static /* synthetic */ Confirmation copy$default(Confirmation confirmation, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = confirmation.deeplink;
            }
            if ((i11 & 2) != 0) {
                str2 = confirmation.title;
            }
            if ((i11 & 4) != 0) {
                str3 = confirmation.logoUrl;
            }
            if ((i11 & 8) != 0) {
                str4 = confirmation.description;
            }
            return confirmation.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.deeplink;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.logoUrl;
        }

        @NotNull
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final Confirmation copy(@NotNull @Json(name = "deeplink") String str, @NotNull @Json(name = "headline") String str2, @NotNull @Json(name = "logo_url") String str3, @NotNull @Json(name = "subtext") String str4) {
            Intrinsics.checkNotNullParameter(str, "deeplink");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, Profile.LOGO_URL);
            Intrinsics.checkNotNullParameter(str4, "description");
            return new Confirmation(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Confirmation)) {
                return false;
            }
            Confirmation confirmation = (Confirmation) obj;
            return Intrinsics.areEqual((Object) this.deeplink, (Object) confirmation.deeplink) && Intrinsics.areEqual((Object) this.title, (Object) confirmation.title) && Intrinsics.areEqual((Object) this.logoUrl, (Object) confirmation.logoUrl) && Intrinsics.areEqual((Object) this.description, (Object) confirmation.description);
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.deeplink.hashCode() * 31) + this.title.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.description.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.deeplink;
            String str2 = this.title;
            String str3 = this.logoUrl;
            String str4 = this.description;
            return "Confirmation(deeplink=" + str + ", title=" + str2 + ", logoUrl=" + str3 + ", description=" + str4 + ")";
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse$PostConfirmation;", "", "title", "", "imageUrl", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImageUrl", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PostConfirmation {
        @NotNull
        private final String description;
        @NotNull
        private final String imageUrl;
        @NotNull
        private final String title;

        public PostConfirmation(@NotNull @Json(name = "headline") String str, @NotNull @Json(name = "image_url") String str2, @NotNull @Json(name = "tagline") String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
            Intrinsics.checkNotNullParameter(str3, "description");
            this.title = str;
            this.imageUrl = str2;
            this.description = str3;
        }

        public static /* synthetic */ PostConfirmation copy$default(PostConfirmation postConfirmation, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = postConfirmation.title;
            }
            if ((i11 & 2) != 0) {
                str2 = postConfirmation.imageUrl;
            }
            if ((i11 & 4) != 0) {
                str3 = postConfirmation.description;
            }
            return postConfirmation.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.imageUrl;
        }

        @NotNull
        public final String component3() {
            return this.description;
        }

        @NotNull
        public final PostConfirmation copy(@NotNull @Json(name = "headline") String str, @NotNull @Json(name = "image_url") String str2, @NotNull @Json(name = "tagline") String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
            Intrinsics.checkNotNullParameter(str3, "description");
            return new PostConfirmation(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PostConfirmation)) {
                return false;
            }
            PostConfirmation postConfirmation = (PostConfirmation) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) postConfirmation.title) && Intrinsics.areEqual((Object) this.imageUrl, (Object) postConfirmation.imageUrl) && Intrinsics.areEqual((Object) this.description, (Object) postConfirmation.description);
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.description.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.imageUrl;
            String str3 = this.description;
            return "PostConfirmation(title=" + str + ", imageUrl=" + str2 + ", description=" + str3 + ")";
        }
    }

    public TMartGrowthClaimResponse(@NotNull @Json(name = "confirmation") Confirmation confirmation2, @NotNull @Json(name = "post_confirmation") PostConfirmation postConfirmation2) {
        Intrinsics.checkNotNullParameter(confirmation2, "confirmation");
        Intrinsics.checkNotNullParameter(postConfirmation2, "postConfirmation");
        this.confirmation = confirmation2;
        this.postConfirmation = postConfirmation2;
    }

    public static /* synthetic */ TMartGrowthClaimResponse copy$default(TMartGrowthClaimResponse tMartGrowthClaimResponse, Confirmation confirmation2, PostConfirmation postConfirmation2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            confirmation2 = tMartGrowthClaimResponse.confirmation;
        }
        if ((i11 & 2) != 0) {
            postConfirmation2 = tMartGrowthClaimResponse.postConfirmation;
        }
        return tMartGrowthClaimResponse.copy(confirmation2, postConfirmation2);
    }

    @NotNull
    public final Confirmation component1() {
        return this.confirmation;
    }

    @NotNull
    public final PostConfirmation component2() {
        return this.postConfirmation;
    }

    @NotNull
    public final TMartGrowthClaimResponse copy(@NotNull @Json(name = "confirmation") Confirmation confirmation2, @NotNull @Json(name = "post_confirmation") PostConfirmation postConfirmation2) {
        Intrinsics.checkNotNullParameter(confirmation2, "confirmation");
        Intrinsics.checkNotNullParameter(postConfirmation2, "postConfirmation");
        return new TMartGrowthClaimResponse(confirmation2, postConfirmation2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthClaimResponse)) {
            return false;
        }
        TMartGrowthClaimResponse tMartGrowthClaimResponse = (TMartGrowthClaimResponse) obj;
        return Intrinsics.areEqual((Object) this.confirmation, (Object) tMartGrowthClaimResponse.confirmation) && Intrinsics.areEqual((Object) this.postConfirmation, (Object) tMartGrowthClaimResponse.postConfirmation);
    }

    @NotNull
    public final Confirmation getConfirmation() {
        return this.confirmation;
    }

    @NotNull
    public final PostConfirmation getPostConfirmation() {
        return this.postConfirmation;
    }

    public int hashCode() {
        return (this.confirmation.hashCode() * 31) + this.postConfirmation.hashCode();
    }

    @NotNull
    public String toString() {
        Confirmation confirmation2 = this.confirmation;
        PostConfirmation postConfirmation2 = this.postConfirmation;
        return "TMartGrowthClaimResponse(confirmation=" + confirmation2 + ", postConfirmation=" + postConfirmation2 + ")";
    }
}
