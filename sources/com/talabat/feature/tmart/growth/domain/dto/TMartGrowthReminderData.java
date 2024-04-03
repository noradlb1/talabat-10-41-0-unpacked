package com.talabat.feature.tmart.growth.domain.dto;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "", "()V", "Basic", "Plain", "Rich", "Unknown", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Basic;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Plain;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Rich;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Unknown;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TMartGrowthReminderData {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Basic;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "deeplink", "", "iconUrl", "subtitle", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getIconUrl", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Basic extends TMartGrowthReminderData {
        @NotNull
        private final String deeplink;
        @NotNull
        private final String iconUrl;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Basic(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "deeplink");
            Intrinsics.checkNotNullParameter(str2, "iconUrl");
            Intrinsics.checkNotNullParameter(str3, "subtitle");
            Intrinsics.checkNotNullParameter(str4, "title");
            this.deeplink = str;
            this.iconUrl = str2;
            this.subtitle = str3;
            this.title = str4;
        }

        public static /* synthetic */ Basic copy$default(Basic basic, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = basic.deeplink;
            }
            if ((i11 & 2) != 0) {
                str2 = basic.iconUrl;
            }
            if ((i11 & 4) != 0) {
                str3 = basic.subtitle;
            }
            if ((i11 & 8) != 0) {
                str4 = basic.title;
            }
            return basic.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.deeplink;
        }

        @NotNull
        public final String component2() {
            return this.iconUrl;
        }

        @NotNull
        public final String component3() {
            return this.subtitle;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final Basic copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "deeplink");
            Intrinsics.checkNotNullParameter(str2, "iconUrl");
            Intrinsics.checkNotNullParameter(str3, "subtitle");
            Intrinsics.checkNotNullParameter(str4, "title");
            return new Basic(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Basic)) {
                return false;
            }
            Basic basic = (Basic) obj;
            return Intrinsics.areEqual((Object) this.deeplink, (Object) basic.deeplink) && Intrinsics.areEqual((Object) this.iconUrl, (Object) basic.iconUrl) && Intrinsics.areEqual((Object) this.subtitle, (Object) basic.subtitle) && Intrinsics.areEqual((Object) this.title, (Object) basic.title);
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((this.deeplink.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.title.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.deeplink;
            String str2 = this.iconUrl;
            String str3 = this.subtitle;
            String str4 = this.title;
            return "Basic(deeplink=" + str + ", iconUrl=" + str2 + ", subtitle=" + str3 + ", title=" + str4 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Plain;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "iconUrl", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Plain extends TMartGrowthReminderData {
        @NotNull
        private final String iconUrl;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Plain(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "iconUrl");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.iconUrl = str;
            this.title = str2;
        }

        public static /* synthetic */ Plain copy$default(Plain plain, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = plain.iconUrl;
            }
            if ((i11 & 2) != 0) {
                str2 = plain.title;
            }
            return plain.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.iconUrl;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final Plain copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "iconUrl");
            Intrinsics.checkNotNullParameter(str2, "title");
            return new Plain(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Plain)) {
                return false;
            }
            Plain plain = (Plain) obj;
            return Intrinsics.areEqual((Object) this.iconUrl, (Object) plain.iconUrl) && Intrinsics.areEqual((Object) this.title, (Object) plain.title);
        }

        @NotNull
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.iconUrl.hashCode() * 31) + this.title.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.iconUrl;
            String str2 = this.title;
            return "Plain(iconUrl=" + str + ", title=" + str2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Rich;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "backgroundUrl", "", "buttonText", "deeplink", "logoUrl", "imageUrl", "subtitle", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundUrl", "()Ljava/lang/String;", "getButtonText", "getDeeplink", "getImageUrl", "getLogoUrl", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Rich extends TMartGrowthReminderData {
        @NotNull
        private final String backgroundUrl;
        @NotNull
        private final String buttonText;
        @NotNull
        private final String deeplink;
        @NotNull
        private final String imageUrl;
        @NotNull
        private final String logoUrl;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Rich(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "backgroundUrl");
            Intrinsics.checkNotNullParameter(str2, "buttonText");
            Intrinsics.checkNotNullParameter(str3, "deeplink");
            Intrinsics.checkNotNullParameter(str4, Profile.LOGO_URL);
            Intrinsics.checkNotNullParameter(str5, ObservableAttributesNames.IMAGE_URL_V2);
            Intrinsics.checkNotNullParameter(str6, "subtitle");
            Intrinsics.checkNotNullParameter(str7, "title");
            this.backgroundUrl = str;
            this.buttonText = str2;
            this.deeplink = str3;
            this.logoUrl = str4;
            this.imageUrl = str5;
            this.subtitle = str6;
            this.title = str7;
        }

        public static /* synthetic */ Rich copy$default(Rich rich, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = rich.backgroundUrl;
            }
            if ((i11 & 2) != 0) {
                str2 = rich.buttonText;
            }
            String str8 = str2;
            if ((i11 & 4) != 0) {
                str3 = rich.deeplink;
            }
            String str9 = str3;
            if ((i11 & 8) != 0) {
                str4 = rich.logoUrl;
            }
            String str10 = str4;
            if ((i11 & 16) != 0) {
                str5 = rich.imageUrl;
            }
            String str11 = str5;
            if ((i11 & 32) != 0) {
                str6 = rich.subtitle;
            }
            String str12 = str6;
            if ((i11 & 64) != 0) {
                str7 = rich.title;
            }
            return rich.copy(str, str8, str9, str10, str11, str12, str7);
        }

        @NotNull
        public final String component1() {
            return this.backgroundUrl;
        }

        @NotNull
        public final String component2() {
            return this.buttonText;
        }

        @NotNull
        public final String component3() {
            return this.deeplink;
        }

        @NotNull
        public final String component4() {
            return this.logoUrl;
        }

        @NotNull
        public final String component5() {
            return this.imageUrl;
        }

        @NotNull
        public final String component6() {
            return this.subtitle;
        }

        @NotNull
        public final String component7() {
            return this.title;
        }

        @NotNull
        public final Rich copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
            Intrinsics.checkNotNullParameter(str, "backgroundUrl");
            Intrinsics.checkNotNullParameter(str2, "buttonText");
            Intrinsics.checkNotNullParameter(str3, "deeplink");
            Intrinsics.checkNotNullParameter(str4, Profile.LOGO_URL);
            Intrinsics.checkNotNullParameter(str5, ObservableAttributesNames.IMAGE_URL_V2);
            Intrinsics.checkNotNullParameter(str6, "subtitle");
            String str8 = str7;
            Intrinsics.checkNotNullParameter(str8, "title");
            return new Rich(str, str2, str3, str4, str5, str6, str8);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rich)) {
                return false;
            }
            Rich rich = (Rich) obj;
            return Intrinsics.areEqual((Object) this.backgroundUrl, (Object) rich.backgroundUrl) && Intrinsics.areEqual((Object) this.buttonText, (Object) rich.buttonText) && Intrinsics.areEqual((Object) this.deeplink, (Object) rich.deeplink) && Intrinsics.areEqual((Object) this.logoUrl, (Object) rich.logoUrl) && Intrinsics.areEqual((Object) this.imageUrl, (Object) rich.imageUrl) && Intrinsics.areEqual((Object) this.subtitle, (Object) rich.subtitle) && Intrinsics.areEqual((Object) this.title, (Object) rich.title);
        }

        @NotNull
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @NotNull
        public final String getButtonText() {
            return this.buttonText;
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((((((this.backgroundUrl.hashCode() * 31) + this.buttonText.hashCode()) * 31) + this.deeplink.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.title.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.backgroundUrl;
            String str2 = this.buttonText;
            String str3 = this.deeplink;
            String str4 = this.logoUrl;
            String str5 = this.imageUrl;
            String str6 = this.subtitle;
            String str7 = this.title;
            return "Rich(backgroundUrl=" + str + ", buttonText=" + str2 + ", deeplink=" + str3 + ", logoUrl=" + str4 + ", imageUrl=" + str5 + ", subtitle=" + str6 + ", title=" + str7 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData$Unknown;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthReminderData;", "()V", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unknown extends TMartGrowthReminderData {
        @NotNull
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super((DefaultConstructorMarker) null);
        }
    }

    private TMartGrowthReminderData() {
    }

    public /* synthetic */ TMartGrowthReminderData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
