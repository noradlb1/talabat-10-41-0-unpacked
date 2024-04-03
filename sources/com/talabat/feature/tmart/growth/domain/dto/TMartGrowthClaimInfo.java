package com.talabat.feature.tmart.growth.domain.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo;", "", "()V", "Refreshing", "State", "Success", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Refreshing;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TMartGrowthClaimInfo {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Refreshing;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo;", "()V", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Refreshing extends TMartGrowthClaimInfo {
        @NotNull
        public static final Refreshing INSTANCE = new Refreshing();

        private Refreshing() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$State;", "", "(Ljava/lang/String;I)V", "CLAIMED", "UNCLAIMED", "OTHER", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum State {
        CLAIMED,
        UNCLAIMED,
        OTHER
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo;", "title", "", "description", "buttonText", "basicImageUrl", "finalImageUrl", "basicLoaderUrl", "finalLoaderUrl", "state", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$State;", "deeplink", "logoUrl", "backgroundUrl", "iconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$State;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundUrl", "()Ljava/lang/String;", "getBasicImageUrl", "getBasicLoaderUrl", "getButtonText", "getDeeplink", "getDescription", "getFinalImageUrl", "getFinalLoaderUrl", "getIconUrl", "getLogoUrl", "getState", "()Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$State;", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success extends TMartGrowthClaimInfo {
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

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Success(String str, String str2, String str3, String str4, String str5, String str6, String str7, State state2, String str8, String str9, String str10, String str11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, state2, str8, str9, str10, (i11 & 2048) != 0 ? null : str11);
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, String str3, String str4, String str5, String str6, String str7, State state2, String str8, String str9, String str10, String str11, int i11, Object obj) {
            Success success2 = success;
            int i12 = i11;
            return success.copy((i12 & 1) != 0 ? success2.title : str, (i12 & 2) != 0 ? success2.description : str2, (i12 & 4) != 0 ? success2.buttonText : str3, (i12 & 8) != 0 ? success2.basicImageUrl : str4, (i12 & 16) != 0 ? success2.finalImageUrl : str5, (i12 & 32) != 0 ? success2.basicLoaderUrl : str6, (i12 & 64) != 0 ? success2.finalLoaderUrl : str7, (i12 & 128) != 0 ? success2.state : state2, (i12 & 256) != 0 ? success2.deeplink : str8, (i12 & 512) != 0 ? success2.logoUrl : str9, (i12 & 1024) != 0 ? success2.backgroundUrl : str10, (i12 & 2048) != 0 ? success2.iconUrl : str11);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final String component10() {
            return this.logoUrl;
        }

        @Nullable
        public final String component11() {
            return this.backgroundUrl;
        }

        @Nullable
        public final String component12() {
            return this.iconUrl;
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
            return this.basicImageUrl;
        }

        @Nullable
        public final String component5() {
            return this.finalImageUrl;
        }

        @Nullable
        public final String component6() {
            return this.basicLoaderUrl;
        }

        @Nullable
        public final String component7() {
            return this.finalLoaderUrl;
        }

        @NotNull
        public final State component8() {
            return this.state;
        }

        @NotNull
        public final String component9() {
            return this.deeplink;
        }

        @NotNull
        public final Success copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull State state2, @NotNull String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
            Intrinsics.checkNotNullParameter(str, "title");
            String str12 = str2;
            Intrinsics.checkNotNullParameter(str12, "description");
            State state3 = state2;
            Intrinsics.checkNotNullParameter(state3, "state");
            String str13 = str8;
            Intrinsics.checkNotNullParameter(str13, "deeplink");
            return new Success(str, str12, str3, str4, str5, str6, str7, state3, str13, str9, str10, str11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) success.title) && Intrinsics.areEqual((Object) this.description, (Object) success.description) && Intrinsics.areEqual((Object) this.buttonText, (Object) success.buttonText) && Intrinsics.areEqual((Object) this.basicImageUrl, (Object) success.basicImageUrl) && Intrinsics.areEqual((Object) this.finalImageUrl, (Object) success.finalImageUrl) && Intrinsics.areEqual((Object) this.basicLoaderUrl, (Object) success.basicLoaderUrl) && Intrinsics.areEqual((Object) this.finalLoaderUrl, (Object) success.finalLoaderUrl) && this.state == success.state && Intrinsics.areEqual((Object) this.deeplink, (Object) success.deeplink) && Intrinsics.areEqual((Object) this.logoUrl, (Object) success.logoUrl) && Intrinsics.areEqual((Object) this.backgroundUrl, (Object) success.backgroundUrl) && Intrinsics.areEqual((Object) this.iconUrl, (Object) success.iconUrl);
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
            String str2 = this.basicImageUrl;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.finalImageUrl;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.basicLoaderUrl;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.finalLoaderUrl;
            int hashCode6 = (((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.state.hashCode()) * 31) + this.deeplink.hashCode()) * 31;
            String str6 = this.logoUrl;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.backgroundUrl;
            int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.iconUrl;
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
            String str4 = this.basicImageUrl;
            String str5 = this.finalImageUrl;
            String str6 = this.basicLoaderUrl;
            String str7 = this.finalLoaderUrl;
            State state2 = this.state;
            String str8 = this.deeplink;
            String str9 = this.logoUrl;
            String str10 = this.backgroundUrl;
            String str11 = this.iconUrl;
            return "Success(title=" + str + ", description=" + str2 + ", buttonText=" + str3 + ", basicImageUrl=" + str4 + ", finalImageUrl=" + str5 + ", basicLoaderUrl=" + str6 + ", finalLoaderUrl=" + str7 + ", state=" + state2 + ", deeplink=" + str8 + ", logoUrl=" + str9 + ", backgroundUrl=" + str10 + ", iconUrl=" + str11 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull State state2, @NotNull String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(state2, "state");
            Intrinsics.checkNotNullParameter(str8, "deeplink");
            this.title = str;
            this.description = str2;
            this.buttonText = str3;
            this.basicImageUrl = str4;
            this.finalImageUrl = str5;
            this.basicLoaderUrl = str6;
            this.finalLoaderUrl = str7;
            this.state = state2;
            this.deeplink = str8;
            this.logoUrl = str9;
            this.backgroundUrl = str10;
            this.iconUrl = str11;
        }
    }

    private TMartGrowthClaimInfo() {
    }

    public /* synthetic */ TMartGrowthClaimInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
