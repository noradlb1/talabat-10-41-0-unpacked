package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u0004X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0012\u0010\n\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006\u0001\u0005\u0011\u0012\u0013\u0014\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "", "()V", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "getImageFilePath-U-Yv4Z4", "()Ljava/lang/String;", "subtitle", "", "getSubtitle", "title", "getTitle", "Claimed", "Loading", "None", "Reminder", "Unclaimed", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Unclaimed;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Claimed;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Reminder;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Loading;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$None;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TMartGrowthClaimDisplayModel {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Claimed;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "title", "", "subtitle", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "deeplink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDeeplink", "()Ljava/lang/String;", "getImageFilePath-U-Yv4Z4", "Ljava/lang/String;", "getSubtitle", "getTitle", "component1", "component2", "component3", "component3-U-Yv4Z4", "component4", "copy", "copy-aU7rEVs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Claimed;", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Claimed extends TMartGrowthClaimDisplayModel {
        @NotNull
        private final String deeplink;
        @NotNull
        private final String imageFilePath;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        private Claimed(String str, String str2, String str3, String str4) {
            super((DefaultConstructorMarker) null);
            this.title = str;
            this.subtitle = str2;
            this.imageFilePath = str3;
            this.deeplink = str4;
        }

        public /* synthetic */ Claimed(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4);
        }

        /* renamed from: copy-aU7rEVs$default  reason: not valid java name */
        public static /* synthetic */ Claimed m10301copyaU7rEVs$default(Claimed claimed, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = claimed.getTitle();
            }
            if ((i11 & 2) != 0) {
                str2 = claimed.getSubtitle();
            }
            if ((i11 & 4) != 0) {
                str3 = claimed.m10304getImageFilePathUYv4Z4();
            }
            if ((i11 & 8) != 0) {
                str4 = claimed.deeplink;
            }
            return claimed.m10303copyaU7rEVs(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final String component2() {
            return getSubtitle();
        }

        @NotNull
        /* renamed from: component3-U-Yv4Z4  reason: not valid java name */
        public final String m10302component3UYv4Z4() {
            return m10304getImageFilePathUYv4Z4();
        }

        @NotNull
        public final String component4() {
            return this.deeplink;
        }

        @NotNull
        /* renamed from: copy-aU7rEVs  reason: not valid java name */
        public final Claimed m10303copyaU7rEVs(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, "imageFilePath");
            Intrinsics.checkNotNullParameter(str4, "deeplink");
            return new Claimed(str, str2, str3, str4, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Claimed)) {
                return false;
            }
            Claimed claimed = (Claimed) obj;
            return Intrinsics.areEqual((Object) getTitle(), (Object) claimed.getTitle()) && Intrinsics.areEqual((Object) getSubtitle(), (Object) claimed.getSubtitle()) && TMartGrowthFilePath.m10326equalsimpl0(m10304getImageFilePathUYv4Z4(), claimed.m10304getImageFilePathUYv4Z4()) && Intrinsics.areEqual((Object) this.deeplink, (Object) claimed.deeplink);
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        @NotNull
        /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
        public String m10304getImageFilePathUYv4Z4() {
            return this.imageFilePath;
        }

        @NotNull
        public String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((getTitle().hashCode() * 31) + getSubtitle().hashCode()) * 31) + TMartGrowthFilePath.m10327hashCodeimpl(m10304getImageFilePathUYv4Z4())) * 31) + this.deeplink.hashCode();
        }

        @NotNull
        public String toString() {
            String title2 = getTitle();
            String subtitle2 = getSubtitle();
            String r22 = TMartGrowthFilePath.m10328toStringimpl(m10304getImageFilePathUYv4Z4());
            String str = this.deeplink;
            return "Claimed(title=" + title2 + ", subtitle=" + subtitle2 + ", imageFilePath=" + r22 + ", deeplink=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Loading;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "()V", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "getImageFilePath-U-Yv4Z4", "()Ljava/lang/String;", "Ljava/lang/String;", "subtitle", "", "getSubtitle", "title", "getTitle", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends TMartGrowthClaimDisplayModel {
        @NotNull
        public static final Loading INSTANCE = new Loading();
        @NotNull
        private static final String imageFilePath = TMartGrowthFilePath.m10324constructorimpl("");
        @NotNull
        private static final String subtitle = "";
        @NotNull
        private static final String title = "";

        private Loading() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
        public String m10305getImageFilePathUYv4Z4() {
            return imageFilePath;
        }

        @NotNull
        public String getSubtitle() {
            return subtitle;
        }

        @NotNull
        public String getTitle() {
            return title;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$None;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "()V", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "getImageFilePath-U-Yv4Z4", "()Ljava/lang/String;", "Ljava/lang/String;", "subtitle", "", "getSubtitle", "title", "getTitle", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends TMartGrowthClaimDisplayModel {
        @NotNull
        public static final None INSTANCE = new None();
        @NotNull
        private static final String imageFilePath = TMartGrowthFilePath.m10324constructorimpl("");
        @NotNull
        private static final String subtitle = "";
        @NotNull
        private static final String title = "";

        private None() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
        public String m10306getImageFilePathUYv4Z4() {
            return imageFilePath;
        }

        @NotNull
        public String getSubtitle() {
            return subtitle;
        }

        @NotNull
        public String getTitle() {
            return title;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\rJ^\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001f\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Reminder;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "title", "", "subtitle", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "buttonText", "deeplink", "logoUrl", "backgroundImagePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundImagePath-U-Yv4Z4", "()Ljava/lang/String;", "Ljava/lang/String;", "getButtonText", "getDeeplink", "getImageFilePath-U-Yv4Z4", "getLogoUrl", "getSubtitle", "getTitle", "component1", "component2", "component3", "component3-U-Yv4Z4", "component4", "component5", "component6", "component7", "component7-U-Yv4Z4", "copy", "copy-65U1SDg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Reminder;", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Reminder extends TMartGrowthClaimDisplayModel {
        @NotNull
        private final String backgroundImagePath;
        @NotNull
        private final String buttonText;
        @NotNull
        private final String deeplink;
        @NotNull
        private final String imageFilePath;
        @Nullable
        private final String logoUrl;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        private Reminder(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            super((DefaultConstructorMarker) null);
            this.title = str;
            this.subtitle = str2;
            this.imageFilePath = str3;
            this.buttonText = str4;
            this.deeplink = str5;
            this.logoUrl = str6;
            this.backgroundImagePath = str7;
        }

        public /* synthetic */ Reminder(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7);
        }

        /* renamed from: copy-65U1SDg$default  reason: not valid java name */
        public static /* synthetic */ Reminder m10307copy65U1SDg$default(Reminder reminder, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = reminder.getTitle();
            }
            if ((i11 & 2) != 0) {
                str2 = reminder.getSubtitle();
            }
            String str8 = str2;
            if ((i11 & 4) != 0) {
                str3 = reminder.m10312getImageFilePathUYv4Z4();
            }
            String str9 = str3;
            if ((i11 & 8) != 0) {
                str4 = reminder.buttonText;
            }
            String str10 = str4;
            if ((i11 & 16) != 0) {
                str5 = reminder.deeplink;
            }
            String str11 = str5;
            if ((i11 & 32) != 0) {
                str6 = reminder.logoUrl;
            }
            String str12 = str6;
            if ((i11 & 64) != 0) {
                str7 = reminder.backgroundImagePath;
            }
            return reminder.m10310copy65U1SDg(str, str8, str9, str10, str11, str12, str7);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final String component2() {
            return getSubtitle();
        }

        @NotNull
        /* renamed from: component3-U-Yv4Z4  reason: not valid java name */
        public final String m10308component3UYv4Z4() {
            return m10312getImageFilePathUYv4Z4();
        }

        @NotNull
        public final String component4() {
            return this.buttonText;
        }

        @NotNull
        public final String component5() {
            return this.deeplink;
        }

        @Nullable
        public final String component6() {
            return this.logoUrl;
        }

        @NotNull
        /* renamed from: component7-U-Yv4Z4  reason: not valid java name */
        public final String m10309component7UYv4Z4() {
            return this.backgroundImagePath;
        }

        @NotNull
        /* renamed from: copy-65U1SDg  reason: not valid java name */
        public final Reminder m10310copy65U1SDg(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, "imageFilePath");
            Intrinsics.checkNotNullParameter(str4, "buttonText");
            Intrinsics.checkNotNullParameter(str5, "deeplink");
            String str8 = str7;
            Intrinsics.checkNotNullParameter(str8, "backgroundImagePath");
            return new Reminder(str, str2, str3, str4, str5, str6, str8, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reminder)) {
                return false;
            }
            Reminder reminder = (Reminder) obj;
            return Intrinsics.areEqual((Object) getTitle(), (Object) reminder.getTitle()) && Intrinsics.areEqual((Object) getSubtitle(), (Object) reminder.getSubtitle()) && TMartGrowthFilePath.m10326equalsimpl0(m10312getImageFilePathUYv4Z4(), reminder.m10312getImageFilePathUYv4Z4()) && Intrinsics.areEqual((Object) this.buttonText, (Object) reminder.buttonText) && Intrinsics.areEqual((Object) this.deeplink, (Object) reminder.deeplink) && Intrinsics.areEqual((Object) this.logoUrl, (Object) reminder.logoUrl) && TMartGrowthFilePath.m10326equalsimpl0(this.backgroundImagePath, reminder.backgroundImagePath);
        }

        @NotNull
        /* renamed from: getBackgroundImagePath-U-Yv4Z4  reason: not valid java name */
        public final String m10311getBackgroundImagePathUYv4Z4() {
            return this.backgroundImagePath;
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
        /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
        public String m10312getImageFilePathUYv4Z4() {
            return this.imageFilePath;
        }

        @Nullable
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @NotNull
        public String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode = ((((((((getTitle().hashCode() * 31) + getSubtitle().hashCode()) * 31) + TMartGrowthFilePath.m10327hashCodeimpl(m10312getImageFilePathUYv4Z4())) * 31) + this.buttonText.hashCode()) * 31) + this.deeplink.hashCode()) * 31;
            String str = this.logoUrl;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + TMartGrowthFilePath.m10327hashCodeimpl(this.backgroundImagePath);
        }

        @NotNull
        public String toString() {
            String title2 = getTitle();
            String subtitle2 = getSubtitle();
            String r22 = TMartGrowthFilePath.m10328toStringimpl(m10312getImageFilePathUYv4Z4());
            String str = this.buttonText;
            String str2 = this.deeplink;
            String str3 = this.logoUrl;
            String r62 = TMartGrowthFilePath.m10328toStringimpl(this.backgroundImagePath);
            return "Reminder(title=" + title2 + ", subtitle=" + subtitle2 + ", imageFilePath=" + r22 + ", buttonText=" + str + ", deeplink=" + str2 + ", logoUrl=" + str3 + ", backgroundImagePath=" + r62 + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u000bJH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001f\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Unclaimed;", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "title", "", "subtitle", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "buttonText", "backgroundImagePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundImagePath-U-Yv4Z4", "()Ljava/lang/String;", "Ljava/lang/String;", "getButtonText", "getImageFilePath-U-Yv4Z4", "getSubtitle", "getTitle", "component1", "component2", "component3", "component3-U-Yv4Z4", "component4", "component5", "component5-U-Yv4Z4", "copy", "copy-ZhJnhwo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Unclaimed;", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unclaimed extends TMartGrowthClaimDisplayModel {
        @NotNull
        private final String backgroundImagePath;
        @NotNull
        private final String buttonText;
        @NotNull
        private final String imageFilePath;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        private Unclaimed(String str, String str2, String str3, String str4, String str5) {
            super((DefaultConstructorMarker) null);
            this.title = str;
            this.subtitle = str2;
            this.imageFilePath = str3;
            this.buttonText = str4;
            this.backgroundImagePath = str5;
        }

        public /* synthetic */ Unclaimed(String str, String str2, String str3, String str4, String str5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5);
        }

        /* renamed from: copy-ZhJnhwo$default  reason: not valid java name */
        public static /* synthetic */ Unclaimed m10313copyZhJnhwo$default(Unclaimed unclaimed, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = unclaimed.getTitle();
            }
            if ((i11 & 2) != 0) {
                str2 = unclaimed.getSubtitle();
            }
            String str6 = str2;
            if ((i11 & 4) != 0) {
                str3 = unclaimed.m10318getImageFilePathUYv4Z4();
            }
            String str7 = str3;
            if ((i11 & 8) != 0) {
                str4 = unclaimed.buttonText;
            }
            String str8 = str4;
            if ((i11 & 16) != 0) {
                str5 = unclaimed.backgroundImagePath;
            }
            return unclaimed.m10316copyZhJnhwo(str, str6, str7, str8, str5);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final String component2() {
            return getSubtitle();
        }

        @NotNull
        /* renamed from: component3-U-Yv4Z4  reason: not valid java name */
        public final String m10314component3UYv4Z4() {
            return m10318getImageFilePathUYv4Z4();
        }

        @NotNull
        public final String component4() {
            return this.buttonText;
        }

        @NotNull
        /* renamed from: component5-U-Yv4Z4  reason: not valid java name */
        public final String m10315component5UYv4Z4() {
            return this.backgroundImagePath;
        }

        @NotNull
        /* renamed from: copy-ZhJnhwo  reason: not valid java name */
        public final Unclaimed m10316copyZhJnhwo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, "imageFilePath");
            Intrinsics.checkNotNullParameter(str4, "buttonText");
            Intrinsics.checkNotNullParameter(str5, "backgroundImagePath");
            return new Unclaimed(str, str2, str3, str4, str5, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unclaimed)) {
                return false;
            }
            Unclaimed unclaimed = (Unclaimed) obj;
            return Intrinsics.areEqual((Object) getTitle(), (Object) unclaimed.getTitle()) && Intrinsics.areEqual((Object) getSubtitle(), (Object) unclaimed.getSubtitle()) && TMartGrowthFilePath.m10326equalsimpl0(m10318getImageFilePathUYv4Z4(), unclaimed.m10318getImageFilePathUYv4Z4()) && Intrinsics.areEqual((Object) this.buttonText, (Object) unclaimed.buttonText) && TMartGrowthFilePath.m10326equalsimpl0(this.backgroundImagePath, unclaimed.backgroundImagePath);
        }

        @NotNull
        /* renamed from: getBackgroundImagePath-U-Yv4Z4  reason: not valid java name */
        public final String m10317getBackgroundImagePathUYv4Z4() {
            return this.backgroundImagePath;
        }

        @NotNull
        public final String getButtonText() {
            return this.buttonText;
        }

        @NotNull
        /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
        public String m10318getImageFilePathUYv4Z4() {
            return this.imageFilePath;
        }

        @NotNull
        public String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((getTitle().hashCode() * 31) + getSubtitle().hashCode()) * 31) + TMartGrowthFilePath.m10327hashCodeimpl(m10318getImageFilePathUYv4Z4())) * 31) + this.buttonText.hashCode()) * 31) + TMartGrowthFilePath.m10327hashCodeimpl(this.backgroundImagePath);
        }

        @NotNull
        public String toString() {
            String title2 = getTitle();
            String subtitle2 = getSubtitle();
            String r22 = TMartGrowthFilePath.m10328toStringimpl(m10318getImageFilePathUYv4Z4());
            String str = this.buttonText;
            String r42 = TMartGrowthFilePath.m10328toStringimpl(this.backgroundImagePath);
            return "Unclaimed(title=" + title2 + ", subtitle=" + subtitle2 + ", imageFilePath=" + r22 + ", buttonText=" + str + ", backgroundImagePath=" + r42 + ")";
        }
    }

    private TMartGrowthClaimDisplayModel() {
    }

    public /* synthetic */ TMartGrowthClaimDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    /* renamed from: getImageFilePath-U-Yv4Z4  reason: not valid java name */
    public abstract String m10300getImageFilePathUYv4Z4();

    @NotNull
    public abstract String getSubtitle();

    @NotNull
    public abstract String getTitle();
}
