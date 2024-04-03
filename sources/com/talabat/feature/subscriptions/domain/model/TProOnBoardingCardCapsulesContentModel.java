package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardCapsulesContentModel;", "", "title", "", "titleColor", "background", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "getImage", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardCapsulesContentModel {
    @NotNull
    private final String background;
    @NotNull
    private final String image;
    @NotNull
    private final String title;
    @NotNull
    private final String titleColor;

    public TProOnBoardingCardCapsulesContentModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "background");
        Intrinsics.checkNotNullParameter(str4, "image");
        this.title = str;
        this.titleColor = str2;
        this.background = str3;
        this.image = str4;
    }

    public static /* synthetic */ TProOnBoardingCardCapsulesContentModel copy$default(TProOnBoardingCardCapsulesContentModel tProOnBoardingCardCapsulesContentModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingCardCapsulesContentModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingCardCapsulesContentModel.titleColor;
        }
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingCardCapsulesContentModel.background;
        }
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingCardCapsulesContentModel.image;
        }
        return tProOnBoardingCardCapsulesContentModel.copy(str, str2, str3, str4);
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
    public final TProOnBoardingCardCapsulesContentModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "background");
        Intrinsics.checkNotNullParameter(str4, "image");
        return new TProOnBoardingCardCapsulesContentModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingCardCapsulesContentModel)) {
            return false;
        }
        TProOnBoardingCardCapsulesContentModel tProOnBoardingCardCapsulesContentModel = (TProOnBoardingCardCapsulesContentModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingCardCapsulesContentModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingCardCapsulesContentModel.titleColor) && Intrinsics.areEqual((Object) this.background, (Object) tProOnBoardingCardCapsulesContentModel.background) && Intrinsics.areEqual((Object) this.image, (Object) tProOnBoardingCardCapsulesContentModel.image);
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
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTitleColor() {
        return this.titleColor;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.titleColor.hashCode()) * 31) + this.background.hashCode()) * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.titleColor;
        String str3 = this.background;
        String str4 = this.image;
        return "TProOnBoardingCardCapsulesContentModel(title=" + str + ", titleColor=" + str2 + ", background=" + str3 + ", image=" + str4 + ")";
    }
}
