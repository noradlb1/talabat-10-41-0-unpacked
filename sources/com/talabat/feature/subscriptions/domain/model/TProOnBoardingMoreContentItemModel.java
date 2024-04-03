package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentItemModel;", "", "backgroundColor", "", "leadingImage", "leadingText", "leadingTextColor", "trailingText", "trailingTextColor", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getLeadingImage", "getLeadingText", "getLeadingTextColor", "getTrailingText", "getTrailingTextColor", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingMoreContentItemModel {
    @NotNull
    private final String backgroundColor;
    @NotNull
    private final String leadingImage;
    @NotNull
    private final String leadingText;
    @NotNull
    private final String leadingTextColor;
    @NotNull
    private final String trailingText;
    @NotNull
    private final String trailingTextColor;
    @NotNull
    private final String type;

    public TProOnBoardingMoreContentItemModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, "leadingImage");
        Intrinsics.checkNotNullParameter(str3, "leadingText");
        Intrinsics.checkNotNullParameter(str4, "leadingTextColor");
        Intrinsics.checkNotNullParameter(str5, "trailingText");
        Intrinsics.checkNotNullParameter(str6, "trailingTextColor");
        Intrinsics.checkNotNullParameter(str7, "type");
        this.backgroundColor = str;
        this.leadingImage = str2;
        this.leadingText = str3;
        this.leadingTextColor = str4;
        this.trailingText = str5;
        this.trailingTextColor = str6;
        this.type = str7;
    }

    public static /* synthetic */ TProOnBoardingMoreContentItemModel copy$default(TProOnBoardingMoreContentItemModel tProOnBoardingMoreContentItemModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingMoreContentItemModel.backgroundColor;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingMoreContentItemModel.leadingImage;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingMoreContentItemModel.leadingText;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingMoreContentItemModel.leadingTextColor;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingMoreContentItemModel.trailingText;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingMoreContentItemModel.trailingTextColor;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = tProOnBoardingMoreContentItemModel.type;
        }
        return tProOnBoardingMoreContentItemModel.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.backgroundColor;
    }

    @NotNull
    public final String component2() {
        return this.leadingImage;
    }

    @NotNull
    public final String component3() {
        return this.leadingText;
    }

    @NotNull
    public final String component4() {
        return this.leadingTextColor;
    }

    @NotNull
    public final String component5() {
        return this.trailingText;
    }

    @NotNull
    public final String component6() {
        return this.trailingTextColor;
    }

    @NotNull
    public final String component7() {
        return this.type;
    }

    @NotNull
    public final TProOnBoardingMoreContentItemModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, "leadingImage");
        Intrinsics.checkNotNullParameter(str3, "leadingText");
        Intrinsics.checkNotNullParameter(str4, "leadingTextColor");
        Intrinsics.checkNotNullParameter(str5, "trailingText");
        Intrinsics.checkNotNullParameter(str6, "trailingTextColor");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, "type");
        return new TProOnBoardingMoreContentItemModel(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingMoreContentItemModel)) {
            return false;
        }
        TProOnBoardingMoreContentItemModel tProOnBoardingMoreContentItemModel = (TProOnBoardingMoreContentItemModel) obj;
        return Intrinsics.areEqual((Object) this.backgroundColor, (Object) tProOnBoardingMoreContentItemModel.backgroundColor) && Intrinsics.areEqual((Object) this.leadingImage, (Object) tProOnBoardingMoreContentItemModel.leadingImage) && Intrinsics.areEqual((Object) this.leadingText, (Object) tProOnBoardingMoreContentItemModel.leadingText) && Intrinsics.areEqual((Object) this.leadingTextColor, (Object) tProOnBoardingMoreContentItemModel.leadingTextColor) && Intrinsics.areEqual((Object) this.trailingText, (Object) tProOnBoardingMoreContentItemModel.trailingText) && Intrinsics.areEqual((Object) this.trailingTextColor, (Object) tProOnBoardingMoreContentItemModel.trailingTextColor) && Intrinsics.areEqual((Object) this.type, (Object) tProOnBoardingMoreContentItemModel.type);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getLeadingImage() {
        return this.leadingImage;
    }

    @NotNull
    public final String getLeadingText() {
        return this.leadingText;
    }

    @NotNull
    public final String getLeadingTextColor() {
        return this.leadingTextColor;
    }

    @NotNull
    public final String getTrailingText() {
        return this.trailingText;
    }

    @NotNull
    public final String getTrailingTextColor() {
        return this.trailingTextColor;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.backgroundColor.hashCode() * 31) + this.leadingImage.hashCode()) * 31) + this.leadingText.hashCode()) * 31) + this.leadingTextColor.hashCode()) * 31) + this.trailingText.hashCode()) * 31) + this.trailingTextColor.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.backgroundColor;
        String str2 = this.leadingImage;
        String str3 = this.leadingText;
        String str4 = this.leadingTextColor;
        String str5 = this.trailingText;
        String str6 = this.trailingTextColor;
        String str7 = this.type;
        return "TProOnBoardingMoreContentItemModel(backgroundColor=" + str + ", leadingImage=" + str2 + ", leadingText=" + str3 + ", leadingTextColor=" + str4 + ", trailingText=" + str5 + ", trailingTextColor=" + str6 + ", type=" + str7 + ")";
    }
}
