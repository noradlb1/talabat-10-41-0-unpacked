package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003Jk\u0010'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006."}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingDefaultCardModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "content", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardTagsModel;", "topImage", "", "cardBackgroundColor", "cardBackgroundImage", "titleSpanning", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTitleSpanningModel;", "haveMore", "", "moreContent", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "trackingId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;Ljava/lang/String;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getCardBackgroundImage", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "getHaveMore", "()Z", "getMoreContent", "()Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "getTitleSpanning", "getTopImage", "getTrackingId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingDefaultCardModel extends TProOnBoardingCardModel {
    @NotNull
    private final String cardBackgroundColor;
    @Nullable
    private final String cardBackgroundImage;
    @NotNull
    private List<TProOnBoardingCardTagsModel> content;
    private final boolean haveMore;
    @Nullable
    private final TProOnBoardingMoreContentModel moreContent;
    @NotNull
    private final List<TProOnBoardingTitleSpanningModel> titleSpanning;
    @Nullable
    private final String topImage;
    @NotNull
    private final String trackingId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProOnBoardingDefaultCardModel(@NotNull List<TProOnBoardingCardTagsModel> list, @Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull List<TProOnBoardingTitleSpanningModel> list2, boolean z11, @Nullable TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, @NotNull String str4) {
        super(str4, str, str2, str3, list2, z11, tProOnBoardingMoreContentModel, TProOnBoardingCardType.DEFAULT, (DefaultConstructorMarker) null);
        List<TProOnBoardingCardTagsModel> list3 = list;
        String str5 = str2;
        List<TProOnBoardingTitleSpanningModel> list4 = list2;
        String str6 = str4;
        Intrinsics.checkNotNullParameter(list3, "content");
        Intrinsics.checkNotNullParameter(str5, "cardBackgroundColor");
        Intrinsics.checkNotNullParameter(list4, "titleSpanning");
        Intrinsics.checkNotNullParameter(str6, "trackingId");
        this.content = list3;
        this.topImage = str;
        this.cardBackgroundColor = str5;
        this.cardBackgroundImage = str3;
        this.titleSpanning = list4;
        this.haveMore = z11;
        this.moreContent = tProOnBoardingMoreContentModel;
        this.trackingId = str6;
    }

    public static /* synthetic */ TProOnBoardingDefaultCardModel copy$default(TProOnBoardingDefaultCardModel tProOnBoardingDefaultCardModel, List list, String str, String str2, String str3, List list2, boolean z11, TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, String str4, int i11, Object obj) {
        List list3;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            list3 = tProOnBoardingDefaultCardModel.content;
        } else {
            TProOnBoardingDefaultCardModel tProOnBoardingDefaultCardModel2 = tProOnBoardingDefaultCardModel;
            list3 = list;
        }
        return tProOnBoardingDefaultCardModel.copy(list3, (i12 & 2) != 0 ? tProOnBoardingDefaultCardModel.getTopImage() : str, (i12 & 4) != 0 ? tProOnBoardingDefaultCardModel.getCardBackgroundColor() : str2, (i12 & 8) != 0 ? tProOnBoardingDefaultCardModel.getCardBackgroundImage() : str3, (i12 & 16) != 0 ? tProOnBoardingDefaultCardModel.getTitleSpanning() : list2, (i12 & 32) != 0 ? tProOnBoardingDefaultCardModel.getHaveMore() : z11, (i12 & 64) != 0 ? tProOnBoardingDefaultCardModel.getMoreContent() : tProOnBoardingMoreContentModel, (i12 & 128) != 0 ? tProOnBoardingDefaultCardModel.getTrackingId() : str4);
    }

    @NotNull
    public final List<TProOnBoardingCardTagsModel> component1() {
        return this.content;
    }

    @Nullable
    public final String component2() {
        return getTopImage();
    }

    @NotNull
    public final String component3() {
        return getCardBackgroundColor();
    }

    @Nullable
    public final String component4() {
        return getCardBackgroundImage();
    }

    @NotNull
    public final List<TProOnBoardingTitleSpanningModel> component5() {
        return getTitleSpanning();
    }

    public final boolean component6() {
        return getHaveMore();
    }

    @Nullable
    public final TProOnBoardingMoreContentModel component7() {
        return getMoreContent();
    }

    @NotNull
    public final String component8() {
        return getTrackingId();
    }

    @NotNull
    public final TProOnBoardingDefaultCardModel copy(@NotNull List<TProOnBoardingCardTagsModel> list, @Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull List<TProOnBoardingTitleSpanningModel> list2, boolean z11, @Nullable TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(list, "content");
        Intrinsics.checkNotNullParameter(str2, "cardBackgroundColor");
        Intrinsics.checkNotNullParameter(list2, "titleSpanning");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "trackingId");
        return new TProOnBoardingDefaultCardModel(list, str, str2, str3, list2, z11, tProOnBoardingMoreContentModel, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingDefaultCardModel)) {
            return false;
        }
        TProOnBoardingDefaultCardModel tProOnBoardingDefaultCardModel = (TProOnBoardingDefaultCardModel) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) tProOnBoardingDefaultCardModel.content) && Intrinsics.areEqual((Object) getTopImage(), (Object) tProOnBoardingDefaultCardModel.getTopImage()) && Intrinsics.areEqual((Object) getCardBackgroundColor(), (Object) tProOnBoardingDefaultCardModel.getCardBackgroundColor()) && Intrinsics.areEqual((Object) getCardBackgroundImage(), (Object) tProOnBoardingDefaultCardModel.getCardBackgroundImage()) && Intrinsics.areEqual((Object) getTitleSpanning(), (Object) tProOnBoardingDefaultCardModel.getTitleSpanning()) && getHaveMore() == tProOnBoardingDefaultCardModel.getHaveMore() && Intrinsics.areEqual((Object) getMoreContent(), (Object) tProOnBoardingDefaultCardModel.getMoreContent()) && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingDefaultCardModel.getTrackingId());
    }

    @NotNull
    public String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    @Nullable
    public String getCardBackgroundImage() {
        return this.cardBackgroundImage;
    }

    @NotNull
    public final List<TProOnBoardingCardTagsModel> getContent() {
        return this.content;
    }

    public boolean getHaveMore() {
        return this.haveMore;
    }

    @Nullable
    public TProOnBoardingMoreContentModel getMoreContent() {
        return this.moreContent;
    }

    @NotNull
    public List<TProOnBoardingTitleSpanningModel> getTitleSpanning() {
        return this.titleSpanning;
    }

    @Nullable
    public String getTopImage() {
        return this.topImage;
    }

    @NotNull
    public String getTrackingId() {
        return this.trackingId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((this.content.hashCode() * 31) + (getTopImage() == null ? 0 : getTopImage().hashCode())) * 31) + getCardBackgroundColor().hashCode()) * 31) + (getCardBackgroundImage() == null ? 0 : getCardBackgroundImage().hashCode())) * 31) + getTitleSpanning().hashCode()) * 31;
        boolean haveMore2 = getHaveMore();
        if (haveMore2) {
            haveMore2 = true;
        }
        int i12 = (hashCode + (haveMore2 ? 1 : 0)) * 31;
        if (getMoreContent() != null) {
            i11 = getMoreContent().hashCode();
        }
        return ((i12 + i11) * 31) + getTrackingId().hashCode();
    }

    public final void setContent(@NotNull List<TProOnBoardingCardTagsModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.content = list;
    }

    @NotNull
    public String toString() {
        List<TProOnBoardingCardTagsModel> list = this.content;
        String topImage2 = getTopImage();
        String cardBackgroundColor2 = getCardBackgroundColor();
        String cardBackgroundImage2 = getCardBackgroundImage();
        List<TProOnBoardingTitleSpanningModel> titleSpanning2 = getTitleSpanning();
        boolean haveMore2 = getHaveMore();
        TProOnBoardingMoreContentModel moreContent2 = getMoreContent();
        String trackingId2 = getTrackingId();
        return "TProOnBoardingDefaultCardModel(content=" + list + ", topImage=" + topImage2 + ", cardBackgroundColor=" + cardBackgroundColor2 + ", cardBackgroundImage=" + cardBackgroundImage2 + ", titleSpanning=" + titleSpanning2 + ", haveMore=" + haveMore2 + ", moreContent=" + moreContent2 + ", trackingId=" + trackingId2 + ")";
    }
}
