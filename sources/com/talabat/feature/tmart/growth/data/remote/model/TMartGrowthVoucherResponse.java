package com.talabat.feature.tmart.growth.data.remote.model;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "", "claimInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo;", "trackingInfo", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "(Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;)V", "getClaimInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo;", "getTrackingInfo", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthTrackingInfoResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ClaimInfo", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthVoucherResponse {
    @NotNull
    private final ClaimInfo claimInfo;
    @NotNull
    private final TMartGrowthTrackingInfoResponse trackingInfo;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u00012B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo;", "", "title", "", "description", "buttonText", "iconUrl", "basicImageUrl", "finalImageUrl", "basicLoaderUrl", "finalLoaderUrl", "state", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo$State;", "deeplink", "logoUrl", "backgroundUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo$State;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundUrl", "()Ljava/lang/String;", "getBasicImageUrl", "getBasicLoaderUrl", "getButtonText", "getDeeplink", "getDescription", "getFinalImageUrl", "getFinalLoaderUrl", "getIconUrl", "getLogoUrl", "getState", "()Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo$State;", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "State", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ClaimInfo {
        @Nullable
        private final String backgroundUrl;
        @Nullable
        private final String basicImageUrl;
        @Nullable
        private final String basicLoaderUrl;
        @Nullable
        private final String buttonText;
        @NotNull
        private final String deeplink;
        @NotNull
        private final String description;
        @Nullable
        private final String finalImageUrl;
        @Nullable
        private final String finalLoaderUrl;
        @Nullable
        private final String iconUrl;
        @Nullable
        private final String logoUrl;
        @NotNull
        private final State state;
        @NotNull
        private final String title;

        @JsonClass(generateAdapter = false)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse$ClaimInfo$State;", "", "(Ljava/lang/String;I)V", "CLAIMED", "UNCLAIMED", "OTHER", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @FallbackEnum(name = "OTHER")
        public enum State {
            CLAIMED,
            UNCLAIMED,
            OTHER
        }

        public ClaimInfo(@NotNull @Json(name = "headline") String str, @NotNull @Json(name = "subtext") String str2, @Nullable @Json(name = "button_text") String str3, @Nullable @Json(name = "icon_url") String str4, @Nullable @Json(name = "image_basic_url") String str5, @Nullable @Json(name = "image_final_url") String str6, @Nullable @Json(name = "loader_gif_basic_url") String str7, @Nullable @Json(name = "loader_gif_final_url") String str8, @NotNull @Json(name = "state") State state2, @NotNull @Json(name = "deeplink") String str9, @Nullable @Json(name = "logo_url") String str10, @Nullable @Json(name = "background_url") String str11) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(state2, "state");
            Intrinsics.checkNotNullParameter(str9, "deeplink");
            this.title = str;
            this.description = str2;
            this.buttonText = str3;
            this.iconUrl = str4;
            this.basicImageUrl = str5;
            this.finalImageUrl = str6;
            this.basicLoaderUrl = str7;
            this.finalLoaderUrl = str8;
            this.state = state2;
            this.deeplink = str9;
            this.logoUrl = str10;
            this.backgroundUrl = str11;
        }

        public static /* synthetic */ ClaimInfo copy$default(ClaimInfo claimInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, State state2, String str9, String str10, String str11, int i11, Object obj) {
            ClaimInfo claimInfo2 = claimInfo;
            int i12 = i11;
            return claimInfo.copy((i12 & 1) != 0 ? claimInfo2.title : str, (i12 & 2) != 0 ? claimInfo2.description : str2, (i12 & 4) != 0 ? claimInfo2.buttonText : str3, (i12 & 8) != 0 ? claimInfo2.iconUrl : str4, (i12 & 16) != 0 ? claimInfo2.basicImageUrl : str5, (i12 & 32) != 0 ? claimInfo2.finalImageUrl : str6, (i12 & 64) != 0 ? claimInfo2.basicLoaderUrl : str7, (i12 & 128) != 0 ? claimInfo2.finalLoaderUrl : str8, (i12 & 256) != 0 ? claimInfo2.state : state2, (i12 & 512) != 0 ? claimInfo2.deeplink : str9, (i12 & 1024) != 0 ? claimInfo2.logoUrl : str10, (i12 & 2048) != 0 ? claimInfo2.backgroundUrl : str11);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component10() {
            return this.deeplink;
        }

        @Nullable
        public final String component11() {
            return this.logoUrl;
        }

        @Nullable
        public final String component12() {
            return this.backgroundUrl;
        }

        @NotNull
        public final String component2() {
            return this.description;
        }

        @Nullable
        public final String component3() {
            return this.buttonText;
        }

        @Nullable
        public final String component4() {
            return this.iconUrl;
        }

        @Nullable
        public final String component5() {
            return this.basicImageUrl;
        }

        @Nullable
        public final String component6() {
            return this.finalImageUrl;
        }

        @Nullable
        public final String component7() {
            return this.basicLoaderUrl;
        }

        @Nullable
        public final String component8() {
            return this.finalLoaderUrl;
        }

        @NotNull
        public final State component9() {
            return this.state;
        }

        @NotNull
        public final ClaimInfo copy(@NotNull @Json(name = "headline") String str, @NotNull @Json(name = "subtext") String str2, @Nullable @Json(name = "button_text") String str3, @Nullable @Json(name = "icon_url") String str4, @Nullable @Json(name = "image_basic_url") String str5, @Nullable @Json(name = "image_final_url") String str6, @Nullable @Json(name = "loader_gif_basic_url") String str7, @Nullable @Json(name = "loader_gif_final_url") String str8, @NotNull @Json(name = "state") State state2, @NotNull @Json(name = "deeplink") String str9, @Nullable @Json(name = "logo_url") String str10, @Nullable @Json(name = "background_url") String str11) {
            Intrinsics.checkNotNullParameter(str, "title");
            String str12 = str2;
            Intrinsics.checkNotNullParameter(str12, "description");
            State state3 = state2;
            Intrinsics.checkNotNullParameter(state3, "state");
            String str13 = str9;
            Intrinsics.checkNotNullParameter(str13, "deeplink");
            return new ClaimInfo(str, str12, str3, str4, str5, str6, str7, str8, state3, str13, str10, str11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClaimInfo)) {
                return false;
            }
            ClaimInfo claimInfo = (ClaimInfo) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) claimInfo.title) && Intrinsics.areEqual((Object) this.description, (Object) claimInfo.description) && Intrinsics.areEqual((Object) this.buttonText, (Object) claimInfo.buttonText) && Intrinsics.areEqual((Object) this.iconUrl, (Object) claimInfo.iconUrl) && Intrinsics.areEqual((Object) this.basicImageUrl, (Object) claimInfo.basicImageUrl) && Intrinsics.areEqual((Object) this.finalImageUrl, (Object) claimInfo.finalImageUrl) && Intrinsics.areEqual((Object) this.basicLoaderUrl, (Object) claimInfo.basicLoaderUrl) && Intrinsics.areEqual((Object) this.finalLoaderUrl, (Object) claimInfo.finalLoaderUrl) && this.state == claimInfo.state && Intrinsics.areEqual((Object) this.deeplink, (Object) claimInfo.deeplink) && Intrinsics.areEqual((Object) this.logoUrl, (Object) claimInfo.logoUrl) && Intrinsics.areEqual((Object) this.backgroundUrl, (Object) claimInfo.backgroundUrl);
        }

        @Nullable
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Nullable
        public final String getBasicImageUrl() {
            return this.basicImageUrl;
        }

        @Nullable
        public final String getBasicLoaderUrl() {
            return this.basicLoaderUrl;
        }

        @Nullable
        public final String getButtonText() {
            return this.buttonText;
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getFinalImageUrl() {
            return this.finalImageUrl;
        }

        @Nullable
        public final String getFinalLoaderUrl() {
            return this.finalLoaderUrl;
        }

        @Nullable
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Nullable
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @NotNull
        public final State getState() {
            return this.state;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode = ((this.title.hashCode() * 31) + this.description.hashCode()) * 31;
            String str = this.buttonText;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.iconUrl;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.basicImageUrl;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.finalImageUrl;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.basicLoaderUrl;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.finalLoaderUrl;
            int hashCode7 = (((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.state.hashCode()) * 31) + this.deeplink.hashCode()) * 31;
            String str7 = this.logoUrl;
            int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.backgroundUrl;
            if (str8 != null) {
                i11 = str8.hashCode();
            }
            return hashCode8 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.description;
            String str3 = this.buttonText;
            String str4 = this.iconUrl;
            String str5 = this.basicImageUrl;
            String str6 = this.finalImageUrl;
            String str7 = this.basicLoaderUrl;
            String str8 = this.finalLoaderUrl;
            State state2 = this.state;
            String str9 = this.deeplink;
            String str10 = this.logoUrl;
            String str11 = this.backgroundUrl;
            return "ClaimInfo(title=" + str + ", description=" + str2 + ", buttonText=" + str3 + ", iconUrl=" + str4 + ", basicImageUrl=" + str5 + ", finalImageUrl=" + str6 + ", basicLoaderUrl=" + str7 + ", finalLoaderUrl=" + str8 + ", state=" + state2 + ", deeplink=" + str9 + ", logoUrl=" + str10 + ", backgroundUrl=" + str11 + ")";
        }
    }

    public TMartGrowthVoucherResponse(@NotNull @Json(name = "claim_info") ClaimInfo claimInfo2, @NotNull @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
        Intrinsics.checkNotNullParameter(claimInfo2, "claimInfo");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfoResponse, NavigationMethodChannel.SEARCH_TRACKING);
        this.claimInfo = claimInfo2;
        this.trackingInfo = tMartGrowthTrackingInfoResponse;
    }

    public static /* synthetic */ TMartGrowthVoucherResponse copy$default(TMartGrowthVoucherResponse tMartGrowthVoucherResponse, ClaimInfo claimInfo2, TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            claimInfo2 = tMartGrowthVoucherResponse.claimInfo;
        }
        if ((i11 & 2) != 0) {
            tMartGrowthTrackingInfoResponse = tMartGrowthVoucherResponse.trackingInfo;
        }
        return tMartGrowthVoucherResponse.copy(claimInfo2, tMartGrowthTrackingInfoResponse);
    }

    @NotNull
    public final ClaimInfo component1() {
        return this.claimInfo;
    }

    @NotNull
    public final TMartGrowthTrackingInfoResponse component2() {
        return this.trackingInfo;
    }

    @NotNull
    public final TMartGrowthVoucherResponse copy(@NotNull @Json(name = "claim_info") ClaimInfo claimInfo2, @NotNull @Json(name = "tracking_info") TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse) {
        Intrinsics.checkNotNullParameter(claimInfo2, "claimInfo");
        Intrinsics.checkNotNullParameter(tMartGrowthTrackingInfoResponse, NavigationMethodChannel.SEARCH_TRACKING);
        return new TMartGrowthVoucherResponse(claimInfo2, tMartGrowthTrackingInfoResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthVoucherResponse)) {
            return false;
        }
        TMartGrowthVoucherResponse tMartGrowthVoucherResponse = (TMartGrowthVoucherResponse) obj;
        return Intrinsics.areEqual((Object) this.claimInfo, (Object) tMartGrowthVoucherResponse.claimInfo) && Intrinsics.areEqual((Object) this.trackingInfo, (Object) tMartGrowthVoucherResponse.trackingInfo);
    }

    @NotNull
    public final ClaimInfo getClaimInfo() {
        return this.claimInfo;
    }

    @NotNull
    public final TMartGrowthTrackingInfoResponse getTrackingInfo() {
        return this.trackingInfo;
    }

    public int hashCode() {
        return (this.claimInfo.hashCode() * 31) + this.trackingInfo.hashCode();
    }

    @NotNull
    public String toString() {
        ClaimInfo claimInfo2 = this.claimInfo;
        TMartGrowthTrackingInfoResponse tMartGrowthTrackingInfoResponse = this.trackingInfo;
        return "TMartGrowthVoucherResponse(claimInfo=" + claimInfo2 + ", trackingInfo=" + tMartGrowthTrackingInfoResponse + ")";
    }
}
