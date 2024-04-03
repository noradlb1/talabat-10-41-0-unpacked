package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "", "()V", "Dismiss", "Loading", "OpenTMart", "ShowImage", "ShowInfo", "ShowSuccess", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$Loading;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$Dismiss;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowImage;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$OpenTMart;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowSuccess;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowInfo;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BottomSheetState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$Dismiss;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Dismiss extends BottomSheetState {
        @NotNull
        public static final Dismiss INSTANCE = new Dismiss();

        private Dismiss() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$Loading;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "()V", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends BottomSheetState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$OpenTMart;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "deeplink", "", "(Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OpenTMart extends BottomSheetState {
        @NotNull
        private final String deeplink;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenTMart(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "deeplink");
            this.deeplink = str;
        }

        public static /* synthetic */ OpenTMart copy$default(OpenTMart openTMart, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = openTMart.deeplink;
            }
            return openTMart.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.deeplink;
        }

        @NotNull
        public final OpenTMart copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "deeplink");
            return new OpenTMart(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenTMart) && Intrinsics.areEqual((Object) this.deeplink, (Object) ((OpenTMart) obj).deeplink);
        }

        @NotNull
        public final String getDeeplink() {
            return this.deeplink;
        }

        public int hashCode() {
            return this.deeplink.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.deeplink;
            return "OpenTMart(deeplink=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0006J \u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowImage;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "filePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFilePath-U-Yv4Z4", "()Ljava/lang/String;", "Ljava/lang/String;", "component1", "component1-U-Yv4Z4", "copy", "copy-yxrKQzk", "(Ljava/lang/String;)Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowImage;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowImage extends BottomSheetState {
        @NotNull
        private final String filePath;

        private ShowImage(String str) {
            super((DefaultConstructorMarker) null);
            this.filePath = str;
        }

        public /* synthetic */ ShowImage(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* renamed from: copy-yxrKQzk$default  reason: not valid java name */
        public static /* synthetic */ ShowImage m10338copyyxrKQzk$default(ShowImage showImage, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = showImage.filePath;
            }
            return showImage.m10340copyyxrKQzk(str);
        }

        @NotNull
        /* renamed from: component1-U-Yv4Z4  reason: not valid java name */
        public final String m10339component1UYv4Z4() {
            return this.filePath;
        }

        @NotNull
        /* renamed from: copy-yxrKQzk  reason: not valid java name */
        public final ShowImage m10340copyyxrKQzk(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "filePath");
            return new ShowImage(str, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowImage) && TMartGrowthFilePath.m10326equalsimpl0(this.filePath, ((ShowImage) obj).filePath);
        }

        @NotNull
        /* renamed from: getFilePath-U-Yv4Z4  reason: not valid java name */
        public final String m10341getFilePathUYv4Z4() {
            return this.filePath;
        }

        public int hashCode() {
            return TMartGrowthFilePath.m10327hashCodeimpl(this.filePath);
        }

        @NotNull
        public String toString() {
            String r02 = TMartGrowthFilePath.m10328toStringimpl(this.filePath);
            return "ShowImage(filePath=" + r02 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowInfo;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "title", "", "subtitle", "logoUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogoUrl", "()Ljava/lang/String;", "getSubtitle", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowInfo extends BottomSheetState {
        @NotNull
        private final String logoUrl;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, Profile.LOGO_URL);
            this.title = str;
            this.subtitle = str2;
            this.logoUrl = str3;
        }

        public static /* synthetic */ ShowInfo copy$default(ShowInfo showInfo, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = showInfo.title;
            }
            if ((i11 & 2) != 0) {
                str2 = showInfo.subtitle;
            }
            if ((i11 & 4) != 0) {
                str3 = showInfo.logoUrl;
            }
            return showInfo.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.subtitle;
        }

        @NotNull
        public final String component3() {
            return this.logoUrl;
        }

        @NotNull
        public final ShowInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, Profile.LOGO_URL);
            return new ShowInfo(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInfo)) {
                return false;
            }
            ShowInfo showInfo = (ShowInfo) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) showInfo.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) showInfo.subtitle) && Intrinsics.areEqual((Object) this.logoUrl, (Object) showInfo.logoUrl);
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
            return (((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.logoUrl.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.subtitle;
            String str3 = this.logoUrl;
            return "ShowInfo(title=" + str + ", subtitle=" + str2 + ", logoUrl=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$ShowSuccess;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "title", "", "subtitle", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getSubtitle", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowSuccess extends BottomSheetState {
        @NotNull
        private final String imageUrl;
        @NotNull
        private final String subtitle;
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowSuccess(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
            this.title = str;
            this.subtitle = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ ShowSuccess copy$default(ShowSuccess showSuccess, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = showSuccess.title;
            }
            if ((i11 & 2) != 0) {
                str2 = showSuccess.subtitle;
            }
            if ((i11 & 4) != 0) {
                str3 = showSuccess.imageUrl;
            }
            return showSuccess.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.subtitle;
        }

        @NotNull
        public final String component3() {
            return this.imageUrl;
        }

        @NotNull
        public final ShowSuccess copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subtitle");
            Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
            return new ShowSuccess(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowSuccess)) {
                return false;
            }
            ShowSuccess showSuccess = (ShowSuccess) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) showSuccess.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) showSuccess.subtitle) && Intrinsics.areEqual((Object) this.imageUrl, (Object) showSuccess.imageUrl);
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
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
            return (((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.imageUrl.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.subtitle;
            String str3 = this.imageUrl;
            return "ShowSuccess(title=" + str + ", subtitle=" + str2 + ", imageUrl=" + str3 + ")";
        }
    }

    private BottomSheetState() {
    }

    public /* synthetic */ BottomSheetState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
