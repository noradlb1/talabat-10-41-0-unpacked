package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardTagsModel;", "", "title", "", "titleColor", "background", "image", "imageBackgroundColor", "toolTipImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "getImage", "getImageBackgroundColor", "getTitle", "getTitleColor", "getToolTipImage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardTagsModel {
    @NotNull
    private final String background;
    @NotNull
    private final String image;
    @NotNull
    private final String imageBackgroundColor;
    @NotNull
    private final String title;
    @NotNull
    private final String titleColor;
    @NotNull
    private final String toolTipImage;

    public TProOnBoardingCardTagsModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "background");
        Intrinsics.checkNotNullParameter(str4, "image");
        Intrinsics.checkNotNullParameter(str5, "imageBackgroundColor");
        Intrinsics.checkNotNullParameter(str6, "toolTipImage");
        this.title = str;
        this.titleColor = str2;
        this.background = str3;
        this.image = str4;
        this.imageBackgroundColor = str5;
        this.toolTipImage = str6;
    }

    public static /* synthetic */ TProOnBoardingCardTagsModel copy$default(TProOnBoardingCardTagsModel tProOnBoardingCardTagsModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingCardTagsModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingCardTagsModel.titleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingCardTagsModel.background;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingCardTagsModel.image;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingCardTagsModel.imageBackgroundColor;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingCardTagsModel.toolTipImage;
        }
        return tProOnBoardingCardTagsModel.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.titleColor;
    }

    @NotNull
    public final String component3() {
        return this.background;
    }

    @NotNull
    public final String component4() {
        return this.image;
    }

    @NotNull
    public final String component5() {
        return this.imageBackgroundColor;
    }

    @NotNull
    public final String component6() {
        return this.toolTipImage;
    }

    @NotNull
    public final TProOnBoardingCardTagsModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "background");
        Intrinsics.checkNotNullParameter(str4, "image");
        Intrinsics.checkNotNullParameter(str5, "imageBackgroundColor");
        Intrinsics.checkNotNullParameter(str6, "toolTipImage");
        return new TProOnBoardingCardTagsModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingCardTagsModel)) {
            return false;
        }
        TProOnBoardingCardTagsModel tProOnBoardingCardTagsModel = (TProOnBoardingCardTagsModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingCardTagsModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingCardTagsModel.titleColor) && Intrinsics.areEqual((Object) this.background, (Object) tProOnBoardingCardTagsModel.background) && Intrinsics.areEqual((Object) this.image, (Object) tProOnBoardingCardTagsModel.image) && Intrinsics.areEqual((Object) this.imageBackgroundColor, (Object) tProOnBoardingCardTagsModel.imageBackgroundColor) && Intrinsics.areEqual((Object) this.toolTipImage, (Object) tProOnBoardingCardTagsModel.toolTipImage);
    }

    @NotNull
    public final String getBackground() {
        return this.background;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getImageBackgroundColor() {
        return this.imageBackgroundColor;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTitleColor() {
        return this.titleColor;
    }

    @NotNull
    public final String getToolTipImage() {
        return this.toolTipImage;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.titleColor.hashCode()) * 31) + this.background.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageBackgroundColor.hashCode()) * 31) + this.toolTipImage.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.titleColor;
        String str3 = this.background;
        String str4 = this.image;
        String str5 = this.imageBackgroundColor;
        String str6 = this.toolTipImage;
        return "TProOnBoardingCardTagsModel(title=" + str + ", titleColor=" + str2 + ", background=" + str3 + ", image=" + str4 + ", imageBackgroundColor=" + str5 + ", toolTipImage=" + str6 + ")";
    }
}
